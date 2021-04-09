package process;

import model.Cell;
import model.Furniture;
import model.Grid;
import org.junit.Test;
import view.GridPanel;

import javax.swing.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * \file GridHandlerTest.java
 * \brief Classe qui permet de tester les méthodes de la classe GridHandler
 * \author BENCHELKA Salma, LEKMITI Mouncif, MANOUBI Farah, OBEYESEKARA Avishka, CERINI Enzo, DENDOUNE Rayane
 * \version 1.0
 * \date 09/04/2021
 *
 * Classe contenant toutes les methodes de test de la classe GridHandler.
 */

public class GridHandlerTest {
    /**
     * @brief Méthode permettant de tester la méthode initGrid(int columnNumber, int rowNumber) de la classe GridHandler.
     * @details Méthode dans laquelle est initialisé un GridPanel dans lequel on ajoute des cellules (Cell). On vérifie ensuite que le nombre de cellules ajoutés est bien égal au nombre de cellules totale de GridPanel.
     */
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

    /**
     * @brief Méthode permettant de tester la méthode addFurniture(int position, Furniture furniture) de la classe GridHandler.
     * @details Un meuble qui à été créé est ajouté à un GridPanel. La méthode verifie que le meuble contenu dans la GridPanel n'est pas NULL et qu'il correspond bien au meuble créé initialement.
     */
    @Test
    public void addFurniture() {
        int position=0;
        int position2=1;
        Furniture furniture = new Furniture("Canapé", "Baroque", "Canapé baroque bleu",
                200, 200,
                new ImageIcon("./ressources/images/canapes/baroque_1.png"));

        Furniture furniture2 = new Furniture("Canapé", "Baroque", "Canapé baroque rose",
                200, 200, new ImageIcon("./ressources/images/canapes/baroque_2.png"));


        GridPanel gp = new GridPanel(2,2, false, false,1);
        gp.getGridHandler().addFurniture(position, furniture);
        //gp.getGridHandler().addFurniture(position2, furniture2);


        Furniture f = gp.getGridHandler().getGrid().getCells().get(position).getFurniture();
        //Furniture f2 = gp.getGridHandler().getGrid().getCells().get(position2).getFurniture();
        assertNotNull(f);
        //assertSame(furniture,f);

        assertEquals(furniture, gp.getGridHandler().getGrid().getCells().get(position).getFurniture());
        //assertEquals(furniture2, gp.getGridHandler().getGrid().getCells().get(position2).getFurniture());





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

    /**
     * @brief Méthode permettant de tester la méthode removeFurnitures() de la classe GridHandler.
     * @details Méthode qui vérifie qu'un meuble créé au préalable est bien à NULL après sa suppression.
     */
    @Test
    public void removeFurnitures() {
        int position=0;
        Furniture furniture = new Furniture("Canapé", "Baroque", "Canapé baroque bleu",
                200, 200, new ImageIcon("./ressources/images/canapes/baroque_1.png"));
        GridPanel gp = new GridPanel(1,1,false,false,1);
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