package model;

import java.util.ArrayList;

public class BoiteOutil {

    private ArrayList<Mobilier> mobilier;

    public BoiteOutil() {
        mobilier = new ArrayList<Mobilier>();
    }

    public ArrayList<Mobilier> getArrayMobilier() {
        return this.mobilier;
    }

    public void setMobilier(ArrayList<Mobilier> mobilier) {
        this.mobilier = mobilier;
    }

    public ArrayList<Mobilier> addMobilier(Mobilier meuble) {
        mobilier.add(meuble);
        return mobilier;
    }
}
