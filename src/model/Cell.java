package model;

public class Cell {

    private int width;
    private int height;
    private Furniture furniture;

    public Cell(int width, int height, Furniture furniture) {
        this.width = width;
        this.height = height;
        this.furniture = furniture;
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
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
