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
import society.account.ui.AlertMessages;
import society.account.ui.InputValidation;
import society.account.ui.InputValidation.ErrorReport;
import society.account.ui.UiConstants;

@SuppressWarnings("serial")
public class AddUserPanel extends JPanel implements ActionListener {

	private int mWidth = UiConstants.DimensionConstants.DEFAULT_WIDTH;
	private int mHeight = UiConstants.DimensionConstants.DEFAULT_HEIGHT;
	private int mInitialSpacing = UiConstants.DimensionConstants.DEFAULT_INITIAL_SPACING;
	private int mVerticalSpacing = UiConstants.DimensionConstants.DEFAULT_VERTICAL_SPACING;
	private int mHorizontalSpacing = UiConstants.DimensionConstants.DEFAULT_HORIZONTAL_SPACING;
	private int mComboBoxWidth = UiConstants.DimensionConstants.DEFAULT_COMBO_BOX_DATE_WIDTH;

	private JLabel mAccountNumberLabel;
	private JTextField mAccountNumberValue;
	private JButton mFind;
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
		mAccountNumberLabel.setSize(mWidth, mHeight);
		mAccountNumberLabel.setLocation(mInitialSpacing, mInitialSpacing);
		add(mAccountNumberLabel);

		mAccountNumberValue = new JTextField();
		mAccountNumberValue.setSize(mWidth, mHeight);
		mAccountNumberValue.setLocation(mHorizontalSpacing, mInitialSpacing);
		add(mAccountNumberValue);

		mFind = new JButton("Find");
		mFind.setSize(100, mHeight);
		mFind.setLocation(mHorizontalSpacing * 2, mInitialSpacing);
		mFind.addActionListener(this);
		add(mFind);

		mNameLabel = new JLabel("Name");
		mNameLabel.setSize(mWidth, mHeight);
		mNameLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing);
		add(mNameLabel);

		mNameValue = new JTextField();
		mNameValue.setSize(mWidth, mHeight);
		mNameValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing);
		add(mNameValue);

		mDobLabel = new JLabel("Date of Birth");
		mDobLabel.setSize(mWidth, mHeight);
		mDobLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 2);
		add(mDobLabel);

		mDobDate = new JComboBox<>(UiConstants.DateConstants.DATES);
		mDobDate.setSize(mComboBoxWidth, mHeight);
		mDobDate.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 2);
		add(mDobDate);

		mDobMonth = new JComboBox<>(UiConstants.DateConstants.MONTHS);
		mDobMonth.setSize(mComboBoxWidth, mHeight);
		mDobMonth.setLocation(mHorizontalSpacing + mInitialSpacing + mComboBoxWidth,
				mInitialSpacing + mVerticalSpacing * 2);
		add(mDobMonth);

		mDobYear = new JComboBox<>(UiConstants.DateConstants.YEARS);
		mDobYear.setSize(mComboBoxWidth, mHeight);
		mDobYear.setLocation(mHorizontalSpacing + (mInitialSpacing + mComboBoxWidth) * 2,
				mInitialSpacing + mVerticalSpacing * 2);
		add(mDobYear);

		mDojLabel = new JLabel("Date of Joining");
		mDojLabel.setSize(mWidth, mHeight);
		mDojLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 3);
		add(mDojLabel);

		mDojDate = new JComboBox<>(UiConstants.DateConstants.DATES);
		mDojDate.setSize(mComboBoxWidth, mHeight);
		mDojDate.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 3);
		mDojDate.setSelectedIndex(UiConstants.DateConstants.getCurrentDateIdx());
		add(mDojDate);

		mDojMonth = new JComboBox<>(UiConstants.DateConstants.MONTHS);
		mDojMonth.setSize(mComboBoxWidth, mHeight);
		mDojMonth.setLocation(mHorizontalSpacing + mInitialSpacing + mComboBoxWidth,
				mInitialSpacing + mVerticalSpacing * 3);
		mDojMonth.setSelectedIndex(UiConstants.DateConstants.getCurrentMonthIdx());
		add(mDojMonth);

		mDojYear = new JComboBox<>(UiConstants.DateConstants.YEARS);
		mDojYear.setSize(mComboBoxWidth, mHeight);
		mDojYear.setLocation(mHorizontalSpacing + (mInitialSpacing + mComboBoxWidth) * 2,
				mInitialSpacing + mVerticalSpacing * 3);
		mDojYear.setSelectedIndex(UiConstants.DateConstants.getCurrentYearIdx());
		add(mDojYear);

		mAddressLabel = new JLabel("Address");
		mAddressLabel.setSize(mWidth, mHeight);
		mAddressLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 4);
		add(mAddressLabel);

		mAddressValue = new JTextArea();
		mAddressValue.setLineWrap(true);
		mAddressScroll = new JScrollPane(mAddressValue);
		mAddressScroll.setSize(mWidth, mHeight * 3);
		mAddressScroll.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 4);
		add(mAddressScroll);

		mMobileLabel = new JLabel("Mobile Number");
		mMobileLabel.setSize(mWidth, mHeight);
		mMobileLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 6);
		add(mMobileLabel);

		mMobileValue = new JTextField();
		mMobileValue.setSize(mWidth, mHeight);
		mMobileValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 6);
		add(mMobileValue);

		mEmailLabel = new JLabel("Email Id");
		mEmailLabel.setSize(mWidth, mHeight);
		mEmailLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 7);
		add(mEmailLabel);

		mEmailValue = new JTextField();
		mEmailValue.setSize(mWidth, mHeight);
		mEmailValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 7);
		add(mEmailValue);

		mPanLabel = new JLabel("PAN Number");
		mPanLabel.setSize(mWidth, mHeight);
		mPanLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 8);
		add(mPanLabel);

		mPanValue = new JTextField();
		mPanValue.setSize(mWidth, mHeight);
		mPanValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 8);
		add(mPanValue);

		mAadharLabel = new JLabel("Aadhar Number");
		mAadharLabel.setSize(mWidth, mHeight);
		mAadharLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 9);
		add(mAadharLabel);

		mAadharValue = new JTextField();
		mAadharValue.setSize(mWidth, mHeight);
		mAadharValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 9);
		add(mAadharValue);

		mSubmit = new JButton("Submit");
		mSubmit.setSize(100, 20);
		mSubmit.setLocation(200, mInitialSpacing + mVerticalSpacing * 11);
		mSubmit.addActionListener(this);
		add(mSubmit);

		mClear = new JButton("Clear");
		mClear.setSize(100, 20);
		mClear.setLocation(330, mInitialSpacing + mVerticalSpacing * 11);
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
			String aadhar = mAadharValue.getText().trim().replace(" ", "");

			ErrorReport validation = InputValidation.verifyMemberInfo(accountNumber, name, address, mobile, email, pan,
					aadhar);
			if (!validation.valid) {
				AlertMessages.showErrorMessage(this, validation.errorMessage);
				return;
			}

			int result = dbHelper.addUser(accountNumber, name, dobYear + "-" + dobMonth + "-" + dobDate,
					dojYear + "-" + dojMonth + "-" + dojDate, address, mobile, email, pan, aadhar);

			if (result == 1) {
				AlertMessages.showAlertMessage(this, "New Member Added!");
				mClear.doClick();
			} else {
				AlertMessages.showSystemErrorMessage(this);
			}
		} else if (e.getSource() == mClear) {
			mAccountNumberValue.setText("");
			mNameValue.setText("");
			mDobDate.setSelectedIndex(0);
			mDobMonth.setSelectedIndex(0);
			mDobYear.setSelectedIndex(0);
			mDojDate.setSelectedIndex(UiConstants.DateConstants.getCurrentDateIdx());
			mDojMonth.setSelectedIndex(UiConstants.DateConstants.getCurrentMonthIdx());
			mDojYear.setSelectedIndex(UiConstants.DateConstants.getCurrentYearIdx());
			mAddressValue.setText("");
			mMobileValue.setText("");
			mEmailValue.setText("");
			mPanValue.setText("");
			mAadharValue.setText("");
		} else if (e.getSource() == mFind) {
			int result = dbHelper.getNextAccountNumber();
			if (result <= 0) {
				AlertMessages.showSystemErrorMessage(this);
			} else {
				mAccountNumberValue.setText(String.valueOf(result));
			}
		}
	}
}
