package model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * \file Grid.java
 * \brief Classe qui permet de créer une grille
 * \author CERINI Enzo, OBEYESEKARA Avishka, MANOUBI Farah, DENDOUNE Rayane, LEKMITI Mouncif, BENCHELKHA Salma
 * \version 1.0
 * \date 09/04/2021
 *
 * Classe contenant toutes les fonctions associées à la création d'une grille
 *
 */
public class Grid implements Serializable {

    private ArrayList<Cell> cells;
    private int rowNumber;
    private int columnNumber;

    /**
     * \fn Grid(int rowNumber, int columnNumber)
     * \brief Constructeur de Grille
     * \param [in] rowNumber correspond aux lignes de la grille (Type Integer)
     * \param [in] columnNumber correspond aux colonnes de la grille (Type Integer)
     */
    public Grid(int rowNumber, int columnNumber) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        cells = new ArrayList<Cell>();
    }

    /**
     * \fn int getColumnNumber()
     * \brief Fonction qui retourne le nombre de colonnes
     * \return Retourne un nombre de colonnes
     */

    public int getColumnNumber() {
        return columnNumber;
    }

    /**
     * \fn ArrayList<Cell> getCells()
     * \brief Fonction qui retourne une arraylist de cellules
     * \return Retourne une arraylist de celllules
     */
    public ArrayList<Cell> getCells() {
        return cells;
    }

    /**
     * \fn void setCells(ArrayList<Cell> cells)
     * \brief Fonction qui modifie l'arraylist de cellules
     * \param [in] celles correspond à une arraylist de cellules
     */

    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    /**
     * \fn int getRowNumber()
     * \brief Fonction qui retourne le nombre de lignes
     * \return Retourne un nombre de lignes
     */
    public int getRowNumber() {
        return rowNumber;
    }

}
