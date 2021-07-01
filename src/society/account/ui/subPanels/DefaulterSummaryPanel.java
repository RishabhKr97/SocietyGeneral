package society.account.ui.subPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import society.account.ui.UiConstants;
import society.account.ui.UiFontManager;

@SuppressWarnings("serial")
public class DefaulterSummaryPanel extends JPanel implements ActionListener {

	private int mWidth = 400;
	private int mHeight = UiConstants.DimensionConstants.DEFAULT_HEIGHT;
	private int mInitialSpacing = UiConstants.DimensionConstants.DEFAULT_INITIAL_SPACING;
	private int mVerticalSpacing = UiConstants.DimensionConstants.DEFAULT_VERTICAL_SPACING;

	private JLabel mDateLabel;
	private JButton mFind;
	private JLabel mCdDefaulterLabel;
	private JScrollPane mCdDefaulterPane;
	private JTable mCdDefaulterTable;
	private JLabel mLoanDefaulterLabel;
	private JScrollPane mLoanDefaulterPane;
	private JTable mLoanDefaulterTable;

	public DefaulterSummaryPanel() {
		setLayout(null);

		mDateLabel = new JLabel("Defaulters As On ");
		mDateLabel.setSize(mWidth, mHeight);
		mDateLabel.setLocation(mInitialSpacing * 2, mInitialSpacing);
		mDateLabel.setFont(UiFontManager.getLabelAsHeadingFont());
		add(mDateLabel);

		mFind = new JButton("Find");
		mFind.setSize(100, mHeight);
		mFind.setLocation(mWidth + mInitialSpacing * 2, mInitialSpacing);
		mFind.addActionListener(this);
		add(mFind);

		mCdDefaulterLabel = new JLabel("CD DEFAULTERS");
		mCdDefaulterLabel.setSize(mWidth, mHeight);
		mCdDefaulterLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing);
		mCdDefaulterLabel.setFont(UiFontManager.getLabelAsHeadingFont());
		mCdDefaulterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(mCdDefaulterLabel);

		mLoanDefaulterLabel = new JLabel("LOAN DEFAULTERS");
		mLoanDefaulterLabel.setSize(mWidth, mHeight);
		mLoanDefaulterLabel.setLocation(mInitialSpacing + mWidth, mInitialSpacing + mVerticalSpacing);
		mLoanDefaulterLabel.setFont(UiFontManager.getLabelAsHeadingFont());
		mLoanDefaulterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(mLoanDefaulterLabel);

		mCdDefaulterTable = new JTable(UiConstants.TableConstants.ROW_DEFAULTS,
				UiConstants.TableConstants.DEFAULTER_TABLE_COLUMN_NAMES);
		for (int column = 0; column < mCdDefaulterTable.getColumnCount(); column++) {
			TableColumn tableColumn = mCdDefaulterTable.getColumnModel().getColumn(column);
			tableColumn.setPreferredWidth(UiConstants.DimensionConstants.DEFAULT_TABLE_COLUMN_WIDTH * 2 + 4);
		}
		mCdDefaulterTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		mCdDefaulterTable.getTableHeader().setReorderingAllowed(false);
		mCdDefaulterTable.setEnabled(false);
		mCdDefaulterPane = new JScrollPane(mCdDefaulterTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		mCdDefaulterPane.setSize(mWidth - mInitialSpacing * 2, 600);
		mCdDefaulterPane.setLocation(mInitialSpacing * 2, mInitialSpacing + mVerticalSpacing * 2);
		mCdDefaulterPane.setVisible(true);
		add(mCdDefaulterPane);

		mLoanDefaulterTable = new JTable(UiConstants.TableConstants.ROW_DEFAULTS,
				UiConstants.TableConstants.DEFAULTER_TABLE_COLUMN_NAMES);
		for (int column = 0; column < mLoanDefaulterTable.getColumnCount(); column++) {
			TableColumn tableColumn = mLoanDefaulterTable.getColumnModel().getColumn(column);
			tableColumn.setPreferredWidth(UiConstants.DimensionConstants.DEFAULT_TABLE_COLUMN_WIDTH * 2 + 4);
		}
		mLoanDefaulterTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		mLoanDefaulterTable.getTableHeader().setReorderingAllowed(false);
		mLoanDefaulterTable.setEnabled(false);
		mLoanDefaulterPane = new JScrollPane(mLoanDefaulterTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		mLoanDefaulterPane.setSize(mWidth - mInitialSpacing * 2, 600);
		mLoanDefaulterPane.setLocation(mInitialSpacing * 2 + mWidth, mInitialSpacing + mVerticalSpacing * 2);
		mLoanDefaulterPane.setVisible(true);
		add(mLoanDefaulterPane);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
