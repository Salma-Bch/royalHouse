package view;

import model.Cell;
import model.Furniture;
import model.Grid;
import process.GridHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GridPanel extends JPanel implements MouseListener, DropTargetListener {

    public GridHandler gridHandler;
    private final Grid grid;
    int height, width;

    private DragGestureRecognizer dgr;
    private DragGestureHandler dragGestureHandler;

   // private DropTarget dropTarget;


    public GridPanel(int widthPan, int heightPan, int columnNumber, int rowNumber) {
        super();

        // FOR DRAG AND DROP



        //////////

        //this.setMinimumSize(new Dimension(200,200));
      /*  this.add(new JLabel("ggggbgtbrbfvfvggg"));
        this.add(new JLabel("ggggbgtbrbfvfvggg"));
        this.add(new JLabel("ggggbgtbrbfvfvggg"));*/
        this.setSize(widthPan, heightPan);
        JTextField jTextField = new JTextField();
        jTextField.setText("Source hhhhhhhhhhh");
        jTextField.setDragEnabled(true);
        JTextField jt = new JTextField();
        jt.setText("Destination ddddddddddddddddd");
        jt.setDropMode(DropMode.INSERT);
        //this.setDropTarget(jt);
        this.add(jTextField);
        this.add(jt);
        this.setTransferHandler(new TransferHandler("texte"));
        gridHandler = new GridHandler(columnNumber,rowNumber);
        grid = gridHandler.getGrid();
        height = GridHandler.sizeCell * grid.getRowNumber();
        width = GridHandler.sizeCell * grid.getColumnNumber();

        this.addMouseListener(this);
    }

    @Override
    public void addNotify(){
        super.addNotify();

        if (dgr == null){
            dragGestureHandler = new DragGestureHandler(this);
            dgr = DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(this
            , DnDConstants.ACTION_MOVE,dragGestureHandler);
        }
    }

    @Override
    public void removeNotify(){
        if (dgr != null){
            dgr.removeDragGestureListener(dragGestureHandler);
            dragGestureHandler = null;
        }
        dgr = null;
        super.removeNotify();
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

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
        if(dtde.isDataFlavorSupported(PanelDataFlavor.SHARED_INSTANCE)){
            dtde.acceptDrag(DnDConstants.ACTION_MOVE);
        }
        else {
            dtde.rejectDrag();
        }
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {

    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {

    }

    @Override
    public void dragExit(DropTargetEvent dte) {

    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
        boolean success = false;
        if(dtde.isDataFlavorSupported(PanelDataFlavor.SHARED_INSTANCE)){
            Transferable transferable = dtde.getTransferable();
            try {
                Object data = transferable.getTransferData(PanelDataFlavor.SHARED_INSTANCE);
                if (data instanceof JPanel){
                    JPanel panel = (JPanel) data;
                    DropTargetContext dtc = dtde.getDropTargetContext();
                    Component component = dtc.getComponent();
                    if(component instanceof JComponent){
                        Container parent = panel.getParent();
                        if(parent != null){
                            parent.remove(panel);
                        }
                        ((JComponent)component).add(panel);
                        success = true;
                        dtde.acceptDrop(DnDConstants.ACTION_MOVE);
                        invalidate();
                        repaint();
                    }
                    else {
                        success = false;
                        dtde.rejectDrop();
                    }
                }
                else {
                    success = false;
                    dtde.rejectDrop();
                }
            } catch (Exception e){
                success = false;
                dtde.rejectDrop();
                e.printStackTrace();
            }
        }
        else {
            success = false;
            dtde.rejectDrop();
        }
        dtde.dropComplete(success);
    }
}
