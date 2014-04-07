package com.epam.feel.client.view;

import com.epam.feel.client.ui.util.pagination.SortablePagingDataProvider;
import com.epam.feel.shared.dto.OperationDTO;

public interface IHistoryRequestGroupView {

    public interface IHistoryRequestGroupPresenter extends ISuperPresenter, SortablePagingDataProvider<OperationDTO> {}

    public void setPresenter(IHistoryRequestGroupPresenter presenter);
}
