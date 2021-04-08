package view;

import model.Cell;
import process.GridHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.io.Serializable;

public class DragGestureHandler implements DragGestureListener, DragSourceListener, Serializable {
    private Container parent;
    private CellPanel child;

    public DragGestureHandler(CellPanel child){
        this.child = child;
    }

    public JPanel getPanel(){
        return child;
    }

    public void setParent(Container parent){
        this.parent = parent;
    }

    public Container getParent(){
        return this.parent;
    }
    @Override
    public void dragGestureRecognized(DragGestureEvent dge) {
        Container parent = getPanel().getParent();
        setParent(parent);
        Transferable transferable = new PanelTransferable(getPanel());

        DragSource ds = dge.getDragSource();

        ds.startDrag(dge, null,transferable, this);
        parent.invalidate();
        parent.repaint();
    }

    @Override
    public void dragEnter(DragSourceDragEvent dsde) {
    }

    @Override
    public void dragOver(DragSourceDragEvent dsde) {
    }

    @Override
    public void dropActionChanged(DragSourceDragEvent dsde) {
    }

    @Override
    public void dragExit(DragSourceEvent dse) {
    }

    @Override
    public void dragDropEnd(DragSourceDropEvent dsde) {
        if(!dsde.getDropSuccess()){
            if(((CellPanel)getPanel()).canThrow){
                ((CellPanel)getPanel()).getCell().setFurniture(null);
            }
            getParent().invalidate();
            getParent().repaint();
        }
    }
}

