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

		mTabs.setSize(600, 600);
		mTabs.add("add new member", mAddUserPanel);
		mTabs.add("remove or restore member", mDeleteRestoreUserPanel);
		mTabs.add("edit member details", mEditUserPanel);
		add(mTabs);
	}
}
