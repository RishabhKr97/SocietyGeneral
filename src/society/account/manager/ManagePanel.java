package society.account.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	DeleteRestoreUserPanel mDeleteRestoreUserPanel;
	EditUserPanel mEditUserPanel;

	ManagePanel() {
		setLayout(new BorderLayout());
		mTabs = new JTabbedPane();
		mAddUserPanel = new AddUserPanel();
		mDeleteRestoreUserPanel = new DeleteRestoreUserPanel();
		mEditUserPanel = new EditUserPanel();

		mTabs.setSize(600, 600);
		mTabs.add("add new member", mAddUserPanel);
		mTabs.add("remove or restore member", mDeleteRestoreUserPanel);
		mTabs.add("edit member details", mEditUserPanel);
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
		private JLabel mPanLabel;
		private JTextField mPanValue;
		private JLabel mAadharLabel;
		private JTextField mAadharValue;
		private JButton mSubmit;
		private JButton mClear;
		private final DatabaseHelper dbHelper = new DatabaseHelper();

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

			mPanLabel = new JLabel("PAN Number");
			mPanLabel.setSize(180, 20);
			mPanLabel.setLocation(5, 260);
			add(mPanLabel);

			mPanValue = new JTextField();
			mPanValue.setSize(180, 20);
			mPanValue.setLocation(200, 260);
			add(mPanValue);

			mAadharLabel = new JLabel("Aadhar Number");
			mAadharLabel.setSize(180, 20);
			mAadharLabel.setLocation(5, 290);
			add(mAadharLabel);

			mAadharValue = new JTextField();
			mAadharValue.setSize(180, 20);
			mAadharValue.setLocation(200, 290);
			add(mAadharValue);

			mSubmit = new JButton("Submit");
			mSubmit.setSize(80, 20);
			mSubmit.setLocation(100, 340);
			mSubmit.addActionListener(this);
			add(mSubmit);

			mClear = new JButton("Clear");
			mClear.setSize(80, 20);
			mClear.setLocation(205, 340);
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
				String pan = mPanValue.getText().trim();
				String aadhar = mAadharValue.getText().trim();

				if (!verifyInput(accountNumber, name, mobile, email, pan, aadhar)) {
					return;
				}

				dbHelper.addUser(accountNumber, name, dobYear + "-" + dobMonth + "-" + dobDate,
						dojYear + "-" + dojMonth + "-" + dojDate, address, mobile, email, "pan", "aadhar");

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
				mPanValue.setText("");
				mAadharValue.setText("");
			}
		}

		private boolean verifyInput(String accNum, String name, String mobile, String email, String pan,
				String aadhar) {
			try {
				if (Integer.parseInt(accNum) <= 0) {
					mAccountNumberValue.setText("Invalid Account Number");
					return false;
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				mAccountNumberValue.setText("Invalid Account Number");
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

			if (pan.length() != 10) {
				mPanValue.setText("Invalid PAN Number");
				return false;
			}

			if (aadhar.length() != 12) {
				mAadharValue.setText("Invalid Aadhar Number");
				return false;
			}

			return true;
		}
	}

	private class DeleteRestoreUserPanel extends JPanel implements ActionListener {

		private JLabel mRemoveMemberLabel;
		private JTextField mRemoveAccountNumber;
		private JButton mRemoveMemberSubmit;
		private JLabel mRestoreMemberLabel;
		private JTextField mRestoreAccountNumber;
		private JButton mRestoreMemberSubmit;
		private JLabel mStatusLabel;

		public DeleteRestoreUserPanel() {
			setLayout(null);

			mRemoveMemberLabel = new JLabel("Remove Member");
			mRemoveMemberLabel.setSize(180, 20);
			mRemoveMemberLabel.setLocation(5, 10);
			add(mRemoveMemberLabel);

			mRemoveAccountNumber = new JTextField();
			mRemoveAccountNumber.setSize(180, 20);
			mRemoveAccountNumber.setLocation(200, 10);
			add(mRemoveAccountNumber);

			mRemoveMemberSubmit = new JButton("Submit");
			mRemoveMemberSubmit.setSize(80, 20);
			mRemoveMemberSubmit.setLocation(400, 10);
			mRemoveMemberSubmit.addActionListener(this);
			add(mRemoveMemberSubmit);

			mRestoreMemberLabel = new JLabel("Restore Member");
			mRestoreMemberLabel.setSize(180, 20);
			mRestoreMemberLabel.setLocation(5, 40);
			add(mRestoreMemberLabel);

			mRestoreAccountNumber = new JTextField();
			mRestoreAccountNumber.setSize(180, 20);
			mRestoreAccountNumber.setLocation(200, 40);
			add(mRestoreAccountNumber);

			mRestoreMemberSubmit = new JButton("Submit");
			mRestoreMemberSubmit.setSize(80, 20);
			mRestoreMemberSubmit.setLocation(400, 40);
			mRestoreMemberSubmit.addActionListener(this);
			add(mRestoreMemberSubmit);

			mStatusLabel = new JLabel("Member Deleted Successfully!");
			mStatusLabel.setSize(180, 20);
			mStatusLabel.setLocation(150, 90);
			mStatusLabel.setForeground(Color.GREEN);
			add(mStatusLabel);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	}

	private class EditUserPanel extends JPanel implements ActionListener {
		private JTextField mSearchAccountNumber;
		private JButton mSearchAccountNumberSubmit;
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
		private JLabel mPanLabel;
		private JTextField mPanValue;
		private JLabel mAadharLabel;
		private JTextField mAadharValue;
		private JButton mSubmit;

		public EditUserPanel() {
			setLayout(null);

			mSearchAccountNumber = new JTextField();
			mSearchAccountNumber.setText(" ENTER ACCOUNT NUMBER");
			mSearchAccountNumber.setSize(180, 20);
			mSearchAccountNumber.setLocation(5, 5);
			mSearchAccountNumber.addMouseListener(new AccountMouseListner());
			add(mSearchAccountNumber);

			mSearchAccountNumberSubmit = new JButton("Find");
			mSearchAccountNumberSubmit.setSize(80, 20);
			mSearchAccountNumberSubmit.setLocation(200, 5);
			mSearchAccountNumberSubmit.addActionListener(this);
			add(mSearchAccountNumberSubmit);

			mAccountNumberLabel = new JLabel("Account Number");
			mAccountNumberLabel.setSize(180, 20);
			mAccountNumberLabel.setLocation(5, 60);
			add(mAccountNumberLabel);

			mAccountNumberValue = new JTextField();
			mAccountNumberValue.setSize(180, 20);
			mAccountNumberValue.setLocation(200, 60);
			add(mAccountNumberValue);

			mNameLabel = new JLabel("Name");
			mNameLabel.setSize(180, 20);
			mNameLabel.setLocation(5, 90);
			add(mNameLabel);

			mNameValue = new JTextField();
			mNameValue.setSize(180, 20);
			mNameValue.setLocation(200, 90);
			add(mNameValue);

			mDobLabel = new JLabel("Date of Birth");
			mDobLabel.setSize(180, 20);
			mDobLabel.setLocation(5, 120);
			add(mDobLabel);

			mDobDate = new JComboBox<>(DateConstants.DATES);
			mDobDate.setSize(52, 20);
			mDobDate.setLocation(200, 120);
			add(mDobDate);

			mDobMonth = new JComboBox<>(DateConstants.MONTHS);
			mDobMonth.setSize(52, 20);
			mDobMonth.setLocation(264, 120);
			add(mDobMonth);

			mDobYear = new JComboBox<>(DateConstants.YEARS);
			mDobYear.setSize(52, 20);
			mDobYear.setLocation(328, 120);
			add(mDobYear);

			mDojLabel = new JLabel("Date of Joining");
			mDojLabel.setSize(180, 20);
			mDojLabel.setLocation(5, 150);
			add(mDojLabel);

			mDojDate = new JComboBox<>(DateConstants.DATES);
			mDojDate.setSize(52, 20);
			mDojDate.setLocation(200, 150);
			mDojDate.setSelectedIndex(DateConstants.getCurrentDateIdx());
			add(mDojDate);

			mDojMonth = new JComboBox<>(DateConstants.MONTHS);
			mDojMonth.setSize(52, 20);
			mDojMonth.setLocation(264, 150);
			mDojMonth.setSelectedIndex(DateConstants.getCurrentMonthIdx());
			add(mDojMonth);

			mDojYear = new JComboBox<>(DateConstants.YEARS);
			mDojYear.setSize(52, 20);
			mDojYear.setLocation(328, 150);
			mDojYear.setSelectedIndex(DateConstants.getCurrentYearIdx());
			add(mDojYear);

			mAddressLabel = new JLabel("Address");
			mAddressLabel.setSize(180, 20);
			mAddressLabel.setLocation(5, 180);
			add(mAddressLabel);

			mAddressValue = new JTextArea();
			mAddressValue.setLineWrap(true);
			mAddressScroll = new JScrollPane(mAddressValue);
			mAddressScroll.setSize(180, 60);
			mAddressScroll.setLocation(200, 180);
			add(mAddressScroll);

			mMobileLabel = new JLabel("Mobile Number");
			mMobileLabel.setSize(180, 20);
			mMobileLabel.setLocation(5, 250);
			add(mMobileLabel);

			mMobileValue = new JTextField();
			mMobileValue.setSize(180, 20);
			mMobileValue.setLocation(200, 250);
			add(mMobileValue);

			mEmailLabel = new JLabel("Email Id");
			mEmailLabel.setSize(180, 20);
			mEmailLabel.setLocation(5, 280);
			add(mEmailLabel);

			mEmailValue = new JTextField();
			mEmailValue.setSize(180, 20);
			mEmailValue.setLocation(200, 280);
			add(mEmailValue);

			mPanLabel = new JLabel("PAN Number");
			mPanLabel.setSize(180, 20);
			mPanLabel.setLocation(5, 310);
			add(mPanLabel);

			mPanValue = new JTextField();
			mPanValue.setSize(180, 20);
			mPanValue.setLocation(200, 310);
			add(mPanValue);

			mAadharLabel = new JLabel("Aadhar Number");
			mAadharLabel.setSize(180, 20);
			mAadharLabel.setLocation(5, 340);
			add(mAadharLabel);

			mAadharValue = new JTextField();
			mAadharValue.setSize(180, 20);
			mAadharValue.setLocation(200, 340);
			add(mAadharValue);

			mSubmit = new JButton("Submit");
			mSubmit.setSize(80, 20);
			mSubmit.setLocation(100, 390);
			mSubmit.addActionListener(this);
			add(mSubmit);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == mSearchAccountNumberSubmit) {
				mSearchAccountNumberSubmit.setText("FOUND");
			}
		}

		private class AccountMouseListner implements MouseListener {

			@Override
			public void mouseClicked(MouseEvent e) {
				mSearchAccountNumber.setText("");
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		}
	}
}
