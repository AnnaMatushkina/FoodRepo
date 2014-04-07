package com.epam.feel.client;

import com.epam.feel.client.gin.GINinjector;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Epam-feel GWT entry point define <code>onModuleLoad()</code>.
 * 
 * @author Artem Tumasov (Artem_Tumasov@epam.com)
 */
public class MainClassEntity implements EntryPoint {

    private final GINinjector injector = GWT.create(GINinjector.class);

    public void onModuleLoad() {
        SimplePanel display = new SimplePanel(injector.getApplicationView());
        injector.getActivityManager().setDisplay(display);
        RootLayoutPanel.get().add(display);
        injector.getPlaceHistoryHandler().handleCurrentHistory();
    }

}
