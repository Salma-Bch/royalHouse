package process;

import model.Cell;
import model.Furniture;
import model.Grid;
import view.CellPanel;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class GridHandler implements Serializable{
    private int columnNumber, rowNumber;
    private Grid grid;
    public static CellPanel selectedCellPanel;

    public GridHandler(int columnNumber, int rowNumber) {
        grid = initGrid(columnNumber, rowNumber);
        this.columnNumber=columnNumber;
        this.rowNumber=rowNumber;
    }

    public Grid getGrid(){
        return this.grid;
    }

    public Grid initGrid(int columnNumber, int rowNumber) {
        Grid grid = new Grid(columnNumber, rowNumber);
        ArrayList<Cell> cells = new ArrayList<Cell>();
        for(int i = 0; i<columnNumber*rowNumber; i++) {
            Cell cell = new Cell(200, 200, null);
            cells.add(cell);
        }
        grid.setCells(cells);
        return grid;
    }

    public void addFurniture(int position, Furniture furniture) {
        grid.getCells().get(position).setFurniture(furniture);
        //return grid;
    }

    public void removeFurnitures(){
        for(int i = 0; i< grid.getCells().size(); i++){
            grid.getCells().get(i).setFurniture(null);
        }
    }

    public int getRowNumber() {
        return this.rowNumber;
    }
    public int getColumnNumber(){
        return this.columnNumber;
    }
}
