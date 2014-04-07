package com.epam.feel.client.ui.util.highlighting;

import com.epam.feel.client.EpamFeelResources;

/**
 * Helper class for highlightables.
 * 
 * @author Michael_Silvanovich
 */
public class HighlightingHelper {

    public static final String DEFAULT_HIGHLIGHTING_STYLE = EpamFeelResources.INSTANCE.global().highlighted();
    public static final String ERROR_HIGHLIGHTING_STYLE = EpamFeelResources.INSTANCE.global().highlightedRequired();

    private HighlightingHelper() {}

    public static void highlightChanged(Highlightable highlightable, boolean empty) {
        if (empty) {
            highlightable.applyHighlighting(DEFAULT_HIGHLIGHTING_STYLE, Highlightable.HIGHLIGHT_NOT_EMPTY);
        } else {
            highlightable.applyHighlighting(DEFAULT_HIGHLIGHTING_STYLE, Highlightable.HIGHLIGHT_CHANGED);
        }
    }

    public static void highlightError(Highlightable highlightable) {
        highlightable.applyHighlighting(ERROR_HIGHLIGHTING_STYLE, Highlightable.HIGHLIGHT_WITHOUT_CHECK);
    }

    public static void removeErrorHighlighting(Highlightable highlightable) {
        highlightable.removeHighlighting(ERROR_HIGHLIGHTING_STYLE);
    }

    public static void removeChangedHighlighting(Highlightable highlightable) {
        highlightable.removeHighlighting(DEFAULT_HIGHLIGHTING_STYLE);
    }

}
