package view;

import model.Cell;
import model.Furniture;
import model.Toolbox;

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
    private final boolean dropable;
    private final boolean dragable;
    private JLabel couleur;
    private JLabel style;
    private JLabel type;

    private DragGestureRecognizer dragGestureRecognizer;
    private DragGestureHandler dragGestureHandler;
    DropTarget dropTarget;
    DropHandler dropHandler;

    public CellPanel(Cell cell, int cellSize, boolean dropable, boolean dragable){
        super();
        this.cell = cell;
        this.cellSize = cellSize;
        this.dropable = dropable;
        this.dragable = dragable;
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.addMouseListener(this);
    }
    public Cell getCell(){
        return this.cell;
    }

    @Override
    public void addNotify() {
        if (dragable) {
            super.addNotify();
            if (dragGestureRecognizer == null) {
                dragGestureHandler = new DragGestureHandler(this);
                dragGestureRecognizer = DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(this
                        , DnDConstants.ACTION_COPY, dragGestureHandler);
            }
            if (this.dropable) {
                dropHandler = new DropHandler();
                dropTarget = new DropTarget(this, DnDConstants.ACTION_COPY, dropHandler, true);
            }
        }
    }

    @Override
    public void removeNotify(){
        if(dragable) {
            if (dragGestureRecognizer != null) {
                dragGestureRecognizer.removeDragGestureListener(dragGestureHandler);
                dragGestureHandler = null;
            }
            dragGestureRecognizer = null;
            super.removeNotify();
            if (this.dropable)
                dropTarget.removeDropTargetListener(dropHandler);
        }
    }


    @Override
    public void paint(Graphics g){
        super.paint(g);
        this.setBackground(backgroundColor);
        paintFurniture(g);
    }

    public void paintFurniture(Graphics g){
        if(cell.getFurniture() != null) {
            Image image = cell.getFurniture().getImage().getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
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
        JPanel informationsMeubles = informationsMeubles();
        if(f != null) {
            try {
                Furniture clonedF = (Furniture)f.clone();
                ToolboxPanel.cellInfoPan.getCell().setFurniture(clonedF);
                ToolboxPanel.infoPanel.remove(1);
                ToolboxPanel.infoPanel.add(informationsMeubles);
                this.setVisible(true);
                ToolboxPanel.infoPanel.revalidate();
                ToolboxPanel.infoPanel.repaint();
            } catch (CloneNotSupportedException ex) {
                ex.printStackTrace();
            }

            backgroundColor = Color.BLUE;
            this.repaint();

        }

    }
    public JPanel informationsMeubles() {
        JPanel informations = new JPanel();
        informations.setLayout(new GridLayout(3,1));
        JLabel name = new JLabel(cell.getFurniture().getName());
        JLabel style = new JLabel(cell.getFurniture().getStyle());
        JLabel type = new JLabel(cell.getFurniture().getType());
        informations.add(name);
        couleur = new JLabel();
        style = new JLabel();
        type = new JLabel();
        couleur.setText("Couleur : " + cell.getFurniture().getName());
        style.setText("Style : " + cell.getFurniture().getStyle());
        type.setText("Type : " + cell.getFurniture().getType());
        informations.add(couleur);
        informations.add(type);
        informations.add(style);

        return informations;
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
