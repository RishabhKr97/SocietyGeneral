package society.account.ui.subPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import society.account.database.DatabaseHelper;
import society.account.logger.Log;
import society.account.ui.AlertMessages;
import society.account.ui.UiConstants;

@SuppressWarnings("serial")
public class DeleteRestoreUserPanel extends JPanel implements ActionListener {
	private static final String TAG = "DeleteRestoreUserPanel";

	private int mWidth = UiConstants.DimensionConstants.DEFAULT_WIDTH;
	private int mHeight = UiConstants.DimensionConstants.DEFAULT_HEIGHT;
	private int mInitialSpacing = UiConstants.DimensionConstants.DEFAULT_INITIAL_SPACING;
	private int mVerticalSpacing = UiConstants.DimensionConstants.DEFAULT_VERTICAL_SPACING;
	private int mHorizontalSpacing = UiConstants.DimensionConstants.DEFAULT_HORIZONTAL_SPACING;

	private JLabel mRemoveMemberLabel;
	private JTextField mRemoveAccountNumber;
	private JButton mRemoveMemberSubmit;
	private JLabel mRestoreMemberLabel;
	private JTextField mRestoreAccountNumber;
	private JButton mRestoreMemberSubmit;

	private final DatabaseHelper dbHelper = new DatabaseHelper();

	public DeleteRestoreUserPanel() {
		setLayout(null);

		mRemoveMemberLabel = new JLabel("Remove Member");
		mRemoveMemberLabel.setSize(mWidth, mHeight);
		mRemoveMemberLabel.setLocation(mInitialSpacing, mInitialSpacing);
		add(mRemoveMemberLabel);

		mRemoveAccountNumber = new JTextField();
		mRemoveAccountNumber.setSize(mWidth, mHeight);
		mRemoveAccountNumber.setLocation(mHorizontalSpacing, mInitialSpacing);
		add(mRemoveAccountNumber);

		mRemoveMemberSubmit = new JButton("Submit");
		mRemoveMemberSubmit.setSize(100, mHeight);
		mRemoveMemberSubmit.setLocation(mHorizontalSpacing * 2, mInitialSpacing);
		mRemoveMemberSubmit.addActionListener(this);
		add(mRemoveMemberSubmit);

		mRestoreMemberLabel = new JLabel("Restore Member");
		mRestoreMemberLabel.setSize(mWidth, mHeight);
		mRestoreMemberLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing);
		add(mRestoreMemberLabel);

		mRestoreAccountNumber = new JTextField();
		mRestoreAccountNumber.setSize(mWidth, mHeight);
		mRestoreAccountNumber.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing);
		add(mRestoreAccountNumber);

		mRestoreMemberSubmit = new JButton("Submit");
		mRestoreMemberSubmit.setSize(100, mHeight);
		mRestoreMemberSubmit.setLocation(mHorizontalSpacing * 2, mInitialSpacing + mVerticalSpacing);
		mRestoreMemberSubmit.addActionListener(this);
		add(mRestoreMemberSubmit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mRemoveMemberSubmit) {
			String accountNumber = mRemoveAccountNumber.getText().trim();
			Log.d(TAG, "Remove account " + accountNumber);
			if (accountNumber.isEmpty()) {
				return;
			}

			if (!dbHelper.checkAccountNumberActive(accountNumber)) {
				AlertMessages.showAlertMessage(this, "Account Number Does Not Exists");
				mRemoveAccountNumber.setText("");
				Log.d(TAG, "Inactive account " + accountNumber);
				return;
			}

			if (AlertMessages.showConfirmMessage(this, "Remove Member From Society?") != 0) {
				mRemoveAccountNumber.setText("");
				return;
			}

			if (dbHelper.removeUser(accountNumber) != 1) {
				AlertMessages.showSystemErrorMessage(this);
				mRemoveAccountNumber.setText("");
				Log.e(TAG, "Remove account failed");
				return;
			}

			AlertMessages.showAlertMessage(this, "Member Removed From Society");
			mRemoveAccountNumber.setText("");
			Log.d(TAG, "Remove account success");
		} else if (e.getSource() == mRestoreMemberSubmit) {
			String accountNumber = mRestoreAccountNumber.getText().trim();
			Log.d(TAG, "Restore account " + accountNumber);
			if (accountNumber.isEmpty()) {
				return;
			}

			if (!dbHelper.checkAccountNumberDeleted(accountNumber)) {
				AlertMessages.showAlertMessage(this, "Account Number Was Not Deleted");
				mRestoreAccountNumber.setText("");
				Log.d(TAG, "Account not deleted");
				return;
			}

			if (AlertMessages.showConfirmMessage(this, "Add Member Back To Society?") != 0) {
				mRestoreAccountNumber.setText("");
				return;
			}

			if (dbHelper.restoreUser(accountNumber) != 1) {
				AlertMessages.showSystemErrorMessage(this);
				mRestoreAccountNumber.setText("");
				Log.e(TAG, "Restore account failed");
				return;
			}

			AlertMessages.showAlertMessage(this, "Member Added Back To Society");
			mRestoreAccountNumber.setText("");
			Log.d(TAG, "Restore account success");
		}
	}
}
