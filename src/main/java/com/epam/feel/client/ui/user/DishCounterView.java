package com.epam.feel.client.ui.user;

import com.epam.feel.client.EpamFeelResources;
import com.epam.feel.client.EpamFeelResources.GlobalStyles;
import com.epam.feel.server.model.MenuDetails;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.InlineLabel;

/**
 * Counter dish layout view for MenuClientView.
 * 
 * @author Anna_Gavrilina
 */
public class DishCounterView extends Composite {

    private static final OnValueChangedListener NULL_LISTENER = new OnValueChangedListener() {
        @Override
        public void onValueChanged(DishCounterView counter) {}
    };

    public static interface OnValueChangedListener {
        void onValueChanged(DishCounterView counter);
    }

    private Anchor previous;
    private Anchor next;
    private InlineLabel counter;

    private OnValueChangedListener onValueChangedListener = NULL_LISTENER;
    private Integer tag;

    private int maxValue;

    public DishCounterView() {
        GlobalStyles globalStyles = EpamFeelResources.INSTANCE.global();

        FlowPanel panel = new FlowPanel();
        previous = new Anchor();
        previous.addStyleName(globalStyles.counter());
        previous.addStyleName(globalStyles.counterMinus());
        previous.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                setCounterValue(getCounterValue() - 1);
            }
        });
        counter = new InlineLabel();
        counter.addStyleName(globalStyles.counterDishPadding());
        next = new Anchor();
        next.addStyleName(globalStyles.counter());
        next.addStyleName(globalStyles.counterPlus());
        next.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                setCounterValue(getCounterValue() + 1);
            }
        });
        panel.add(previous);
        panel.add(counter);
        panel.add(next);

        initWidget(panel);
        counter.setText("0");
    }

    public DishCounterView(int maxvalue, ClickHandler clickHandler) {
        this();
        initView(maxvalue, clickHandler);
    }

    public void initView(int maxvalue, ClickHandler clickHandler) {
        this.maxValue = maxvalue;
        previous.addClickHandler(clickHandler);
        next.addClickHandler(clickHandler);
    }

    public Integer getCounterValue() {
        return Integer.parseInt(counter.getText());
    }

    public void setCounterValue(Integer count) {
        setCounterValueSilently(count);
        onValueChangedListener.onValueChanged(this);
    }

    public void setCounterValueSilently(Integer count) {
        if (count == 0 || count > 0 && (maxValue == MenuDetails.UNESTIMATABLE_COUNT || count <= maxValue)) {
            counter.setText(String.valueOf(count));
        }
    }

    public void setOnValueChangedListener(OnValueChangedListener onValueChangedListener) {
        if (onValueChangedListener == null) {
            onValueChangedListener = NULL_LISTENER;
        }
        this.onValueChangedListener = onValueChangedListener;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

}
