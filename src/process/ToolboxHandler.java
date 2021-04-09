package process;

import model.Furniture;
import view.CellPanel;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;


/**
 * \file ToolboxHandler.c
 * \brief Gestionnaire de boite à outil
 * \author LEKMITI Mouncif, MANOUBI Farah, BENCHELKHA Salma, OBEYESEKARA Avishka, CERINI Enzo, DENDOUNE Rayane
 * \version 1.0
 * \date 09/04/2021
 *
 * Cette classe est le gestionnaire de boite à outil. Elle permet d'initialiser les combobox et d'initialiser les meubles dans la boite à outil.
 *
 */
public class ToolboxHandler {
    private GridHandler gridHandler;
   // public static CellPanel selectedCellPanel;

    public ToolboxHandler(){

    }

    /**
     * ArrayList<String> getFilters(String filePathName)
     * @brief Fonction qui permet de lire un fichier et retourner ce qu'il y a dedans sous forme d'une ArrayList de String
     * @param filePathName Chemin du fichier que nous voulons lire (type String)
     * @return Retourne une ArrayList de String après la lecture du fichier
     */
    public ArrayList<String> getFilters(String filePathName) throws IOException {
        ArrayList<String> filtres = new ArrayList<String>();
        FileReader fr = new FileReader(new File(filePathName));
        BufferedReader br = new BufferedReader(fr);
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] words = line.split(";");
            for (String word:words) {
                filtres.add(word);
            }
        }
        br.close();
        fr.close();
        return filtres;
    }

    /**
     * void initComboBox(JComboBox  comboBoxMeuble, JComboBox comboBoxStyles)
     * @brief Fonction qui permet d'initialiser deux JComboBox : Une pour les meuble et une autre pour le style
     * @param comboBoxMeuble (type JComboBox)
     * @param comboBoxStyles (type JComboBox)
     */
    public void initComboBox(JComboBox  comboBoxMeuble, JComboBox comboBoxStyles) {
        ArrayList<String> meubleFiltres= new ArrayList<String>();
        ArrayList<String> styleFiltres = new ArrayList<String>();
        try {
            meubleFiltres = this.getFilters("ressources/styleFilter.csv");
            styleFiltres = this.getFilters("ressources/meubleFilter.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String filtre: meubleFiltres) {
            comboBoxMeuble.addItem(filtre);
        }
        for (String filtre: styleFiltres) {
            comboBoxStyles.addItem(filtre);
        }
    }

    /**
     * ArrayList<Furniture> initFurniture(String filePathName)
     * @brief Fonction qui retourne une ArrayList de Meuble grâce au chemin du fichier qui va être passé en paramètre.
     * @param filePathName Chemin du fichier que nous voulons lire (type String)
     * @return Retourne une ArrayList de Meuble après la lecture du fichier
     */
    public ArrayList<Furniture> initFurniture(String filePathName) throws IOException {
        ArrayList<Furniture> furniture = new ArrayList<Furniture>();
        FileReader fr = new FileReader(new File(filePathName));
        BufferedReader br = new BufferedReader(fr);
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] words = line.split(";");
            furniture.add(new Furniture(words[0], words[1], words[2], 200,200,new ImageIcon(words[3])));
        }
        br.close();
        fr.close();
        return furniture;
    }
}
