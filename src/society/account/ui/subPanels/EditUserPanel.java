package society.account.ui.subPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import society.account.ui.UiConstants;

@SuppressWarnings("serial")
public class EditUserPanel extends JPanel implements ActionListener {

	private int mWidth = UiConstants.DimensionConstants.DEFAULT_WIDTH;
	private int mHeight = UiConstants.DimensionConstants.DEFAULT_HEIGHT;
	private int mInitialSpacing = UiConstants.DimensionConstants.DEFAULT_INITIAL_SPACING;
	private int mVerticalSpacing = UiConstants.DimensionConstants.DEFAULT_VERTICAL_SPACING;
	private int mHorizontalSpacing = UiConstants.DimensionConstants.DEFAULT_HORIZONTAL_SPACING;
	private int mComboBoxWidth = UiConstants.DimensionConstants.DEFAULT_COMBO_BOX_DATE_WIDTH;
	
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
		mSearchAccountNumber.setSize(mWidth, mHeight);
		mSearchAccountNumber.setLocation(mInitialSpacing, mInitialSpacing);
		mSearchAccountNumber.addMouseListener(new AccountMouseListner());
		add(mSearchAccountNumber);

		mSearchAccountNumberSubmit = new JButton("Find");
		mSearchAccountNumberSubmit.setSize(100, mHeight);
		mSearchAccountNumberSubmit.setLocation(mHorizontalSpacing, mInitialSpacing);
		mSearchAccountNumberSubmit.addActionListener(this);
		add(mSearchAccountNumberSubmit);

		mAccountNumberLabel = new JLabel("Account Number");
		mAccountNumberLabel.setSize(mWidth, mHeight);
		mAccountNumberLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing);
		add(mAccountNumberLabel);

		mAccountNumberValue = new JTextField();
		mAccountNumberValue.setSize(mWidth, mHeight);
		mAccountNumberValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing);
		add(mAccountNumberValue);

		mNameLabel = new JLabel("Name");
		mNameLabel.setSize(mWidth, mHeight);
		mNameLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 2);
		add(mNameLabel);

		mNameValue = new JTextField();
		mNameValue.setSize(mWidth, mHeight);
		mNameValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 2);
		add(mNameValue);

		mDobLabel = new JLabel("Date of Birth");
		mDobLabel.setSize(mWidth, mHeight);
		mDobLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 3);
		add(mDobLabel);

		mDobDate = new JComboBox<>(UiConstants.DateConstants.DATES);
		mDobDate.setSize(mComboBoxWidth, mHeight);
		mDobDate.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 3);
		add(mDobDate);

		mDobMonth = new JComboBox<>(UiConstants.DateConstants.MONTHS);
		mDobMonth.setSize(mComboBoxWidth, mHeight);
		mDobMonth.setLocation(mHorizontalSpacing + mInitialSpacing + mComboBoxWidth, mInitialSpacing + mVerticalSpacing * 3);
		add(mDobMonth);

		mDobYear = new JComboBox<>(UiConstants.DateConstants.YEARS);
		mDobYear.setSize(mComboBoxWidth, mHeight);
		mDobYear.setLocation(mHorizontalSpacing + (mInitialSpacing + mComboBoxWidth) * 2, mInitialSpacing + mVerticalSpacing * 3);
		add(mDobYear);

		mDojLabel = new JLabel("Date of Joining");
		mDojLabel.setSize(mWidth, mHeight);
		mDojLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 4);
		add(mDojLabel);

		mDojDate = new JComboBox<>(UiConstants.DateConstants.DATES);
		mDojDate.setSize(mComboBoxWidth, mHeight);
		mDojDate.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 4);
		mDojDate.setSelectedIndex(UiConstants.DateConstants.getCurrentDateIdx());
		add(mDojDate);

		mDojMonth = new JComboBox<>(UiConstants.DateConstants.MONTHS);
		mDojMonth.setSize(mComboBoxWidth, mHeight);
		mDojMonth.setLocation(mHorizontalSpacing + mInitialSpacing + mComboBoxWidth, mInitialSpacing + mVerticalSpacing * 4);
		mDojMonth.setSelectedIndex(UiConstants.DateConstants.getCurrentMonthIdx());
		add(mDojMonth);

		mDojYear = new JComboBox<>(UiConstants.DateConstants.YEARS);
		mDojYear.setSize(mComboBoxWidth, mHeight);
		mDojYear.setLocation(mHorizontalSpacing + (mInitialSpacing + mComboBoxWidth) * 2, mInitialSpacing + mVerticalSpacing * 4);
		mDojYear.setSelectedIndex(UiConstants.DateConstants.getCurrentYearIdx());
		add(mDojYear);

		mAddressLabel = new JLabel("Address");
		mAddressLabel.setSize(mWidth, mHeight);
		mAddressLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 5);
		add(mAddressLabel);

		mAddressValue = new JTextArea();
		mAddressValue.setLineWrap(true);
		mAddressScroll = new JScrollPane(mAddressValue);
		mAddressScroll.setSize(mWidth, mHeight * 3);
		mAddressScroll.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 5);
		add(mAddressScroll);

		mMobileLabel = new JLabel("Mobile Number");
		mMobileLabel.setSize(mWidth, mHeight);
		mMobileLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 7);
		add(mMobileLabel);

		mMobileValue = new JTextField();
		mMobileValue.setSize(mWidth, mHeight);
		mMobileValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 7);
		add(mMobileValue);

		mEmailLabel = new JLabel("Email Id");
		mEmailLabel.setSize(mWidth, mHeight);
		mEmailLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 8);
		add(mEmailLabel);

		mEmailValue = new JTextField();
		mEmailValue.setSize(mWidth, mHeight);
		mEmailValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 8);
		add(mEmailValue);

		mPanLabel = new JLabel("PAN Number");
		mPanLabel.setSize(mWidth, mHeight);
		mPanLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 9);
		add(mPanLabel);

		mPanValue = new JTextField();
		mPanValue.setSize(mWidth, mHeight);
		mPanValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 9);
		add(mPanValue);

		mAadharLabel = new JLabel("Aadhar Number");
		mAadharLabel.setSize(mWidth, mHeight);
		mAadharLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 10);
		add(mAadharLabel);

		mAadharValue = new JTextField();
		mAadharValue.setSize(mWidth, mHeight);
		mAadharValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 10);
		add(mAadharValue);

		mSubmit = new JButton("Submit");
		mSubmit.setSize(100, mHeight);
		mSubmit.setLocation(300, mInitialSpacing + mVerticalSpacing * 12);
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
