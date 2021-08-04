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
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import society.account.database.DatabaseHelper;
import society.account.logger.Log;
import society.account.ui.AlertMessages;
import society.account.ui.UiConstants;
import society.account.ui.UiFontManager;

@SuppressWarnings("serial")
public class TransactionSummaryPanel extends JPanel implements ActionListener {
	private static final String TAG = "TransactionSummaryPanel";

	private int mWidth = UiConstants.DimensionConstants.DEFAULT_WIDTH;
	private int mHeight = UiConstants.DimensionConstants.DEFAULT_HEIGHT;
	private int mInitialSpacing = UiConstants.DimensionConstants.DEFAULT_INITIAL_SPACING;
	private int mVerticalSpacing = UiConstants.DimensionConstants.DEFAULT_VERTICAL_SPACING;
	private int mHorizontalSpacing = UiConstants.DimensionConstants.DEFAULT_HORIZONTAL_SPACING;
	private int mComboBoxWidth = UiConstants.DimensionConstants.DEFAULT_COMBO_BOX_DATE_WIDTH;

	private JLabel mDotLabel;
	private JButton mFind;
	private JComboBox<String> mDotDate;
	private JComboBox<String> mDotMonth;
	private JComboBox<String> mDotYear;
	private JLabel mSummaryLabel;
	private JScrollPane mSummaryPane;
	private JTable mSummaryTable;
	private JLabel mAllTransactionsLabel;
	private JScrollPane mTransactionPane;
	private JTable mTransactionTable;

	private final DatabaseHelper dbHelper = new DatabaseHelper();

	public TransactionSummaryPanel() {
		setLayout(null);

		mDotLabel = new JLabel("Summary Date");
		mDotLabel.setSize(mWidth, mHeight);
		mDotLabel.setLocation(mInitialSpacing, mInitialSpacing);
		add(mDotLabel);

		mDotDate = new JComboBox<>(UiConstants.DateConstants.DATES_WITH_NA);
		mDotDate.setSize(mComboBoxWidth, mHeight);
		mDotDate.setLocation(mHorizontalSpacing, mInitialSpacing);
		add(mDotDate);

		mDotMonth = new JComboBox<>(UiConstants.DateConstants.MONTHS_WITH_NA);
		mDotMonth.setSize(mComboBoxWidth, mHeight);
		mDotMonth.setLocation(mHorizontalSpacing + mInitialSpacing + mComboBoxWidth, mInitialSpacing);
		add(mDotMonth);

		mDotYear = new JComboBox<>(UiConstants.DateConstants.YEARS_WITH_NA);
		mDotYear.setSize(mComboBoxWidth, mHeight);
		mDotYear.setLocation(mHorizontalSpacing + (mInitialSpacing + mComboBoxWidth) * 2, mInitialSpacing);
		add(mDotYear);

		mFind = new JButton("Find");
		mFind.setSize(100, mHeight);
		mFind.setLocation(mHorizontalSpacing * 2, mInitialSpacing);
		mFind.addActionListener(this);
		add(mFind);

		mSummaryLabel = new JLabel("SUMMARY");
		mSummaryLabel.setSize(800, mHeight);
		mSummaryLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing);
		mSummaryLabel.setFont(UiFontManager.getLabelAsHeadingFont());
		mSummaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(mSummaryLabel);

		mSummaryTable = new JTable(new DefaultTableModel(UiConstants.TableConstants.ROW_DEFAULTS,
				UiConstants.TableConstants.SUMMARY_TABLE_COLUMN_NAMES));
		for (int column = 0; column < mSummaryTable.getColumnCount(); column++) {
			TableColumn tableColumn = mSummaryTable.getColumnModel().getColumn(column);
			tableColumn.setPreferredWidth(UiConstants.DimensionConstants.DEFAULT_TABLE_COLUMN_WIDTH + 12);
		}
		mSummaryTable.setRowHeight(mHeight + 2);
		mSummaryTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		mSummaryTable.getTableHeader().setReorderingAllowed(false);
		mSummaryTable.setEnabled(false);
		mSummaryPane = new JScrollPane(mSummaryTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mSummaryPane.setSize(800, 168);
		mSummaryPane.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 2);
		mSummaryPane.setVisible(true);
		add(mSummaryPane);

		mAllTransactionsLabel = new JLabel("ALL TRANSACTIONS");
		mAllTransactionsLabel.setSize(800, mHeight);
		mAllTransactionsLabel.setLocation(mInitialSpacing, (int) (mVerticalSpacing * 8.2));
		mAllTransactionsLabel.setFont(UiFontManager.getLabelAsHeadingFont());
		mAllTransactionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(mAllTransactionsLabel);

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
		mTransactionPane.setSize(800, 250);
		mTransactionPane.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 9);
		mTransactionPane.setVisible(true);
		add(mTransactionPane);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mFind) {
			String dotDate = (String) mDotDate.getSelectedItem();
			String dotMonth = (String) mDotMonth.getSelectedItem();
			String dotYear = (String) mDotYear.getSelectedItem();
			String accNum = "%";

			if (UiConstants.DateConstants.NA.equals(dotDate)) {
				dotDate = "%";
			}
			if (UiConstants.DateConstants.NA.equals(dotMonth)) {
				dotMonth = "%";
			}
			if (UiConstants.DateConstants.NA.equals(dotYear)) {
				dotYear = "%";
			}
			Log.d(TAG, "Find summary", dotDate, dotMonth, dotYear, accNum);

			List<String[]> values_transactions = dbHelper.searchTransactionByDate(accNum, dotDate, dotMonth, dotYear);
			List<String[]> values_summary = dbHelper.getTransactionSummaryByDate(dotDate, dotMonth, dotYear);
			if (values_transactions == null || values_transactions.isEmpty()) {
				clearFields();
				AlertMessages.showErrorMessage(this, "Nothing To Display.");
				Log.d(TAG, "No transactions found");
				return;
			}

			Log.d(TAG, "Found: " + values_transactions.size());
			Log.d(TAG, "Found: " + values_summary.size());
			clearTables();
			DefaultTableModel summaryTableModel = (DefaultTableModel) mSummaryTable.getModel();
			for (String[] row : values_summary) {
				summaryTableModel.addRow(row);
			}

			DefaultTableModel transactionTableModel = (DefaultTableModel) mTransactionTable.getModel();
			for (String[] row : values_transactions) {
				transactionTableModel.addRow(row);
			}
		}
	}

	private void clearFields() {
		mDotDate.setSelectedIndex(0);
		mDotMonth.setSelectedIndex(0);
		mDotYear.setSelectedIndex(0);
		clearTables();
	}

	private void clearTables() {
		DefaultTableModel transactionTableModel = (DefaultTableModel) mTransactionTable.getModel();
		transactionTableModel.setRowCount(0);

		DefaultTableModel summaryTableModel = (DefaultTableModel) mSummaryTable.getModel();
		summaryTableModel.setRowCount(0);
	}
}
