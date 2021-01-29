package view;

import model.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GridPanel extends JPanel implements MouseListener {
    public static int taille = 50 ;
    public static int width = 600;
    public static int length = 600;
    public static Room grid;
    int position = 0;

    public GridPanel() {
      //  setPreferredSize(new Dimension(601, 601));
        super();
        this.setSize(600, 600);
        grid = new Room();
        this.addMouseListener(this);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        drawGrid(g, width, taille,length);
    }

    private void drawGrid(Graphics g, int width, int taille ,int length) {
        /*g.drawLine(length, 0, width, width);
        g.drawLine(0, width, width, width);
        g.drawLine(0, 0, 0, width);
        g.drawLine(0, 0, width, 0);
        g.drawLine(0, 0, width, 0);*/
        g.setColor(Color.BLACK);

        /*g.drawLine(350, 50, 950, 50);
        g.drawLine(350, 650, 950, 650);
        g.drawLine(350, 50, 350, 650);
        g.drawLine(950, 50, 950, 650);

        for(int i = 350; i<=950; i +=taille) {
            g.drawLine(i, 100, i, 700);
        }

        for(int i = 100; i<650; i++) {
            g.drawLine(350, i, 950, i);
        }*/

        g.drawLine(150, 100, 750, 100);
        g.drawLine(150, 700, 750, 700);
        g.drawLine(150, 100, 150, 700);
        g.drawLine(750, 100, 750, 700);

        for(int i = 100; i<=700; i+=taille) {
            g.drawLine(150, i, 750, i);
        }

        for(int i = 150; i<=750; i+=taille) {
            g.drawLine(i, 100, i, 700);
        }


        /*for (int i = 0; i <= width; i += taille) {
            g.drawLine(i, 0, i, width);
        }

        for (int i = 0; i <= length; i += taille) {
            g.drawLine(1, i, length, i);
        }*/
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX()/50;
        int y = e.getY()/50;
        position = y*12 + x -27;
        System.out.println(position);

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
