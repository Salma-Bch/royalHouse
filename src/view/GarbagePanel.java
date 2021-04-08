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

    private JButton poubelle = new JButton("Poubelle");
    private JPanel deleteZone = new JPanel();
    private Image image;
    private JButton button ;
    private JPanel modifMeuble = new JPanel();
    private JComboBox<String> color;// = new JComboBox<String>();
    private JComboBox<String> style = new JComboBox<String>();
    private JComboBox<String> type = new JComboBox<String>();
    private JButton valider = new JButton("Valider");
    private JButton modifier = new JButton("Modifier");
    JLabel phrase1 = new JLabel("Modification esthétique");
    JLabel phrase2 = new JLabel("Et en quelle couleur ?");
    private boolean alreadyDone = false;
    public JPanel garbagePanel;
    public GridPanel cellPan;
    public static JPanel infoPanel;
    public static CellPanel cellInfoPan;

    public GarbagePanel(int width, int height) {
        super();
        this.setPreferredSize(new Dimension(width/6, height));
        this.setBorder(BorderFactory.createEmptyBorder(30,0,30,0));
        cellInfoPan = new CellPanel(new Cell(600,600,null),200, false, false,false);

        //Sa c'est pour PNG
        ImageIcon icon = new ImageIcon("./ressources/images/SVGFiles/trash.png");
        ImageIcon icon2 = new ImageIcon(icon.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));

        image = Toolkit.getDefaultToolkit().getImage("./ressources/images/autres/royal_texture.jpg");
        BufferedImage buttonIcon = null;
        try {
            buttonIcon = ImageIO.read(new File("./ressources/images/autres/rotation.png"));
            button = new JButton(new ImageIcon(buttonIcon));
            button.setPreferredSize(new Dimension(130, 130));
        } catch (IOException e) {
            e.printStackTrace();
        }



        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(GridHandler.selectedCellPanel != null) {
                    GridHandler.selectedCellPanel.getCell().getFurniture().incrementeOrientation();
                    GridHandler.selectedCellPanel.repaint();
                }
            }
        });

        poubelle.addActionListener(this);

        Cell cell = new Cell(200,200,null);
        cellPan = new GridPanel(1,1,true,true,200);

        //il faut que dragable soit impossible

        /*cellPan = new CellPanel(cell,200, true, false,false);*/
        cellPan.setPreferredSize(new Dimension(200,200));


        valider.addActionListener(this);
        modifier.addActionListener(this);

        (new ToolboxHandler()).initComboBox(style, type);
        JLabel phrase = new JLabel("Question : ");
        modifMeuble.add(phrase1);
        modifMeuble.add(style);
        modifMeuble.add(type);
        modifMeuble.add(valider);

        style.setPreferredSize(new Dimension(150,40));
        type.setPreferredSize(new Dimension(150,40));

        style.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 22));
        type.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 22));

        ((JLabel)style.getRenderer()).setVerticalAlignment(SwingConstants.BOTTOM);
        ((JLabel)type.getRenderer()).setVerticalAlignment(SwingConstants.BOTTOM);

        valider.setPreferredSize(new Dimension(100, 40));
        valider.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 20));
        valider.setVerticalAlignment(SwingConstants.BOTTOM);
        valider.addActionListener(this);

        modifMeuble.setPreferredSize(new Dimension(200,200));


        infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(1,2));
        infoPanel.add(cellInfoPan);
        infoPanel.add(new JPanel());

        this.add(infoPanel, BorderLayout.SOUTH);
        infoPanel.setPreferredSize(new Dimension(400,200));
        cellInfoPan.setPreferredSize(new Dimension(200,200));

        JPanel complete = buildPanel(poubelle, cellPan, modifMeuble);

        this.add(button);
        this.add(complete);
    }

    public JPanel buildPanel(JButton trash, GridPanel panel, JPanel modifMeuble) {
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

        c.insets = new Insets(10,0,0,0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        grid.add(panel, c);

        return grid;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object Button = e.getSource();
        if (Button == poubelle) {
            //cellPan.getCell().setFurniture(null);
            cellPan.getGridHandler().getGrid().getCells().get(0).setFurniture(null);
            //getParent().add(cellPan.getCell());
            //getParent().invalidate();
            //getParent().repaint();
            repaint();
        }

        if(Button == valider) {
            try {
                //color = new JComboBox<String>();
                color = couleurMeuble((String)type.getSelectedItem(), (String)style.getSelectedItem());
                if(!alreadyDone) {
                    modifMeuble.add(phrase2);
                    modifMeuble.add(color);
                    modifMeuble.add(modifier);
                    alreadyDone = true;
                }
                else {
                    modifMeuble.remove(5);
                    modifMeuble.remove(5);
                    modifMeuble.add(color);
                    modifMeuble.add(modifier);
                }

                //modifMeuble.repaint();
                modifMeuble.revalidate();
            } catch (IOException ex) {
                ex.printStackTrace();
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
            if (furnitures.get(i).getStyle().equals(style) && furnitures.get(i).getType().equals(type)) {
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
