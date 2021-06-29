package society.account.ui.subPanels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DeleteRestoreUserPanel extends JPanel implements ActionListener {

	private JLabel mRemoveMemberLabel;
	private JTextField mRemoveAccountNumber;
	private JButton mRemoveMemberSubmit;
	private JLabel mRestoreMemberLabel;
	private JTextField mRestoreAccountNumber;
	private JButton mRestoreMemberSubmit;
	private JLabel mStatusLabel;

	public DeleteRestoreUserPanel() {
		setLayout(null);

		mRemoveMemberLabel = new JLabel("Remove Member");
		mRemoveMemberLabel.setSize(180, 20);
		mRemoveMemberLabel.setLocation(5, 10);
		add(mRemoveMemberLabel);

		mRemoveAccountNumber = new JTextField();
		mRemoveAccountNumber.setSize(180, 20);
		mRemoveAccountNumber.setLocation(200, 10);
		add(mRemoveAccountNumber);

		mRemoveMemberSubmit = new JButton("Submit");
		mRemoveMemberSubmit.setSize(80, 20);
		mRemoveMemberSubmit.setLocation(400, 10);
		mRemoveMemberSubmit.addActionListener(this);
		add(mRemoveMemberSubmit);

		mRestoreMemberLabel = new JLabel("Restore Member");
		mRestoreMemberLabel.setSize(180, 20);
		mRestoreMemberLabel.setLocation(5, 40);
		add(mRestoreMemberLabel);

		mRestoreAccountNumber = new JTextField();
		mRestoreAccountNumber.setSize(180, 20);
		mRestoreAccountNumber.setLocation(200, 40);
		add(mRestoreAccountNumber);

		mRestoreMemberSubmit = new JButton("Submit");
		mRestoreMemberSubmit.setSize(80, 20);
		mRestoreMemberSubmit.setLocation(400, 40);
		mRestoreMemberSubmit.addActionListener(this);
		add(mRestoreMemberSubmit);

		mStatusLabel = new JLabel("Member Deleted Successfully!");
		mStatusLabel.setSize(180, 20);
		mStatusLabel.setLocation(150, 90);
		mStatusLabel.setForeground(Color.GREEN);
		add(mStatusLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
