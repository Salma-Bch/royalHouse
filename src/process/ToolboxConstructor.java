package process;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ToolboxConstructor {
    private GridConstructor gridConstructor;
    public ToolboxConstructor( int columnNumber, int rowNumber){
       gridConstructor = new GridConstructor(columnNumber,rowNumber);
    }
    public ToolboxConstructor(){

    }
    public ArrayList<String> getFilters(String pathName) throws IOException {
        ArrayList<String> result = new ArrayList<String>();


        FileReader fr = new FileReader(new File(pathName));
        BufferedReader br = new BufferedReader(fr);

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            result.add(line);
            //System.out.println(line);
        }

        br.close();
        fr.close();

        return result;
    }
    public static void main(String[]args) throws IOException {
        ToolboxConstructor toolboxConstructor = new ToolboxConstructor();
        try {
            ArrayList<String> rc= toolboxConstructor.getFilters("ressources/styleFilter.csv");
            for(int i=0; i<rc.size(); i++) {
                System.out.println(rc.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
