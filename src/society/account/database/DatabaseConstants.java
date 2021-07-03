package society.account.database;

class DatabaseConstants {
		
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
			+ "compulsory_deposit INTEGER, "
			+ "cd_fine_deposit INTEGER, "
			+ "loan_installment_deposit INTEGER, "
			+ "loan_interest_deposit INTEGER, "
			+ "loan_fine_deposit INTEGER, "
			+ "share_money_deposit INTEGER, "
			+ "admission_fee_deposit INTEGER, "
			+ "welfare_deposit INTEGER, "
			+ "misc_deposit INTEGER, "
			+ "loan_issued INTEGER, "
			+ "misc_amount_issued INTEGER, "
			+ "payment_mode INTEGER, "
			+ "remarks TEXT, "
			+ "FOREIGN KEY (account_number) REFERENCES members(account_number) )";
	
	public static final String ADD_MEMBER = "INSERT INTO members "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
	
	public static final String REMOVE_MEMBER = "UPDATE members SET account_active = 0 WHERE account_number = ?";
	
	public static final String RESTORE_MEMBER = "UPDATE members SET account_active = 1 WHERE account_number = ?";
	
	public static final String ADD_TRANSACTION = "INSERT INTO transactions "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
	
	public static final String NEXT_ACCOUNT_NUMBER = "SELECT MAX(account_number) FROM members";
	
	public static final String CHECK_ACCOUNT_NUMBER_EXIST = "SELECT COUNT(*) FROM members WHERE account_number = ?";
	
	public static final String CHECK_ACCOUNT_NUMBER_ACTIVE = "SELECT COUNT(*) FROM members WHERE account_number = ? AND account_active = 1";
	
	public static final String CHECK_ACCOUNT_NUMBER_DELETED = "SELECT COUNT(*) FROM members WHERE account_number = ? AND account_active = 0";
	
	public static final String GET_USER_INFO = "SELECT * FROM members WHERE account_number = ?";
	
	public static final String UPDATE_USER_INFO = "UPDATE members SET name = ?, date_of_birth = ?, date_of_joining = ?, address = ?, "
			+ "mobile_number = ?, email_id = ?, pan_number = ?, aadhar_number = ? WHERE account_number = ?";
	
	public static final String USER_BALANCE_SUMMARY = "SELECT (SUM(loan_issued) - SUM(loan_installment_deposit)) AS loan_balance, "
			+ "SUM(compulsory_deposit) AS cd_balance, SUM(share_money_deposit) AS share_balance FROM transactions WHERE account_number = ?";
}
