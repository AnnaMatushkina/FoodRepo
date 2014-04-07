package com.epam.feel.client.ui.util.box;

import org.apache.commons.lang.StringUtils;
import com.epam.feel.client.ui.util.highlighting.Highlightable;
import com.epam.feel.client.ui.util.highlighting.StatefulHighlightable;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.user.client.ui.TextArea;

/**
 * TextArea allowing setting max length parameter (like TextBox).
 * 
 * @author Michael_Silvanovich
 */
public class FixedLengthTextArea extends TextArea implements StatefulHighlightable {

    private String oldValue = StringUtils.EMPTY;

    public FixedLengthTextArea() {
        super();
    }

    public FixedLengthTextArea(Element element) {
        super(element);
    }

    /**
     * Gets the maximum allowable length of the text area.
     * 
     * @return the maximum length, in characters
     */
    public int getMaxLength() {
        return getInputElement().getMaxLength();
    }

    /**
     * Sets the maximum allowable length of the text area.
     * 
     * @param length
     *            the maximum length, in characters
     */
    public void setMaxLength(int length) {
        getInputElement().setMaxLength(length);
    }

    private InputElement getInputElement() {
        return getElement().cast();
    }

    @Override
    public void setValue(String value) {
        super.setValue(value);
        this.oldValue = getValue();
    }

    @Override
    public void setText(String text) {
        super.setText(text);
        this.oldValue = getValue();
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
