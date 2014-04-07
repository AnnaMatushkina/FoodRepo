package com.epam.feel.client.ui.util.highlighting;

/**
 * Indicates that component can be highlighted.
 * 
 * @author Michael_Silvanovich
 */
public interface Highlightable {

    public static final int HIGHLIGHT_WITHOUT_CHECK = 0;
    public static final int HIGHLIGHT_NOT_EMPTY = 1;
    public static final int HIGHLIGHT_CHANGED = 2;

    /**
     * Applies highlighting according to style
     * 
     * @param style
     *            - style to be applied
     * @param type
     *            - type of highlighting (component dependent)
     */
    void applyHighlighting(String style, int type);

    /**
     * Applies highlighting according to style
     * 
     * @param style
     *            - style to be removed
     */
    void removeHighlighting(String style);

}
