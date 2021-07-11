package society.account.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class UiConstants {

	public static class DimensionConstants {
		public static final int WINDOW_DIMENSION = 850;
		public static final int DEFAULT_WIDTH = 250;
		public static final int DEFAULT_HEIGHT = 25;
		public static final int DEFAULT_INITIAL_SPACING = 15;
		public static final int DEFAULT_VERTICAL_SPACING = DEFAULT_HEIGHT + 15;
		public static final int DEFAULT_HORIZONTAL_SPACING = DEFAULT_INITIAL_SPACING + DEFAULT_WIDTH + 30;
		public static final int DEFAULT_COMBO_BOX_DATE_WIDTH = 60;
		public static final int DEFAULT_TABLE_COLUMN_WIDTH = 90;
	}

	public static class DateConstants {

		public static final String NA = "NA";

		public static final String[] DATES = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
				"30", "31" };
		public static final String[] MONTHS = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
				"12" };
		public static final String[] YEARS = { "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938",
				"1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951",
				"1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964",
				"1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977",
				"1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990",
				"1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003",
				"2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016",
				"2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" };

		public static final String[] DATES_WITH_NA = new String[DATES.length + 1];
		public static final String[] MONTHS_WITH_NA = new String[MONTHS.length + 1];
		public static final String[] YEARS_WITH_NA = new String[YEARS.length + 1];

		public static final Map<String, Integer> INDEX_OF_DATES = new HashMap<>();
		public static final Map<String, Integer> INDEX_OF_MONTHS = new HashMap<>();
		public static final Map<String, Integer> INDEX_OF_YEARS = new HashMap<>();
		public static final Map<String, Integer> INDEX_OF_DATES_WITH_NA = new HashMap<>();
		public static final Map<String, Integer> INDEX_OF_MONTHS_WITH_NA = new HashMap<>();
		public static final Map<String, Integer> INDEX_OF_YEARS_WITH_NA = new HashMap<>();

		static {
			DATES_WITH_NA[0] = NA;
			MONTHS_WITH_NA[0] = NA;
			YEARS_WITH_NA[0] = NA;
			System.arraycopy(DATES, 0, DATES_WITH_NA, 1, DATES.length);
			System.arraycopy(MONTHS, 0, MONTHS_WITH_NA, 1, MONTHS.length);
			System.arraycopy(YEARS, 0, YEARS_WITH_NA, 1, YEARS.length);

			for (int i = 0; i < DATES.length; i++) {
				INDEX_OF_DATES.put(DATES[i], i);
			}
			for (int i = 0; i < MONTHS.length; i++) {
				INDEX_OF_MONTHS.put(MONTHS[i], i);
			}
			for (int i = 0; i < YEARS.length; i++) {
				INDEX_OF_YEARS.put(YEARS[i], i);
			}
			for (int i = 0; i < DATES_WITH_NA.length; i++) {
				INDEX_OF_DATES_WITH_NA.put(DATES_WITH_NA[i], i);
			}
			for (int i = 0; i < MONTHS_WITH_NA.length; i++) {
				INDEX_OF_MONTHS_WITH_NA.put(MONTHS_WITH_NA[i], i);
			}
			for (int i = 0; i < YEARS_WITH_NA.length; i++) {
				INDEX_OF_YEARS_WITH_NA.put(YEARS_WITH_NA[i], i);
			}
		}

		public static int getCurrentDateIdx() {
			LocalDateTime now = LocalDateTime.now();
			return now.getDayOfMonth() - 1;
		}

		public static int getCurrentMonthIdx() {
			LocalDateTime now = LocalDateTime.now();
			return now.getMonthValue() - 1;
		}

		public static int getCurrentYearIdx() {
			LocalDateTime now = LocalDateTime.now();
			return now.getYear() - 1930;
		}

		public static String getCurrentDate() {
			LocalDate date = LocalDate.now();
			return date.getDayOfMonth() + "-" + date.getMonthValue() + "-" + date.getYear();
		}
	}

	public static class PaymentModeConstants {

		public static final String[] PAYMENT_MODES = { "Cash", "Cheque", "Online", "Others" };
	}

	public static class TableConstants {

		public static final String[] TRANSACTION_TABLE_COLUMN_NAMES = { "Transaction<br>Number", "Account<br>Number",
				"Date", "CD", "CD<br>Fine", "Loan<br>Installment", "Loan<br>Interest", "Loan<br>Fine", "Share<br>Money",
				"Admission<br>Fee", "Welfare<br>Depoit", "Misc<br>Fee", "Loan<br>Issued", "Misc Amount<br>Issued",
				"Mode", "Remarks" };
		public static final String[] SUMMARY_TABLE_COLUMN_NAMES = { "Payment<br>Mode", "Count Of<br>Transactions",
				"Total<br>CD", "Total CD<br>Fine", "Total Loan<br>Installment", "Total Loan<br>Interest",
				"Total Loan<br>Fine", "Total Share<br>Money", "Total Admission<br>Fee", "Total Welfare<br>Depoit",
				"Total Misc<br>Fee", "Total Loan<br>Issued", "Total Misc<br>Amount Issued" };
		public static final String[] ALL_MEMBERS_TABLE_COLUMN_NAMES = { "Account<br>Number", "Name",
				"Account<br>Status" };
		public static final String[] DEFAULTER_TABLE_COLUMN_NAMES = { "Account<br>Number", "Pending From<br>(Months)", "Pending<br>Amount" };
		public static final String[][] ROW_DEFAULTS = new String[0][];

		static {
			for (int i = 0; i < TRANSACTION_TABLE_COLUMN_NAMES.length; i++) {
				TRANSACTION_TABLE_COLUMN_NAMES[i] = "<html><center>" + TRANSACTION_TABLE_COLUMN_NAMES[i] + "</html>";
			}
			for (int i = 0; i < SUMMARY_TABLE_COLUMN_NAMES.length; i++) {
				SUMMARY_TABLE_COLUMN_NAMES[i] = "<html><center>" + SUMMARY_TABLE_COLUMN_NAMES[i] + "</html>";
			}
			for (int i = 0; i < DEFAULTER_TABLE_COLUMN_NAMES.length; i++) {
				DEFAULTER_TABLE_COLUMN_NAMES[i] = "<html><center>" + DEFAULTER_TABLE_COLUMN_NAMES[i] + "</html>";
			}
			for (int i = 0; i < ALL_MEMBERS_TABLE_COLUMN_NAMES.length; i++) {
				ALL_MEMBERS_TABLE_COLUMN_NAMES[i] = "<html><center>" + ALL_MEMBERS_TABLE_COLUMN_NAMES[i] + "</html>";
			}
		}
	}
}
