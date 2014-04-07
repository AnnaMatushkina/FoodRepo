package com.epam.feel.client.activity;

import java.util.Map;
import org.apache.commons.lang.StringUtils;
import com.epam.feel.client.mvp.ClientFactory;
import com.epam.feel.client.mvp.ViewFactory;
import com.epam.feel.client.ui.util.pagination.CollectionUtils;
import com.epam.feel.client.ui.util.pagination.PagingDataProvider;
import com.epam.feel.client.ui.util.pagination.ProvideredDataGrid.PagingCountAsyncCallback;
import com.epam.feel.client.ui.util.pagination.ProvideredDataGrid.PagingDataAsyncCallback;
import com.epam.feel.client.ui.util.pagination.SortablePagingDataProvider;
import com.epam.feel.client.view.IListRequestView;
import com.epam.feel.server.model.Request;
import com.epam.feel.shared.dto.ExtendedRequestDTO;
import com.epam.feel.shared.dto.ExtendedRequestGroupDTO;
import com.epam.feel.shared.dto.MenuDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class ListOrderActivity extends PageTemplateActivity implements IListRequestView.IListRequestPresenter {

    private String likeString = StringUtils.EMPTY;
    private MenuDTO menu = null;
    private PagingDataProvider<ExtendedRequestDTO> requestProvider;
    private static final Map<String, Boolean> DEFAULT_ORDER = CollectionUtils.getOrderList(Request.ID_COLUMN, false);

    @Inject
    public ListOrderActivity(ClientFactory clientFactory, ViewFactory viewFactory) {
        super(clientFactory, viewFactory);
    }

    @Override
    public void start(AcceptsOneWidget paramAcceptsOneWidget, EventBus paramEventBus) {}

    @Override
    public void editRequest(RequestDTO request, String reason, AsyncCallback<RequestDTO> callbackEditOrder) {
        getRequestService().editRequest(request, reason, callbackEditOrder);
    }

    @Override
    public void acceptRequest(Long requestId, AsyncCallback<RequestDTO> callbackAcceptOrder) {
        getRequestService().acceptRequest(requestId, callbackAcceptOrder);
    }

    @Override
    public void payRequest(Long requestId, AsyncCallback<RequestDTO> callback) {
        getRequestService().payRequest(requestId, callback);
    }

    @Override
    public void deleteRequest(Long requestId, boolean deleteGroup, String reason,
        AsyncCallback<RequestDTO> callbackDeleteOrder) {
        getRequestService().tryToDeleteRequest(requestId, deleteGroup, reason, callbackDeleteOrder);
    }

    @Override
    public void declineRequest(Long requestId, boolean deleteGroup, String reason,
        AsyncCallback<RequestDTO> callbackDeclineOrder) {
        getRequestService().tryToDeclineRequest(requestId, deleteGroup, reason, callbackDeclineOrder);
    }

    @Override
    public void completeRequest(Long requestId, AsyncCallback<RequestDTO> callbackCompleteOrder) {
        getRequestService().completeRequest(requestId, callbackCompleteOrder);
    }

    @Override
    public void getStatusOfGroup(Long requestId, AsyncCallback<ExtendedRequestGroupDTO> callback) {
        getRequestService().getStatusOfGroup(requestId, callback);
    }

    @Override
    public PagingDataProvider<ExtendedRequestDTO> getArchiveRequestsProvider() {
        if (requestProvider == null) {
            requestProvider = createRequestProvider();
        }
        return requestProvider;
    }

    private PagingDataProvider<ExtendedRequestDTO> createRequestProvider() {
        return new SortablePagingDataProvider<ExtendedRequestDTO>() {

            @Override
            public void updateRowData(int startRow, int maxRows, RowDataAcceptor<ExtendedRequestDTO> acceptor) {
                updateRowData(startRow, maxRows, DEFAULT_ORDER, acceptor);
            }

            @Override
            public void updateRowCount(RowDataAcceptor<ExtendedRequestDTO> acceptor) {
                getRequestService().getRequestsByDishNameCount(likeString,
                    new PagingCountAsyncCallback<ExtendedRequestDTO>(acceptor));
            }

            @Override
            public void updateRowData(int startRow, int maxRows, Map<String, Boolean> orderByList,
                RowDataAcceptor<ExtendedRequestDTO> acceptor) {
                getRequestService().getRequestsByDishName(startRow, maxRows, likeString, orderByList,
                    new PagingDataAsyncCallback<ExtendedRequestDTO>(startRow, acceptor));
            }

        };
    }

    @Override
    public void setDishFilterString(String likeString) {
        this.likeString = likeString;
    }

    @Override
    public PagingDataProvider<RequestDTO> getActiveRequestsProvider() {
        return new SortablePagingDataProvider<RequestDTO>() {

            @Override
            public void updateRowData(int startRow, int maxRows, RowDataAcceptor<RequestDTO> acceptor) {
                updateRowData(startRow, maxRows, DEFAULT_ORDER, acceptor);
            }

            @Override
            public void updateRowCount(RowDataAcceptor<RequestDTO> acceptor) {
                if (menu != null) {
                    getRequestService().getActiveRequestsByMenuCount(menu.getId(),
                        new PagingCountAsyncCallback<RequestDTO>(acceptor));
                } else {
                    acceptor.accept(0);
                }
            }

            @Override
            public void updateRowData(int startRow, int maxRows, Map<String, Boolean> orderByList,
                RowDataAcceptor<RequestDTO> acceptor) {
                getRequestService().getActiveRequestsByMenu(startRow, maxRows, menu.getId(), orderByList,
                    new PagingDataAsyncCallback<RequestDTO>(startRow, acceptor));
            }

        };
    }

    @Override
    public void setFilterMenu(MenuDTO menu) {
        this.menu = menu;
    }

    @Override
    public void makeGroupRequest(AsyncCallback<Boolean> callback) {
        if (menu != null) {
            getRequestService().makeRequestGroupByMenu(menu.getId(), callback);
        }
    }
}
