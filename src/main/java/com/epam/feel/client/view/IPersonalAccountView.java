package com.epam.feel.client.view;

import java.util.Date;
import com.epam.feel.client.ui.util.pagination.SortablePagingDataProvider;
import com.epam.feel.shared.dto.ExtendedRequestDTO;
import com.epam.feel.shared.dto.ExtendedRequestGroupDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;

public interface IPersonalAccountView extends IsWidget {

    public interface IPersonalAccountPresenter extends ISuperPresenter, SortablePagingDataProvider<ExtendedRequestDTO> {

        public void deleteRequest(Long requestId, AsyncCallback<RequestDTO> callbackDeleteOrder);

        public void editRequest(RequestDTO request, AsyncCallback<RequestDTO> callbackEditOrder);

        public void getStatusOfGroup(Long requestId, AsyncCallback<ExtendedRequestGroupDTO> callback);

        public void setProviderDates(Date dateStart, Date dateEnd);
    }

    public void setPresenter(IPersonalAccountPresenter presenter);
}
