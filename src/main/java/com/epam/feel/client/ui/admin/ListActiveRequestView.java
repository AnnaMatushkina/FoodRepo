package com.epam.feel.client.ui.admin;

import static com.epam.feel.client.IEpamFeelConstants.CONSTANTS;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.epam.feel.client.activity.ApplicationActivity;
import com.epam.feel.client.ui.util.dialogs.MessageDialog;
import com.epam.feel.client.view.ICreateMenuView.ICreateMenuPresenter;
import com.epam.feel.shared.dto.MenuDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class ListActiveRequestView extends AbstractListRequestView<RequestDTO> {

    interface ListActiveRequestsViewUiBinder extends UiBinder<Widget, ListActiveRequestView> {};

    private static ListActiveRequestsViewUiBinder uiBinder = GWT.create(ListActiveRequestsViewUiBinder.class);

    private Map<Integer, MenuDTO> menus = new HashMap<Integer, MenuDTO>();

    private ICreateMenuPresenter createMenuPresenter;

    @UiField
    ListBox nameMenu;

    @UiField
    HorizontalPanel filterPanel;

    @UiField
    Anchor makeGroup;

    private AsyncCallback<Boolean> makeGroupCallback = new AsyncCallback<Boolean>() {

        @Override
        public void onFailure(Throwable caught) {
            GWT.log("ListActiveRequestView - makeGroupCallback (err)", caught);
        }

        @Override
        public void onSuccess(Boolean result) {
            if (result) {
                MessageDialog.alert(CONSTANTS.groupWasFormed());
            } else {
                MessageDialog.alert(CONSTANTS.emptyGroupRequests());
            }
        }

    };

    private AsyncCallback<List<MenuDTO>> getMenuCallback = new AsyncCallback<List<MenuDTO>>() {

        @Override
        public void onSuccess(List<MenuDTO> result) {
            onMenuLoaded(result);
        }

        @Override
        public void onFailure(Throwable caught) {
            GWT.log("[ERROR] - ListActiveRequestView: get menu callback - " + caught.getMessage());
        }
    };

    public ListActiveRequestView() {
        initWidget(uiBinder.createAndBindUi(this));
        initUi();
        noData(true);
    }

    @Override
    protected void noData(Boolean value) {
        makeGroup.setVisible(!value);
        super.noData(value);
    }

    @Override
    public void setPresenter(ApplicationActivity activity) {
        super.setPresenter(activity);
        this.createMenuPresenter = activity.createMenuPresenter;
        requests.setProvider(getPresenter().getActiveRequestsProvider());
    }

    @UiHandler ("makeGroup")
    void onMakeGroupClick(ClickEvent event) {
        MenuDTO menuDTO = currentMenu();
        if (menuDTO != null) {
            getPresenter().makeGroupRequest(makeGroupCallback);
        }
    }

    @UiHandler ("nameMenu")
    void onNameMenuChange(ChangeEvent event) {
        super.reset();
    }

    @Override
    public void reset() {
        viewVerticalPanel.setVisible(false);
        scheduleRefreshOnMenuLoaded();
    }

    @Override
    public void refreshTableRequests() {
        MenuDTO menu = currentMenu();
        if (menu != null) {
            getPresenter().setFilterMenu(menu);
        }
        super.refreshTableRequests();
    }

    private void scheduleRefreshOnMenuLoaded() {
        createMenuPresenter.getLastMenusOrHavinRequests(getMenuCallback);
    }

    protected void fireMenuSetChanged() {
        boolean notEmpty = nameMenu.getItemCount() > 0;
        filterPanel.setVisible(notEmpty);
        if (notEmpty) {
            if (nameMenu.getSelectedIndex() < 0) {
                nameMenu.setSelectedIndex(0);
            }
        }
        super.reset();
    }

    private MenuDTO currentMenu() {
        MenuDTO result = null;
        if (nameMenu.getSelectedIndex() > -1) {
            result = menus.get(nameMenu.getSelectedIndex());
        }
        return result;
    }

    protected void onMenuLoaded(List<MenuDTO> list) {
        nameMenu.clear();
        menus.clear();
        for (MenuDTO menu : list) {
            nameMenu.addItem(menu.getMenuName());
            menus.put(nameMenu.getItemCount() - 1, menu);
        }
        fireMenuSetChanged();
    }

}
