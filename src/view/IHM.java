package view;

import java.awt.* ;
import javax.swing.* ;

public class IHM extends JFrame {

    public static void main(String[] args) {

        JPanel panel2, panel3, panel4;
        Toolbox panel1 = new Toolbox();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        GridPanel panel5 = new GridPanel();

        panel1.setPreferredSize(new Dimension(275, 600));
        panel1.setBorder(BorderFactory.createEmptyBorder(200,20,20,200));
        panel1.setBackground(new Color(203, 203, 203));
        panel2.setBackground(new Color(193, 56, 58));
        panel3.setBackground(new Color(193, 56, 58));
        panel4.setBackground(new Color(193, 56, 58));

        JFrame frame = new JFrame("Royal House") ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("./ressources/images/logo.png").getImage());
        frame.setSize(1200,600);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new java.awt.Color(90, 90, 90));

        frame.add(panel1,BorderLayout.WEST);
        frame.add(panel2, BorderLayout.EAST);
        frame.add(panel3, BorderLayout.NORTH);
        frame.add(panel4, BorderLayout.SOUTH);
        frame.add(panel5, BorderLayout.CENTER);
        frame.setVisible(true);
    }

}
