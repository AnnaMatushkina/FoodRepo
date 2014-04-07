package com.epam.feel.client.ui.user;

import static com.epam.feel.client.IEpamFeelConstants.CONSTANTS;
import static com.epam.feel.client.IEpamFeelMessages.MESSAGES;
import static com.epam.feel.client.IEpamFeelStatusConstants.STATUSES;
import static com.epam.feel.shared.WebAppConstants.CURRENCY_FORMATTER;
import static com.epam.feel.shared.WebAppConstants.DATE_TIME_FORMATTER;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import com.epam.feel.client.activity.ApplicationActivity;
import com.epam.feel.client.ui.util.approver.ApproveManager;
import com.epam.feel.client.ui.util.approver.ApproveableAction;
import com.epam.feel.client.ui.util.approver.ApproveableActionWithMessage;
import com.epam.feel.client.ui.util.approver.Approver;
import com.epam.feel.client.ui.util.approver.HasApprovers;
import com.epam.feel.client.ui.util.dialogs.DialogEvent;
import com.epam.feel.client.ui.util.dialogs.DialogEventHandler;
import com.epam.feel.client.ui.util.dialogs.MessageDialog;
import com.epam.feel.client.ui.util.role.ChooseRoleListener;
import com.epam.feel.client.ui.util.role.IRoleChooser;
import com.epam.feel.client.view.IMainHeaderView;
import com.epam.feel.server.filter.AuthorizationFilter;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.dto.ClientDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.epam.feel.shared.enums.RequestStatus;
import com.epam.feel.shared.enums.Role;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.Header;
import com.google.gwt.user.cellview.client.SafeHtmlHeader;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;

/**
 * Header of all pages. Header contains basic information about the user of the system.
 * 
 * @author Artem Tumasov (Artem_Tumasov@epam.com)
 */
@Singleton
public class MainHeader extends Composite implements IMainHeaderView, HasApprovers {
    private static HeaderViewUiBinder uiBinder = GWT.create(HeaderViewUiBinder.class);

    private final static String NUMBER_COLUMN_WIDTH = "40";
    private final static String DELIVERY_DATE_COLUMN_WIDTH = "70";
    private final static String COST_COLUMN_WIDTH = "80";
    private final static String STATUS_COLUMN_WIDTH = "60";

    interface HeaderViewUiBinder extends UiBinder<Widget, MainHeader> {}

    private IMainHeaderPresenter mainHeaderPresenter;

    private ClientDTO clientDTO;
    private boolean isAdminHeader = false;

    @UiField
    DataGrid<RequestDTO> requestsMenu;

    @UiField
    Anchor archiveRequestLink;

    @UiField
    Label numAccount;

    @UiField
    Label labelPrepayment;

    @UiField
    HorizontalPanel requestsPanel;

    @UiField
    DialogBox requestsTablePanel;

    @UiField
    Anchor balanceLink;

    @UiField
    HorizontalPanel paPanel;

    @UiField
    HorizontalPanel paymentPanel;

    @UiField
    Label requestsValue;

    @UiField
    RoleChooser roleChooser;

    @UiField
    Label personalAccountLabel;

    @UiField
    HorizontalPanel advicePanel;
    @UiField
    HorizontalPanel notAdvicePanel;

    private ApproveManager approveManager = new ApproveManager();
    private List<Approver> adminApprovers = new LinkedList<Approver>();
    private ApproveableAction exitAction = new ApproveableActionWithMessage(CONSTANTS.confirmHasChangesOnOtherAction()) {

        @Override
        public void run(boolean approve) {
            if (approve) {
                getMainHeaderPresenter().logout(callbackLogout);
            }
        }

    };

    public MainHeader(ApplicationActivity activity) {
        this();
        setPresenter(activity.getHeader());
    }

    @UiHandler ("headerTitle")
    void goToMainPage(ClickEvent e) {
        mainHeaderPresenter.goMainMenuUserView();
    }

    @UiHandler ("exit")
    void onExit(ClickEvent e) {
        approveAction(exitAction);
    }

    private AsyncCallback<Map<String, String>> callbackLogout = new AsyncCallback<Map<String, String>>() {
        @Override
        public void onFailure(Throwable throwable) {
            GWT.log("MainHeader.callbackLogaut (err)", throwable);
            Window.Location.reload();
        }

        @Override
        public void onSuccess(Map<String, String> result) {
            String path = result.get(WebAppConstants.AM_KEY_PATH_COOKIE);
            String domain = result.get(WebAppConstants.AM_KEY_DOMAIN_COOKIE);
            String host = result.get(WebAppConstants.AM_KEY_HOST);

            //
            // Cookies.removeCookieNative(AuthorizationFilter.TOKEN_PARAM_NAME, WebAppConstants.AM_DEFAULT_PATH);
            // Cookies.removeCookieNative(AuthorizationFilter.TOKEN_PARAM_NAME, path);
            // if (GWT.getHostPageBaseURL().toLowerCase().contains(domain.toLowerCase())) {
            // Cookies.setCookie(AuthorizationFilter.TOKEN_PARAM_NAME, StringUtils.EMPTY, new Date(0), domain, path,
            // false);
            // }

            String tokenKey = AuthorizationFilter.TOKEN_PARAM_NAME;
            if (host != null) {
                if (host.toLowerCase().contains(domain.toLowerCase())) {
                    tokenKey += domain;
                } else {
                    tokenKey += host;
                }
            }
            GWT.log(tokenKey);

            Cookies.removeCookieNative(tokenKey, WebAppConstants.AM_DEFAULT_PATH);
            Cookies.removeCookieNative(tokenKey, path);
            if (host != null && host.contains(domain.toLowerCase())) {
                Cookies.setCookie(tokenKey, StringUtils.EMPTY, new Date(0), domain, path, false);
            }

            Window.Location.reload();
        }
    };

    @UiHandler ("requestsAnchor")
    void onRequestsAnchorClicked(ClickEvent e) {
        requestsTablePanel.setVisible(true);
        requestsTablePanel.center();
        requestsTablePanel.setPopupPosition((Window.getClientWidth() - requestsMenu.getOffsetWidth()) / 2,
            (Window.getClientHeight() - requestsMenu.getOffsetHeight()) / 2);
        requestsTablePanel.show();
    }

    @UiHandler ("closeOrdersButton")
    void onCloseDialogClicked(ClickEvent e) {
        requestsTablePanel.hide();
    }

    @UiHandler ("balanceLink")
    void onBalanceLinkClicked(ClickEvent e) {
        this.mainHeaderPresenter.goToHistoryBalance();
    }

    @UiHandler ("archiveRequestLink")
    void onPersonalAccount(ClickEvent e) {
        if (!isAdminHeader) {
            this.mainHeaderPresenter.goToPersonalAccount();
        }
    }

    @UiHandler ({"adviceAnchor", "adviceImg"})
    void onAdviceBox(ClickEvent e) {
        this.mainHeaderPresenter.advice(true, callbackAdvised);
    }

    @UiHandler ({"notAdviceAnchor", "notAdviceImg"})
    void onNotAdviceBox(ClickEvent e) {
        MessageDialog.confirm(CONSTANTS.turnOffEmailConfirmMsg(), notAdviceConfirmation);
    }

    private DialogEventHandler<MessageDialog> notAdviceConfirmation = new DialogEventHandler.PositiveListener<MessageDialog>() {

        @Override
        public void onPositiveButtonClick(DialogEvent<MessageDialog> event) {
            mainHeaderPresenter.advice(false, callbackAdvised);
        }
    };

    private AsyncCallback<ClientDTO> callbackAdvised = new AsyncCallback<ClientDTO>() {
        @Override
        public void onFailure(Throwable caught) {
            GWT.log("MainHeader.callbackAdvised (err)", caught);
        }

        @Override
        public void onSuccess(ClientDTO result) {
            clientDTO = result;
            renderAdviceElement(!isAdminHeader, clientDTO.isAdvised());
        }

    };

    private AsyncCallback<ClientDTO> callbackFillClientInfo = new AsyncCallback<ClientDTO>() {
        @Override
        public void onFailure(Throwable throwable) {
            GWT.log("MainHeader.callbackFillClientInfo (err)", throwable);
        }

        @Override
        public void onSuccess(ClientDTO result) {
            clientDTO = result;
            outClientInfo(clientDTO);
            mainHeaderPresenter.getActiveRequests(clientDTO, callbackActiveRequestsInfo);
        }
    };

    private AsyncCallback<List<RequestDTO>> callbackActiveRequestsInfo = new AsyncCallback<List<RequestDTO>>() {
        @Override
        public void onFailure(Throwable throwable) {
            GWT.log("MainHeader.callbackActiveRequestsInfo (err)", throwable);
        }

        @Override
        public void onSuccess(List<RequestDTO> result) {
            outRequests(result);
        }
    };

    private AsyncCallback<ClientDTO> reloadCurrentClientCallback = new AsyncCallback<ClientDTO>() {
        @Override
        public void onFailure(Throwable caught) {
            GWT.log("MainHeader.reloadCurrentClientCallback (err)", caught);
        }

        @Override
        public void onSuccess(ClientDTO result) {
            clientDTO = result;
            if (!isAdminHeader) {
                outClientInfo(clientDTO);
            }
            mainHeaderPresenter.getActiveRequests(clientDTO, callbackActiveRequestsInfo);
        }
    };

    private void initUI() {
        renderAdviceElement(!isAdminHeader, false);
        paPanel.setVisible(!isAdminHeader);
        paymentPanel.setVisible(!isAdminHeader);
        archiveRequestLink.setVisible(!isAdminHeader);
        requestsPanel.setVisible(!isAdminHeader);
    }

    private void outClientInfo(ClientDTO clientDTO) {
        personalAccountLabel.setText(clientDTO.getName());
        numAccount.setText(clientDTO.getId().toString());
        labelPrepayment.setText(CURRENCY_FORMATTER.format(clientDTO.getBalance()));
        renderAdviceElement(!isAdminHeader, clientDTO.isAdvised());
    }

    private void renderAdviceElement(boolean isVisible, boolean isAdvice) {
        advicePanel.setVisible(isVisible && !isAdvice);
        notAdvicePanel.setVisible(isVisible && isAdvice);
    }

    private void outRequests(List<RequestDTO> requests) {
        archiveRequestLink.setVisible(!isAdminHeader);
        requestsPanel.setVisible(!isAdminHeader && !requests.isEmpty());
        requestsValue.setText(String.valueOf(requests.size()));
        requestsMenu.setRowData(requests);
    }

    public MainHeader() {
        initWidget(uiBinder.createAndBindUi(this));
        initUI();
        Column<RequestDTO, Number> numberColumn = new Column<RequestDTO, Number>(new NumberCell()) {
            @Override
            public Number getValue(RequestDTO object) {
                return object.getId();
            }
        };
        requestsMenu.addColumn(numberColumn, CONSTANTS.numberColumn());
        requestsMenu.setColumnWidth(numberColumn, NUMBER_COLUMN_WIDTH);
        Column<RequestDTO, Date> deliveryDateColumn = new Column<RequestDTO, Date>(new DateCell(DATE_TIME_FORMATTER)) {
            @Override
            public Date getValue(RequestDTO object) {
                return object.getDeliveryDate();
            }
        };
        requestsMenu.addColumn(deliveryDateColumn, CONSTANTS.deliveryDateColumn());
        requestsMenu.setColumnWidth(deliveryDateColumn, DELIVERY_DATE_COLUMN_WIDTH);
        Column<RequestDTO, Number> costColumn = new Column<RequestDTO, Number>(new NumberCell()) {
            @Override
            public Number getValue(RequestDTO object) {
                return object.getCost();
            }
        };

        Header<String> ageFooter = new Header<String>(new TextCell()) {
            @Override
            public String getValue() {
                double sumCostClientRequests = 0;
                List<RequestDTO> items = requestsMenu.getVisibleItems();
                for (RequestDTO request : items) {
                    if (request.getStatus() == RequestStatus.IN_PROCESS
                        || request.getStatus() == RequestStatus.ACCEPTED) {
                        sumCostClientRequests += request.getCost();
                    }
                }
                return MESSAGES.payable(WebAppConstants.CURRENCY_FORMATTER.format(sumCostClientRequests));
            }
        };
        requestsMenu.addColumn(costColumn,
            new SafeHtmlHeader(SafeHtmlUtils.fromSafeConstant(CONSTANTS.amountColumn())), ageFooter);
        requestsMenu.setColumnWidth(costColumn, COST_COLUMN_WIDTH);
        TextColumn<RequestDTO> statusColumn = new TextColumn<RequestDTO>() {
            @Override
            public String getValue(RequestDTO object) {
                return STATUSES.getString(object.getStatus().name());
            }
        };

        requestsMenu.addColumn(statusColumn, CONSTANTS.statusColumn());
        requestsMenu.setColumnWidth(statusColumn, STATUS_COLUMN_WIDTH);

    }

    @Override
    public void setPresenter(IMainHeaderPresenter presenter) {
        mainHeaderPresenter = presenter;
        mainHeaderPresenter.getCurrentClient(callbackFillClientInfo);
    }

    public IMainHeaderPresenter getMainHeaderPresenter() {
        return mainHeaderPresenter;
    }

    public boolean getIsAdminHeader() {
        return isAdminHeader;
    }

    public void setIsAdminHeader(boolean isAdminHeader) {
        this.isAdminHeader = isAdminHeader;
        initUI();
    }

    public IRoleChooser getRoleChooser() {
        mainHeaderPresenter.reloadCurrentClient(reloadCurrentClientCallback);
        return new RoleChooserProxy(roleChooser);
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

    public void registerAdminApprover(Approver approver) {
        if (approver != null) {
            registerApprover(approver);
            adminApprovers.add(approver);
        }
    }

    private void registerAdminApprovers() {
        for (Approver approver : adminApprovers) {
            registerApprover(approver);
        }
    }

    private void unregisterAdminApprovers() {
        for (Approver approver : adminApprovers) {
            unregisterApprover(approver);
        }
    }

    private class RoleChooserProxy implements IRoleChooser {

        private RoleChooser chooser;

        public RoleChooserProxy(RoleChooser chooser) {
            this.chooser = chooser;
        }

        @Override
        public void setListener(final ChooseRoleListener listener) {
            chooser.setListener(new ChooseRoleListener() {

                @Override
                public void onRoleChoosed(final Role role) {
                    if (role == Role.CLIENT) {
                        approveAction(new ApproveableAction() {

                            @Override
                            public void run(boolean approve) {
                                if (approve) {
                                    unregisterAdminApprovers();
                                    listener.onRoleChoosed(role);
                                }
                            }
                        });
                    } else {
                        registerAdminApprovers();
                        listener.onRoleChoosed(role);
                    }
                }
            });
        }

        @Override
        public void setVisible(boolean visible) {
            chooser.setVisible(visible);
        }

        @Override
        public void toggleRole(Role newRole) {
            chooser.toggleRole(newRole);
        }

    }
}
