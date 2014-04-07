package com.epam.feel.shared.excel;

import java.util.ArrayList;
import java.util.List;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.Widget;

/**
 * Utility for GWT tables.
 * 
 * @author Anna_Gavrilina
 */
public class CellUtil {

    private CellUtil() {}

    /**
     * Convert table data to list of custom cells
     * 
     * @param table
     *            GWT table
     * @return list of cells.
     */
    public static List<Cell> generateCells(HTMLTable table) {
        List<Cell> result = new ArrayList<Cell>();
        for (int r = 0; r < table.getRowCount(); r++) {
            for (int c = 0; c < table.getCellCount(r); c++) {
                Widget cellWidget = table.getWidget(r, c);
                Cell cell = getCell(cellWidget, r, c);
                if (cell != null) {
                    result.add(cell);
                }
            }
        }
        return result;
    }

    private static Cell getCell(Widget cellWidget, int r, int c) {
        Cell cell = null;
        if (cellWidget != null) {
            cell = new Cell(r, c, cellWidget.getElement().getInnerText());
        }
        return cell;
    }
}
