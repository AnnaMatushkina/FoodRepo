package com.epam.feel.client.activity;

import java.util.List;
import java.util.Map;
import com.epam.feel.client.mvp.ClientFactory;
import com.epam.feel.client.mvp.ViewFactory;
import com.epam.feel.client.view.IMainHeaderView;
import com.epam.feel.shared.dto.ClientDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class MainHeaderActivity extends SuperActivity implements IMainHeaderView.IMainHeaderPresenter {

    AsyncCallback<List<RequestDTO>> callBackRefresh = null;

    ClientDTO currentClient;

    @Inject
    public MainHeaderActivity(ClientFactory clientFactory, ViewFactory viewFactory) {
        super(clientFactory, viewFactory);
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus paramEventBus) {}

    @Override
    public void goToPersonalAccount() {
        final PlaceController placeController = getClientFactory().getPlaceController();
        placeController.goTo(getPlaceFactory().getPersonalAccountProviderPlace());
    }

    @Override
    public void goToHistoryBalance() {
        final PlaceController placeController = getClientFactory().getPlaceController();
        placeController.goTo(getPlaceFactory().getBalanceHistoryProviderPlace());
    }

    @Override
    public void getCurrentClient(AsyncCallback<ClientDTO> callback) {
        getClientService().getCurrentClient(callback);
    }

    @Override
    public void getActiveRequests(ClientDTO client, AsyncCallback<List<RequestDTO>> callback) {
        getRequestService().getActiveRequests(client.getId(), callback);
        currentClient = client;
        callBackRefresh = callback;
    }

    @Override
    public void refreshActiveOrders() {
        if (callBackRefresh != null) {
            getRequestService().getActiveRequests(currentClient.getId(), callBackRefresh);
        }
    }

    @Override
    public void advice(Boolean advised, AsyncCallback<ClientDTO> callback) {
        getClientService().adviseClient(currentClient.getId(), advised, callback);
    }

    @Override
    public void logout(AsyncCallback<Map<String, String>> callback) {
        getClientService().logout(callback);
    }

    @Override
    public void reloadCurrentClient(AsyncCallback<ClientDTO> callback) {
        getClientService().reloadCurrentClient(callback);
    }

    @Override
    public void goMainMenuUserView() {
        final PlaceController placeController = getClientFactory().getPlaceController();
        placeController.goTo(getPlaceFactory().getApplicationProviderPlace());
    }
}
