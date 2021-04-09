package model;

import javax.swing.*;
import java.io.Serializable;
/**
 * \file Furniture.java
 * \brief Classe qui permet de créer un mobilier
 * \author CERINI Enzo, OBEYESEKARA Avishka, MANOUBI Farah, DENDOUNE Rayane, LEKMITI Mouncif, BENCHELKHA Salma
 * \version 1.0
 * \date 09/04/2021
 *
 * Classe contenant toutes les fonctions associées à la création d'un mobilier
 *
 */
public class Furniture implements Serializable, Cloneable {
    private String type;
    private String style;
    private String color;
    private int width;
    private int lenght;
    private ImageIcon image;
    private int orientation;

    /**
     * \fn Furniture(String type, String style, String color, int width, int lenght, ImageIcon image)
     * \brief Constructeur de Meuble
     * \param [in] type correspond au genre du meuble (Type String)
     * \param [in] style correspond à l'architecture du meuble (Type Integer)
     * \param [in] color correspond à la couleur du meuble (Type String)
     * \param [in] width correspond à la largeur du meuble (Type Integer)
     * \param [in] length correspond à la taille du meuble (Type Integer)
     * \param [in] image correspond à l'image representant le meuble (Type Image)
     */

    public Furniture(String type, String style, String color, int width, int lenght, ImageIcon image) {
        this.type = type;
        this.style = style;
        this.color = color;
        this.width = width;
        this.lenght = lenght;
        this.image = image;
        this.orientation = 0;
    }
    /**
     * \fn void incrementeOrientation()
     * \brief Fonction qui permet la rotation du meuble de 90° dans le sens des aiguilles d'une montre
     */
    public void incrementeOrientation(){
        this.orientation += 90;
        if(orientation > 270)
            orientation = 0;
    }
    /**
     * \fn int getOrientation()
     * \brief Fonction qui retourne une orientation
     * \return Retourne une orientation
     */
    public int getOrientation() {
        return orientation;
    }

    /**
     * \fn void setOrientation(int orientation)
     * \brief Fonction qui modifie une orientation
     * \param [in] orientation correspond à la disposition
     *
     */
    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    /**
     * \fn Object clone()
     * \brief Fonction qui duplique un objet
     * \return Retourne l'objet cloné, l'objet dupliqué
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * \fn String getType()
     * \brief Fonction qui retoure un genre
     * \return Retourne un type qui va être utile pour le type de meuble
     */
    public String getType() {
        return type;
    }

    /**
     * \fn String getStyle()
     * \brief Fonction qui retoure un style
     * \return Retourne un style qui va être utile pour le meuble
     */
    public String getStyle() {
        return style;
    }

    /**
     * \fn String getColor()
     * \brief Fonction qui retoure une couleur
     * \return Retourne une couleur qui va être utile pour le meuble
     */
    public String getColor() {
        return color;
    }

    /**
     * \fn String getImage()
     * \brief Fonction qui retoure une image
     * \return Retourne une image qui va être utile pour le meuble
     */
    public ImageIcon getImage() {
        return this.image;
    }

}
