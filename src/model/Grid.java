package model;

import java.util.ArrayList;

public class Grid {

    private ArrayList<Cell> cells;


    public Grid(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }
}
