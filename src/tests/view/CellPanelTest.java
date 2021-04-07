package view;

import model.Cell;
import model.Furniture;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class CellPanelTest {

    @Test
    public void informationsMeubles() {
        Furniture furniture = new Furniture("Canapé", "Baroque", "Canapé baroque bleu",
                200, 200, new ImageIcon("./ressources/images/canapes/baroque_1.png"));
        Cell cell = new Cell(1,1,furniture);
        CellPanel cp = new CellPanel(cell, 1,false,false, false);
        cp.informationsMeubles();
        assertNotNull(cp);
    }
}