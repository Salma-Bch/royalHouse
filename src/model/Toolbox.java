package model;

import java.util.ArrayList;

public class Toolbox {

    private ArrayList<Furniture> furnitures;
    private Grid grid;

    public Toolbox() {
        furnitures = new ArrayList<Furniture>();
    }

    public Toolbox(Grid grid, ArrayList<Furniture> furnitures) {
        this.grid = grid;
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

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
