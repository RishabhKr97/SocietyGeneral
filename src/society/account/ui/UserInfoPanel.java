package society.account.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import society.account.ui.subPanels.AllMembersPanel;
import society.account.ui.subPanels.SearchMemberPanel;

@SuppressWarnings("serial")
public class UserInfoPanel extends JPanel {

	JTabbedPane mTabs;
	SearchMemberPanel mSearchMemberPanel;
	AllMembersPanel mAllMemberPanel;

	UserInfoPanel() {
		setLayout(new BorderLayout());
		mTabs = new JTabbedPane();
		mSearchMemberPanel = new SearchMemberPanel();
		mAllMemberPanel = new AllMembersPanel();

		mTabs.setSize(UiConstants.DimensionConstants.WINDOW_DIMENSION, UiConstants.DimensionConstants.WINDOW_DIMENSION);
		mTabs.setFont(UiFontManager.getSubHeadingFont());
		mTabs.add("Search Member", mSearchMemberPanel);
		mTabs.add("All Members", mAllMemberPanel);
		add(mTabs);
	}
}
