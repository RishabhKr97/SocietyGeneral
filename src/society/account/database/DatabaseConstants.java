package society.account.database;

class DatabaseConstants {
	
	public static final String CREATE_DATABASE = "CREATE DATABASE IF NOT EXISTS ";
	
	public static final String CREATE_MEMBERS_TABLE = "CREATE TABLE IF NOT EXISTS members ( "
			+ "account_number INTEGER PRIMARY KEY, "
			+ "name TEXT NOT NULL, "
			+ "date_of_birth DATE, "
			+ "date_of_joining DATE, "
			+ "address TEXT, "
			+ "mobile_number TEXT NOT NULL, "
			+ "email_id TEXT, "
			+ "pan_number TEXT, "
			+ "aadhar_number TEXT, "
			+ "account_active BOOLEAN )";
	
	public static final String CREATE_TRANSACTIONS_TABLE = "CREATE TABLE IF NOT EXISTS transactions ("
			+ "transaction_id INTEGER PRIMARY KEY, "
			+ "account_number INTEGER, "
			+ "date_of_transaction DATE NOT NULL, "
			+ "share_money_deposit INTEGER, "
			+ "compulsory_deposit INTEGER, "
			+ "loan_installment_deposit INTEGER, "
			+ "loan_fine_deposit INTEGER, "
			+ "cd_fine_deposit INTEGER, "
			+ "interest_deposit INTEGER, "
			+ "admission_fee_deposit INTEGER, "
			+ "welfare_deposit INTEGER, "
			+ "misc_deposit INTEGER, "
			+ "payment_mode INTEGER, "
			+ "remarks TEXT, "
			+ "FOREIGN KEY (account_number) REFERENCES members(account_number) )";
	
	public static final String ADD_MEMBER = "INSERT INTO members "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
	
	public static final String ADD_TRANSACTION = "INSERT INTO transactions "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
}
