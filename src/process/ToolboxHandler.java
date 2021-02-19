package process;
import model.Furniture;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class ToolboxHandler {
    private GridHandler gridHandler;



    public ToolboxHandler(){

    }

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

    public ArrayList<Furniture> initFurniture() {
        Furniture f1 = new Furniture("Canapé", "Baroque", "Canapé baroque bleu",
                200, 200, false, new ImageIcon("./ressources/images/canapeVuDenFace.png"));
        Furniture f2 = new Furniture("Canapé", "Design", "Canapé design",
                200, 200, false, new ImageIcon("./ressources/images/canape_design.png"));

        Furniture f3 = new Furniture("Canapé", "Baroque", "Canapé baroque",
                200, 200, false, new ImageIcon("./ressources/images/canape_baroque.png"));
        Furniture f4 = new Furniture("Lit", "Classique", "Lit classique",
                200, 200, false, new ImageIcon("./ressources/images/lit_classique.png"));
        Furniture f5 = new Furniture("Lit", "Design", "Lit design",
                200, 200, false, new ImageIcon("./ressources/images/lit_design.png"));
        Furniture f6 = new Furniture("Table", "Classique", "Table classique",
                200, 200, false, new ImageIcon("./ressources/images/table_classique.png"));
        Furniture f7 = new Furniture("Table", "Design", "Table design",
                200, 200, false, new ImageIcon("./ressources/images/table_design.png"));

        ArrayList<Furniture> furniture = new ArrayList<Furniture>();
        furniture.add(f1);
        furniture.add(f2);
        furniture.add(f3);
        furniture.add(f4);
        furniture.add(f5);
        furniture.add(f6);
        furniture.add(f7);

        return furniture;
    }
}
