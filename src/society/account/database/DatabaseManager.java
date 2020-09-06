package society.account.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DatabaseManager {

	private static final String DEFAULT_USER = "root";
	private static final String DEFAULT_PASSWORD = "password";
	private static final String DB_NAME = "SocietyGeneral";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private Connection mConnection = null;

	private DatabaseManager() {
		initializeDatabase();
	}

	private void initializeDatabase() {
		try {
			mConnection = DriverManager.getConnection(DB_URL, DEFAULT_USER, DEFAULT_PASSWORD);
			// create database
			executeQuery(DatabaseConstants.CREATE_DATABASE + DB_NAME);
			mConnection.setCatalog(DB_NAME);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// create schema
		executeQuery(DatabaseConstants.CREATE_MEMBERS_TABLE);
		executeQuery(DatabaseConstants.CREATE_BALANCE_TABLE);
		executeQuery(DatabaseConstants.CREATE_TRANSACTIONS_TABLE);
		executeQuery(DatabaseConstants.CREATE_SHARE_TRANSACTIONS_TABLE);
		executeQuery(DatabaseConstants.CREATE_CD_TRANSACTIONS_TABLE);
		executeQuery(DatabaseConstants.CREATE_LOAN_TRANSACTIONS_TABLE);
	}

	ResultSet executeQuery(String query) {
		Statement statement = null;
		ResultSet result = null;
		try {
			if (mConnection.isClosed()) {
				initializeDatabase();
			}
			statement = mConnection.createStatement();
			statement.execute(query);
			result = statement.getResultSet();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	ResultSet executeQuery(String query, String[] params) {
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			if (mConnection.isClosed()) {
				initializeDatabase();
			}
			statement = mConnection.prepareStatement(query);
			for (int i = 1; i <= params.length; i++) {
				statement.setString(i, params[i - 1]);
			}
			statement.execute();
			result = statement.getResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	void close() {
		try {
			if (mConnection != null) {
				mConnection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static DatabaseManager getDatabaseManager() {
		return Singleton.sDatabaseManager;
	}

	private static class Singleton {
		private static final DatabaseManager sDatabaseManager = new DatabaseManager();
	}
}
