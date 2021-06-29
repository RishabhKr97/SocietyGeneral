package society.account.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import society.account.ui.subPanels.AddTransactionPanel;
import society.account.ui.subPanels.EditTransactionPanel;
import society.account.ui.subPanels.SearchTransactionPanel;

@SuppressWarnings("serial")
public class TransactionPanel extends JPanel {

	JTabbedPane mTabs;
	AddTransactionPanel mAddTransactionPanel;
	SearchTransactionPanel mSearchTransactionPanel;
	EditTransactionPanel mEditTransactionPanel;

	TransactionPanel() {
		setLayout(new BorderLayout());
		mTabs = new JTabbedPane();
		mAddTransactionPanel = new AddTransactionPanel();
		mSearchTransactionPanel = new SearchTransactionPanel();
		mEditTransactionPanel = new EditTransactionPanel();

		mTabs.setSize(600, 600);
		mTabs.add("add new transaction", mAddTransactionPanel);
		mTabs.add("search transaction", mSearchTransactionPanel);
		mTabs.add("edit transaction", mEditTransactionPanel);
		add(mTabs);
	}
}
