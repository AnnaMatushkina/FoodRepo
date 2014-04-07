package com.epam.feel.client.activity;

import java.util.Collections;
import java.util.Date;
import java.util.Map;
import com.epam.feel.client.mvp.ClientFactory;
import com.epam.feel.client.mvp.ViewFactory;
import com.epam.feel.client.ui.util.pagination.CollectionUtils;
import com.epam.feel.client.ui.util.pagination.ProvideredDataGrid.PagingCountAsyncCallback;
import com.epam.feel.client.ui.util.pagination.ProvideredDataGrid.PagingDataAsyncCallback;
import com.epam.feel.client.view.IPersonalAccountView;
import com.epam.feel.server.model.Request;
import com.epam.feel.shared.dto.ExtendedRequestDTO;
import com.epam.feel.shared.dto.ExtendedRequestGroupDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class PersonalAccountActivity extends PageTemplateActivity implements
    IPersonalAccountView.IPersonalAccountPresenter {

    private static final Map<String, Boolean> DEFAULT_ORDER = CollectionUtils.getOrderList(Request.ID_COLUMN, false);

    private Date dateStart;
    private Date dateEnd;

    @Inject
    public PersonalAccountActivity(ClientFactory clientFactory, ViewFactory viewFactory) {
        super(clientFactory, viewFactory);
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus paramEventBus) {
        final IPersonalAccountView personalAccountView = getViewFactory().getPersonalAccountView();
        personalAccountView.setPresenter(this);
        container.setWidget(personalAccountView.asWidget());
    }

    @Override
    public void deleteRequest(Long requestId, AsyncCallback<RequestDTO> callbackDeleteOrder) {
        getRequestService().deleteRequest(requestId, callbackDeleteOrder);
    }

    @Override
    public void editRequest(RequestDTO request, AsyncCallback<RequestDTO> callbackEditOrder) {
        getRequestService().editRequest(request, callbackEditOrder);
    }

    @Override
    public void getStatusOfGroup(Long requestId, AsyncCallback<ExtendedRequestGroupDTO> callback) {
        getRequestService().getStatusOfGroup(requestId, callback);
    }

    @Override
    public void updateRowData(int startRow, int maxRows, RowDataAcceptor<ExtendedRequestDTO> acceptor) {
        updateRowData(startRow, maxRows, DEFAULT_ORDER, acceptor);
    }

    @Override
    public void updateRowCount(RowDataAcceptor<ExtendedRequestDTO> acceptor) {
        if (dateStart != null && dateEnd != null) {
            getRequestService().getRequestsForUserDateCount(dateStart, dateEnd,
                new PagingCountAsyncCallback<ExtendedRequestDTO>(acceptor));
        } else {
            acceptor.accept(0);
        }
    }

    @Override
    public void setProviderDates(Date dateStart, Date dateEnd) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    @Override
    public void updateRowData(int startRow, int maxRows, Map<String, Boolean> orderByList,
        RowDataAcceptor<ExtendedRequestDTO> acceptor) {
        if (dateStart != null && dateEnd != null) {
            getRequestService().getRequestsForUserDate(dateStart, dateEnd, startRow, maxRows, orderByList,
                new PagingDataAsyncCallback<ExtendedRequestDTO>(startRow, acceptor));
        } else {
            acceptor.accept(0, Collections.<ExtendedRequestDTO> emptyList());
        }
    }
}
