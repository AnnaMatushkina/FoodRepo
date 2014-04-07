package com.epam.feel.shared;

import static com.epam.feel.client.IEpamFeelConstants.CONSTANTS;
import com.epam.feel.server.model.MenuDetails;
import com.google.gwt.i18n.client.CurrencyList;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;

/**
 * Constants for application.
 * 
 * @author Evgeny_Kincharov
 */
public final class WebAppConstants {
    public static final String EXPORT_EXCEL_SESSION_PARAM = "export_excel_";

    public static final Double MAX_VAL = 99999999.99d;
    public static final int MAX_REASON_LENGTH = 500;
    public static final int MAX_STRUCTURE_LENGTH = 250;
    public static final int AVERAGE_DELIVERY_DAYS = 1;

    public static final int MAX_FILTER_BOX_LENGTH = 50;
    public static final int MAX_MENU_NAME_LENGTH = 70;

    // User section
    public static final String CLIENT_SESSION_KEY = "currentClientDTO";

    // Formatters section
    public static final DateTimeFormat SHORT_DATE_FORMATTER = DateTimeFormat.getFormat("dd.MM.yyyy");
    public static final DateTimeFormat SHORT_TIME_FORMATTER = DateTimeFormat.getFormat("HH:mm");
    public static final DateTimeFormat DATE_TIME_FORMATTER = DateTimeFormat.getFormat("dd.MM.yyyy HH:mm");
    public static final DateTimeFormat YEAR_DATE_FORMATTER = DateTimeFormat.getFormat("y");

    public static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getFormat("###,###,###,##0.00");
    public static final NumberFormat CURRENCY_FORMATTER2 = NumberFormat.getFormat("#0.00");
    public static final NumberFormat DECIMAL_FORMATTER = NumberFormat.getDecimalFormat();
    public static final NumberFormat ACCOUNT_NUMBER_FORMATTER = new NumberFormat(DECIMAL_FORMATTER.getPattern(),
        CurrencyList.get().getDefault(), false) {
        public String format(Number number) {
            return super.format(number).replace(" ", "");
        };
    };
    public static final NumberFormat MAX_COUNT_FORMATTER = new NumberFormat(DECIMAL_FORMATTER.getPattern(),
        CurrencyList.get().getDefault(), false) {

        public String format(Number number) {
            if (number.intValue() != MenuDetails.UNESTIMATABLE_COUNT) {
                return super.format(number);
            }
            return CONSTANTS.unestimatableValue();
        };

    };

    public static final NumberFormat PLUS_MINUS_CURRENCY_FORMATTER = new NumberFormat("###,###,###,##0.00",
        CurrencyList.get().getDefault(), false) {

        public String format(Number number) {
            if (number.doubleValue() > 0.0) {
                return "+" + super.format(number);
            } else {
                return super.format(number);
            }
        };
    };

    public static final NumberFormat WEIGHT_FORMATTER = NumberFormat.getFormat("#,###");
    public static final NumberFormat PAGES_FORMATTER = NumberFormat.getFormat("#,###");

    public static final String GENERATE_MENU_LOG_USER = "Scheduler";
    public static final String UPLOAD_MESSAGE_LONG_FILE = "File_Too_Long";

    public static final int ROWS_PER_PAGE = 20;

    // Cookie section
    public static final String AM_KEY_DOMAIN_COOKIE = "domain.cookie";
    public static final String AM_KEY_PATH_COOKIE = "path.cookie";
    public static final String AM_KEY_HOST = "hostname";
    public static final String AM_DEFAULT_PATH = "/";
}
