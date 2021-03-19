package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GarbagePanel extends JPanel implements ActionListener {

    private JButton poubelle = new JButton("Poubelle");
    private JPanel deleteZone = new JPanel();


    public GarbagePanel(int width, int height) {
        super();
        this.setPreferredSize(new Dimension(width/6, height));
        this.setBorder(BorderFactory.createEmptyBorder(30,0,30,0));
        this.setBackground(new Color(227, 72, 181));

        //Sa c'est pour PNG
        ImageIcon icon = new ImageIcon("./ressources/images/SVGFiles/trash.png");
        ImageIcon icon2 = new ImageIcon(icon.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
        JLabel label = new JLabel(icon2, JLabel.CENTER);

        poubelle.addActionListener(this);

        GridPanel gridPanel = new GridPanel(1,1,false);
        gridPanel.setPreferredSize(new Dimension(150,150));
        gridPanel.add(label);

        JPanel complete = buildPanel(poubelle, gridPanel);

        this.add(complete);
    }

    public JPanel buildPanel(JButton trash, GridPanel gridPanel) {
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

        grid.add(gridPanel, c);
        grid.setBackground(new Color(227, 72, 181));

        return grid;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
