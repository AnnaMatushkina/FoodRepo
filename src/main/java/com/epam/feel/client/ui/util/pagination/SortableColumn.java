package com.epam.feel.client.ui.util.pagination;

import java.util.Map;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.user.cellview.client.Column;

/**
 * @author Michael_Silvanovich
 * @param <T>
 *            source data type
 * @param <C>
 *            dest data type
 */
public abstract class SortableColumn<T, C> extends Column<T, C> {

    public SortableColumn(Cell<C> cell) {
        super(cell);
        setSortable(true);
    }

    /**
     * Returns order list: [{columnName, order-boolean}*]
     * 
     * @param asc
     *            - true - if order must be ascending, false - in other case
     * @return order list
     */
    public abstract Map<String, Boolean> getOrderList(boolean asc);

}