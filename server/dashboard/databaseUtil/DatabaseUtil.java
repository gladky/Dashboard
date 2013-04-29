package dashboard.databaseUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dashboard.databaseUtil.complex_types.ProjectDataWithDateAndAmount;
import dashboard.databaseUtil.complex_types.ProjectInfoWithNameAndHPW;

public class DatabaseUtil {

	Connection connection = null;
	DatabaseDataGate databaseDG;

	public DatabaseUtil() {
		connect();
		databaseDG = new DatabaseDataGate();

	}

	public void connect() {
		System.out.println("-------- Oracle JDBC Connection Testing ------");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;
		}
		System.out.println("Oracle JDBC Driver Registered!");
		try {
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/XE", "dashboard",
					"dashboard");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}

	public String getAnswer(String request) {
		String answer = null;
		if (request.matches(".*#.*"))
			answer = getChart(request);
		else if (request.matches("getUserInfo=.*"))
			answer = getUserProjectsInfo(request);
		else if (request.matches("getGoalTypeInfo=.*"))
			answer = getGoalTypeProjects(request);
		else if (request.matches("addEntry=.*"))
			answer = addEntry(request);
		return answer;
	}

	private String getChart(String request) {
		Statement statement;
		int index = request.indexOf("#");
		String user;
		String project;
		user = request.substring(0, index);
		project = request.substring(index + 1);

		System.out.println("Requested user= " + user + ", project= " + project);

		int userId = 0, projectId = 0, hoursPerWeek = 0;
		String answer = "[";

		Date date;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();

		userId = databaseDG.getUserIdByName(connection, user);
		ProjectInfoWithNameAndHPW projectInfo = databaseDG
				.getProjectInfoWithNameAndHPW(connection, project);

		projectId = projectInfo.projectId;
		hoursPerWeek = projectInfo.HPW;

		List<ProjectDataWithDateAndAmount> projectData = databaseDG
				.getProjectDataWithDateAndAmount(connection, userId, projectId);

		Date prevDate = null;
		int diffInDays;
		float amount = 0;
		String dateAsString;
		float currSum = 0;

		for (int p = 0; p < projectData.size(); p++) {
			if (!answer.equals("["))
				answer += ",";

			date = projectData.get(p).date;
			if (prevDate != null) {
				diffInDays = (int) ((date.getTime() - prevDate.getTime()) / (1000 * 60 * 60 * 24));
				for (int i = 0; i < diffInDays; i++) {
					
					System.out.println("DEBUG - counting, diff=" + diffInDays
							+ " curr i=" + i);
					// TODO add date step
					cal.setTime(prevDate);
					cal.add(Calendar.DATE, 1 * (i + 1));
					 	

					// add amount step
					int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
					if (dayOfWeek != Calendar.SATURDAY
							&& dayOfWeek != Calendar.SUNDAY)
						currSum -= ((float) hoursPerWeek) / 5;
					
				}
			}

			System.out.println("DEBUG - normal");
			// date section
			dateAsString = simpleDateFormat.format(date);
			answer += "[";
			answer += "'";
			answer += dateAsString;
			answer += "',";

			// amount section
			amount = projectData.get(p).amount;
			currSum += amount;
			answer += currSum;
			answer += "]";

			prevDate = date;
		}
		answer = putToday(answer, prevDate, currSum, hoursPerWeek, simpleDateFormat);
		answer += "]";

		System.out.println("For project [" + project + "] answer is ["+answer + "]");
		if (answer.equals("[]"))// empty project
			answer = "[['" + simpleDateFormat.format(new Date()) + "',0]]";

		return answer;
	}
	
	/**
	 * @param currentAnswer
	 * @param lastDate
	 * @param currSum
	 * @param hoursPerWeek
	 * @param sdf
	 * @return
	 */
	private String putToday(String currentAnswer, Date lastDate, float currSum,
			int hoursPerWeek, SimpleDateFormat sdf) {
		if(lastDate == null) return currentAnswer;
		
		
		/**
		 * jesli od lastDate minal przynajmniej jeden dzien dodaj sztuczny
		 * element
		 */
		Date today = new Date();
		long diffInDays = (today.getTime() - lastDate.getTime())
				/ (1000 * 60 * 60 * 24);
	
		/**
		 * zmienna określająca aktualne zaległości w zależności od ostatniej
		 * aktywności
		 */
		float arrears = 0;

		/**
		 * stworzenie obiektu kalendarza umożliwiającego określenanie dni
		 * tygodnia
		 */
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(lastDate);

		/** przechodź po każdym dniu od ostatniego wpisu do dzisiejszego dnia */
		for (int i = 0; i < diffInDays; i++) {

			/** sprawdź jaki to dzień tygodnia */
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

			/** jeśli dzień tygodnia inny niż weekend */
			if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
				/** dodaj do zaległości ilość pracy na dzień */
				arrears += ((float) hoursPerWeek / 5F);
			}

			/** przejdź do kolejnego dnia w zależności od iteratora */
			cal.add(Calendar.DATE, 1 * (i + 1));
		}
		
		
		
		
		System.out.println("Last -> today: diff=" +diffInDays+ " substract " + arrears);
		
		if (diffInDays >= 1L) {
			currentAnswer += ",['" + sdf.format(today) + "',"
					+ (currSum - arrears)
					+ "]";
		}

		return currentAnswer;
	}

	/**
	 * Metoda zwracająca odpowiedz na zapytanie o projekty uzytkownika
	 * 
	 * @param request
	 * @return
	 */
	private String getUserProjectsInfo(String request) {
		String answer = null;
		String user;
		int index = request.indexOf("=");
		int userId = 0;
		int a = 0, b = 0, c = 0;
		user = request.substring(index + 1);

		userId = databaseDG.getUserIdByName(connection, user);

		a = databaseDG.getGoalCountByType(connection, userId, 'a');
		b = databaseDG.getGoalCountByType(connection, userId, 'b');
		c = databaseDG.getGoalCountByType(connection, userId, 'c');

		answer = a + "," + b + "," + c;

		return answer;
	}

	/**
	 * Metoda zwracająca odpowiedz na zapytanie o projekty o danym typie
	 * 
	 * @param request
	 * @return
	 */
	private String getGoalTypeProjects(String request) {
		String answer = "";
		String projectName;
		String user;
		String type;

		int userId = 0;
		int index = request.indexOf("=");
		int index2 = request.indexOf("^");

		user = request.substring(index + 1, index2);
		type = request.substring(index2 + 1);
		System.out.println("requested projects for user " + user + " of type "
				+ type + ".");

		userId = databaseDG.getUserIdByName(connection, user);

		List<String> projects = new ArrayList<String>();

		projects = databaseDG.getProjectsNamesByType(connection, userId,
				type.charAt(0)); // TODO konieczna konwersja ze string do char
									// ze wzgledu na BLEDNY typ zmiennej
									// type(String) powinna byc (Char)

		for (int i = 0; i < projects.size(); i++) {
			projectName = projects.get(i);
			if (!(answer.equals("")))
				answer += ",";
			answer += projectName;
		}
		return answer;
	}

	private String addEntry(String request) {
		String answer = "";
		String user;
		String project;
		String amount;

		int userId = 0;
		int projectId = 0;

		int index = request.indexOf("=");
		int index2 = request.indexOf("@");
		int index3 = request.indexOf("$");

		user = request.substring(index + 1, index2);
		project = request.substring(index2 + 1, index3);
		amount = request.substring(index3 + 1);

		System.out.println("Added entry for user " + user + " to project "
				+ project + " and amount " + amount);

		userId = databaseDG.getUserIdByName(connection, user);
		projectId = databaseDG.getProjectIdByName(connection, project);

		databaseDG.addEntry(connection, projectId, Integer.parseInt(amount),
				userId);

		return answer;
	}
}
