package com.epam.feel.client.ui.util.table;

import java.util.List;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.Header;

/**
 * Represents data grid with enabled natural sorting.
 * 
 * @author Michael_Silvanovich
 */
public class SortableDataGrid<T> extends FixedDataGrid<T> {

    public SortableDataGrid() {
        super();
        addColumnSortHandler(new NaturallySortingListHandler<T>(this));
    }

    protected void fillTableHistory(final List<T> data) {
        setRowData(data);
    }

    @Override
    public void insertColumn(int beforeIndex, Column<T, ?> col, Header<?> header, Header<?> footer) {
        super.insertColumn(beforeIndex, col, header, footer);
        col.setSortable(true);
    }

}
