package view;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;

public class Exemple extends  javax.swing.JFrame{

    /*DropTargetListener dropListener=new DropTargetListener() {
    public void dragEnter(DropTargetDragEvent dtde) { doDrag(dtde); }
    public void dragOver(DropTargetDragEvent dtde) { doDrag(dtde); }

    public void dropActionChanged(DropTargetDragEvent dtde) {
        doDrag(dtde);
    }
    public void dragExit(DropTargetEvent dte) {
    }

        @Override
        public void drop(DropTargetDropEvent dtde) {
            dtde.acceptDrop(dtde.getDropAction());
            String text;
            try {
                text=(String)dtde.getTransferable().
                        getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException e) {
                dtde.dropComplete(false);
                return;
            } catch (IOException e) {
                dtde.dropComplete(false);
                return;
            }
        }

        private void doTargetDrag(DropTargetDragEvent dtde) {
        if (dtde.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            int position=area.viewToModel(dtde.getLocation());
            area.setCaretPosition(position);
            area.getCaret().setVisible(true);
            dtde.acceptDrag(dtde.getDropAction());
        }
        else
            dtde.rejectDrag();
    }

        drop() {

        }
    };*/


}
