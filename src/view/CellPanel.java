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
    public boolean dropable;
    private JLabel name;
    private JLabel style;
    private JLabel type;
    private JPanel pan  = new JPanel();

    private DragGestureRecognizer dragGestureRecognizer;
    private DragGestureHandler dragGestureHandler;
    DropTarget dropTarget;
    DropHandler dropHandler;

    public CellPanel(Cell cell, int cellSize, boolean dropable){
        super();
        this.cell = cell;
        this.cellSize = cellSize;
        this.dropable = dropable;
      //  this.setPreferredSize(new Dimension(2000,200));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.addMouseListener(this);

        //dropTarget = new DropTarget(this,DnDConstants.ACTION_COPY_OR_MOVE, this, true,null);

       /* Furniture f1 = new Furniture("Canapé", "Baroque", "Canapé baroque bleu",
                200, 200, false, new ImageIcon("./ressources/images/canapes/baroque_1.png"));
        cell.setFurniture(f1);*/

        //dropHandler = new DropHandler();
        //dropTarget = new DropTarget(this, DnDConstants.ACTION_COPY,dropHandler,true);
        //dragGestureHandler = new DragGestureHandler(this);
       // dragGestureRecognizer = DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY, dragGestureHandler);
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
        if(this.dropable)
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
        if(this.dropable)
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
        JPanel informationsMeubles = informationsMeubles();
        if(f != null) {
            try {
                Furniture clonedF = (Furniture)f.clone();
                ToolboxPanel.cellInfoPan.getCell().setFurniture(clonedF);
                ToolboxPanel.cellInfoPan.repaint();
                ToolboxPanel.cellInfoPan.add(pan);
                pan.setLayout(new BorderLayout());
                pan.add(informationsMeubles,BorderLayout.CENTER);
                this.setVisible(true);
            } catch (CloneNotSupportedException ex) {
                ex.printStackTrace();
            }

            backgroundColor = Color.BLUE;
            this.repaint();

        }

    }
    public JPanel informationsMeubles() {
        JPanel informations = new JPanel();
        informations.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        name = new JLabel(cell.getFurniture().getName());
        style = new JLabel(cell.getFurniture().getStyle());
        type = new JLabel(cell.getFurniture().getType());
        /*name = new JLabel("NAME");
        style = new JLabel("style");
        type = new JLabel("type");*/

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 0;
        informations.add(name, constraints);

        constraints.insets = new Insets(0,20,0,0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 0;
        informations.add(type, constraints);

        constraints.insets = new Insets(0,20,0,0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = 2;
        constraints.gridy = 0;
        informations.add(style, constraints);

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
