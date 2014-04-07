package com.epam.feel.client.ui.admin;

import static com.epam.feel.client.IEpamFeelConstants.CONSTANTS;
import static com.epam.feel.client.IEpamFeelMessages.MESSAGES;
import static com.epam.feel.client.IEpamFeelStatusConstants.STATUSES;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import com.epam.feel.client.activity.ApplicationActivity;
import com.epam.feel.client.ui.util.dialogs.DialogEvent;
import com.epam.feel.client.ui.util.dialogs.DialogEventHandler;
import com.epam.feel.client.ui.util.dialogs.MessageDialog;
import com.epam.feel.client.ui.util.dialogs.ReasonMessageBox;
import com.epam.feel.client.ui.util.pagination.CollectionUtils;
import com.epam.feel.client.ui.util.pagination.FixedPager;
import com.epam.feel.client.ui.util.pagination.ProvideredDataGrid;
import com.epam.feel.client.ui.util.pagination.ProvideredDataGrid.OnDataAcceptedListener;
import com.epam.feel.client.ui.util.pagination.SortableColumn;
import com.epam.feel.client.ui.util.table.MenuTable;
import com.epam.feel.client.view.IListRequestView;
import com.epam.feel.server.model.IRequest;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.dto.ClientDTO;
import com.epam.feel.shared.dto.ExtendedRequestGroupDTO;
import com.epam.feel.shared.dto.MenuDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.epam.feel.shared.dto.RequestDetailsDTO;
import com.epam.feel.shared.enums.GroupStatus;
import com.epam.feel.shared.enums.RequestStatus;
import com.epam.feel.shared.exception.RequestHasGroupException;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

/**
 * List of requests layout view implementation for administrator.
 * 
 * @author Evgeny_Kincharov
 */
public abstract class AbstractListRequestView<T extends RequestDTO> extends Composite implements IListRequestView {

    protected final SingleSelectionModel<RequestDTO> selectionModel = new SingleSelectionModel<RequestDTO>();

    private IListRequestPresenter presenter;
    private ApplicationActivity activity;
    protected RequestDTO selectedRequest;
    protected ReasonMessageBox declineMessage = new ReasonMessageBox();
    protected ReasonMessageBox deleteMessage = new ReasonMessageBox();
    protected ReasonMessageBox changeMessage = new ReasonMessageBox();

    private void initDialogs() {
        declineMessage.addDialogEventHandler(declineRequestHandler);
        declineMessage.setText(CONSTANTS.declineReason());

        deleteMessage.addDialogEventHandler(deleteRequestHandler);
        deleteMessage.setText(CONSTANTS.deleteReason());

        changeMessage.addDialogEventHandler(changeRequestHandler);
        changeMessage.setText(CONSTANTS.changeReason());
    }

    public AbstractListRequestView() {}

    @Override
    public void setPresenter(ApplicationActivity activity) {
        this.activity = activity;
        this.presenter = activity.listRequestPresenter;
    }

    /**
     * Returns presenter set to this
     * 
     * @return presenter set to this
     */
    public IListRequestPresenter getPresenter() {
        return presenter;
    }

    protected void initUi() {
        selectionModel.addSelectionChangeHandler(selectionHandler);
        requests.setDataAcceptedListener(new OnDataAcceptedListener() {

            @Override
            public void onDataAccepted(int startRow, int rowCount) {}

            @Override
            public void onSizeOfDataAccepted(int count) {
                noData(count == 0);
            }

            @Override
            public void onFailed(Throwable caught) {
                GWT.log("ListRequestView - callbackFindRequests (err)", caught);
                noData(true);
            }

        });
        initDataGridRequests();
        initDialogs();
    }

    public AbstractListRequestView(ApplicationActivity applicationActivity) {
        this();
        setPresenter(applicationActivity);
        refreshTableRequests();
        initDialogs();
    }

    @UiField
    Button changeRequest;
    @UiField
    Button payForRequest;
    @UiField
    Button acceptRequest;
    @UiField
    Button declineRequest;
    @UiField
    Button prepaidRequest;
    @UiField
    Button outputBalance;
    @UiField
    Button completeRequest;
    @UiField
    Button deleteRequest;
    @UiField
    Label noDataLabel;
    @UiField
    VerticalPanel dataPanel;
    @UiField
    ProvideredDataGrid<T> requests;
    @UiField
    FixedPager requestsPager;
    @UiField
    VerticalPanel viewVerticalPanel;
    @UiField
    MenuTable viewRequestPanel;

    @UiField
    Label menuNameLabel;

    protected void noData(Boolean value) {
        noDataLabel.setVisible(value);
        dataPanel.setVisible(!value);
    }

    @UiHandler ("changeRequest")
    void onChangeRequestClicked(ClickEvent e) {
        presenter.getStatusOfGroup(selectedRequest.getId(), callbackStatusOfGroupChangeRequest);

    }

    @UiHandler ("acceptRequest")
    void onAcceptRequestClicked(ClickEvent e) {
        acceptRequest();
    }

    @UiHandler ("payForRequest")
    void onPayForRequestClicked(ClickEvent e) {
        payForRequest();
    }

    @UiHandler ("declineRequest")
    void onCancelRequestClicked(ClickEvent e) {
        MessageDialog.confirm(MESSAGES.declineRequestConfirmation(selectedRequest.getId().toString(), selectedRequest
            .getClient().getName()), closeHandlerDeclineMessage);
    }

    @UiHandler ("completeRequest")
    void onCloseRequestClicked(ClickEvent e) {
        completeRequest();
    }

    @UiHandler ("deleteRequest")
    void onDeleteRequestClicked(ClickEvent e) {
        MessageDialog.confirm(MESSAGES.deleteRequestConfirmation(selectedRequest.getId().toString(), selectedRequest
            .getClient().getName()), new DialogEventHandler.PositiveListener<MessageDialog>() {
            @Override
            public void onPositiveButtonClick(DialogEvent<MessageDialog> event) {
                deleteMessage.center();
            }
        });
    }

    @UiHandler ("prepaidRequest")
    void onPrepaidRequestClicked(ClickEvent e) {
        prepaidRequest();
    }

    @UiHandler ("outputBalance")
    void onOutputBalanceClicked(ClickEvent e) {
        outputBalance();
    }

    private AsyncCallback<ExtendedRequestGroupDTO> callbackStatusOfGroupChangeRequest = new AsyncCallback<ExtendedRequestGroupDTO>() {
        @Override
        public void onFailure(Throwable caught) {
            GWT.log("ListRequestView.callbackStatusOfGroup (err)", caught);
        }

        @Override
        public void onSuccess(final ExtendedRequestGroupDTO result) {
            if (result == null || result.getStatus() == GroupStatus.DELETED) {
                MessageDialog.confirm(MESSAGES.changeRequestConfirmation(selectedRequest.getId().toString(),
                    selectedRequest.getClient().getName()), closeHandlerChangeMessage);
            } else {
                MessageDialog.confirm(MESSAGES.changeRequestAndDellGroupConfirmation(
                    selectedRequest.getId().toString(), selectedRequest.getClient().getName()),
                    closeHandlerChangeMessage);
            }
        }
    };

    private DialogEventHandler<MessageDialog> closeHandlerDeclineMessage = new DialogEventHandler.PositiveListener<MessageDialog>() {

        @Override
        public void onPositiveButtonClick(DialogEvent<MessageDialog> event) {
            declineMessage.center();
        }
    };

    private DialogEventHandler<MessageDialog> closeHandlerChangeMessage = new DialogEventHandler.PositiveListener<MessageDialog>() {

        @Override
        public void onPositiveButtonClick(DialogEvent<MessageDialog> event) {
            changeMessage.center();
        }
    };

    private DialogEventHandler<ReasonMessageBox> declineRequestHandler = new DialogEventHandler.PositiveListener<ReasonMessageBox>() {

        @Override
        public void onPositiveButtonClick(DialogEvent<ReasonMessageBox> event) {
            ReasonMessageBox messageBox = (ReasonMessageBox) event.getSource();
            final String reason = messageBox.getReason();
            if (!reason.isEmpty()) {
                declineRequest(false);
            }
        }

    };

    private DialogEventHandler<ReasonMessageBox> deleteRequestHandler = new DialogEventHandler.PositiveListener<ReasonMessageBox>() {

        @Override
        public void onPositiveButtonClick(DialogEvent<ReasonMessageBox> event) {
            ReasonMessageBox messageBox = (ReasonMessageBox) event.getSource();
            final String reason = messageBox.getReason();
            final boolean reasonEmpty = reason.isEmpty();
            if (!reasonEmpty) {
                deleteRequest(false);
            }
        }

    };

    private DialogEventHandler<ReasonMessageBox> changeRequestHandler = new DialogEventHandler.PositiveListener<ReasonMessageBox>() {

        @Override
        public void onPositiveButtonClick(DialogEvent<ReasonMessageBox> event) {
            ReasonMessageBox messageBox = (ReasonMessageBox) event.getSource();
            if (!messageBox.getReason().isEmpty()) {
                editRequest();
                messageBox.setReason(StringUtils.EMPTY);
            }
        }

    };

    private AsyncCallback<RequestDTO> callbackDeclineRequest = new AsyncCallback<RequestDTO>() {

        @Override
        public void onFailure(final Throwable throwable) {
            GWT.log("ListRequestView - callbackDeleteRequest (err)", throwable);
            if (throwable instanceof RequestHasGroupException) {
                MessageDialog.confirm(MESSAGES.declineRequestAndDellGroupConfirmation(selectedRequest.getId()
                    .toString(), selectedRequest.getClient().getName()),

                new DialogEventHandler.PositiveListener<MessageDialog>() {

                    @Override
                    public void onPositiveButtonClick(DialogEvent<MessageDialog> event) {
                        declineRequest(true);
                    }
                });

            }
        }

        @Override
        public void onSuccess(RequestDTO request) {
            selectedRequest = null;
            refreshTableRequests();
        }
    };

    private AsyncCallback<RequestDTO> callbackDeleteRequest = new AsyncCallback<RequestDTO>() {

        @Override
        public void onFailure(final Throwable throwable) {
            GWT.log("ListRequestView - callbackDeleteRequest (err)", throwable);
            if (throwable instanceof RequestHasGroupException) {
                MessageDialog.confirm(MESSAGES.deleteRequestFromGroupConfirmation(selectedRequest.getId().toString(),
                    selectedRequest.getClient().getName()),

                new DialogEventHandler.PositiveListener<MessageDialog>() {

                    @Override
                    public void onPositiveButtonClick(DialogEvent<MessageDialog> event) {
                        deleteRequest(true);
                        deleteMessage.setReason(StringUtils.EMPTY);
                    }
                });

            }
        }

        @Override
        public void onSuccess(RequestDTO request) {
            selectedRequest = null;
            refreshTableRequests();
        }
    };

    private AsyncCallback<RequestDTO> callbackRefreshRequest = new AsyncCallback<RequestDTO>() {

        @Override
        public void onFailure(Throwable throwable) {
            GWT.log("ListRequestView - callbackRefreshRequest (err)", throwable);
        }

        @Override
        public void onSuccess(RequestDTO request) {
            selectedRequest.copy(request);
            refreshTableRequests();
        }
    };

    private AsyncCallback<ClientDTO> paymentCallback = new AsyncCallback<ClientDTO>() {

        @Override
        public void onFailure(Throwable paramThrowable) {
            GWT.log("ListRequestView - paymentCallback (err)", paramThrowable);
        }

        @Override
        public void onSuccess(ClientDTO clientDTO) {
            if (selectedRequest != null) {
                selectedRequest.setClient(clientDTO);
                if (selectedRequest.getStatus() == RequestStatus.ACCEPTED) {

                    MessageDialog.confirm(
                        MESSAGES.payConfirmation(selectedRequest.getId().toString(), clientDTO.getName()),
                        new DialogEventHandler.PositiveListener<MessageDialog>() {

                            @Override
                            public void onPositiveButtonClick(DialogEvent<MessageDialog> event) {
                                if (selectedRequest.getStatus() != RequestStatus.ACCEPTED
                                    && selectedRequest.getClient().getBalance() < selectedRequest.getCost()) {
                                    MessageDialog.alert(MESSAGES.insufficientFunds(selectedRequest.getId().toString(),
                                        selectedRequest.getClient().getName()));
                                } else {
                                    presenter.payRequest(selectedRequest.getId(), callbackPayRequest);
                                }
                            }

                        });
                }
            }
            refreshTableRequests();
        }
    };

    private AsyncCallback<RequestDTO> callbackPayRequest = new AsyncCallback<RequestDTO>() {
        @Override
        public void onFailure(Throwable caught) {
            GWT.log("ListRequestView.callbackPayRequest (err)", caught);
        }

        @Override
        public void onSuccess(RequestDTO result) {
            selectedRequest = result;
            refreshTableRequests();
        }
    };

    protected void initDataGridRequests() {
        Column<T, Number> numberColumn = new SortableColumn<T, Number>(new NumberCell()) {
            @Override
            public Number getValue(T object) {
                return object.getId();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(IRequest.ID_COLUMN, asc);
            }
        };
        requests.addColumn(numberColumn, CONSTANTS.numberColumn());
        requests.setColumnWidth(numberColumn, 100, Unit.PX);
        Column<T, Date> dateColumn = new SortableColumn<T, Date>(new DateCell(WebAppConstants.DATE_TIME_FORMATTER)) {
            @Override
            public Date getValue(T object) {
                return object.getCreateDate();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(IRequest.DATE_COLUMN, asc);
            }
        };
        requests.addColumn(dateColumn, CONSTANTS.dateColumn());
        requests.setColumnWidth(dateColumn, 130, Unit.PX);
        Column<T, String> clientColumn = new SortableColumn<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return object.getClient().getName();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(IRequest.CLIENT_NAME_COLUMN, asc);
            }
        };
        requests.addColumn(clientColumn, CONSTANTS.clientNameColumn());
        requests.setColumnWidth(clientColumn, 180, Unit.PX);
        Column<T, String> costColumn = new SortableColumn<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return WebAppConstants.CURRENCY_FORMATTER.format(object.getCost());
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(IRequest.COST_COLUMN, asc);
            }
        };
        requests.addColumn(costColumn, CONSTANTS.costColumn());
        requests.setColumnWidth(costColumn, 140, Unit.PX);
        Column<T, String> statusColumn = new SortableColumn<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return STATUSES.getString(object.getStatus().name());
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(IRequest.STATUS_COLUMN, asc);
            }
        };
        requests.addColumn(statusColumn, CONSTANTS.statusColumn());
        requests.setColumnWidth(statusColumn, 100, Unit.PX);

        requests.setSelectionModel(selectionModel);
    }

    protected SelectionChangeEvent.Handler selectionHandler = new SelectionChangeEvent.Handler() {

        @Override
        public void onSelectionChange(SelectionChangeEvent arg0) {
            selectedRequest = selectionModel.getSelectedObject();
            viewRequest();
        }

    };

    private DialogEventHandler<MessageDialog> payForRequestDialogHandler = new DialogEventHandler<MessageDialog>() {

        @Override
        public void onPositiveButtonClick(DialogEvent<MessageDialog> event) {
            presenter.payRequest(selectedRequest.getId(), callbackRefreshRequest);
        }

        @Override
        public void onNegativeButtonClick(DialogEvent<MessageDialog> event) {}

    };

    protected void viewRequest() {
        viewRequestPanel.removeAllRows();
        boolean isRequestSelected = selectedRequest != null;
        viewVerticalPanel.setVisible(isRequestSelected);
        if (isRequestSelected) {
            renderButtons(selectedRequest);
            MenuDTO menu = selectedRequest.getMenu();
            menuNameLabel.setText(menu.getMenuName());
            viewRequestPanel.setObjects(menu, selectedRequest.getRequestDetails());
        } else {
            viewRequestPanel.setObjects(null, null);
        }
    }

    protected void renderButtons(RequestDTO request) {
        switch (request.getStatus()) {
            case IN_PROCESS:
                defaultButtonsVisability();
                break;
            case ACCEPTED:
                changeRequest.setVisible(false);
                acceptRequest.setVisible(false);
                declineRequest.setVisible(false);
                completeRequest.setVisible(false);
                payForRequest.setVisible(true);
                deleteRequest.setVisible(true);
                prepaidRequest.setVisible(true);
                break;
            case DECLINED:
                changeRequest.setVisible(true);
                acceptRequest.setVisible(false);
                declineRequest.setVisible(false);
                completeRequest.setVisible(false);
                payForRequest.setVisible(false);
                deleteRequest.setVisible(true);
                prepaidRequest.setVisible(false);
                break;
            case PAID:
                changeRequest.setVisible(false);
                acceptRequest.setVisible(false);
                declineRequest.setVisible(false);
                completeRequest.setVisible(true);
                payForRequest.setVisible(false);
                deleteRequest.setVisible(true);
                prepaidRequest.setVisible(true);
                break;
            case DELETED:
                hideButtons(false);
                break;
            case PERFORMED:
                hideButtons(false);
                break;
            default:
                defaultButtonsVisability();
                break;
        }
    }

    protected void defaultButtonsVisability() {
        changeRequest.setVisible(true);
        acceptRequest.setVisible(true);
        declineRequest.setVisible(true);
        completeRequest.setVisible(false);
        deleteRequest.setVisible(true);
        prepaidRequest.setVisible(true);
        payForRequest.setVisible(false);
    }

    protected void hideButtons(boolean isNotHide) {
        changeRequest.setVisible(isNotHide);
        acceptRequest.setVisible(isNotHide);
        declineRequest.setVisible(isNotHide);
        completeRequest.setVisible(isNotHide);
        deleteRequest.setVisible(isNotHide);
        prepaidRequest.setVisible(isNotHide);
        payForRequest.setVisible(isNotHide);
    }

    /**
     * Refreshes table
     */
    public void refreshTableRequests() {
        if (requestsPager.getDisplay() == null) {
            requestsPager.setDisplay(requests);
            requestsPager.setPageSize(WebAppConstants.ROWS_PER_PAGE);
        }
        requests.refreshData();
        viewRequest();
        if (selectedRequest != null)
            renderButtons(selectedRequest);
    }

    /**
     * Resets view state
     */
    public void reset() {
        RequestDTO selectedObject = selectionModel.getSelectedObject();
        if (selectedObject != null) {
            selectionModel.setSelected(selectedObject, false);
        }
        refreshTableRequests();
    }

    private void editRequest() {
        if (selectedRequest != null) {
            List<RequestDetailsDTO> details = viewRequestPanel.generateRequestDetailsFromView();
            if (!details.isEmpty()) {
                selectedRequest.setRequestDetails(details);
                if (selectedRequest.getStatus() == RequestStatus.DECLINED)
                    selectedRequest.setStatus(RequestStatus.IN_PROCESS);
                presenter.editRequest(selectedRequest, changeMessage.getReason(), callbackRefreshRequest);
            } else {
                MessageDialog.alert(CONSTANTS.unableToSaveEmptyRequest());
            }
        }
    }

    private void acceptRequest() {
        if (selectedRequest != null) {
            if (selectedRequest.getClient().getBalance() < selectedRequest.getCost()) {
                MessageDialog.alert(MESSAGES.insufficientFundsForAccept(selectedRequest.getId().toString(),
                    selectedRequest.getClient().getName()));
            } else {
                presenter.acceptRequest(selectedRequest.getId(), callbackRefreshRequest);
            }
        }
    }

    private void payForRequest() {
        if (selectedRequest != null) {
            MessageDialog.confirm(CONSTANTS.payForRequestConfirmation(), payForRequestDialogHandler);
        }
    }

    private void declineRequest(boolean deleteGroup) {
        if (selectedRequest != null) {
            presenter.declineRequest(selectedRequest.getId(), deleteGroup, declineMessage.getReason(),
                callbackDeclineRequest);
        }
    }

    private void completeRequest() {
        if (selectedRequest != null) {
            MessageDialog.confirm(MESSAGES.closeRequestConfirmation(selectedRequest.getId().toString(), selectedRequest
                .getClient().getName()),

            new DialogEventHandler.PositiveListener<MessageDialog>() {

                @Override
                public void onPositiveButtonClick(DialogEvent<MessageDialog> event) {
                    presenter.completeRequest(selectedRequest.getId(), callbackRefreshRequest);
                }

            });
        }
    }

    private void deleteRequest(boolean deleteGroup) {
        if (selectedRequest != null) {
            presenter.deleteRequest(selectedRequest.getId(), deleteGroup, deleteMessage.getReason(),
                callbackDeleteRequest);
        }
    }

    private void prepaidRequest() {
        if (selectedRequest != null) {
            ClientDTO client = selectedRequest.getClient();
            new AdvancePaymentView(client.getId(), client.getName(), client.getBalance(), paymentCallback, activity)
                .show();
        }
    }

    private void outputBalance() {
        if (selectedRequest != null) {
            if (selectedRequest.getClient().getBalance() > 0.0) {
                ClientDTO client = selectedRequest.getClient();
                new OutputBalanceView(client.getId(), client.getName(), client.getBalance(), outputBalanceCallback,
                    activity).show();
            } else MessageDialog.alert(CONSTANTS.balanceIsEmpty());
        }
    }

    private AsyncCallback<Double> outputBalanceCallback = new AsyncCallback<Double>() {
        @Override
        public void onFailure(Throwable throwable) {
            GWT.log("ListRequestView.callbackBalanceRefresh (err)", throwable);
        }

        @Override
        public void onSuccess(Double balance) {
            selectedRequest.getClient().setBalance(0d);
            MessageDialog.alert(MESSAGES.balanceOutputted(WebAppConstants.CURRENCY_FORMATTER.format(balance)));
            refreshTableRequests();
        }
    };
}
