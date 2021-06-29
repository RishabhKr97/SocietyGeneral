package society.account.ui.subPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import society.account.ui.DateConstants;

@SuppressWarnings("serial")
public class EditUserPanel extends JPanel implements ActionListener {
	private JTextField mSearchAccountNumber;
	private JButton mSearchAccountNumberSubmit;
	private JLabel mAccountNumberLabel;
	private JTextField mAccountNumberValue;
	private JLabel mNameLabel;
	private JTextField mNameValue;
	private JLabel mDobLabel;
	private JComboBox<String> mDobDate;
	private JComboBox<String> mDobMonth;
	private JComboBox<String> mDobYear;
	private JLabel mDojLabel;
	private JComboBox<String> mDojDate;
	private JComboBox<String> mDojMonth;
	private JComboBox<String> mDojYear;
	private JLabel mAddressLabel;
	private JTextArea mAddressValue;
	private JScrollPane mAddressScroll;
	private JLabel mMobileLabel;
	private JTextField mMobileValue;
	private JLabel mEmailLabel;
	private JTextField mEmailValue;
	private JLabel mPanLabel;
	private JTextField mPanValue;
	private JLabel mAadharLabel;
	private JTextField mAadharValue;
	private JButton mSubmit;

	public EditUserPanel() {
		setLayout(null);

		mSearchAccountNumber = new JTextField();
		mSearchAccountNumber.setText(" ENTER ACCOUNT NUMBER");
		mSearchAccountNumber.setSize(180, 20);
		mSearchAccountNumber.setLocation(5, 5);
		mSearchAccountNumber.addMouseListener(new AccountMouseListner());
		add(mSearchAccountNumber);

		mSearchAccountNumberSubmit = new JButton("Find");
		mSearchAccountNumberSubmit.setSize(80, 20);
		mSearchAccountNumberSubmit.setLocation(200, 5);
		mSearchAccountNumberSubmit.addActionListener(this);
		add(mSearchAccountNumberSubmit);

		mAccountNumberLabel = new JLabel("Account Number");
		mAccountNumberLabel.setSize(180, 20);
		mAccountNumberLabel.setLocation(5, 60);
		add(mAccountNumberLabel);

		mAccountNumberValue = new JTextField();
		mAccountNumberValue.setSize(180, 20);
		mAccountNumberValue.setLocation(200, 60);
		add(mAccountNumberValue);

		mNameLabel = new JLabel("Name");
		mNameLabel.setSize(180, 20);
		mNameLabel.setLocation(5, 90);
		add(mNameLabel);

		mNameValue = new JTextField();
		mNameValue.setSize(180, 20);
		mNameValue.setLocation(200, 90);
		add(mNameValue);

		mDobLabel = new JLabel("Date of Birth");
		mDobLabel.setSize(180, 20);
		mDobLabel.setLocation(5, 120);
		add(mDobLabel);

		mDobDate = new JComboBox<>(DateConstants.DATES);
		mDobDate.setSize(52, 20);
		mDobDate.setLocation(200, 120);
		add(mDobDate);

		mDobMonth = new JComboBox<>(DateConstants.MONTHS);
		mDobMonth.setSize(52, 20);
		mDobMonth.setLocation(264, 120);
		add(mDobMonth);

		mDobYear = new JComboBox<>(DateConstants.YEARS);
		mDobYear.setSize(52, 20);
		mDobYear.setLocation(328, 120);
		add(mDobYear);

		mDojLabel = new JLabel("Date of Joining");
		mDojLabel.setSize(180, 20);
		mDojLabel.setLocation(5, 150);
		add(mDojLabel);

		mDojDate = new JComboBox<>(DateConstants.DATES);
		mDojDate.setSize(52, 20);
		mDojDate.setLocation(200, 150);
		mDojDate.setSelectedIndex(DateConstants.getCurrentDateIdx());
		add(mDojDate);

		mDojMonth = new JComboBox<>(DateConstants.MONTHS);
		mDojMonth.setSize(52, 20);
		mDojMonth.setLocation(264, 150);
		mDojMonth.setSelectedIndex(DateConstants.getCurrentMonthIdx());
		add(mDojMonth);

		mDojYear = new JComboBox<>(DateConstants.YEARS);
		mDojYear.setSize(52, 20);
		mDojYear.setLocation(328, 150);
		mDojYear.setSelectedIndex(DateConstants.getCurrentYearIdx());
		add(mDojYear);

		mAddressLabel = new JLabel("Address");
		mAddressLabel.setSize(180, 20);
		mAddressLabel.setLocation(5, 180);
		add(mAddressLabel);

		mAddressValue = new JTextArea();
		mAddressValue.setLineWrap(true);
		mAddressScroll = new JScrollPane(mAddressValue);
		mAddressScroll.setSize(180, 60);
		mAddressScroll.setLocation(200, 180);
		add(mAddressScroll);

		mMobileLabel = new JLabel("Mobile Number");
		mMobileLabel.setSize(180, 20);
		mMobileLabel.setLocation(5, 250);
		add(mMobileLabel);

		mMobileValue = new JTextField();
		mMobileValue.setSize(180, 20);
		mMobileValue.setLocation(200, 250);
		add(mMobileValue);

		mEmailLabel = new JLabel("Email Id");
		mEmailLabel.setSize(180, 20);
		mEmailLabel.setLocation(5, 280);
		add(mEmailLabel);

		mEmailValue = new JTextField();
		mEmailValue.setSize(180, 20);
		mEmailValue.setLocation(200, 280);
		add(mEmailValue);

		mPanLabel = new JLabel("PAN Number");
		mPanLabel.setSize(180, 20);
		mPanLabel.setLocation(5, 310);
		add(mPanLabel);

		mPanValue = new JTextField();
		mPanValue.setSize(180, 20);
		mPanValue.setLocation(200, 310);
		add(mPanValue);

		mAadharLabel = new JLabel("Aadhar Number");
		mAadharLabel.setSize(180, 20);
		mAadharLabel.setLocation(5, 340);
		add(mAadharLabel);

		mAadharValue = new JTextField();
		mAadharValue.setSize(180, 20);
		mAadharValue.setLocation(200, 340);
		add(mAadharValue);

		mSubmit = new JButton("Submit");
		mSubmit.setSize(80, 20);
		mSubmit.setLocation(100, 390);
		mSubmit.addActionListener(this);
		add(mSubmit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mSearchAccountNumberSubmit) {
			mSearchAccountNumberSubmit.setText("FOUND");
		}
	}

	private class AccountMouseListner implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			mSearchAccountNumber.setText("");
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
