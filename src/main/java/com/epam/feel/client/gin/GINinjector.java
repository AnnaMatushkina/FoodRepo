package com.epam.feel.client.gin;

import com.epam.feel.client.mvp.ClientFactory;
import com.epam.feel.client.mvp.ViewFactory;
import com.epam.feel.client.ui.ApplicationView;
import com.epam.feel.shared.service.ClientInfoServiceAsync;
import com.epam.feel.shared.service.HistoryInfoServiceAsync;
import com.epam.feel.shared.service.MenuInfoServiceAsync;
import com.epam.feel.shared.service.RequestInfoServiceAsync;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceHistoryHandler;

/**
 * Gin injector for epam-feel application.
 * 
 * @author Artem Tumasov (Artem_Tumasov@epam.com)
 */

@GinModules (GINClientModule.class)
public interface GINinjector extends Ginjector {

    PlaceHistoryHandler getPlaceHistoryHandler();

    ClientFactory getClientFactory();

    ViewFactory getViewFactory();

    ActivityManager getActivityManager();

    MenuInfoServiceAsync getMenuInfoServiceAsync();

    RequestInfoServiceAsync getOrderInfoServiceAsync();

    ClientInfoServiceAsync getClientInfoServiceAsync();

    HistoryInfoServiceAsync getHistoryInfoServiceAsync();

    /**
     * Returns main application layout view.
     */
    ApplicationView getApplicationView();

}
