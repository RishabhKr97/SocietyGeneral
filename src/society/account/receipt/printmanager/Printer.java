package society.account.receipt.printmanager;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import society.account.database.DatabaseHelper;
import society.account.logger.Log;
import society.account.ui.AlertMessages;

public class Printer {
	private static final String TAG = "Printer";
	private static final String RECEIPT_SHEET_PATH = "receipts.xls";

	// Cell Details For Each Column Of Receipt
	private static final int TRANSACTION_NUM_ROW = 2;
	private static final int DATE_ROW = 2;
	private static final int NAME_ROW = 3;
	private static final int ACC_NUM_ROW = 3;
	private static final int CD_ROW = 4;
	private static final int FINE_ON_CD_ROW = 5;
	private static final int LOAN_INSTALLMENT_ROW = 6;
	private static final int LOAN_INTEREST_ROW = 7;
	private static final int FINE_ON_LOAN_ROW = 8;
	private static final int SHARE_MONEY_ROW = 9;
	private static final int ADM_FEE_ROW = 10;
	private static final int WELFARE_DEPOSIT_ROW = 11;
	private static final int MISC_DEPOSIT_ROW = 12;
	private static final int TOTAL_PAID_ROW = 13;
	private static final int LOAN_ISSUED_ROW = 14;
	private static final int MISC_ISSUED_ROW = 15;
	private static final int SHARE_BALANCE_ROW = 16;
	private static final int CD_BALANCE_ROW = 17;
	private static final int LOAN_BALANCE_ROW = 18;
	private static final int PRINT_FROM_ROW = 0;

	private static final int TRANSACTION_NUM_AND_NAME_COLUMN = 0;
	private static final int DEFAULT_COLUMN = 1;
	private static final int PRINT_FROM_COLUMN = 8;

	private static int mPrintFrom = 0;

	private static boolean printTransaction(String accNum, String transactionId, Component component, int numTrials) {
		Log.d(TAG, "Print: Trial: " + numTrials);

		DatabaseHelper dbHelper = new DatabaseHelper();
		Map<String, String> transactionInfo = dbHelper.getTransactionInfo(transactionId);
		Map<String, String> userInfo = dbHelper.getUserInfo(accNum);
		Map<String, String> userBalance = dbHelper.getUserBalanceSummary(accNum);

		if (transactionInfo == null || userInfo == null || userBalance == null) {
			Log.d(TAG, "Can not find all needed information");
			return false;
		}

		try (FileInputStream inputStream = new FileInputStream(new File(RECEIPT_SHEET_PATH));
				Workbook workbook = WorkbookFactory.create(inputStream)) {
			Sheet sheet = workbook.getSheetAt(0);
			Cell printFromCell = sheet.getRow(PRINT_FROM_ROW).getCell(PRINT_FROM_COLUMN);
			int printFromValue = (int) printFromCell.getNumericCellValue();
			Log.d(TAG, "Print From: " + printFromValue);
			if (printFromValue >= 7) {
				Log.d(TAG, "All receipt filled");
				AlertMessages.showAlertMessage(component, "All Receipts Filled.\nPlease Print Before Continuing.");
			}
			if (printFromValue >= 1 && printFromValue <= 6) {
				mPrintFrom = printFromValue;
			} else {
				Log.d(TAG, "Resetting print from value");
				mPrintFrom = 1;
				printFromCell.setCellValue("1");
			}

			double totalPaid = 0.0;
			double tempStore = 0.0;

			updateCellAsString(sheet, TRANSACTION_NUM_ROW, TRANSACTION_NUM_AND_NAME_COLUMN,
					"Transaction No. " + transactionId);
			updateCellAsString(sheet, NAME_ROW, TRANSACTION_NUM_AND_NAME_COLUMN, "Name: " + userInfo.get("name"));
			updateCellAsString(sheet, DATE_ROW, DEFAULT_COLUMN,
					"Date: " + getFormattedDate(transactionInfo.get("date_of_transaction")));
			updateCellAsString(sheet, ACC_NUM_ROW, DEFAULT_COLUMN, "Acc No. " + accNum);

			tempStore = Double.parseDouble(transactionInfo.get("compulsory_deposit"));
			totalPaid += tempStore;
			updateCellAsNumber(sheet, CD_ROW, DEFAULT_COLUMN, tempStore);
			tempStore = Double.parseDouble(transactionInfo.get("cd_fine_deposit"));
			totalPaid += tempStore;
			updateCellAsNumber(sheet, FINE_ON_CD_ROW, DEFAULT_COLUMN, tempStore);
			tempStore = Double.parseDouble(transactionInfo.get("loan_installment_deposit"));
			totalPaid += tempStore;
			updateCellAsNumber(sheet, LOAN_INSTALLMENT_ROW, DEFAULT_COLUMN, tempStore);
			tempStore = Double.parseDouble(transactionInfo.get("loan_interest_deposit"));
			totalPaid += tempStore;
			updateCellAsNumber(sheet, LOAN_INTEREST_ROW, DEFAULT_COLUMN, tempStore);
			tempStore = Double.parseDouble(transactionInfo.get("loan_fine_deposit"));
			totalPaid += tempStore;
			updateCellAsNumber(sheet, FINE_ON_LOAN_ROW, DEFAULT_COLUMN, tempStore);
			tempStore = Double.parseDouble(transactionInfo.get("share_money_deposit"));
			totalPaid += tempStore;
			updateCellAsNumber(sheet, SHARE_MONEY_ROW, DEFAULT_COLUMN, tempStore);
			tempStore = Double.parseDouble(transactionInfo.get("admission_fee_deposit"));
			totalPaid += tempStore;
			updateCellAsNumber(sheet, ADM_FEE_ROW, DEFAULT_COLUMN, tempStore);
			tempStore = Double.parseDouble(transactionInfo.get("welfare_deposit"));
			totalPaid += tempStore;
			updateCellAsNumber(sheet, WELFARE_DEPOSIT_ROW, DEFAULT_COLUMN, tempStore);
			tempStore = Double.parseDouble(transactionInfo.get("misc_deposit"));
			totalPaid += tempStore;
			updateCellAsNumber(sheet, MISC_DEPOSIT_ROW, DEFAULT_COLUMN, tempStore);

			updateCellAsNumber(sheet, TOTAL_PAID_ROW, DEFAULT_COLUMN, totalPaid);
			updateCellAsNumber(sheet, LOAN_ISSUED_ROW, DEFAULT_COLUMN, transactionInfo.get("loan_issued"));
			updateCellAsNumber(sheet, MISC_ISSUED_ROW, DEFAULT_COLUMN, transactionInfo.get("misc_amount_issued"));
			updateCellAsNumber(sheet, SHARE_BALANCE_ROW, DEFAULT_COLUMN, userBalance.get("share_balance"));
			updateCellAsNumber(sheet, CD_BALANCE_ROW, DEFAULT_COLUMN, userBalance.get("cd_balance"));
			updateCellAsNumber(sheet, LOAN_BALANCE_ROW, DEFAULT_COLUMN, userBalance.get("loan_balance"));

			inputStream.close();
			try (FileOutputStream outputStream = new FileOutputStream(RECEIPT_SHEET_PATH)) {
				Log.d(TAG, "Starting output stream");
				mPrintFrom += 1;
				printFromCell.setCellValue(mPrintFrom);
				workbook.write(outputStream);
				outputStream.flush();
				workbook.close();
			}
			return true;
		} catch (FileNotFoundException e) {
			Log.e(TAG, "Receipt file not found");
			if (numTrials > 2) {
				Log.e(TAG, "Trials Over. Receipt file not found");
				return false;
			}

			if (e.getMessage().contains("being used by another process")) {
				AlertMessages.showAlertMessage(component, "Please Close The Receipt Sheet Before Proceeding");
				Log.e(TAG, "Receipt fFile is being used by another process");
				return printTransaction(accNum, transactionId, component, numTrials + 1);
			}
		} catch (NumberFormatException | IOException e) {
			Log.e(TAG, "Exception Occurred.", e);
		}
		return false;
	}

	public static boolean printTransaction(String accNum, String transactionId, Component component) {
		Log.d(TAG, "Print Request: ", accNum, transactionId);
		return printTransaction(accNum, transactionId, component, 0);
	}

	private static void updateCellAsNumber(Sheet sheet, int row, int column, double data) {
		Cell cell = sheet.getRow(getAdjustedRow(row)).getCell(getAdjustedColumn(column));
		cell.setCellValue(data);
	}

	private static void updateCellAsNumber(Sheet sheet, int row, int column, String data) {
		updateCellAsNumber(sheet, row, column, Double.parseDouble(data));
	}

	private static void updateCellAsString(Sheet sheet, int row, int column, String data) {
		Cell cell = sheet.getRow(getAdjustedRow(row)).getCell(getAdjustedColumn(column));
		cell.setCellValue(data);
	}

	private static int getAdjustedRow(int row) {
		int factor = ((mPrintFrom / 2) + (mPrintFrom % 2)) - 1;
		return row + factor * 22;
	}

	private static int getAdjustedColumn(int column) {
		if (mPrintFrom % 2 == 0) {
			return column + 4;
		}
		return column;
	}

	private static String getFormattedDate(String date) {
		LocalDate localDate = LocalDate.parse(date);
		return localDate.getDayOfMonth() + "/" + localDate.getMonthValue() + "/" + (localDate.getYear() % 100);
	}

}
