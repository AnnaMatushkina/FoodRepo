package com.epam.feel.client.ui.util.table;

import com.epam.feel.client.ui.util.pagination.*;
import com.google.gwt.user.client.ui.*;

import static com.epam.feel.client.IEpamFeelConstants.*;

/**
 * Custom data grid for history view. Provides show label for empty dataGrid and hide header.
 * 
 * @author Anna_Gavrilina, Michael_Silvanovich
 */
public class HistoryDataGrid<T> extends SortableProvideredDataGrid<T> {

    public HistoryDataGrid() {
        super();
        setEmptyTableWidget(new Label(CONSTANTS.noDataForView()));
    }

    /**
     * Analyzes hide or show header of data grid by parameter isExistData
     * 
     * @param isExistData
     *            exists data from data grid
     */
    protected void hideHeader(boolean isExistData) {
        if (isExistData) {
            getTableHeadElement().removeClassName("dataGridHeaderHide");
        } else {
            getTableHeadElement().addClassName("dataGridHeaderHide");
        }
    }

    @Override
    public void accept(int rowCount) {
        hideHeader(rowCount > 0);
        super.accept(rowCount);
    }

}
