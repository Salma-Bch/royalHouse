package view;

import org.junit.Test;
import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

/**
 * \file IHMTest.java
 * \brief Classe qui permet de tester les méthodes de la classe IHMTest.
 * \author BENCHELKA Salma, LEKMITI Mouncif, MANOUBI Farah, OBEYESEKARA Avishka, CERINI Enzo, DENDOUNE Rayane
 * \version 1.0
 * \date 09/04/2021
 *
 * Classe contenant toutes les methodes de test de la classe IHMTest.
 */
public class IHMTest {

    /**
     * @Brief Méthode permettant de tester la méthode initToolBoxPan() de la classe IHMTest.
     * @details Méthode qui vérifie que le ToolboxPan initialisé à bien été créé, c'est à dire qu'il n'est pas NULL.
     */
    @Test
    public void initToolboxPan() {
        Dimension dimension;
        int height;
        int width;
        ToolboxPanel toolboxPan = new ToolboxPanel();
        dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        height = (int)dimension.getHeight();
        width  = (int)dimension.getWidth();
        toolboxPan.setPreferredSize(new Dimension(width/4, height));
        toolboxPan.setBorder(BorderFactory.createEmptyBorder(30,0,30,0));
        assertNotNull(toolboxPan);
    }

    /**
     * @Brief Méthode qui permet de tester la méthode initGridPan() de la classe IHMTest.
     * @details Méthode qui vérifie que le GridPan initialisé à bien été créé, c'est à dire qu'il n'est pas NULL.
     */
    @Test
    public void initGridPan() {
        Dimension dimension;
        int height;
        int width;
        GridPanel gridPan = new GridPanel(5,4,true,false, 20);
        dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        height = (int)dimension.getHeight();
        width  = (int)dimension.getWidth();
        gridPan.setPreferredSize(new Dimension(width*7/12, height));
        assertNotNull(gridPan);
    }
}