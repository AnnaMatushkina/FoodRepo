package com.epam.feel.client.ui.admin;

import com.epam.feel.client.activity.ApplicationActivity;
import com.epam.feel.client.ui.user.Footer;
import com.epam.feel.client.ui.user.MainHeader;
import com.epam.feel.client.ui.util.approver.ApproveManager;
import com.epam.feel.client.ui.util.approver.ApproveableAction;
import com.epam.feel.client.ui.util.approver.Approver;
import com.epam.feel.client.ui.util.approver.HasApprovers;
import com.epam.feel.client.ui.util.pagination.FixedPager;
import com.epam.feel.client.ui.util.pagination.ProvideredDataGrid;
import com.epam.feel.client.ui.util.role.IRoleChooser;
import com.epam.feel.client.ui.util.role.RoleChoseMainMenu;
import com.epam.feel.shared.WebAppConstants;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.BeforeSelectionEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Main menu layout view implementation for administrator.
 * 
 * @author Anna_Gavrilina
 */
public class MainMenuAdminView extends Composite implements RoleChoseMainMenu, HasApprovers {

    private static final int TAB_MENU = 0;
    private static final int TAB_REQUEST = 1;
    private static final int TAB_CLIENT = 2;
    private static final int TAB_HISTORY = 3;

    private static final int STACK_PANEL_ACTIVE_REQUEST_INDEX = 0;
    private static final int STACK_PANEL_ARCHIVE_REQUEST_INDEX = 1;
    private static final int STACK_PANEL_GROUP_INDEX = 2;

    private static final int STACK_PANEL_HISTORY_MENU_INDEX = 0;
    private static final int STACK_PANEL_HISTORY_REQUEST_INDEX = 1;
    private static final int STACK_PANEL_HISTORY_GROUP_INDEX = 2;
    private static final int STACK_PANEL_HISTORY_NOTICE_INDEX = 3;
    private static final int STACK_PANEL_HISTORY_BALANCE_INDEX = 4;

    private static MainMenuViewUiBinder uiBinder = GWT.create(MainMenuViewUiBinder.class);

    interface MainMenuViewUiBinder extends UiBinder<Widget, MainMenuAdminView> {}

    @UiField
    TabLayoutPanel mainMenu;
    @UiField
    HistoryMenuView historyMenu;
    @UiField
    HistoryRequestView historyRequest;
    @UiField
    HistoryRequestGroupView historyRequestGroup;
    @UiField
    HistoryNotificationView historyNotification;
    @UiField
    HistoryBalanceView historyBalance;
    @UiField
    MainHeader header;
    @UiField
    Footer footer;
    @UiField
    CreateMenuView createMenuView;
    @UiField
    ListRequestView listRequest;
    @UiField
    ListActiveRequestView listActiveRequest;
    @UiField
    ListGroupRequestView listGroupRequest;
    @UiField
    StackLayoutPanel historyView;
    @UiField
    StackLayoutPanel requestsView;

    @UiField
    ClientListView clientListView;

    @UiField
    FixedPager balancePager;

    @UiField
    FixedPager notificationPager;

    @UiField
    FixedPager menuPager;

    @UiField
    FixedPager requestGroupPager;

    @UiField
    FixedPager requestPager;

    private ApproveManager approveManager = new ApproveManager();

    @UiHandler ("historyView")
    void onHistoryViewSelection(SelectionEvent<Integer> event) {
        refreshHistory(event.getSelectedItem());
    }

    @UiHandler ("requestsView")
    public void onRequestsViewSelection(SelectionEvent<Integer> paramSelectionEvent) {
        refreshRequestView(paramSelectionEvent.getSelectedItem());
    }

    @UiHandler ("mainMenu")
    void onPreMainMenuSelection(final BeforeSelectionEvent<Integer> event) {
        event.cancel();
        approveAction(new ApproveableAction() {
            @Override
            public void run(boolean approve) {
                if (approve) {
                    final Integer item = event.getItem();
                    mainMenu.selectTab(item, false);
                    SelectionEvent.fire(mainMenu, item);
                }
            }
        });
    }

    @UiHandler ("mainMenu")
    void onMainMenuSelection(SelectionEvent<Integer> event) {
        refreshMainMenu(event.getSelectedItem());
    }

    private void refreshMainMenu(int selectedItem) {
        if (selectedItem == TAB_MENU) {
            registerApprover(createMenuView);
        } else {
            unregisterApprover(createMenuView);
        }
        switch (selectedItem) {
            case TAB_MENU:
                createMenuView.refreshData();
                break;
            case TAB_CLIENT:
                clientListView.reset();
                break;
            case TAB_REQUEST:
                switch (requestsView.getVisibleIndex()) {
                    case STACK_PANEL_ARCHIVE_REQUEST_INDEX:
                        listRequest.refreshTableRequests();
                        break;
                    case STACK_PANEL_GROUP_INDEX:
                        listGroupRequest.refreshTableRequests();
                        break;
                    case STACK_PANEL_ACTIVE_REQUEST_INDEX:
                        listActiveRequest.reset();
                        break;
                    default:
                        break;
                }
                break;
            case TAB_HISTORY:
                refreshHistory(historyView.getVisibleIndex());
                break;
            default:
                break;
        }
    }

    private void refreshRequestView(int selectedItem) {
        if (mainMenu.getSelectedIndex() == TAB_REQUEST) {
            switch (selectedItem) {
                case STACK_PANEL_ARCHIVE_REQUEST_INDEX:
                    listRequest.reset();
                    break;
                case STACK_PANEL_GROUP_INDEX:
                    listGroupRequest.reset();
                    break;
                case STACK_PANEL_ACTIVE_REQUEST_INDEX:
                    listActiveRequest.reset();
                    break;
                default:
                    break;
            }
        }
    }

    private void refreshHistory(int selectedItem) {
        switch (selectedItem) {
            case STACK_PANEL_HISTORY_MENU_INDEX:
                selectGrid(menuPager, historyMenu);
                break;
            case STACK_PANEL_HISTORY_REQUEST_INDEX:
                selectGrid(requestPager, historyRequest);
                break;
            case STACK_PANEL_HISTORY_GROUP_INDEX:
                selectGrid(requestGroupPager, historyRequestGroup);
                break;
            case STACK_PANEL_HISTORY_NOTICE_INDEX:
                selectGrid(notificationPager, historyNotification);
                break;
            case STACK_PANEL_HISTORY_BALANCE_INDEX:
                selectGrid(balancePager, historyBalance);
                break;
            default:
                selectGrid(menuPager, historyMenu);
                break;
        }
    }

    public MainMenuAdminView() {}

    public MainMenuAdminView(ApplicationActivity applicationActivity) {
        initWidget(uiBinder.createAndBindUi(this));
        initMenuUI(applicationActivity);
    }

    private void initMenuUI(ApplicationActivity applicationActivity) {
        mainMenu.selectTab(TAB_MENU);
        footer.setPresenter(applicationActivity.getFooter());
        header.setPresenter(applicationActivity.getHeader());
        historyMenu.setPresenter(applicationActivity.historyMenuPresenter);
        historyBalance.setPresenter(applicationActivity.historyBalancePresenter);
        historyNotification.setPresenter(applicationActivity.historyNotificationPresenter);
        historyRequest.setPresenter(applicationActivity.historyRequestPresenter);
        historyRequestGroup.setPresenter(applicationActivity.historyRequestGroupPresenter);

        listRequest.setPresenter(applicationActivity);
        listActiveRequest.setPresenter(applicationActivity);
        listGroupRequest.setPresenter(applicationActivity.listGroupRequestPresenter);

        createMenuView.setPresenter(applicationActivity);

        header.registerAdminApprover(createMenuView);
        registerApprover(createMenuView);

        clientListView.setPresenter(applicationActivity);

    }

    @SuppressWarnings ("rawtypes")
    private void selectGrid(FixedPager pager, ProvideredDataGrid grid) {
        if (pager.getDisplay() == null) {
            pager.setDisplay(grid);
            pager.setPageSize(WebAppConstants.ROWS_PER_PAGE);
        }
        grid.refreshData();
    }

    @Override
    public void refreshData() {
        refreshMainMenu(mainMenu.getSelectedIndex());
    }

    @Override
    public IRoleChooser getRoleChooser() {
        return header.getRoleChooser();
    }

    @Override
    public void registerApprover(Approver approver) {
        approveManager.registerApprover(approver);
    }

    @Override
    public void unregisterApprover(Approver approver) {
        approveManager.unregisterApprover(approver);
    }

    @Override
    public void approveAction(ApproveableAction action) {
        approveManager.approveAction(action);
    }

}
