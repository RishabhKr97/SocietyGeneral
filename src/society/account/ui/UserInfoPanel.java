package society.account.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UserInfoPanel extends JPanel implements ActionListener {

	private int mWidth = UiConstants.DimensionConstants.DEFAULT_WIDTH;
	private int mHeight = UiConstants.DimensionConstants.DEFAULT_HEIGHT;
	private int mInitialSpacing = UiConstants.DimensionConstants.DEFAULT_INITIAL_SPACING;
	private int mVerticalSpacing = UiConstants.DimensionConstants.DEFAULT_VERTICAL_SPACING;
	private int mHorizontalSpacing = UiConstants.DimensionConstants.DEFAULT_HORIZONTAL_SPACING;

	private JTextField mAccountNumber;
	private JButton mSubmit;
	private JLabel mNameLabel;
	private JTextField mNameValue;
	private JLabel mDobLabel;
	private JTextField mDobValue;
	private JLabel mDojLabel;
	private JTextField mDojValue;
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
	private JLabel mShareBalanceLabel;
	private JTextField mShareBalanceValue;
	private JLabel mCdBalanceLabel;
	private JTextField mCdBalanceValue;
	private JLabel mLoanBalanceLabel;
	private JTextField mLoanBalanceValue;
	private JLabel mStatusLabel;

	public UserInfoPanel() {
		setLayout(null);

		mAccountNumber = new JTextField();
		mAccountNumber.setText(" ENTER ACCOUNT NUMBER");
		mAccountNumber.setSize(mWidth, mHeight);
		mAccountNumber.setLocation(mInitialSpacing, mInitialSpacing);
		mAccountNumber.addMouseListener(new AccountMouseListner());
		add(mAccountNumber);

		mSubmit = new JButton("Find");
		mSubmit.setSize(100, mHeight);
		mSubmit.setLocation(mHorizontalSpacing, mInitialSpacing);
		mSubmit.addActionListener(this);
		add(mSubmit);

		mNameLabel = new JLabel("Name");
		mNameLabel.setSize(mWidth, mHeight);
		mNameLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing);
		add(mNameLabel);

		mNameValue = new JTextField();
		mNameValue.setText("My Name");
		mNameValue.setSize(mWidth, mHeight);
		mNameValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing);
		mNameValue.setEditable(false);
		add(mNameValue);

		mDobLabel = new JLabel("Date of Birth");
		mDobLabel.setSize(mWidth, mHeight);
		mDobLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 2);
		add(mDobLabel);

		mDobValue = new JTextField();
		mDobValue.setText("My DOB");
		mDobValue.setSize(mWidth, mHeight);
		mDobValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 2);
		mDobValue.setEditable(false);
		add(mDobValue);

		mDojLabel = new JLabel("Date of Joining");
		mDojLabel.setSize(mWidth, mHeight);
		mDojLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 3);
		add(mDojLabel);

		mDojValue = new JTextField();
		mDojValue.setText("My DOJ");
		mDojValue.setSize(mWidth, mHeight);
		mDojValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 3);
		mDojValue.setEditable(false);
		add(mDojValue);

		mAddressLabel = new JLabel("Address");
		mAddressLabel.setSize(mWidth, mHeight);
		mAddressLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 4);
		add(mAddressLabel);

		mAddressValue = new JTextArea();
		mAddressValue.setText("My Address");
		mAddressValue.setLineWrap(true);
		mAddressValue.setEditable(false);
		mAddressScroll = new JScrollPane(mAddressValue);
		mAddressScroll.setSize(mWidth, mHeight * 3);
		mAddressScroll.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 4);
		add(mAddressScroll);

		mMobileLabel = new JLabel("Mobile Number");
		mMobileLabel.setSize(mWidth, mHeight);
		mMobileLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 6);
		add(mMobileLabel);

		mMobileValue = new JTextField();
		mMobileValue.setText("My Mobile Number");
		mMobileValue.setSize(mWidth, mHeight);
		mMobileValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 6);
		mMobileValue.setEditable(false);
		add(mMobileValue);

		mEmailLabel = new JLabel("Email Id");
		mEmailLabel.setSize(mWidth, mHeight);
		mEmailLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 7);
		add(mEmailLabel);

		mEmailValue = new JTextField();
		mEmailValue.setText("My Email Id");
		mEmailValue.setSize(mWidth, mHeight);
		mEmailValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 7);
		mEmailValue.setEditable(false);
		add(mEmailValue);

		mPanLabel = new JLabel("PAN Number");
		mPanLabel.setSize(mWidth, mHeight);
		mPanLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 8);
		add(mPanLabel);

		mPanValue = new JTextField();
		mPanValue.setText("My PAN Number");
		mPanValue.setSize(mWidth, mHeight);
		mPanValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 8);
		mPanValue.setEditable(false);
		add(mPanValue);

		mAadharLabel = new JLabel("Aadhar Number");
		mAadharLabel.setSize(mWidth, mHeight);
		mAadharLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 9);
		add(mAadharLabel);

		mAadharValue = new JTextField();
		mAadharValue.setText("My Aadhar Number");
		mAadharValue.setSize(mWidth, mHeight);
		mAadharValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 9);
		mAadharValue.setEditable(false);
		add(mAadharValue);

		mShareBalanceLabel = new JLabel("Share Balance");
		mShareBalanceLabel.setSize(mWidth, mHeight);
		mShareBalanceLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 10);
		add(mShareBalanceLabel);

		mShareBalanceValue = new JTextField();
		mShareBalanceValue.setText("My Share Balance");
		mShareBalanceValue.setSize(mWidth, mHeight);
		mShareBalanceValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 10);
		mShareBalanceValue.setEditable(false);
		add(mShareBalanceValue);

		mCdBalanceLabel = new JLabel("Compulsory Deposit Balance");
		mCdBalanceLabel.setSize(mWidth, mHeight);
		mCdBalanceLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 11);
		add(mCdBalanceLabel);

		mCdBalanceValue = new JTextField();
		mCdBalanceValue.setText("My Compulsory Deposit Balance");
		mCdBalanceValue.setSize(mWidth, mHeight);
		mCdBalanceValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 11);
		mCdBalanceValue.setEditable(false);
		add(mCdBalanceValue);

		mLoanBalanceLabel = new JLabel("Loan Balance");
		mLoanBalanceLabel.setSize(mWidth, mHeight);
		mLoanBalanceLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 12);
		add(mLoanBalanceLabel);

		mLoanBalanceValue = new JTextField();
		mLoanBalanceValue.setText("My Loan Balance");
		mLoanBalanceValue.setSize(mWidth, mHeight);
		mLoanBalanceValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 12);
		mLoanBalanceValue.setEditable(false);
		add(mLoanBalanceValue);

		mStatusLabel = new JLabel("Account is active.");
		mStatusLabel.setSize(mWidth, mHeight);
		mStatusLabel.setLocation(200, mInitialSpacing + mVerticalSpacing * 14);
		mStatusLabel.setForeground(Color.GREEN);
		add(mStatusLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mSubmit) {
			mSubmit.setText("FOUND");
		}
	}

	private class AccountMouseListner implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			mAccountNumber.setText("");
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
