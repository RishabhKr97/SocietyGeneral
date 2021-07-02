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

		if (new DatabaseHelper().checkAccountNumberExists(accNum)) {
			errorReport.valid = false;
			errorReport.errorMessage = "Account Number Already Exists!";
			return errorReport;
		}

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
}
