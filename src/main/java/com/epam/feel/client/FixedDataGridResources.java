package com.epam.feel.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.DataGrid;

/**
 * Style resource for GWT element DtaGrid.
 * 
 * @author Michael_Silvanovich
 */
public interface FixedDataGridResources extends DataGrid.Resources {

    public static final FixedDataGridResources INSTANCE = GWT.create(FixedDataGridResources.class);

    @Source ({DataGrid.Style.DEFAULT_CSS, "fixed-datagrid.css"})
    DataGrid.Style dataGridStyle();
}
