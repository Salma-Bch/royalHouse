package process;
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
}
