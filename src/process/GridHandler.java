package process;

import model.Cell;
import model.Furniture;
import model.Grid;
import view.CellPanel;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * \file GridHandler.c
 * \brief Gestionnaire de grille
 * \author LEKMITI Mouncif, MANOUBI Farah, BENCHELKHA Salma, OBEYESEKARA Avishka, CERINI Enzo, DENDOUNE Rayane
 * \version 1.0
 * \date 09/04/2021
 *
 * Cette classe est le gestionnaire de grille. Elle permet d'initialiser la grille ainsi que d'ajouter ou de supprimer les éléments
 *
 */
public class GridHandler implements Serializable{
    private int columnNumber, rowNumber;
    private Grid grid;
    public static CellPanel selectedCellPanel;

    /**
     * GridHandler constructor
     * @param columnNumber Nombre de colonnes (type Integer)
     * @param rowNumber Nombre de lignes (type Integer)
     */
    public GridHandler(int columnNumber, int rowNumber) {
        grid = initGrid(columnNumber, rowNumber);
        this.columnNumber=columnNumber;
        this.rowNumber=rowNumber;
    }

    /**
     * Grid getGrid()
     * @brief Fonction qui retourne la grille qui est dans le constructeur
     * @return Retourne la grille
     */
    public Grid getGrid(){
        return this.grid;
    }

    /**
     * Grid initGrid(int columnNumber, int rowNumber)
     * @brief Fonction qui créer des Cell pour chaque cases de la grille
     * @param columnNumber Nombre de colonnes (type Integer)
     * @param rowNumber Nombre de lignes (type Integer)
     * @return Retourne la grille après initialisation
     */
    public Grid initGrid(int columnNumber, int rowNumber) {
        Grid grid = new Grid(columnNumber, rowNumber);
        ArrayList<Cell> cells = new ArrayList<Cell>();
        for(int i = 0; i<columnNumber*rowNumber; i++) {
            Cell cell = new Cell(200, 200, null);
            cells.add(cell);
        }
        grid.setCells(cells);
        return grid;
    }

    /**
     * void addFurniture(int position, Furniture furniture)
     * @brief Fonction qui ajoute un meuble à un emplacement donné dans la grille.
     * @param position Position à laquelle le meuble doit être placé. (Type Integer)
     * @param furniture Meuble à placer. (Type Furniture)
     */
    public void addFurniture(int position, Furniture furniture) {
        grid.getCells().get(position).setFurniture(furniture);
        //return grid;
    }

    /**
     * void removeFurnitures()
     * @brief Fonction qui supprime un meuble dans la grille.
     */
    public void removeFurnitures(){
        for(int i = 0; i< grid.getCells().size(); i++){
            grid.getCells().get(i).setFurniture(null);
        }
    }

    /**
     * int getRowNumber()
     * @return Le nombre de lignes.
     */
    public int getRowNumber() {
        return this.rowNumber;
    }

    /**
     * int getColumnNumber()
     * @return Le nombre de colonnes.
     */
    public int getColumnNumber(){
        return this.columnNumber;
    }
}
