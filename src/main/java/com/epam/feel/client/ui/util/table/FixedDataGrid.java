package com.epam.feel.client.ui.util.table;

import com.epam.feel.client.FixedDataGridResources;
import com.google.gwt.user.cellview.client.DataGrid;

/**
 * Fixed styled (for IE browsers) data grid.
 * 
 * @author Michael_Silvanovich
 * @param <T>
 */
public class FixedDataGrid<T> extends DataGrid<T> {

    public static final int DEFAULT_PAGE_SIZE = 50;

    public FixedDataGrid() {
        super(DEFAULT_PAGE_SIZE, FixedDataGridResources.INSTANCE);
    }
}
