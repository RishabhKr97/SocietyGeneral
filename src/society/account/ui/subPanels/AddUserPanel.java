package society.account.ui.subPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import society.account.database.DatabaseHelper;
import society.account.ui.DateConstants;

@SuppressWarnings("serial")
public class AddUserPanel extends JPanel implements ActionListener {

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

	public AddUserPanel() {
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

	private boolean verifyInput(String accNum, String name, String mobile, String email, String pan, String aadhar) {
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
