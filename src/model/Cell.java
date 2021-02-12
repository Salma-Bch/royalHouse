package model;

public class Cell {

    private int x;
    private int y;
    private int width;
    private int height;
    private Furniture furniture;

    public Cell(int x, int y, int width, int height, Furniture furniture) {
        this.x = x;
        this.y = y;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
