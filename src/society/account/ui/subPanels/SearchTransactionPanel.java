package society.account.ui.subPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import society.account.ui.UiConstants;

@SuppressWarnings("serial")
public class SearchTransactionPanel extends JPanel implements ActionListener {

	private JLabel mAccountNumberLabel;
	private JTextField mAccountNumberValue;
	private JButton mGetPaymentDetails;
	private JLabel mDotLabel;
	private JComboBox<String> mDotDate;
	private JComboBox<String> mDotMonth;
	private JComboBox<String> mDotYear;

	public SearchTransactionPanel() {
		setLayout(null);

		mAccountNumberLabel = new JLabel("Account Number");
		mAccountNumberLabel.setSize(180, 20);
		mAccountNumberLabel.setLocation(5, 10);
		add(mAccountNumberLabel);

		mAccountNumberValue = new JTextField();
		mAccountNumberValue.setSize(180, 20);
		mAccountNumberValue.setLocation(200, 10);
		add(mAccountNumberValue);

		mGetPaymentDetails = new JButton("Get Details");
		mGetPaymentDetails.setSize(100, 20);
		mGetPaymentDetails.setLocation(400, 10);
		mGetPaymentDetails.addActionListener(this);
		add(mGetPaymentDetails);

		mDotLabel = new JLabel("Date of Transaction");
		mDotLabel.setSize(180, 20);
		mDotLabel.setLocation(5, 40);
		add(mDotLabel);

		mDotDate = new JComboBox<>(UiConstants.DateConstants.DATES_WITH_NA);
		mDotDate.setSize(52, 20);
		mDotDate.setLocation(200, 40);
		add(mDotDate);

		mDotMonth = new JComboBox<>(UiConstants.DateConstants.MONTHS_WITH_NA);
		mDotMonth.setSize(52, 20);
		mDotMonth.setLocation(264, 40);
		add(mDotMonth);

		mDotYear = new JComboBox<>(UiConstants.DateConstants.YEARS_WITH_NA);
		mDotYear.setSize(52, 20);
		mDotYear.setLocation(328, 40);
		add(mDotYear);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
