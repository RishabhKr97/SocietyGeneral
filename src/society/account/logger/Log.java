package society.account.logger;

import org.apache.log4j.Logger;

public class Log {
	public static void d(String tag, String message) {
		d(tag, message, (Exception) null);
	}

	public static void d(String tag, String message, String... values) {
		d(tag, message + " :: " + String.join(",", values), (Exception) null);
	}

	public static void d(String tag, String message, String[] values, Exception e) {
		d(tag, message + " :: " + String.join(",", values), (Exception) null);
	}

	public static void d(String tag, String message, Exception e) {
		Logger logger = Logger.getLogger(tag);
		logger.debug(message, e);
	}

	public static void e(String tag, String message) {
		e(tag, message, (Exception) null);
	}

	public static void e(String tag, String message, String... values) {
		e(tag, message + " :: " + String.join(",", values), (Exception) null);
	}

	public static void e(String tag, String message, String[] values, Exception e) {
		e(tag, message + " :: " + String.join(",", values), (Exception) null);
	}

	public static void e(String tag, String message, Exception e) {
		Logger logger = Logger.getLogger(tag);
		logger.error(message, e);
	}

	public static void e(String tag, String message, Throwable th) {
		Logger logger = Logger.getLogger(tag);
		logger.error(message, th);
	}
}
