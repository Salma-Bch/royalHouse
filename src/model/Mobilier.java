package model;

import java.awt.*;

public class Mobilier {

    private String type;
    private String style;
    private String name;
    private int largeur;
    private int longueur;
    private boolean superposable;
    private Image image;

    public Mobilier(String type, String style, String name, int largeur, int longueur, boolean superposable, Image image) {
        this.type = type;
        this.style = style;
        this.name = name;
        this.largeur = largeur;
        this.longueur = longueur;
        this.superposable = superposable;
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public String getStyle() {
        return style;
    }

    public String getName() {
        return name;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getLongueur() {
        return longueur;
    }

    public boolean isSuperposable() {
        return superposable;
    }

    public Image getImage() {
        return this.image;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public void setSuperposable(boolean superposable) {
        this.superposable = superposable;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
