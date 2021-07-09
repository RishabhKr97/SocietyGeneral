package society.account.logger;

import org.apache.log4j.Logger;

public class Log {
	public static void d(String tag, String message) {
		d(tag, message, null);
	}

	public static void d(String tag, String message, Exception e) {
		Logger logger = Logger.getLogger(tag);
		logger.debug(message, e);
	}
}
