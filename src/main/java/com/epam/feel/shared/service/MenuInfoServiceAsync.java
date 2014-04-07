package com.epam.feel.shared.service;

import java.util.Date;
import java.util.List;
import com.epam.feel.shared.dto.DishTypeDTO;
import com.epam.feel.shared.dto.MenuDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * GWT-RPC service asynchronous (client-side) interface.
 * 
 * @see com.epam.feel.shared.service.MenuInfoService
 */
public interface MenuInfoServiceAsync {

    void getLastMenus(Date start, Date end, AsyncCallback<List<MenuDTO>> callback);

    void getActualMenus(AsyncCallback<List<MenuDTO>> callback);

    void getAllDishTypes(AsyncCallback<List<DishTypeDTO>> callback);

    void saveMenu(MenuDTO menuDTO, AsyncCallback<MenuDTO> callback);

    void removeMenu(Long menuId, AsyncCallback<Boolean> callback);

    void setStatusMenu(MenuDTO menuDTO, boolean isOpen, AsyncCallback<MenuDTO> callback);

    void checkRequestTime(AsyncCallback<Boolean> callback);

    void getRequestedDishesCount(Long menuDetailsId, AsyncCallback<Integer> callback);

    void generateMenuToNextDay(AsyncCallback<Void> callback);

    void getLastMenusOrHavingRequests(AsyncCallback<List<MenuDTO>> callback);

    void saveImage(String fieldName, AsyncCallback<Long> callback);

}
