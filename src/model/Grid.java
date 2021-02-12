package model;

import java.util.ArrayList;

public class Grid {

    private ArrayList<Cell> cells;
    private int rowNumber;
    private int columnNumber;


    public Grid(ArrayList<Cell> cells, int rowNumber, int columnNumber) {
        this.cells = cells;
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }
}
