package view;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
/**
 * \file PanelTransferable.java
 * \brief Classe qui permet de gérer le transfert d'un objet vers le panel
 * \author CERINI Enzo, OBEYESEKARA Avishka, MANOUBI Farah, DENDOUNE Rayane, LEKMITI Mouncif, BENCHELKHA Salma
 * \version 1.0
 * \date 09/04/2021
 *
 * Classe contenant toutes les fonctions associées au transfert d'un objet vers le panel
 *
 */

public class PanelTransferable implements Transferable {
    private DataFlavor[] flavors = new DataFlavor[]{PanelDataFlavor.SHARED_INSTANCE};
    private JPanel panel;

    public PanelTransferable(JPanel panel){
        this.panel = panel;
    }
    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return flavors;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        boolean supported = false;
        for(DataFlavor mine : getTransferDataFlavors()){
            if(mine.equals(flavor)){
                supported = true;
                break;
            }
        }
        return supported;
    }

    public JPanel getPanel(){
        return panel;
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        Object data = null;
        if(isDataFlavorSupported(flavor)){
            data = getPanel();
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
        return data;
    }
}
