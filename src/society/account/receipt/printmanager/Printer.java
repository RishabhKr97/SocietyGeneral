package society.account.receipt.printmanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import society.account.database.DatabaseHelper;

public class Printer {
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
	private static final int LOAN_ISSUED_ROW = 14;
	private static final int MISC_ISSUED_ROW = 15;
	private static final int SHARE_BALANCE_ROW = 16;
	private static final int CD_BALANCE_ROW = 17;
	private static final int LOAN_BALANCE_ROW = 18;
	private static final int PRINT_FROM_ROW = 0;

	private static final int TRANSACTION_NUM_AND_NAME_COLUMN = 0;
	private static final int DEFAULT_COLUMN = 1;
	private static final int PRINT_FROM_COLUMN = 8;

	private static final String RECEIPT_SHEET_PATH = "Receipts/receipts.xlsx";

	private static int mReceiptToAdd = 0;

	public static boolean printTransaction(String accNum, String transactionId) {
		DatabaseHelper dbHelper = new DatabaseHelper();
		Map<String, String> transactionInfo = dbHelper.getTransactionInfo(transactionId);
		Map<String, String> userInfo = dbHelper.getUserInfo(accNum);
		Map<String, String> userBalance = dbHelper.getUserBalanceSummary(accNum);

		if (transactionInfo == null || userInfo == null || userBalance == null) {
			return false;
		}

		try (FileInputStream inputStream = new FileInputStream(new File(RECEIPT_SHEET_PATH));
				Workbook workbook = WorkbookFactory.create(inputStream)) {
			Sheet sheet = workbook.getSheetAt(0);
			Cell printFromCell = sheet.getRow(PRINT_FROM_ROW).getCell(PRINT_FROM_COLUMN);
			int printFromValue = (int) printFromCell.getNumericCellValue();
			if (printFromValue >= 1 && printFromValue <= 6) {
				mReceiptToAdd = printFromValue;
			} else {
				mReceiptToAdd = 1;
				printFromCell.setCellValue("1");
			}

			updateCell(sheet, TRANSACTION_NUM_ROW, TRANSACTION_NUM_AND_NAME_COLUMN, transactionId);
			updateCell(sheet, NAME_ROW, TRANSACTION_NUM_AND_NAME_COLUMN, userInfo.get("name"));
			updateCell(sheet, DATE_ROW, DEFAULT_COLUMN, getFormattedDate(transactionInfo.get("date_of_transaction")));
			updateCell(sheet, ACC_NUM_ROW, DEFAULT_COLUMN, accNum);
			updateCell(sheet, CD_ROW, DEFAULT_COLUMN, transactionInfo.get("compulsory_deposit"));
			updateCell(sheet, FINE_ON_CD_ROW, DEFAULT_COLUMN, transactionInfo.get("cd_fine_deposit"));
			updateCell(sheet, LOAN_INSTALLMENT_ROW, DEFAULT_COLUMN, transactionInfo.get("loan_installment_deposit"));
			updateCell(sheet, LOAN_INTEREST_ROW, DEFAULT_COLUMN, transactionInfo.get("loan_interest_deposit"));
			updateCell(sheet, FINE_ON_LOAN_ROW, DEFAULT_COLUMN, transactionInfo.get("loan_fine_deposit"));
			updateCell(sheet, SHARE_MONEY_ROW, DEFAULT_COLUMN, transactionInfo.get("share_money_deposit"));
			updateCell(sheet, ADM_FEE_ROW, DEFAULT_COLUMN, transactionInfo.get("admission_fee_deposit"));
			updateCell(sheet, WELFARE_DEPOSIT_ROW, DEFAULT_COLUMN, transactionInfo.get("welfare_deposit"));
			updateCell(sheet, MISC_DEPOSIT_ROW, DEFAULT_COLUMN, transactionInfo.get("misc_deposit"));
			updateCell(sheet, LOAN_ISSUED_ROW, DEFAULT_COLUMN, transactionInfo.get("loan_issued"));
			updateCell(sheet, MISC_ISSUED_ROW, DEFAULT_COLUMN, transactionInfo.get("misc_amount_issued"));
			updateCell(sheet, SHARE_BALANCE_ROW, DEFAULT_COLUMN, userBalance.get("share_balance"));
			updateCell(sheet, CD_BALANCE_ROW, DEFAULT_COLUMN, userBalance.get("cd_balance"));
			updateCell(sheet, LOAN_BALANCE_ROW, DEFAULT_COLUMN, userBalance.get("loan_balance"));

			inputStream.close();
			try (FileOutputStream outputStream = new FileOutputStream(RECEIPT_SHEET_PATH)) {
				workbook.write(outputStream);
				workbook.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private static void updateCell(Sheet sheet, int row, int column, String data) {
		Cell cell = sheet.getRow(getAdjustedRow(row)).getCell(getAdjustedColumn(column));
		cell.setCellValue(data);
	}

	private static int getAdjustedRow(int row) {
		int factor = ((mReceiptToAdd / 2) + (mReceiptToAdd % 2)) - 1;
		return row + factor * 22;
	}

	private static int getAdjustedColumn(int column) {
		if (column % 2 == 0) {
			return column + 4;
		}
		return column;
	}

	private static String getFormattedDate(String date) {
		LocalDate localDate = LocalDate.parse(date);
		return localDate.getDayOfMonth() + "/" + localDate.getMonthValue() + "/" + localDate.getYear();
	}

}
