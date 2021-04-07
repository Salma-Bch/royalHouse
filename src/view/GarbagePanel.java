package view;

import model.Cell;

import model.Furniture;
import process.GridHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GarbagePanel extends JPanel implements ActionListener {

    private JButton poubelle = new JButton("Poubelle");
    private JPanel deleteZone = new JPanel();
    private Image image;
    private JButton button ;

    public JPanel garbagePanel;
    public GridPanel cellPan;

    public GarbagePanel(int width, int height) {
        super();
        this.setPreferredSize(new Dimension(width/6, height));
        this.setBorder(BorderFactory.createEmptyBorder(30,0,30,0));
        this.setBackground(new Color(227, 72, 181));

        //Sa c'est pour PNG
        ImageIcon icon = new ImageIcon("./ressources/images/SVGFiles/trash.png");
        ImageIcon icon2 = new ImageIcon(icon.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
        JLabel label = new JLabel(icon2, JLabel.CENTER);
        image = Toolkit.getDefaultToolkit().getImage("./ressources/images/autres/royal_texture.jpg");
        BufferedImage buttonIcon = null;
        try {
            buttonIcon = ImageIO.read(new File("./ressources/images/autres/rotation.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        button = new JButton(new ImageIcon(buttonIcon));

        this.add(button);

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
        cellPan = new GridPanel(1,1,true,true,150);
        //il faut que dragable soit impossible

        /*cellPan = new CellPanel(cell,200, true, false,false);*/
        cellPan.setPreferredSize(new Dimension(200,200));

        /*garbagePanel = new JPanel();
        garbagePanel.setLayout(new GridLayout(1,2));
        garbagePanel.add(cellPan);
        garbagePanel.add(new JPanel());*/


        /*GridPanel gridPanel = new GridPanel(1,1,true);
        gridPanel.setPreferredSize(new Dimension(150,150));
        gridPanel.add(label);*/

        /*Cell cell = new Cell(200,200,null);

        CellPanel cellPanel = new CellPanel(cell, 200, true, false);*/


        JPanel complete = buildPanel(poubelle, cellPan);

        this.add(complete);
    }

    public JPanel buildPanel(JButton trash, GridPanel panel) {
        JPanel grid = new JPanel();
        grid.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        grid.add(trash, c);

        c.insets = new Insets(430,0,0,0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;

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
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
