package com.epam.feel.client.ui.admin;

import static com.epam.feel.client.EpamFeelResources.INSTANCE;
import static com.epam.feel.client.IEpamFeelConstants.CONSTANTS;
import static com.epam.feel.client.IEpamFeelMessages.MESSAGES;
import static com.epam.feel.client.IEpamFeelStatusConstants.STATUSES;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
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
import com.epam.feel.client.view.IListGroupRequestView;
import com.epam.feel.server.model.ExtendedRequestGroup;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.dto.ClientDTO;
import com.epam.feel.shared.dto.ExtendedRequestGroupDTO;
import com.epam.feel.shared.dto.GroupRequestDTO;
import com.epam.feel.shared.dto.MenuDetailsDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.epam.feel.shared.dto.RequestDetailsDTO;
import com.epam.feel.shared.enums.GroupStatus;
import com.epam.feel.shared.enums.RequestStatus;
import com.epam.feel.shared.excel.Cell;
import com.epam.feel.shared.excel.CellUtil;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

/**
 * List of group requests layout view implementation for administrator.
 * 
 * @author Anna_Gavrilina
 */
public class ListGroupRequestView extends Composite implements IListGroupRequestView {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_SIMPLE = 1;
    private static final int TYPE_RIGHT_HEADER = 2;

    private static ListGroupRequestViewUiBinder uiBinder = GWT.create(ListGroupRequestViewUiBinder.class);

    interface ListGroupRequestViewUiBinder extends UiBinder<Widget, ListGroupRequestView> {}

    private IListGroupRequestPresenter presenter;
    private final SingleSelectionModel<ExtendedRequestGroupDTO> selectionModel = new SingleSelectionModel<ExtendedRequestGroupDTO>();
    private ExtendedRequestGroupDTO selectedGroup;

    private ReasonMessageBox deleteMessage = new ReasonMessageBox();

    private void initDialogs() {
        deleteMessage.addDialogEventHandler(deleteRequestHandler);
        deleteMessage.setText(CONSTANTS.deleteReason());
    }

    public ListGroupRequestView() {
        initWidget(uiBinder.createAndBindUi(this));
        initDataGridGroups();
        initDialogs();
    }

    public ListGroupRequestView(ApplicationActivity applicationActivity) {
        this();
        setPresenter(applicationActivity.listGroupRequestPresenter);
    }

    @UiField
    Label noDataLabel;
    @UiField
    ProvideredDataGrid<ExtendedRequestGroupDTO> groups;
    @UiField
    VerticalPanel viewVerticalPanel;
    @UiField
    Label titleGroup;
    @UiField
    Button registerGroup;
    @UiField
    Button saveExcel;
    @UiField
    Button deleteGroup;
    @UiField
    Button completeGroup;
    @UiField
    FlexTable groupInfo;
    @UiField
    FormPanel formForExcel;
    @UiField
    FixedPager groupsPager;

    private AsyncCallback<Void> callbackRemoveGroup = new AsyncCallback<Void>() {

        @Override
        public void onSuccess(Void result) {
            selectionModel.setSelected(selectionModel.getSelectedObject(), false);
            refreshTableRequests();
        }

        @Override
        public void onFailure(Throwable caught) {
            GWT.log("ListGroupRequestView.callbackRemoveGroup (err)", caught);
        }
    };

    private void noData(Boolean value) {
        noDataLabel.setVisible(value);
        groups.setVisible(!value);
    }

    @UiHandler ("registerGroup")
    void onRegGroupClicked(ClickEvent e) {
        if (selectedGroup != null) {
            boolean hasInProgress = false;
            for (RequestDTO result : selectedGroup.getRequests())
                if (result.getStatus() == RequestStatus.IN_PROCESS) {
                    hasInProgress = true;
                    break;
                }
            if (hasInProgress)
                MessageDialog.alert(CONSTANTS.thereAreRequestInProcess());
            else {
                presenter.checkRequestTime(callbackCheckRequestTime);
            }
        }
    }

    @UiHandler ("completeGroup")
    void onCompleteGroupClicked(ClickEvent e) {
        if (selectedGroup != null) {
            presenter.completeGroupRequests(selectedGroup.getId(), callbackCompleteGroup);
        }
    }

    @UiHandler ("saveExcel")
    void onSaveExcelClicked(ClickEvent e) {
        if (selectedGroup != null) {
            List<Cell> cells = CellUtil.generateCells(groupInfo);
            presenter.saveExcelGroupRequests(cells, callbackExcelGroup);
        }
    }

    private void deleteGroupRequests() {
        if (selectedGroup != null) {
            presenter.deleteGroupRequests(selectedGroup.getId(), deleteMessage.getReason(), callbackRemoveGroup);
        }
    }

    private DialogEventHandler<ReasonMessageBox> deleteRequestHandler = new DialogEventHandler.PositiveListener<ReasonMessageBox>() {

        @Override
        public void onPositiveButtonClick(DialogEvent<ReasonMessageBox> event) {
            ReasonMessageBox messageBox = (ReasonMessageBox) event.getSource();
            if (!messageBox.getReason().isEmpty()) {
                deleteGroupRequests();
                messageBox.setReason(StringUtils.EMPTY);
            }
        }

    };

    /**
     * Callback for export excel file. Submit form for run HttpServlet.
     */
    private AsyncCallback<Void> callbackExcelGroup = new AsyncCallback<Void>() {

        @Override
        public void onSuccess(Void paramT) {
            formForExcel.setAction(GWT.getModuleBaseURL() + "excel");
            formForExcel.submit();
        }

        @Override
        public void onFailure(Throwable paramThrowable) {
            paramThrowable.printStackTrace();
            GWT.log("ListGroupRequestView.callbackExcelGroup (err)" + paramThrowable);
        }
    };

    @UiHandler ("deleteGroup")
    void onDelGroupClicked(ClickEvent e) {
        MessageDialog.confirm(MESSAGES.deleteGroupRequestConfirmation(selectedGroup.getId().toString()),
            new DialogEventHandler.PositiveListener<MessageDialog>() {

                @Override
                public void onPositiveButtonClick(DialogEvent<MessageDialog> event) {
                    if (GroupStatus.DRAFT.equals(selectedGroup.getStatus())) {
                        deleteGroupRequests();
                    } else {
                        deleteMessage.center();
                    }
                }

            });
    }

    @Override
    public void setPresenter(IListGroupRequestPresenter presenter) {
        this.presenter = presenter;
        groups.setProvider(presenter);
        groups.setDataAcceptedListener(new OnDataAcceptedListener() {

            @Override
            public void onDataAccepted(int startRow, int rowCount) {}

            @Override
            public void onSizeOfDataAccepted(int count) {
                noData(count == 0);
            }

            @Override
            public void onFailed(Throwable caught) {
                GWT.log("ListGroupRequestView.callbackFindGroups (err)", caught);
                noData(true);
            }

        });
    }

    private void initDataGridGroups() {
        Column<ExtendedRequestGroupDTO, Number> numberColumn = new SortableColumn<ExtendedRequestGroupDTO, Number>(
            new NumberCell()) {
            @Override
            public Number getValue(ExtendedRequestGroupDTO object) {
                return object.getId();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(ExtendedRequestGroup.ID_COLUMN, asc);
            }
        };
        groups.addColumn(numberColumn, CONSTANTS.numberColumn());
        groups.setColumnWidth(numberColumn, 100, Unit.PX);

        Column<ExtendedRequestGroupDTO, Date> dateColumn = new SortableColumn<ExtendedRequestGroupDTO, Date>(
            new DateCell(WebAppConstants.DATE_TIME_FORMATTER)) {

            @Override
            public Date getValue(ExtendedRequestGroupDTO object) {
                return object.getCreateDate();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(ExtendedRequestGroup.DATE_COLUMN, asc);
            }

        };
        groups.addColumn(dateColumn, CONSTANTS.creationDateColumn());
        groups.setColumnWidth(dateColumn, 130, Unit.PX);

        Column<ExtendedRequestGroupDTO, String> menuNameColumn = new SortableColumn<ExtendedRequestGroupDTO, String>(
            new TextCell()) {
            @Override
            public String getValue(ExtendedRequestGroupDTO object) {
                return object.getMenuName();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(ExtendedRequestGroup.MENU_NAME_COLUMN, asc);
            }
        };
        groups.addColumn(menuNameColumn, CONSTANTS.menuNameColumn());
        groups.setColumnWidth(menuNameColumn, 420, Unit.PX);

        Column<ExtendedRequestGroupDTO, String> statusColumn = new SortableColumn<ExtendedRequestGroupDTO, String>(
            new TextCell()) {
            @Override
            public String getValue(ExtendedRequestGroupDTO object) {
                return STATUSES.getString(object.getStatus().name());
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(ExtendedRequestGroup.STATUS_COLUMN, asc);
            }
        };
        groups.addColumn(statusColumn, CONSTANTS.statusColumn());
        groups.setColumnWidth(statusColumn, 100, Unit.PX);

        selectionModel.addSelectionChangeHandler(selectionHandler);
        groups.setSelectionModel(selectionModel);
    }

    private SelectionChangeEvent.Handler selectionHandler = new SelectionChangeEvent.Handler() {

        @Override
        public void onSelectionChange(SelectionChangeEvent arg0) {
            selectedGroup = selectionModel.getSelectedObject();
            viewGroup();
        }

    };

    private void viewGroup() {
        boolean groupSelected = selectedGroup != null;
        viewVerticalPanel.setVisible(groupSelected);
        if (groupSelected) {
            titleGroup.setText(MESSAGES.requestGroupView(selectedGroup.getId().toString(),
                WebAppConstants.DATE_TIME_FORMATTER.format(selectedGroup.getCreateDate())));
            renderButtons(selectedGroup);
            initGroupInfo(selectedGroup);
        }
    }

    private void renderButtons(GroupRequestDTO group) {
        viewVerticalPanel.setVisible(true);
        switch (group.getStatus()) {
            case DRAFT:
                defaultButtonsVisibility();
                break;
            case ACCEPTED:
                registerGroup.setVisible(false);
                deleteGroup.setVisible(true);
                completeGroup.setVisible(true);
                break;
            case PERFORMED:
                hideButtons(false);
                break;
            case DELETED:
                hideButtons(false);
                break;
            default:
                defaultButtonsVisibility();
                break;
        }
    }

    private void defaultButtonsVisibility() {
        registerGroup.setVisible(true);
        deleteGroup.setVisible(true);
        completeGroup.setVisible(false);
    }

    private void hideButtons(boolean isNotHide) {
        registerGroup.setVisible(isNotHide);
        deleteGroup.setVisible(isNotHide);
        completeGroup.setVisible(isNotHide);
    }

    public void refreshTableRequests() {
        if (groupsPager.getDisplay() == null) {
            groupsPager.setDisplay(groups);
            groupsPager.setPageSize(WebAppConstants.ROWS_PER_PAGE);
        }
        groups.refreshData();
        selectedGroup = selectionModel.getSelectedObject();
        viewGroup();
    }

    public void reset() {
        ExtendedRequestGroupDTO selectedObject = selectionModel.getSelectedObject();
        if (selectedObject != null) {
            selectionModel.setSelected(selectedObject, false);
        }
        refreshTableRequests();
    }

    private AsyncCallback<Boolean> callbackCheckRequestTime = new AsyncCallback<Boolean>() {
        @Override
        public void onFailure(Throwable caught) {
            GWT.log("ListGroupRequestView - callbackCheckRequestTime (err)", caught);
        }

        @Override
        public void onSuccess(Boolean result) {
            if (selectedGroup != null) {
                if (result) {
                    presenter.registerGroupRequests(selectedGroup.getId(), callbackRefreshGroups);
                } else {
                    MessageDialog.confirm(CONSTANTS.requestGroupConfirmation(),
                        new DialogEventHandler.PositiveListener<MessageDialog>() {

                            @Override
                            public void onPositiveButtonClick(DialogEvent<MessageDialog> event) {
                                presenter.registerGroupRequests(selectedGroup.getId(), callbackRefreshGroups);
                            }

                        });
                }
            }
        }
    };

    private void setText(int row, int column, String text, int cellType) {
        groupInfo.setWidget(row, column, new Label(text));
        String styleName;
        switch (cellType) {
            case TYPE_HEADER:
                styleName = INSTANCE.global().tableMenuHeader();
                break;
            case TYPE_SIMPLE:
                styleName = INSTANCE.global().tableMenuDishRow();
                break;
            case TYPE_RIGHT_HEADER:
                styleName = INSTANCE.global().tableMenuHeader() + " " + INSTANCE.global().rightText();
                break;
            default:
                styleName = null;
        }
        if (styleName != null) {
            groupInfo.getFlexCellFormatter().setStyleName(row, column, styleName);
        }
    }

    private void initGroupInfo(GroupRequestDTO group) {
        groupInfo.clear();
        groupInfo.removeAllRows();
        Set<ClientDTO> clients = new TreeSet<ClientDTO>(new Comparator<ClientDTO>() {

            @Override
            public int compare(ClientDTO o1, ClientDTO o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        Map<MenuDetailsDTO, Map<ClientDTO, RequestDetailsDTO>> dishes = new TreeMap<MenuDetailsDTO, Map<ClientDTO, RequestDetailsDTO>>(
            new Comparator<MenuDetailsDTO>() {
                @Override
                public int compare(MenuDetailsDTO o1, MenuDetailsDTO o2) {
                    int result = o1.getDishName().compareTo(o2.getDishName());
                    if (result == 0) {
                        result = Integer.valueOf(o1.hashCode()).compareTo(o2.hashCode());
                    }
                    return result;
                }
            });
        for (RequestDTO request : group.getRequests()) {
            for (RequestDetailsDTO requestDetails : request.getRequestDetails()) {
                MenuDetailsDTO dish = requestDetails.getMenuDetails();
                if (!dishes.containsKey(dish))
                    dishes.put(dish, new HashMap<ClientDTO, RequestDetailsDTO>());
                dishes.get(dish).put(request.getClient(), requestDetails);
            }
            if (!clients.contains(request.getClient())) {
                clients.add(request.getClient());
            }
        }
        setText(0, 0, CONSTANTS.titleLabel(), TYPE_HEADER);
        setText(1, 0, CONSTANTS.priceColumn(), TYPE_HEADER);
        int j = 1;
        for (MenuDetailsDTO dish : dishes.keySet()) {
            setText(0, j, dish.getDishName(), TYPE_HEADER);
            setText(1, j, WebAppConstants.CURRENCY_FORMATTER.format(dish.getPrice()), TYPE_HEADER);
            j++;
        }
        setText(0, j, CONSTANTS.amountForOnePersonLabel(), TYPE_HEADER);
        setText(1, 0, CONSTANTS.priceColumn(), TYPE_HEADER);
        setText(1, j, CONSTANTS.empty(), TYPE_HEADER);

        for (ClientDTO client : clients) {
            int i = groupInfo.getRowCount();
            setText(i, 0, client.getName(), TYPE_HEADER);
            j = 1;
            double summCost = 0;
            for (MenuDetailsDTO dish : dishes.keySet()) {
                int count = 0;
                RequestDetailsDTO details = dishes.get(dish).get(client);
                if (details != null) {
                    count = details.getCount();
                    summCost += details.getMenuDetails().getPrice() * count;
                }
                setText(i, j, String.valueOf(count), TYPE_SIMPLE);
                j++;
            }
            setText(i, j, WebAppConstants.CURRENCY_FORMATTER.format(summCost), TYPE_HEADER);
        }
        int i = groupInfo.getRowCount();
        setText(i, 0, CONSTANTS.numberOfMealsLabel(), TYPE_HEADER);
        j = 1;
        for (MenuDetailsDTO dish : dishes.keySet()) {
            int sumCount = 0;
            for (RequestDetailsDTO details : dishes.get(dish).values()) {
                sumCount += details.getCount();
            }
            setText(i, j, String.valueOf(sumCount), TYPE_HEADER);
            j++;
        }
        setText(i, j, CONSTANTS.empty(), TYPE_HEADER);
        i++;
        groupInfo.getFlexCellFormatter().setColSpan(i, 0, j);
        setText(i, 0, CONSTANTS.totalLabel(), TYPE_RIGHT_HEADER);
        setText(i, 1, WebAppConstants.CURRENCY_FORMATTER.format(group.getGroupPrice()), TYPE_HEADER);
    }

    private AsyncCallback<Void> callbackRefreshGroups = new AsyncCallback<Void>() {
        @Override
        public void onFailure(Throwable throwable) {
            GWT.log("ListGroupRequestView.callbackRefreshGroups (err)", throwable);
        }

        @Override
        public void onSuccess(Void result) {
            selectedGroup.setStatus(GroupStatus.ACCEPTED);
            refreshTableRequests();
            viewGroup();
        }
    };

    private AsyncCallback<ExtendedRequestGroupDTO> callbackCompleteGroup = new AsyncCallback<ExtendedRequestGroupDTO>() {
        @Override
        public void onFailure(Throwable throwable) {
            GWT.log("ListGroupRequestView.callbackCompleteGroup (err)", throwable);
        }

        @Override
        public void onSuccess(ExtendedRequestGroupDTO result) {
            selectedGroup.copy(result);
            refreshTableRequests();
        }
    };
}
