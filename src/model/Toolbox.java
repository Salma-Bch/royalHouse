package model;

import java.util.ArrayList;
/**
 * \file Toolbox.java
 * \brief Classe qui permet de créer une boite à outils
 * \author CERINI Enzo, OBEYESEKARA Avishka, MANOUBI Farah, DENDOUNE Rayane, LEKMITI Mouncif, BENCHELKHA Salma
 * \version 1.0
 * \date 09/04/2021
 *
 * Classe contenant toutes les fonctions associées à la création d'une boite à outils
 *
 */

public class Toolbox {

    private ArrayList<Furniture> furnitures;
    private Grid grid;


    public Toolbox() {
        furnitures = new ArrayList<Furniture>();
    }

    /**
     * \fn Toolobox()
     * \brief Constructeur de Boite à outils
     * \param [in] grid correspond à une grille (Type Grid)
     * \param [in] furnitures correspond à une arraylist de meubles(Type Arraylist<Furniture>)
     */
    public Toolbox(Grid grid, ArrayList<Furniture> furnitures) {
        this.grid = grid;
        this.furnitures = furnitures;
    }

    /**
     * \fn ArrayList<Furniture> getFurnitures()
     * \brief Fonction qui retourne une arraylist de meubles
     * \return Retourne une arraylist de meubles
     */
    public ArrayList<Furniture> getFurnitures() {
        return this.furnitures;
    }

    /**
     * \fn void setCells(ArrayList<Cell> cells)
     * \brief Fonction qui modifie l'arraylist de  meubles
     * \param [in] furniture correspond à une arraylist de meubles(Type Arraylist<Furniture>)</Furniture>
     */

    public void setFurnitures(ArrayList<Furniture> furniture) {
        this.furnitures = furniture;
    }

    /**
     * \fn ArrayList<Furniture> addMobilier(Furniture meuble)
     * \brief Fonction qui permet d'ajouter un meuble dans une arraylist de meubles
     * \param [in] meuble correspond à une arraylist de meubles(Type Furniture)
     * \return Retourne une arraylist de meubles
     */
    public ArrayList<Furniture> addMobilier(Furniture meuble) {
        furnitures.add(meuble);
        return furnitures;
    }

    /**
     * \fn Grid getGrid()
     * \brief Fonction qui permet de retourner une grid
     * \return Retourne une une grille
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * \fn void setGrid(Grid grid)
     * \brief Fonction qui modifie la largeur
     * \param [in] width correspond à la largeur (Type Integer)
     */
    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
