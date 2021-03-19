package process;

import model.Cell;
import model.Furniture;
import model.Grid;
import org.junit.Test;
import view.GridPanel;

import javax.swing.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GridHandlerTest {

    @Test
    public void addFurniture() {
        int position=0;
        Furniture furniture = new Furniture("Canapé", "Baroque", "Canapé baroque bleu",
                200, 200, false,
                new ImageIcon("./ressources/images/canapes/baroque_1.png"));
        /*GridHandler gr = new GridHandler(1,1);
        //ssertEquals(null, gr.addFurniture(position,furniture));
        gr.addFurniture(position,furniture);*/

        GridPanel gp = new GridPanel(1,1, false);
        gp.getGridHandler().addFurniture(position, furniture);
        Furniture f = gp.getGridHandler().getGrid().getCells().get(position).getFurniture();
        assertNotNull(f);
        assertSame(furniture,f);

    }

    @Test
    public void initGrid(){
        int r=4, c=4;
        Grid grid = new Grid(r,c);
        ArrayList<Cell> cells = new ArrayList<Cell>();
        for(int i = 0; i<r*c; i++) {
            Cell cell = new Cell(200, 200, null);
            cells.add(cell);
        }
        grid.setCells(cells);
        assertNotNull(grid);
        //assertSame(grid,cells);
        assertEquals(r*c, grid.getCells().size());
    }

    @Test
    public void setSelectedCell() {
    }

    @Test
    public void getSelectedCell() {
    }

    @Test
    public void getGrid() {
    }

    @Test
    public void removeFurnitures() {
        int position=0;
        Furniture furniture = new Furniture("Canapé", "Baroque", "Canapé baroque bleu",
                200, 200, false,
                new ImageIcon("./ressources/images/canapes/baroque_1.png"));
        GridPanel gp = new GridPanel(1,1,false);
        gp.getGridHandler().addFurniture(position, furniture);
        gp.getGridHandler().removeFurnitures();
        assertNull(gp.getGridHandler().getGrid().getCells().get(position).getFurniture());

    }

    @Test
    public void getRowNumber() {
    }

    @Test
    public void getColumnNumber() {
    }
}