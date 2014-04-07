package com.epam.feel.client.ui.util;

import com.epam.feel.client.EpamFeelResources;
import com.epam.feel.client.EpamFeelResources.GlobalStyles;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SpinnerView extends Composite {

    private final static GlobalStyles STYLES = EpamFeelResources.INSTANCE.global();

    private ClickHandler upClickHandler = null;
    private ClickHandler downClickHandler = null;

    private FocusPanel upButton = new FocusPanel();
    private FocusPanel downButton = new FocusPanel();
    private VerticalPanel panel = new VerticalPanel();

    public SpinnerView() {
        initUi();
    }

    private void initUi() {
        initHandlers();
        initButton(upButton, STYLES.spinnerUpHover(), STYLES.spinnerUpPressed(), STYLES.spinnerUpReleased());
        initButton(downButton, STYLES.spinnerDownHover(), STYLES.spinnerDownPressed(), STYLES.spinnerDownReleased());
        initWidget(panel);
    }

    private void initHandlers() {
        upButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                upButton.setFocus(false);
                upButton.setStyleName(STYLES.spinnerUpHover());
                if (upClickHandler != null) {
                    upClickHandler.onClick(event);
                }
            }
        });

        downButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                downButton.setFocus(false);
                downButton.setStyleName(STYLES.spinnerDownHover());
                if (downClickHandler != null) {
                    downClickHandler.onClick(event);
                }
            }
        });
    }

    private void initButton(final FocusPanel button, final String hoverStyle, final String pressedStyle,
        final String releasedStyle) {
        button.addMouseOverHandler(new MouseOverHandler() {
            @Override
            public void onMouseOver(MouseOverEvent event) {
                button.setFocus(false);
                button.setStyleName(hoverStyle);
            }
        });

        button.addMouseOutHandler(new MouseOutHandler() {
            @Override
            public void onMouseOut(MouseOutEvent event) {
                button.setFocus(false);
                button.setStyleName(releasedStyle);
            }
        });

        button.addMouseDownHandler(new MouseDownHandler() {
            @Override
            public void onMouseDown(MouseDownEvent event) {
                button.setFocus(false);
                button.setStyleName(pressedStyle);
            }
        });

        button.addMouseUpHandler(new MouseUpHandler() {
            @Override
            public void onMouseUp(MouseUpEvent event) {
                button.setFocus(false);
                button.setStyleName(hoverStyle);
            }
        });

        button.setStyleName(releasedStyle);

        panel.add(button);
    }

    public void addUpClickListener(ClickHandler handler) {
        upClickHandler = handler;
    }

    public void addDownClickListener(ClickHandler handler) {
        downClickHandler = handler;
    }
}
