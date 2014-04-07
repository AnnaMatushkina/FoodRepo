package com.epam.feel.client.ui.util.pagination;

import java.util.Map;

/**
 * An interface for providing row-level updates of data with specified sort order.
 * 
 * @author Michael_Silvanovich
 */
public interface SortablePagingDataProvider<T> extends PagingDataProvider<T> {

    /**
     * Asks service to update row data by given start point with given max result count
     * 
     * @param startRow
     *            - row we start from
     * @param maxRows
     *            - max row we can get
     * @param acceptor
     *            - row-data-acceptor
     */
    void updateRowData(int startRow, int maxRows, Map<String, Boolean> orderByList, RowDataAcceptor<T> acceptor);

}
