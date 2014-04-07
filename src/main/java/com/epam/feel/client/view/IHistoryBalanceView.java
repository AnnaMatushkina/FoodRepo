package com.epam.feel.client.view;

import com.epam.feel.client.ui.util.pagination.PagingDataProvider;
import com.epam.feel.client.ui.util.pagination.SortablePagingDataProvider;
import com.epam.feel.shared.dto.TransactionDTO;
import com.google.gwt.user.client.ui.IsWidget;

public interface IHistoryBalanceView extends IsWidget {

    public interface IHistoryBalancePresenter extends ISuperPresenter, SortablePagingDataProvider<TransactionDTO> {

        public PagingDataProvider<TransactionDTO> getProviderForClient();

    }

    public void setPresenter(IHistoryBalancePresenter presenter);
}
