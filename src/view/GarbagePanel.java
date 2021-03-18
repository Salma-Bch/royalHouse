package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.InputStream;

import model.Cell;
//import org.apache.batik.swing.JSVGCanvas;
//import org.apache.batik.swing.svg.SVGDocumentLoader;

public class GarbagePanel extends JPanel implements ActionListener {

    private JButton poubelle = new JButton("Poubelle");
    //private JSVGCanvas svgCanvas = new JSVGCanvas(null,true,false);
    private JPanel deleteZone = new JPanel();


    public GarbagePanel(int width, int height) {
        super();
        this.setPreferredSize(new Dimension(width/6, height));
        this.setBorder(BorderFactory.createEmptyBorder(30,0,30,0));
        this.setBackground(new Color(227, 72, 181));


        /*svgCanvas.setURI(new File("./ressources/images/SVGFiles/trash.svg").toURI().toString());
        String imageString = g2.getSVGElement();


        svgCanvas.setURI( this.getClass().getResource("./ressources/images/SVGFiles/trash.svg").toString());

        InputStream svgFile = getClass().getResourceAsStream("./ressources/images/SVGFiles/trash.svg");
        SvgLoader loader = new SvgLoader();

        this.add("Center", svgCanvas);*/
        //this.add(svgCanvas);

        //Sa c'est pour PNG
        ImageIcon icon = new ImageIcon("./ressources/images/SVGFiles/trash.png");
        ImageIcon icon2 = new ImageIcon(icon.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
        JLabel label = new JLabel(icon2, JLabel.CENTER);
        /*label.setHorizontalAlignment(10);
        label.setVerticalAlignment(20);
        label.setBounds(5,460, 25,25);
        label.setLocation(new Point(5,460));
        this.add(label);*/

        poubelle.addActionListener(this);


        //this.add(poubelle);



        GridPanel gridPanel = new GridPanel(1,1,false);
        gridPanel.setPreferredSize(new Dimension(150,150));
        gridPanel.add(label);


        JPanel complete = buildPanel(poubelle, gridPanel);

        //this.add(gridPanel);
        //this.add(poubelle);
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
