package society.account.manager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UserInfoPanel extends JPanel implements ActionListener {

	private JTextField mAccountNumber;
	private JButton mSubmit;
	private JLabel mNameLabel;
	private JTextField mNameValue;
	private JLabel mDobLabel;
	private JTextField mDobValue;
	private JLabel mDojLabel;
	private JTextField mDojValue;
	private JLabel mAddressLabel;
	private JTextArea mAddressValue;
	private JScrollPane mAddressScroll;
	private JLabel mMobileLabel;
	private JTextField mMobileValue;
	private JLabel mEmailLabel;
	private JTextField mEmailValue;
	private JLabel mShareBalanceLabel;
	private JTextField mShareBalanceValue;
	private JLabel mCdBalanceLabel;
	private JTextField mCdBalanceValue;
	private JLabel mLoanBalanceLabel;
	private JTextField mLoanBalanceValue;
	private JLabel mStatusLabel;

	public UserInfoPanel() {
		setLayout(null);

		mAccountNumber = new JTextField();
		mAccountNumber.setText(" ENTER ACCOUNT NUMBER");
		mAccountNumber.setSize(180, 20);
		mAccountNumber.setLocation(5, 5);
		mAccountNumber.addMouseListener(new AccountMouseListner());
		add(mAccountNumber);

		mSubmit = new JButton("Find");
		mSubmit.setSize(80, 20);
		mSubmit.setLocation(200, 5);
		mSubmit.addActionListener(this);
		add(mSubmit);

		mNameLabel = new JLabel("Name");
		mNameLabel.setSize(180, 20);
		mNameLabel.setLocation(5, 40);
		add(mNameLabel);

		mNameValue = new JTextField();
		mNameValue.setText("My Name");
		mNameValue.setSize(180, 20);
		mNameValue.setLocation(200, 40);
		mNameValue.setEditable(false);
		add(mNameValue);

		mDobLabel = new JLabel("Date of Birth");
		mDobLabel.setSize(180, 20);
		mDobLabel.setLocation(5, 70);
		add(mDobLabel);

		mDobValue = new JTextField();
		mDobValue.setText("My DOB");
		mDobValue.setSize(180, 20);
		mDobValue.setLocation(200, 70);
		mDobValue.setEditable(false);
		add(mDobValue);

		mDojLabel = new JLabel("Date of Joining");
		mDojLabel.setSize(180, 20);
		mDojLabel.setLocation(5, 100);
		add(mDojLabel);

		mDojValue = new JTextField();
		mDojValue.setText("My DOJ");
		mDojValue.setSize(180, 20);
		mDojValue.setLocation(200, 100);
		mDojValue.setEditable(false);
		add(mDojValue);

		mAddressLabel = new JLabel("Address");
		mAddressLabel.setSize(180, 20);
		mAddressLabel.setLocation(5, 130);
		add(mAddressLabel);

		mAddressValue = new JTextArea();
		mAddressValue.setText("My Address");
		mAddressValue.setLineWrap(true);
		mAddressValue.setEditable(false);
		mAddressScroll = new JScrollPane(mAddressValue);
		mAddressScroll.setSize(180, 60);
		mAddressScroll.setLocation(200, 130);
		add(mAddressScroll);

		mMobileLabel = new JLabel("Mobile Number");
		mMobileLabel.setSize(180, 20);
		mMobileLabel.setLocation(5, 200);
		add(mMobileLabel);

		mMobileValue = new JTextField();
		mMobileValue.setText("My Mobile Number");
		mMobileValue.setSize(180, 20);
		mMobileValue.setLocation(200, 200);
		mMobileValue.setEditable(false);
		add(mMobileValue);

		mEmailLabel = new JLabel("Email Id");
		mEmailLabel.setSize(180, 20);
		mEmailLabel.setLocation(5, 230);
		add(mEmailLabel);

		mEmailValue = new JTextField();
		mEmailValue.setText("My Email Id");
		mEmailValue.setSize(180, 20);
		mEmailValue.setLocation(200, 230);
		mEmailValue.setEditable(false);
		add(mEmailValue);

		mShareBalanceLabel = new JLabel("Share Balance");
		mShareBalanceLabel.setSize(180, 20);
		mShareBalanceLabel.setLocation(5, 260);
		add(mShareBalanceLabel);

		mShareBalanceValue = new JTextField();
		mShareBalanceValue.setText("My Share Balance");
		mShareBalanceValue.setSize(180, 20);
		mShareBalanceValue.setLocation(200, 260);
		mShareBalanceValue.setEditable(false);
		add(mShareBalanceValue);

		mCdBalanceLabel = new JLabel("Compulsory Deposit Balance");
		mCdBalanceLabel.setSize(180, 20);
		mCdBalanceLabel.setLocation(5, 290);
		add(mCdBalanceLabel);

		mCdBalanceValue = new JTextField();
		mCdBalanceValue.setText("My Compulsory Deposit Balance");
		mCdBalanceValue.setSize(180, 20);
		mCdBalanceValue.setLocation(200, 290);
		mCdBalanceValue.setEditable(false);
		add(mCdBalanceValue);

		mLoanBalanceLabel = new JLabel("Loan Balance");
		mLoanBalanceLabel.setSize(180, 20);
		mLoanBalanceLabel.setLocation(5, 320);
		add(mLoanBalanceLabel);

		mLoanBalanceValue = new JTextField();
		mLoanBalanceValue.setText("My Loan Balance");
		mLoanBalanceValue.setSize(180, 20);
		mLoanBalanceValue.setLocation(200, 320);
		mLoanBalanceValue.setEditable(false);
		add(mLoanBalanceValue);

		mStatusLabel = new JLabel("Account is active.");
		mStatusLabel.setSize(180, 20);
		mStatusLabel.setLocation(120, 370);
		mStatusLabel.setForeground(Color.GREEN);
		add(mStatusLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mSubmit) {
			mSubmit.setText("FOUND");
		}
	}

	private class AccountMouseListner implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			mAccountNumber.setText("");
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
}
