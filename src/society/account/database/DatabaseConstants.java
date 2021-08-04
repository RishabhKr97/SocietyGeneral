package society.account.database;

class DatabaseConstants {

	public static final String CREATE_MEMBERS_TABLE = "CREATE TABLE IF NOT EXISTS members ( "
			+ "account_number INTEGER PRIMARY KEY, name TEXT NOT NULL, date_of_birth DATE, "
			+ "date_of_joining DATE, address TEXT, mobile_number TEXT NOT NULL, email_id TEXT, "
			+ "pan_number TEXT, aadhar_number TEXT, account_active BOOLEAN )";

	public static final String CREATE_TRANSACTIONS_TABLE = "CREATE TABLE IF NOT EXISTS transactions ("
			+ "transaction_id INTEGER PRIMARY KEY AUTOINCREMENT, account_number INTEGER, "
			+ "date_of_transaction DATE NOT NULL, compulsory_deposit INTEGER, cd_fine_deposit INTEGER, "
			+ "loan_installment_deposit INTEGER, loan_interest_deposit INTEGER, loan_fine_deposit INTEGER, "
			+ "share_money_deposit INTEGER, admission_fee_deposit INTEGER, welfare_deposit INTEGER, "
			+ "misc_deposit INTEGER, loan_issued INTEGER, misc_amount_issued INTEGER, "
			+ "payment_mode INTEGER, remarks TEXT, "
			+ "FOREIGN KEY (account_number) REFERENCES members(account_number) )";

	public static final String ADD_MEMBER = "INSERT INTO members " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

	public static final String REMOVE_MEMBER = "UPDATE members SET account_active = 0 WHERE account_number = ?";

	public static final String RESTORE_MEMBER = "UPDATE members SET account_active = 1 WHERE account_number = ?";

	public static final String ADD_TRANSACTION = "INSERT INTO transactions (account_number, date_of_transaction, compulsory_deposit, cd_fine_deposit, loan_installment_deposit, "
			+ "loan_interest_deposit, loan_fine_deposit, share_money_deposit, admission_fee_deposit, welfare_deposit, misc_deposit, loan_issued, misc_amount_issued, payment_mode,"
			+ "remarks) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

	public static final String GET_LAST_TRANSACTION_ID = "SELECT MAX(transaction_id) FROM transactions WHERE account_number = ?";

	public static final String NEXT_ACCOUNT_NUMBER = "SELECT MAX(account_number) FROM members";

	public static final String CHECK_ACCOUNT_NUMBER_EXIST = "SELECT COUNT(*) FROM members WHERE account_number = ?";

	public static final String CHECK_ACCOUNT_NUMBER_ACTIVE = "SELECT COUNT(*) FROM members WHERE account_number = ? AND account_active = 1";

	public static final String CHECK_ACCOUNT_NUMBER_DELETED = "SELECT COUNT(*) FROM members WHERE account_number = ? AND account_active = 0";

	public static final String GET_USER_INFO = "SELECT * FROM members WHERE account_number = ?";

	public static final String UPDATE_USER_INFO = "UPDATE members SET name = ?, date_of_birth = ?, date_of_joining = ?, address = ?, "
			+ "mobile_number = ?, email_id = ?, pan_number = ?, aadhar_number = ? WHERE account_number = ?";

	public static final String USER_BALANCE_SUMMARY = "SELECT (SUM(loan_issued) - SUM(loan_installment_deposit)) AS loan_balance, "
			+ "SUM(compulsory_deposit) AS cd_balance, SUM(share_money_deposit) AS share_balance FROM transactions WHERE account_number = ?";

	public static final String CHECK_TRANSACTION_NUMBER_VALID = "SELECT COUNT(*) FROM transactions WHERE transaction_id = ?";

	public static final String GET_TRANSACTION_INFO = "SELECT * FROM transactions WHERE transaction_id = ?";

	public static final String UPDATE_TRANSACTION_INFO = "UPDATE transactions SET account_number = ?, date_of_transaction = ?, compulsory_deposit = ?, cd_fine_deposit = ?, "
			+ "loan_installment_deposit = ?, loan_interest_deposit = ?, loan_fine_deposit = ?, share_money_deposit = ?, admission_fee_deposit = ?, welfare_deposit = ?, "
			+ "misc_deposit = ?, loan_issued = ?, misc_amount_issued = ?, payment_mode = ?, remarks = ? WHERE transaction_id = ?";

	public static final String SEARCH_TRANSACTION_BY_DATE = "SELECT * FROM transactions WHERE STRFTIME('%d', date_of_transaction) LIKE ? AND "
			+ "STRFTIME('%m', date_of_transaction) LIKE ? AND STRFTIME('%Y', date_of_transaction) LIKE ? "
			+ "AND account_number LIKE ? ORDER BY date_of_transaction DESC, transaction_id DESC";

	public static final String GET_ALL_TRANSACTIONS_BY_DATE = "SELECT * FROM transactions WHERE account_number = ? AND date_of_transaction >= ? ORDER BY date_of_transaction DESC, transaction_id DESC";

	public static final String SUMMARY_TRANSACTION_BY_DATE = "SELECT SUM(compulsory_deposit) AS cd, SUM(cd_fine_deposit) AS cd_fine, SUM(loan_installment_deposit) AS "
			+ "loan_installment, SUM(loan_interest_deposit) AS loan_interest, SUM(loan_fine_deposit) AS loan_fine, SUM(share_money_deposit) AS share_money, "
			+ "SUM(admission_fee_deposit) AS admission_fee, SUM(welfare_deposit) AS welfare_deposit, SUM(misc_deposit) AS misc_deposit, SUM(loan_issued) AS loan_issued, "
			+ "SUM(misc_amount_issued) AS misc_issued, COUNT(payment_mode) AS mode_count, payment_mode FROM transactions WHERE STRFTIME('%d', date_of_transaction) LIKE ? AND "
			+ "STRFTIME('%m', date_of_transaction) LIKE ? AND STRFTIME('%Y', date_of_transaction) LIKE ? GROUP BY payment_mode ORDER BY mode_count DESC, cd DESC";

	public static final String LAST_CD_DATE = "SELECT MAX(date) AS last_date FROM ( "
			+ "SELECT MAX(date_of_transaction) AS date FROM transactions WHERE account_number = ? AND compulsory_deposit > 0 "
			+ "UNION SELECT date_of_joining AS date FROM members WHERE account_number = ?)";

	public static final String LAST_LOAN_DEPOSIT_DATE = "SELECT MAX(date) AS last_date FROM ( "
			+ "SELECT MAX(date_of_transaction) AS date FROM transactions WHERE account_number = ? AND loan_installment_deposit > 0 "
			+ "UNION SELECT MAX(date_of_transaction) AS date FROM transactions WHERE account_number = ? AND loan_issued > 0)";

	public static final String ALL_ACTIVE_ACCOUNT_NUMBERS = "SELECT account_number from members WHERE account_active = 1";

	public static final String GET_ALL_MEMBERS = "SELECT account_number, name, account_active FROM members ORDER BY account_number";
}
