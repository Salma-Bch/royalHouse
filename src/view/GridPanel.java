package view;

import model.Cell;
import model.Furniture;
import model.Grid;
import process.GridHandler;
import process.ToolboxHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GridPanel extends JPanel implements MouseListener {

    public GridHandler gridHandler;
    private final Grid grid;
    int height, width;

    //A supprimer
    //ToolboxHandler toolboxHandler = new ToolboxHandler();

    private DragGestureRecognizer dgr;
    private DragGestureHandler dragGestureHandler;

   // private DropTarget dropTarget;
    DropTarget dropTarget;
    DropHandler dropHandler;


    public GridPanel(int widthPan, int heightPan, int columnNumber, int rowNumber) {
        super();

        // FOR DRAG AND DROP
        dropHandler = new DropHandler();
        dropTarget = new DropTarget(this,DnDConstants.ACTION_COPY,dropHandler,true);
        dragGestureHandler = new DragGestureHandler(this);
        dgr = DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY, dragGestureHandler);


        //////////

        //this.setMinimumSize(new Dimension(200,200));
      /*  this.add(new JLabel("ggggbgtbrbfvfvggg"));
        this.add(new JLabel("ggggbgtbrbfvfvggg"));
        this.add(new JLabel("ggggbgtbrbfvfvggg"));*/
        this.setSize(widthPan, heightPan);

        gridHandler = new GridHandler(columnNumber,rowNumber);
        grid = gridHandler.getGrid();
        height = GridHandler.sizeCell * grid.getRowNumber();
        width = GridHandler.sizeCell * grid.getColumnNumber();

        this.addMouseListener(this);
    }

    @Override
    public void addNotify(){
        super.addNotify();

       /* if (dgr == null){
            dragGestureHandler = new DragGestureHandler(this);
            dgr = DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(this
            , DnDConstants.ACTION_COPY,dragGestureHandler);
        }*/
        dropHandler = new DropHandler();
        dropTarget = new DropTarget(this, DnDConstants.ACTION_COPY, dropHandler, true);

    }

    @Override
    public void removeNotify(){
       /* if (dgr != null){
            dgr.removeDragGestureListener(dragGestureHandler);
            dragGestureHandler = null;
        }
        dgr = null;*/
        super.removeNotify();
        dropTarget.removeDropTargetListener(dropHandler);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawCells(g);
        drawGridBorder(g, width,height, GridHandler.sizeCell);
    }

    private void drawFurniture(Graphics g, Cell cell, int cellSize, int position, int columnNumber){
        if(cell.getFurniture() != null){
            Image image = cell.getFurniture().getImage().getImage().getScaledInstance(cellSize,cellSize,Image.SCALE_DEFAULT);
            ImageIcon imageIcon = new ImageIcon(image);
            imageIcon.paintIcon(this, g, (((position-(columnNumber*(position/columnNumber)))))*cellSize,(position/columnNumber)*cellSize);
        }
    }


    public GridPanel drawF(int nbCell, Furniture furniture) {
        this.gridHandler.addFurniture(nbCell, furniture);
        return this;
    }



    private void drawGridBorder(Graphics g, int width , int height, int sizeCell) {
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

   public void drawCells(Graphics g){
       g.setColor(Color.GRAY);
       for (int i=0; i<grid.getCells().size(); i++){
           drawCell(g, i, GridHandler.sizeCell, grid.getColumnNumber());
       }
       g.setColor(Color.PINK);
       drawCell(g, gridHandler.getSelectedCell(), GridHandler.sizeCell, grid.getColumnNumber());
       for (int i=0; i<grid.getCells().size(); i++){
           drawFurniture(g,grid.getCells().get(i),GridHandler.sizeCell, i, grid.getColumnNumber());
       }
   }

   public void drawCell(Graphics g, int cellPos, int cellSize, int columnNumber){
       int y = cellPos/columnNumber;
       int px =  ( (cellPos-columnNumber*y+1) * cellSize) ;
       int py =  ( (y+1) * cellSize);
       g.fillRect(px -cellSize,py -cellSize,cellSize, cellSize );
   }

    public void mouseClicked(MouseEvent e) {
        if(e.getX()<width && e.getY()<height) {
            int x = e.getX() / GridHandler.sizeCell;
            int y = e.getY() / GridHandler.sizeCell;
            int position = grid.getColumnNumber() * y + x;
            gridHandler.setSelectedCell(position);
            this.repaint();
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

    public GridHandler getGridHandler() {
        return gridHandler;
    }

    public void setGridHandler(GridHandler gridHandler) {
        this.gridHandler = gridHandler;
    }
}
