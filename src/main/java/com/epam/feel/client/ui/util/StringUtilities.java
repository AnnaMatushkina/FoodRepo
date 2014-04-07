package com.epam.feel.client.ui.util;

/**
 * Utility class containing methods simplifying some operations with strings.
 * 
 * @author Michael_Silvanovich
 */
public class StringUtilities {

    private static final char WHITE_SPACE = ' ';

    private StringUtilities() {};

    /**
     * Detects whether s matches URL-pattern or not
     * 
     * @param s
     *            - matching string
     * @return true if s matches URL-pattern, false - in other case
     */
    public static native boolean isUrl(String s) /*-{
		var regexp = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/
		return regexp.test(s)
    }-*/;

    /**
     * Check that the given CharSequence is neither <code>null</code> nor of length 0. Note: Will return
     * <code>true</code> for a CharSequence that purely consists of whitespace.
     * <p>
     * 
     * <pre>
     * StringUtilities.hasLength(null) = false
     * StringUtilities.hasLength("") = false
     * StringUtilities.hasLength(" ") = true
     * StringUtilities.hasLength("Hello") = true
     * </pre>
     * 
     * @param str
     *            the CharSequence to check (may be <code>null</code>)
     * @return <code>true</code> if the CharSequence is not null and has length
     * @see #hasText(CharSequence)
     */
    public static boolean hasLength(CharSequence str) {
        return (str != null && str.length() > 0);
    }

    /**
     * Check whether the given CharSequence has actual text. More specifically, returns <code>true</code> if the string
     * not <code>null</code>, its length is greater than 0, and it contains at least one non-whitespace character.
     * <p>
     * 
     * <pre>
     * StringUtilities.hasText(null) = false
     * StringUtilities.hasText("") = false
     * StringUtilities.hasText(" ") = false
     * StringUtilities.hasText("12345") = true
     * StringUtilities.hasText(" 12345 ") = true
     * </pre>
     * 
     * @param str
     *            the CharSequence to check (may be <code>null</code>)
     * @return <code>true</code> if the CharSequence is not <code>null</code>, its length is greater than 0, and it does
     *         not contain whitespace only
     * @see java.lang.Character#isWhitespace
     */
    public static boolean hasText(CharSequence str) {
        if (!hasLength(str)) {
            return false;
        }
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (str.charAt(i) != WHITE_SPACE) {
                return true;
            }
        }
        return false;
    }

}
