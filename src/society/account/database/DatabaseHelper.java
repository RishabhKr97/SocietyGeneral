package society.account.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHelper {

	private final DatabaseManager dbManager = DatabaseManager.getDatabaseManager();

	public void closeDatabase() {
		dbManager.close();
	}

	public int addUser(String accNum, String name, String dob, String doj, String address, String mobile, String email,
			String pan, String aadhar) {
		name = name.toUpperCase();
		address = address.toUpperCase();
		email = email.toUpperCase();
		pan = pan.toUpperCase();

		return dbManager.executeUpdate(DatabaseConstants.ADD_MEMBER,
				new String[] { accNum, name, dob, doj, address, mobile, email, pan, aadhar, "1" });
	}

	public int getNextAccountNumber() {
		int nextAccNum = -1;
		ResultSet result = dbManager.executeQuery(DatabaseConstants.NEXT_ACCOUNT_NUMBER);
		if (result == null) {
			return 1;
		}

		try {
			if (result.next()) {
				nextAccNum = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				result.getStatement().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return nextAccNum + 1;
	}

	public boolean checkAccountNumberExists(String accNum) {
		ResultSet result = dbManager.executeQuery(DatabaseConstants.CHECK_ACCOUNT_NUMBER_EXISTS,
				new String[] { accNum });
		if (result == null) {
			return false;
		}

		try {
			if (result.next() && result.getInt(1) > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				result.getStatement().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
