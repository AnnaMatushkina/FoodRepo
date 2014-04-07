package com.epam.feel.client.ui.util;

import java.util.Date;
import org.apache.commons.lang.StringUtils;
import com.epam.feel.client.ui.util.box.ExtendedIntegerBox;
import com.epam.feel.client.ui.util.box.ExtendedIntegerBox.TextChangeEvent;
import com.epam.feel.client.ui.util.box.ExtendedIntegerBox.TextChangeEventHandler;
import com.epam.feel.client.ui.util.highlighting.Highlightable;
import com.epam.feel.client.ui.util.highlighting.StatefulHighlightable;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * This view representing time control for picking time.
 * 
 * @author Evgeny_Neustroev
 */
public class TimeView extends Composite implements StatefulHighlightable {

    private static TimeViewUiBinder uiBinder = GWT.create(TimeViewUiBinder.class);

    interface TimeViewUiBinder extends UiBinder<Widget, TimeView> {}

    private static final int MAX_LENGTH = 2;

    private static final int MIN_HOUR = 0;
    private static final int MAX_HOUR = 23;
    private static final int HOUR_ITERATOR = 1;

    private static final int MIN_MINUTE = 0;
    private static final int MAX_MINUTE = 59;
    private static final int MINUTE_ITERATOR = 5;

    private Integer hours = MIN_HOUR;
    private Integer minutes = MIN_MINUTE;

    @UiField
    ExtendedIntegerBox hourBox;

    @UiField
    SpinnerView hourSpinner;

    @UiField
    ExtendedIntegerBox minuteBox;

    @UiField
    SpinnerView minuteSpinner;

    private Date date = new Date();
    private Date oldDate = date;

    public TimeView() {
        initWidget(uiBinder.createAndBindUi(this));
        initUi();
    }

    private void parseHourInput() {
        Integer candidate = hourBox.getValue();
        if (candidate != null) {
            parseLimitedValue(hourBox, MIN_HOUR, MAX_HOUR);
            hours = hourBox.getValue();
            setHours();
        }
        setHours();
    }

    private void parseMinuteInput() {
        Integer candidate = minuteBox.getValue();
        if (candidate != null) {
            parseLimitedValue(minuteBox, MIN_MINUTE, MAX_MINUTE);
            minutes = minuteBox.getValue();
        }
        setMinutes();
    }

    private void setHours() {
        if (hours > MAX_HOUR) {
            hours = MIN_HOUR;
        } else if (hours < MIN_HOUR) {
            hours = MAX_HOUR;
        }
        hourBox.setText((hours < 10 ? "0" : StringUtils.EMPTY) + hours);
    }

    private void setMinutes() {
        if (minutes > MAX_MINUTE) {
            minutes = MIN_MINUTE;
        } else if (minutes < MIN_MINUTE) {
            minutes = MAX_MINUTE;
        }
        minuteBox.setText((minutes < 10 ? "0" : StringUtils.EMPTY) + minutes);
    }

    private void parseLimitedValue(IntegerBox widget, int minValue, int maxValue) {
        Integer value = widget.getValue();
        if (value > maxValue) {
            value = maxValue;
        }
        if (value < minValue) {
            value = minValue;
        }
        widget.setValue(value);
    }

    private int increaseValue(int value, int iterator) {
        int result = value;
        if (value % iterator != 0) {
            result = (value / iterator) * iterator;
        }
        return (result + iterator);
    }

    private int decreaseValue(int value, int iterator) {
        int result = value;
        if (value % iterator != 0) {
            result = (value / iterator + 1) * iterator;
        }
        return (result - iterator);
    }

    private void initUi() {
        setHours();
        setMinutes();

        hourBox.setMaxLength(MAX_LENGTH);
        minuteBox.setMaxLength(MAX_LENGTH);

        hourSpinner.addUpClickListener(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                increaseHours();
            }
        });

        hourSpinner.addDownClickListener(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                decreaseHours();
            }
        });

        minuteSpinner.addUpClickListener(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                increaseMinutes();
            }
        });

        minuteSpinner.addDownClickListener(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                decreaseMinutes();
            }
        });

        hourBox.addKeyPressHandler(new KeyPressHandler() {
            @Override
            public void onKeyPress(KeyPressEvent event) {
                final int keyCode = event.getNativeEvent().getKeyCode();
                if (keyCode == KeyCodes.KEY_UP) {
                    increaseHours();
                } else if (keyCode == KeyCodes.KEY_DOWN) {
                    decreaseHours();
                }
            }
        });

        hourBox.addTextChangeEventHandler(new TextChangeEventHandler() {

            @Override
            public void onTextChange(TextChangeEvent event) {
                if (hourBox.getText().length() > 1) {
                    parseHourInput();
                }
            }
        });

        hourBox.addValueChangeHandler(new ValueChangeHandler<Integer>() {

            @Override
            public void onValueChange(ValueChangeEvent<Integer> event) {
                parseHourInput();
            }

        });

        minuteBox.addKeyPressHandler(new KeyPressHandler() {
            @Override
            public void onKeyPress(KeyPressEvent event) {
                final int keyCode = event.getNativeEvent().getKeyCode();
                if (keyCode == KeyCodes.KEY_UP) {
                    increaseMinutes();
                } else if (keyCode == KeyCodes.KEY_DOWN) {
                    decreaseMinutes();
                }
            }
        });

        minuteBox.addTextChangeEventHandler(new TextChangeEventHandler() {

            @Override
            public void onTextChange(TextChangeEvent event) {
                final String text = minuteBox.getText();
                if (text.length() > 1) {
                    parseMinuteInput();
                }
            }
        });

        minuteBox.addValueChangeHandler(new ValueChangeHandler<Integer>() {

            @Override
            public void onValueChange(ValueChangeEvent<Integer> event) {
                parseMinuteInput();
            }

        });

    }

    protected void increaseHours() {
        hours = increaseValue(hours, HOUR_ITERATOR);
        setHours();
    }

    protected void decreaseHours() {
        hours = decreaseValue(hours, HOUR_ITERATOR);
        setHours();
    }

    protected void increaseMinutes() {
        minutes = increaseValue(minutes, MINUTE_ITERATOR);
        setMinutes();
    }

    protected void decreaseMinutes() {
        minutes = decreaseValue(minutes, MINUTE_ITERATOR);
        setMinutes();
    }

    @SuppressWarnings ("deprecation")
    public void setValue(Date time) {
        hours = 0;
        minutes = 0;
        if (time != null) {
            hours = time.getHours();
            minutes = time.getMinutes();
        }
        setHours();
        setMinutes();
        oldDate = getValue();
    }

    @SuppressWarnings ("deprecation")
    public Date getValue() {
        date.setHours(hours);
        date.setMinutes(minutes);
        return date;
    }

    public void setDate(Date date) {
        if (date != null) {
            this.date = date;
            this.oldDate = date;
        }
    }

    @Override
    public void applyHighlighting(String style, int type) {
        switch (type) {
            case Highlightable.HIGHLIGHT_WITHOUT_CHECK:
                highlightBox(hourBox, style);
                highlightBox(minuteBox, style);
                break;
            case Highlightable.HIGHLIGHT_CHANGED:
                if (isChanged()) {
                    highlightBox(hourBox, style);
                    highlightBox(minuteBox, style);
                }
                break;
            case Highlightable.HIGHLIGHT_NOT_EMPTY:
                highlightNotEmpty(hourBox, style);
                highlightNotEmpty(minuteBox, style);
                break;
            default:
                throw new IllegalArgumentException();
        }

    }

    @Override
    public void removeHighlighting(String style) {
        hourBox.removeStyleName(style);
        minuteBox.removeStyleName(style);
    }

    @Override
    public boolean isChanged() {
        return oldDate == null ? false : getValue().compareTo(oldDate) != 0;
    }

    private void highlightNotEmpty(ExtendedIntegerBox box, String style) {
        boolean empty = box.getValue() == null || box.getValue() == 0;
        if (!empty) {
            highlightBox(box, style);
        }
    }

    private void highlightBox(ExtendedIntegerBox box, String style) {
        box.addStyleName(style);
    }
}
