package view;

import model.Furniture;
import process.ToolboxHandler;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * \file ToolboxPanel.java
 * \brief Classe qui permet d afficher la boite à outils
 * \author CERINI Enzo, OBEYESEKARA Avishka, MANOUBI Farah, DENDOUNE Rayane, LEKMITI Mouncif, BENCHELKHA Salma
 * \version 1.0
 * \date 09/04/2021
 *
 * Classe contenant toutes les fonctions associées à l'affichage de la boite à outils
 *
 */
public class ToolboxPanel extends JPanel implements ActionListener {
    private JComboBox comboBoxMeuble = new JComboBox();
    private JComboBox comboBoxStyles = new JComboBox();
    private JButton valider = new JButton("Valider");
    public ToolboxHandler toolboxHandler = new ToolboxHandler();
    public static GridPanel gridPanel;
    public int nbCell = 0;
    private ArrayList<Furniture> emplacement = new ArrayList<Furniture>();
    private Image image;

    /**
     * \fn TooloboxPanel()
     * \brief Constructeur de TooloboxPanel
     */
    public ToolboxPanel() {
        super();
        JPanel mainPan = new JPanel();
        gridPanel = new GridPanel(1,6,false, false,130);
        gridPanel.setBackground(Color.BLACK);
        gridPanel.setPreferredSize(new Dimension(280,900));

        comboBoxStyles.setPreferredSize(new Dimension(150,40));
        comboBoxMeuble.setPreferredSize(new Dimension(150,40));

        comboBoxMeuble.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 22));
        comboBoxStyles.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 22));

        ((JLabel)comboBoxStyles.getRenderer()).setVerticalAlignment(SwingConstants.BOTTOM);
        ((JLabel)comboBoxMeuble.getRenderer()).setVerticalAlignment(SwingConstants.BOTTOM);

        valider.setPreferredSize(new Dimension(100, 40));
        valider.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 20));
        valider.setVerticalAlignment(SwingConstants.BOTTOM);
        valider.addActionListener(this);

        image = Toolkit.getDefaultToolkit().getImage("./ressources/images/autres/royal_texture_gauche.jpg");
        toolboxHandler.initComboBox(comboBoxStyles, comboBoxMeuble);

        this.add(this.getJpanelComboboxs());
        this.add(valider);
        this.add(gridPanel, BorderLayout.SOUTH);

        System.out.println(this.getSize().getWidth());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public JPanel getJpanelComboboxs(){
        JPanel jPanel = new JPanel();
        jPanel.add(comboBoxMeuble);
        jPanel.add(comboBoxStyles);
        return jPanel;
    }
    /**
     * \fn  GridPanel drawFurniture(String type, String style)
     * \brief Fonction qui permet de dessiner un meuble dans la ToolboxPanel
     * \param type correspond au type de meuble(Type String)
     * \param style correspond au style (Type String)
     * \return Retourne la grille avec le meuble dessiner
     */
    public GridPanel drawFurniture(String type, String style) throws IOException {
        ArrayList<Furniture> furnitures = toolboxHandler.initFurniture("./ressources/furnitures.csv");
        int nbElt = 0;
        gridPanel.getGridHandler().removeFurnitures();
        for(int i = 0; i<furnitures.size(); i++) {
            if(furnitures.get(i).getStyle().equals(style) && furnitures.get(i).getType().equals(type)) {
                gridPanel.getGridHandler().addFurniture(nbElt, furnitures.get(i));
                nbElt++;
            }
        }
        return gridPanel;
    }
    /**
     * \fn void actionPerformed(ActionEvent e)
     * \brief Fonction qui gère l'affichage dans la boite à outilsen fonction de l'action effectué
     * \param [in] e correspond aux évènements de l'utilisateur
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object Button = e.getSource();
        if (Button == valider) {
            try {
                gridPanel = drawFurniture((String) comboBoxMeuble.getSelectedItem(), (String) comboBoxStyles.getSelectedItem());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            gridPanel.revalidate();
            gridPanel.repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0,getWidth(),getHeight(), this);
    }

}
