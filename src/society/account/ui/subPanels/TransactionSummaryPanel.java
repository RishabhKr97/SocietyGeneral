package society.account.ui.subPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import society.account.ui.UiConstants;
import society.account.ui.UiFontManager;

@SuppressWarnings("serial")
public class TransactionSummaryPanel extends JPanel implements ActionListener {

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

		mSummaryTable = new JTable(UiConstants.TableConstants.ROW_DEFAULTS,
				UiConstants.TableConstants.SUMMARY_TABLE_COLUMN_NAMES);
		for (int column = 0; column < mSummaryTable.getColumnCount(); column++) {
			TableColumn tableColumn = mSummaryTable.getColumnModel().getColumn(column);
			tableColumn.setPreferredWidth(UiConstants.DimensionConstants.DEFAULT_TABLE_COLUMN_WIDTH + 12);
		}
		mSummaryTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		mSummaryTable.getTableHeader().setReorderingAllowed(false);
		mSummaryTable.setEnabled(false);
		mSummaryPane = new JScrollPane(mSummaryTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mSummaryPane.setSize(800, 110);
		mSummaryPane.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 2);
		mSummaryPane.setVisible(true);
		add(mSummaryPane);

		mAllTransactionsLabel = new JLabel("ALL TRANSACTIONS");
		mAllTransactionsLabel.setSize(800, mHeight);
		mAllTransactionsLabel.setLocation(mInitialSpacing, mVerticalSpacing * 6);
		mAllTransactionsLabel.setFont(UiFontManager.getLabelAsHeadingFont());
		mAllTransactionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(mAllTransactionsLabel);

		mTransactionTable = new JTable(UiConstants.TableConstants.ROW_DEFAULTS,
				UiConstants.TableConstants.TRANSACTION_TABLE_COLUMN_NAMES);
		for (int column = 0; column < mTransactionTable.getColumnCount(); column++) {
			TableColumn tableColumn = mTransactionTable.getColumnModel().getColumn(column);
			tableColumn.setPreferredWidth(UiConstants.DimensionConstants.DEFAULT_TABLE_COLUMN_WIDTH);
			if (column == mTransactionTable.getColumnCount() - 1) {
				tableColumn.setPreferredWidth(UiConstants.DimensionConstants.DEFAULT_TABLE_COLUMN_WIDTH * 2);
			}
		}
		mTransactionTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		mTransactionTable.getTableHeader().setReorderingAllowed(false);
		mTransactionTable.setEnabled(false);
		mTransactionPane = new JScrollPane(mTransactionTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mTransactionPane.setSize(800, 425);
		mTransactionPane.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing * 7);
		mTransactionPane.setVisible(true);
		add(mTransactionPane);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
