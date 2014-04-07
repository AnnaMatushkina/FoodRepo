package com.epam.feel.client.view;

import java.util.List;
import com.epam.feel.shared.dto.ClientDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;

public interface IFooterView extends IsWidget {
    public interface IFooterPresenter {

        void getAdministrators(AsyncCallback<List<ClientDTO>> callback);
    }

    public void setPresenter(IFooterPresenter footerPresenter);
}
