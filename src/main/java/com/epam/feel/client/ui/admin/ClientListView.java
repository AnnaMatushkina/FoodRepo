package com.epam.feel.client.ui.admin;

import static com.epam.feel.client.IEpamFeelConstants.CONSTANTS;
import static com.epam.feel.client.IEpamFeelMessages.MESSAGES;
import java.util.Map;
import com.epam.feel.client.activity.ApplicationActivity;
import com.epam.feel.client.ui.util.dialogs.MessageDialog;
import com.epam.feel.client.ui.util.pagination.CollectionUtils;
import com.epam.feel.client.ui.util.pagination.FixedPager;
import com.epam.feel.client.ui.util.pagination.ProvideredDataGrid.OnDataAcceptedListener;
import com.epam.feel.client.ui.util.pagination.SortableColumn;
import com.epam.feel.client.ui.util.pagination.SortableProvideredDataGrid;
import com.epam.feel.client.view.IClientListView;
import com.epam.feel.server.model.IClient;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.dto.ClientDTO;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

/**
 * Clients list for payments and balance outputs.
 * 
 * @author Michael_Silvanovich
 */
public class ClientListView extends Composite implements IClientListView {

    interface ClientListViewUiBinder extends UiBinder<Widget, ClientListView> {};

    private static ClientListViewUiBinder uiBinder = GWT.create(ClientListViewUiBinder.class);

    private final SingleSelectionModel<ClientDTO> selectionModel = new SingleSelectionModel<ClientDTO>();

    @UiField
    HorizontalPanel filterPanel;
    @UiField
    Button submitFilter;
    @UiField
    TextBox filterBox;

    @UiField
    Label noDataLabel;
    @UiField
    VerticalPanel dataPanel;

    @UiField
    FixedPager clientsPager;
    @UiField
    SortableProvideredDataGrid<ClientDTO> clients;

    @UiField
    HorizontalPanel operationPanel;
    @UiField
    Button advance;
    @UiField
    Button outputBalance;

    private ApplicationActivity activity;
    private IClientListViewPresenter presenter;
    private ClientDTO selectedClient;

    private AsyncCallback<ClientDTO> paymentCallback = new AsyncCallback<ClientDTO>() {

        @Override
        public void onFailure(Throwable paramThrowable) {
            GWT.log("ListRequestView - paymentCallback (err)", paramThrowable);
        }

        @Override
        public void onSuccess(ClientDTO clientDTO) {
            selectedClient.setBalance(clientDTO.getBalance());
            refreshTableClients();
        }
    };

    private AsyncCallback<Double> outputBalanceCallback = new AsyncCallback<Double>() {
        @Override
        public void onFailure(Throwable throwable) {
            GWT.log("ListRequestView.callbackBalanceRefresh (err)", throwable);
        }

        @Override
        public void onSuccess(Double balance) {
            selectedClient.setBalance(0d);
            MessageDialog.alert(MESSAGES.balanceOutputted(WebAppConstants.CURRENCY_FORMATTER.format(balance)));
            refreshTableClients();
        }
    };

    private SelectionChangeEvent.Handler selectionHandler = new SelectionChangeEvent.Handler() {

        @Override
        public void onSelectionChange(SelectionChangeEvent arg0) {
            selectedClient = selectionModel.getSelectedObject();
            renderButtons(selectedClient);
        }

    };

    public ClientListView() {
        initWidget(uiBinder.createAndBindUi(this));
        initUi();
    }

    protected void initUi() {
        selectionModel.addSelectionChangeHandler(selectionHandler);
        clients.setDataAcceptedListener(new OnDataAcceptedListener() {

            @Override
            public void onDataAccepted(int startRow, int rowCount) {}

            @Override
            public void onSizeOfDataAccepted(int count) {
                noData(count == 0);
            }

            @Override
            public void onFailed(Throwable caught) {
                GWT.log("ClientListView - callbackFindClients (err)", caught);
                noData(true);
            }

        });
        initDataGridclients();
    }

    protected void noData(Boolean value) {
        noDataLabel.setVisible(value);
        dataPanel.setVisible(!value);
        operationPanel.setVisible(!value);
    }

    protected void initDataGridclients() {
        Column<ClientDTO, String> nameColumn = new SortableColumn<ClientDTO, String>(new TextCell()) {
            @Override
            public String getValue(ClientDTO object) {
                return object.getName();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(IClient.NAME_COLUMN, asc);
            }
        };
        clients.addColumn(nameColumn, CONSTANTS.clientNameColumn());
        clients.setColumnWidth(nameColumn, 220, Unit.PX);
        Column<ClientDTO, String> emailColumn = new SortableColumn<ClientDTO, String>(new TextCell()) {
            @Override
            public String getValue(ClientDTO object) {
                return object.getEmail();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(IClient.EMAIL_COLUMN, asc);
            }
        };
        clients.addColumn(emailColumn, CONSTANTS.emailColumn());
        clients.setColumnWidth(emailColumn, 220, Unit.PX);
        Column<ClientDTO, Number> numberColumn = new SortableColumn<ClientDTO, Number>(new NumberCell(
            WebAppConstants.ACCOUNT_NUMBER_FORMATTER)) {

            @Override
            public Number getValue(ClientDTO object) {
                return object.getId();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(IClient.ACCOUNT_ID_COLUMN, asc);
            }
        };
        clients.addColumn(numberColumn, CONSTANTS.personalAccountNumColumn());
        clients.setColumnWidth(numberColumn, 140, Unit.PX);
        Column<ClientDTO, String> balanceColumn = new SortableColumn<ClientDTO, String>(new TextCell()) {
            @Override
            public String getValue(ClientDTO object) {
                return WebAppConstants.CURRENCY_FORMATTER.format(object.getBalance());
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(IClient.BALANCE_COLUMN, asc);
            }
        };
        clients.addColumn(balanceColumn, CONSTANTS.balanceColumn());
        clients.setColumnWidth(balanceColumn, 140, Unit.PX);

        clients.setSelectionModel(selectionModel);
    }

    @Override
    public void setPresenter(ApplicationActivity activity) {
        this.activity = activity;
        this.presenter = activity.clientListViewPresenter;
        clients.setProvider(getPresenter().getClientsProvider());
    }

    @Override
    public IClientListViewPresenter getPresenter() {
        return presenter;
    }

    /**
     * Resets view state
     */
    public void reset() {
        ClientDTO selectedObject = selectionModel.getSelectedObject();
        if (selectedObject != null) {
            selectionModel.setSelected(selectedObject, false);
        }
        refreshTableClients();
    }

    /**
     * Refreshes table
     */
    public void refreshTableClients() {
        if (clientsPager.getDisplay() == null) {
            clientsPager.setDisplay(clients);
            clientsPager.setPageSize(WebAppConstants.ROWS_PER_PAGE);
        }
        clients.refreshData();
        renderButtons(selectedClient);
    }

    protected void renderButtons(ClientDTO client) {
        boolean isClientSelected = client != null;
        advance.setEnabled(isClientSelected);
        outputBalance.setEnabled(isClientSelected && client.getBalance() > 0.0);
    }

    @UiHandler ("advance")
    void onPrepaidRequestClicked(ClickEvent e) {
        makeAdvancePayment();
    }

    @UiHandler ("outputBalance")
    void onOutputBalanceClicked(ClickEvent e) {
        outputBalance();
    }

    private void makeAdvancePayment() {
        if (selectedClient != null) {
            new AdvancePaymentView(selectedClient.getId(), selectedClient.getName(), selectedClient.getBalance(),
                paymentCallback, activity).show();
        }
    }

    private void outputBalance() {
        if (selectedClient != null) {
            if (selectedClient.getBalance() > 0.0) {
                new OutputBalanceView(selectedClient.getId(), selectedClient.getName(), selectedClient.getBalance(),
                    outputBalanceCallback, activity).show();
            } else MessageDialog.alert(CONSTANTS.balanceIsEmpty());
        }
    }

    @UiHandler ("submitFilter")
    void onFilterSubmitted(ClickEvent e) {
        applyFilter();
    }

    @UiHandler ("filterBox")
    void onFilterSubmitted(KeyUpEvent e) {
        if (e.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER) {
            applyFilter();
        }
    }

    protected void applyFilter() {
        getPresenter().setNameFilterString(filterBox.getText());
        refreshTableClients();
    }

}
