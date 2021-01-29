package view;

import java.awt.* ;
import javax.swing.* ;

public class IHM extends JFrame {

    public static void main(String[] args) {

        JPanel panel1, panel2, panel3, panel4, panel5;
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        GridPanel gridPanel = new GridPanel();

        panel1.setBackground(new Color(193, 56, 58));
        panel2.setBackground(new Color(193, 56, 58));
        panel3.setBackground(new Color(193, 56, 58));
        panel4.setBackground(new Color(193, 56, 58));

        JFrame frame = new JFrame("Royal House") ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("./ressources/images/logo.png").getImage());
        frame.setSize(1000,600);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new java.awt.Color(90, 90, 90));

        JPanel toolbox = new JPanel();
        toolbox.setSize(100,100);
        toolbox.setBackground(new Color(193, 37, 192));
        toolbox.setLayout(new FlowLayout());
        toolbox.setVisible(false);

        frame.getContentPane().add(toolbox) ;
        frame.add(panel1,BorderLayout.WEST);
        frame.add(panel2, BorderLayout.EAST);
        frame.add(panel3, BorderLayout.NORTH);
        frame.add(panel4, BorderLayout.SOUTH);
        frame.add(gridPanel, BorderLayout.CENTER);
        frame.setVisible(true);

    }


}
