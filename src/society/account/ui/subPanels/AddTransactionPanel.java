package society.account.ui.subPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import society.account.ui.DateConstants;

@SuppressWarnings("serial")
public class AddTransactionPanel extends JPanel implements ActionListener {

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
	private JLabel mMiscPaymentIssuedLabel;
	private JTextField mMiscPaymentIssuedValue;
	private JLabel mPaymentModeLabel;
	private JComboBox<String> mPaymentModeValue;
	private JLabel mRemarksLabel;
	private JTextField mRemarksValue;
	private JButton mSubmit;
	private JButton mClear;

	public AddTransactionPanel() {
		setLayout(null);

		mAccountNumberLabel = new JLabel("Account Number");
		mAccountNumberLabel.setSize(180, 20);
		mAccountNumberLabel.setLocation(5, 10);
		add(mAccountNumberLabel);

		mAccountNumberValue = new JTextField();
		mAccountNumberValue.setSize(180, 20);
		mAccountNumberValue.setLocation(200, 10);
		add(mAccountNumberValue);

		mGetPaymentDetails = new JButton("Get Details");
		mGetPaymentDetails.setSize(100, 20);
		mGetPaymentDetails.setLocation(400, 10);
		mGetPaymentDetails.addActionListener(this);
		add(mGetPaymentDetails);

		mDotLabel = new JLabel("Date of Transaction");
		mDotLabel.setSize(180, 20);
		mDotLabel.setLocation(5, 40);
		add(mDotLabel);

		mDotDate = new JComboBox<>(DateConstants.DATES);
		mDotDate.setSize(52, 20);
		mDotDate.setLocation(200, 40);
		mDotDate.setSelectedIndex(DateConstants.getCurrentDateIdx());
		add(mDotDate);

		mDotMonth = new JComboBox<>(DateConstants.MONTHS);
		mDotMonth.setSize(52, 20);
		mDotMonth.setLocation(264, 40);
		mDotMonth.setSelectedIndex(DateConstants.getCurrentMonthIdx());
		add(mDotMonth);

		mDotYear = new JComboBox<>(DateConstants.YEARS);
		mDotYear.setSize(52, 20);
		mDotYear.setLocation(328, 40);
		mDotYear.setSelectedIndex(DateConstants.getCurrentYearIdx());
		add(mDotYear);

		mCdDepositLabel = new JLabel("Compulsory Deposit");
		mCdDepositLabel.setSize(180, 20);
		mCdDepositLabel.setLocation(5, 70);
		add(mCdDepositLabel);

		mCdDepositValue = new JTextField();
		mCdDepositValue.setSize(180, 20);
		mCdDepositValue.setLocation(200, 70);
		add(mCdDepositValue);

		mCdFineDepositLabel = new JLabel("Compulsory Deposit Fine");
		mCdFineDepositLabel.setSize(180, 20);
		mCdFineDepositLabel.setLocation(5, 100);
		add(mCdFineDepositLabel);

		mCdFineDepositValue = new JTextField();
		mCdFineDepositValue.setSize(180, 20);
		mCdFineDepositValue.setLocation(200, 100);
		add(mCdFineDepositValue);

		mLoanInstallmentDepositLabel = new JLabel("Loan Installment Deposit");
		mLoanInstallmentDepositLabel.setSize(180, 20);
		mLoanInstallmentDepositLabel.setLocation(5, 130);
		add(mLoanInstallmentDepositLabel);

		mLoanInstallmentDepositValue = new JTextField();
		mLoanInstallmentDepositValue.setSize(180, 20);
		mLoanInstallmentDepositValue.setLocation(200, 130);
		add(mLoanInstallmentDepositValue);

		mLoanInterestDepositLabel = new JLabel("Loan Interest Deposit");
		mLoanInterestDepositLabel.setSize(180, 20);
		mLoanInterestDepositLabel.setLocation(5, 160);
		add(mLoanInterestDepositLabel);

		mLoanInterestDepositValue = new JTextField();
		mLoanInterestDepositValue.setSize(180, 20);
		mLoanInterestDepositValue.setLocation(200, 160);
		add(mLoanInterestDepositValue);

		mLoanFineDepositLabel = new JLabel("Loan Fine Deposit");
		mLoanFineDepositLabel.setSize(180, 20);
		mLoanFineDepositLabel.setLocation(5, 190);
		add(mLoanFineDepositLabel);

		mLoanFineDepositValue = new JTextField();
		mLoanFineDepositValue.setSize(180, 20);
		mLoanFineDepositValue.setLocation(200, 190);
		add(mLoanFineDepositValue);

		mShareMoneyDepositLabel = new JLabel("Share Money Deposit");
		mShareMoneyDepositLabel.setSize(180, 20);
		mShareMoneyDepositLabel.setLocation(5, 220);
		add(mShareMoneyDepositLabel);

		mShareMoneyDepositValue = new JTextField();
		mShareMoneyDepositValue.setSize(180, 20);
		mShareMoneyDepositValue.setLocation(200, 220);
		add(mShareMoneyDepositValue);

		mAdmissionFeeDepositLabel = new JLabel("Admission Fee Deposit");
		mAdmissionFeeDepositLabel.setSize(180, 20);
		mAdmissionFeeDepositLabel.setLocation(5, 250);
		add(mAdmissionFeeDepositLabel);

		mAdmissionFeeDepositValue = new JTextField();
		mAdmissionFeeDepositValue.setSize(180, 20);
		mAdmissionFeeDepositValue.setLocation(200, 250);
		add(mAdmissionFeeDepositValue);

		mWelfareDepositLabel = new JLabel("Welfare Deposit");
		mWelfareDepositLabel.setSize(180, 20);
		mWelfareDepositLabel.setLocation(5, 280);
		add(mWelfareDepositLabel);

		mWelfareDepositValue = new JTextField();
		mWelfareDepositValue.setSize(180, 20);
		mWelfareDepositValue.setLocation(200, 280);
		add(mWelfareDepositValue);

		mMiscDepositLabel = new JLabel("Miscellaneous Deposit");
		mMiscDepositLabel.setSize(180, 20);
		mMiscDepositLabel.setLocation(5, 310);
		add(mMiscDepositLabel);

		mMiscDepositValue = new JTextField();
		mMiscDepositValue.setSize(180, 20);
		mMiscDepositValue.setLocation(200, 310);
		add(mMiscDepositValue);

		mLoanIssuedLabel = new JLabel("Loan Issued");
		mLoanIssuedLabel.setSize(180, 20);
		mLoanIssuedLabel.setLocation(5, 340);
		add(mLoanIssuedLabel);

		mLoanIssuedValue = new JTextField();
		mLoanIssuedValue.setSize(180, 20);
		mLoanIssuedValue.setLocation(200, 340);
		add(mLoanIssuedValue);

		mMiscPaymentIssuedLabel = new JLabel("Miscellaneous Payment Issued");
		mMiscPaymentIssuedLabel.setSize(180, 20);
		mMiscPaymentIssuedLabel.setLocation(5, 370);
		add(mMiscPaymentIssuedLabel);

		mMiscPaymentIssuedValue = new JTextField();
		mMiscPaymentIssuedValue.setSize(180, 20);
		mMiscPaymentIssuedValue.setLocation(200, 370);
		add(mMiscPaymentIssuedValue);

		mPaymentModeLabel = new JLabel("Payment Mode");
		mPaymentModeLabel.setSize(180, 20);
		mPaymentModeLabel.setLocation(5, 400);
		add(mPaymentModeLabel);

		mPaymentModeValue = new JComboBox<>(DateConstants.DATES);
		mPaymentModeValue.setSize(52, 20);
		mPaymentModeValue.setLocation(200, 400);
		add(mPaymentModeValue);

		mRemarksLabel = new JLabel("Remarks");
		mRemarksLabel.setSize(180, 20);
		mRemarksLabel.setLocation(5, 430);
		add(mRemarksLabel);

		mRemarksValue = new JTextField();
		mRemarksValue.setSize(180, 20);
		mRemarksValue.setLocation(200, 430);
		add(mRemarksValue);

		mSubmit = new JButton("Submit");
		mSubmit.setSize(80, 20);
		mSubmit.setLocation(100, 480);
		mSubmit.addActionListener(this);
		add(mSubmit);

		mClear = new JButton("Clear");
		mClear.setSize(80, 20);
		mClear.setLocation(205, 480);
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
			String miscPaymentIssued = mMiscPaymentIssuedValue.getText().trim();
			String paymentMode = (String) mPaymentModeValue.getSelectedItem();
			String remarks = mRemarksValue.getText().trim();

			if (!verifyInput(accountNumber, cdDeposit, cdFineDeposit, loanInstallmentDeposit, loanInterestDeposit,
					loanFineDeposit, shareMoneyDeposit, admissionFeeDeposit, welfareDeposit, miscDeposit, loanIssued,
					miscPaymentIssued)) {
				return;
			}

		} else if (e.getSource() == mClear) {
			mAccountNumberValue.setText("");
			mDotDate.setSelectedIndex(DateConstants.getCurrentDateIdx());
			mDotMonth.setSelectedIndex(DateConstants.getCurrentMonthIdx());
			mDotYear.setSelectedIndex(DateConstants.getCurrentYearIdx());
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
			mMiscPaymentIssuedValue.setText("0");
			mPaymentModeValue.setSelectedIndex(0);
			mRemarksValue.setText("");
		}
	}

	private boolean verifyInput(String accNum, String cd, String cdFine, String loanInstallment, String loanInst,
			String loanFine, String shareMoney, String admFee, String welfareDep, String miscDep, String loanIssue,
			String miscIssue) {
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

		try {
			if (Integer.parseInt(cd) < 0) {
				mCdDepositValue.setText("Invalid Value");
				return false;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			mCdDepositValue.setText("Invalid Value");
			return false;
		}

		try {
			if (Integer.parseInt(cdFine) < 0) {
				mCdFineDepositValue.setText("Invalid Value");
				return false;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			mCdFineDepositValue.setText("Invalid Value");
			return false;
		}

		try {
			if (Integer.parseInt(loanInstallment) < 0) {
				mLoanInstallmentDepositValue.setText("Invalid Value");
				return false;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			mLoanInstallmentDepositValue.setText("Invalid Value");
			return false;
		}

		try {
			if (Integer.parseInt(loanInst) < 0) {
				mLoanInterestDepositValue.setText("Invalid Value");
				return false;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			mLoanInterestDepositValue.setText("Invalid Value");
			return false;
		}

		try {
			if (Integer.parseInt(loanFine) < 0) {
				mLoanFineDepositValue.setText("Invalid Value");
				return false;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			mLoanFineDepositValue.setText("Invalid Value");
			return false;
		}

		try {
			if (Integer.parseInt(shareMoney) < 0) {
				mShareMoneyDepositValue.setText("Invalid Value");
				return false;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			mShareMoneyDepositValue.setText("Invalid Value");
			return false;
		}

		try {
			if (Integer.parseInt(admFee) < 0) {
				mAdmissionFeeDepositValue.setText("Invalid Value");
				return false;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			mAdmissionFeeDepositValue.setText("Invalid Value");
			return false;
		}

		try {
			if (Integer.parseInt(welfareDep) < 0) {
				mWelfareDepositValue.setText("Invalid Value");
				return false;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			mWelfareDepositValue.setText("Invalid Value");
			return false;
		}

		try {
			if (Integer.parseInt(miscDep) < 0) {
				mMiscDepositValue.setText("Invalid Value");
				return false;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			mMiscDepositValue.setText("Invalid Value");
			return false;
		}

		try {
			if (Integer.parseInt(loanIssue) < 0) {
				mLoanIssuedValue.setText("Invalid Value");
				return false;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			mLoanIssuedValue.setText("Invalid Value");
			return false;
		}

		try {
			if (Integer.parseInt(miscIssue) < 0) {
				mMiscPaymentIssuedValue.setText("Invalid Value");
				return false;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			mMiscPaymentIssuedValue.setText("Invalid Value");
			return false;
		}

		return true;
	}
}
