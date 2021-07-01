package society.account.ui.subPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

import society.account.ui.UiConstants;

@SuppressWarnings("serial")
public class SearchTransactionPanel extends JPanel implements ActionListener {

	private int mWidth = UiConstants.DimensionConstants.DEFAULT_WIDTH;
	private int mHeight = UiConstants.DimensionConstants.DEFAULT_HEIGHT;
	private int mIinitialSpacing = UiConstants.DimensionConstants.DEFAULT_INITIAL_SPACING;
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
	private JScrollPane mTransactionPane;
	private JTable mTransactionTable;

	public SearchTransactionPanel() {
		setLayout(null);

		mAccountNumberLabel = new JLabel("Account Number");
		mAccountNumberLabel.setSize(mWidth, mHeight);
		mAccountNumberLabel.setLocation(mIinitialSpacing, mIinitialSpacing);
		add(mAccountNumberLabel);

		mAccountNumberValue = new JTextField();
		mAccountNumberValue.setSize(mWidth, mHeight);
		mAccountNumberValue.setLocation(mHorizontalSpacing, mIinitialSpacing);
		add(mAccountNumberValue);

		mGetPaymentDetails = new JButton("Get Details");
		mGetPaymentDetails.setSize(125, mHeight);
		mGetPaymentDetails.setLocation(mHorizontalSpacing * 2, mIinitialSpacing);
		mGetPaymentDetails.addActionListener(this);
		add(mGetPaymentDetails);

		mDotLabel = new JLabel("Date of Transaction");
		mDotLabel.setSize(mWidth, mHeight);
		mDotLabel.setLocation(mIinitialSpacing, mIinitialSpacing + mVerticalSpacing);
		add(mDotLabel);

		mDotDate = new JComboBox<>(UiConstants.DateConstants.DATES_WITH_NA);
		mDotDate.setSize(mComboBoxWidth, mHeight);
		mDotDate.setLocation(mHorizontalSpacing, mIinitialSpacing + mVerticalSpacing);
		add(mDotDate);

		mDotMonth = new JComboBox<>(UiConstants.DateConstants.MONTHS_WITH_NA);
		mDotMonth.setSize(mComboBoxWidth, mHeight);
		mDotMonth.setLocation(mHorizontalSpacing + mIinitialSpacing + mComboBoxWidth,
				mIinitialSpacing + mVerticalSpacing);
		add(mDotMonth);

		mDotYear = new JComboBox<>(UiConstants.DateConstants.YEARS_WITH_NA);
		mDotYear.setSize(mComboBoxWidth, mHeight);
		mDotYear.setLocation(mHorizontalSpacing + (mIinitialSpacing + mComboBoxWidth) * 2,
				mIinitialSpacing + mVerticalSpacing);
		add(mDotYear);

		mTransactionTable = new JTable(UiConstants.TransactionTableConstants.ROW_DEFAULTS,
				UiConstants.TransactionTableConstants.COLUMN_NAMES);
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
		mTransactionPane.setSize(800, 600);
		mTransactionPane.setLocation(mIinitialSpacing, mIinitialSpacing + mVerticalSpacing * 3);
		mTransactionPane.setVisible(true);
		add(mTransactionPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
