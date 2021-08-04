package society.account.ui;

import java.awt.Component;

import javax.swing.JOptionPane;

public class AlertMessages {

	public static void showErrorMessage(Component component, String message) {
		JOptionPane.showMessageDialog(component, message, "Input Error", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showAlertMessage(Component component, String message) {
		JOptionPane.showMessageDialog(component, message, "Alert", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showSystemErrorMessage(Component component) {
		JOptionPane.showMessageDialog(component, "System Error Occured. Contact Administrator.", "Error",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static int showConfirmMessage(Component component, String message) {
		return JOptionPane.showConfirmDialog(component, message);
	}

	public static int showAccountStatementPeriodDialog(Component component) {
		String[] options = new String[] { "3 Months", "6 Months", "1 Year", "All Time" };
		return JOptionPane.showOptionDialog(component, "Select Period Of Statement", "Print Account Statement",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	}
}
