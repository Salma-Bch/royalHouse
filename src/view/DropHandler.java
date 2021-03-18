package view;

import model.Furniture;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.io.Serializable;

public class DropHandler implements DropTargetListener, Serializable {
    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
        if (dtde.isDataFlavorSupported(PanelDataFlavor.SHARED_INSTANCE)) {

            dtde.acceptDrag(DnDConstants.ACTION_COPY);

        } else {

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
        // Basically, we want to unwrap the present...
        if (dtde.isDataFlavorSupported(PanelDataFlavor.SHARED_INSTANCE)) {
            Transferable transferable = dtde.getTransferable();
            try {
                Object data = transferable.getTransferData(PanelDataFlavor.SHARED_INSTANCE);
                if (data instanceof JPanel) {
                    CellPanel cellPanel = (CellPanel) data;
                    DropTargetContext dtc = dtde.getDropTargetContext();
                    Component component = dtc.getComponent();
                    if (component instanceof JComponent) {
                        Container parent = cellPanel.getParent();
                        if (parent != null) {
                            //parent.remove(panel);
                           // parent.revalidate();
                            //parent.repaint();
                        }

                        Furniture f = cellPanel.getCell().getFurniture();
                        Furniture clonedF = (Furniture) f.clone();
                        ((CellPanel) component).getCell().setFurniture(clonedF);
                        success = true;
                        dtde.acceptDrop(DnDConstants.ACTION_MOVE);
                        ((JComponent) component).invalidate();
                        ((JComponent) component).repaint();


                    } else {
                        success = false;
                        dtde.rejectDrop();
                    }
                } else {
                    success = false;
                    dtde.rejectDrop();
                }
            } catch (Exception exp) {
                success = false;
                dtde.rejectDrop();
                exp.printStackTrace();
            }
        } else {
            success = false;
            dtde.rejectDrop();
        }
        dtde.dropComplete(success);
    }
}
