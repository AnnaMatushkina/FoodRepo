package com.epam.feel.client.activity;

import java.util.List;
import java.util.Map;
import com.epam.feel.client.mvp.ClientFactory;
import com.epam.feel.client.mvp.ViewFactory;
import com.epam.feel.client.ui.util.pagination.CollectionUtils;
import com.epam.feel.client.ui.util.pagination.ProvideredDataGrid.PagingCountAsyncCallback;
import com.epam.feel.client.ui.util.pagination.ProvideredDataGrid.PagingDataAsyncCallback;
import com.epam.feel.client.view.IListGroupRequestView;
import com.epam.feel.server.model.RequestGroup;
import com.epam.feel.shared.dto.ExtendedRequestGroupDTO;
import com.epam.feel.shared.excel.Cell;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class ListGroupRequestActivity extends PageTemplateActivity implements
    IListGroupRequestView.IListGroupRequestPresenter {

    private static final Map<String, Boolean> DEFAULT_ORDER = CollectionUtils.getOrderList(RequestGroup.DATE_COLUMN,
        false);

    @Inject
    public ListGroupRequestActivity(ClientFactory clientFactory, ViewFactory viewFactory) {
        super(clientFactory, viewFactory);
    }

    @Override
    public void start(AcceptsOneWidget arg0, EventBus arg1) {}

    @Override
    public void registerGroupRequests(Long groupId, AsyncCallback<Void> callbackRegGroup) {
        getRequestService().acceptGroupRequests(groupId, callbackRegGroup);
    }

    @Override
    public void deleteGroupRequests(Long groupId, String reason, AsyncCallback<Void> callbackDelGroup) {
        getRequestService().deleteGroupRequests(groupId, reason, callbackDelGroup);
    }

    @Override
    public void saveExcelGroupRequests(List<Cell> cells, AsyncCallback<Void> callbackDelGroup) {
        getRequestService().exportGroupToExcel(cells, callbackDelGroup);
    }

    @Override
    public void checkRequestTime(AsyncCallback<Boolean> callback) {
        getMenuService().checkRequestTime(callback);
    }

    @Override
    public void completeGroupRequests(Long groupId, AsyncCallback<ExtendedRequestGroupDTO> callbackRegGroup) {
        getRequestService().completeGroupRequests(groupId, callbackRegGroup);
    }

    @Override
    public void updateRowData(int startRow, int maxRows, RowDataAcceptor<ExtendedRequestGroupDTO> acceptor) {
        updateRowData(startRow, maxRows, DEFAULT_ORDER, acceptor);
    }

    @Override
    public void updateRowData(int startRow, int maxRows, Map<String, Boolean> orderByList,
        RowDataAcceptor<ExtendedRequestGroupDTO> acceptor) {
        getRequestService().getAllGroupRequests(startRow, maxRows, orderByList,
            new PagingDataAsyncCallback<ExtendedRequestGroupDTO>(startRow, acceptor));
    }

    @Override
    public void updateRowCount(RowDataAcceptor<ExtendedRequestGroupDTO> acceptor) {
        getRequestService().getAllGroupRequestsCount(new PagingCountAsyncCallback<ExtendedRequestGroupDTO>(acceptor));
    }
}
