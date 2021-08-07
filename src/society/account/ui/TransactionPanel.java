package society.account.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import society.account.ui.subPanels.AddTransactionPanel;
import society.account.ui.subPanels.EditTransactionPanel;
import society.account.ui.subPanels.GenerateReceiptPanel;
import society.account.ui.subPanels.SearchTransactionPanel;

@SuppressWarnings("serial")
public class TransactionPanel extends JPanel {

	JTabbedPane mTabs;
	AddTransactionPanel mAddTransactionPanel;
	SearchTransactionPanel mSearchTransactionPanel;
	GenerateReceiptPanel mGenerateReceiptPanel;
	EditTransactionPanel mEditTransactionPanel;

	TransactionPanel() {
		setLayout(new BorderLayout());
		mTabs = new JTabbedPane();
		mAddTransactionPanel = new AddTransactionPanel();
		mSearchTransactionPanel = new SearchTransactionPanel();
		mGenerateReceiptPanel = new GenerateReceiptPanel();
		mEditTransactionPanel = new EditTransactionPanel();

		mTabs.setSize(UiConstants.DimensionConstants.WINDOW_DIMENSION_WIDTH,
				UiConstants.DimensionConstants.WINDOW_DIMENSION_HEIGHT);
		mTabs.setFont(UiFontManager.getSubHeadingFont());
		mTabs.add("Add New Transaction", mAddTransactionPanel);
		mTabs.add("Search Transaction", mSearchTransactionPanel);
		mTabs.add("Generate Transaction Receipt", mGenerateReceiptPanel);
		mTabs.add("Edit Transaction", mEditTransactionPanel);
		add(mTabs);
	}
}
