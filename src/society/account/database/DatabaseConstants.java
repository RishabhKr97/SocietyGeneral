package society.account.database;

class DatabaseConstants {
	
	public static final String CREATE_DATABASE = "CREATE DATABASE IF NOT EXISTS ";
	
	public static final String CREATE_MEMBERS_TABLE = "CREATE TABLE IF NOT EXISTS members ( "
			+ "account_number INT UNSIGNED PRIMARY KEY, "
			+ "name VARCHAR(255) NOT NULL, "
			+ "date_of_birth DATE, "
			+ "date_of_joining DATE, "
			+ "address VARCHAR(1024), "
			+ "mobile_number CHAR(10), "
			+ "email VARCHAR(255), "
			+ "account_active BOOL )";
	
	public static final String CREATE_BALANCE_TABLE = "CREATE TABLE IF NOT EXISTS balance ("
			+ "account_number INT UNSIGNED, "
			+ "share INT, "
			+ "compulsory_deposit INT, "
			+ "optional_deposit INT, "
			+ "loan INT, "
			+ "FOREIGN KEY (account_number) REFERENCES members(account_number) )";
	
	public static final String CREATE_TRANSACTIONS_TABLE = "CREATE TABLE IF NOT EXISTS transactions ("
			+ "transaction_id INT UNSIGNED PRIMARY KEY, "
			+ "account_number INT UNSIGNED, "
			+ "date_of_transaction DATE NOT NULL, "
			+ "FOREIGN KEY (account_number) REFERENCES members(account_number) )";
	
	public static final String CREATE_SHARE_TRANSACTIONS_TABLE = "CREATE TABLE IF NOT EXISTS share_transactions ("
			+ "transaction_id INT UNSIGNED, "
			+ "deposit_amount INT UNSIGNED, "
			+ "refund_amount INT UNSIGNED, "
			+ "balance INT UNSIGNED, "
			+ "FOREIGN KEY (transaction_id) REFERENCES transactions(transaction_id) )";
	
	public static final String CREATE_CD_TRANSACTIONS_TABLE = "CREATE TABLE IF NOT EXISTS compulsory_deposit_transactions ("
			+ "transaction_id INT UNSIGNED, "
			+ "deposit_amount INT UNSIGNED, "
			+ "withdrawn_amount INT UNSIGNED, "
			+ "balance INT UNSIGNED, "
			+ "FOREIGN KEY (transaction_id) REFERENCES transactions(transaction_id) )";
	
	public static final String CREATE_LOAN_TRANSACTIONS_TABLE = "CREATE TABLE IF NOT EXISTS loan_transactions ("
			+ "transaction_id INT UNSIGNED, "
			+ "advanced_amount INT UNSIGNED, "
			+ "principal_paid INT UNSIGNED, "
			+ "interest_paid INT UNSIGNED, "
			+ "balance INT UNSIGNED, "
			+ "FOREIGN KEY (transaction_id) REFERENCES transactions(transaction_id) )";
	
	public static final String ADD_MEMBER = "INSERT INTO members "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
	
	public static final String ADD_MEMBER_IN_BALANCE = "INSERT INTO balance "
			+ "VALUES (?, ?, ?, ?, ?) ";
}
