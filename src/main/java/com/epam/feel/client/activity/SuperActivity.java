/**
 * 
 */
package com.epam.feel.client.activity;

import java.util.LinkedList;
import java.util.List;
import com.epam.feel.client.mvp.AppPlaceFactory;
import com.epam.feel.client.mvp.ClientFactory;
import com.epam.feel.client.mvp.ViewFactory;
import com.epam.feel.shared.service.ClientInfoServiceAsync;
import com.epam.feel.shared.service.HistoryInfoServiceAsync;
import com.epam.feel.shared.service.MenuInfoServiceAsync;
import com.epam.feel.shared.service.RequestInfoServiceAsync;
import com.epam.feel.shared.service.ServiceUtils;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.inject.Inject;

/**
 * Abstract activity class for inject common factory and services.
 * 
 * @author Evgeny_Kincharov
 */
public abstract class SuperActivity extends AbstractActivity {
    private ClientFactory clientFactory;

    @Inject
    private AppPlaceFactory placeFactory;

    @Inject
    private ViewFactory viewFactory;

    @Inject
    private MenuInfoServiceAsync menuInfoServiceAsync;

    @Inject
    private ClientInfoServiceAsync clientInfoServiceAsync;

    @Inject
    private RequestInfoServiceAsync requestInfoServiceAsync;

    @Inject
    private HistoryInfoServiceAsync historyInfoServiceAsync;

    private List<Object> wrapped;

    public SuperActivity(ClientFactory clientFactory, ViewFactory viewFactory) {
        this.clientFactory = clientFactory;
        this.viewFactory = viewFactory;
        this.wrapped = new LinkedList<Object>();
    }

    protected MenuInfoServiceAsync getMenuService() {
        wrapRequestBuilder(menuInfoServiceAsync);
        return menuInfoServiceAsync;
    }

    protected ClientInfoServiceAsync getClientService() {
        wrapRequestBuilder(clientInfoServiceAsync);
        return clientInfoServiceAsync;
    }

    protected RequestInfoServiceAsync getRequestService() {
        wrapRequestBuilder(requestInfoServiceAsync);
        return requestInfoServiceAsync;
    }

    protected HistoryInfoServiceAsync getHistoryService() {
        wrapRequestBuilder(historyInfoServiceAsync);
        return historyInfoServiceAsync;
    }

    private <T> void wrapRequestBuilder(T object) {
        if (object instanceof ServiceDefTarget && !wrapped.contains(object)) {
            ServiceDefTarget service = (ServiceDefTarget) object;
            ServiceUtils.addLoadingDialogForAllRpc(service);
            wrapped.add(service);
        }
    }

    public ClientFactory getClientFactory() {
        return clientFactory;
    }

    public AppPlaceFactory getPlaceFactory() {
        return placeFactory;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

}
