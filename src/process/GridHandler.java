package process;

import model.Cell;
import model.Furniture;
import model.Grid;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GridHandler {
    private static final Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    public static final int sizeCell = (int)(dimension.getHeight()-100)/6;
    private int columnNumber, rowNumber, position;
    private Grid grid;
    private int selectedCell;


    public GridHandler(int columnNumber, int rowNumber) {
        grid = createGrid(columnNumber, rowNumber);
        this.columnNumber=columnNumber;
        this.rowNumber=rowNumber;
        this.position = -1;
        this.selectedCell = -1;
    }

    public void setSelectedCell(int selectedCell) {
        this.selectedCell = selectedCell;
    }

    public int getSelectedCell() {
        return selectedCell;
    }

    public Grid getGrid(){
        return this.grid;
    }

    public Grid createGrid(int columnNumber, int rowNumber) {
        Grid grid = new Grid(columnNumber, rowNumber);
        ArrayList<Cell> cells = new ArrayList<Cell>();
        for(int i = 0; i<columnNumber*rowNumber; i++) {
                Cell cell = new Cell(sizeCell, sizeCell, null);
                cells.add(cell);
        }
        grid.setCells(cells);
        grid.getCells().get(7).setFurniture(new Furniture("Canapé", "Baroque", "Canapé baroque bleu",
                200, 200, false, new ImageIcon("./ressources/images/canapeVuDenFace.png")));
        grid.getCells().get(3).setFurniture(new Furniture("Canapé", "Baroque", "Canapé baroque bleu",
                200, 200, false, new ImageIcon("./ressources/images/canapeVuDenFace.png")));
        grid.getCells().get(9).setFurniture(new Furniture("Canapé", "Baroque", "Canapé baroque bleu",
                200, 200, false, new ImageIcon("./ressources/images/canapeVuDenFace.png")));
        grid.getCells().get(2).setFurniture(new Furniture("Canapé", "Baroque", "Canapé baroque bleu",
                200, 200, false, new ImageIcon("./ressources/images/canapeVuDenFace.png")));
        return grid;
    }

    public int getPosition(){ return this.position;}
    public int getRowNumber() {
        return this.rowNumber;
    }
    public int getColumnNumber(){
        return this.columnNumber;
    }
}
