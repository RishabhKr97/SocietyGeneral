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

		mTabs.setSize(UiConstants.DimensionConstants.WINDOW_DIMENSION, UiConstants.DimensionConstants.WINDOW_DIMENSION);
		mTabs.setFont(UiFontManager.getSubHeadingFont());
		mTabs.add("Add New Transaction", mAddTransactionPanel);
		mTabs.add("Search Transaction", mSearchTransactionPanel);
		mTabs.add("Edit Transaction", mEditTransactionPanel);
		add(mTabs);
	}
}
