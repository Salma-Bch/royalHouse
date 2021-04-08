package view;

import model.Cell;
import model.Furniture;
import process.GridHandler;
import process.RotatedIcon;
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
    public boolean canThrow;

    private DragGestureRecognizer dragGestureRecognizer;
    private DragGestureHandler dragGestureHandler;
    DropTarget dropTarget;
    DropHandler dropHandler;

    public CellPanel(Cell cell, int cellSize, boolean dropable, boolean dragable,boolean canThrow){
        super();
        this.cell = cell;
        this.canThrow = canThrow;
        this.cellSize = cellSize;
        this.dropable = dropable;
        this.dragable = dragable;
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.addMouseListener(this);
    }
    public Cell getCell(){
        return this.cell;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public void addNotify(){
        if(dragable) {
            super.addNotify();
            if (dragGestureRecognizer == null) {
                dragGestureHandler = new DragGestureHandler(this);
                dragGestureRecognizer = DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(this
                        , DnDConstants.ACTION_COPY, dragGestureHandler);
            }
            dropHandler = new DropHandler();
            if (this.dropable)
                dropTarget = new DropTarget(this, DnDConstants.ACTION_COPY, dropHandler, true);
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
            Image image = cell.getFurniture().getImage().getImage().getScaledInstance(cellSize, cellSize, Image.SCALE_DEFAULT);
            ImageIcon imageIcon = new ImageIcon(image);
            RotatedIcon rotatedIcon = new RotatedIcon(imageIcon,cell.getFurniture().getOrientation());
            rotatedIcon.paintIcon(this, g,  0, 0);
        }
    }

    public void setBackgroundColor(Color backgroundColor){
        this.backgroundColor = backgroundColor;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        ToolboxPanel.gridPanel.reinitCellPanels();
        ToolboxPanel.gridPanel.revalidate();
        ToolboxPanel.gridPanel.repaint();
        IHM.gridPan.reinitCellPanels();
        IHM.gridPan.revalidate();
        IHM.gridPan.repaint();

        this.getParent().repaint();
        Furniture f = cell.getFurniture();
        GridHandler.selectedCellPanel = this;

        if(f != null) {
            JPanel informationsMeubles = informationsMeubles();
            try {
                Furniture clonedF = (Furniture)f.clone();
                GarbagePanel.cellInfoPan.getCell().setFurniture(clonedF);
                GarbagePanel.infoPanel.remove(1);
                GarbagePanel.infoPanel.add(informationsMeubles);
                this.setVisible(true);
                GarbagePanel.infoPanel.revalidate();
                GarbagePanel.infoPanel.repaint();
            } catch (CloneNotSupportedException ex) {
                ex.printStackTrace();
            }

            backgroundColor = new Color(61, 101, 160);
            this.repaint();

        }

    }
    public JPanel informationsMeubles() {
        JPanel informations = new JPanel();
        informations.setLayout(new GridLayout(3,1));

        couleur = new JLabel();
        style = new JLabel();
        type = new JLabel();
        couleur.setText("Couleur : " + cell.getFurniture().getColor());
        style.setText("Style : " + cell.getFurniture().getStyle());
        type.setText("Type : " + cell.getFurniture().getType());
        couleur.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 22));
        style.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 22));
        type.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 22));

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
