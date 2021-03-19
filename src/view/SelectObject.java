/*package view;

import model.BoiteOutil;
import model.Mobilier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class SelectObject extends JFrame implements MouseListener {
    int position = 0;
    private BoiteOutil bo = new BoiteOutil();
    public SelectObject(String title){
        super(title);
        this.addMouseListener(this);
    }
    public static void main(String[] args) {

        BoiteOutil boiteOutil =  new BoiteOutil() ;
        ArrayList<Mobilier[]> mobilier = new ArrayList();
        //   mobilier.add(new Mobilier("Canapé", "Baroque", "Canapé baroque blanc", 200, 200, false, "./ressources/images/canapeVuDenFace.png"));
        //  mobilier.add(new Mobilier("Table", "Classique", "Table classique en bois", 200, 200, false, "./ressources/images/tableVuDenFace.png"));
        JPanel panel2, panel3, panel4, panel5;
        Toolbox panel1 = new Toolbox();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        GridPanel gridPanel = new GridPanel();

        panel1.setPreferredSize(new Dimension(275, 600));
        panel1.setBorder(BorderFactory.createEmptyBorder(200,20,20,200));
        panel1.setBackground(new Color(203, 203, 203));
        panel2.setBackground(new Color(193, 56, 58));
        panel3.setBackground(new Color(193, 56, 58));
        panel4.setBackground(new Color(193, 56, 58));
        //panel5.setBackground(new Color(222, 222, 222));

        JFrame frame = new SelectObject("Royal House") ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("./ressources/images/logo.png").getImage());
        frame.setSize(1000,600);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new java.awt.Color(90, 90, 90));

        frame.add(panel1,BorderLayout.WEST);
        frame.add(panel2, BorderLayout.EAST);
        frame.add(panel3, BorderLayout.NORTH);
        frame.add(panel4, BorderLayout.SOUTH);
        frame.add(gridPanel, BorderLayout.CENTER);
        frame.setVisible(true);


    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX()/50;
        int y = e.getY()/50;
        position = y*12 + x;
        System.out.println(position);

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}*/
