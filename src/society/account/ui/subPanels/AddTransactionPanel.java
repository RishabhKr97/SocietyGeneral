package society.account.ui.subPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import society.account.database.DatabaseHelper;
import society.account.receipt.printmanager.Printer;
import society.account.ui.AlertMessages;
import society.account.ui.InputValidation;
import society.account.ui.InputValidation.ErrorReport;
import society.account.ui.UiConstants;

@SuppressWarnings("serial")
public class AddTransactionPanel extends JPanel implements ActionListener {

	private int mWidth = UiConstants.DimensionConstants.DEFAULT_WIDTH;
	private int mHeight = UiConstants.DimensionConstants.DEFAULT_HEIGHT;
	private int mInitialSpacing = UiConstants.DimensionConstants.DEFAULT_INITIAL_SPACING;
	private int mVerticalSpacing = UiConstants.DimensionConstants.DEFAULT_VERTICAL_SPACING;
	private int mHorizontalSpacing = UiConstants.DimensionConstants.DEFAULT_HORIZONTAL_SPACING;
	private int mComboBoxWidth = UiConstants.DimensionConstants.DEFAULT_COMBO_BOX_DATE_WIDTH;

	private JLabel mAccountNumberLabel;
	private JTextField mAccountNumberValue;
	private JButton mGetPaymentDetails;
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
	private JButton mClear;

	private final DatabaseHelper dbHelper = new DatabaseHelper();

	public AddTransactionPanel() {
		setLayout(null);

		mAccountNumberLabel = new JLabel("Account Number");
		mAccountNumberLabel.setSize(mWidth, mHeight);
		mAccountNumberLabel.setLocation(mInitialSpacing, mInitialSpacing);
		add(mAccountNumberLabel);

		mAccountNumberValue = new JTextField();
		mAccountNumberValue.setSize(mWidth, mHeight);
		mAccountNumberValue.setLocation(mHorizontalSpacing, mInitialSpacing);
		add(mAccountNumberValue);

		mGetPaymentDetails = new JButton("Get Details");
		mGetPaymentDetails.setSize(125, mHeight);
		mGetPaymentDetails.setLocation(mHorizontalSpacing * 2, mInitialSpacing);
		mGetPaymentDetails.addActionListener(this);
		add(mGetPaymentDetails);

		mDotLabel = new JLabel("Date of Transaction");
		mDotLabel.setSize(mWidth, mHeight);
		mDotLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing);
		add(mDotLabel);

		mDotDate = new JComboBox<>(UiConstants.DateConstants.DATES);
		mDotDate.setSize(mComboBoxWidth, mHeight);
		mDotDate.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing);
		mDotDate.setSelectedIndex(UiConstants.DateConstants.getCurrentDateIdx());
		add(mDotDate);

		mDotMonth = new JComboBox<>(UiConstants.DateConstants.MONTHS);
		mDotMonth.setSize(mComboBoxWidth, mHeight);
		mDotMonth.setLocation(mHorizontalSpacing + mInitialSpacing + mComboBoxWidth,
				mInitialSpacing + mVerticalSpacing);
		mDotMonth.setSelectedIndex(UiConstants.DateConstants.getCurrentMonthIdx());
		add(mDotMonth);

		mDotYear = new JComboBox<>(UiConstants.DateConstants.YEARS);
		mDotYear.setSize(mComboBoxWidth, mHeight);
		mDotYear.setLocation(mHorizontalSpacing + (mInitialSpacing + mComboBoxWidth) * 2,
				mInitialSpacing + mVerticalSpacing);
		mDotYear.setSelectedIndex(UiConstants.DateConstants.getCurrentYearIdx());
		add(mDotYear);

		mCdDepositLabel = new JLabel("Compulsory Deposit");
		mCdDepositLabel.setSize(mWidth, mHeight);
		mCdDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 2);
		add(mCdDepositLabel);

		mCdDepositValue = new JTextField();
		mCdDepositValue.setSize(mWidth, mHeight);
		mCdDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 2);
		add(mCdDepositValue);

		mCdFineDepositLabel = new JLabel("Compulsory Deposit Fine");
		mCdFineDepositLabel.setSize(mWidth, mHeight);
		mCdFineDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 3);
		add(mCdFineDepositLabel);

		mCdFineDepositValue = new JTextField();
		mCdFineDepositValue.setSize(mWidth, mHeight);
		mCdFineDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 3);
		add(mCdFineDepositValue);

		mLoanInstallmentDepositLabel = new JLabel("Loan Installment Deposit");
		mLoanInstallmentDepositLabel.setSize(mWidth, mHeight);
		mLoanInstallmentDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 4);
		add(mLoanInstallmentDepositLabel);

		mLoanInstallmentDepositValue = new JTextField();
		mLoanInstallmentDepositValue.setSize(mWidth, mHeight);
		mLoanInstallmentDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 4);
		add(mLoanInstallmentDepositValue);

		mLoanInterestDepositLabel = new JLabel("Loan Interest Deposit");
		mLoanInterestDepositLabel.setSize(mWidth, mHeight);
		mLoanInterestDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 5);
		add(mLoanInterestDepositLabel);

		mLoanInterestDepositValue = new JTextField();
		mLoanInterestDepositValue.setSize(mWidth, mHeight);
		mLoanInterestDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 5);
		add(mLoanInterestDepositValue);

		mLoanFineDepositLabel = new JLabel("Loan Fine Deposit");
		mLoanFineDepositLabel.setSize(mWidth, mHeight);
		mLoanFineDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 6);
		add(mLoanFineDepositLabel);

		mLoanFineDepositValue = new JTextField();
		mLoanFineDepositValue.setSize(mWidth, mHeight);
		mLoanFineDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 6);
		add(mLoanFineDepositValue);

		mShareMoneyDepositLabel = new JLabel("Share Money Deposit");
		mShareMoneyDepositLabel.setSize(mWidth, mHeight);
		mShareMoneyDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 7);
		add(mShareMoneyDepositLabel);

		mShareMoneyDepositValue = new JTextField();
		mShareMoneyDepositValue.setSize(mWidth, mHeight);
		mShareMoneyDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 7);
		add(mShareMoneyDepositValue);

		mAdmissionFeeDepositLabel = new JLabel("Admission Fee Deposit");
		mAdmissionFeeDepositLabel.setSize(mWidth, mHeight);
		mAdmissionFeeDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 8);
		add(mAdmissionFeeDepositLabel);

		mAdmissionFeeDepositValue = new JTextField();
		mAdmissionFeeDepositValue.setSize(mWidth, mHeight);
		mAdmissionFeeDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 8);
		add(mAdmissionFeeDepositValue);

		mWelfareDepositLabel = new JLabel("Welfare Deposit");
		mWelfareDepositLabel.setSize(mWidth, mHeight);
		mWelfareDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 9);
		add(mWelfareDepositLabel);

		mWelfareDepositValue = new JTextField();
		mWelfareDepositValue.setSize(mWidth, mHeight);
		mWelfareDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 9);
		add(mWelfareDepositValue);

		mMiscDepositLabel = new JLabel("Miscellaneous Deposit");
		mMiscDepositLabel.setSize(mWidth, mHeight);
		mMiscDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 10);
		add(mMiscDepositLabel);

		mMiscDepositValue = new JTextField();
		mMiscDepositValue.setSize(mWidth, mHeight);
		mMiscDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 10);
		add(mMiscDepositValue);

		mLoanIssuedLabel = new JLabel("Loan Issued");
		mLoanIssuedLabel.setSize(mWidth, mHeight);
		mLoanIssuedLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 11);
		add(mLoanIssuedLabel);

		mLoanIssuedValue = new JTextField();
		mLoanIssuedValue.setSize(mWidth, mHeight);
		mLoanIssuedValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 11);
		add(mLoanIssuedValue);

		mMiscAmountIssuedLabel = new JLabel("Miscellaneous Amount Issued");
		mMiscAmountIssuedLabel.setSize(mWidth, mHeight);
		mMiscAmountIssuedLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 12);
		add(mMiscAmountIssuedLabel);

		mMiscAmountIssuedValue = new JTextField();
		mMiscAmountIssuedValue.setSize(mWidth, mHeight);
		mMiscAmountIssuedValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 12);
		add(mMiscAmountIssuedValue);

		mPaymentModeLabel = new JLabel("Payment Mode");
		mPaymentModeLabel.setSize(mWidth, mHeight);
		mPaymentModeLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 13);
		add(mPaymentModeLabel);

		mPaymentModeValue = new JComboBox<>(UiConstants.PaymentModeConstants.PAYMENT_MODES);
		mPaymentModeValue.setSize(90, mHeight);
		mPaymentModeValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 13);
		add(mPaymentModeValue);

		mRemarksLabel = new JLabel("Remarks");
		mRemarksLabel.setSize(mWidth, mHeight);
		mRemarksLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 14);
		add(mRemarksLabel);

		mRemarksValue = new JTextField();
		mRemarksValue.setSize(mWidth, mHeight);
		mRemarksValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 14);
		add(mRemarksValue);

		mSubmit = new JButton("Submit");
		mSubmit.setSize(100, mHeight);
		mSubmit.setLocation(200, mInitialSpacing + mVerticalSpacing * 16);
		mSubmit.addActionListener(this);
		add(mSubmit);

		mClear = new JButton("Clear");
		mClear.setSize(100, mHeight);
		mClear.setLocation(330, mInitialSpacing + mVerticalSpacing * 16);
		mClear.addActionListener(this);
		mClear.doClick();
		add(mClear);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == mSubmit) {
			String accountNumber = mAccountNumberValue.getText().trim();
			String dotDate = (String) mDotDate.getSelectedItem();
			String dotMonth = (String) mDotMonth.getSelectedItem();
			String dotYear = (String) mDotYear.getSelectedItem();
			String cdDeposit = mCdDepositValue.getText().trim();
			String cdFineDeposit = mCdFineDepositValue.getText().trim();
			String loanInstallmentDeposit = mLoanInstallmentDepositValue.getText().trim();
			String loanInterestDeposit = mLoanInterestDepositValue.getText().trim();
			String loanFineDeposit = mLoanFineDepositValue.getText().trim();
			String shareMoneyDeposit = mShareMoneyDepositValue.getText().trim();
			String admissionFeeDeposit = mAdmissionFeeDepositValue.getText().trim();
			String welfareDeposit = mWelfareDepositValue.getText().trim();
			String miscDeposit = mMiscDepositValue.getText().trim();
			String loanIssued = mLoanIssuedValue.getText().trim();
			String miscPaymentIssued = mMiscAmountIssuedValue.getText().trim();
			String paymentMode = String.valueOf(mPaymentModeValue.getSelectedIndex());
			String remarks = mRemarksValue.getText().trim();

			ErrorReport validation = InputValidation.verifyTransactionDetails(accountNumber, cdDeposit, cdFineDeposit,
					loanInstallmentDeposit, loanInterestDeposit, loanFineDeposit, shareMoneyDeposit,
					admissionFeeDeposit, welfareDeposit, miscDeposit, loanIssued, miscPaymentIssued);
			if (!validation.valid) {
				AlertMessages.showErrorMessage(this, validation.errorMessage);
				return;
			}

			int result = dbHelper.addTransaction(accountNumber, dotYear + "-" + dotMonth + "-" + dotDate, cdDeposit,
					cdFineDeposit, loanInstallmentDeposit, loanInterestDeposit, loanFineDeposit, shareMoneyDeposit,
					admissionFeeDeposit, welfareDeposit, miscDeposit, loanIssued, miscPaymentIssued, paymentMode,
					remarks);

			if (result == 1) {
				int requiredPrint = AlertMessages.showConfirmMessage(this, "Transaction Added!\nDo You Want To Print?");
				if (requiredPrint == 0) {
					String transactionId = dbHelper.getLastTransactionId(accountNumber);
					if (transactionId == null || !Printer.printTransaction(accountNumber, transactionId, this)) {
						AlertMessages.showSystemErrorMessage(this);
					} else {
						AlertMessages.showAlertMessage(this, "Receipt Generated!");
					}
				}
				mClear.doClick();
			} else {
				AlertMessages.showSystemErrorMessage(this);
			}

		} else if (e.getSource() == mGetPaymentDetails) {
			String accountNumber = mAccountNumberValue.getText().trim();

			if (!dbHelper.checkAccountNumberExist(accountNumber)) {
				AlertMessages.showErrorMessage(this, "Account Number Does Not Exists");
				mClear.doClick();
				return;
			}

			Map<String, String> values = dbHelper.getPendingPayments(accountNumber);
			if (values == null) {
				AlertMessages.showSystemErrorMessage(this);
				mClear.doClick();
				return;
			}

			mCdDepositValue.setText(values.get("cd_pending"));
			mCdFineDepositValue.setText(values.get("cd_fine"));
			mLoanInterestDepositValue.setText(values.get("loan_interest"));
			mLoanFineDepositValue.setText(values.get("loan_fine"));
		} else if (e.getSource() == mClear) {
			mAccountNumberValue.setText("");
			mDotDate.setSelectedIndex(UiConstants.DateConstants.getCurrentDateIdx());
			mDotMonth.setSelectedIndex(UiConstants.DateConstants.getCurrentMonthIdx());
			mDotYear.setSelectedIndex(UiConstants.DateConstants.getCurrentYearIdx());
			mCdDepositValue.setText("0");
			mCdFineDepositValue.setText("0");
			mLoanInstallmentDepositValue.setText("0");
			mLoanInterestDepositValue.setText("0");
			mLoanFineDepositValue.setText("0");
			mShareMoneyDepositValue.setText("0");
			mAdmissionFeeDepositValue.setText("0");
			mWelfareDepositValue.setText("0");
			mMiscDepositValue.setText("0");
			mLoanIssuedValue.setText("0");
			mMiscAmountIssuedValue.setText("0");
			mPaymentModeValue.setSelectedIndex(0);
			mRemarksValue.setText("");
		}
	}
}
