package view;

import model.Cell;
import model.Grid;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class GridPanelTest {

    @Test
    public void reinitCellPanels() {
        ArrayList<CellPanel> cellPanels = new ArrayList<CellPanel>();
        Cell cell = new Cell(10, 10, null);
        CellPanel cp = new CellPanel(cell, 200, false, false, false);
        cellPanels.add(cp);

        for (CellPanel cellPanel : cellPanels) {
           cellPanel.setBackgroundColor(Color.GRAY);
        }

        GridPanel gp = new GridPanel(2,2,false, false, 4);
        gp.reinitCellPanels();

        for(int i = 0; i<cellPanels.size(); i++) {
            System.out.println("La couleur est : " + cellPanels.get(i).getBackgroundColor());
            System.out.println("La couleur est : " + Color.GRAY);

            assertEquals(Color.GRAY, cellPanels.get(i).getBackgroundColor());

        }
   }

    @Test
    public void initCellPanels() {
        ArrayList<CellPanel> cellPanels = new ArrayList<CellPanel>();
        int r = 2;
        int c = 2;
        for(int i=0; i<r*c; i++) {
            Cell cell = new Cell(10, 10, null);
            CellPanel cp = new CellPanel(cell, 200, false, false, false);
            cellPanels.add(cp);
        }
        assertNotNull(cellPanels);
        assertEquals(r*c, cellPanels.size());
    }

    @Test
    public void paint() {
    }

    @Test
    public void getGridHandler() {
    }
}