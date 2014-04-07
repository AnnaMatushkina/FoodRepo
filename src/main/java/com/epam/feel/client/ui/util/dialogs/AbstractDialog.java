package com.epam.feel.client.ui.util.dialogs;

import com.epam.feel.client.ui.util.dialogs.DialogEvent.HasDialogEventHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;

/**
 * Abstract class for dialogs.
 * 
 * @author Michael_Silvanovich
 */
public abstract class AbstractDialog<T extends AbstractDialog<?>> extends DialogBox implements HasDialogEventHandler<T> {

    protected void initUI() {
        onInitUI();
        onPostInitUI();
    }

    abstract void onInitUI();

    /**
     * Set event handlers here
     */
    protected void onPostInitUI() {
        if (hasPositiveButton()) {
            getPositiveButton().addClickHandler(new ClickHandler() {

                @Override
                public void onClick(ClickEvent event) {
                    onPositiveButtonClicked();
                }
            });
        }
        if (hasNegativeButton()) {
            getNegativeButton().addClickHandler(new ClickHandler() {

                @Override
                public void onClick(ClickEvent event) {
                    onNegativeButtonClicked();
                }
            });
        }
    };

    protected abstract Button getPositiveButton();

    protected abstract Button getNegativeButton();

    /**
     * Return true if dialog has positive button, false - in other case
     * 
     * @return true if dialog has positive button, false - in other case
     */
    protected boolean hasPositiveButton() {
        return false;
    }

    /**
     * Return true if dialog has negative button, false - in other case
     * 
     * @return true if dialog has negative button, false - in other case
     */
    protected boolean hasNegativeButton() {
        return false;
    }

    protected void onPositiveButtonClicked() {
        DialogEvent.fire(this, DialogEvent.RESULT_OK);
        hide();
    }

    protected void onNegativeButtonClicked() {
        DialogEvent.fire(this, DialogEvent.RESULT_CANCEL);
        hide();
    }

    @Override
    public HandlerRegistration addDialogEventHandler(DialogEventHandler<T> handler) {
        return addHandler(handler, DialogEvent.TYPE);
    }

}
