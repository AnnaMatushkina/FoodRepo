package com.epam.feel.client.activity;

import java.util.Map;
import com.epam.feel.client.mvp.ClientFactory;
import com.epam.feel.client.mvp.ViewFactory;
import com.epam.feel.client.ui.util.pagination.CollectionUtils;
import com.epam.feel.client.ui.util.pagination.PagingDataProvider;
import com.epam.feel.client.ui.util.pagination.ProvideredDataGrid.PagingCountAsyncCallback;
import com.epam.feel.client.ui.util.pagination.ProvideredDataGrid.PagingDataAsyncCallback;
import com.epam.feel.client.ui.util.pagination.SortablePagingDataProvider;
import com.epam.feel.client.view.IClientListView.IClientListViewPresenter;
import com.epam.feel.server.model.IClient;
import com.epam.feel.shared.dto.ClientDTO;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class ClientListViewActivity extends PageTemplateActivity implements IClientListViewPresenter {

    private static final Map<String, Boolean> DEFAULT_ORDER = CollectionUtils.getOrderList(IClient.NAME_COLUMN, false);
    private String name;

    @Inject
    public ClientListViewActivity(ClientFactory clientFactory, ViewFactory viewFactory) {
        super(clientFactory, viewFactory);
        this.name = null;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {}

    @Override
    public PagingDataProvider<ClientDTO> getClientsProvider() {
        return new SortablePagingDataProvider<ClientDTO>() {

            @Override
            public void updateRowData(int startRow, int maxRows, RowDataAcceptor<ClientDTO> acceptor) {
                updateRowData(startRow, maxRows, DEFAULT_ORDER, acceptor);
            }

            @Override
            public void updateRowCount(RowDataAcceptor<ClientDTO> acceptor) {
                getClientService().getClientsByNameCount(name, new PagingCountAsyncCallback<ClientDTO>(acceptor));
            }

            @Override
            public void updateRowData(int startRow, int maxRows, Map<String, Boolean> orderByList,
                RowDataAcceptor<ClientDTO> acceptor) {
                getClientService().getClientsByName(startRow, maxRows, name, orderByList,
                    new PagingDataAsyncCallback<ClientDTO>(startRow, acceptor));
            }

        };
    }

    @Override
    public void setNameFilterString(String likeString) {
        this.name = likeString;
    }

}
