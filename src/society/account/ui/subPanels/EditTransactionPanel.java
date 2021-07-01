package society.account.ui.subPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import society.account.ui.UiConstants;

@SuppressWarnings("serial")
public class EditTransactionPanel extends JPanel implements ActionListener {

	private int mWidth = UiConstants.DimensionConstants.DEFAULT_WIDTH;
	private int mHeight = UiConstants.DimensionConstants.DEFAULT_HEIGHT;
	private int mInitialSpacing = UiConstants.DimensionConstants.DEFAULT_INITIAL_SPACING;
	private int mVerticalSpacing = UiConstants.DimensionConstants.DEFAULT_VERTICAL_SPACING;
	private int mHorizontalSpacing = UiConstants.DimensionConstants.DEFAULT_HORIZONTAL_SPACING;
	private int mComboBoxWidth = UiConstants.DimensionConstants.DEFAULT_COMBO_BOX_DATE_WIDTH;

	private JTextField mSearchTransactionNumber;
	private JButton mSearchTransactionNumberSubmit;
	private JLabel mAccountNumberLabel;
	private JTextField mAccountNumberValue;
	private JLabel mDotLabel;
	private JComboBox<String> mDotDate;
	private JComboBox<String> mDotMonth;
	private JComboBox<String> mDotYear;
	private JLabel mCdDepositLabel;
	private JTextField mCdDepositValue;
	private JLabel mCdFineDepositLabel;
	private JTextField mCdFineDepositValue;
	private JLabel mLoanInstallmentDepositLabel;
	private JTextField mLoanInstallmentDepositValue;
	private JLabel mLoanInterestDepositLabel;
	private JTextField mLoanInterestDepositValue;
	private JLabel mLoanFineDepositLabel;
	private JTextField mLoanFineDepositValue;
	private JLabel mShareMoneyDepositLabel;
	private JTextField mShareMoneyDepositValue;
	private JLabel mAdmissionFeeDepositLabel;
	private JTextField mAdmissionFeeDepositValue;
	private JLabel mWelfareDepositLabel;
	private JTextField mWelfareDepositValue;
	private JLabel mMiscDepositLabel;
	private JTextField mMiscDepositValue;
	private JLabel mLoanIssuedLabel;
	private JTextField mLoanIssuedValue;
	private JLabel mMiscAmountIssuedLabel;
	private JTextField mMiscAmountIssuedValue;
	private JLabel mPaymentModeLabel;
	private JComboBox<String> mPaymentModeValue;
	private JLabel mRemarksLabel;
	private JTextField mRemarksValue;
	private JButton mSubmit;

	public EditTransactionPanel() {
		setLayout(null);

		mSearchTransactionNumber = new JTextField();
		mSearchTransactionNumber.setText("ENTER TRANSACTION NUMBER");
		mSearchTransactionNumber.setSize(mWidth, mHeight);
		mSearchTransactionNumber.setLocation(mInitialSpacing, mInitialSpacing);
		mSearchTransactionNumber.addMouseListener(new AccountMouseListner());
		add(mSearchTransactionNumber);

		mSearchTransactionNumberSubmit = new JButton("Find");
		mSearchTransactionNumberSubmit.setSize(100, mHeight);
		mSearchTransactionNumberSubmit.setLocation(mHorizontalSpacing, mInitialSpacing);
		mSearchTransactionNumberSubmit.addActionListener(this);
		add(mSearchTransactionNumberSubmit);
		
		mAccountNumberLabel = new JLabel("Account Number");
		mAccountNumberLabel.setSize(mWidth, mHeight);
		mAccountNumberLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing);
		add(mAccountNumberLabel);

		mAccountNumberValue = new JTextField();
		mAccountNumberValue.setSize(mWidth, mHeight);
		mAccountNumberValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing);
		add(mAccountNumberValue);

		mDotLabel = new JLabel("Date of Transaction");
		mDotLabel.setSize(mWidth, mHeight);
		mDotLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 2);
		add(mDotLabel);

		mDotDate = new JComboBox<>(UiConstants.DateConstants.DATES);
		mDotDate.setSize(mComboBoxWidth, mHeight);
		mDotDate.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 2);
		mDotDate.setSelectedIndex(UiConstants.DateConstants.getCurrentDateIdx());
		add(mDotDate);

		mDotMonth = new JComboBox<>(UiConstants.DateConstants.MONTHS);
		mDotMonth.setSize(mComboBoxWidth, mHeight);
		mDotMonth.setLocation(mHorizontalSpacing + mInitialSpacing + mComboBoxWidth,
				mInitialSpacing + mVerticalSpacing * 2);
		mDotMonth.setSelectedIndex(UiConstants.DateConstants.getCurrentMonthIdx());
		add(mDotMonth);

		mDotYear = new JComboBox<>(UiConstants.DateConstants.YEARS);
		mDotYear.setSize(mComboBoxWidth, mHeight);
		mDotYear.setLocation(mHorizontalSpacing + (mInitialSpacing + mComboBoxWidth) * 2,
				mInitialSpacing + mVerticalSpacing * 2);
		mDotYear.setSelectedIndex(UiConstants.DateConstants.getCurrentYearIdx());
		add(mDotYear);

		mCdDepositLabel = new JLabel("Compulsory Deposit");
		mCdDepositLabel.setSize(mWidth, mHeight);
		mCdDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 3);
		add(mCdDepositLabel);

		mCdDepositValue = new JTextField();
		mCdDepositValue.setSize(mWidth, mHeight);
		mCdDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 3);
		add(mCdDepositValue);

		mCdFineDepositLabel = new JLabel("Compulsory Deposit Fine");
		mCdFineDepositLabel.setSize(mWidth, mHeight);
		mCdFineDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 4);
		add(mCdFineDepositLabel);

		mCdFineDepositValue = new JTextField();
		mCdFineDepositValue.setSize(mWidth, mHeight);
		mCdFineDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 4);
		add(mCdFineDepositValue);

		mLoanInstallmentDepositLabel = new JLabel("Loan Installment Deposit");
		mLoanInstallmentDepositLabel.setSize(mWidth, mHeight);
		mLoanInstallmentDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 5);
		add(mLoanInstallmentDepositLabel);

		mLoanInstallmentDepositValue = new JTextField();
		mLoanInstallmentDepositValue.setSize(mWidth, mHeight);
		mLoanInstallmentDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 5);
		add(mLoanInstallmentDepositValue);

		mLoanInterestDepositLabel = new JLabel("Loan Interest Deposit");
		mLoanInterestDepositLabel.setSize(mWidth, mHeight);
		mLoanInterestDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 6);
		add(mLoanInterestDepositLabel);

		mLoanInterestDepositValue = new JTextField();
		mLoanInterestDepositValue.setSize(mWidth, mHeight);
		mLoanInterestDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 6);
		add(mLoanInterestDepositValue);

		mLoanFineDepositLabel = new JLabel("Loan Fine Deposit");
		mLoanFineDepositLabel.setSize(mWidth, mHeight);
		mLoanFineDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 7);
		add(mLoanFineDepositLabel);

		mLoanFineDepositValue = new JTextField();
		mLoanFineDepositValue.setSize(mWidth, mHeight);
		mLoanFineDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 7);
		add(mLoanFineDepositValue);

		mShareMoneyDepositLabel = new JLabel("Share Money Deposit");
		mShareMoneyDepositLabel.setSize(mWidth, mHeight);
		mShareMoneyDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 8);
		add(mShareMoneyDepositLabel);

		mShareMoneyDepositValue = new JTextField();
		mShareMoneyDepositValue.setSize(mWidth, mHeight);
		mShareMoneyDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 8);
		add(mShareMoneyDepositValue);

		mAdmissionFeeDepositLabel = new JLabel("Admission Fee Deposit");
		mAdmissionFeeDepositLabel.setSize(mWidth, mHeight);
		mAdmissionFeeDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 9);
		add(mAdmissionFeeDepositLabel);

		mAdmissionFeeDepositValue = new JTextField();
		mAdmissionFeeDepositValue.setSize(mWidth, mHeight);
		mAdmissionFeeDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 9);
		add(mAdmissionFeeDepositValue);

		mWelfareDepositLabel = new JLabel("Welfare Deposit");
		mWelfareDepositLabel.setSize(mWidth, mHeight);
		mWelfareDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 10);
		add(mWelfareDepositLabel);

		mWelfareDepositValue = new JTextField();
		mWelfareDepositValue.setSize(mWidth, mHeight);
		mWelfareDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 10);
		add(mWelfareDepositValue);

		mMiscDepositLabel = new JLabel("Miscellaneous Deposit");
		mMiscDepositLabel.setSize(mWidth, mHeight);
		mMiscDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 11);
		add(mMiscDepositLabel);

		mMiscDepositValue = new JTextField();
		mMiscDepositValue.setSize(mWidth, mHeight);
		mMiscDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 11);
		add(mMiscDepositValue);

		mLoanIssuedLabel = new JLabel("Loan Issued");
		mLoanIssuedLabel.setSize(mWidth, mHeight);
		mLoanIssuedLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 12);
		add(mLoanIssuedLabel);

		mLoanIssuedValue = new JTextField();
		mLoanIssuedValue.setSize(mWidth, mHeight);
		mLoanIssuedValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 12);
		add(mLoanIssuedValue);

		mMiscAmountIssuedLabel = new JLabel("Miscellaneous Amount Issued");
		mMiscAmountIssuedLabel.setSize(mWidth, mHeight);
		mMiscAmountIssuedLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 13);
		add(mMiscAmountIssuedLabel);

		mMiscAmountIssuedValue = new JTextField();
		mMiscAmountIssuedValue.setSize(mWidth, mHeight);
		mMiscAmountIssuedValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 13);
		add(mMiscAmountIssuedValue);

		mPaymentModeLabel = new JLabel("Payment Mode");
		mPaymentModeLabel.setSize(mWidth, mHeight);
		mPaymentModeLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 14);
		add(mPaymentModeLabel);

		mPaymentModeValue = new JComboBox<>(UiConstants.PaymentModeConstants.PAYMENT_MODES);
		mPaymentModeValue.setSize(90, mHeight);
		mPaymentModeValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 14);
		add(mPaymentModeValue);

		mRemarksLabel = new JLabel("Remarks");
		mRemarksLabel.setSize(mWidth, mHeight);
		mRemarksLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 15);
		add(mRemarksLabel);

		mRemarksValue = new JTextField();
		mRemarksValue.setSize(mWidth, mHeight);
		mRemarksValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 15);
		add(mRemarksValue);

		mSubmit = new JButton("Submit");
		mSubmit.setSize(100, mHeight);
		mSubmit.setLocation(300, mInitialSpacing + mVerticalSpacing * 17);
		mSubmit.addActionListener(this);
		add(mSubmit);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	private class AccountMouseListner implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			mSearchTransactionNumber.setText("");
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
