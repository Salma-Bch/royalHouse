package process;

import model.Cell;
import model.Grid;

import java.util.ArrayList;

public class GridConstructor {
    public static final int heightCell = 50;
    public static final int widthCell = 50;
    public int columnNumber, rowNumber;
    ArrayList<Cell> cells = new ArrayList<Cell>();


    public GridConstructor(int columnNumber, int rowNumber) {
        Grid grid = createGrid(columnNumber, rowNumber);
        this.columnNumber=columnNumber;
        this.rowNumber=rowNumber;
    }

    public Grid createGrid(int columnNumber, int rowNumber) {
        Grid grid = new Grid(columnNumber, rowNumber);
        for(int i = 0; i<columnNumber*rowNumber; i++) {
                Cell cell = new Cell(widthCell, heightCell, null);
                cells.add(cell);
        }
        grid.setCells(cells);
        return grid;
    }

    public int getRowNumber() {
        return rowNumber;
    }
    public int getColumnNumber(){
        return columnNumber;
    }
}
