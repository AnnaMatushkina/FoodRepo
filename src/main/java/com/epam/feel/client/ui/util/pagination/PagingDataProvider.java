package com.epam.feel.client.ui.util.pagination;

import java.util.List;

/**
 * An interface for providing row-level updates of data.
 * 
 * @author Michael_Silvanovich
 */
public interface PagingDataProvider<T> {

    /**
     * An interface allow a widget to accept or report failure when a row data is issued for update.
     * 
     * @author Michael_Silvanovich
     */
    interface RowDataAcceptor<T> {

        void accept(int rowCount);

        void accept(int startRow, List<T> rows);

        void failed(Throwable caught);
    }

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
    void updateRowData(int startRow, int maxRows, RowDataAcceptor<T> acceptor);

    /**
     * Asks service to update data row count
     * 
     * @param acceptor
     *            - row-data-acceptor
     */
    void updateRowCount(RowDataAcceptor<T> acceptor);

}
