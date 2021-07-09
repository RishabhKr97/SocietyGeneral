package society.account.ui;

import java.awt.Component;

import society.account.logger.Log;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
	private static final String TAG = "ExceptionHandler";
	Component component;

	public ExceptionHandler(Component component) {
		this.component = component;
	}

	@Override
	public void uncaughtException(Thread t, Throwable th) {
		Log.e(TAG, "Runtime Exception Occurred. Thread " + t.getName(), th);
		AlertMessages.showErrorMessage(component,
				"System Error Occurred.\nPlease Restart The Application.\nIf Error Is Not Resolved Contact Administrator");
	}
}
