package society.account.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import society.account.ui.subPanels.PendingPaymentsSummaryPanel;
import society.account.ui.subPanels.TransactionSummaryPanel;

@SuppressWarnings("serial")
public class SummaryPanel extends JPanel {

	JTabbedPane mTabs;
	TransactionSummaryPanel mTransactionSummaryPanel;
	PendingPaymentsSummaryPanel mDefaulterSummaryPanel;

	SummaryPanel() {
		setLayout(new BorderLayout());
		mTabs = new JTabbedPane();
		mTransactionSummaryPanel = new TransactionSummaryPanel();
		mDefaulterSummaryPanel = new PendingPaymentsSummaryPanel();

		mTabs.setSize(UiConstants.DimensionConstants.WINDOW_DIMENSION_WIDTH,
				UiConstants.DimensionConstants.WINDOW_DIMENSION_HEIGHT);
		mTabs.setFont(UiFontManager.getSubHeadingFont());
		mTabs.add("Transaction Summary", mTransactionSummaryPanel);
		mTabs.add("Pending Payments", mDefaulterSummaryPanel);
		add(mTabs);
	}
}
