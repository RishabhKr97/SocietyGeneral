package society.account.ui.subPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import society.account.database.DatabaseHelper;
import society.account.logger.Log;
import society.account.ui.AlertMessages;
import society.account.ui.UiConstants;

@SuppressWarnings("serial")
public class AllMembersPanel extends JPanel implements ActionListener {
	private static final String TAG = "AllMembersPane";

	private int mWidth = UiConstants.DimensionConstants.DEFAULT_WIDTH;
	private int mHeight = UiConstants.DimensionConstants.DEFAULT_HEIGHT;
	private int mInitialSpacing = UiConstants.DimensionConstants.DEFAULT_INITIAL_SPACING;
	private int mVerticalSpacing = UiConstants.DimensionConstants.DEFAULT_VERTICAL_SPACING;
	private int mHorizontalSpacing = UiConstants.DimensionConstants.DEFAULT_HORIZONTAL_SPACING;

	private JButton mGetMembers;
	private JScrollPane mAllMembersPane;
	private JTable mAllMembersTable;

	private final DatabaseHelper dbHelper = new DatabaseHelper();

	public AllMembersPanel() {
		setLayout(null);

		mGetMembers = new JButton("Get All Members");
		mGetMembers.setSize(mWidth, mHeight);
		mGetMembers.setLocation(mHorizontalSpacing, mInitialSpacing);
		mGetMembers.addActionListener(this);
		add(mGetMembers);

		mAllMembersTable = new JTable(new DefaultTableModel(UiConstants.TableConstants.ROW_DEFAULTS,
				UiConstants.TableConstants.ALL_MEMBERS_TABLE_COLUMN_NAMES));
		for (int column = 0; column < mAllMembersTable.getColumnCount(); column++) {
			TableColumn tableColumn = mAllMembersTable.getColumnModel().getColumn(column);
			if (column == 0) {
				tableColumn.setPreferredWidth(UiConstants.DimensionConstants.DEFAULT_TABLE_COLUMN_WIDTH + 20);
			} else if (column == 1) {
				tableColumn.setPreferredWidth(UiConstants.DimensionConstants.DEFAULT_TABLE_COLUMN_WIDTH + 185);
			} else {
				tableColumn.setPreferredWidth(UiConstants.DimensionConstants.DEFAULT_TABLE_COLUMN_WIDTH + 20);
			}
		}
		mAllMembersTable.setRowHeight(mHeight + 2);
		mAllMembersTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		mAllMembersTable.getTableHeader().setReorderingAllowed(false);
		mAllMembersTable.setEnabled(false);
		mAllMembersPane = new JScrollPane(mAllMembersTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mAllMembersPane.setSize(497, 500);
		mAllMembersPane.setLocation(mInitialSpacing + mHorizontalSpacing / 2, mInitialSpacing + mVerticalSpacing);
		mAllMembersPane.setVisible(true);
		add(mAllMembersPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mGetMembers) {
			Log.d(TAG, "Getting all members");
			List<String[]> values = dbHelper.getAllMembers();
			if (values == null || values.isEmpty()) {
				clearTable();
				AlertMessages.showAlertMessage(this, "No Member Found!");
				Log.d(TAG, "No member found");
				return;
			}

			Log.d(TAG, "Found " + values.size());
			clearTable();
			DefaultTableModel allMembersTableModel = (DefaultTableModel) mAllMembersTable.getModel();
			for (String[] row : values) {
				row[2] = "1".equals(row[2]) ? "Active" : "Inactive";
				allMembersTableModel.addRow(row);
			}
		}
	}

	private void clearTable() {
		DefaultTableModel allMembersTableModel = (DefaultTableModel) mAllMembersTable.getModel();
		allMembersTableModel.setRowCount(0);
	}
}
