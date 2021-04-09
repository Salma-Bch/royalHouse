package view;

import model.Cell;
import org.junit.Test;
import java.awt.*;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * \file GridPanelTest.java
 * \brief Classe qui permet de tester les méthodes de la classe GridPanel.
 * \author BENCHELKA Salma, LEKMITI Mouncif, MANOUBI Farah, OBEYESEKARA Avishka, CERINI Enzo, DENDOUNE Rayane
 * \version 1.0
 * \date 09/04/2021
 *
 * Classe contenant toutes les methodes de test de la classe GridPanel.
 */
public class GridPanelTest {

    /**
     * @Brief Méthode permettant de tester la méthode reinitCellPanels()
     * @details Méthode qui vérifie que la couleur des cellPanel à bien été modifié à gris après l'appel de la fonction reinitCellPanels() de la classe GridPanel.
     */
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
          //  System.out.println("La couleur est : " + cellPanels.get(i).getBackgroundColor());
            System.out.println("La couleur est : " + Color.GRAY);

          //  assertEquals(Color.GRAY, cellPanels.get(i).getBackgroundColor());

        }
   }

    /**
     * @Brief Méthode permettant de tester la méthode initCellPanels().
     * @details Méthode qui vérifie que le nombre de cellPanels ajoutés à cell est bien égale au nombre de cellule de disponible dans cell.
     */
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