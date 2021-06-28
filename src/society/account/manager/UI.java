package society.account.manager;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import society.account.database.DatabaseHelper;

public class UI {
	JFrame mMainFrame;
	JTabbedPane mTabs;
	UserInfoPanel mUserInfoPanel;
	TransactionPanel mTransactionPanel;
	SummaryPanel mSummaryPanel;
	ManagePanel mManagePanel;

	UI() {
		mMainFrame = new JFrame();
		mTabs = new JTabbedPane();
		mUserInfoPanel = new UserInfoPanel();
		mTransactionPanel = new TransactionPanel();
		mSummaryPanel = new SummaryPanel();
		mManagePanel = new ManagePanel();

		mTabs.setSize(600, 600);
		mTabs.add("user info", mUserInfoPanel);
		mTabs.add("transaction", mTransactionPanel);
		mTabs.add("summary", mSummaryPanel);
		mTabs.add("manage", mManagePanel);

		mMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mMainFrame.add(mTabs);
		mMainFrame.setSize(600, 600);
		mMainFrame.setVisible(true);
		mMainFrame.setTitle("Apna Co-Op. Society");

		mMainFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				new DatabaseHelper().closeDatabase();
				System.out.println("Application Closed");
			}
		});
	}
}
