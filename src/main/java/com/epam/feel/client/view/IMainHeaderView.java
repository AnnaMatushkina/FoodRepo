package com.epam.feel.client.view;

import java.util.List;
import java.util.Map;
import com.epam.feel.shared.dto.ClientDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;

public interface IMainHeaderView extends IsWidget {

    public interface IMainHeaderPresenter {

        public void goToPersonalAccount();

        public void goToHistoryBalance();

        void getCurrentClient(AsyncCallback<ClientDTO> callback);

        void getActiveRequests(ClientDTO client, AsyncCallback<List<RequestDTO>> callback);

        void refreshActiveOrders();

        void advice(Boolean value, AsyncCallback<ClientDTO> callback);

        void logout(AsyncCallback<Map<String, String>> callback);

        void reloadCurrentClient(AsyncCallback<com.epam.feel.shared.dto.ClientDTO> callback);

        void goMainMenuUserView();
    }

    public void setPresenter(IMainHeaderPresenter presenter);

}
