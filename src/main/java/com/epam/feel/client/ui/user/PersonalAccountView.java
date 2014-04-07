package com.epam.feel.client.ui.user;

import static com.epam.feel.client.IEpamFeelConstants.CONSTANTS;
import static com.epam.feel.client.IEpamFeelMessages.MESSAGES;
import static com.epam.feel.client.IEpamFeelStatusConstants.STATUSES;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.epam.feel.client.ui.util.CalendarView;
import com.epam.feel.client.ui.util.dialogs.DialogEvent;
import com.epam.feel.client.ui.util.dialogs.DialogEventHandler;
import com.epam.feel.client.ui.util.dialogs.MessageDialog;
import com.epam.feel.client.ui.util.pagination.CollectionUtils;
import com.epam.feel.client.ui.util.pagination.FixedPager;
import com.epam.feel.client.ui.util.pagination.ProvideredDataGrid;
import com.epam.feel.client.ui.util.pagination.ProvideredDataGrid.OnDataAcceptedListener;
import com.epam.feel.client.ui.util.pagination.SortableColumn;
import com.epam.feel.client.ui.util.table.MenuTable;
import com.epam.feel.client.view.IPersonalAccountView;
import com.epam.feel.server.model.ExtendedRequest;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.dto.ExtendedRequestDTO;
import com.epam.feel.shared.dto.MenuDetailsDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.epam.feel.shared.enums.RequestStatus;
import com.epam.feel.shared.exception.EstimatedRequestDetailsException;
import com.epam.feel.shared.exception.RequestCantBeSavedException;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.Header;
import com.google.gwt.user.cellview.client.SafeHtmlHeader;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

/**
 * Personal account layout view implementation.
 * 
 * @author Anna_Gavrilina
 */
public class PersonalAccountView extends Composite implements IPersonalAccountView {

    private static PersonalAccountUiBinder uiBinder = GWT.create(PersonalAccountUiBinder.class);

    private RequestDTO selectedRequest;

    interface PersonalAccountUiBinder extends UiBinder<Widget, PersonalAccountView> {}

    private IPersonalAccountPresenter presenter;

    private final SingleSelectionModel<RequestDTO> selectionModel = new SingleSelectionModel<RequestDTO>();

    @UiField
    CalendarView dateStartBox;
    @UiField
    CalendarView dateEndBox;
    @UiField
    ProvideredDataGrid<ExtendedRequestDTO> orders;
    @UiField
    FixedPager ordersPager;
    @UiField
    MainHeader header;
    @UiField
    Footer footer;
    @UiField
    MenuTable viewOrderPanel;
    @UiField
    Label ordersLabel;
    @UiField
    Button editButton;
    @UiField
    Button delButton;
    @UiField
    HorizontalPanel widgetPanel;

    @UiHandler ("historyPersonalBalance")
    void onHistoryPersonalBalanceClicked(ClickEvent e) {
        header.getMainHeaderPresenter().goToHistoryBalance();
    }

    @UiHandler ("goToMain")
    void onGoToMain(ClickEvent e) {
        presenter.getHeader().goMainMenuUserView();
    }

    @UiHandler ("editButton")
    void onEditButtonClicked(ClickEvent e) {
        editOrder();
    }

    @UiHandler ("delButton")
    void onDelButtonClicked(ClickEvent e) {
        deleteOrder();
    }

    @UiHandler ("submitFilter")
    void onClickFilter(ClickEvent event) {
        if (dateStartBox.getValue() == null) {
            dateStartBox.setValue(new Date(0));
        }
        if (dateEndBox.getValue() == null) {
            dateEndBox.setValue(new Date());
        }
        refreshTableOrders();
    }

    public PersonalAccountView() {
        initWidget(uiBinder.createAndBindUi(this));
        initUI();
        orders.setVisible(false);
        widgetPanel.setVisible(orders.isVisible());
        ordersLabel.setVisible(!orders.isVisible());
        dateStartBox.setFormat(WebAppConstants.SHORT_DATE_FORMATTER);
        dateEndBox.setFormat(WebAppConstants.SHORT_DATE_FORMATTER);
    }

    @Override
    public void setPresenter(IPersonalAccountPresenter presenter) {
        this.presenter = presenter;
        header.setPresenter(presenter.getHeader());
        footer.setPresenter(presenter.getFooter());
        orders.setProvider(presenter);
        orders.setDataAcceptedListener(new OnDataAcceptedListener() {

            @Override
            public void onDataAccepted(int startRow, int rowCount) {}

            @Override
            public void onSizeOfDataAccepted(int count) {
                final boolean empty = count == 0;
                orders.setVisible(!empty);
                widgetPanel.setVisible(!empty);
                ordersLabel.setVisible(empty);
            }

            @Override
            public void onFailed(Throwable caught) {
                GWT.log("PersonalAccountView.callbackFindOrders (err)", caught);
            }

        });
        ordersPager.setDisplay(orders);
        ordersPager.setPageSize(WebAppConstants.ROWS_PER_PAGE);
        refreshTableOrders();
    }

    private void refreshTableOrders() {
        selectionModel.setSelected(selectionModel.getSelectedObject(), false);
        selectedRequest = null;
        viewOrderPanel.removeAllRows();
        presenter.setProviderDates(dateStartBox.getValue(), dateEndBox.getValue());
        orders.refreshData();
    }

    private void initUI() {
        Column<ExtendedRequestDTO, Number> numberColumn = new SortableColumn<ExtendedRequestDTO, Number>(
            new NumberCell()) {
            @Override
            public Number getValue(ExtendedRequestDTO object) {
                return object.getId();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(ExtendedRequest.ID_COLUMN, asc);
            }
        };
        orders.addColumn(numberColumn, CONSTANTS.numberColumn());
        orders.setColumnWidth(numberColumn, 10, Unit.PCT);
        Column<ExtendedRequestDTO, Date> dateColumn = new SortableColumn<ExtendedRequestDTO, Date>(new DateCell(
            WebAppConstants.SHORT_DATE_FORMATTER)) {
            @Override
            public Date getValue(ExtendedRequestDTO object) {
                return object.getCreateDate();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(ExtendedRequest.DATE_COLUMN, asc);
            }
        };
        orders.addColumn(dateColumn, CONSTANTS.requestDateColumn());
        orders.setColumnWidth(dateColumn, 15, Unit.PCT);
        Column<ExtendedRequestDTO, Date> deliveryDateColumn = new SortableColumn<ExtendedRequestDTO, Date>(
            new DateCell(WebAppConstants.SHORT_DATE_FORMATTER)) {
            @Override
            public Date getValue(ExtendedRequestDTO object) {
                return object.getDeliveryDate();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(ExtendedRequest.DELIVERY_DATE_COLUMN, asc);
            }
        };
        orders.addColumn(deliveryDateColumn, CONSTANTS.deliveryDateColumn());
        orders.setColumnWidth(deliveryDateColumn, 15, Unit.PCT);
        Column<ExtendedRequestDTO, String> menuNameColumn = new SortableColumn<ExtendedRequestDTO, String>(
            new TextCell()) {
            @Override
            public String getValue(ExtendedRequestDTO object) {
                return object.getMenuName();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(ExtendedRequest.MENU_NAME_COLUMN, asc);
            }
        };
        orders.addColumn(menuNameColumn, CONSTANTS.menuNameColumn());
        Column<ExtendedRequestDTO, String> costColumn = new SortableColumn<ExtendedRequestDTO, String>(new TextCell()) {
            @Override
            public String getValue(ExtendedRequestDTO object) {
                return WebAppConstants.CURRENCY_FORMATTER.format(object.getCost());
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(ExtendedRequest.COST_COLUMN, asc);
            }
        };
        Header<String> ageFooter = new Header<String>(new TextCell()) {
            @Override
            public String getValue() {
                double sumCostClientRequests = 0;
                List<ExtendedRequestDTO> items = orders.getVisibleItems();
                for (RequestDTO request : items) {
                    if (request.getStatus() == RequestStatus.IN_PROCESS
                        || request.getStatus() == RequestStatus.ACCEPTED) {
                        sumCostClientRequests += request.getCost();
                    }
                }
                return MESSAGES.payable(WebAppConstants.CURRENCY_FORMATTER.format(sumCostClientRequests));
            }
        };
        orders.addColumn(costColumn, new SafeHtmlHeader(SafeHtmlUtils.fromSafeConstant(CONSTANTS.amountColumn())),
            ageFooter);
        orders.setColumnWidth(costColumn, 12, Unit.PCT);

        Column<ExtendedRequestDTO, String> statusColumn = new SortableColumn<ExtendedRequestDTO, String>(new TextCell()) {
            @Override
            public String getValue(ExtendedRequestDTO object) {
                return STATUSES.getString(object.getStatus().name());
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(ExtendedRequest.STATUS_COLUMN, asc);
            }
        };
        orders.addColumn(statusColumn, CONSTANTS.statusColumn());
        orders.setColumnWidth(statusColumn, 12, Unit.PCT);

        selectionModel.addSelectionChangeHandler(selectionHandler);
        orders.setSelectionModel(selectionModel);
    }

    private SelectionChangeEvent.Handler selectionHandler = new SelectionChangeEvent.Handler() {

        @Override
        public void onSelectionChange(SelectionChangeEvent arg0) {
            selectedRequest = selectionModel.getSelectedObject();
            viewOrder();
        }

    };

    private void viewOrder() {
        viewOrderPanel.removeAllRows();
        if (selectedRequest != null) {
            viewOrderPanel.setObjects(selectedRequest.getMenu(), selectedRequest.getRequestDetails());
        }
    }

    private void editOrder() {
        if (selectedRequest != null) {
            RequestDTO request = new RequestDTO();
            request.copy(selectedRequest);
            request.setRequestDetails(viewOrderPanel.generateRequestDetailsFromView());
            presenter.editRequest(request, callbackEditOrder);
        }
    }

    private void deleteOrder() {
        if (selectedRequest != null) {
            if (RequestStatus.IN_PROCESS == selectedRequest.getStatus()
                || RequestStatus.DECLINED == selectedRequest.getStatus())
                MessageDialog.confirm(CONSTANTS.questionRemoveRequest(), deleteConfirmation);
            else MessageDialog.alert(CONSTANTS.unableToChangeRequest());
        }
    }

    private DialogEventHandler<MessageDialog> deleteConfirmation = new DialogEventHandler.PositiveListener<MessageDialog>() {

        @Override
        public void onPositiveButtonClick(DialogEvent<MessageDialog> event) {
            presenter.deleteRequest(selectedRequest.getId(), callbackDeleteOrder);
        }
    };

    private AsyncCallback<RequestDTO> callbackEditOrder = new AsyncCallback<RequestDTO>() {

        @Override
        public void onSuccess(RequestDTO request) {
            refreshTableOrders();
        }

        @Override
        public void onFailure(Throwable throwable) {
            GWT.log("PersonalAccountView.callbackEditOrder (err)", throwable);
            if (throwable instanceof EstimatedRequestDetailsException) {
                EstimatedRequestDetailsException e = (EstimatedRequestDetailsException) throwable;
                MenuDetailsDTO details = e.getDetails();
                MessageDialog.alert(MESSAGES.requestedDishIsNotAvailable(details.getDishName(),
                    WebAppConstants.CURRENCY_FORMATTER.format(details.getPrice()), e.getAvailableCount().toString()));
            } else if (throwable instanceof RequestCantBeSavedException) {
                RequestCantBeSavedException.Type type = ((RequestCantBeSavedException) throwable).getType();
                String message = null;
                switch (type) {
                    case EMPTY_REQUEST:
                        message = CONSTANTS.unableToSaveEmptyRequest();
                        break;
                    case REGISTRED_REQUEST:
                        message = CONSTANTS.groupIsRegistry();
                        break;
                    case NOT_IN_PROCESS_REQUEST:
                        message = CONSTANTS.unableToChangeRequest();
                        break;
                    default:
                        throw new IllegalStateException();
                }
                MessageDialog.alert(message);
            }
        }
    };

    private AsyncCallback<RequestDTO> callbackDeleteOrder = new AsyncCallback<RequestDTO>() {

        @Override
        public void onSuccess(RequestDTO request) {
            refreshTableOrders();
        }

        @Override
        public void onFailure(Throwable throwable) {
            GWT.log("PersonalAccountView.callbackDeleteOrder (err)", throwable);
        }
    };
}
