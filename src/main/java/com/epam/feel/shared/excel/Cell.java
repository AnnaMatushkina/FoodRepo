package com.epam.feel.shared.excel;

import java.io.Serializable;

/**
 * The class represents information of table's cell.
 * 
 * @author Anna_Gavrilina
 * 
 */
public class Cell implements Serializable {

    private static final long serialVersionUID = -3046259998392237057L;

    private int row;
    private int column;
    private String value;

    public Cell() {}

    public Cell(int row, int column, String value) {
        super();
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
