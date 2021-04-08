package process;

import model.Furniture;
import org.junit.Test;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ToolboxHandlerTest {

    @Test
    public void getFilters() throws IOException {
        ToolboxHandler tbh = new ToolboxHandler();
        ArrayList<String> filtres1 = tbh.getFilters("./ressources/meubleFilter.csv");

        ArrayList<String> filtres2 = new ArrayList<String>();
        FileReader fr = new FileReader(new File("./ressources/meubleFilter.csv"));
        BufferedReader br = new BufferedReader(fr);
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] words = line.split(";");
            for (String word : words) {
                filtres2.add(word);
            }
        }
        assertEquals(filtres2.size(), filtres1.size());
    }

    @Test
    public void initComboBox() throws IOException {
        ToolboxHandler tbh = new ToolboxHandler();
        ArrayList<String> filtres = tbh.getFilters("./ressources/meubleFilter.csv");
        int nbComboBox = 0;

        JComboBox jcb = new JComboBox();

        for (String filtre: filtres) {
            nbComboBox++;
            jcb.addItem(filtre);
        }

        assertEquals(filtres.size(), nbComboBox);
    }

    @Test
    public void initFurniture() throws IOException {
        ToolboxHandler tbh = new ToolboxHandler();
        ArrayList<Furniture> furnitures1 = tbh.initFurniture("./ressources/furnitures.csv");

        ArrayList<String> furnitures2 = new ArrayList<String>();
        FileReader fr = new FileReader(new File("./ressources/furnitures.csv"));
        BufferedReader br = new BufferedReader(fr);
        for (String line = br.readLine(); line != null; line = br.readLine()) {
                furnitures2.add(line);
        }

        assertEquals(furnitures1.size(), furnitures2.size());
    }
}