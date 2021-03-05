package view;

import java.awt.* ;
import java.io.Serializable;
import javax.swing.* ;

public class IHM extends JFrame implements Serializable {
    public static ToolboxPanel toolboxPan;
    public static GridPanel gridPan;
    private JPanel buttonPan = new JPanel();

    public IHM(){
        toolboxPan = initToolboxPan();
        gridPan = initGridPan();

        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int)dimension.getHeight();
        int width  = (int)dimension.getWidth();
        buttonPan.setPreferredSize(new Dimension(width/6, height));
        buttonPan.setBorder(BorderFactory.createEmptyBorder(30,0,30,0));
        buttonPan.setBackground(new Color(227, 72, 181));

        JFrame frame = new JFrame("Royal House") ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("./ressources/images/logo.png").getImage());
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.add(toolboxPan,BorderLayout.WEST);
        frame.add(gridPan, BorderLayout.CENTER);
        frame.add(buttonPan, BorderLayout.EAST) ;
        frame.setVisible(true);
    }

    public ToolboxPanel initToolboxPan(){
        ToolboxPanel toolboxPan = new ToolboxPanel();
        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int)dimension.getHeight();
        int width  = (int)dimension.getWidth();
        toolboxPan.setPreferredSize(new Dimension(width/4, height));
        toolboxPan.setBorder(BorderFactory.createEmptyBorder(30,0,30,0));
        toolboxPan.setBackground(new Color(227, 195, 106));
        return toolboxPan;
    }

    public GridPanel initGridPan(){
        GridPanel gridPan = new GridPanel(5,4);
        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int)dimension.getHeight();
        int width  = (int)dimension.getWidth();
        gridPan.setPreferredSize(new Dimension(width*7/12, height));
        return gridPan;
    }

    public static void main(String[] args) {
        new IHM();
    }
}
