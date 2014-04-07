package com.epam.feel.client.view;

import java.util.List;
import com.epam.feel.client.ui.util.pagination.SortablePagingDataProvider;
import com.epam.feel.shared.dto.ExtendedRequestGroupDTO;
import com.epam.feel.shared.excel.Cell;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;

public interface IListGroupRequestView extends IsWidget {

    public interface IListGroupRequestPresenter extends ISuperPresenter,
        SortablePagingDataProvider<ExtendedRequestGroupDTO> {
        public void registerGroupRequests(Long groupId, AsyncCallback<Void> callbackRegGroup);

        public void deleteGroupRequests(Long groupId, String reason, AsyncCallback<Void> callbackDelGroup);

        public void saveExcelGroupRequests(List<Cell> cells, AsyncCallback<Void> callbackDelGroup);

        public void checkRequestTime(AsyncCallback<Boolean> callback);

        public void completeGroupRequests(Long groupId, AsyncCallback<ExtendedRequestGroupDTO> callbackRegGroup);

    }

    public void setPresenter(IListGroupRequestPresenter presenter);
}
