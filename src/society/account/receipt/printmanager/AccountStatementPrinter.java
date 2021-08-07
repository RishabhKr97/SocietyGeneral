package society.account.receipt.printmanager;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import society.account.database.DatabaseHelper;
import society.account.logger.Log;
import society.account.ui.AlertMessages;
import society.account.ui.UiConstants;

public class AccountStatementPrinter {
	private static final String TAG = "StatementPrinter";
	private static final String STATEMENT_SHEET_PATH = "passbook.xls";

	// Cell Details For Each Part Of Account Statement
	private static final int STATEMENT_DATE_COLUMN = 5;
	private static final int ACC_NAME_DOJ_COLUMN = 2;
	private static final int MOB_AADHAR_PAN_COLUMN = 12;
	private static final int SHARE_BALANCE_COLUMN = 2;
	private static final int CD_BALANCE_COLUMN = 6;
	private static final int LOAN_BALANCE_COLUMN = 10;

	private static final int TRANSACTION_NUM_COLUMN = 0;
	private static final int DATE_COLUMN = 1;
	private static final int CD_COLUMN = 2;
	private static final int FINE_ON_CD_COLUMN = 3;
	private static final int LOAN_INSTALLMENT_COLUMN = 4;
	private static final int LOAN_INTEREST_COLUMN = 5;
	private static final int FINE_ON_LOAN_COLUMN = 6;
	private static final int SHARE_MONEY_COLUMN = 7;
	private static final int ADM_FEE_COLUMN = 8;
	private static final int WELFARE_DEPOSIT_COLUMN = 9;
	private static final int MISC_DEPOSIT_COLUMN = 10;
	private static final int LOAN_ISSUED_COLUMN = 11;
	private static final int MISC_ISSUED_COLUMN = 12;
	private static final int MODE_COLUMN = 13;
	private static final int REMARKS_COLUMN = 14;

	private static final int STATEMENT_DATE_ROW = 2;
	private static final int ACC_MOB_ROW = 3;
	private static final int NAME_AADHAR_ROW = 4;
	private static final int DOJ_PAN_ROW = 5;
	private static final int BALANCE_SUMMARY_ROW = 7;
	private static final int ENTRY_ROW = 10;

	private static boolean printStatement(String accNum, String fromDate, Component component, int numTrials) {
		Log.d(TAG, "Print: Trial: " + numTrials);

		DatabaseHelper dbHelper = new DatabaseHelper();
		List<String[]> userTransactions = dbHelper.getAllTransactionsByDate(accNum, fromDate);
		Map<String, String> userInfo = dbHelper.getUserInfo(accNum);
		Map<String, String> userBalance = dbHelper.getUserBalanceSummary(accNum);

		if (userInfo == null || userBalance == null) {
			Log.d(TAG, "Can not find all needed information");
			return false;
		}

		try (FileInputStream inputStream = new FileInputStream(new File(STATEMENT_SHEET_PATH));
				Workbook workbook = WorkbookFactory.create(inputStream)) {
			Sheet sheet = workbook.getSheetAt(0);

			LocalDate localFromDate = LocalDate.parse(fromDate);
			if (LocalDate.EPOCH.isEqual(localFromDate)) {
				updateCellAsString(sheet, STATEMENT_DATE_ROW, STATEMENT_DATE_COLUMN,
						"Member Passbook Till " + UiConstants.DateConstants.getCurrentDate());
			} else {
				updateCellAsString(sheet, STATEMENT_DATE_ROW, STATEMENT_DATE_COLUMN,
						"Account Statement From " + UiConstants.DateConstants.getFormattedDate(localFromDate) + " To "
								+ UiConstants.DateConstants.getCurrentDate());
			}

			updateCellAsString(sheet, ACC_MOB_ROW, ACC_NAME_DOJ_COLUMN, accNum);
			updateCellAsString(sheet, NAME_AADHAR_ROW, ACC_NAME_DOJ_COLUMN, userInfo.get("name"));
			updateCellAsString(sheet, DOJ_PAN_ROW, ACC_NAME_DOJ_COLUMN,
					UiConstants.DateConstants.getFormattedDate(userInfo.get("date_of_joining")));
			updateCellAsString(sheet, ACC_MOB_ROW, MOB_AADHAR_PAN_COLUMN, userInfo.get("mobile_number"));
			updateCellAsString(sheet, NAME_AADHAR_ROW, MOB_AADHAR_PAN_COLUMN, userInfo.get("aadhar_number"));
			updateCellAsString(sheet, DOJ_PAN_ROW, MOB_AADHAR_PAN_COLUMN, userInfo.get("pan_number"));

			updateCellAsString(sheet, BALANCE_SUMMARY_ROW, SHARE_BALANCE_COLUMN, userBalance.get("share_balance"));
			updateCellAsString(sheet, BALANCE_SUMMARY_ROW, CD_BALANCE_COLUMN, userBalance.get("cd_balance"));
			updateCellAsString(sheet, BALANCE_SUMMARY_ROW, LOAN_BALANCE_COLUMN, userBalance.get("loan_balance"));

			clearPreviousTransactionData(sheet, ENTRY_ROW);
			if (userTransactions == null || userTransactions.isEmpty()) {
				AlertMessages.showAlertMessage(component, "No Transactions Found");
				Log.d(TAG, "No transactions found");
				return false;
			}

			int currentRow = ENTRY_ROW;
			for (String[] transaction : userTransactions) {
				updateCellAsString(sheet, currentRow, TRANSACTION_NUM_COLUMN, transaction[0]);
				updateCellAsString(sheet, currentRow, DATE_COLUMN,
						UiConstants.DateConstants.getFormattedDate(transaction[2]));
				updateCellAsString(sheet, currentRow, CD_COLUMN, transaction[3]);
				updateCellAsString(sheet, currentRow, FINE_ON_CD_COLUMN, transaction[4]);
				updateCellAsString(sheet, currentRow, LOAN_INSTALLMENT_COLUMN, transaction[5]);
				updateCellAsString(sheet, currentRow, LOAN_INTEREST_COLUMN, transaction[6]);
				updateCellAsString(sheet, currentRow, FINE_ON_LOAN_COLUMN, transaction[7]);
				updateCellAsString(sheet, currentRow, SHARE_MONEY_COLUMN, transaction[8]);
				updateCellAsString(sheet, currentRow, ADM_FEE_COLUMN, transaction[9]);
				updateCellAsString(sheet, currentRow, WELFARE_DEPOSIT_COLUMN, transaction[10]);
				updateCellAsString(sheet, currentRow, MISC_DEPOSIT_COLUMN, transaction[11]);
				updateCellAsString(sheet, currentRow, LOAN_ISSUED_COLUMN, transaction[12]);
				updateCellAsString(sheet, currentRow, MISC_ISSUED_COLUMN, transaction[13]);
				updateCellAsString(sheet, currentRow, MODE_COLUMN, transaction[14]);
				updateCellAsString(sheet, currentRow, REMARKS_COLUMN, transaction[15]);
				currentRow++;
			}

			inputStream.close();
			try (FileOutputStream outputStream = new FileOutputStream(STATEMENT_SHEET_PATH)) {
				Log.d(TAG, "Starting output stream");
				workbook.write(outputStream);
				outputStream.flush();
				workbook.close();
			}
			return true;
		} catch (FileNotFoundException e) {
			Log.e(TAG, "Passbook file not found");
			if (numTrials > 2) {
				Log.e(TAG, "Trials Over. Passbook file not found");
				return false;
			}

			if (e.getMessage().contains("being used by another process")) {
				AlertMessages.showAlertMessage(component, "Please Close The Passbook Sheet Before Proceeding");
				Log.e(TAG, "Passbook file is being used by another process");
				return printStatement(accNum, fromDate, component, numTrials + 1);
			}
		} catch (NumberFormatException | IOException e) {
			Log.e(TAG, "Exception Occurred.", e);
		}
		return false;
	}

	public static boolean printStatement(String accNum, String fromDate, Component component) {
		Log.d(TAG, "Print account statement request: ", accNum, fromDate);
		return printStatement(accNum, fromDate, component, 0);
	}

	private static void clearPreviousTransactionData(Sheet sheet, int beg) {
		Row row = null;
		for (int i = beg; i < sheet.getLastRowNum(); i++) {
			row = sheet.getRow(i);
			if (row != null) {
				sheet.removeRow(row);
			}
		}
	}

	private static void updateCellAsString(Sheet sheet, int row, int column, String data) {
		if (sheet.getRow(row) == null) {
			sheet.createRow(row);
		}
		if (sheet.getRow(row).getCell(column) == null) {
			sheet.getRow(row).createCell(column, CellType.STRING);
		}
		Cell cell = sheet.getRow(row).getCell(column);
		cell.setCellValue(data);
	}
}
