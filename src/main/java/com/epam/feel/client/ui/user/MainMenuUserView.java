package com.epam.feel.client.ui.user;

import static com.epam.feel.client.IEpamFeelConstants.CONSTANTS;
import static com.epam.feel.client.IEpamFeelMessages.MESSAGES;
import static com.epam.feel.shared.WebAppConstants.DATE_TIME_FORMATTER;
import static com.epam.feel.shared.WebAppConstants.SHORT_DATE_FORMATTER;
import static com.epam.feel.shared.WebAppConstants.SHORT_TIME_FORMATTER;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.epam.feel.client.activity.ApplicationActivity;
import com.epam.feel.client.ui.util.dialogs.MessageDialog;
import com.epam.feel.client.ui.util.role.IRoleChooser;
import com.epam.feel.client.ui.util.role.RoleChoseMainMenu;
import com.epam.feel.client.ui.util.table.MenuTable;
import com.epam.feel.client.view.IApplicationView;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.dto.MenuDTO;
import com.epam.feel.shared.dto.MenuDetailsDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.epam.feel.shared.dto.RequestDetailsDTO;
import com.epam.feel.shared.enums.RequestStatus;
import com.epam.feel.shared.exception.EstimatedRequestDetailsException;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Main client layout view implementation for order launch.
 * 
 * @author Anna_Gavrilina
 */
public class MainMenuUserView extends Composite implements IApplicationView, RoleChoseMainMenu {

    private static MenuClientViewUiBinder uiBinder = GWT.create(MenuClientViewUiBinder.class);

    interface MenuClientViewUiBinder extends UiBinder<Widget, MainMenuUserView> {}

    private IApplicationView.IApplicationPresenter applicationPresenter;

    private List<MenuDTO> menuDTO;
    private Map<Integer, MenuDTO> menuListToListBox = new HashMap<Integer, MenuDTO>();
    private List<RequestDetailsDTO> ordersList = null;
    private RequestDTO requestDTO = null;

    @UiField
    Label dateTakeRequest;
    @UiField
    Label timeFrom;
    @UiField
    Label timeTo;
    @UiField
    Label dateBecameRequest;
    @UiField
    Label deliveryTimeFrom;
    @UiField
    Label deliveryTimeTo;
    @UiField
    Label dateMenu;
    @UiField
    Label statusPostOrder;
    @UiField
    ListBox nameMenu;
    @UiField
    VerticalPanel menuPanel;
    @UiField
    MenuTable menu;
    @UiField
    VerticalPanel mainPanel;
    @UiField
    VerticalPanel noFindActiveMenusPanel;
    @UiField
    HorizontalPanel deliveryTimes;
    @UiField
    MainHeader header;
    @UiField
    Footer footer;

    public MainMenuUserView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public MainMenuUserView(ApplicationActivity applicationActivity) {
        this();
        setPresenter(applicationActivity);
        initUI();
    }

    private MenuDTO currentMenu() {
        MenuDTO result = null;
        if (nameMenu.getSelectedIndex() > -1) {
            result = menuListToListBox.get(nameMenu.getSelectedIndex());
        }
        return result;
    }

    /**
     * Run request to save order on current menu.
     * 
     * @param e
     *            {@link ClickEvent}
     */
    @UiHandler ({"orderLinkTop", "orderLinkBottom"})
    void onOrderLinkClicked(ClickEvent e) {
        if (currentMenu() != null) {
            Date currentDate = new Date();
            if (currentMenu().getReceiptStartDate().before(currentDate)
                && currentMenu().getReceiptEndDate().after(currentDate)) {
                ordersList = menu.generateRequestDetailsFromView();
                requestDTO = new RequestDTO(null, new Date(), RequestStatus.IN_PROCESS, null);
                requestDTO.setRequestDetails(ordersList);
                if (!ordersList.isEmpty()) {
                    applicationPresenter.getAllRequestForUser(currentMenu(), callbackRequestListForUser);

                } else {
                    MessageDialog.alert(CONSTANTS.dishesNotSelected());
                }
            } else {
                MessageDialog.alert(CONSTANTS.menuRegistrationDisabled());
            }
        } else {
            MessageDialog.alert(CONSTANTS.menuNotSelected());
        }
    }

    /**
     * Clear checked dish and set count dishes to zero.
     * 
     * @param event
     *            {@link ClickEvent}
     */
    @UiHandler ("nameMenu")
    void onNameMenuChange(ChangeEvent event) {
        MenuDTO currentMenu = currentMenu();
        if (currentMenu != null) {
            fillMenuHeader(currentMenu);
            menu.setObjects(currentMenu, null);
        }
    }

    @UiHandler ({"clearLinkTop", "clearLinkBottom"})
    void onClearLinkClicked(ClickEvent e) {
        menu.clearMenu();
    }

    /**
     * Callback for getting current MenuDTO.
     */
    private AsyncCallback<List<MenuDTO>> callbackMenu = new AsyncCallback<List<MenuDTO>>() {
        @Override
        public void onFailure(Throwable throwable) {
            GWT.log("MainMenuUserView.callbackMenu (err)", throwable);
        }

        @Override
        public void onSuccess(List<MenuDTO> menuDTOs) {
            menuDTO = menuDTOs;
            boolean menuFound = !menuDTOs.isEmpty();
            mainPanel.setVisible(menuFound);
            noFindActiveMenusPanel.setVisible(!menuFound);
            if (menuFound) {
                fillListBox(menuDTO);
                onNameMenuChange(null);
            }
        }
    };

    private void fillListBox(List<MenuDTO> menuDTO) {
        nameMenu.clear();
        menuListToListBox.clear();
        for (MenuDTO menu : menuDTO) {
            nameMenu.addItem(menu.getMenuName());
            menuListToListBox.put(nameMenu.getItemCount() - 1, menu);
        }
        if (nameMenu.getItemCount() > 0) {
            nameMenu.setSelectedIndex(0);
        }
    }

    /**
     * Callback for getting OrderDTO.
     */
    private AsyncCallback<RequestDTO> callbackOrders = new AsyncCallback<RequestDTO>() {
        @Override
        public void onFailure(Throwable throwable) {
            GWT.log("MainMenuUserView.callbackOrders (err)", throwable);
            if (throwable instanceof EstimatedRequestDetailsException) {
                EstimatedRequestDetailsException e = (EstimatedRequestDetailsException) throwable;
                MenuDetailsDTO details = e.getDetails();
                MessageDialog.alert(MESSAGES.requestedDishIsNotAvailable(details.getDishName(),
                    WebAppConstants.CURRENCY_FORMATTER.format(details.getPrice()), e.getAvailableCount().toString()));
            }
        }

        @Override
        public void onSuccess(RequestDTO result) {
            applicationPresenter.invalidateClientHeader();
            MessageDialog.alert(CONSTANTS.requestIsProcessing());
        }
    };

    private AsyncCallback<Boolean> callbackRequestListForUser = new AsyncCallback<Boolean>() {
        @Override
        public void onFailure(Throwable caught) {
            GWT.log("MainMenuUserView.callbackRequestListForUser (err)", caught);
        }

        @Override
        public void onSuccess(Boolean result) {
            if (!result) {
                applicationPresenter.makeOrder(requestDTO, callbackOrders);
            } else {
                MessageDialog.alert(CONSTANTS.unableToMakeMultipleRequests());
            }
        }
    };

    private void initUI() {
        menu.setShouldUseOnlyActiveMenuDetails(true);
        refreshData();
    }

    private void fillMenuHeader(MenuDTO menu) {
        if (menu.getReceiptStartDate() != null) {
            dateTakeRequest.setText(SHORT_DATE_FORMATTER.format(menu.getMenuOnDate()));
            timeFrom.setText(DATE_TIME_FORMATTER.format(menu.getReceiptStartDate()));
        }
        if (menu.getReceiptEndDate() != null) {
            timeTo.setText(DATE_TIME_FORMATTER.format(menu.getReceiptEndDate()));
        }
        deliveryTimes.setVisible((menu.getDeliveryStartDate() != null) || (menu.getDeliveryEndDate() != null));
        if (menu.getDeliveryStartDate() != null) {
            dateBecameRequest.setText(SHORT_DATE_FORMATTER.format(menu.getDeliveryStartDate()));
            deliveryTimeFrom.setText(SHORT_TIME_FORMATTER.format(menu.getDeliveryStartDate()));
        }
        if (menu.getDeliveryEndDate() != null) {
            deliveryTimeTo.setText(SHORT_TIME_FORMATTER.format(menu.getDeliveryEndDate()));
        }
        if (menu.getMenuOnDate() != null) {
            dateMenu.setText(SHORT_DATE_FORMATTER.format(menu.getMenuOnDate()));
        }
    }

    @Override
    public void setPresenter(ApplicationActivity applicationActivity) {
        this.applicationPresenter = applicationActivity;
        header.setPresenter(applicationPresenter.getHeader());
        footer.setPresenter(applicationPresenter.getFooter());
    }

    @Override
    public IRoleChooser getRoleChooser() {
        return header.getRoleChooser();
    }

    @Override
    public void refreshData() {
        mainPanel.setVisible(false);
        noFindActiveMenusPanel.setVisible(true);
        this.applicationPresenter.getActualMenus(callbackMenu);
    }
}
