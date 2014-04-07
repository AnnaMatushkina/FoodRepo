package com.epam.feel.client.activity;

import java.util.List;
import com.epam.feel.client.mvp.ClientFactory;
import com.epam.feel.client.mvp.ViewFactory;
import com.epam.feel.client.view.IApplicationView;
import com.epam.feel.client.view.ICashManagementView;
import com.epam.feel.client.view.IClientListView;
import com.epam.feel.client.view.ICreateMenuView;
import com.epam.feel.client.view.IHistoryBalanceView;
import com.epam.feel.client.view.IHistoryMenuView;
import com.epam.feel.client.view.IHistoryNotificationView;
import com.epam.feel.client.view.IHistoryRequestGroupView;
import com.epam.feel.client.view.IHistoryRequestView;
import com.epam.feel.client.view.IListGroupRequestView;
import com.epam.feel.client.view.IListRequestView;
import com.epam.feel.shared.dto.MenuDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class ApplicationActivity extends PageTemplateActivity implements IApplicationView.IApplicationPresenter {

    @Inject
    public ICreateMenuView.ICreateMenuPresenter createMenuPresenter;

    @Inject
    public IListRequestView.IListRequestPresenter listRequestPresenter;

    @Inject
    public IListGroupRequestView.IListGroupRequestPresenter listGroupRequestPresenter;

    @Inject
    public IClientListView.IClientListViewPresenter clientListViewPresenter;

    @Inject
    public ICashManagementView.ICashManagementPresenter cashManagementrPresenter;

    @Inject
    public IHistoryMenuView.IHistoryMenuPresenter historyMenuPresenter;

    @Inject
    public IHistoryRequestView.IHistoryRequestPresenter historyRequestPresenter;

    @Inject
    public IHistoryRequestGroupView.IHistoryRequestGroupPresenter historyRequestGroupPresenter;

    @Inject
    public IHistoryNotificationView.IHistoryNotificationPresenter historyNotificationPresenter;

    @Inject
    public IHistoryBalanceView.IHistoryBalancePresenter historyBalancePresenter;

    @Inject
    public ApplicationActivity(ClientFactory clientFactory, ViewFactory viewFactory) {
        super(clientFactory, viewFactory);
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus paramEventBus) {
        final IApplicationView applicationView = getViewFactory().getApplicationView();
        applicationView.setPresenter(this);
        container.setWidget(applicationView);
    }

    @Override
    public void getActualMenus(AsyncCallback<List<MenuDTO>> callback) {
        getMenuService().getActualMenus(callback);
    }

    @Override
    public void makeOrder(RequestDTO requestDTO, AsyncCallback<RequestDTO> callback) {
        getRequestService().makeRequest(requestDTO, callback);
    }

    @Override
    public void invalidateClientHeader() {
        getHeader().refreshActiveOrders();
    }

    @Override
    public void getAllRequestForUser(MenuDTO menuDTO, AsyncCallback<Boolean> callback) {
        getRequestService().getRequestsForUser(menuDTO, callback);
    }
}
