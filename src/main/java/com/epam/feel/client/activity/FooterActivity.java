package com.epam.feel.client.activity;

import java.util.List;
import com.epam.feel.client.mvp.ClientFactory;
import com.epam.feel.client.mvp.ViewFactory;
import com.epam.feel.client.view.IFooterView;
import com.epam.feel.shared.dto.ClientDTO;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class FooterActivity extends SuperActivity implements IFooterView.IFooterPresenter {

    @Inject
    public FooterActivity(ClientFactory clientFactory, ViewFactory viewFactory) {
        super(clientFactory, viewFactory);
    }

    @Override
    public void start(AcceptsOneWidget paramAcceptsOneWidget, EventBus paramEventBus) {}

    @Override
    public void getAdministrators(AsyncCallback<List<ClientDTO>> callback) {
        getClientService().getAdministrators(callback);
    }

}
