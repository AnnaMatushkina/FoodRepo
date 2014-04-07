package com.epam.feel.client.activity;

import java.util.Date;
import java.util.List;
import com.epam.feel.client.mvp.ClientFactory;
import com.epam.feel.client.mvp.ViewFactory;
import com.epam.feel.client.view.ICreateMenuView;
import com.epam.feel.client.view.IFooterView;
import com.epam.feel.client.view.IMainHeaderView;
import com.epam.feel.shared.dto.DishTypeDTO;
import com.epam.feel.shared.dto.MenuDTO;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class CreateMenuActivity extends PageTemplateActivity implements ICreateMenuView.ICreateMenuPresenter {

    @Inject
    public IMainHeaderView.IMainHeaderPresenter mainHeaderPresenter;
    @Inject
    public IFooterView.IFooterPresenter footerPresenter;

    @Inject
    public CreateMenuActivity(ClientFactory clientFactory, ViewFactory viewFactory) {
        super(clientFactory, viewFactory);
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus paramEventBus) {}

    @Override
    public void getDishList(AsyncCallback<List<DishTypeDTO>> callback) {
        getMenuService().getAllDishTypes(callback);
    }

    @Override
    public IMainHeaderView.IMainHeaderPresenter getHeader() {
        return null;
    }

    @Override
    public IFooterView.IFooterPresenter getFooter() {
        return null;
    }

    @Override
    public void saveMenu(MenuDTO menuDTO, AsyncCallback<MenuDTO> callback) {
        getMenuService().saveMenu(menuDTO, callback);
    }

    @Override
    public void delMenu(Long menuId, AsyncCallback<Boolean> callback) {
        getMenuService().removeMenu(menuId, callback);
    }

    @Override
    public void getLastMenus(Date start, Date end, AsyncCallback<List<MenuDTO>> callback) {
        getMenuService().getLastMenus(start, end, callback);
    }

    @Override
    public void setStatusMenu(MenuDTO menuDTO, boolean isOpen, AsyncCallback<MenuDTO> callback) {
        getMenuService().setStatusMenu(menuDTO, isOpen, callback);
    }

    @Override
    public void saveImage(String fieldName, AsyncCallback<Long> callback) {
        getMenuService().saveImage(fieldName, callback);
    }

    @Override
    public void getRequestedDishesCount(Long menuDetailsId, AsyncCallback<Integer> callback) {
        getMenuService().getRequestedDishesCount(menuDetailsId, callback);
    }

    @Override
    public void getLastMenusOrHavinRequests(AsyncCallback<List<MenuDTO>> callback) {
        getMenuService().getLastMenusOrHavingRequests(callback);
    }

}
