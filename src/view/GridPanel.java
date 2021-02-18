package view;

import model.Grid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GridPanel extends JPanel implements MouseListener {

    public static Grid grid;
    int position = 0;
    int x = 0;
    int y = 0;
    int px =  50 + x * 50;
    int py = 100 + y * 50 - 50;
    Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    int height = (int)dimension.getHeight()-100;
    int width  = (int)dimension.getWidth()-400;
    int sizeCell = height/6;

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
        drawGrid(g, width,height, sizeCell, 8, 6);
        for(int i = 0; i< ToolboxPanel.furnitures.size(); i++){
            Image image = ToolboxPanel.furnitures.get(i).getImage().getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
            ImageIcon imageIcon = new ImageIcon(image);
            imageIcon.paintIcon(this, g2, 150 + i*50,100);
        }
    }

    private void drawGrid(Graphics g, int width ,int height, int sizeCell, int column, int row) {

        height = sizeCell * row;
        width = sizeCell * column;
        g.setColor(Color.BLACK);

        g.drawLine(0, 0, width, 0);
        g.drawLine(0, height, width, height);
        g.drawLine(0, 0, 0, height);
        g.drawLine(width, 0, width, height);

        for(int i = 0; i<=width; i+=sizeCell) {
            g.drawLine(i, 0, i, height);
        }

        for(int i = 0; i<=height; i+=sizeCell) {
            g.drawLine(0, i, width, i);
        }


    }
    @Override
    /*public void mouseClicked(MouseEvent e) {
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

    }*/
    public void mouseClicked(MouseEvent e) {
        Graphics g = this.getGraphics();
        if(px != 0 && py != 0) {
            g.setColor(new Color(189, 189, 189));
            g.fillRect(px, py, 0, 0);
        }

        //x = e.getX()/sizeCell;
        //y = e.getY()/sizeCell;
        //System.out.println("x = " + x  + " y = " + y);

        position = 7*y + x;
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
