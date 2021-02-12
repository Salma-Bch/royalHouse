package view;

import model.Cell;
import model.Grid;
import process.GridConstructor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GridPanel extends JPanel implements MouseListener {
    public static int sizeCell;
    public static int width;
    public static int height;
    public static GridConstructor grid;
    int position = 0;
    int x = 0;
    int y = 0;
    int px =  50 + x * 50;
    int py = 100 + y * 50 - 50;

    Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();


    public GridPanel(int numberCellX, int numberCellY) {
      //  setPreferredSize(new Dimension(601, 601));
        super();
        this.setSize(600, 600);
        grid = new GridConstructor(6, 6);
        this.addMouseListener(this);
        height = (int)dimension.getHeight();
        width = (int)dimension.getWidth();

        sizeCell = height/numberCellX;
        width  = sizeCell*numberCellX;
        height = sizeCell*numberCellY;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        drawGrid(g, width, height, sizeCell);
        for(int i = 0; i< Toolbox.furnitures.size(); i++){
            Image image = Toolbox.furnitures.get(i).getImage().getImage().getScaledInstance(sizeCell,sizeCell,Image.SCALE_DEFAULT);
            ImageIcon imageIcon = new ImageIcon(image);
            imageIcon.paintIcon(this, g2, i*sizeCell,100);
        }
    }

    private void drawGrid(Graphics g, int width, int height, int sizeCell) {

        g.setColor(Color.BLACK);

       g.drawLine(0, 0, width, 0);
       g.drawLine(0,0, 0, height);
       g.drawLine(0, height, width, height);
       g.drawLine(width,0,width,height);

       for(int i = 0; i<width; i+=sizeCell) {
           g.drawLine(i, 0, i, height);
       }

        for(int i = 0; i<height; i+=sizeCell) {
            g.drawLine(0, i, width, i);
        }

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

        for(int i = 0; i< Toolbox.furnitures.size(); i++){
            Image image = Toolbox.furnitures.get(i).getImage().getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
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
