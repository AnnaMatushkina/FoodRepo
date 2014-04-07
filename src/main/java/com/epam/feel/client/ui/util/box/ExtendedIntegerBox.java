package com.epam.feel.client.ui.util.box;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.IntegerBox;

/**
 * IntegerBox providing possibility of catching change events. (Useful sample for catching change events is found here:
 * http://gwtgrabbag.wordpress.com/2010/12/26/detecting-changes-in-a-gwt-textbox-by-sinking-events/).
 * 
 * @author Michael_Silvanovich
 */
public class ExtendedIntegerBox extends IntegerBox implements HasHandlers {

    public ExtendedIntegerBox() {
        super();
        sinkEvents(Event.ONKEYUP);
        sinkEvents(Event.ONPASTE);
    }

    @Override
    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        switch (event.getTypeInt()) {
            case Event.ONKEYUP:
                final int keyCode = event.getKeyCode();
                if (keyCode < KeyCodes.KEY_DELETE && keyCode != KeyCodes.KEY_BACKSPACE) {
                    // skip all special keys (keyCode < 40), but backspace
                    break;
                }
                //$FALL-THROUGH$
            case Event.ONPASTE: { // Scheduler needed so pasted data shows up in TextBox before we fire
                Scheduler.get().scheduleDeferred(new ScheduledCommand() {
                    @Override
                    public void execute() {
                        fireEvent(new TextChangeEvent());
                    }
                });
                break;
            }
            default: // Do nothing
        }
    }

    public HandlerRegistration addTextChangeEventHandler(TextChangeEventHandler handler) {
        return addHandler(handler, TextChangeEvent.TYPE);
    }

    public interface TextChangeEventHandler extends EventHandler {

        void onTextChange(TextChangeEvent event);

    }

    public static class TextChangeEvent extends GwtEvent<TextChangeEventHandler> {

        public static final Type<TextChangeEventHandler> TYPE = new Type<TextChangeEventHandler>();

        @Override
        public Type<TextChangeEventHandler> getAssociatedType() {
            return TYPE;
        }

        @Override
        protected void dispatch(TextChangeEventHandler handler) {
            handler.onTextChange(this);
        }
    }

}
