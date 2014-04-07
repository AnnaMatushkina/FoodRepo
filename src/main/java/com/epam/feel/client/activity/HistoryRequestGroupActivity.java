package com.epam.feel.client.activity;

import java.util.Map;
import com.epam.feel.client.mvp.ClientFactory;
import com.epam.feel.client.mvp.ViewFactory;
import com.epam.feel.client.ui.util.pagination.CollectionUtils;
import com.epam.feel.client.ui.util.pagination.ProvideredDataGrid.PagingCountAsyncCallback;
import com.epam.feel.client.ui.util.pagination.ProvideredDataGrid.PagingDataAsyncCallback;
import com.epam.feel.client.view.IHistoryRequestGroupView;
import com.epam.feel.server.model.Operation;
import com.epam.feel.shared.dto.OperationDTO;
import com.epam.feel.shared.enums.OperationType;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

/**
 * @author Evgeny_Neustroev
 */
public class HistoryRequestGroupActivity extends PageTemplateActivity implements
    IHistoryRequestGroupView.IHistoryRequestGroupPresenter {

    private static final Map<String, Boolean> DEFAULT_ORDER = CollectionUtils.getOrderList(Operation.DATE_COLUMN, false);

    @Inject
    public HistoryRequestGroupActivity(ClientFactory clientFactory, ViewFactory viewFactory) {
        super(clientFactory, viewFactory);
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {}

    @Override
    public void updateRowData(int startRow, int maxRows, RowDataAcceptor<OperationDTO> acceptor) {
        updateRowData(startRow, maxRows, DEFAULT_ORDER, acceptor);
    }

    @Override
    public void updateRowCount(RowDataAcceptor<OperationDTO> acceptor) {
        getHistoryService().getOperationsByTypeCount(OperationType.REQUEST_GROUP_CHANGED,
            new PagingCountAsyncCallback<OperationDTO>(acceptor));
    }

    @Override
    public void updateRowData(int startRow, int maxRows, Map<String, Boolean> orderByList,
        RowDataAcceptor<OperationDTO> acceptor) {
        getHistoryService().getOperationsByType(OperationType.REQUEST_GROUP_CHANGED, startRow, maxRows, orderByList,
            new PagingDataAsyncCallback<OperationDTO>(startRow, acceptor));
    }

}
