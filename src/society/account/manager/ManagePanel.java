package society.account.manager;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import society.account.database.DatabaseHelper;

@SuppressWarnings("serial")
public class ManagePanel extends JPanel {

	JTabbedPane mTabs;
	AddUserPanel mAddUserPanel;
	DeleteUserPanel mDeleteUserPanel;

	ManagePanel() {
		setLayout(new BorderLayout());
		mTabs = new JTabbedPane();
		mAddUserPanel = new AddUserPanel();
		mDeleteUserPanel = new DeleteUserPanel();

		mTabs.setSize(600, 600);
		mTabs.add("add new user", mAddUserPanel);
		mTabs.add("delete user", mDeleteUserPanel);
		add(mTabs);
	}

	private class AddUserPanel extends JPanel implements ActionListener {

		private JLabel mAccountNumberLabel;
		private JTextField mAccountNumberValue;
		private JLabel mNameLabel;
		private JTextField mNameValue;
		private JLabel mDobLabel;
		private JComboBox<String> mDobDate;
		private JComboBox<String> mDobMonth;
		private JComboBox<String> mDobYear;
		private JLabel mDojLabel;
		private JComboBox<String> mDojDate;
		private JComboBox<String> mDojMonth;
		private JComboBox<String> mDojYear;
		private JLabel mAddressLabel;
		private JTextArea mAddressValue;
		private JScrollPane mAddressScroll;
		private JLabel mMobileLabel;
		private JTextField mMobileValue;
		private JLabel mEmailLabel;
		private JTextField mEmailValue;
		private JButton mSubmit;
		private JButton mClear;
		private final DatabaseHelper dbHelper = null;// new DatabaseHelper();

		AddUserPanel() {
			setLayout(null);

			mAccountNumberLabel = new JLabel("Account Number");
			mAccountNumberLabel.setSize(180, 20);
			mAccountNumberLabel.setLocation(5, 10);
			add(mAccountNumberLabel);

			mAccountNumberValue = new JTextField();
			mAccountNumberValue.setSize(180, 20);
			mAccountNumberValue.setLocation(200, 10);
			add(mAccountNumberValue);

			mNameLabel = new JLabel("Name");
			mNameLabel.setSize(180, 20);
			mNameLabel.setLocation(5, 40);
			add(mNameLabel);

			mNameValue = new JTextField();
			mNameValue.setSize(180, 20);
			mNameValue.setLocation(200, 40);
			add(mNameValue);

			mDobLabel = new JLabel("Date of Birth");
			mDobLabel.setSize(180, 20);
			mDobLabel.setLocation(5, 70);
			add(mDobLabel);

			mDobDate = new JComboBox<>(DateConstants.DATES);
			mDobDate.setSize(52, 20);
			mDobDate.setLocation(200, 70);
			add(mDobDate);

			mDobMonth = new JComboBox<>(DateConstants.MONTHS);
			mDobMonth.setSize(52, 20);
			mDobMonth.setLocation(264, 70);
			add(mDobMonth);

			mDobYear = new JComboBox<>(DateConstants.YEARS);
			mDobYear.setSize(52, 20);
			mDobYear.setLocation(328, 70);
			add(mDobYear);

			mDojLabel = new JLabel("Date of Joining");
			mDojLabel.setSize(180, 20);
			mDojLabel.setLocation(5, 100);
			add(mDojLabel);

			mDojDate = new JComboBox<>(DateConstants.DATES);
			mDojDate.setSize(52, 20);
			mDojDate.setLocation(200, 100);
			mDojDate.setSelectedIndex(DateConstants.getCurrentDateIdx());
			add(mDojDate);

			mDojMonth = new JComboBox<>(DateConstants.MONTHS);
			mDojMonth.setSize(52, 20);
			mDojMonth.setLocation(264, 100);
			mDojMonth.setSelectedIndex(DateConstants.getCurrentMonthIdx());
			add(mDojMonth);

			mDojYear = new JComboBox<>(DateConstants.YEARS);
			mDojYear.setSize(52, 20);
			mDojYear.setLocation(328, 100);
			mDojYear.setSelectedIndex(DateConstants.getCurrentYearIdx());
			add(mDojYear);

			mAddressLabel = new JLabel("Address");
			mAddressLabel.setSize(180, 20);
			mAddressLabel.setLocation(5, 130);
			add(mAddressLabel);

			mAddressValue = new JTextArea();
			mAddressValue.setLineWrap(true);
			mAddressScroll = new JScrollPane(mAddressValue);
			mAddressScroll.setSize(180, 60);
			mAddressScroll.setLocation(200, 130);
			add(mAddressScroll);

			mMobileLabel = new JLabel("Mobile Number");
			mMobileLabel.setSize(180, 20);
			mMobileLabel.setLocation(5, 200);
			add(mMobileLabel);

			mMobileValue = new JTextField();
			mMobileValue.setSize(180, 20);
			mMobileValue.setLocation(200, 200);
			add(mMobileValue);

			mEmailLabel = new JLabel("Email Id");
			mEmailLabel.setSize(180, 20);
			mEmailLabel.setLocation(5, 230);
			add(mEmailLabel);

			mEmailValue = new JTextField();
			mEmailValue.setSize(180, 20);
			mEmailValue.setLocation(200, 230);
			add(mEmailValue);

			mSubmit = new JButton("Submit");
			mSubmit.setSize(80, 20);
			mSubmit.setLocation(100, 280);
			mSubmit.addActionListener(this);
			add(mSubmit);

			mClear = new JButton("Clear");
			mClear.setSize(80, 20);
			mClear.setLocation(205, 280);
			mClear.addActionListener(this);
			add(mClear);
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == mSubmit) {
				String accountNumber = mAccountNumberValue.getText().trim();
				String name = mNameValue.getText().trim();
				String dobDate = (String) mDobDate.getSelectedItem();
				String dobMonth = (String) mDobMonth.getSelectedItem();
				String dobYear = (String) mDobYear.getSelectedItem();
				String dojDate = (String) mDojDate.getSelectedItem();
				String dojMonth = (String) mDojMonth.getSelectedItem();
				String dojYear = (String) mDojYear.getSelectedItem();
				String address = mAddressValue.getText().trim();
				String mobile = mMobileValue.getText().trim();
				String email = mEmailValue.getText().trim();

				if (!verifyInput(accountNumber, name, mobile, email)) {
					return;
				}

				dbHelper.addUser(accountNumber, name, dobYear + "-" + dobMonth + "-" + dobDate,
						dojYear + "-" + dojMonth + "-" + dojDate, address, mobile, email);

			} else if (e.getSource() == mClear) {
				mAccountNumberValue.setText("");
				mNameValue.setText("");
				mDobDate.setSelectedIndex(0);
				mDobMonth.setSelectedIndex(0);
				mDobYear.setSelectedIndex(0);
				mDojDate.setSelectedIndex(DateConstants.getCurrentDateIdx());
				mDojMonth.setSelectedIndex(DateConstants.getCurrentMonthIdx());
				mDojYear.setSelectedIndex(DateConstants.getCurrentYearIdx());
				mAddressValue.setText("");
				mMobileValue.setText("");
				mEmailValue.setText("");
			}
		}

		private boolean verifyInput(String accNum, String name, String mobile, String email) {
			try {
				if (Integer.parseInt(accNum) <= 0) {
					mAccountNumberValue.setText("Invalid Account Number");
					return false;
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				return false;
			}

			if (!name.matches("[\\sa-zA-Z]+")) {
				mNameValue.setText("Invalid Name");
				return false;
			}

			if (mobile.length() != 10 || !mobile.matches("[0-9]+")) {
				mMobileValue.setText("Invalid Mobile Number");
				return false;
			}

			if (!email.equals("") && !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
				System.out.println(email);
				mEmailValue.setText("Invalid Email Id");
				return false;
			}

			return true;
		}

	}

	private class DeleteUserPanel extends JPanel implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
