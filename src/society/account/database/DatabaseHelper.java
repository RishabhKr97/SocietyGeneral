package society.account.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

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

	public int removeUser(String accNum) {
		return dbManager.executeUpdate(DatabaseConstants.REMOVE_MEMBER, new String[] { accNum });
	}

	public int restoreUser(String accNum) {
		return dbManager.executeUpdate(DatabaseConstants.RESTORE_MEMBER, new String[] { accNum });
	}

	public int getNextAccountNumber() {
		try (Statement statement = dbManager.executeQuery(DatabaseConstants.NEXT_ACCOUNT_NUMBER);
				ResultSet result = statement == null ? null : statement.getResultSet()) {
			if (result != null && result.next()) {
				return result.getInt(1) + 1;
			}
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public boolean checkAccountNumberActive(String accNum) {
		try (Statement statement = dbManager.executeQuery(DatabaseConstants.CHECK_ACCOUNT_NUMBER_ACTIVE,
				new String[] { accNum }); ResultSet result = statement == null ? null : statement.getResultSet()) {
			if (result != null && result.next() && result.getInt(1) == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkAccountNumberExist(String accNum) {
		try (Statement statement = dbManager.executeQuery(DatabaseConstants.CHECK_ACCOUNT_NUMBER_EXIST,
				new String[] { accNum }); ResultSet result = statement == null ? null : statement.getResultSet()) {
			if (result != null && result.next() && result.getInt(1) == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkAccountNumberDeleted(String accNum) {
		try (Statement statement = dbManager.executeQuery(DatabaseConstants.CHECK_ACCOUNT_NUMBER_DELETED,
				new String[] { accNum }); ResultSet result = statement == null ? null : statement.getResultSet()) {
			if (result != null && result.next() && result.getInt(1) == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Map<String, String> getUserInfo(String accNum) {
		try (Statement statement = dbManager.executeQuery(DatabaseConstants.GET_USER_INFO, new String[] { accNum });
				ResultSet result = statement == null ? null : statement.getResultSet()) {
			if (result != null && result.next()) {
				Map<String, String> op = new HashMap<>();
				op.put("name", result.getString("name"));
				op.put("date_of_birth", result.getString("date_of_birth"));
				op.put("date_of_joining", result.getString("date_of_joining"));
				op.put("address", result.getString("address"));
				op.put("mobile_number", result.getString("mobile_number"));
				op.put("email_id", result.getString("email_id"));
				op.put("pan_number", result.getString("pan_number"));
				op.put("aadhar_number", result.getString("aadhar_number"));
				op.put("account_active", result.getString("account_active"));
				return op;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateUser(String accNum, String name, String dob, String doj, String address, String mobile,
			String email, String pan, String aadhar) {
		name = name.toUpperCase();
		address = address.toUpperCase();
		email = email.toUpperCase();
		pan = pan.toUpperCase();

		return dbManager.executeUpdate(DatabaseConstants.UPDATE_USER_INFO,
				new String[] { name, dob, doj, address, mobile, email, pan, aadhar, accNum });
	}

	public Map<String, String> getUserBalanceSummary(String accNum) {
		try (Statement statement = dbManager.executeQuery(DatabaseConstants.USER_BALANCE_SUMMARY,
				new String[] { accNum }); ResultSet result = statement == null ? null : statement.getResultSet()) {
			if (result != null && result.next()) {
				Map<String, String> op = new HashMap<>();
				String balance = result.getString("share_balance");
				op.put("share_balance", balance == null ? "0" : balance);
				balance = result.getString("cd_balance");
				op.put("cd_balance", balance == null ? "0" : balance);
				balance = result.getString("loan_balance");
				op.put("loan_balance", balance == null ? "0" : balance);
				return op;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int addTransaction(String accNum, String dot, String cd, String cdFine, String loanInstallment,
			String loanInst, String loanFine, String shareMoney, String admFee, String welfareDep, String miscDep,
			String loanIssue, String miscIssue, String mode, String remarks) {

		return dbManager.executeUpdate(DatabaseConstants.ADD_TRANSACTION,
				new String[] { accNum, dot, cd, cdFine, loanInstallment, loanInst, loanFine, shareMoney, admFee,
						welfareDep, miscDep, loanIssue, miscIssue, mode, remarks });
	}
}
