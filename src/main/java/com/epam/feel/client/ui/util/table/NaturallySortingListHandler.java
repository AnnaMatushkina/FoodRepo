package com.epam.feel.client.ui.util.table;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.cellview.client.ColumnSortEvent.Handler;
import com.google.gwt.user.cellview.client.DataGrid;

/**
 * Contains sorting logic for columns of comparable values (column.getValue must be Comparable to be sorted, in other
 * case no sorting will be applied).
 * 
 * @author Michael_Silvanovich
 * @see DataGrid
 * @param <T>
 *            as same as T in DataGrid<T>
 */
public class NaturallySortingListHandler<T> implements Handler {

    private Map<Column<T, ?>, Comparator<T>> comparators;
    private DataGrid<T> grid;

    public NaturallySortingListHandler(DataGrid<T> grid) {
        this.grid = grid;
        this.comparators = new HashMap<Column<T, ?>, Comparator<T>>();
    }

    @SuppressWarnings ("unchecked")
    public void onColumnSort(ColumnSortEvent event) {

        // Get the sorted column.
        final Column<T, ?> column = (Column<T, ?>) event.getColumn();
        if (column == null) {
            return;
        }

        List<T> list = new LinkedList<T>(grid.getVisibleItems());

        if (list.isEmpty()) {
            return;
        }

        if (isColumnContainsOnlyComparables(column, list)) {

            final Comparator<T> comparator = getComparator(column);

            // Sort using the comparator.
            if (event.isSortAscending()) {
                Collections.sort(list, comparator);
            } else {
                Collections.sort(list, new Comparator<T>() {
                    public int compare(T o1, T o2) {
                        return comparator.compare(o2, o1);
                    }
                });
            }

            grid.setRowData(list);

        }
    }

    protected boolean isColumnContainsOnlyComparables(Column<T, ?> column, List<T> list) {
        for (T row : list) {
            final Object cell = column.getValue(row);
            if (!(cell instanceof Comparable)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Comparator to be used to compare values represented by this column
     * 
     * @param column
     * @return Comparator to be used to compare values represented by this column
     */
    protected Comparator<T> getComparator(Column<T, ?> column) {
        Comparator<T> comparator = comparators.get(column);
        if (comparator == null) {
            comparator = new NaturallyComparator<T>(column);
            comparators.put(column, comparator);
        }
        return comparator;
    }

    private static class NaturallyComparator<T> implements Comparator<T> {

        private Column<T, ?> column;

        public NaturallyComparator(Column<T, ?> column) {
            this.column = column;
            assert column != null;
        }

        @Override
        @SuppressWarnings ({"rawtypes", "unchecked"})
        public int compare(T o1, T o2) {
            Comparable left = (Comparable) column.getValue(o1);
            Comparable right = (Comparable) column.getValue(o2);
            return left.compareTo(right);
        }
    }

}