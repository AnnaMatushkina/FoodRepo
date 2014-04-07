package com.epam.feel.client.ui.util.dialogs;

import com.google.gwt.event.shared.EventHandler;

/**
 * Callback interface for dialog type components.
 * 
 * @author Michael_Silvanovich
 * @param <T>
 *            - dialog class parameter
 */
public interface DialogEventHandler<T> extends EventHandler {

    /**
     * Will be called in case of positive button is clicked
     * 
     * @param event
     */
    void onPositiveButtonClick(DialogEvent<T> event);

    /**
     * Will be called in case of negative button is clicked
     * 
     * @param event
     */
    void onNegativeButtonClick(DialogEvent<T> event);

    public static abstract class PositiveListener<T> implements DialogEventHandler<T> {

        @Override
        public void onNegativeButtonClick(DialogEvent<T> event) {
            // do nothing
        }

    }

}