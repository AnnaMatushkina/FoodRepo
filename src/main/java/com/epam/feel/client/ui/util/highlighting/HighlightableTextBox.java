package com.epam.feel.client.ui.util.highlighting;

import org.apache.commons.lang.StringUtils;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.TextBox;

/**
 * TextBox that can be highlighted if changed.
 * 
 * @author Michael_Silvanovich
 */
public class HighlightableTextBox extends TextBox implements StatefulHighlightable {

    private String oldValue = StringUtils.EMPTY;

    public HighlightableTextBox() {
        super();
    }

    public HighlightableTextBox(Element element) {
        super(element);
    }

    @Override
    public void setValue(String value) {
        super.setValue(value);
        this.oldValue = getText();
    }

    @Override
    public void setText(String text) {
        super.setText(text);
        this.oldValue = getText();
    }

    @Override
    public void applyHighlighting(String style, int type) {
        switch (type) {
            case Highlightable.HIGHLIGHT_WITHOUT_CHECK:
                addStyleName(style);
                break;
            case Highlightable.HIGHLIGHT_CHANGED:
                if (isChanged()) {
                    addStyleName(style);
                }
                break;
            case Highlightable.HIGHLIGHT_NOT_EMPTY:
                if (!getText().isEmpty()) {
                    addStyleName(style);
                }
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public void removeHighlighting(String style) {
        removeStyleName(style);
    }

    @Override
    public boolean isChanged() {
        return !getText().equals(oldValue);
    }

}
