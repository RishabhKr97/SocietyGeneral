package society.account.ui.subPanels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import society.account.ui.UiConstants;

@SuppressWarnings("serial")
public class DeleteRestoreUserPanel extends JPanel implements ActionListener {

	private int mWidth = UiConstants.DimensionConstants.DEFAULT_WIDTH;
	private int mHeight = UiConstants.DimensionConstants.DEFAULT_HEIGHT;
	private int mInitialSpacing = UiConstants.DimensionConstants.DEFAULT_INITIAL_SPACING;
	private int mVerticalSpacing = UiConstants.DimensionConstants.DEFAULT_VERTICAL_SPACING;
	private int mHorizontalSpacing = UiConstants.DimensionConstants.DEFAULT_HORIZONTAL_SPACING;

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
		mRemoveMemberLabel.setSize(mWidth, mHeight);
		mRemoveMemberLabel.setLocation(mInitialSpacing, mInitialSpacing);
		add(mRemoveMemberLabel);

		mRemoveAccountNumber = new JTextField();
		mRemoveAccountNumber.setSize(mWidth, mHeight);
		mRemoveAccountNumber.setLocation(mHorizontalSpacing, mInitialSpacing);
		add(mRemoveAccountNumber);

		mRemoveMemberSubmit = new JButton("Submit");
		mRemoveMemberSubmit.setSize(100, mHeight);
		mRemoveMemberSubmit.setLocation(mHorizontalSpacing * 2, mInitialSpacing);
		mRemoveMemberSubmit.addActionListener(this);
		add(mRemoveMemberSubmit);

		mRestoreMemberLabel = new JLabel("Restore Member");
		mRestoreMemberLabel.setSize(mWidth, mHeight);
		mRestoreMemberLabel.setLocation(mInitialSpacing, mInitialSpacing + mVerticalSpacing);
		add(mRestoreMemberLabel);

		mRestoreAccountNumber = new JTextField();
		mRestoreAccountNumber.setSize(mWidth, mHeight);
		mRestoreAccountNumber.setLocation(mHorizontalSpacing, mInitialSpacing + mVerticalSpacing);
		add(mRestoreAccountNumber);

		mRestoreMemberSubmit = new JButton("Submit");
		mRestoreMemberSubmit.setSize(100, mHeight);
		mRestoreMemberSubmit.setLocation(mHorizontalSpacing * 2, mInitialSpacing + mVerticalSpacing);
		mRestoreMemberSubmit.addActionListener(this);
		add(mRestoreMemberSubmit);

		mStatusLabel = new JLabel("Member Deleted Successfully!");
		mStatusLabel.setSize(mWidth, mHeight);
		mStatusLabel.setLocation(200, mInitialSpacing + mVerticalSpacing * 3);
		mStatusLabel.setForeground(Color.GREEN);
		add(mStatusLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
