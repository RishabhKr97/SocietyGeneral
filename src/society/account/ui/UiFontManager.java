package society.account.ui;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.UIManager;

public class UiFontManager {
	private static final Font mHeadingFont = new Font(Font.SANS_SERIF, Font.BOLD, 17);
	private static final Font mSubHeadingFont = new Font(Font.SANS_SERIF, Font.BOLD, 15);
	private static final Font mLabelFont = new Font("", Font.BOLD, 16);
	private static final Font mTextFont = new Font("", Font.PLAIN, 16);
	private static final Font mButtonFont = new Font("", Font.BOLD, 15);
	private static final Font mComboBoxFont = new Font("", Font.BOLD, 16);
	private static final Font mTableHeaderFont = new Font(Font.SERIF, Font.BOLD, 14);
	private static final Font mLabelAsHeadingFont = new Font(Font.MONOSPACED, Font.BOLD, 18);

	public static Font getSubHeadingFont() {
		return mSubHeadingFont;
	}

	public static Font getLabelAsHeadingFont() {
		return mLabelAsHeadingFont;
	}

	public static void setFont() {
//		UIManager.put("CheckBoxMenuItem.acceleratorFont", myFont);
		UIManager.put("Button.font", mButtonFont);
//		UIManager.put("ToggleButton.font", myFont);
//		UIManager.put("RadioButton.font", myFont);
//		UIManager.put("CheckBox.font", myFont);
//		UIManager.put("ColorChooser.font", myFont);
		UIManager.put("ComboBox.font", mComboBoxFont);
		UIManager.put("Label.font", mLabelFont);
//		UIManager.put("List.font", myFont);
//		UIManager.put("MenuBar.font", myFont);
//		UIManager.put("Menu.acceleratorFont", myFont);
//		UIManager.put("RadioButtonMenuItem.acceleratorFont", myFont);
//		UIManager.put("MenuItem.acceleratorFont", myFont);
//		UIManager.put("MenuItem.font", myFont);
//		UIManager.put("RadioButtonMenuItem.font", myFont);
//		UIManager.put("CheckBoxMenuItem.font", myFont);
//		UIManager.put("OptionPane.buttonFont", myFont);
//		UIManager.put("OptionPane.messageFont", myFont);
//		UIManager.put("Menu.font", myFont);
//		UIManager.put("PopupMenu.font", myFont);
//		UIManager.put("OptionPane.font", myFont);
//		UIManager.put("Panel.font", myFont);
//		UIManager.put("ProgressBar.font", myFont);
//		UIManager.put("ScrollPane.font", myFont);
//		UIManager.put("Viewport.font", myFont);
		UIManager.put("TabbedPane.font", mHeadingFont);
//		UIManager.put("Slider.font", myFont);
//		UIManager.put("Table.font", myFont);
		UIManager.put("TableHeader.font", mTableHeaderFont);
		UIManager.put("TextField.font", mTextFont);
//		UIManager.put("Spinner.font", myFont);
//		UIManager.put("PasswordField.font", myFont);
		UIManager.put("TextArea.font", mTextFont);
//		UIManager.put("TextPane.font", myFont);
//		UIManager.put("EditorPane.font", myFont);
//		UIManager.put("TabbedPane.smallFont", myFont);
//		UIManager.put("TitledBorder.font", myFont);
//		UIManager.put("ToolBar.font", myFont);
//		UIManager.put("ToolTip.font", myFont);
//		UIManager.put("Tree.font", myFont);
//		UIManager.put("FormattedTextField.font", myFont);
//		UIManager.put("IconButton.font", myFont);
//		UIManager.put("InternalFrame.optionDialogTitleFont", myFont);
//		UIManager.put("InternalFrame.paletteTitleFont", myFont);
//		UIManager.put("InternalFrame.titleFont", myFont);
	}
}
