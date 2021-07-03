package society.account.ui;

import society.account.database.DatabaseHelper;

public class InputValidation {

	public static class ErrorReport {
		public boolean valid;
		public String errorMessage;
	}

	public static ErrorReport verifyMemberInfo(String accNum, String name, String address, String mobile, String email,
			String pan, String aadhar) {

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

		return verifyMemberInfo(name, address, mobile, email, pan, aadhar);
	}

	public static ErrorReport verifyMemberInfo(String name, String address, String mobile, String email, String pan,
			String aadhar) {

		ErrorReport errorReport = new ErrorReport();
		if (!name.matches("[a-zA-Z]+[\\sa-zA-Z]+")) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Name";
			return errorReport;
		}

		if (address.isEmpty()) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Address";
			return errorReport;
		}

		if (mobile.length() != 10 || !mobile.matches("[0-9]+")) {
			errorReport.valid = false;
			errorReport.errorMessage = "Invalid Mobile Number";
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

	public static ErrorReport verifyTransactionDetails(String accNum, String cd, String cdFine, String loanInstallment,
			String loanInst, String loanFine, String shareMoney, String admFee, String welfareDep, String miscDep,
			String loanIssue, String miscIssue) {

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

		try {
			if (Integer.parseInt(cd) < 0) {
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
			if (Integer.parseInt(cdFine) < 0) {
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
			if (Integer.parseInt(loanInstallment) < 0) {
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
			if (Integer.parseInt(loanInst) < 0) {
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
			if (Integer.parseInt(loanFine) < 0) {
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
			if (Integer.parseInt(shareMoney) < 0) {
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
			if (Integer.parseInt(admFee) < 0) {
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
			if (Integer.parseInt(welfareDep) < 0) {
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
			if (Integer.parseInt(miscDep) < 0) {
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
			if (Integer.parseInt(loanIssue) < 0) {
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
			if (Integer.parseInt(miscIssue) < 0) {
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
