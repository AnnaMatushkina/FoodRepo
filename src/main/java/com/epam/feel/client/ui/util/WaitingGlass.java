package com.epam.feel.client.ui.util;

import com.epam.feel.client.EpamFeelResources;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window;

/**
 * Waiting dialog for RPC.
 * 
 * @author Michael_Silvanovich
 */
public class WaitingGlass {

    private static int visibleCount = 0;

    private static final String glassStyleName = EpamFeelResources.INSTANCE.global().waitingGlass();

    private static boolean glassVisible;
    private static HandlerRegistration resizeRegistration;
    private static Element glass;

    private WaitingGlass() {}

    /**
     * Window resize handler used to keep the glass the proper size
     */
    private static ResizeHandler glassResizer = new ResizeHandler() {
        public void onResize(ResizeEvent event) {
            Style style = glass.getStyle();

            int winWidth = Window.getClientWidth();
            int winHeight = Window.getClientHeight();

            // Hide the glass while checking the document size. Otherwise it would
            // interfere with the measurement.
            style.setDisplay(Display.NONE);
            style.setWidth(0, Unit.PX);
            style.setHeight(0, Unit.PX);

            int width = Document.get().getScrollWidth();
            int height = Document.get().getScrollHeight();

            // Set the glass size to the larger of the window's client size or the
            // document's scroll size.
            style.setWidth(Math.max(width, winWidth), Unit.PX);
            style.setHeight(Math.max(height, winHeight), Unit.PX);

            // The size is set. Show the glass again.
            style.setDisplay(Display.BLOCK);
        }
    };

    /**
     * Short version of setGlassVisible(true)
     */
    public static void show() {
        setGlassVisible(true);
    }

    /**
     * Short version of setGlassVisible(false)
     */
    public static void hide() {
        setGlassVisible(false);
    }

    /**
     * Shows glass if needed. NOTE: if you call this method with "true" argument, you must call it again with "false"
     * argument later
     * 
     * @param visible
     */
    public static void setGlassVisible(boolean visible) {

        if (visible) {
            visibleCount++;
        } else {
            visibleCount--;
        }

        assert visibleCount >= 0;

        if (visible == glassVisible) {
            return;
        }

        if (!glassVisible) {
            Document.get().getBody().appendChild(getGlass());
            resizeRegistration = Window.addResizeHandler(glassResizer);
            glassResizer.onResize(null);

            glassVisible = true;
        } else if (visibleCount == 0) {
            Document.get().getBody().removeChild(getGlass());

            resizeRegistration.removeHandler();
            resizeRegistration = null;

            glassVisible = false;
        }
    }

    /**
     * Returns true if glass is shown, false - in other case
     * 
     * @return true if glass is shown, false - in other case
     */
    public static boolean isGlassVisible() {
        return glassVisible;
    }

    private static Element getGlass() {
        if (glass == null) {
            glass = Document.get().createDivElement();
            glass.setClassName(glassStyleName);

            glass.getStyle().setPosition(Position.ABSOLUTE);
            glass.getStyle().setLeft(0, Unit.PX);
            glass.getStyle().setTop(0, Unit.PX);
        }
        return glass;
    }

}
