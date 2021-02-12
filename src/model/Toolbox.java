package model;

import java.util.ArrayList;

public class Toolbox {

    private ArrayList<Furniture> furnitures;
    private ArrayList<Cell> cells;

    public Toolbox() {
        furnitures = new ArrayList<Furniture>();
    }

    public Toolbox(ArrayList<Cell> cells, ArrayList<Furniture> furnitures) {
        this.cells = cells;
        this.furnitures = furnitures;
    }

    public ArrayList<Furniture> getFurnitures() {
        return this.furnitures;
    }

    public void setFurnitures(ArrayList<Furniture> furniture) {
        this.furnitures = furniture;
    }

    public ArrayList<Furniture> addMobilier(Furniture meuble) {
        furnitures.add(meuble);
        return furnitures;
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }
}
