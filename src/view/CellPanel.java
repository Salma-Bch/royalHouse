package view;

import model.Cell;
import model.Furniture;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

public class CellPanel extends JPanel implements MouseListener, Serializable {
    private final Cell cell;
    private final int cellSize;
    private Color backgroundColor = Color.GRAY;

    private DragGestureRecognizer dragGestureRecognizer;
    private DragGestureHandler dragGestureHandler;
    DropTarget dropTarget;
    DropHandler dropHandler;

    public CellPanel(Cell cell, int cellSize){
        super();
        this.cell = cell;
        this.cellSize = cellSize;
      //  this.setPreferredSize(new Dimension(2000,200));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.addMouseListener(this);

        //dropTarget = new DropTarget(this,DnDConstants.ACTION_COPY_OR_MOVE, this, true,null);

       /* Furniture f1 = new Furniture("Canapé", "Baroque", "Canapé baroque bleu",
                200, 200, false, new ImageIcon("./ressources/images/canapes/baroque_1.png"));
        cell.setFurniture(f1);*/

        dropHandler = new DropHandler();
        dropTarget = new DropTarget(this, DnDConstants.ACTION_COPY,dropHandler,true);
        dragGestureHandler = new DragGestureHandler(this);
        dragGestureRecognizer = DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY, dragGestureHandler);
    }
    public Cell getCell(){
        return this.cell;
    }

    @Override
    public void addNotify(){
        super.addNotify();
        if (dragGestureRecognizer == null){
            dragGestureHandler = new DragGestureHandler(this);
            dragGestureRecognizer = DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(this
            , DnDConstants.ACTION_COPY,dragGestureHandler);
        }
        dropHandler = new DropHandler();
        dropTarget = new DropTarget(this, DnDConstants.ACTION_COPY, dropHandler, true);
    }

    @Override
    public void removeNotify(){
        if (dragGestureRecognizer != null){
            dragGestureRecognizer.removeDragGestureListener(dragGestureHandler);
            dragGestureHandler = null;
        }
        dragGestureRecognizer = null;
        super.removeNotify();
        dropTarget.removeDropTargetListener(dropHandler);
    }


    @Override
    public void paint(Graphics g){
        super.paint(g);
        this.setBackground(backgroundColor);
        paintFurniture(g);
    }

    public void paintFurniture(Graphics g){
        if(cell.getFurniture() != null) {
            Image image = cell.getFurniture().getImage().getImage().getScaledInstance(cellSize, cellSize, Image.SCALE_DEFAULT);
            ImageIcon imageIcon = new ImageIcon(image);
            imageIcon.paintIcon(this, g,  0, 0);
        }
    }

    public void setBackgroundColor(Color backgroundColor){
        this.backgroundColor = backgroundColor;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ( (GridPanel)this.getParent() ).reinitCellPanels();
        this.getParent().repaint();
        Furniture f = cell.getFurniture();
        if(f != null) {
            try {
                Furniture clonedF = (Furniture)f.clone();
                ToolboxPanel.cellInfoPan.getCell().setFurniture(clonedF);
            } catch (CloneNotSupportedException ex) {
                ex.printStackTrace();
            }

            backgroundColor = Color.BLUE;
            this.repaint();
            /*JTextArea journal = new JTextArea("Monsiffffffffff");
            JScrollPane scrollPane = new JScrollPane(journal);
            JFrame jf = new JFrame();
            jf.add(scrollPane);
            jf.setSize(400, 400) ;
            jf.setVisible(true);
            jf.setLocationRelativeTo(null);
            jf.setLocationRelativeTo(null);*/
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
