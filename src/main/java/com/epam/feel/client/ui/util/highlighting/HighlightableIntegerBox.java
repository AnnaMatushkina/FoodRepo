package com.epam.feel.client.ui.util.highlighting;

import com.epam.feel.client.ui.util.box.KeyCodeUtils;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.IntegerBox;

/**
 * IntegerBox that can be highlighted if changed and containing input controlling logic.
 * 
 * @author Michael_Silvanovich
 */
public class HighlightableIntegerBox extends IntegerBox implements StatefulHighlightable {

    private Integer oldValue;
    private boolean specialKey = false;

    public HighlightableIntegerBox() {
        super();
        addKeyDownHandler(new KeyDownHandler() {

            @Override
            public void onKeyDown(KeyDownEvent event) {
                int code = event.getNativeKeyCode();
                specialKey = KeyCodeUtils.isSpecialKey(code);
            }
        });

        addKeyPressHandler(new KeyPressHandler() {

            @Override
            public void onKeyPress(KeyPressEvent event) {
                char code = event.getCharCode();
                if (!Character.isDigit(code)) {
                    if (!specialKey) {
                        specialKey = false;
                        cancelKey();
                    }
                }
            }
        });

        sinkEvents(Event.ONPASTE);
    }

    @Override
    public void onBrowserEvent(Event event) {
        if (event.getTypeInt() == Event.ONPASTE) {
            final String prePastValue = getText();
            Scheduler.get().scheduleDeferred(new ScheduledCommand() {

                @Override
                public void execute() {
                    try {
                        Integer.parseInt(getText());
                    } catch (NumberFormatException e) {
                        setText(prePastValue);
                    }
                }
            });
        } else {
            super.onBrowserEvent(event);
        }
    }

    @Override
    public void setValue(Integer value) {
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
        Integer value = getValue();
        return value != null && !value.equals(oldValue) || value == null && oldValue != null;
    }

}
