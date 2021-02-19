package view;

import java.awt.* ;
import javax.swing.* ;

public class IHM extends JFrame {
    private ToolboxPanel toolboxPan;
    private GridPanel gridPan;

    public IHM(){
        toolboxPan = initToolboxPan();
        gridPan = initGridPan();

        JFrame frame = new JFrame("Royal House") ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("./ressources/images/logo.png").getImage());
        frame.setSize(1200,600);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new java.awt.Color(90, 90, 90));

        frame.add(toolboxPan,BorderLayout.WEST);
        frame.add(gridPan, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public ToolboxPanel initToolboxPan(){
        ToolboxPanel toolboxPan = new ToolboxPanel();
        toolboxPan.setPreferredSize(new Dimension(275, 600));
        toolboxPan.setBorder(BorderFactory.createEmptyBorder(20,170,20,200));
        //toolboxPan.setBackground(new Color(203, 203, 203));
        return toolboxPan;
    }

    public GridPanel initGridPan(){
        GridPanel gridPan = new GridPanel(600,600,6,8);
        gridPan.add(new JLabel("ttgtttt"));
        gridPan.setBackground(new Color(189, 189, 189));
        return gridPan;
    }
    public static void main(String[] args) {
        new IHM();
    }

}
