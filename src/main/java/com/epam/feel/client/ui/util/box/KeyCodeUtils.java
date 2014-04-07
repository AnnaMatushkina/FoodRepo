package com.epam.feel.client.ui.util.box;

import com.google.gwt.event.dom.client.KeyCodes;

public class KeyCodeUtils {

    private KeyCodeUtils() {}

    public static final int KEY_SPACE = 32;

    public static boolean isSpecialKey(int code) {
        return code <= KeyCodes.KEY_DELETE && code != KEY_SPACE;
    }

}
