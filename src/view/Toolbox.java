package view;

import model.Room;

import javax.swing.*;
import java.awt.*;

public class Toolbox extends JPanel {
    public static int taille = 91 ;
    public static int width = 620;
    public static int length = 300;
    public static Room grid;

    public Toolbox() {
        //  setPreferredSize(new Dimension(601, 601));
        this.setSize(600, 600);
        grid = new Room();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        drawGrid(g, width, taille,length);
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
