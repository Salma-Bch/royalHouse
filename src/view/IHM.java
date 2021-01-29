package view;

import java.awt.* ;
import javax.swing.* ;

public class IHM extends JFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Royal House") ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("./ressources/images/logo.png").getImage());
        frame.setSize(1000,600);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new java.awt.Color(90, 90, 90));

        JPanel toolbox = new JPanel();
        toolbox.setSize(100,100);
        toolbox.setBackground(new Color(193, 37, 192));
        toolbox.setVisible(false);

        frame.getContentPane().add(toolbox) ;
        frame.setVisible(true);
    }


}
