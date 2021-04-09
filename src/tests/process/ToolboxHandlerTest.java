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

/**
 * \file ToolboxHandlerTest.java
 * \brief Classe qui permet de tester les méthodes de la classe ToolboxHandler
 * \author BENCHELKA Salma, LEKMITI Mouncif, MANOUBI Farah, OBEYESEKARA Avishka, CERINI Enzo, DENDOUNE Rayane
 * \version 1.0
 * \date 09/04/2021
 *
 * Classe contenant toutes les methodes de test de la classe ToolboxHandler
 */

public class ToolboxHandlerTest {

    /**
     * @brief Méthode permettant de tester la méthode getFilters(String filePathName) de la classe ToolboxHandler.
     * @details Méthode dans laquelle on ajoute dans 2 ArrayList les types de meubles (String). Dans la première on les ajoute directement depuis le fichier mmeubleFilter.csv. Dans l'autre on les ajoute en utilisant la méthode getFilters() de la classe TollboxHandler. On vérifie ensuite que ces deux Arraylist possèdent le même nombre d'éléments.
     * @throws IOException
     */
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

    /**
     * @brief Méthode permettant de tester la méthode initComboBox(JComboBox  comboBoxMeuble, JComboBox comboBoxStyles) de la classe ToolboxHandler.
     * @Méthode qui vérifie que le nombre nbComboBox correspond bien au nombre d'éléments ajoutés à la JComboBox jcb.
     * @throws IOException
     */
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

    /**
     * @brief Méthode permettant de tester la méthode initFurniture(String filePathName) de la classe ToolboxHandler.
     * @details Méthode qui vérifie que le nombre de meubles ajoutés à la ToolboxHandler est bien égal au nombre de meubles contenue dans le fichier furnitures.csv.
     * @throws IOException
     */
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