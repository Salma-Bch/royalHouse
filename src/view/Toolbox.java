package view;

import model.BoiteOutil;
import model.Mobilier;
import model.Room;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Toolbox extends JPanel {
    public static int taille = 91 ;
    public static int width = 620;
    public static int length = 300;
    public static Room grid;
    public static ArrayList<Mobilier> mobiliers;

    BoiteOutil boiteOutil =  new BoiteOutil() ;


    public Toolbox() {
        //  setPreferredSize(new Dimension(601, 601));
        this.setSize(600, 600);
        grid = new Room();
        mobiliers = new ArrayList<Mobilier>();
        mobiliers.add(new Mobilier("Canapé", "Baroque", "Canapé baroque bleu", 200, 200, false, new ImageIcon("./ressources/images/canapeVuDenFace.png")));
        mobiliers.add(new Mobilier("Table", "Classique", "Table classique en bois", 200, 200, false,  new ImageIcon("./ressources/images/tableVuDenFace.png")));
        boiteOutil.setMobiliers(mobiliers);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        drawGrid(g, width, taille,length);
        for(int i=0; i< mobiliers.size(); i++){
            Image image = mobiliers.get(i).getImage().getImage().getScaledInstance(91,80,Image.SCALE_DEFAULT);
            ImageIcon imageIcon = new ImageIcon(image);
            imageIcon.paintIcon(this, g2, i*91,1);
        }
    }

    private void drawGrid(Graphics g, int width, int taille ,int length) {
        g.drawLine(length, 0, width, width);
        g.drawLine(0, width, width, width);
        g.drawLine(0, 0, 0, width);
        g.drawLine(0, 0, width, 0);
        g.setColor(Color.BLACK);

        for (int i = 0; i <= width; i += taille) {
            g.drawLine(i, 0, i, width);
        }

        for (int i = 0; i <= width; i += taille) {
            g.drawLine(1, i, width, i);
        }
    }
}
