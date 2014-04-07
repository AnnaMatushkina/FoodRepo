package com.epam.feel.client.activity;

import com.epam.feel.client.mvp.ClientFactory;
import com.epam.feel.client.mvp.ViewFactory;
import com.epam.feel.client.view.ICashManagementView;
import com.epam.feel.shared.dto.ClientDTO;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class CashManagementActivity extends PageTemplateActivity implements
    ICashManagementView.ICashManagementPresenter {

    @Inject
    public CashManagementActivity(ClientFactory clientFactory, ViewFactory viewFactory) {
        super(clientFactory, viewFactory);
    }

    @Override
    public void start(AcceptsOneWidget paramAcceptsOneWidget, EventBus paramEventBus) {}

    @Override
    public void makeAdvancePayment(Long clientId, double value, AsyncCallback<ClientDTO> callbackPaymentOrder) {
        getClientService().makeAdvancePayment(clientId, value, callbackPaymentOrder);
    }

    @Override
    public void outputBalance(Long clientId, AsyncCallback<Double> callbackOutputBalance) {
        getClientService().outputBalance(clientId, callbackOutputBalance);
    }
}