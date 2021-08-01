package society.account.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import society.account.ui.subPanels.AddUserPanel;
import society.account.ui.subPanels.DeleteRestoreUserPanel;
import society.account.ui.subPanels.EditUserPanel;

@SuppressWarnings("serial")
public class ManagePanel extends JPanel {

	JTabbedPane mTabs;
	AddUserPanel mAddUserPanel;
	DeleteRestoreUserPanel mDeleteRestoreUserPanel;
	EditUserPanel mEditUserPanel;

	ManagePanel() {
		setLayout(new BorderLayout());
		mTabs = new JTabbedPane();
		mAddUserPanel = new AddUserPanel();
		mDeleteRestoreUserPanel = new DeleteRestoreUserPanel();
		mEditUserPanel = new EditUserPanel();

		mTabs.setSize(UiConstants.DimensionConstants.WINDOW_DIMENSION_WIDTH, UiConstants.DimensionConstants.WINDOW_DIMENSION_HEIGHT);
		mTabs.setFont(UiFontManager.getSubHeadingFont());
		mTabs.add("Add New Member", mAddUserPanel);
		mTabs.add("Remove Or Restore Member", mDeleteRestoreUserPanel);
		mTabs.add("Edit Member Details", mEditUserPanel);
		add(mTabs);
	}
}
