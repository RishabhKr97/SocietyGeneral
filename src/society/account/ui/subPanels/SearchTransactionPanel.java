package society.account.ui.subPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import society.account.database.DatabaseHelper;
import society.account.logger.Log;
import society.account.ui.AlertMessages;
import society.account.ui.UiConstants;

@SuppressWarnings("serial")
public class SearchTransactionPanel extends JPanel implements ActionListener {
	public static final String TAG = "SearchTransactionPanel";

	private int mWidth = UiConstants.DimensionConstants.DEFAULT_WIDTH;
	private int mHeight = UiConstants.DimensionConstants.DEFAULT_HEIGHT;
	private int mInitialSpacing = UiConstants.DimensionConstants.DEFAULT_INITIAL_SPACING;
	private int mVerticalSpacing = UiConstants.DimensionConstants.DEFAULT_VERTICAL_SPACING;
	private int mHorizontalSpacing = UiConstants.DimensionConstants.DEFAULT_HORIZONTAL_SPACING;
	private int mComboBoxWidth = UiConstants.DimensionConstants.DEFAULT_COMBO_BOX_DATE_WIDTH;

	private JLabel mAccountNumberLabel;
	private JTextField mAccountNumberValue;
	private JButton mSearchButton;
	private JLabel mDotLabel;
	private JComboBox<String> mDotDate;
	private JComboBox<String> mDotMonth;
	private JComboBox<String> mDotYear;
	private JScrollPane mTransactionPane;
	private JTable mTransactionTable;

	private final DatabaseHelper dbHelper = new DatabaseHelper();

	public SearchTransactionPanel() {
		setLayout(null);

		mAccountNumberLabel = new JLabel("Account Number");
		mAccountNumberLabel.setSize(mWidth, mHeight);
		mAccountNumberLabel.setLocation(mInitialSpacing, mInitialSpacing);
		add(mAccountNumberLabel);

		mAccountNumberValue = new JTextField();
		mAccountNumberValue.setSize(mWidth, mHeight);
		mAccountNumberValue.setLocation(mHorizontalSpacing, mInitialSpacing);
		add(mAccountNumberValue);

		mSearchButton = new JButton("Get Details");
		mSearchButton.setSize(125, mHeight);
		mSearchButton.setLocation(mHorizontalSpacing * 2, mInitialSpacing);
		mSearchButton.addActionListener(this);
		add(mSearchButton);

		mDotLabel = new JLabel("Date of Transaction");
		mDotLabel.setSize(mWidth, mHeight);
		mDotLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing);
		add(mDotLabel);

		mDotDate = new JComboBox<>(UiConstants.DateConstants.DATES_WITH_NA);
		mDotDate.setSize(mComboBoxWidth, mHeight);
		mDotDate.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing);
		add(mDotDate);

		mDotMonth = new JComboBox<>(UiConstants.DateConstants.MONTHS_WITH_NA);
		mDotMonth.setSize(mComboBoxWidth, mHeight);
		mDotMonth.setLocation(mHorizontalSpacing + mInitialSpacing + mComboBoxWidth,
				mInitialSpacing + mVerticalSpacing);
		add(mDotMonth);

		mDotYear = new JComboBox<>(UiConstants.DateConstants.YEARS_WITH_NA);
		mDotYear.setSize(mComboBoxWidth, mHeight);
		mDotYear.setLocation(mHorizontalSpacing + (mInitialSpacing + mComboBoxWidth) * 2,
				mInitialSpacing + mVerticalSpacing);
		add(mDotYear);

		mTransactionTable = new JTable(new DefaultTableModel(UiConstants.TableConstants.ROW_DEFAULTS,
				UiConstants.TableConstants.TRANSACTION_TABLE_COLUMN_NAMES));
		for (int column = 0; column < mTransactionTable.getColumnCount(); column++) {
			TableColumn tableColumn = mTransactionTable.getColumnModel().getColumn(column);
			tableColumn.setPreferredWidth(UiConstants.DimensionConstants.DEFAULT_TABLE_COLUMN_WIDTH);
			if (column == mTransactionTable.getColumnCount() - 1) {
				tableColumn.setPreferredWidth(UiConstants.DimensionConstants.DEFAULT_TABLE_COLUMN_WIDTH * 2);
			}
		}
		mTransactionTable.setRowHeight(mHeight + 2);
		mTransactionTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		mTransactionTable.getTableHeader().setReorderingAllowed(false);
		mTransactionTable.setEnabled(false);
		mTransactionPane = new JScrollPane(mTransactionTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mTransactionPane.setSize(800, 450);
		mTransactionPane.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 3);
		mTransactionPane.setVisible(true);
		add(mTransactionPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mSearchButton) {
			String accNum = mAccountNumberValue.getText().trim();
			String dotDate = (String) mDotDate.getSelectedItem();
			String dotMonth = (String) mDotMonth.getSelectedItem();
			String dotYear = (String) mDotYear.getSelectedItem();

			if (!dbHelper.checkAccountNumberExist(accNum)) {
				clearFields();
				AlertMessages.showAlertMessage(this, "Account Number Does Not Exists");
				Log.d(TAG, "Search transaction. Account number does not exists: " + accNum);
				return;
			}

			if (UiConstants.DateConstants.NA.equals(dotDate)) {
				dotDate = "%";
			}
			if (UiConstants.DateConstants.NA.equals(dotMonth)) {
				dotMonth = "%";
			}
			if (UiConstants.DateConstants.NA.equals(dotYear)) {
				dotYear = "%";
			}
			Log.d(TAG, "Search transaction", dotDate, dotMonth, dotYear, accNum);

			List<String[]> values = dbHelper.searchTransactionByDate(accNum, dotDate, dotMonth, dotYear);
			if (values == null || values.isEmpty()) {
				clearFields();
				AlertMessages.showErrorMessage(this, "Nothing To Display.");
				Log.d(TAG, "No transctions found");
				return;
			}
			
			Log.d(TAG, "Found: " + values.size());
			clearTable();
			DefaultTableModel tableModel = (DefaultTableModel) mTransactionTable.getModel();
			for (String[] row : values) {
				tableModel.addRow(row);
			}
		}
	}

	private void clearFields() {
		mAccountNumberValue.setText("");
		mDotDate.setSelectedIndex(0);
		mDotMonth.setSelectedIndex(0);
		mDotYear.setSelectedIndex(0);
		clearTable();
	}

	private void clearTable() {
		DefaultTableModel tableModel = (DefaultTableModel) mTransactionTable.getModel();
		tableModel.setRowCount(0);
	}
}
