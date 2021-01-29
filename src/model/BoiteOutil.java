package model;

import java.util.ArrayList;

public class BoiteOutil {

    private ArrayList<Mobilier> mobiliers;

    public BoiteOutil() {
        mobiliers = new ArrayList<Mobilier>();
    }

    public ArrayList<Mobilier> getMobiliers() {
        return this.mobiliers;
    }

    public void setMobiliers(ArrayList<Mobilier> mobilier) {
        this.mobiliers = mobilier;
    }

    public ArrayList<Mobilier> addMobilier(Mobilier meuble) {
        mobiliers.add(meuble);
        return mobiliers;
    }
}
