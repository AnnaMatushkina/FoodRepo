package com.epam.feel.client.ui.util.box;

import com.epam.feel.client.ui.util.highlighting.Highlightable;
import com.epam.feel.client.ui.util.highlighting.StatefulHighlightable;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.DoubleBox;

public class ExtendedDoubleBox extends DoubleBox implements StatefulHighlightable {

    private static final char DECIMAL_SEPARATOR = NumberFormat.getDecimalFormat().format(1.2345).charAt(1);

    private static final String POSITIVE_DECIMAL_PATTERN = "(\\d)+("
        + (DECIMAL_SEPARATOR == '.' ? "\\." : DECIMAL_SEPARATOR) + "?(\\d)+)?(\\d)*";

    private boolean specialKey = false;
    private Double oldValue;

    public ExtendedDoubleBox() {
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
                if (!Character.isDigit(code)
                    && (code != DECIMAL_SEPARATOR || getText().indexOf(DECIMAL_SEPARATOR) >= 0)) {
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
                    if (!getText().matches(POSITIVE_DECIMAL_PATTERN)) {
                        setText(prePastValue);
                    }
                }
            });
        } else {
            super.onBrowserEvent(event);
        }
    }

    @Override
    public void setValue(Double value) {
        super.setValue(value);
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
        Double newValue = getValue();
        return newValue != null && !newValue.equals(oldValue) || newValue == null && oldValue != null;
    }

}
