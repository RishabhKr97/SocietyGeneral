package society.account.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import society.account.logger.Log;

class DatabaseManager {

	private static final String TAG = "DatabaseManager";
	private static final String DB_URL = "jdbc:sqlite:Database/SocietyGeneral.db";
	private Connection mConnection = null;

	private DatabaseManager() {
		initializeDatabase();
	}

	private void initializeDatabase() {
		try {
			mConnection = DriverManager.getConnection(DB_URL);
		} catch (SQLException e) {
			Log.e(TAG, "Exception while connecting to DB", e);
		}

		// create schema
		executeQuery(DatabaseConstants.CREATE_MEMBERS_TABLE);
		executeQuery(DatabaseConstants.CREATE_TRANSACTIONS_TABLE);
		Log.d(TAG, "Database Initialized");
	}

	Statement executeQuery(String query) {
		Statement statement = null;
		try {
			if (mConnection.isClosed()) {
				initializeDatabase();
			}
			statement = mConnection.createStatement();
			statement.execute(query);
			return statement;
		} catch (SQLException e) {
			Log.e(TAG, "Exception while execute query: " + query, e);
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e1) {
					Log.e(TAG, "Exception: ", e1);
				}
			}
		}
		return null;
	}

	PreparedStatement executeQuery(String query, String[] params) {
		PreparedStatement statement = null;
		try {
			if (mConnection.isClosed()) {
				initializeDatabase();
			}
			statement = mConnection.prepareStatement(query);
			for (int i = 1; i <= params.length; i++) {
				statement.setString(i, params[i - 1]);
			}
			statement.execute();
			return statement;
		} catch (SQLException e) {
			Log.e(TAG, "Exception while execute query: " + query, params, e);
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e1) {
					Log.e(TAG, "Exception: ", e1);
				}
			}
		}
		return null;
	}

	int executeUpdate(String query, String[] params) {
		PreparedStatement statement = null;
		int result = 0;
		try {
			if (mConnection.isClosed()) {
				initializeDatabase();
			}
			statement = mConnection.prepareStatement(query);
			for (int i = 1; i <= params.length; i++) {
				statement.setString(i, params[i - 1]);
			}
			result = statement.executeUpdate();
		} catch (SQLException e) {
			Log.e(TAG, "Exception while execute update: " + query, params, e);
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				Log.e(TAG, "Exception: ", e);
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
			Log.e(TAG, "Exception while closing DB ", e);
		}
	}

	static DatabaseManager getDatabaseManager() {
		return Singleton.sDatabaseManager;
	}

	private static class Singleton {
		private static final DatabaseManager sDatabaseManager = new DatabaseManager();
	}
}
