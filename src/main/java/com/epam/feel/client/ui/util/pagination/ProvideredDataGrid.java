package com.epam.feel.client.ui.util.pagination;

import java.util.List;
import com.epam.feel.client.ui.util.pagination.PagingDataProvider.RowDataAcceptor;
import com.epam.feel.client.ui.util.table.FixedDataGrid;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.Range;

/**
 * DataGrid with possibility to obtain data from data providers with PagingDataProvider interface.
 * 
 * @author Michael_Silvanovich
 * @param <T>
 */
public class ProvideredDataGrid<T> extends FixedDataGrid<T> implements RowDataAcceptor<T> {

    private static final OnDataAcceptedListener NULL_LISTENER = new OnDataAcceptedListener() {
        @Override
        public void onSizeOfDataAccepted(int count) {}

        @Override
        public void onDataAccepted(int startRow, int rowCount) {}

        @Override
        public void onFailed(Throwable caught) {}
    };

    protected PagingDataProvider<T> provider;
    protected OnDataAcceptedListener listener = NULL_LISTENER;

    /**
     * Sets data provider
     * 
     * @param provider
     */
    public void setProvider(PagingDataProvider<T> provider) {
        this.provider = provider;
    }

    /**
     * Returns current set data provider
     * 
     * @return provider
     */
    public PagingDataProvider<T> getProvider() {
        return provider;
    }

    /**
     * Sets data accepted callback
     * 
     * @param listener
     */
    public void setDataAcceptedListener(OnDataAcceptedListener listener) {
        if (listener == null) {
            listener = NULL_LISTENER;
        }
        this.listener = listener;
    }

    @Override
    public void setVisibleRange(Range range) {
        boolean same = getVisibleRange().equals(range);
        super.setVisibleRange(range);
        if (!same && getRowCount() > 0) {
            loadVisibleRange();
        }
    }

    /**
     * Forces table to update it is data (if table is providered - data will be reloaded)
     */
    public void refreshData() {
        updateRowCount();
    }

    private void updateRowCount() {
        if (provider != null) {
            provider.updateRowCount(this);
        }
    }

    @Override
    public void accept(int rowCount) {
        setRowCount(rowCount);
        listener.onSizeOfDataAccepted(rowCount);
        if (rowCount > 0) {
            loadVisibleRange();
        }
    }

    void loadVisibleRange() {
        Range range = getVisibleRange();
        if (provider != null) {
            provider.updateRowData(range.getStart(), range.getLength(), this);
        }
    }

    @Override
    public void accept(int startRow, List<T> rows) {
        setRowData(startRow, rows);
        listener.onDataAccepted(startRow, rows.size());
    }

    @Override
    public void failed(Throwable caught) {
        listener.onFailed(caught);
    }

    /**
     * Interface for data accepted event callback.
     * 
     * @author Michael_Silvanovich
     */
    public static interface OnDataAcceptedListener {

        /**
         * Signals that data is accepted from startRow by (startRow + rowCount - 1) row
         * 
         * @param startRow
         * @param rowCount
         */
        void onDataAccepted(int startRow, int rowCount);

        /**
         * Signals that full size of data is obtained
         * 
         * @param count
         */
        void onSizeOfDataAccepted(int count);

        /**
         * Signals that something is wrong
         * 
         * @param caught
         */
        void onFailed(Throwable caught);

    }

    /**
     * Default callback for async services, obtains data and puts it into acceptor (datagrid).
     * 
     * @author Michael_Silvanovich
     * @param <T>
     */
    public static class PagingDataAsyncCallback<T> implements AsyncCallback<List<T>> {

        RowDataAcceptor<T> acceptor;
        int startRow;

        public PagingDataAsyncCallback(int startRow, RowDataAcceptor<T> acceptor) {
            this.acceptor = acceptor;
            this.startRow = startRow;
        }

        @Override
        public void onFailure(Throwable caught) {
            GWT.log("ERROR:" + caught);
            caught.printStackTrace();
            acceptor.failed(caught);
        }

        @Override
        public void onSuccess(List<T> result) {
            acceptor.accept(startRow, result);
        }
    }

    /**
     * Default callback for async services, obtains data size and puts it into acceptor (datagrid).
     * 
     * @author Michael_Silvanovich
     * @param <T>
     */
    public static class PagingCountAsyncCallback<T> implements AsyncCallback<Integer> {

        RowDataAcceptor<T> acceptor;

        public PagingCountAsyncCallback(RowDataAcceptor<T> acceptor) {
            this.acceptor = acceptor;
        }

        @Override
        public void onFailure(Throwable caught) {
            acceptor.failed(caught);
        }

        @Override
        public void onSuccess(Integer result) {
            acceptor.accept(result);
        }
    }

}
