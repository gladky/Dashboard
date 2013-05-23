package dashboard.databaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dashboard.databaseUtil.complex_types.ProjectDataWithDateAndAmount;
import dashboard.databaseUtil.complex_types.ProjectInfoWithNameAndHPW;

public class DatabaseDataGate {

	/**
	 * Zwraca identyfikator uzytkownika na podstawie nazwy uzytkownika
	 * 
	 * @param connection
	 * @param userName
	 * @return
	 */
	public int getUserIdByName(Connection connection, String userName) {
		int userId = 0;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select user_id from users where name like '"
							+ userName + "'");
			while (resultSet.next()) {
				userId = Integer.parseInt(resultSet.getString(1));
				System.out.println("[DatabaseDataGate] User search: UserId=["
						+ userId + "] found for user name [" + userName + "]");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userId;
	}

	/**
	 * Zwraca identyfikator projektu na podstawie nazwy projektu
	 * 
	 * @param connection
	 * @param projectName
	 * @return
	 */
	public int getProjectIdByName(Connection connection, String projectName) {
		int projectId = 0;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select project_id from projects where name like '"
							+ projectName + "'");
			while (resultSet.next()) {
				projectId = Integer.parseInt(resultSet.getString(1));
				System.out
						.println("[DatabaseDataGate] Project search: ProjectId=["
								+ projectId
								+ "] found for project name ["
								+ projectName + "]");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projectId;
	}

	/**
	 * Zwraca ilosc projektów o danym priorytecie dla danego użytkownika
	 * 
	 * @param connection
	 * @param userId
	 * @param type
	 * @return
	 */
	public int getGoalCountByType(Connection connection, int userId, char type) {
		int count = 0;

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT COUNT(1) FROM projects WHERE owner_id="
							+ userId + " AND priority like '" + type + "'");
			while (resultSet.next()) {
				count = resultSet.getInt(1);
				System.out.println("[DatabaseDataGate] Project count: ["
						+ count + "] projects of type [" + type
						+ "] found for user with id=[" + userId + "]");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	public List<String> getProjectsNamesByType(Connection connection,
			int userId, char type) {
		String projectName;

		List<String> projects = new ArrayList<String>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select name from projects where owner_id = "
							+ userId + "and priority like '" + type + "'");
			while (resultSet.next()) {
				projectName = resultSet.getString(1);
				projects.add(projectName);
				System.out
						.println("[DatabaseDataGate] Project search: Project ["
								+ projectName + "] of type [" + type
								+ "] found for user with id=[" + userId + "]");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projects;
	}

	/**
	 * Dodaj wpis do bazy danych - jeśli istnieje inkrementuj
	 * @throws SQLException 
	 */
	public void addEntry(Connection connection, int projectId, float amount,
			int userId, int dateCorrection) throws SQLException {

		/** zmienne pomocnicze */
		String sqlStmt, initStmt, checkAmountStmt;
		int numberOfEntries = 0;
		float currAmount = 0F;
		int dateCorrectionMils = dateCorrection *1000*60*60*24;
		
		/** sprawdzenie czy istnieje juz wpis tego dnia dla konkretnego projektu i izutkownika*/
		initStmt = "SELECT COUNT(1) FROM entries WHERE owner_id="
				+ userId + " AND project_id =" + projectId + " AND entry_date like ?";
		PreparedStatement pInitStmt = connection.prepareStatement(initStmt);
		pInitStmt.setDate(1, new java.sql.Date((new Date()).getTime() - dateCorrectionMils));
		ResultSet resultSet = pInitStmt.executeQuery();
		while (resultSet.next()) {
			numberOfEntries = resultSet.getInt(1);
		}
		
		/** jesli nie istnieje  - dodaj nowy wpis*/
		if(numberOfEntries == 0){
			System.out.println("Dodanie");
			sqlStmt = "insert into entries (entry_id, project_id, amount, entry_date, owner_id)"
					+ "values (entries_seq.nextval,"
					+ projectId
					+ ","
					+ amount
					+ ",?," + userId + ")";
		}
		
		/** jesli istnieje wpis - etytuj (inkrementuj) wpis */
		else {
			
			/** pobrac obecna liczbe */
			checkAmountStmt = "SELECT amount FROM entries WHERE owner_id="
					+ userId + " AND project_id =" + projectId + " AND entry_date like ?";
			PreparedStatement pCheckAmountStmt = connection.prepareStatement(checkAmountStmt);
			pCheckAmountStmt.setDate(1, new java.sql.Date((new Date()).getTime()- dateCorrectionMils));
			ResultSet amountResultSet = pCheckAmountStmt.executeQuery();
			while (amountResultSet.next()) {
				currAmount = amountResultSet.getFloat(1);
			}
			
			System.out.println("Edycja");
			sqlStmt = "update entries set amount = "+ (((float)currAmount) + amount) +" where project_id = "+
					projectId+" and entry_date = ? and owner_id = "+ userId;
			}

		System.out.println(sqlStmt);
		PreparedStatement pStmt;
		try {
			pStmt = connection.prepareStatement(sqlStmt);

			pStmt.setDate(1, new java.sql.Date((new Date()).getTime()- dateCorrectionMils));
			pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ProjectInfoWithNameAndHPW getProjectInfoWithNameAndHPW(
			Connection connection, String project) {
		ProjectInfoWithNameAndHPW projectInfo = null;
		int projectId = 0;
		int hoursPerWeek = 0;
		boolean activeWeekend = false;
		try {

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select project_id, hours_per_week, active_weekend from projects where name like '"
							+ project + "'");

			while (resultSet.next()) {
				projectId = Integer.parseInt(resultSet.getString(1));
				hoursPerWeek = resultSet.getInt(2);
				activeWeekend = (resultSet.getString(3).charAt(0) == 'y' ? true : false);
				System.out.println("ProjectId= " + projectId + " hoursPerWeek "
						+ hoursPerWeek);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		projectInfo = new ProjectInfoWithNameAndHPW(projectId, hoursPerWeek, activeWeekend);
		return projectInfo;
	}

	public List<ProjectDataWithDateAndAmount> getProjectDataWithDateAndAmount(
			Connection connection, int userId, int projectId) {
		List<ProjectDataWithDateAndAmount> projectData = new ArrayList<ProjectDataWithDateAndAmount>();

		try {
			Statement statement = connection.createStatement();
			statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select  entry_date, amount from entries where project_id = "
							+ projectId
							+ " and owner_id = "
							+ userId
							+ "order by entry_date");
			
			while (resultSet.next()) {
				projectData.add(new ProjectDataWithDateAndAmount(resultSet.getDate(1), resultSet.getFloat(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return projectData;
	}
}
