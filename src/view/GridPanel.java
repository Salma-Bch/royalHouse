package view;

import model.Grid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GridPanel extends JPanel implements MouseListener {
    public static int taille = 50 ;
    public static int width = 600;
    public static int length = 600;
    public static Grid grid;
    int position = 0;
    int x = 0;
    int y = 0;
    int px =  50 + x * 50;
    int py = 100 + y * 50 - 50;

    public GridPanel() {
      //  setPreferredSize(new Dimension(601, 601));
        super();
        this.setSize(600, 600);
        //grid = new Grid();
        this.addMouseListener(this);


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        drawGrid(g, width, taille,length);
        for(int i = 0; i< ToolboxPanel.furnitures.size(); i++){
            Image image = ToolboxPanel.furnitures.get(i).getImage().getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
            ImageIcon imageIcon = new ImageIcon(image);
            imageIcon.paintIcon(this, g2, 150 + i*50,100);
        }
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
        Graphics g = this.getGraphics();
        if(px != 0 && py != 0) {
            g.setColor(new Color(189, 189, 189));
            g.fillRect(px - 49, py - 49, 49, 49);
        }
        x = e.getX()/50;
        y = e.getY()/50;
        position = y*12 + x -27;
        System.out.println(position);
        px =  50 + x * 50;
        py = 100 + y * 50 - 50;
        g.setColor(new Color(59, 109, 146));
        g.fillRect(px - 49,py - 49,49, 49 );

        for(int i = 0; i< ToolboxPanel.furnitures.size(); i++){
            Image image = ToolboxPanel.furnitures.get(i).getImage().getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
            ImageIcon imageIcon = new ImageIcon(image);
            imageIcon.paintIcon(this, g, 150 + i*50,100);
        }

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
