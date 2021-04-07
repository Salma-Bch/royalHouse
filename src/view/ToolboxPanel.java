package view;

import model.Cell;
import model.Furniture;
import process.ToolboxHandler;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ToolboxPanel extends JPanel implements ActionListener {
    private JComboBox comboBoxMeuble = new JComboBox();
    private JComboBox comboBoxStyles = new JComboBox();
    private JButton valider = new JButton("Valider");
    public ToolboxHandler toolboxHandler = new ToolboxHandler();
    public GridPanel gridPanel;
    public static JPanel infoPanel;
    public static CellPanel cellInfoPan;
    public int nbCell = 0;
    private ArrayList<Furniture> emplacement = new ArrayList<Furniture>();
    private Image image;

    public ToolboxPanel() {
        super();
        JPanel mainPan = new JPanel();
        gridPanel = new GridPanel(1,6,false, false,130);
        cellInfoPan = new CellPanel(new Cell(600,600,null),200, false, false,false);

        image = Toolkit.getDefaultToolkit().getImage("./ressources/images/autres/royal_texture.jpg");
        toolboxHandler.initComboBox(comboBoxStyles, comboBoxMeuble);
        gridPanel.setBackground(Color.BLACK);
        valider.addActionListener(this);

        this.add(this.getJpanelComboboxs());
        this.add(valider);
        infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(1,2));
        infoPanel.add(cellInfoPan);
        infoPanel.add(new JPanel());
        System.out.println(this.getSize().getWidth());
        gridPanel.setPreferredSize(new Dimension(200,700));
        this.add(gridPanel, BorderLayout.CENTER);
      //  this.add(infoPanel, BorderLayout.SOUTH);
      //  infoPanel.setPreferredSize(new Dimension(400,200));
      //  cellInfoPan.setPreferredSize(new Dimension(200,200));
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
        /*if(Button == ajouter){
            if(nbCell<49 && IHM.toolboxPan.gridPanel.gridHandler.getSelectedCell() <emplacement.size()) {
                //ArrayList<Furniture> furnitures = toolboxHandler.initFurniture();
                IHM.gridPan.drawF(nbCell, emplacement.get(IHM.toolboxPan.gridPanel.gridHandler.getSelectedCell()));
                IHM.toolboxPan.gridPanel.gridHandler.setSelectedCell(-1);
                IHM.gridPan.repaint();
                nbCell++;

                //System.out.println(IHM.toolboxPan.gridPanel.gridHandler.getSelectedCell());
            }
        }*/

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

}
