package view;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;

/**
 * \file PanelDataFlavor.java
 * \brief Classe qui est utile pour le système de "drag and drop".
 * \author BENCHELKA Salma, LEKMITI Mouncif, MANOUBI Farah, OBEYESEKARA Avishka, CERINI Enzo, DENDOUNE Rayane
 * \version 1.0
 * \date 09/04/2021
 */

public class PanelDataFlavor extends DataFlavor {

    public static final PanelDataFlavor SHARED_INSTANCE = new PanelDataFlavor();

    public PanelDataFlavor(){
        super(JPanel.class, null);
    }
}
