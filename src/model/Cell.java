package model;

import java.io.Serializable;

public class Cell implements Serializable {

    public static int width;
    public static int height;
    private Furniture furniture;
    private final int position;

    public Cell(int width, int height, int position, Furniture furniture) {
        Cell.width = width;
        Cell.height = height;
        this.furniture = furniture;
        this.position = position;
    }

    public int getPosition(){
        return this.position;
    }

    public Furniture getFurniture() {
        return furniture;
    }

    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        Cell.width = width;
    }

    public void setHeight(int height) {
        Cell.height = height;
    }
}
