package dashboard.databaseUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatabaseUtil {

	Connection connection = null;

	public DatabaseUtil() {
		connect();
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
					"jdbc:oracle:thin:@localhost:1521:XE", "dashboard",
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
			answer = getUserInfo(request);
		else if (request.matches("getGoalTypeInfo=.*"))
			answer = getGoalTypeProjects(request);
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

		int userId = 0, projectId = 0;
		String answer = "[";

		Date date;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select user_id from users where name like '"
							+ user + "'");
			while (resultSet.next()) {
				userId = Integer.parseInt(resultSet.getString(1));
				System.out.println("UserId= " + userId);
			}

			resultSet = statement
					.executeQuery("select project_id from projects where name like '"
							+ project + "'");

			while (resultSet.next()) {
				projectId = Integer.parseInt(resultSet.getString(1));
				System.out.println("ProjectId= " + projectId);
			}

			resultSet = statement
					.executeQuery("select  entry_date, amount from entries where project_id = "
							+ projectId
							+ " and owner_id = "
							+ userId
							+ "order by entry_date");

			Date prevDate = null;
			int diffInDays;
			float amount = 0, prevAmount =0;
			String dateAsString;
			float currSum = 0;
			while (resultSet.next()) {
				if (!answer.equals("["))
					answer += ",";
				
				
				
				date = resultSet.getDate(1);
				if(prevDate != null){
					diffInDays = (int) ((date.getTime() - prevDate.getTime())/(1000 * 60 * 60 * 24));
					for(int i = 0; i<diffInDays; i++){
						if(i+1!=diffInDays) answer += "['";
						System.out.println("DEBUG - counting, diff=" + diffInDays + " curr i=" + i );
						//TODO add date step	
							cal.setTime(prevDate); 
							cal.add(Calendar.DATE, 1*(i+1));
							if(i+1!=diffInDays) answer +=  simpleDateFormat.format(cal.getTime());
							if(i+1!=diffInDays) answer += "',";
						
						// add amount step
							int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
							if(dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY)
								currSum -=  4;
							if(i+1!=diffInDays) answer += currSum;
							if(i+1!=diffInDays) answer += "],";
					}
				}
				
				System.out.println("DEBUG - normal");
				//date section
					dateAsString = simpleDateFormat.format(date);
					answer += "[";
					answer += "'";
					answer += dateAsString;
					answer += "',";
				
				//amount section
					amount = resultSet.getFloat(2);
					currSum += amount;
					answer += currSum;
					answer += "]";
					
					prevDate = date;
			}
			answer += "]";

			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		System.out.println(answer);
		if (answer.equals("[]"))// empty project
			answer = "[['" + simpleDateFormat.format(new Date()) + "',0]]";

		return answer;
	}

	// TODO: close connection

	private String getUserInfo(String request) {
		String answer = null;
		String user;
		Statement statement;
		int index = request.indexOf("=");
		int userId = 0;
		int a = 0, b = 0, c = 0;
		user = request.substring(index + 1);
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select user_id from users where name like '"
							+ user + "'");
			while (resultSet.next()) {
				userId = Integer.parseInt(resultSet.getString(1));
				System.out.println("UserId= " + userId);
			}

			resultSet = statement
					.executeQuery("SELECT COUNT(1) FROM projects WHERE owner_id="
							+ userId + " AND priority like 'a'");
			while (resultSet.next()) {
				a = resultSet.getInt(1);
				System.out.println("a count= " + a);
			}

			resultSet = statement
					.executeQuery("SELECT COUNT(1) FROM projects WHERE owner_id="
							+ userId + " AND priority like 'b'");
			while (resultSet.next()) {
				b = resultSet.getInt(1);
				System.out.println("b count= " + b);
			}

			resultSet = statement
					.executeQuery("SELECT COUNT(1) FROM projects WHERE owner_id="
							+ userId + " AND priority like 'c'");
			while (resultSet.next()) {
				c = resultSet.getInt(1);
				System.out.println("c count= " + c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		answer = a + "," + b + "," + c;
		return answer;
	}

	private String getGoalTypeProjects(String request) {
		String answer = "";
		Statement statement;
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

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select user_id from users where name like '"
							+ user + "'");
			while (resultSet.next()) {
				userId = Integer.parseInt(resultSet.getString(1));
				System.out.println("UserId= " + userId);
			}

			resultSet = statement
					.executeQuery("select name from projects where owner_id = "
							+ userId);
			while (resultSet.next()) {
				projectName = resultSet.getString(1);
				if (!(answer.equals("")))
					answer += ",";
				answer += projectName;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return answer;
	}
}
