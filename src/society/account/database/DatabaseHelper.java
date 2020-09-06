package society.account.database;

public class DatabaseHelper {

	private final DatabaseManager dbManager = DatabaseManager.getDatabaseManager();

	public void closeDatabase() {
		dbManager.close();
	}

	public void addUser(String accNum, String name, String dob, String doj, String address, String mobile,
			String email) {
		dbManager.executeQuery(DatabaseConstants.ADD_MEMBER,
				new String[] { accNum, name, dob, doj, address, mobile, email, "1" });
		dbManager.executeQuery(DatabaseConstants.ADD_MEMBER_IN_BALANCE, new String[] { accNum, "0", "0", "0", "0" });
	}

}
