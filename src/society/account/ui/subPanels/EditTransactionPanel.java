package society.account.ui.subPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import society.account.database.DatabaseHelper;
import society.account.logger.Log;
import society.account.ui.AlertMessages;
import society.account.ui.InputValidation;
import society.account.ui.InputValidation.ErrorReport;
import society.account.ui.UiConstants;

@SuppressWarnings("serial")
public class EditTransactionPanel extends JPanel implements ActionListener {
	private static final String TAG = "EditTransactionPanel";

	private int mWidth = UiConstants.DimensionConstants.DEFAULT_WIDTH;
	private int mHeight = UiConstants.DimensionConstants.DEFAULT_HEIGHT;
	private int mInitialSpacing = UiConstants.DimensionConstants.DEFAULT_INITIAL_SPACING;
	private int mVerticalSpacing = UiConstants.DimensionConstants.DEFAULT_VERTICAL_SPACING;
	private int mHorizontalSpacing = UiConstants.DimensionConstants.DEFAULT_HORIZONTAL_SPACING;
	private int mComboBoxWidth = UiConstants.DimensionConstants.DEFAULT_COMBO_BOX_DATE_WIDTH;

	private JTextField mSearchTransactionNumber;
	private JButton mSearchTransactionNumberSubmit;
	private JLabel mTransactionNumberLabel;
	private JTextField mTransactionNumberValue;
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

	private final DatabaseHelper dbHelper = new DatabaseHelper();

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

		mTransactionNumberLabel = new JLabel("Transaction Number");
		mTransactionNumberLabel.setSize(mWidth, mHeight);
		mTransactionNumberLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing);
		add(mTransactionNumberLabel);

		mTransactionNumberValue = new JTextField();
		mTransactionNumberValue.setSize(mWidth, mHeight);
		mTransactionNumberValue.setEditable(false);
		mTransactionNumberValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing);
		add(mTransactionNumberValue);

		mAccountNumberLabel = new JLabel("Account Number");
		mAccountNumberLabel.setSize(mWidth, mHeight);
		mAccountNumberLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 2);
		add(mAccountNumberLabel);

		mAccountNumberValue = new JTextField();
		mAccountNumberValue.setSize(mWidth, mHeight);
		mAccountNumberValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 2);
		add(mAccountNumberValue);

		mDotLabel = new JLabel("Date of Transaction");
		mDotLabel.setSize(mWidth, mHeight);
		mDotLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 3);
		add(mDotLabel);

		mDotDate = new JComboBox<>(UiConstants.DateConstants.DATES);
		mDotDate.setSize(mComboBoxWidth, mHeight);
		mDotDate.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 3);
		mDotDate.setSelectedIndex(UiConstants.DateConstants.getCurrentDateIdx());
		add(mDotDate);

		mDotMonth = new JComboBox<>(UiConstants.DateConstants.MONTHS);
		mDotMonth.setSize(mComboBoxWidth, mHeight);
		mDotMonth.setLocation(mHorizontalSpacing + mInitialSpacing + mComboBoxWidth,
				mInitialSpacing + mVerticalSpacing * 3);
		mDotMonth.setSelectedIndex(UiConstants.DateConstants.getCurrentMonthIdx());
		add(mDotMonth);

		mDotYear = new JComboBox<>(UiConstants.DateConstants.YEARS);
		mDotYear.setSize(mComboBoxWidth, mHeight);
		mDotYear.setLocation(mHorizontalSpacing + (mInitialSpacing + mComboBoxWidth) * 2,
				mInitialSpacing + mVerticalSpacing * 3);
		mDotYear.setSelectedIndex(UiConstants.DateConstants.getCurrentYearIdx());
		add(mDotYear);

		mCdDepositLabel = new JLabel("Compulsory Deposit");
		mCdDepositLabel.setSize(mWidth, mHeight);
		mCdDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 4);
		add(mCdDepositLabel);

		mCdDepositValue = new JTextField();
		mCdDepositValue.setSize(mWidth, mHeight);
		mCdDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 4);
		add(mCdDepositValue);

		mCdFineDepositLabel = new JLabel("Compulsory Deposit Fine");
		mCdFineDepositLabel.setSize(mWidth, mHeight);
		mCdFineDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 5);
		add(mCdFineDepositLabel);

		mCdFineDepositValue = new JTextField();
		mCdFineDepositValue.setSize(mWidth, mHeight);
		mCdFineDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 5);
		add(mCdFineDepositValue);

		mLoanInstallmentDepositLabel = new JLabel("Loan Installment Deposit");
		mLoanInstallmentDepositLabel.setSize(mWidth, mHeight);
		mLoanInstallmentDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 6);
		add(mLoanInstallmentDepositLabel);

		mLoanInstallmentDepositValue = new JTextField();
		mLoanInstallmentDepositValue.setSize(mWidth, mHeight);
		mLoanInstallmentDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 6);
		add(mLoanInstallmentDepositValue);

		mLoanInterestDepositLabel = new JLabel("Loan Interest Deposit");
		mLoanInterestDepositLabel.setSize(mWidth, mHeight);
		mLoanInterestDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 7);
		add(mLoanInterestDepositLabel);

		mLoanInterestDepositValue = new JTextField();
		mLoanInterestDepositValue.setSize(mWidth, mHeight);
		mLoanInterestDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 7);
		add(mLoanInterestDepositValue);

		mLoanFineDepositLabel = new JLabel("Loan Fine Deposit");
		mLoanFineDepositLabel.setSize(mWidth, mHeight);
		mLoanFineDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 8);
		add(mLoanFineDepositLabel);

		mLoanFineDepositValue = new JTextField();
		mLoanFineDepositValue.setSize(mWidth, mHeight);
		mLoanFineDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 8);
		add(mLoanFineDepositValue);

		mShareMoneyDepositLabel = new JLabel("Share Money Deposit");
		mShareMoneyDepositLabel.setSize(mWidth, mHeight);
		mShareMoneyDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 9);
		add(mShareMoneyDepositLabel);

		mShareMoneyDepositValue = new JTextField();
		mShareMoneyDepositValue.setSize(mWidth, mHeight);
		mShareMoneyDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 9);
		add(mShareMoneyDepositValue);

		mAdmissionFeeDepositLabel = new JLabel("Admission Fee Deposit");
		mAdmissionFeeDepositLabel.setSize(mWidth, mHeight);
		mAdmissionFeeDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 10);
		add(mAdmissionFeeDepositLabel);

		mAdmissionFeeDepositValue = new JTextField();
		mAdmissionFeeDepositValue.setSize(mWidth, mHeight);
		mAdmissionFeeDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 10);
		add(mAdmissionFeeDepositValue);

		mWelfareDepositLabel = new JLabel("Welfare Deposit");
		mWelfareDepositLabel.setSize(mWidth, mHeight);
		mWelfareDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 11);
		add(mWelfareDepositLabel);

		mWelfareDepositValue = new JTextField();
		mWelfareDepositValue.setSize(mWidth, mHeight);
		mWelfareDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 11);
		add(mWelfareDepositValue);

		mMiscDepositLabel = new JLabel("Miscellaneous Deposit");
		mMiscDepositLabel.setSize(mWidth, mHeight);
		mMiscDepositLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 12);
		add(mMiscDepositLabel);

		mMiscDepositValue = new JTextField();
		mMiscDepositValue.setSize(mWidth, mHeight);
		mMiscDepositValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 12);
		add(mMiscDepositValue);

		mLoanIssuedLabel = new JLabel("Loan Issued");
		mLoanIssuedLabel.setSize(mWidth, mHeight);
		mLoanIssuedLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 13);
		add(mLoanIssuedLabel);

		mLoanIssuedValue = new JTextField();
		mLoanIssuedValue.setSize(mWidth, mHeight);
		mLoanIssuedValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 13);
		add(mLoanIssuedValue);

		mMiscAmountIssuedLabel = new JLabel("Miscellaneous Amount Issued");
		mMiscAmountIssuedLabel.setSize(mWidth, mHeight);
		mMiscAmountIssuedLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 14);
		add(mMiscAmountIssuedLabel);

		mMiscAmountIssuedValue = new JTextField();
		mMiscAmountIssuedValue.setSize(mWidth, mHeight);
		mMiscAmountIssuedValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 14);
		add(mMiscAmountIssuedValue);

		mPaymentModeLabel = new JLabel("Payment Mode");
		mPaymentModeLabel.setSize(mWidth, mHeight);
		mPaymentModeLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 15);
		add(mPaymentModeLabel);

		mPaymentModeValue = new JComboBox<>(UiConstants.PaymentModeConstants.PAYMENT_MODES);
		mPaymentModeValue.setSize(90, mHeight);
		mPaymentModeValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 15);
		add(mPaymentModeValue);

		mRemarksLabel = new JLabel("Remarks");
		mRemarksLabel.setSize(mWidth, mHeight);
		mRemarksLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 16);
		add(mRemarksLabel);

		mRemarksValue = new JTextField();
		mRemarksValue.setSize(mWidth, mHeight);
		mRemarksValue.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing * 16);
		add(mRemarksValue);

		mSubmit = new JButton("Submit");
		mSubmit.setSize(100, mHeight);
		mSubmit.setLocation(300, mInitialSpacing + mVerticalSpacing * 17);
		mSubmit.addActionListener(this);
		add(mSubmit);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mSearchTransactionNumberSubmit) {
			String transactionNumber = mSearchTransactionNumber.getText().trim();
			Log.d(TAG, "Edit transaction " + transactionNumber);
			if (transactionNumber.isEmpty()) {
				clearFields();
				return;
			}

			if (!dbHelper.checkTransactionNumberValid(transactionNumber)) {
				AlertMessages.showAlertMessage(this, "Transaction Number Does Not Exists");
				clearFields();
				Log.d(TAG, "Transaction does not exists");
				return;
			}

			Map<String, String> values = dbHelper.getTransactionInfo(transactionNumber);
			if (values == null) {
				AlertMessages.showSystemErrorMessage(this);
				clearFields();
				Log.e(TAG, "Can not get transaction info");
				return;
			}

			mTransactionNumberValue.setText(transactionNumber);
			mAccountNumberValue.setText(values.get("account_number"));
			String[] dot = values.get("date_of_transaction").split("-");
			mDotYear.setSelectedIndex(UiConstants.DateConstants.INDEX_OF_YEARS.get(dot[0]));
			mDotMonth.setSelectedIndex(UiConstants.DateConstants.INDEX_OF_MONTHS.get(dot[1]));
			mDotDate.setSelectedIndex(UiConstants.DateConstants.INDEX_OF_DATES.get(dot[2]));
			mCdDepositValue.setText(values.get("compulsory_deposit"));
			mCdFineDepositValue.setText(values.get("cd_fine_deposit"));
			mLoanInstallmentDepositValue.setText(values.get("loan_installment_deposit"));
			mLoanInterestDepositValue.setText(values.get("loan_interest_deposit"));
			mLoanFineDepositValue.setText(values.get("loan_fine_deposit"));
			mShareMoneyDepositValue.setText(values.get("share_money_deposit"));
			mAdmissionFeeDepositValue.setText(values.get("admission_fee_deposit"));
			mWelfareDepositValue.setText(values.get("welfare_deposit"));
			mMiscDepositValue.setText(values.get("misc_deposit"));
			mLoanIssuedValue.setText(values.get("loan_issued"));
			mMiscAmountIssuedValue.setText(values.get("misc_amount_issued"));
			mPaymentModeValue.setSelectedIndex(Integer.parseInt(values.get("payment_mode")));
			mRemarksValue.setText(values.get("remarks"));
		} else if (e.getSource() == mSubmit) {
			String transactionNumber = mTransactionNumberValue.getText().trim();
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
			Log.d(TAG, "Edit transaction", accountNumber, dotYear, dotMonth, dotDate, cdDeposit, cdFineDeposit,
					loanInstallmentDeposit, loanInterestDeposit, loanFineDeposit, shareMoneyDeposit,
					admissionFeeDeposit, welfareDeposit, miscDeposit, loanIssued, miscPaymentIssued, paymentMode,
					remarks);

			ErrorReport validation = InputValidation.verifyTransactionDetails(accountNumber,
					dotYear + "-" + dotMonth + "-" + dotDate, cdDeposit, cdFineDeposit, loanInstallmentDeposit,
					loanInterestDeposit, loanFineDeposit, shareMoneyDeposit, admissionFeeDeposit, welfareDeposit,
					miscDeposit, loanIssued, miscPaymentIssued);
			if (!validation.valid) {
				AlertMessages.showErrorMessage(this, validation.errorMessage);
				Log.d(TAG, "Validation failed");
				return;
			}

			int result = dbHelper.updateTransaction(accountNumber, dotYear + "-" + dotMonth + "-" + dotDate, cdDeposit,
					cdFineDeposit, loanInstallmentDeposit, loanInterestDeposit, loanFineDeposit, shareMoneyDeposit,
					admissionFeeDeposit, welfareDeposit, miscDeposit, loanIssued, miscPaymentIssued, paymentMode,
					remarks, transactionNumber);

			if (result == 1) {
				AlertMessages.showAlertMessage(this, "Transaction Information Updated!");
				clearFields();
				Log.d(TAG, "Transaction updated");
			} else {
				AlertMessages.showSystemErrorMessage(this);
				Log.e(TAG, "Can not update transsaction. Result: " + result);
			}
		}
	}

	private void clearFields() {
		mSearchTransactionNumber.setText("ENTER TRANSACTION NUMBER");
		mTransactionNumberValue.setText("");
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
