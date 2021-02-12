package view;

import model.Furniture;
import model.Grid;
import process.ToolboxConstructor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ToolboxPanel extends JPanel {
    public static int taille = 91 ;
    public static int width = 620;
    public static int length = 300;
    private JLabel mobilier = new JLabel("Mobilier ");
    JComboBox meubles = new JComboBox();

    public static ToolboxConstructor toolboxConstructor;
    public static ArrayList<Furniture> furnitures;
    //changement du toolbook
    model.Toolbox boiteOutil =  new model.Toolbox() ;


    public ToolboxPanel() {
        //  setPreferredSize(new Dimension(601, 601));

        this.setSize(600, 600);
        toolboxConstructor = new ToolboxConstructor(8,8);
        furnitures = new ArrayList<Furniture>();
        furnitures.add(new Furniture("Canapé", "Baroque", "Canapé baroque bleu", 200, 200, false, new ImageIcon("./ressources/images/canapeVuDenFace.png")));
        furnitures.add(new Furniture("Table", "Classique", "Table classique en bois", 200, 200, false,  new ImageIcon("./ressources/images/tableVuDenFace.png")));
        boiteOutil.setFurnitures(furnitures);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        drawGrid(g, width, taille,length);
        for(int i = 0; i< furnitures.size(); i++){
            Image image = furnitures.get(i).getImage().getImage().getScaledInstance(91,80,Image.SCALE_DEFAULT);
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
