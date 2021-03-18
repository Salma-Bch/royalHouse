package view;

import model.Grid;
import process.GridHandler;
import javax.swing.*;
import java.awt.*;
import java.awt.dnd.*;
import java.util.ArrayList;

public class GridPanel extends JPanel  {

    private ArrayList<CellPanel> cellPanels;
    public GridHandler gridHandler;
    private final Grid grid;
    private boolean dropable;

    //A ENLEVER
    /*private DragGestureRecognizer dgr;
    private DragGestureHandler dragGestureHandler;
    DropTarget dropTarget;
    DropHandler dropHandler;*/
    ///////////

    public GridPanel( int columnNumber, int rowNumber, boolean dropable) {
        super();
        this.dropable = dropable;

        // FOR DRAG AND DROP A ENLEVER
      /*  dropHandler = new DropHandler();
        dropTarget = new DropTarget(this,DnDConstants.ACTION_COPY,dropHandler,true);
        //dragGestureHandler = new DragGestureHandler(this);
        dgr = DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY, dragGestureHandler);*/
        ///////////

        this.setLayout(new GridLayout(rowNumber, columnNumber));
        gridHandler = new GridHandler(columnNumber,rowNumber);
        grid = gridHandler.getGrid();
        cellPanels = initCellPanels();
    }

    public void reinitCellPanels(){
        for (CellPanel cellPanel : cellPanels) {
            cellPanel.setBackgroundColor(Color.GRAY);
        }
    }

    public ArrayList<CellPanel> initCellPanels(){
        ArrayList<CellPanel> cellPanels = new ArrayList<CellPanel>();
        int rows = grid.getRowNumber();
        int columns = grid.getColumnNumber();
        for(int i=0; i<rows*columns; i++){
            cellPanels.add(new CellPanel(grid.getCells().get(i),200, this.dropable));
            this.add(cellPanels.get(i));
        }
        return cellPanels;
    }

    //A ENLEVER
  /*  @Override
    public void addNotify(){
        super.addNotify();
       /* if (dgr == null){
            dragGestureHandler = new DragGestureHandler(this);
            dgr = DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(this
            , DnDConstants.ACTION_COPY,dragGestureHandler);
        }
        dropHandler = new DropHandler();
        dropTarget = new DropTarget(this, DnDConstants.ACTION_COPY, dropHandler, true);
    }

    @Override
    public void removeNotify(){
       /* if (dgr != null){
            dgr.removeDragGestureListener(dragGestureHandler);
            dragGestureHandler = null;
        }
        dgr = null;
        super.removeNotify();
        dropTarget.removeDropTargetListener(dropHandler);
    }*/
    ////////////////

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(int i=0; i<cellPanels.size(); i++){
            cellPanels.get(i).repaint();
        }
    }

    //A ENLEVER
    public GridHandler getGridHandler() {
        return gridHandler;
    }
    ////////////////
}
