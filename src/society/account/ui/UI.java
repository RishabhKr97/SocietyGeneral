package society.account.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import society.account.database.DatabaseHelper;
import society.account.logger.Log;

public class UI {
	private static final String TAG = "UI";

	JFrame mMainFrame;
	JTabbedPane mTabs;
	UserInfoPanel mUserInfoPanel;
	TransactionPanel mTransactionPanel;
	SummaryPanel mSummaryPanel;
	ManagePanel mManagePanel;

	public UI() {
		UiFontManager.setFont();

		mMainFrame = new JFrame();
		mTabs = new JTabbedPane();
		mUserInfoPanel = new UserInfoPanel();
		mTransactionPanel = new TransactionPanel();
		mSummaryPanel = new SummaryPanel();
		mManagePanel = new ManagePanel();

		mTabs.setSize(UiConstants.DimensionConstants.WINDOW_DIMENSION, UiConstants.DimensionConstants.WINDOW_DIMENSION);
		mTabs.add("Member Info", mUserInfoPanel);
		mTabs.add("Member Transactions", mTransactionPanel);
		mTabs.add("Summary", mSummaryPanel);
		mTabs.add("Manage", mManagePanel);

		mMainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mMainFrame.add(mTabs);
		mMainFrame.setSize(UiConstants.DimensionConstants.WINDOW_DIMENSION,
				UiConstants.DimensionConstants.WINDOW_DIMENSION);
		mMainFrame.setVisible(true);
		mMainFrame.setTitle("Apna Co-Op. Society");

		mMainFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				new DatabaseHelper().closeDatabase();
				Log.d(TAG, "Application Closed");
			}
		});

		Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(mMainFrame));
	}
}
