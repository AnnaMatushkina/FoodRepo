package com.epam.feel.client.view;

import java.util.Date;
import java.util.List;
import com.epam.feel.client.activity.ApplicationActivity;
import com.epam.feel.shared.dto.DishTypeDTO;
import com.epam.feel.shared.dto.MenuDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;

public interface ICreateMenuView extends IsWidget {

    public interface ICreateMenuPresenter extends ISuperPresenter {
        public void saveMenu(MenuDTO menuDTO, AsyncCallback<MenuDTO> callback);

        public void getLastMenus(Date start, Date end, AsyncCallback<List<MenuDTO>> callback);

        public void getLastMenusOrHavinRequests(AsyncCallback<List<MenuDTO>> callback);

        public void delMenu(Long menuId, AsyncCallback<Boolean> callback);

        public void getDishList(AsyncCallback<List<DishTypeDTO>> callback);

        public void setStatusMenu(MenuDTO menuDTO, boolean isOpen, AsyncCallback<MenuDTO> callback);

        public void getRequestedDishesCount(Long menuDetailsId, AsyncCallback<Integer> callback);

        public void saveImage(String fieldName, AsyncCallback<Long> callback);

    }

    public void setPresenter(ApplicationActivity applicationActivity);

}
