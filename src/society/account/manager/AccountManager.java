package society.account.manager;

import society.account.logger.Log;
import society.account.ui.UI;

public class AccountManager {
	private static final String TAG = "Main";

	public static void main(String[] args) {
		Log.d(TAG, "Appication Launched");
		new UI();
	}
}
