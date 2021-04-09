package model;

import javax.swing.*;
import java.io.Serializable;

public class Furniture implements Serializable, Cloneable {
    private String type;
    private String style;
    private String color;
    private int width;
    private int lenght;
    private ImageIcon image;
    private int orientation;

    public Furniture(String type, String style, String color, int width, int lenght, ImageIcon image) {
        this.type = type;
        this.style = style;
        this.color = color;
        this.width = width;
        this.lenght = lenght;
        this.image = image;
        this.orientation = 0;
    }

    public void incrementeOrientation(){
        this.orientation += 90;
        if(orientation > 270)
            orientation = 0;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getType() {
        return type;
    }

    public String getStyle() {
        return style;
    }

    public String getColor() {
        return color;
    }

    public int getWidth() {
        return width;
    }

    public int getLenght() {
        return lenght;
    }

    public ImageIcon getImage() {
        return this.image;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
}
