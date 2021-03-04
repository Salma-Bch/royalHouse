package view;

import model.Cell;
import model.Furniture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CellPanel extends JPanel implements MouseListener {
    private final Cell cell;
    private final int cellSize;

    public CellPanel(Cell cell, int cellSize){
        super();
        this.cell = cell;
        this.cellSize = cellSize;
      //  this.setPreferredSize(new Dimension(2000,200));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.addMouseListener(this);
       /* Furniture f1 = new Furniture("Canapé", "Baroque", "Canapé baroque bleu",
                200, 200, false, new ImageIcon("./ressources/images/canapes/baroque_1.png"));
        cell.setFurniture(f1);*/
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        paintFurniture(g);
    }

    public void paintFurniture(Graphics g){
        if(cell.getFurniture() != null) {
            Image image = cell.getFurniture().getImage().getImage().getScaledInstance(cellSize, cellSize, Image.SCALE_DEFAULT);
            ImageIcon imageIcon = new ImageIcon(image);
            imageIcon.paintIcon(this, g,  0, 0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.setBackground(Color.BLUE);
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
