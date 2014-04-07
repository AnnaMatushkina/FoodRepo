package com.epam.feel.client.ui.util.dialogs;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Event indicating that user made some action in this dialog.
 * 
 * @author Michael_Silvanovich
 */
public class DialogEvent<T> extends GwtEvent<DialogEventHandler<T>> {

    public static final Type<DialogEventHandler<?>> TYPE = new Type<DialogEventHandler<?>>();

    /**
     * Modal result of confirmation dialog, if dialog was closed by button "OK" return RESULT_OK, otherwise return
     * RESULT_CANCEL
     */
    public static final int RESULT_OK = 0;
    public static final int RESULT_CANCEL = 1;

    private int modalResult;

    /**
     * Fires a dialog event on all registered handlers in the handler manager.
     * 
     * @param source
     *            the source of the handlers
     * @param modalResult
     *            code of event
     */
    public static <T> void fire(HasDialogEventHandler<T> source, int modalResult) {
        DialogEvent<T> event = new DialogEvent<T>(source, modalResult);
        source.fireEvent(event);
    }

    /**
     * Creates a new close event.
     * 
     * @param source
     *            the target
     */
    protected DialogEvent(HasDialogEventHandler<T> source, int modalResult) {
        this.modalResult = modalResult;
        setSource(source);
    }

    /**
     * Returns modal result
     * 
     * @return modal result
     */
    public int getModalResult() {
        return modalResult;
    }

    @Override
    protected void dispatch(DialogEventHandler<T> handler) {
        switch (modalResult) {
            case DialogEvent.RESULT_OK:
                handler.onPositiveButtonClick(this);
                break;
            case DialogEvent.RESULT_CANCEL:
                handler.onNegativeButtonClick(this);
                break;
            default:
                throw new IllegalStateException();
        }
    }

    // The instance knows its of type T, but the TYPE
    // field itself does not, so we have to do an unsafe cast here.
    @SuppressWarnings ({"unchecked", "rawtypes"})
    @Override
    public Type<DialogEventHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    public interface HasDialogEventHandler<T> extends HasHandlers {

        public HandlerRegistration addDialogEventHandler(DialogEventHandler<T> handler);

    }

}
