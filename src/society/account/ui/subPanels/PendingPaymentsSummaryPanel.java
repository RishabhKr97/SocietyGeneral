package society.account.ui.subPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
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
public class PendingPaymentsSummaryPanel extends JPanel implements ActionListener {
	private static final String TAG = "PendingPaymentsSummaryPanel";

	private int mWidth = 400;
	private int mHeight = UiConstants.DimensionConstants.DEFAULT_HEIGHT;
	private int mInitialSpacing = UiConstants.DimensionConstants.DEFAULT_INITIAL_SPACING;
	private int mVerticalSpacing = UiConstants.DimensionConstants.DEFAULT_VERTICAL_SPACING;

	private JLabel mDateLabel;
	private JButton mFind;
	private JLabel mCdPendingLabel;
	private JScrollPane mCdPendingPane;
	private JTable mCdPendingTable;
	private JLabel mLoanPendingLabel;
	private JScrollPane mLoanPendingPane;
	private JTable mLoanPendingTable;

	private final DatabaseHelper dbHelper = new DatabaseHelper();

	public PendingPaymentsSummaryPanel() {
		setLayout(null);

		mDateLabel = new JLabel("Pending Payments As On " + UiConstants.DateConstants.getCurrentDate());
		mDateLabel.setSize(mWidth, mHeight);
		mDateLabel.setLocation(mInitialSpacing * 2, mInitialSpacing);
		mDateLabel.setFont(UiFontManager.getLabelAsHeadingFont());
		add(mDateLabel);

		mFind = new JButton("Find");
		mFind.setSize(100, mHeight);
		mFind.setLocation(mWidth + mInitialSpacing * 2, mInitialSpacing);
		mFind.addActionListener(this);
		add(mFind);

		mCdPendingLabel = new JLabel("PENDING CD");
		mCdPendingLabel.setSize(mWidth, mHeight);
		mCdPendingLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing);
		mCdPendingLabel.setFont(UiFontManager.getLabelAsHeadingFont());
		mCdPendingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(mCdPendingLabel);

		mLoanPendingLabel = new JLabel("PENDING LOAN");
		mLoanPendingLabel.setSize(mWidth, mHeight);
		mLoanPendingLabel.setLocation(mInitialSpacing + mWidth, mInitialSpacing + mVerticalSpacing);
		mLoanPendingLabel.setFont(UiFontManager.getLabelAsHeadingFont());
		mLoanPendingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(mLoanPendingLabel);

		mCdPendingTable = new JTable(new DefaultTableModel(UiConstants.TableConstants.ROW_DEFAULTS,
				UiConstants.TableConstants.DEFAULTER_TABLE_COLUMN_NAMES));
		for (int column = 0; column < mCdPendingTable.getColumnCount(); column++) {
			TableColumn tableColumn = mCdPendingTable.getColumnModel().getColumn(column);
			tableColumn.setPreferredWidth(UiConstants.DimensionConstants.DEFAULT_TABLE_COLUMN_WIDTH * 2 + 4);
		}
		mCdPendingTable.setRowHeight(mHeight + 2);
		mCdPendingTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		mCdPendingTable.getTableHeader().setReorderingAllowed(false);
		mCdPendingTable.setEnabled(false);
		mCdPendingPane = new JScrollPane(mCdPendingTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mCdPendingPane.setSize(mWidth - mInitialSpacing * 2, 600);
		mCdPendingPane.setLocation(mInitialSpacing * 2, mInitialSpacing + mVerticalSpacing * 2);
		mCdPendingPane.setVisible(true);
		add(mCdPendingPane);

		mLoanPendingTable = new JTable(new DefaultTableModel(UiConstants.TableConstants.ROW_DEFAULTS,
				UiConstants.TableConstants.DEFAULTER_TABLE_COLUMN_NAMES));
		for (int column = 0; column < mLoanPendingTable.getColumnCount(); column++) {
			TableColumn tableColumn = mLoanPendingTable.getColumnModel().getColumn(column);
			tableColumn.setPreferredWidth(UiConstants.DimensionConstants.DEFAULT_TABLE_COLUMN_WIDTH * 2 + 4);
		}
		mLoanPendingTable.setRowHeight(mHeight + 2);
		mLoanPendingTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		mLoanPendingTable.getTableHeader().setReorderingAllowed(false);
		mLoanPendingTable.setEnabled(false);
		mLoanPendingPane = new JScrollPane(mLoanPendingTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mLoanPendingPane.setSize(mWidth - mInitialSpacing * 2, 600);
		mLoanPendingPane.setLocation(mInitialSpacing * 2 + mWidth, mInitialSpacing + mVerticalSpacing * 2);
		mLoanPendingPane.setVisible(true);
		add(mLoanPendingPane);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mFind) {
			Log.d(TAG, "Find all pending payments");
			Map<String, List<String[]>> allPending = dbHelper.getAllPendingPaymentSummary();
			if (allPending == null
					|| (allPending.get("pending_cd").isEmpty() && allPending.get("pending_loan").isEmpty())) {
				clearFields();
				AlertMessages.showAlertMessage(this, "No Pending Payments Found");
				Log.d(TAG, "No pending payments");
				return;
			}

			Log.d(TAG, "Pending CD " + allPending.get("pending_cd").size());
			Log.d(TAG, "Pending Loan " + allPending.get("pending_loan").size());
			clearFields();
			DefaultTableModel cdTableModel = (DefaultTableModel) mCdPendingTable.getModel();
			for (String[] row : allPending.get("pending_cd")) {
				cdTableModel.addRow(row);
			}

			DefaultTableModel loanTableModel = (DefaultTableModel) mLoanPendingTable.getModel();
			for (String[] row : allPending.get("pending_loan")) {
				loanTableModel.addRow(row);
			}
		}
	}

	public void clearFields() {
		mDateLabel.setText("Pending Payments As On " + UiConstants.DateConstants.getCurrentDate());
		DefaultTableModel cdTableModel = (DefaultTableModel) mCdPendingTable.getModel();
		cdTableModel.setRowCount(0);
		DefaultTableModel loanTableModel = (DefaultTableModel) mLoanPendingTable.getModel();
		loanTableModel.setRowCount(0);
	}
}
