package model;

import java.io.Serializable;
/**
 * \file Cell.java
 * \brief Classe qui permet de créer une cellule
 * \author CERINI Enzo, OBEYESEKARA Avishka, MANOUBI Farah, DENDOUNE Rayane, LEKMITI Mouncif, BENCHELKHA Salma
 * \version 1.0
 * \date 09/04/2021
 *
 * Classe contenant toutes les fonctions associées à la création d'une cellule
 *
 */
public class Cell implements Serializable {
    public static int width;
    public static int height;
    private Furniture furniture;

    /**
     * \fn Cell(int width, int height, Furniture furniture)
     * \brief Constructeur de Cellule
     * \param [in] width correspond à la largeur d'une cellule (Type Integer)
     * \param [in] height correspond  à la taille d'une cellule (Type Integer)
     * \param [in] furniture correspond au meuble present dans la cellule (Type Furniture)
     */

    public Cell(int width, int height, Furniture furniture) {
        Cell.width = width;
        Cell.height = height;
        this.furniture = furniture;
    }

    /**
     * \fn Furniture getFurniture()
     * \brief Fonction qui retourne un meuble
     * \return Retourne un meuble
     */
    public Furniture getFurniture() {
        return furniture;
    }

    /**
     * \fn void setFurniture(Furniture furniture)
     * \brief Fonction qui modifie un mobilier
     * \param [in] furniture correspond au meuble
     *
     */
    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

    /**
     * \fn Furniture getWidht()
     * \brief Fonction qui retourne la largeur
     * \return Retourne une largeur
     */
    public int getWidth() {
        return width;
    }

    /**
     * \fn Furniture getHeight()
     * \brief Fonction qui retourne la taille
     * \return Retourne une taille
     */
    public int getHeight() {
        return height;
    }

    /**
     * \fn void setWidth(int width)
     * \brief Fonction qui modifie la largeur
     * \param [in] width correspond à la largeur (Type Integer)
     */
    public void setWidth(int width) {
        Cell.width = width;
    }

    /**
     * \fn void setHeight(int height)
     * \brief Fonction qui modifie la taille
     * \param [in] taille correspond à la taille (Type Integer)
     */
    public void setHeight(int height) {
        Cell.height = height;
    }
}
