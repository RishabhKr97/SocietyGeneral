package society.account.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import society.account.ui.subPanels.DefaulterSummaryPanel;
import society.account.ui.subPanels.TransactionSummaryPanel;

@SuppressWarnings("serial")
public class SummaryPanel extends JPanel {

	JTabbedPane mTabs;
	TransactionSummaryPanel mTransactionSummaryPanel;
	DefaulterSummaryPanel mDefaulterSummaryPanel;

	SummaryPanel() {
		setLayout(new BorderLayout());
		mTabs = new JTabbedPane();
		mTransactionSummaryPanel = new TransactionSummaryPanel();
		mDefaulterSummaryPanel = new DefaulterSummaryPanel();

		mTabs.setSize(UiConstants.DimensionConstants.WINDOW_DIMENSION, UiConstants.DimensionConstants.WINDOW_DIMENSION);
		mTabs.setFont(UiFontManager.getSubHeadingFont());
		mTabs.add("Transaction Summary", mTransactionSummaryPanel);
		mTabs.add("Defaulter Summary", mDefaulterSummaryPanel);
		add(mTabs);
	}
}
