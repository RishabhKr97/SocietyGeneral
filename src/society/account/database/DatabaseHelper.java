package society.account.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import society.account.ui.UiConstants;

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

	public boolean checkTransactionNumberValid(String transNum) {
		try (Statement statement = dbManager.executeQuery(DatabaseConstants.CHECK_TRANSACTION_NUMBER_VALID,
				new String[] { transNum }); ResultSet result = statement == null ? null : statement.getResultSet()) {
			if (result != null && result.next() && result.getInt(1) == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Map<String, String> getTransactionInfo(String transNum) {
		try (Statement statement = dbManager.executeQuery(DatabaseConstants.GET_TRANSACTION_INFO,
				new String[] { transNum }); ResultSet result = statement == null ? null : statement.getResultSet()) {
			if (result != null && result.next()) {
				Map<String, String> op = new HashMap<>();
				op.put("account_number", result.getString("account_number"));
				op.put("date_of_transaction", result.getString("date_of_transaction"));
				op.put("compulsory_deposit", result.getString("compulsory_deposit"));
				op.put("cd_fine_deposit", result.getString("cd_fine_deposit"));
				op.put("loan_installment_deposit", result.getString("loan_installment_deposit"));
				op.put("loan_interest_deposit", result.getString("loan_interest_deposit"));
				op.put("loan_fine_deposit", result.getString("loan_fine_deposit"));
				op.put("share_money_deposit", result.getString("share_money_deposit"));
				op.put("admission_fee_deposit", result.getString("admission_fee_deposit"));
				op.put("welfare_deposit", result.getString("welfare_deposit"));
				op.put("misc_deposit", result.getString("misc_deposit"));
				op.put("loan_issued", result.getString("loan_issued"));
				op.put("misc_amount_issued", result.getString("misc_amount_issued"));
				op.put("payment_mode", result.getString("payment_mode"));
				op.put("remarks", result.getString("remarks"));
				return op;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateTransaction(String accNum, String dot, String cd, String cdFine, String loanInstallment,
			String loanInst, String loanFine, String shareMoney, String admFee, String welfareDep, String miscDep,
			String loanIssue, String miscIssue, String mode, String remarks, String transactionNumber) {

		return dbManager.executeUpdate(DatabaseConstants.UPDATE_TRANSACTION_INFO,
				new String[] { accNum, dot, cd, cdFine, loanInstallment, loanInst, loanFine, shareMoney, admFee,
						welfareDep, miscDep, loanIssue, miscIssue, mode, remarks, transactionNumber });
	}

	public List<String[]> searchTransactionByDate(String accNum, String dotDate, String dotMonth, String dotYear) {
		try (Statement statement = dbManager.executeQuery(DatabaseConstants.SEARCH_TRANSACTION_BY_DATE,
				new String[] { dotDate, dotMonth, dotYear, accNum });
				ResultSet result = statement == null ? null : statement.getResultSet()) {
			if (result != null && result.next()) {
				List<String[]> op = new ArrayList<>();
				do {
					String[] curr = new String[UiConstants.TableConstants.TRANSACTION_TABLE_COLUMN_NAMES.length];
					curr[0] = result.getString("transaction_id");
					curr[1] = result.getString("account_number");
					curr[2] = result.getString("date_of_transaction");
					curr[3] = result.getString("compulsory_deposit");
					curr[4] = result.getString("cd_fine_deposit");
					curr[5] = result.getString("loan_installment_deposit");
					curr[6] = result.getString("loan_interest_deposit");
					curr[7] = result.getString("loan_fine_deposit");
					curr[8] = result.getString("share_money_deposit");
					curr[9] = result.getString("admission_fee_deposit");
					curr[10] = result.getString("welfare_deposit");
					curr[11] = result.getString("misc_deposit");
					curr[12] = result.getString("loan_issued");
					curr[13] = result.getString("misc_amount_issued");
					curr[14] = UiConstants.PaymentModeConstants.PAYMENT_MODES[result.getInt("payment_mode")];
					curr[15] = result.getString("remarks");
					op.add(curr);
				} while (result.next());
				return op;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String[]> getTransactionSummaryByDate(String dotDate, String dotMonth, String dotYear) {
		try (Statement statement = dbManager.executeQuery(DatabaseConstants.SUMMARY_TRANSACTION_BY_DATE,
				new String[] { dotDate, dotMonth, dotYear });
				ResultSet result = statement == null ? null : statement.getResultSet()) {
			if (result != null && result.next()) {
				List<String[]> op = new ArrayList<>();
				do {
					String[] curr = new String[UiConstants.TableConstants.SUMMARY_TABLE_COLUMN_NAMES.length];
					curr[0] = UiConstants.PaymentModeConstants.PAYMENT_MODES[result.getInt("payment_mode")];
					curr[1] = result.getString("mode_count");
					curr[2] = result.getString("cd");
					curr[3] = result.getString("cd_fine");
					curr[4] = result.getString("loan_installment");
					curr[5] = result.getString("loan_interest");
					curr[6] = result.getString("loan_fine");
					curr[7] = result.getString("share_money");
					curr[8] = result.getString("admission_fee");
					curr[9] = result.getString("welfare_deposit");
					curr[10] = result.getString("misc_deposit");
					curr[11] = result.getString("loan_issued");
					curr[12] = result.getString("misc_issued");
					op.add(curr);
				} while (result.next());

				int[] summation = new int[UiConstants.TableConstants.SUMMARY_TABLE_COLUMN_NAMES.length];
				for (String[] row : op) {
					for (int i = 1; i < row.length; i++) {
						summation[i] += Integer.parseInt(row[i]);
					}
				}
				op.add(Arrays.stream(summation).mapToObj(String::valueOf).toArray(String[]::new));
				op.get(op.size() - 1)[0] = "ALL";
				return op;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, String> getPendingPayments(String accNum) {
		Map<String, String> op = new HashMap<>();

		try (Statement statement = dbManager.executeQuery(DatabaseConstants.LAST_CD_DATE,
				new String[] { accNum, accNum });
				ResultSet result = statement == null ? null : statement.getResultSet()) {
			if (result != null && result.next()) {
				String lastDate = result.getString("last_date");
				if (lastDate != null) {
					LocalDate startDate = LocalDate.parse(lastDate).withDayOfMonth(1);
					LocalDate endDate = LocalDate.now().withDayOfMonth(1);
					startDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
					endDate = endDate.withDayOfMonth(1);
					if (endDate.isAfter(startDate)) {
						Period period = Period.between(startDate, endDate);
						int pendingMonths = period.getMonths();
						op.put("cd_fine", String.valueOf(5 * pendingMonths * (pendingMonths + 1)));
						pendingMonths++;
						op.put("cd_pending", String.valueOf(500 * pendingMonths));
						op.put("cd_pending_duration", String.valueOf(pendingMonths));
					} else {
						op.put("cd_fine", "0");
						op.put("cd_pending", "0");
						op.put("cd_pending_duration", "0");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Map<String, String> userBalanceValues = getUserBalanceSummary(accNum);
		if (userBalanceValues != null && Integer.parseInt(userBalanceValues.get("loan_balance")) > 0) {
			try (Statement statement = dbManager.executeQuery(DatabaseConstants.LAST_LOAN_DEPOSIT_DATE,
					new String[] { accNum, accNum });
					ResultSet result = statement == null ? null : statement.getResultSet()) {
				if (result != null && result.next()) {
					String lastDate = result.getString("last_date");
					if (lastDate != null) {
						LocalDate startDate = LocalDate.parse(lastDate);
						LocalDate endDate = LocalDate.now();
						startDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
						endDate = endDate.withDayOfMonth(1);
						if (endDate.isAfter(startDate)) {
							Period period = Period.between(startDate, endDate);
							int pendingMonths = period.getMonths();
							if (pendingMonths >= 3) {
								op.put("loan_fine", String.valueOf((pendingMonths - 2) * 50));
							} else {
								op.put("loan_fine", "0");
							}
							pendingMonths++;
							op.put("loan_interest", String.valueOf(
									Double.parseDouble(userBalanceValues.get("loan_balance")) * 0.006 * pendingMonths));
							op.put("loan_pending_duration", String.valueOf(pendingMonths));
						} else {
							op.put("loan_fine", "0");
							op.put("loan_interest", "0");
							op.put("loan_pending_duration", "0");
						}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			op.put("loan_fine", "0");
			op.put("loan_interest", "0");
			op.put("loan_pending_duration", "0");
		}

		return op.size() == 6 ? op : null;
	}

	public Map<String, List<String[]>> getAllPendingPaymentSummary() {
		Map<String, List<String[]>> op = new HashMap<>();
		op.put("pending_cd", new ArrayList<>());
		op.put("pending_loan", new ArrayList<>());

		try (Statement statement = dbManager.executeQuery(DatabaseConstants.ALL_ACTIVE_ACCOUNT_NUMBERS);
				ResultSet result = statement == null ? null : statement.getResultSet()) {
			if (result == null || !result.next()) {
				return null;
			}

			do {
				String accNum = result.getString(1);
				Map<String, String> pending = getPendingPayments(accNum);
				if (pending == null) {
					return null;
				}

				int pendingFrom = Integer.parseInt(pending.get("cd_pending_duration"));
				if (pendingFrom > 0) {
					op.get("pending_cd").add(new String[] { accNum, String.valueOf(pendingFrom - 1) });
				}

				pendingFrom = Integer.parseInt(pending.get("loan_pending_duration"));
				if (pendingFrom > 0) {
					op.get("pending_loan").add(new String[] { accNum, String.valueOf(pendingFrom - 1) });
				}
			} while (result.next());

			Collections.sort(op.get("pending_cd"), new Comparator<String[]>() {
				public int compare(String[] strings, String[] otherStrings) {
					int thisInt = Integer.parseInt(strings[1]);
					int otherInt = Integer.parseInt(otherStrings[1]);
					return Integer.compare(otherInt, thisInt);
				}
			});
			Collections.sort(op.get("pending_loan"), new Comparator<String[]>() {
				public int compare(String[] strings, String[] otherStrings) {
					int thisInt = Integer.parseInt(strings[1]);
					int otherInt = Integer.parseInt(otherStrings[1]);
					return Integer.compare(otherInt, thisInt);
				}
			});

			return op;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
