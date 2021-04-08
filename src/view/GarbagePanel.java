package view;

import model.Cell;
import model.Furniture;
import process.GridHandler;
import process.ToolboxHandler;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GarbagePanel extends JPanel implements ActionListener {

    private JButton poubelle ;
    private JButton rotation ;
    private JButton valider = new JButton("Valider");
    private JButton modifier = new JButton("Modifier");

    private Image image;

    private JComboBox<String> color;
    private JComboBox<String> style = new JComboBox<String>();
    private JComboBox<String> type = new JComboBox<String>();

    private JLabel phrase1 = new JLabel("Modification esthétique");
    private JLabel phrase2 = new JLabel("Et en quelle couleur ?");

    public GridPanel cellPan;
    private JPanel modifMeuble = new JPanel();

    public static JPanel infoPanel;
    public static CellPanel cellInfoPan;
    private boolean alreadyDone = false;

    public GarbagePanel(int width, int height) {
        super();
        this.setPreferredSize(new Dimension(width/4, height));
        this.setBorder(BorderFactory.createEmptyBorder(30,0,30,0));

        cellInfoPan = new CellPanel(new Cell(600,600,null),200, false, false,false);
        image = Toolkit.getDefaultToolkit().getImage("./ressources/images/autres/royal_texture.jpg");
        BufferedImage rotationIcon = null;
        BufferedImage poubelleIcon = null;

        try {
            rotationIcon = ImageIO.read(new File("./ressources/images/autres/rotation.png"));
            poubelleIcon = ImageIO.read(new File("./ressources/images/autres/trash.png"));

            rotation = new JButton(new ImageIcon(rotationIcon));
            poubelle = new JButton(new ImageIcon(poubelleIcon));

            rotation.setPreferredSize(new Dimension(140, 140));
            poubelle.setPreferredSize(new Dimension(140, 140));
            rotation.putClientProperty("Synthetica.opaque",Boolean.TRUE);
            rotation.setBackground(Color.WHITE);

            rotation.setForeground(Color.WHITE);

        } catch (IOException e) {
            e.printStackTrace();
        }

        rotation.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(GridHandler.selectedCellPanel != null) {
                    GridHandler.selectedCellPanel.getCell().getFurniture().incrementeOrientation();
                    GridHandler.selectedCellPanel.repaint();
                }
            }
        });

        cellPan = new GridPanel(1,1,true,true,200);

        poubelle.addActionListener(this);
        valider.addActionListener(this);
        modifier.addActionListener(this);

        new ToolboxHandler().initComboBox(style,type);
        modifMeuble.add(phrase1);
        modifMeuble.add(type);
        modifMeuble.add(style);
        modifMeuble.add(valider);

        style.setPreferredSize(new Dimension(150,40));
        type.setPreferredSize(new Dimension(150,40));

        style.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 22));
        type.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 22));

        ((JLabel)style.getRenderer()).setVerticalAlignment(SwingConstants.BOTTOM);
        ((JLabel)type.getRenderer()).setVerticalAlignment(SwingConstants.BOTTOM);

        phrase1.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 22));
        phrase2.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 22));

        valider.setPreferredSize(new Dimension(305, 40));
        valider.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 20));
        valider.setVerticalAlignment(SwingConstants.BOTTOM);
        valider.addActionListener(this);

        modifier.setPreferredSize(new Dimension(305, 40));
        modifier.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 20));
        modifier.setVerticalAlignment(SwingConstants.BOTTOM);
        modifier.addActionListener(this);

        modifMeuble.setPreferredSize(new Dimension(350,350));

        infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(2,1));
        infoPanel.add(cellInfoPan);
        infoPanel.add(new JPanel());

        this.add(infoPanel, BorderLayout.NORTH);
        infoPanel.setPreferredSize(new Dimension(350,350));

        JPanel complete = buildPanel(poubelle, modifMeuble);
        this.add(rotation);
        this.add(poubelle);
        this.add(complete);
    }

    public JPanel buildPanel(JButton trash, JPanel modifMeuble) {
        JPanel grid = new JPanel();
        grid.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(75,0,0,0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        grid.add(trash, c);

        c.insets = new Insets(30,0,0,0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        grid.add(modifMeuble, c);

        return grid;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Button = e.getSource();
        CellPanel selectedCellPanel = IHM.gridPan.gridHandler.selectedCellPanel;
        if(selectedCellPanel != null) {
            Furniture f = selectedCellPanel.getCell().getFurniture();
            if (Button == poubelle && f != null) {
                IHM.gridPan.gridHandler.selectedCellPanel.getCell().setFurniture(null);
                ToolboxPanel.gridPanel.reinitCellPanels();
                ToolboxPanel.gridPanel.revalidate();
                ToolboxPanel.gridPanel.repaint();
                IHM.gridPan.reinitCellPanels();
                IHM.gridPan.revalidate();
                IHM.gridPan.repaint();
            }

            if (Button == valider) {
                try {
                    color = couleurMeuble((String) type.getSelectedItem(), (String) style.getSelectedItem());
                    color.setPreferredSize(new Dimension(150,40));
                    color.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 22));
                    ((JLabel)color.getRenderer()).setVerticalAlignment(SwingConstants.BOTTOM);

                    if (!alreadyDone) {
                        modifMeuble.add(phrase2);
                        modifMeuble.add(color);
                        modifMeuble.add(modifier);
                        alreadyDone = true;
                    } else {
                        modifMeuble.remove(5);
                        modifMeuble.remove(5);
                        modifMeuble.add(color);
                        modifMeuble.add(modifier);
                    }
                    modifMeuble.revalidate();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        if(Button == modifier) {
            try {
                ArrayList<Furniture> furnitures = (new ToolboxHandler()).initFurniture("./ressources/furnitures.csv");
                for(int i = 0; i<furnitures.size(); i++) {
                    if(furnitures.get(i).getType().equals((String)type.getSelectedItem()) && furnitures.get(i).getStyle().equals((String)style.getSelectedItem()) && furnitures.get(i).getColor().equals(color.getSelectedItem())) {
                        Furniture furniture = new Furniture(furnitures.get(i).getType(), furnitures.get(i).getStyle(), furnitures.get(i).getColor(), 200,200, furnitures.get(i).getImage());
                        if(GridHandler.selectedCellPanel != null)
                            GridHandler.selectedCellPanel.getCell().setFurniture(furniture);
                    }
                }
                if(GridHandler.selectedCellPanel != null) {
                    GridHandler.selectedCellPanel.repaint();
                    GridHandler.selectedCellPanel.revalidate();
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    public JComboBox couleurMeuble(String type, String style) throws IOException {
        ArrayList<Furniture> furnitures = (new ToolboxHandler()).initFurniture("./ressources/furnitures.csv");
        JComboBox<String> color = new JComboBox<String>();

        for(int i = 0; i<furnitures.size(); i++) {
            if (furnitures.get(i).getType().equals(type) && furnitures.get(i).getStyle().equals(style)) {
                color.addItem(furnitures.get(i).getColor());
            }
        }
        return color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
