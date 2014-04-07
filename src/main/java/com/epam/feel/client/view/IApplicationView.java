package com.epam.feel.client.view;

import java.util.List;
import com.epam.feel.client.activity.ApplicationActivity;
import com.epam.feel.shared.dto.MenuDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;

public interface IApplicationView extends IsWidget {

    public interface IApplicationPresenter extends ISuperPresenter {

        void getActualMenus(AsyncCallback<List<MenuDTO>> callback);

        void makeOrder(RequestDTO request, AsyncCallback<RequestDTO> callback);

        void invalidateClientHeader();

        void getAllRequestForUser(MenuDTO menuDTO, AsyncCallback<Boolean> callback);

    }

    public void setPresenter(ApplicationActivity applicationActivity);

}
