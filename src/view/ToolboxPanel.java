package view;

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
    private JButton ajouter = new JButton("Ajouter");
    public ToolboxHandler toolboxHandler = new ToolboxHandler();
    public GridPanel gridPanel;
    public int nbCell = 0;


    private ArrayList<Furniture> emplacement = new ArrayList<Furniture>();

    public ToolboxPanel() {
        super();
        this.setBackground(Color.BLUE);
        JPanel mainPan = new JPanel();
        //ToolboxHandler toolboxHandler = new ToolboxHandler();
        toolboxHandler.initComboBox(comboBoxStyles, comboBoxMeuble);
        gridPanel = new GridPanel(6,6);
        gridPanel.setBackground(Color.BLACK);
        valider.addActionListener(this);
        ajouter.addActionListener(this);

        this.add(this.getJpanelComboboxs());
        this.add(valider);
        this.add(ajouter);
        this.add(gridPanel, BorderLayout.CENTER);
        System.out.println(this.getSize().getWidth());
        gridPanel.setPreferredSize(new Dimension(250,600));


        //gridPanel = drawFurniture("Canape", "Baroque");

        //this.setSize(300,200);
        //this.setLayout(new BorderLayout());
        // build();
    }
    public void build(){
        //this.setSize(600, 600);
        //GridPanel gridPanel = new GridPanel(600,600,5,5);
        //ToolboxHandler toolboxHandler = new ToolboxHandler(4,4);
       // toolboxHandler.initComboBox(comboBoxMeuble,comboBoxStyles);

        /*JPanel grid = new JPanel();
        grid.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        grid.add(this.getJpanelComboboxs(), c);

        c.insets = new Insets(20,0,0,0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        grid.add(gridPanel, c);

        this.setSize(new Dimension(600,600));
        this.add(grid);*/
        //this.setLayout(new BorderLayout());
        this.setBackground(Color.BLUE);
        this.setSize(300,200);
       // this.add(this.getJpanelComboboxs(), BorderLayout.NORTH);
        //this.add(gridPanel, BorderLayout.CENTER);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public JPanel getJpanelComboboxs(){
        JPanel jPanel = new JPanel();
        //jPanel.setBackground(Color.BLUE);
        jPanel.add(comboBoxMeuble);
        jPanel.add(comboBoxStyles);
        return jPanel;
    }

    public GridPanel drawFurniture(String type, String style) throws IOException {
        ArrayList<Furniture> furnitures = toolboxHandler.initFurniture("./ressources/furnitures.csv");

            emplacement = new ArrayList<Furniture>();

        int nbElt = 0;
        gridPanel.getGridHandler().removeFurnitures();
        for(int i = 0; i<furnitures.size(); i++) {
            if(furnitures.get(i).getStyle().equals(style) && furnitures.get(i).getType().equals(type)) {

                gridPanel.getGridHandler().addFurniture(nbElt, furnitures.get(i));
                emplacement.add(furnitures.get(i));
                nbElt++;
            }
        }

        return gridPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Button = e.getSource();
        if (Button == valider) {
            //gridPanel = drawFurniture("Canape", "Baroque");

            try {
                gridPanel = drawFurniture((String) comboBoxMeuble.getSelectedItem(), (String) comboBoxStyles.getSelectedItem());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            gridPanel.revalidate();
            gridPanel.repaint();

            //System.out.println((String)comboBoxMeuble.getSelectedItem());
            //System.out.println((String)comboBoxStyles.getSelectedItem());        }
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
    }
}
