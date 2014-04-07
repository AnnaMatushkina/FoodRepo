package com.epam.feel.client.ui.util.pagination;

import java.util.Collections;
import java.util.Map;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.cellview.client.ColumnSortEvent.Handler;
import com.google.gwt.view.client.Range;

/**
 * Provides sorting on providered data grids.
 * 
 * @author Michael_Silvanovich
 * @param <T>
 */
public class SortableProvideredDataGrid<T> extends ProvideredDataGrid<T> {

    private static final Map<String, Boolean> EMPTY_MAP = Collections.emptyMap();

    Map<String, Boolean> currentOrderList = EMPTY_MAP;

    public SortableProvideredDataGrid() {
        super();
        addColumnSortHandler(new SortingHandler<T>(this));
    }

    @Override
    void loadVisibleRange() {
        SortablePagingDataProvider<T> sortableProvider = getSortableProvider();
        if (sortableProvider != null) {
            refreshData(getCurrentOrderList());
        } else {
            super.loadVisibleRange();
        }
    }

    @SuppressWarnings ({"unchecked", "rawtypes"})
    public void refreshData(Map<String, Boolean> orderList) {
        Range range = getVisibleRange();
        setCurrentOrderList(orderList);
        SortablePagingDataProvider provider = getSortableProvider();
        if (provider != null) {
            if (!currentOrderList.equals(EMPTY_MAP)) {
                provider.updateRowData(range.getStart(), range.getLength(), orderList, this);
            } else {
                provider.updateRowData(range.getStart(), range.getLength(), this);
            }
        }
    }

    private SortablePagingDataProvider<T> getSortableProvider() {
        if (provider != null && provider instanceof SortablePagingDataProvider) {
            return ((SortablePagingDataProvider<T>) provider);
        }
        return null;
    }

    /**
     * Returns current order by list
     * 
     * @return current order by list
     */
    public Map<String, Boolean> getCurrentOrderList() {
        return currentOrderList;
    }

    /**
     * Sets current order list, sorting will be changed only after loadVisibleRange call
     * 
     * @param currentOrderList
     *            - order by list, must be serializable
     */
    public void setCurrentOrderList(Map<String, Boolean> currentOrderList) {
        if (currentOrderList == null) {
            currentOrderList = Collections.emptyMap();
        }
        this.currentOrderList = currentOrderList;
    }

    /**
     * Provides processing method for sort-order-changed event on columns.
     * 
     * @author Michael_Silvanovich
     * @param <T>
     */
    public static class SortingHandler<T> implements Handler {

        private SortableProvideredDataGrid<T> grid;

        public SortingHandler(SortableProvideredDataGrid<T> grid) {
            this.grid = grid;
        }

        /**
         * Processes sorting event on columns
         */
        @SuppressWarnings ({"unchecked", "rawtypes"})
        public void onColumnSort(ColumnSortEvent event) {

            // Get the sorted column.
            final Column<T, ?> column = (Column<T, ?>) event.getColumn();
            if (column == null) {
                return;
            }

            if (column instanceof SortableColumn) {
                grid.refreshData(((SortableColumn) column).getOrderList(event.isSortAscending()));
            }

        }
    }

}
