package com.epam.feel.client.ui.util;

import java.util.Date;
import com.epam.feel.client.ui.util.highlighting.Highlightable;
import com.epam.feel.client.ui.util.highlighting.StatefulHighlightable;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

/**
 * This view representing calendar control for picking date.
 * 
 * @author Evgeny_Neustroev
 */
public class CalendarView extends Composite implements HasText, StatefulHighlightable {

    private static CalendarViewUiBinder uiBinder = GWT.create(CalendarViewUiBinder.class);

    interface CalendarViewUiBinder extends UiBinder<Widget, CalendarView> {}

    private Date oldValue;

    @UiField
    DateBox dateBox;
    @UiField
    Image image;
    @UiField
    Label hint;

    public CalendarView() {
        initWidget(uiBinder.createAndBindUi(this));
        oldValue = getValue();
    }

    @UiHandler ("image")
    void onImageClick(ClickEvent event) {
        dateBox.showDatePicker();
    }

    public void setWidth(String width) {
        dateBox.setWidth(width);
    }

    public void setFormat(DateTimeFormat format) {
        dateBox.setFormat(new DateBox.DefaultFormat(format));
    }

    public Date getValue() {
        return dateBox.getValue();
    }

    public void setValue(Date value) {
        dateBox.setValue(value);
        this.oldValue = getValue();
    }

    public void addValueChangeHandler(ValueChangeHandler<Date> handler) {
        dateBox.addValueChangeHandler(handler);
    }

    public void setHint(String text) {
        hint.setText(text);
    }

    @Override
    public String getText() {
        return dateBox.getTextBox().getText();
    }

    @Override
    public void setText(String text) {
        dateBox.getTextBox().setText(text);
    }

    public void setDatePickerVisible(Boolean visible) {
        dateBox.getDatePicker().setVisible(visible);
    }

    @Override
    public boolean isChanged() {
        return oldValue == null ? false : getValue().compareTo(oldValue) != 0;
    }

    @Override
    public void applyHighlighting(String style, int type) {
        switch (type) {
            case Highlightable.HIGHLIGHT_WITHOUT_CHECK:
                dateBox.addStyleName(style);
                break;
            case Highlightable.HIGHLIGHT_CHANGED:
                if (isChanged()) {
                    dateBox.addStyleName(style);
                }
                break;
            case Highlightable.HIGHLIGHT_NOT_EMPTY:
                if (!dateBox.getTextBox().getText().isEmpty()) {
                    dateBox.addStyleName(style);
                }
                break;
            default:
                throw new IllegalArgumentException();
        }

    }

    @Override
    public void removeHighlighting(String style) {
        dateBox.removeStyleName(style);
    }

}