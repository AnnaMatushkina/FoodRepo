package com.epam.feel.client.ui.admin;

import static com.epam.feel.client.IEpamFeelConstants.CONSTANTS;
import static com.epam.feel.client.IEpamFeelMessages.MESSAGES;
import static com.epam.feel.client.IEpamFeelStatusConstants.STATUSES;
import gwtupload.client.IUploadStatus;
import gwtupload.client.IUploadStatus.Status;
import gwtupload.client.IUploader;
import gwtupload.client.IUploader.UploadedInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import com.epam.feel.client.activity.ApplicationActivity;
import com.epam.feel.client.ui.util.AliveMenuDetails;
import com.epam.feel.client.ui.util.CalendarView;
import com.epam.feel.client.ui.util.StringUtilities;
import com.epam.feel.client.ui.util.TimeView;
import com.epam.feel.client.ui.util.approver.ApproveManager;
import com.epam.feel.client.ui.util.approver.ApproveableAction;
import com.epam.feel.client.ui.util.approver.ApproveableActionWithMessage;
import com.epam.feel.client.ui.util.approver.Approver;
import com.epam.feel.client.ui.util.approver.DefaultApproveConfirmation;
import com.epam.feel.client.ui.util.approver.HasApprovers;
import com.epam.feel.client.ui.util.box.ExtendedDoubleBox;
import com.epam.feel.client.ui.util.box.FixedLengthTextArea;
import com.epam.feel.client.ui.util.cell.AnchorCell;
import com.epam.feel.client.ui.util.dialogs.DialogEvent;
import com.epam.feel.client.ui.util.dialogs.DialogEventHandler;
import com.epam.feel.client.ui.util.dialogs.MessageDialog;
import com.epam.feel.client.ui.util.gwtupload.FixedSingleUploader;
import com.epam.feel.client.ui.util.highlighting.Highlightable;
import com.epam.feel.client.ui.util.highlighting.HighlightableIntegerBox;
import com.epam.feel.client.ui.util.highlighting.HighlightableTextBox;
import com.epam.feel.client.ui.util.highlighting.HighlightingHelper;
import com.epam.feel.client.ui.util.highlighting.Stateful;
import com.epam.feel.client.ui.util.highlighting.StatefulHighlightable;
import com.epam.feel.client.view.ICreateMenuView;
import com.epam.feel.server.model.MenuDetails;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.dto.DishTypeDTO;
import com.epam.feel.shared.dto.MenuDTO;
import com.epam.feel.shared.dto.MenuDetailsDTO;
import com.epam.feel.shared.enums.MenuStatus;
import com.epam.feel.shared.service.ServiceUtils;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.CalendarUtil;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

/**
 * Create new menu layout view implementation for administrator.
 * 
 * @author Anna_Gavrilina
 */
public class CreateMenuView extends Composite implements ICreateMenuView, Approver, HasApprovers {

    private static final String IMAGE_WIDTH = "75px";
    private static final String URL_PREFIX = "http://";
    private static final String CHECK_URL_PREFIX = "http";

    private static final List<Status> IDLE_STATUSES = Arrays.asList(new Status[] {Status.SUCCESS, Status.UNINITIALIZED,
            Status.DONE});

    private static CreateMenuViewUiBinder uiBinder = GWT.create(CreateMenuViewUiBinder.class);

    interface CreateMenuViewUiBinder extends UiBinder<Widget, CreateMenuView> {}

    private ICreateMenuPresenter createMenuPresenter;

    // Selected menu, if not selected then null
    private MenuDTO selectedMenu;
    private MenuDTO selectedMenuClone;
    // Selected menuDetails, if not selected then null
    private MenuDetailsDTO selectedMenuDetailsDTO;
    // List of all menus created or loaded form base
    private List<MenuDTO> menuList = new ArrayList<MenuDTO>();
    private List<DishTypeDTO> dishTypes = null;
    private String fieldName;
    private Long imageId;
    private Image image;
    private boolean isEditAction = false;
    private boolean doRefresh = true;
    private final SingleSelectionModel<MenuDTO> selectionModelForMenu = new SingleSelectionModel<MenuDTO>();
    private final SingleSelectionModel<MenuDetailsDTO> selectionModelForDetailsDTO = new SingleSelectionModel<MenuDetailsDTO>();

    @UiField
    VerticalPanel menuPanel;
    @UiField
    CalendarView newMenuDate;
    @UiField
    HighlightableTextBox newMenuTitle;
    @UiField
    CalendarView newOrderStartDate;
    @UiField
    CalendarView newOrderEndDate;
    @UiField
    TimeView newOrderStartTime;
    @UiField
    TimeView newOrderEndTime;
    @UiField
    TimeView newOrderDeliveryStartTime;
    @UiField
    TimeView newOrderDeliveryEndTime;
    @UiField
    VerticalPanel menuDetailsPanel;
    @UiField
    DataGrid<MenuDetailsDTO> menuDetails;

    @UiField
    HighlightableTextBox newTitleBox;
    @UiField
    FixedLengthTextArea newConsistBox;
    @UiField
    HighlightableIntegerBox newWeightBox;
    @UiField
    ExtendedDoubleBox newPriceBox;
    @UiField
    HighlightableIntegerBox newMaxCountBox;
    @UiField
    FixedSingleUploader newPhoto;
    @UiField
    HorizontalPanel imageDish;
    @UiField
    ListBox newTypeDishes;
    @UiField
    Button createMenu;
    @UiField
    DecoratorPanel menuEditPanel;
    @UiField
    Label emptyMenuListLabel;
    @UiField
    VerticalPanel menuTablePanel;
    @UiField
    DataGrid<MenuDTO> menuTable;
    @UiField
    Button editDish;
    @UiField
    Button addDish;
    @UiField
    Button delDish;
    @UiField
    Button saveMenu;
    @UiField
    Button copyMenu;
    @UiField
    Button deleteMenu;
    @UiField
    Button blockMenu;
    @UiField
    Button unBlockMenu;
    @UiField
    DialogBox dishEditorPanel;
    @UiField
    CheckBox isChefDish;
    @UiField
    HorizontalPanel dishActions;
    @UiField
    VerticalPanel dishsTable;
    @UiField
    Button imageDel;

    @UiField
    Button dialogOk;
    @UiField
    Button dialogCancel;

    @UiField
    CalendarView dateStartBox;
    @UiField
    CalendarView dateEndBox;
    @UiField
    TextBox newURL;

    private StatefulHighlightable[] highlightables;
    private StatefulHighlightable[] popupHighlightables;
    private ApproveManager approveManager = new ApproveManager();

    private IUploader.OnFinishUploaderHandler onFinishUploaderHandler = new IUploader.OnFinishUploaderHandler() {
        public void onFinish(IUploader uploader) {
            UploadedInfo info = uploader.getServerInfo();
            if (info.ctype != null) {
                if (info.ctype.contains("image")) {
                    if (!uploader.getServerInfo().message.contains(WebAppConstants.UPLOAD_MESSAGE_LONG_FILE)) {
                        if (uploader.getStatus() == IUploadStatus.Status.SUCCESS) {
                            fieldName = uploader.getServerInfo().field;
                            createMenuPresenter.saveImage(fieldName, callbackImage);
                        }
                    } else {
                        MessageDialog.alert(CONSTANTS.fileTooLarge());
                        clearImage();
                    }
                } else {
                    MessageDialog.alert(CONSTANTS.fileIsNotImage());
                    clearImage();
                }
            } else {
                clearImage();
            }
            if (uploader instanceof FixedSingleUploader) {
                ((FixedSingleUploader) uploader).resetUploadedInfo();
            }
        }
    };

    private DialogEventHandler<MessageDialog> clearImageConfirmation = new DialogEventHandler.PositiveListener<MessageDialog>() {

        @Override
        public void onPositiveButtonClick(DialogEvent<MessageDialog> event) {
            clearImage();
        }

    };

    private ApproveableAction filterAction = new ApproveableActionWithMessage(
        CONSTANTS.confirmHasChangesOnOtherAction()) {

        @Override
        public void run(boolean approve) {
            if (approve) {
                refreshData();
            }
        }
    };

    private ApproveableAction createMenuAction = new ApproveableActionWithMessage(
        CONSTANTS.confirmHasChangesOnOtherAction()) {

        @Override
        public void run(boolean approve) {
            if (approve) {
                createNewMenu();
            }
        }
    };

    private ApproveableAction copyMenuAction = new ApproveableActionWithMessage(
        CONSTANTS.confirmHasChangesOnOtherAction()) {

        @Override
        public void run(boolean approve) {
            if (approve) {
                copyMenu();
            }
        }
    };

    @UiHandler ("submitFilter")
    void onClickFilter(ClickEvent event) {
        approveAction(filterAction);
    }

    @UiHandler ("imageDel")
    void onClickImageDel(ClickEvent event) {
        MessageDialog.confirm(CONSTANTS.confirmImageDeletion(), clearImageConfirmation);
    }

    @UiHandler ("createMenu")
    void onCreateNewMenuLinkClicked(ClickEvent e) {
        approveAction(createMenuAction);
    }

    private void createNewMenu() {
        selectedMenu = new MenuDTO();
        selectedMenu.setStatus(MenuStatus.DRAFT);
        writeMenuToForm(selectedMenu);
        menuDetailsPanel.setVisible(false);
        clearImage();
    }

    @UiHandler ("copyMenu")
    void onCopyMenuClicked(ClickEvent e) {
        approveAction(copyMenuAction);
    }

    private void copyMenu() {
        copyMenu.setVisible(false);
        selectedMenu = selectedMenu.clone();
        cloneSelectedMenu();
        selectedMenu.setMenuName(null);
        selectedMenu.setReceiptStartDate(null);
        selectedMenu.setReceiptEndDate(null);
        selectedMenu.setDeliveryStartDate(null);
        selectedMenu.setDeliveryEndDate(null);
        selectedMenu.setCreateDate(null);
        selectedMenu.setMenuOnDate(new Date());
        selectedMenu.setStatus(MenuStatus.DRAFT);
        clearImage();
        writeMenuToForm(selectedMenu);
    }

    @UiHandler ("saveMenu")
    void onSaveMenuClicked(ClickEvent e) {
        if (validateMenu()) {
            doRefresh = false;
            readMenuFromForm(selectedMenu);
            createMenuPresenter.saveMenu(selectedMenu, asyncCallbackSaveMenuDTO);
            visibleOfButton(true);
        }
    }

    @UiHandler ("blockMenu")
    void onBlockMenuClicked(ClickEvent e) {
        if (validateMenu()) {
            doRefresh = true;
            readMenuFromForm(selectedMenu);
            createMenuPresenter.setStatusMenu(selectedMenu, false, asyncCallbackSaveMenuDTO);
        }
    }

    @UiHandler ("unBlockMenu")
    void onUnBlockMenuClicked(ClickEvent e) {
        doRefresh = false;
        createMenuPresenter.setStatusMenu(selectedMenu, true, asyncCallbackSaveMenuDTO);
    }

    private DishCallBack validateDishesCallback = new DishCallBack() {

        @Override
        public void validate(Integer result) {
            saveEditedDish();
        }

        @Override
        public void invalidate(Integer result) {
            MessageDialog.alert(MESSAGES.cantChangeDishesCount(String.valueOf(result)));
        }

    };

    private DishCallBack validateDishOnRemoveCallback = new DishCallBack() {

        public void onFailure(Throwable caught) {
            super.onFailure(caught);
            menuDetailsPanel.setVisible(false);
        };

        @Override
        public void validate(Integer result) {
            deleteSelectedMenuDetails();
        }

        @Override
        public boolean isValid(Integer result) {
            return result.intValue() == 0;
        };

        @Override
        public void invalidate(Integer result) {
            writeDishToForm(selectedMenuDetailsDTO);
            selectionModelForDetailsDTO.setSelected(selectionModelForDetailsDTO.getSelectedObject(), false);
            MessageDialog.alert(MESSAGES.unableToDeleteMenuItem(String.valueOf(result)));
        }

    };

    private void deleteSelectedMenuDetails() {
        selectedMenuDetailsDTO.setAlive(false);
        List<MenuDetailsDTO> details = selectedMenu.getMenuDetails();
        menuDetailsPanel.setVisible(!details.isEmpty());
        menuDetails.setRowData(details);
    }

    @UiHandler ("dialogOk")
    void onDialogOk(ClickEvent e) {
        resetUploader(true);
        if (validateDish()) {
            if (isEditAction) {
                final MenuDetailsDTO dish = readDishFromForm(selectedMenuDetailsDTO.clone(selectedMenu));
                // make a real copy
                dish.setId(selectedMenuDetailsDTO.getId());
                if (dish.getId() != null && dish.getMaxCount() >= 0) {
                    validateDishesCallback.setDish(dish);
                    createMenuPresenter.getRequestedDishesCount(dish.getId(), validateDishesCallback);
                } else {
                    saveEditedDish();
                }
            } else {
                final MenuDetailsDTO dish = readDishFromForm(null);
                selectedMenu.getMenuDetails().add(dish);
                menuDetails.setRowData(getAliveMenuDetails(selectedMenu));
                writeDishToForm(null);
                dishEditorPanel.hide();
                menuDetailsPanel.setVisible(true);
            }
        }
    }

    private void resetUploader(boolean checkStatus) {
        Status status = newPhoto.getStatus();
        if (!checkStatus || !IDLE_STATUSES.contains(status)) {
            newPhoto.cancel();
            newPhoto.clear();
            newPhoto.reset();
        }
    }

    private void saveEditedDish() {
        readDishFromForm(selectedMenuDetailsDTO);
        writeMenuToForm(selectedMenu, true);
        dishEditorPanel.hide();
        menuDetailsPanel.setVisible(true);
    }

    @UiHandler ("dialogCancel")
    void onDialogCancel(ClickEvent e) {
        dishEditorPanel.hide();
        resetUploader(false);
    }

    private void clearDialog() {
        newTitleBox.setValue(null);
        newConsistBox.setValue(null);
        newTypeDishes.setSelectedIndex(0);
        newWeightBox.setValue(null);
        newPriceBox.setValue(null);
        newMaxCountBox.setValue(null);
        isChefDish.setValue(null);
        newURL.setValue(null);
        clearImage();
    }

    @UiHandler ("addDish")
    void onAddDishButtonClicked(ClickEvent e) {
        isEditAction = false;
        clearDialog();
        dishEditorPanel.setText(CONSTANTS.dialogCreateLabel());
        dishEditorPanel.center();
        dishEditorPanel.setVisible(true);
    }

    private void selectDish(MenuDetailsDTO dish) {
        for (MenuDetailsDTO dishItem : menuDetails.getVisibleItems())
            menuDetails.getSelectionModel().setSelected(dishItem, dishItem == dish);
    }

    private void clearImage() {
        if (imageDish.getWidgetCount() > 0) {
            imageDish.remove(0);
        }
        imageId = null;
        newPhoto.setVisible(true);
        imageDel.setVisible(false);
    }

    @UiHandler ("editDish")
    void onEditDishButtonClicked(ClickEvent e) {
        isEditAction = true;
        writeDishToForm(selectedMenuDetailsDTO);
        dishEditorPanel.setText(CONSTANTS.dialogEditLabel());
        dishEditorPanel.center();
        dishEditorPanel.setVisible(true);
    }

    private DialogEventHandler<MessageDialog> delDishConfirmation = new DialogEventHandler.PositiveListener<MessageDialog>() {

        @Override
        public void onPositiveButtonClick(DialogEvent<MessageDialog> event) {
            tryToDeleteDish();
        }

    };

    @UiHandler ("delDish")
    void onDelDishButtonClicked(ClickEvent e) {
        MessageDialog.confirm(CONSTANTS.confirmDishDeletion(), delDishConfirmation);
    }

    private void tryToDeleteDish() {
        if (selectedMenuDetailsDTO != null) {
            if (selectedMenuDetailsDTO.getId() == null) {
                selectedMenu.getMenuDetails().remove(selectedMenuDetailsDTO);
                writeDishToForm(null);
                menuDetails.setRowData(getAliveMenuDetails(selectedMenu));
            } else {
                final MenuDetailsDTO dish = readDishFromForm(selectedMenuDetailsDTO.clone(selectedMenu));
                // make a real copy
                dish.setId(selectedMenuDetailsDTO.getId());
                validateDishOnRemoveCallback.setDish(dish);
                createMenuPresenter.getRequestedDishesCount(dish.getId(), validateDishOnRemoveCallback);
            }
        }
    }

    private DialogEventHandler<MessageDialog> deleteMenuConfirmation = new DialogEventHandler.PositiveListener<MessageDialog>() {

        @Override
        public void onPositiveButtonClick(DialogEvent<MessageDialog> event) {
            tryToDeleteMenu();
        }
    };

    private DeleteMenuCallback deleteMenuCallback = new DeleteMenuCallback();

    @UiHandler ("deleteMenu")
    void onDeleteMenuButtonClicked(ClickEvent e) {
        MessageDialog.confirm(CONSTANTS.confirmMenuDeletion(), deleteMenuConfirmation);
    }

    private void tryToDeleteMenu() {
        if (selectedMenu.getId() != null) {
            deleteMenuCallback.setMenuToDelete(selectedMenu);
            createMenuPresenter.delMenu(selectedMenu.getId(), deleteMenuCallback);
        } else {
            menuList.remove(selectedMenu);
            menuTable.setRowData(menuList);
            selectionModelForMenu.setSelected(selectionModelForMenu.getSelectedObject(), false);
            selectedMenu = null;
        }
    }

    public CreateMenuView() {
        initWidget(uiBinder.createAndBindUi(this));
        initUI();
    }

    public CreateMenuView(ApplicationActivity applicationActivity) {
        setPresenter(applicationActivity);
        initWidget(uiBinder.createAndBindUi(this));
        initUI();
    }

    private boolean isEmpty(HasText edit) {
        return isEmpty(edit, false);
    }

    private boolean isEmpty(HasText edit, boolean skipHighlighting) {
        boolean result = edit.getText() == null || edit.getText().trim().isEmpty();
        if (!skipHighlighting && result) {
            if (edit instanceof Highlightable) {
                HighlightingHelper.highlightError((Highlightable) edit);
            }
        }
        return result;
    }

    private boolean isEmpty(CalendarView edit) {
        return edit.getValue() == null;
    }

    private AsyncCallback<Long> callbackImage = new AsyncCallback<Long>() {
        @Override
        public void onFailure(Throwable caught) {
            GWT.log("[Error] CreateMenuView - callbackImage", caught);
            imageId = null;
        }

        @Override
        public void onSuccess(Long result) {
            imageId = result;

            Image image = new Image();
            image.setUrl(ServiceUtils.getImageUrlById(result));
            image.setWidth(IMAGE_WIDTH);
            image.setHeight(IMAGE_WIDTH);
            imageDish.add(image);

            imageDel.setVisible(true);
            newPhoto.setVisible(false);
        }
    };

    private AsyncCallback<List<DishTypeDTO>> asyncCallbackDishList = new AsyncCallback<List<DishTypeDTO>>() {
        @Override
        public void onFailure(Throwable caught) {
            GWT.log("[Error] CreateMenuView - asyncCallbackDishList", caught);
        }

        @Override
        public void onSuccess(List<DishTypeDTO> result) {
            dishTypes = result;
            newTypeDishes.clear();
            for (DishTypeDTO type : dishTypes) {
                newTypeDishes.addItem(type.getText());
            }
        }
    };

    private AsyncCallback<List<MenuDTO>> asyncCallbackGetMenus = new AsyncCallback<List<MenuDTO>>() {
        @Override
        public void onFailure(Throwable caught) {
            GWT.log("[Error] CreateMenuView - asyncCallbackGetMenus", caught);
            emptyMenuListLabel.setVisible(true);
            menuTablePanel.setVisible(false);
        }

        @Override
        public void onSuccess(final List<MenuDTO> result) {
            Boolean isEmpty = result.isEmpty();
            emptyMenuListLabel.setVisible(isEmpty);
            menuTablePanel.setVisible(!isEmpty);
            menuList = result;
            menuTable.setRowData(menuList);
            menuTable.getSelectionModel().setSelected(selectedMenu, true);
            writeMenuToForm(!doRefresh ? selectedMenu : null);
            if (!doRefresh)
                doRefresh = true;
        }
    };

    private AsyncCallback<MenuDTO> asyncCallbackSaveMenuDTO = new AsyncCallback<MenuDTO>() {
        @Override
        public void onFailure(Throwable caught) {
            GWT.log("[Error] CreateMenuView - asyncCallbackSaveMenuDTO", caught);
        }

        @Override
        public void onSuccess(MenuDTO result) {
            MessageDialog.alert(CONSTANTS.dataSaved());
            selectedMenu = result;
            cloneSelectedMenu();
            menuTable.getSelectionModel().setSelected(result, true);
            writeMenuToForm(selectedMenu);
            refreshData();
        }
    };

    private ChangeViewConfirmation changeViewConfirmation = new ChangeViewConfirmation();

    private void initUI() {
        TextColumn<MenuDTO> nameColumn = new TextColumn<MenuDTO>() {
            @Override
            public String getValue(MenuDTO object) {
                return object.getMenuName();
            }
        };
        menuTable.addColumn(nameColumn, CONSTANTS.titleColumn());
        menuTable.setColumnWidth(nameColumn, 380, Unit.PX);

        Column<MenuDTO, Date> dateColumn = new Column<MenuDTO, Date>(new DateCell(WebAppConstants.DATE_TIME_FORMATTER)) {
            @Override
            public Date getValue(MenuDTO object) {
                return object.getMenuOnDate();
            }
        };
        menuTable.addColumn(dateColumn, CONSTANTS.dateColumn());
        menuTable.setColumnWidth(dateColumn, 150, Unit.PX);

        Column<MenuDTO, Date> startTimeMenuColumn = new Column<MenuDTO, Date>(new DateCell(
            WebAppConstants.DATE_TIME_FORMATTER)) {
            @Override
            public Date getValue(MenuDTO object) {
                return object.getReceiptStartDate();
            }
        };
        menuTable.addColumn(startTimeMenuColumn, CONSTANTS.receiptStartDateColumn());
        menuTable.setColumnWidth(startTimeMenuColumn, 170, Unit.PX);

        Column<MenuDTO, Date> endTimeMenuColumn = new Column<MenuDTO, Date>(new DateCell(
            WebAppConstants.DATE_TIME_FORMATTER)) {
            @Override
            public Date getValue(MenuDTO object) {
                return object.getReceiptEndDate();
            }
        };
        menuTable.addColumn(endTimeMenuColumn, CONSTANTS.receiptEndDatecolumn());
        menuTable.setColumnWidth(endTimeMenuColumn, 200, Unit.PX);

        TextColumn<MenuDTO> deliveryColumn = new TextColumn<MenuDTO>() {
            @Override
            public String getValue(MenuDTO object) {
                String result = "-";
                if (object.getDeliveryStartDate() != null) {
                    result = WebAppConstants.SHORT_TIME_FORMATTER.format(object.getDeliveryStartDate()) + result;
                }
                if (object.getDeliveryEndDate() != null) {
                    result = result + WebAppConstants.SHORT_TIME_FORMATTER.format(object.getDeliveryEndDate());
                }
                return result;
            }
        };
        menuTable.addColumn(deliveryColumn, CONSTANTS.deliveryColumn());
        menuTable.setColumnWidth(deliveryColumn, 120, Unit.PX);

        TextColumn<MenuDTO> statusColumn = new TextColumn<MenuDTO>() {
            @Override
            public String getValue(MenuDTO object) {
                return STATUSES.getString(object.getStatus().name());
            }
        };
        menuTable.addColumn(statusColumn, CONSTANTS.statusColumn());
        menuTable.setColumnWidth(statusColumn, 120, Unit.PX);

        selectionModelForMenu.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                selectionModelForDetailsDTO.setSelected(selectionModelForDetailsDTO.getSelectedObject(), false);
                if (selectionModelForMenu.getSelectedObject() != null)
                    selectedMenu = selectionModelForMenu.getSelectedObject();
                cloneSelectedMenu();
                if (doRefresh) {
                    clearImage();
                    writeMenuToForm(selectedMenu);
                    copyMenu.setVisible(selectedMenu != null);
                    clearHighlighting(highlightables);
                }
            }
        });
        menuTable.setSelectionModel(selectionModelForMenu);

        final Column<MenuDetailsDTO, AnchorCell.LinkedText> nameMenuDetailsColumn = new Column<MenuDetailsDTO, AnchorCell.LinkedText>(
            new AnchorCell()) {
            @Override
            public AnchorCell.LinkedText getValue(final MenuDetailsDTO entity) {
                return new AnchorCell.LinkedText(entity.getDishName(), entity.getUrl());
            }
        };
        menuDetails.addColumn(nameMenuDetailsColumn, CONSTANTS.titleColumn());
        menuDetails.setColumnWidth(nameMenuDetailsColumn, 360, Unit.PX);

        TextColumn<MenuDetailsDTO> structureMenuDetailsColumn = new TextColumn<MenuDetailsDTO>() {
            @Override
            public String getValue(MenuDetailsDTO object) {
                return object.getStructure();
            }
        };
        menuDetails.addColumn(structureMenuDetailsColumn, CONSTANTS.structureColumn());
        menuDetails.setColumnWidth(structureMenuDetailsColumn, 450, Unit.PX);

        TextColumn<MenuDetailsDTO> dishTypeMenuDetailsColumn = new TextColumn<MenuDetailsDTO>() {
            @Override
            public String getValue(MenuDetailsDTO object) {
                return object.getDishType().getText();
            }
        };
        menuDetails.addColumn(dishTypeMenuDetailsColumn, CONSTANTS.dishTypeColumn());
        menuDetails.setColumnWidth(dishTypeMenuDetailsColumn, 100, Unit.PX);

        Column<MenuDetailsDTO, Number> weightMenuDetailsColumn = new Column<MenuDetailsDTO, Number>(new NumberCell(
            WebAppConstants.WEIGHT_FORMATTER)) {

            @Override
            public Number getValue(MenuDetailsDTO object) {
                return object.getWeight();
            }

        };
        menuDetails.addColumn(weightMenuDetailsColumn, CONSTANTS.weightColumn());
        menuDetails.setColumnWidth(weightMenuDetailsColumn, 100, Unit.PX);

        Column<MenuDetailsDTO, Number> priceMenuDetailsColumn = new Column<MenuDetailsDTO, Number>(new NumberCell(
            WebAppConstants.CURRENCY_FORMATTER)) {

            @Override
            public Number getValue(MenuDetailsDTO object) {
                return object.getPrice();
            }

        };
        menuDetails.addColumn(priceMenuDetailsColumn, CONSTANTS.priceColumn());
        menuDetails.setColumnWidth(priceMenuDetailsColumn, 100, Unit.PX);

        Column<MenuDetailsDTO, Number> maxCountMenuDetailsColumn = new Column<MenuDetailsDTO, Number>(new NumberCell(
            WebAppConstants.MAX_COUNT_FORMATTER)) {

            @Override
            public Number getValue(MenuDetailsDTO object) {
                return object.getMaxCount();
            }

        };
        menuDetails.addColumn(maxCountMenuDetailsColumn, CONSTANTS.maxCountColumn());
        menuDetails.setColumnWidth(maxCountMenuDetailsColumn, 200, Unit.PX);

        Cell<Image> imageCell = new AbstractCell<Image>() {
            @Override
            public void render(Context context, Image value, SafeHtmlBuilder sb) {
                if (value == null) {
                    return;
                }
                sb.appendHtmlConstant("<div class=\"v\">");
                sb.appendHtmlConstant(value.asWidget().toString());
                sb.appendHtmlConstant("</div>");
            }
        };

        Column<MenuDetailsDTO, Image> photoMenuDetailsColumn = new Column<MenuDetailsDTO, Image>(imageCell) {
            @Override
            public Image getValue(MenuDetailsDTO object) {
                final Long imageId = object.getImageId();
                Image result = imageId != null ? new Image() : null;
                if (result != null) {
                    result.setUrl(ServiceUtils.getImageUrlById(imageId));
                    result.setWidth(IMAGE_WIDTH);
                    result.setHeight(IMAGE_WIDTH);
                }
                return result;
            }
        };
        menuDetails.addColumn(photoMenuDetailsColumn, CONSTANTS.photoColumn());
        menuDetails.setColumnWidth(photoMenuDetailsColumn, 100, Unit.PX);

        selectionModelForDetailsDTO.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                selectedMenuDetailsDTO = selectionModelForDetailsDTO.getSelectedObject();
                writeDishToForm(selectedMenuDetailsDTO);
            }
        });
        menuDetails.setSelectionModel(selectionModelForDetailsDTO);

        newPhoto.addOnFinishUploadHandler(onFinishUploaderHandler);
        imageDel.setVisible(false);

        newMenuDate.setFormat(WebAppConstants.SHORT_DATE_FORMATTER);
        newMenuDate.setHint(WebAppConstants.SHORT_DATE_FORMATTER.getPattern());

        newOrderStartDate.setFormat(WebAppConstants.SHORT_DATE_FORMATTER);
        newOrderStartDate.setHint(WebAppConstants.SHORT_DATE_FORMATTER.getPattern());

        newOrderEndDate.setFormat(WebAppConstants.SHORT_DATE_FORMATTER);
        newOrderEndDate.setHint(WebAppConstants.SHORT_DATE_FORMATTER.getPattern());

        newConsistBox.setMaxLength(WebAppConstants.MAX_STRUCTURE_LENGTH);
        newMenuTitle.setMaxLength(WebAppConstants.MAX_MENU_NAME_LENGTH);

        dateStartBox.setFormat(WebAppConstants.SHORT_DATE_FORMATTER);
        dateEndBox.setFormat(WebAppConstants.SHORT_DATE_FORMATTER);

        highlightables = new StatefulHighlightable[] {newMenuTitle, newMenuDate, newOrderDeliveryEndTime,
                newOrderDeliveryStartTime, newOrderEndDate, newOrderEndTime, newOrderStartDate, newOrderStartTime};

        popupHighlightables = new StatefulHighlightable[] {newTitleBox, newConsistBox, newPriceBox, newWeightBox,
                newMaxCountBox};

        registerApprover(this);

        newPhoto.setAutoSubmit(true);
        newPhoto.setAvoidRepeatFiles(false);

    }

    private CloseHandler<PopupPanel> clearPopupHighlightingCloseHandler = new CloseHandler<PopupPanel>() {

        @Override
        public void onClose(CloseEvent<PopupPanel> event) {
            clearHighlighting(popupHighlightables);
        }
    };

    private CloseHandler<PopupPanel> clearHighlightablesCloseHandler = new CloseHandler<PopupPanel>() {

        @Override
        public void onClose(CloseEvent<PopupPanel> event) {
            clearHighlighting(highlightables);
        }
    };

    private Boolean validateMenu() {
        Date now = new Date();
        if (!isEmpty(newMenuDate) && newMenuDate.getValue().before(now)
            && (CalendarUtil.getDaysBetween(now, newMenuDate.getValue()) != 0)) {
            HighlightingHelper.highlightError(newMenuDate);
            MessageDialog.alert(CONSTANTS.cannotCreateMenuInPast(), clearHighlightablesCloseHandler);
            return false;
        }

        newOrderStartTime.setDate(newOrderStartDate.getValue());
        newOrderEndTime.setDate(newOrderEndDate.getValue());
        newOrderDeliveryStartTime.setDate(newMenuDate.getValue());
        newOrderDeliveryEndTime.setDate(newMenuDate.getValue());

        if (!isEmpty(newMenuTitle) && !isEmpty(newOrderStartDate) && !isEmpty(newOrderEndDate)) {
            if (selectedMenu != null && !selectedMenu.getMenuDetails().isEmpty()) {
                if (newOrderStartTime.getValue().before(newOrderEndTime.getValue())) {
                    if (newOrderDeliveryStartTime.getValue().before(newOrderDeliveryEndTime.getValue())) {
                        if (newOrderDeliveryStartTime.getValue().after(newOrderEndTime.getValue())) {
                            return true;
                        } else {
                            HighlightingHelper.highlightError(newOrderDeliveryStartTime);
                            HighlightingHelper.highlightError(newOrderDeliveryStartTime);
                            MessageDialog.alert(CONSTANTS.requestAfterMenuDateError(), clearHighlightablesCloseHandler);
                        }
                    } else {
                        HighlightingHelper.highlightError(newOrderDeliveryStartTime);
                        HighlightingHelper.highlightError(newOrderDeliveryEndTime);
                        MessageDialog.alert(CONSTANTS.menuDeliveryDateError(), clearHighlightablesCloseHandler);
                    }
                } else {
                    HighlightingHelper.highlightError(newOrderStartTime);
                    HighlightingHelper.highlightError(newOrderEndTime);
                    MessageDialog.alert(CONSTANTS.menuRequestDateError(), clearHighlightablesCloseHandler);
                }
            } else {
                MessageDialog.alert(CONSTANTS.menuIsEmpty());
            }
        } else {
            MessageDialog.alert(CONSTANTS.someFieldsEmpty(), clearHighlightablesCloseHandler);
        }

        return false;
    }

    private boolean validateDish() {
        if (!isEmpty(newTitleBox) && !isEmpty(newConsistBox) && !isEmpty(newPriceBox) && !isEmpty(newWeightBox)) {
            if ((isEmpty(newMaxCountBox, true) || checkPositiveInt(newMaxCountBox)) && checkPositiveDouble(newPriceBox)
                && checkPositiveInt(newWeightBox)) {
                if (checkMaxValue(newPriceBox)) {
                    return true;
                } else {
                    MessageDialog.alert(CONSTANTS.tooLargePriceValue(), clearPopupHighlightingCloseHandler);
                    return false;
                }
            } else {
                MessageDialog.alert(CONSTANTS.unCorrectCharacter(), clearPopupHighlightingCloseHandler);
                return false;
            }
        } else {
            MessageDialog.alert(CONSTANTS.someFieldsEmpty(), clearPopupHighlightingCloseHandler);
            return false;
        }
    }

    private boolean checkPositiveInt(ValueBox<?> source) {
        return checkPositiveInt(source, false);
    }

    private boolean checkPositiveInt(ValueBox<?> source, boolean skipHighlighting) {
        try {
            boolean result = Integer.parseInt(source.getText()) >= 0;
            if (!skipHighlighting && !result && source instanceof Highlightable) {
                HighlightingHelper.highlightError((Highlightable) source);
            }
            return result;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkPositiveDouble(DoubleBox source) {
        try {
            Double value = source.getValue();
            boolean result = value != null && value >= 0;
            if (!result && source instanceof Highlightable) {
                HighlightingHelper.highlightError((Highlightable) source);
            }
            return result;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkMaxValue(ExtendedDoubleBox source) {
        Double val = source.getValue();
        boolean result = (val != null && val <= WebAppConstants.MAX_VAL);
        if (!result) {
            HighlightingHelper.highlightError(source);
        }
        return result;
    }

    private MenuDetailsDTO readDishFromForm(MenuDetailsDTO dish) {
        if (dish == null)
            dish = new MenuDetailsDTO();
        dish.setDishName(newTitleBox.getText().trim());
        dish.setDishType(dishTypes.get(newTypeDishes.getSelectedIndex()));
        dish.setMaxCount(isEmpty(newMaxCountBox, true) ? MenuDetails.UNESTIMATABLE_COUNT : newMaxCountBox.getValue());
        dish.setMenu(selectedMenu);
        dish.setPrice(newPriceBox.getValue());
        dish.setStructure(newConsistBox.getValue().trim());
        dish.setWeight(newWeightBox.getValue());
        dish.setIsChiefChoice(isChefDish.getValue());
        dish.setImageId(imageId);
        dish.setUrl(preprocessUrl(newURL.getValue()));
        return dish;
    }

    private String preprocessUrl(String url) {

        if (StringUtilities.hasText(url)) {
            url = url.trim();
            if (!url.startsWith(CHECK_URL_PREFIX)) {
                url = URL_PREFIX + url;
            }
            return url;
        }
        return StringUtils.EMPTY;

    }

    private void readMenuFromForm(MenuDTO menu) {
        menu.setCreateDate(new Date());
        menu.setMenuName(newMenuTitle.getText().trim());
        menu.setMenuOnDate(newMenuDate.getValue());
        menu.setReceiptStartDate(newOrderStartTime.getValue());
        menu.setReceiptEndDate(newOrderEndTime.getValue());
        menu.setDeliveryStartDate(newOrderDeliveryStartTime.getValue());
        menu.setDeliveryEndDate(newOrderDeliveryEndTime.getValue());
    }

    private void writeMenuToForm(MenuDTO menu) {
        writeMenuToForm(menu, false);
    }

    private void writeMenuToForm(MenuDTO menu, boolean editing) {
        selectedMenu = menu;
        if (menu != null) {
            if (!editing) {
                newMenuDate.setValue(menu.getMenuOnDate());
                newMenuTitle.setValue(menu.getMenuName());
                newOrderStartDate.setValue(menu.getReceiptStartDate());
                newOrderEndDate.setValue(menu.getReceiptEndDate());
                newOrderStartTime.setValue(menu.getReceiptStartDate());
                newOrderEndTime.setValue(menu.getReceiptEndDate());
                newOrderDeliveryStartTime.setValue(menu.getDeliveryStartDate());
                newOrderDeliveryEndTime.setValue(menu.getDeliveryEndDate());
            }
            List<MenuDetailsDTO> details = getAliveMenuDetails(menu);
            menuDetails.setRowData(details);
            menuDetailsPanel.setVisible(!details.isEmpty());
        } else {
            newMenuDate.setValue(null);
            newMenuTitle.setValue(null);
            newOrderStartDate.setValue(null);
            newOrderEndDate.setValue(null);
            newOrderStartTime.setValue(null);
            newOrderEndTime.setValue(null);
            newOrderDeliveryStartTime.setValue(null);
            newOrderDeliveryEndTime.setValue(null);
            menuDetails.setRowData(new ArrayList<MenuDetailsDTO>());
            for (MenuDTO menuItem : menuTable.getVisibleItems())
                menuTable.getSelectionModel().setSelected(menuItem, false);
            menuDetailsPanel.setVisible(false);
        }

        selectDish(null);

        boolean menuEnableEdit = selectedMenu != null && selectedMenu.getStatus() == MenuStatus.DRAFT;
        boolean menuUnBlock = selectedMenu != null && selectedMenu.getStatus() == MenuStatus.AVAILABLE;
        unBlockMenu.setVisible(menuUnBlock);
        writeDishToForm(null);

        dishsTable.setVisible(selectedMenu != null);
        visibleOfButton(menuEnableEdit);
    }

    public void visibleOfButton(boolean isVisible) {
        saveMenu.setVisible(isVisible);
        blockMenu.setVisible(isVisible);
        deleteMenu.setVisible(isVisible);
        menuEditPanel.setVisible(isVisible);
        dishActions.setVisible(isVisible);
    }

    private void writeDishToForm(MenuDetailsDTO dish) {
        selectedMenuDetailsDTO = dish;
        if (dish != null) {
            newTitleBox.setValue(dish.getDishName());
            newConsistBox.setValue(dish.getStructure());
            newTypeDishes.setSelectedIndex(dishTypes.indexOf(dish.getDishType()));
            newWeightBox.setText(dish.getWeight().toString());
            newPriceBox.setValue(dish.getPrice());

            final int maxCount = dish.getMaxCount();
            if (maxCount != MenuDetails.UNESTIMATABLE_COUNT) {
                newMaxCountBox.setValue(maxCount);
            } else {
                newMaxCountBox.setText("");
            }

            isChefDish.setValue(dish.getIsChiefChoice());
            imageDish.clear();
            imageId = dish.getImageId();
            boolean imgVisible = imageId != null;
            if (imgVisible) {
                image = new Image();
                image.setUrl(ServiceUtils.getImageUrlById(imageId));
                image.setWidth(IMAGE_WIDTH);
                image.setHeight(IMAGE_WIDTH);
                imageDish.add(image);
            }
            imageDel.setVisible(imgVisible);
            newPhoto.setVisible(!imgVisible);
            newURL.setValue(dish.getUrl());

        } else {
            clearDialog();
        }
        boolean menuEnableEdit = dish != null && selectedMenu != null && selectedMenu.getStatus() == MenuStatus.DRAFT;
        editDish.setVisible(menuEnableEdit);
        delDish.setVisible(menuEnableEdit);
    }

    @Override
    public void setPresenter(ApplicationActivity applicationActivity) {
        createMenuPresenter = applicationActivity.createMenuPresenter;
        refreshData();
    }

    public void refreshData() {
        createMenuPresenter.getDishList(asyncCallbackDishList);
        createMenuPresenter.getLastMenus(dateStartBox.getValue(), dateEndBox.getValue(), asyncCallbackGetMenus);
    }

    private void cloneSelectedMenu() {
        selectedMenuClone = selectedMenu == null ? null : selectedMenu.clone();
    }

    private void highlightChangedFields() {
        for (Highlightable highlightable : highlightables) {
            HighlightingHelper.highlightChanged(highlightable, !isEditingMenu());
        }
    }

    private boolean hasFieldChanges() {
        if (selectedMenu == null) {
            return false;
        }
        if (!isEditingMenu()) {
            return true;
        } else {
            List<MenuDetailsDTO> selectedMenuActiveList = getAliveMenuDetails(selectedMenu);
            List<MenuDetailsDTO> cloneMenuActiveList = getAliveMenuDetails(selectedMenuClone);
            final int size = selectedMenuActiveList.size();
            if (size != cloneMenuActiveList.size()) {
                return true;
            }
            for (int i = 0; i < size; i++) {
                MenuDetailsDTO left = selectedMenuActiveList.get(i);
                MenuDetailsDTO right = cloneMenuActiveList.get(i);
                if (!MenuDetailsDTO.hasSameContent(left, right)) {
                    return true;
                }
            }
        }
        for (Stateful highlightable : highlightables) {
            if (highlightable.isChanged()) {
                return true;
            }
        }
        return false;
    }

    private List<MenuDetailsDTO> getAliveMenuDetails(MenuDTO dto) {
        return new AliveMenuDetails(dto.getMenuDetails());
    }

    private boolean isEditingMenu() {
        return selectedMenu != null && selectedMenu.getId() != null;
    }

    private abstract class DishCallBack implements AsyncCallback<Integer> {

        MenuDetailsDTO dish;

        public void setDish(MenuDetailsDTO dish) {
            this.dish = dish;
        }

        @Override
        public void onFailure(Throwable caught) {
            GWT.log("[Error]", caught);
        }

        @Override
        public void onSuccess(Integer result) {
            if (isValid(result)) {
                validate(result);
            } else {
                invalidate(result);
            }
        }

        public boolean isValid(Integer result) {
            return result <= dish.getMaxCount();
        }

        public abstract void validate(Integer result);

        public abstract void invalidate(Integer result);

    }

    private class DeleteMenuCallback implements AsyncCallback<Boolean> {

        private MenuDTO menuToDelete;

        public void setMenuToDelete(MenuDTO menuToDelete) {
            this.menuToDelete = menuToDelete;
        }

        @Override
        public void onFailure(Throwable caught) {
            GWT.log("[Error]", caught);
            menuToDelete = null;
        }

        @Override
        public void onSuccess(Boolean result) {
            if (!result) {
                MessageDialog.alert(CONSTANTS.cantDeleteSelectedMenu());
            } else {
                menuList.remove(menuToDelete);
                menuTable.setRowData(menuList);
                selectionModelForMenu.setSelected(selectionModelForMenu.getSelectedObject(), false);
                selectedMenu = null;
            }
            menuToDelete = null;
        }

    }

    @Override
    public void approve(final ApproveableAction action) {
        if (!hasFieldChanges()) {
            action.run(true);
        } else {
            highlightChangedFields();
            if (action instanceof ApproveableActionWithMessage) {
                changeViewConfirmation.setAction(action);
                MessageDialog.confirm(((ApproveableActionWithMessage) action).getConfirmationMessage(),
                    changeViewConfirmation);
            } else {
                changeViewConfirmation.setAction(action);
                MessageDialog.confirm(CONSTANTS.confirmHasChangesOnOtherAction(), changeViewConfirmation);
            }
        }
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

    private class ChangeViewConfirmation extends DefaultApproveConfirmation {

        @Override
        public void onPositiveButtonClick(DialogEvent<MessageDialog> event) {
            super.onPositiveButtonClick(event);
            clearHighlighting(highlightables);
        }

        @Override
        public void onNegativeButtonClick(DialogEvent<MessageDialog> event) {
            super.onNegativeButtonClick(event);
            clearHighlighting(highlightables);
        }

    }

    private void clearHighlighting(Highlightable[] highlightables) {
        for (Highlightable highlightable : highlightables) {
            HighlightingHelper.removeChangedHighlighting(highlightable);
            HighlightingHelper.removeErrorHighlighting(highlightable);
        }
    }

}
