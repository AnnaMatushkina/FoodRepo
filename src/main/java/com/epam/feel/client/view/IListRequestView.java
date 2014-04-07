package com.epam.feel.client.view;

import com.epam.feel.client.activity.ApplicationActivity;
import com.epam.feel.client.ui.util.pagination.PagingDataProvider;
import com.epam.feel.shared.dto.ExtendedRequestDTO;
import com.epam.feel.shared.dto.ExtendedRequestGroupDTO;
import com.epam.feel.shared.dto.MenuDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;

public interface IListRequestView extends IsWidget {

    public interface IListRequestPresenter extends ISuperPresenter {
        public void editRequest(RequestDTO request, String reason, AsyncCallback<RequestDTO> callbackEditOrder);

        public void acceptRequest(Long requestId, AsyncCallback<RequestDTO> callbackAcceptOrder);

        public void payRequest(Long requestId, AsyncCallback<RequestDTO> callback);

        public void deleteRequest(Long requestId, boolean deleteGroup, String reason,
            AsyncCallback<RequestDTO> callbackDeleteOrder);

        public void declineRequest(Long requestId, boolean deleteGroup, String reason,
            AsyncCallback<RequestDTO> callbackDeclineOrder);

        public void completeRequest(Long requestId, AsyncCallback<RequestDTO> callbackCompleteOrder);

        public void getStatusOfGroup(Long requestId, AsyncCallback<ExtendedRequestGroupDTO> callback);

        public PagingDataProvider<ExtendedRequestDTO> getArchiveRequestsProvider();

        public PagingDataProvider<RequestDTO> getActiveRequestsProvider();

        public void setDishFilterString(String likeString);

        public void setFilterMenu(MenuDTO menu);

        public void makeGroupRequest(AsyncCallback<Boolean> callback);

    }

    public void setPresenter(ApplicationActivity activity);

}
