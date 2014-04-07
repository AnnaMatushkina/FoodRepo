package com.epam.feel.client.activity;

import java.util.Map;
import com.epam.feel.client.mvp.ClientFactory;
import com.epam.feel.client.mvp.ViewFactory;
import com.epam.feel.client.ui.util.pagination.CollectionUtils;
import com.epam.feel.client.ui.util.pagination.PagingDataProvider;
import com.epam.feel.client.ui.util.pagination.ProvideredDataGrid.PagingCountAsyncCallback;
import com.epam.feel.client.ui.util.pagination.ProvideredDataGrid.PagingDataAsyncCallback;
import com.epam.feel.client.ui.util.pagination.SortablePagingDataProvider;
import com.epam.feel.client.view.IHistoryBalanceView;
import com.epam.feel.client.view.IPersonalHistoryBalanceView;
import com.epam.feel.server.model.Transaction;
import com.epam.feel.shared.dto.TransactionDTO;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class HistoryBalanceActivity extends PageTemplateActivity implements
    IHistoryBalanceView.IHistoryBalancePresenter {

    private PagingDataProvider<TransactionDTO> clientProvider;
    private static final Map<String, Boolean> DEFAULT_ORDER = CollectionUtils.getOrderList(Transaction.DATE_COLUMN,
        false);

    @Inject
    public HistoryBalanceActivity(ClientFactory clientFactory, ViewFactory viewFactory) {
        super(clientFactory, viewFactory);
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus paramEventBus) {
        final IPersonalHistoryBalanceView view = getViewFactory().getHistoryBalanceView();
        view.setPresenter(this);
        container.setWidget(view.asWidget());
        view.refreshData();
    }

    @Override
    public void updateRowData(final int startRow, final int maxRows, final RowDataAcceptor<TransactionDTO> acceptor) {
        updateRowData(startRow, maxRows, DEFAULT_ORDER, acceptor);
    }

    @Override
    public void updateRowData(int startRow, int maxRows, Map<String, Boolean> orderByList,
        RowDataAcceptor<TransactionDTO> acceptor) {
        getHistoryService().getAllTransactions(startRow, maxRows, orderByList,
            new PagingDataAsyncCallback<TransactionDTO>(startRow, acceptor));
    }

    @Override
    public void updateRowCount(final RowDataAcceptor<TransactionDTO> acceptor) {
        getHistoryService().getAllTransactionsCount(new PagingCountAsyncCallback<TransactionDTO>(acceptor));
    }

    @Override
    public PagingDataProvider<TransactionDTO> getProviderForClient() {
        if (clientProvider == null) {
            clientProvider = createProvider();
        }
        return clientProvider;
    }

    private SortablePagingDataProvider<TransactionDTO> createProvider() {
        return new SortablePagingDataProvider<TransactionDTO>() {

            @Override
            public void updateRowData(int startRow, int maxRows, RowDataAcceptor<TransactionDTO> acceptor) {
                updateRowData(startRow, maxRows, DEFAULT_ORDER, acceptor);
            }

            @Override
            public void updateRowCount(RowDataAcceptor<TransactionDTO> acceptor) {
                getHistoryService().getTransactionsOfCurrentClientCount(
                    new PagingCountAsyncCallback<TransactionDTO>(acceptor));
            }

            @Override
            public void updateRowData(int startRow, int maxRows, Map<String, Boolean> orderByList,
                RowDataAcceptor<TransactionDTO> acceptor) {
                getHistoryService().getTransactionsOfCurrentClient(startRow, maxRows, orderByList,
                    new PagingDataAsyncCallback<TransactionDTO>(startRow, acceptor));
            }

        };
    }
}