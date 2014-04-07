package com.epam.feel.shared.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import jxl.CellView;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormats;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * Utility for generate excel book.
 * 
 * @author Anna_Gavrilina
 */
public class HandlerWorkBook {
    private static final String DEFAULT_SHEET_NAME = "Group requests";
    private static final int DEFAULT_SHEET_INDEX = 0;

    private HandlerWorkBook() {}

    /**
     * Writes excel book to output stream
     * 
     * @param os
     *            {@link OutputStream}
     * @param cells
     *            list of custom cells
     */
    public static void generateExcelBook(OutputStream os, List<Cell> cells) throws IOException, RowsExceededException,
        WriteException {
        WritableWorkbook workBook = Workbook.createWorkbook(os);
        WritableSheet sheet = workBook.createSheet(DEFAULT_SHEET_NAME, DEFAULT_SHEET_INDEX);

        for (Cell cell : cells) {
            WritableCell writableCell = getCell(cell);
            if (writableCell != null) {
                sheet.addCell(writableCell);

                CellView cv = sheet.getColumnView(cell.getColumn());
                cv.setAutosize(true);
                sheet.setColumnView(cell.getColumn(), cv);
            }
        }
        workBook.write();
        workBook.close();
    }

    private static WritableCell getCell(Cell cell) throws WriteException {
        WritableCell writableCell = getIntCell(cell);
        if (writableCell == null) {
            writableCell = getDoubleCell(cell);
            if (writableCell == null) {
                writableCell = new Label(cell.getColumn(), cell.getRow(), cell.getValue(),
                    getFormat(new WritableCellFormat()));
            }
        }
        return writableCell;
    }

    private static Number getIntCell(Cell cell) throws WriteException {
        try {
            int value = Integer.parseInt(cell.getValue());
            WritableCellFormat cellFormat = new WritableCellFormat(NumberFormats.INTEGER);
            Number writableCell = new Number(cell.getColumn(), cell.getRow(), value, getFormat(cellFormat));
            return writableCell;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static Number getDoubleCell(Cell cell) throws WriteException {
        try {
            double value = Double.parseDouble(cell.getValue());
            WritableCellFormat cellFormat = new WritableCellFormat(NumberFormats.FLOAT);
            Number writableCell = new Number(cell.getColumn(), cell.getRow(), value, getFormat(cellFormat));
            return writableCell;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static WritableCellFormat getFormat(WritableCellFormat cellFormat) throws WriteException {
        cellFormat.setBorder(Border.ALL, BorderLineStyle.MEDIUM);
        cellFormat.setAlignment(jxl.format.Alignment.CENTRE);
        cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
        return cellFormat;
    }
}
