/**
 * 
 */
package com.epam.feel.client.ui.util.table;

import static com.epam.feel.client.EpamFeelResources.INSTANCE;
import static com.epam.feel.client.IEpamFeelConstants.CONSTANTS;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import com.epam.feel.client.ui.user.DishCounterView;
import com.epam.feel.client.ui.user.DishCounterView.OnValueChangedListener;
import com.epam.feel.client.ui.util.AliveMenuDetails;
import com.epam.feel.client.ui.util.cell.DishNameCell;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.dto.DishTypeDTO;
import com.epam.feel.shared.dto.MenuDTO;
import com.epam.feel.shared.dto.MenuDetailsDTO;
import com.epam.feel.shared.dto.RequestDetailsDTO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

/**
 * Class encapsulate methods and UI Components to output MenuDTO and RequestDTO into GWT FlexTable.
 * 
 * @author Evgeny_Kincharov
 */
public final class MenuTable extends FlexTable {

    private static final int DISH_CHECKBOX_COLUMN_INDEX = 0;
    private static final int DISH_TITLE_COLUMN_INDEX = 1;
    private static final int DISH_WEIGHT_COLUMN_INDEX = 2;
    private static final int DISH_PRICE_COLUMN_INDEX = 3;
    private static final int DISH_COUNT_COLUMN_INDEX = 4;
    private static final int DISH_TOTAL_PRICE_COLUMN_INDEX = 5;

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_DISH_ITEM = 1;
    private static final int TYPE_DISHS = 2;
    private static final int TYPE_SUM_TOTAL_TEXT = 3;
    private static final int TYPE_SUM_TOTAL_VALUE = 4;

    public static final int ON_CHECK_DISH_COUNT = 1;
    public static final int ON_UNCHECK_DISH_COUNT = 0;

    private MenuDTO menu;
    private List<RequestDetailsDTO> order;
    private boolean shouldUseOnlyActiveMenuDetails = false;
    private Map<Integer, Integer> menuRowNumToMenuDTODetails = new HashMap<Integer, Integer>();
    private Map<Integer, RequestDetailsDTO> menuRowNumToRequestDetails = new LinkedHashMap<Integer, RequestDetailsDTO>();

    private OnValueChangedListener changeListener = new OnValueChangedListener() {

        @Override
        public void onValueChanged(DishCounterView counter) {
            final int rowIndex = counter.getTag();
            CheckBox checkBox = (CheckBox) getWidget(rowIndex, DISH_CHECKBOX_COLUMN_INDEX);
            if (checkBox != null) {
                checkBox.setValue(counter.getCounterValue() > 0);
            }
        }
    };

    /**
     * Default Constructor. Called on Create form and all components
     */
    public MenuTable() {
        super();
        setStyleName(INSTANCE.global().tableMenu());
        setHeader();
    }

    public boolean shouldUseOnlyActiveMenuDetails() {
        return shouldUseOnlyActiveMenuDetails;
    }

    public void setShouldUseOnlyActiveMenuDetails(boolean shouldUseOnlyActiveMenuDetails) {
        this.shouldUseOnlyActiveMenuDetails = shouldUseOnlyActiveMenuDetails;
    }

    public void calculateAndFillTotal() {
        int totalRowIndex = getRowCount();
        float total = 0;
        for (int i = 0; i < totalRowIndex; i++) {
            if (isRowChecked(i)) {
                String price = getText(i, DISH_PRICE_COLUMN_INDEX).replace(" ", "");
                DishCounterView countBox = (DishCounterView) getWidget(i, DISH_COUNT_COLUMN_INDEX);

                total += (float) NumberFormat.getDecimalFormat().parse(price) * countBox.getCounterValue();
            }
        }
        setText(totalRowIndex - 1, 1, WebAppConstants.CURRENCY_FORMATTER.format(total), TYPE_SUM_TOTAL_VALUE);
    }

    /**
     * Click handler of checkBox for calculate total price client's order
     */
    private ClickHandler dishCheckClickHandler = new ClickHandler() {

        @Override
        public void onClick(ClickEvent arg0) {
            int rowNum = getCellForEvent(arg0).getRowIndex();
            onDishCheckValueChanged(rowNum);
        }
    };

    private void onDishCheckValueChanged(int rowNum) {
        if (rowNum > 0) {

            Widget widget = getWidget(rowNum, DISH_COUNT_COLUMN_INDEX);
            if (widget != null && widget instanceof DishCounterView) {
                DishCounterView dishCounter = (DishCounterView) widget;
                if (isRowChecked(rowNum) && dishCounter.getCounterValue().equals(ON_UNCHECK_DISH_COUNT)) {
                    dishCounter.setCounterValueSilently(ON_CHECK_DISH_COUNT);
                } else {
                    dishCounter.setCounterValueSilently(ON_UNCHECK_DISH_COUNT);
                }
            }

            calculatePriceOfRow(rowNum);
        }
        calculateAndFillTotal();
    }

    /**
     * Click handler for DishCounterView for calculate price dish
     */
    private ClickHandler countDishHandler = new ClickHandler() {

        @Override
        public void onClick(ClickEvent arg0) {
            int clickedRowIndex = getCellForEvent(arg0).getRowIndex();
            if (clickedRowIndex > 0) {
                calculatePriceOfRow(clickedRowIndex);
                calculateAndFillTotal();
            }
        }
    };

    private void fillMenuTable(MenuDTO menuDTO) {
        Map<DishTypeDTO, List<MenuDetailsDTO>> dishDetails = new TreeMap<DishTypeDTO, List<MenuDetailsDTO>>(
            new Comparator<DishTypeDTO>() {
                @Override
                public int compare(DishTypeDTO o1, DishTypeDTO o2) {
                    return o1.getId().compareTo(o2.getId());
                }
            });
        List<MenuDetailsDTO> details = menuDTO.getMenuDetails();
        if (shouldUseOnlyActiveMenuDetails()) {
            details = new AliveMenuDetails(details);
        }
        for (MenuDetailsDTO menuItem : details) {
            List<MenuDetailsDTO> list = dishDetails.get(menuItem.getDishType());
            if (list == null) {
                list = new ArrayList<MenuDetailsDTO>();
            }
            list.add(menuItem);
            dishDetails.put(menuItem.getDishType(), list);
        }
        menuRowNumToMenuDTODetails.clear();
        menuRowNumToRequestDetails.clear();
        for (Map.Entry<DishTypeDTO, List<MenuDetailsDTO>> item : dishDetails.entrySet()) {
            int rowDishIndex = getRowCount();
            setText(rowDishIndex, 0, item.getKey().getText(), TYPE_DISHS);
            for (MenuDetailsDTO menuItem : item.getValue()) {
                writeDishToTable(menuDTO, menuItem);
            }
        }

        int rowIndex = getRowCount();
        setText(rowIndex, 0, CONSTANTS.totalAmountText(), TYPE_SUM_TOTAL_TEXT);
        calculateAndFillTotal();
    }

    /**
     * @param menu
     * @param dish
     */
    private void writeDishToTable(MenuDTO menu, MenuDetailsDTO dish) {
        final int rowIndex = getRowCount();
        CheckBox check = new CheckBox();
        menuRowNumToMenuDTODetails.put(rowIndex, menu.getMenuDetails().indexOf(dish));
        check.addClickHandler(dishCheckClickHandler);
        setWidget(rowIndex, DISH_CHECKBOX_COLUMN_INDEX, check, TYPE_DISH_ITEM);
        DishNameCell dishName = new DishNameCell();
        dishName.setDish(dish);
        setWidget(rowIndex, DISH_TITLE_COLUMN_INDEX, dishName);

        setText(rowIndex, DISH_WEIGHT_COLUMN_INDEX, WebAppConstants.WEIGHT_FORMATTER.format(dish.getWeight()),
            TYPE_DISH_ITEM);
        setText(rowIndex, DISH_PRICE_COLUMN_INDEX, WebAppConstants.CURRENCY_FORMATTER.format(dish.getPrice()),
            TYPE_DISH_ITEM);
        setText(rowIndex, DISH_TOTAL_PRICE_COLUMN_INDEX, WebAppConstants.CURRENCY_FORMATTER.format(0), TYPE_DISH_ITEM);
        DishCounterView counterView = new DishCounterView(dish.getMaxCount(), countDishHandler);
        counterView.setTag(rowIndex);
        counterView.setOnValueChangedListener(changeListener);
        setWidget(rowIndex, DISH_COUNT_COLUMN_INDEX, counterView, TYPE_DISH_ITEM);
        if (order != null) {
            for (RequestDetailsDTO details : order) {
                if (details.getMenuDetails().equals(dish)) {
                    menuRowNumToRequestDetails.put(rowIndex, details);
                    int countDishes = details.getCount();
                    counterView.setCounterValue(countDishes);
                    check.setValue(countDishes > 0);
                    calculatePriceOfRow(rowIndex);
                }
            }
        }
    }

    public List<RequestDetailsDTO> generateRequestDetailsFromView() {
        List<RequestDetailsDTO> requestDetails = new ArrayList<RequestDetailsDTO>();
        for (int i = 1; i < getRowCount(); i++) {
            if (isRowChecked(i)) {
                DishCounterView countBox = (DishCounterView) getWidget(i, DISH_COUNT_COLUMN_INDEX);
                int countDish = countBox.getCounterValue();
                if (countDish > 0) {
                    RequestDetailsDTO requestDetail = menuRowNumToRequestDetails.get(i);
                    if (requestDetail == null) {
                        requestDetail = new RequestDetailsDTO();
                        requestDetail.setMenuDetails(menu.getMenuDetails().get(menuRowNumToMenuDTODetails.get(i)));
                    }
                    requestDetail.setCount(countBox.getCounterValue());
                    requestDetails.add(requestDetail);
                }
            }
        }
        return requestDetails;
    }

    public void setObjects(MenuDTO menuDTO, List<RequestDetailsDTO> orderDTO) {
        menu = menuDTO;
        order = orderDTO;
        setHeader();
        if (menu == null) {
            setText(0, DISH_TITLE_COLUMN_INDEX, CONSTANTS.notHaveAvailableMenus(), TYPE_HEADER);
        } else {
            fillMenuTable(menu);
        }
    }

    public void clearMenu() {
        setObjects(menu, null);
    }

    /**
     * Calculating and filled in table price of dish in row with number rowIndex
     * 
     * @param rowIndex
     */
    private void calculatePriceOfRow(int rowIndex) {
        if (isCellPresent(rowIndex, DISH_COUNT_COLUMN_INDEX)) {
            MenuDetailsDTO dish = menu.getMenuDetails().get(menuRowNumToMenuDTODetails.get(rowIndex));
            Widget widget = getWidget(rowIndex, DISH_COUNT_COLUMN_INDEX);
            if (widget != null && widget instanceof DishCounterView && dish != null) {
                DishCounterView dishCounter = (DishCounterView) widget;
                int count = dishCounter.getCounterValue();
                double totalPrice = 0;
                if (isRowChecked(rowIndex)) {
                    totalPrice = count * dish.getPrice();
                }
                setText(rowIndex, DISH_TOTAL_PRICE_COLUMN_INDEX, WebAppConstants.CURRENCY_FORMATTER.format(totalPrice),
                    TYPE_DISH_ITEM);
            }
        }
    }

    /**
     * If dish in the row with number rowIndex is checked return true, else return false
     * 
     * @param rowIndex
     * @return
     */
    private boolean isRowChecked(int rowIndex) {
        boolean result = false;
        if (isCellPresent(rowIndex, DISH_CHECKBOX_COLUMN_INDEX)) {
            Widget checkBox = getWidget(rowIndex, DISH_CHECKBOX_COLUMN_INDEX);
            if (checkBox != null && checkBox instanceof CheckBox) {
                result = ((CheckBox) checkBox).getValue();
            }
        }
        return result;
    }

    private void setStyle(int row, int column, int cellType) {
        String styleName;
        switch (cellType) {
            case TYPE_HEADER:
                styleName = INSTANCE.global().tableMenuHeader();
                break;
            case TYPE_DISH_ITEM:
                if (column == DISH_TITLE_COLUMN_INDEX) {
                    styleName = INSTANCE.global().tableMenuDishRow() + " " + INSTANCE.global().leftText();
                } else {
                    styleName = INSTANCE.global().tableMenuDishRow();
                }
                break;
            case TYPE_DISHS:
                styleName = INSTANCE.global().tableMenuDishType() + " " + INSTANCE.global().leftText();
                getFlexCellFormatter().setColSpan(row, 0, 6);
                break;
            case TYPE_SUM_TOTAL_TEXT:
                styleName = INSTANCE.global().tableMenuDishType() + " " + INSTANCE.global().rightText();
                getFlexCellFormatter().setColSpan(row, 0, 5);
                break;
            case TYPE_SUM_TOTAL_VALUE:
                styleName = INSTANCE.global().tableMenuDishRow();
                break;
            default:
                styleName = null;
        }
        if (styleName != null) {
            getFlexCellFormatter().setStyleName(row, column, styleName);
        }
    }

    private void setWidget(int row, int column, Widget widget, int cellType) {
        setWidget(row, column, widget);
        setStyle(row, column, cellType);
    }

    private void setText(int row, int column, String text, int cellType) {
        setText(row, column, text);
        setStyle(row, column, cellType);
    }

    private void setHeader() {
        removeAllRows();
        setText(0, DISH_CHECKBOX_COLUMN_INDEX, CONSTANTS.empty(), TYPE_HEADER);
        setText(0, DISH_TITLE_COLUMN_INDEX, CONSTANTS.titleColumn(), TYPE_HEADER);
        setText(0, DISH_WEIGHT_COLUMN_INDEX, CONSTANTS.weightColumn(), TYPE_HEADER);
        setText(0, DISH_PRICE_COLUMN_INDEX, CONSTANTS.priceColumn(), TYPE_HEADER);
        setText(0, DISH_COUNT_COLUMN_INDEX, CONSTANTS.countDishColumn(), TYPE_HEADER);
        setText(0, DISH_TOTAL_PRICE_COLUMN_INDEX, CONSTANTS.costColumn(), TYPE_HEADER);
    }

}
