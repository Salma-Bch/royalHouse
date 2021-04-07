package view;

import model.Cell;
import model.Furniture;
import org.junit.Test;
import process.ToolboxHandler;

import javax.swing.*;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ToolboxPanelTest {

    @Test
    public void getJpanelComboboxs() {
        JComboBox comboBoxMeuble = new JComboBox();
        JComboBox comboBoxStyles = new JComboBox();
        JPanel jPanel = new JPanel();

        jPanel.add(comboBoxMeuble);
        jPanel.add(comboBoxStyles);
        assertNotNull(jPanel);
        assertEquals(comboBoxMeuble, jPanel.getComponent(0));
        assertEquals(comboBoxStyles, jPanel.getComponent(1));
    }

    @Test
    public void drawFurniture() throws IOException {
        GridPanel gridPanel = new GridPanel(12, 12, false, false,1);
        ToolboxHandler tlb = new ToolboxHandler();
        ArrayList<Furniture> furnitures = tlb.initFurniture("./ressources/furnitures.csv");
        ArrayList<String> aStyle = tlb.getFilters("./ressources/styleFilter.csv");
        ArrayList<String> aType = tlb.getFilters("./ressources/meubleFilter.csv");




        gridPanel.getGridHandler().removeFurnitures();
        int nbElt = 0;
        for (int i = 0; i < furnitures.size(); i++) {
            for(int j = 0; j<aStyle.size(); j++) {
                for(int k = 0; k<aType.size(); k++) {
                    if (furnitures.get(i).getStyle().equals(aStyle.get(j)) && furnitures.get(i).getType().equals(aType.get(k))) {
                        gridPanel.getGridHandler().addFurniture(nbElt, furnitures.get(i));
                        assertEquals(aType.get(k),  gridPanel.getGridHandler().getGrid().getCells().get(nbElt).getFurniture().getType());
                        assertEquals(aStyle.get(j),  gridPanel.getGridHandler().getGrid().getCells().get(nbElt).getFurniture().getStyle());
                        nbElt++;
                    }
                }
            }
        }
    }
}