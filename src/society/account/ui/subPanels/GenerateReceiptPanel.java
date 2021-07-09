package society.account.ui.subPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import society.account.database.DatabaseHelper;
import society.account.logger.Log;
import society.account.receipt.printmanager.Printer;
import society.account.ui.AlertMessages;
import society.account.ui.UiConstants;

@SuppressWarnings("serial")
public class GenerateReceiptPanel extends JPanel implements ActionListener {
	private static final String TAG = "GenerateReceiptPanel";

	private int mWidth = UiConstants.DimensionConstants.DEFAULT_WIDTH;
	private int mHeight = UiConstants.DimensionConstants.DEFAULT_HEIGHT;
	private int mInitialSpacing = UiConstants.DimensionConstants.DEFAULT_INITIAL_SPACING;
	private int mHorizontalSpacing = UiConstants.DimensionConstants.DEFAULT_HORIZONTAL_SPACING;

	private JLabel mTransactionNumberLabel;
	private JTextField mTransactionNumberValue;
	private JButton mSubmit;

	private final DatabaseHelper dbHelper = new DatabaseHelper();

	public GenerateReceiptPanel() {
		setLayout(null);

		mTransactionNumberLabel = new JLabel("Enter Transaction Number");
		mTransactionNumberLabel.setSize(mWidth, mHeight);
		mTransactionNumberLabel.setLocation(mInitialSpacing, mInitialSpacing);
		add(mTransactionNumberLabel);

		mTransactionNumberValue = new JTextField();
		mTransactionNumberValue.setSize(mWidth, mHeight);
		mTransactionNumberValue.setLocation(mHorizontalSpacing, mInitialSpacing);
		add(mTransactionNumberValue);

		mSubmit = new JButton("Generate Receipt");
		mSubmit.setSize(200, mHeight);
		mSubmit.setLocation(mHorizontalSpacing * 2, mInitialSpacing);
		mSubmit.addActionListener(this);
		add(mSubmit);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mSubmit) {
			String transactionNum = mTransactionNumberValue.getText().trim();
			Log.d(TAG, "Generate receipt for " + transactionNum);

			if (!dbHelper.checkTransactionNumberValid(transactionNum)) {
				AlertMessages.showAlertMessage(this, "Transaction Number Does Not Exist");
				mTransactionNumberValue.setText("");
				Log.d(TAG, "Transaction not found");
				return;
			}

			Map<String, String> values = dbHelper.getTransactionInfo(transactionNum);
			if (values == null || !Printer.printTransaction(values.get("account_number"), transactionNum, this)) {
				AlertMessages.showSystemErrorMessage(this);
				mTransactionNumberValue.setText("");
				Log.e(TAG, "Can not generate receipt");
				return;
			}

			Log.d(TAG, "Receipt generated");
			mTransactionNumberValue.setText("");
			AlertMessages.showAlertMessage(this, "Receipt Generated!");
		}
	}

}
