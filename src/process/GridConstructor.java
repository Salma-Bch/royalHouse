package process;

import model.Cell;
import model.Grid;

import java.util.ArrayList;

public class GridConstructor {
    public static final int heightCell = 50;
    public static final int widthCell = 50;

    ArrayList<Cell> cells = new ArrayList<Cell>();

    public GridConstructor() {

    }

    public void createGrid(int x, int y) {
        for(int i = 0; i<x; i++) {
            for(int j = 0; j<y; j++) {
                Cell cell = new Cell(x, y, widthCell, heightCell, null);
                cells.add(cell);
            }
        }
    }
}
