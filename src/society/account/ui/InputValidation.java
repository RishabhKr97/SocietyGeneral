package society.account.ui;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import society.account.database.DatabaseHelper;

public class InputValidation {

	public static class ErrorReport {
		public boolean valid;
		public String errorMessage;
	}

	public static ErrorReport verifyMemberInfo(String accNum, String name, String dob, String doj, String address,
			String mobile, String email, String pan, String aadhar) {

		ErrorReport errorReport = new ErrorReport();
		try {
			if (Integer.parseInt(accNum) <= 0) {
				errorReport.valid = false;
				errorReport.errorMessage = "Invalid Account Number";

				return errorReport;
			}
		} catch (NumberFormatException e) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Account Number";
			return errorReport;
		}

		if (new DatabaseHelper().checkAccountNumberExist(accNum)) {
			errorReport.valid = false;
			errorReport.errorMessage = "Account Number Already Exists!";
			return errorReport;
		}

		return verifyMemberInfo(name, dob, doj, address, mobile, email, pan, aadhar);
	}

	public static ErrorReport verifyMemberInfo(String name, String dob, String doj, String address, String mobile,
			String email, String pan, String aadhar) {

		ErrorReport errorReport = new ErrorReport();
		if (!name.matches("[a-zA-Z][\\sa-zA-Z]+")) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Name";
			return errorReport;
		}

		try {
			LocalDate.parse(dob);
		} catch (DateTimeParseException e) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Date of Birth";
			return errorReport;
		}

		try {
			LocalDate.parse(doj);
		} catch (DateTimeParseException e) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Date of Joining";
			return errorReport;
		}

		if (address.isEmpty()) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Address";
			return errorReport;
		}

		if (mobile.length() != 10 || !mobile.matches("[0-9]+")) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Mobile Number.\nEnter 10 digits without country code.";
			return errorReport;
		}

		if (!email.isEmpty() && !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Email Id";
			return errorReport;
		}

		if (pan.length() != 10) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid PAN Number";
			return errorReport;
		}

		if (aadhar.length() != 12 || !aadhar.matches("[0-9]+")) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Aadhar Number";
			return errorReport;
		}

		errorReport.valid = true;
		return errorReport;
	}

	public static ErrorReport verifyTransactionDetails(String accNum, String dot, String cd, String cdFine,
			String loanInstallment, String loanInst, String loanFine, String shareMoney, String admFee,
			String welfareDep, String miscDep, String loanIssue, String miscIssue) {

		ErrorReport errorReport = new ErrorReport();
		try {
			if (Integer.parseInt(accNum) <= 0) {
				errorReport.valid = false;
				errorReport.errorMessage = "Invalid Account Number";
				return errorReport;
			}
		} catch (NumberFormatException e) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Account Number";
			return errorReport;
		}

		LocalDate localDot = null;
		try {
			localDot = LocalDate.parse(dot);
		} catch (DateTimeParseException e) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Date of Transaction";
			return errorReport;
		}

		LocalDate localDoj = null;
		String doj = new DatabaseHelper().getUserDoj(accNum);
		if (doj == null) {
			errorReport.valid = false;
			errorReport.errorMessage = "Can not determine user. Restart Application Or Contact Administrator.";
			return errorReport;
		}
		localDoj = LocalDate.parse(doj);
		if (localDoj.isAfter(localDot)) {
			errorReport.valid = false;
			errorReport.errorMessage = "Transaction Date Can Not Be Before Joining Date ("
					+ UiConstants.DateConstants.getFormattedDate(localDoj) + ")";
			return errorReport;
		}

		if (!new DatabaseHelper().checkAccountNumberActive(accNum)) {
			errorReport.valid = false;
			errorReport.errorMessage = "Account Number Does Not Exists!";
			return errorReport;
		}

		try {
			if (Double.parseDouble(cd) < 0) {
				errorReport.valid = false;
				errorReport.errorMessage = "Invalid CD Value";
				return errorReport;
			}
		} catch (NumberFormatException e) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid CD Value";
			return errorReport;
		}

		try {
			if (Double.parseDouble(cdFine) < 0) {
				errorReport.valid = false;
				errorReport.errorMessage = "Invalid CD Fine Value";
				return errorReport;
			}
		} catch (NumberFormatException e) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid CD Fine Value";
			return errorReport;
		}

		try {
			if (Double.parseDouble(loanInstallment) < 0) {
				errorReport.valid = false;
				errorReport.errorMessage = "Invalid Loan Installment Value";
				return errorReport;
			}
		} catch (NumberFormatException e) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Loan Installment Value";
			return errorReport;
		}

		try {
			if (Double.parseDouble(loanInst) < 0) {
				errorReport.valid = false;
				errorReport.errorMessage = "Invalid Loan Interest Value";
				return errorReport;
			}
		} catch (NumberFormatException e) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Loan Interest Value";
			return errorReport;
		}

		try {
			if (Double.parseDouble(loanFine) < 0) {
				errorReport.valid = false;
				errorReport.errorMessage = "Invalid Loan Fine Value";
				return errorReport;
			}
		} catch (NumberFormatException e) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Loan Fine Value";
			return errorReport;
		}

		try {
			if (Double.parseDouble(shareMoney) < 0) {
				errorReport.valid = false;
				errorReport.errorMessage = "Invalid Share Money Value";
				return errorReport;
			}
		} catch (NumberFormatException e) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Share Money Value";
			return errorReport;
		}

		try {
			if (Double.parseDouble(admFee) < 0) {
				errorReport.valid = false;
				errorReport.errorMessage = "Invalid Admission Fee Value";
				return errorReport;
			}
		} catch (NumberFormatException e) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Admission Fee Value";
			return errorReport;
		}

		try {
			if (Double.parseDouble(welfareDep) < 0) {
				errorReport.valid = false;
				errorReport.errorMessage = "Invalid Welfare Deposit Value";
				return errorReport;
			}
		} catch (NumberFormatException e) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Welfare Deposit Value";
			return errorReport;
		}

		try {
			if (Double.parseDouble(miscDep) < 0) {
				errorReport.valid = false;
				errorReport.errorMessage = "Invalid Misc Deposit Value";
				return errorReport;
			}
		} catch (NumberFormatException e) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Misc Deposit Value";
			return errorReport;
		}

		try {
			if (Double.parseDouble(loanIssue) < 0) {
				errorReport.valid = false;
				errorReport.errorMessage = "Invalid Loan Issued Value";
				return errorReport;
			}
		} catch (NumberFormatException e) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Loan Issued Value";
			return errorReport;
		}

		try {
			if (Double.parseDouble(miscIssue) < 0) {
				errorReport.valid = false;
				errorReport.errorMessage = "Invalid Misc Amount Issued Value";
				return errorReport;
			}
		} catch (NumberFormatException e) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Misc Amount Issued Value";
			return errorReport;
		}

		errorReport.valid = true;
		return errorReport;
	}
}
