package view;

import model.Grid;
import process.GridHandler;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * \file GridPanel.java
 * \brief Classe qui permet d'afficher la grille correspondant à la zone de conception.
 * \author BENCHELKA Salma, LEKMITI Mouncif, MANOUBI Farah, OBEYESEKARA Avishka, CERINI Enzo, DENDOUNE Rayane
 * \version 1.0
 * \date 09/04/2021
 *
 * Classe contenant toutes les fonctions permettant d'afficher la grille centrale.
 */

public class GridPanel extends JPanel  {

    private ArrayList<CellPanel> cellPanels;
    public GridHandler gridHandler;
    private final Grid grid;
    private boolean dropable;
    private int cellSize = 150;

    /**
     * GridPanel constructor
     * @param columnNumber
     * @param rowNumber
     * @param dropable
     * @param canThrow
     * @param cellSize
     */
    public GridPanel( int columnNumber, int rowNumber, boolean dropable, boolean canThrow, int cellSize) {
        super();
        this.dropable = dropable;
        this.cellSize = cellSize;
        this.setLayout(new GridLayout(rowNumber, columnNumber));
        gridHandler = new GridHandler(columnNumber,rowNumber);
        grid = gridHandler.getGrid();
        cellPanels = initCellPanels(canThrow);
    }

    /**
     * @brief Fonction qui permet de réinitialiser les CellPanel.
     * @details Cette fonction parcourt une Arraylist de CellPanel et remet la couleur de ces CellPanel à leur couleur de base (Color.GRAY)
     */
    public void reinitCellPanels(){
        for (CellPanel cellPanel : cellPanels) {
            cellPanel.setBackgroundColor(Color.GRAY);
        }
    }

    /**
     * @brief Cette fonction permet d'initialiser les CellPanel.
     * @param canThrow
     * @return cellPanels Une ArrayList de CellPanel.
     */
    public ArrayList<CellPanel> initCellPanels(boolean canThrow){
        ArrayList<CellPanel> cellPanels = new ArrayList<CellPanel>();
        int rows = grid.getRowNumber();
        int columns = grid.getColumnNumber();
        for(int i=0; i<rows*columns; i++){
            cellPanels.add(new CellPanel(grid.getCells().get(i),cellSize, this.dropable, true,canThrow));
            this.add(cellPanels.get(i));
        }
        return cellPanels;
    }


    /**
     * @brief Fonction qui permet de dessiner.
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    /**
     * @brief Fonction qui retourne le GridHandler.
     * @return gridHandler Un GridHandler.
     */
    public GridHandler getGridHandler() {
        return gridHandler;
    }

}
