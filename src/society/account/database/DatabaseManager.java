package society.account.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DatabaseManager {

	private static final String DB_URL = "jdbc:sqlite:Database/SocietyGeneral.db";
	private Connection mConnection = null;

	private DatabaseManager() {
		initializeDatabase();
	}

	private void initializeDatabase() {
		try {
			mConnection = DriverManager.getConnection(DB_URL);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// create schema
		executeQuery(DatabaseConstants.CREATE_MEMBERS_TABLE);
		executeQuery(DatabaseConstants.CREATE_TRANSACTIONS_TABLE);
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
