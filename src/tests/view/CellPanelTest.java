package tests.view;

import model.Cell;
import model.Furniture;
import org.junit.Test;
import view.CellPanel;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

/**
 * \file CellPanelTest.java
 * \brief Classe qui permet de tester les méthodes de la classe CellPanel.
 * \author BENCHELKA Salma, LEKMITI Mouncif, MANOUBI Farah, OBEYESEKARA Avishka, CERINI Enzo, DENDOUNE Rayane
 * \version 1.0
 * \date 09/04/2021
 *
 * Classe contenant toutes les methodes de test de la classe CellPanel.
 */

public class CellPanelTest {

    /**
     * @brief Méthode permettant de tester la méthode informationsMeubles() de la classe CellPanel.
     * @details Méthode qui vérifie, qu'après l'ajout d'un JPanel informationsMeubles dans un CellPanel cp, celui-ci n'est pas NULL.
     */
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