package view;

import java.awt.* ;
import java.io.Serializable;
import javax.swing.* ;

public class IHM extends JFrame implements Serializable {
    public static ToolboxPanel toolboxPan;
    public static GridPanel gridPan;
    private JPanel buttonPan;
    private Dimension dimension ;
    private int height;
    private int width;
    private Image image ;

    public IHM(){
        toolboxPan = initToolboxPan();
        gridPan = initGridPan();

        dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        height = (int)dimension.getHeight();
        width  = (int)dimension.getWidth();

        buttonPan = new GarbagePanel(width, height);

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
        dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        height = (int)dimension.getHeight();
        width  = (int)dimension.getWidth();
        toolboxPan.setPreferredSize(new Dimension(width/4, height));
        toolboxPan.setBorder(BorderFactory.createEmptyBorder(30,0,30,0));
        return toolboxPan;
    }

    public GridPanel initGridPan(){
        GridPanel gridPan = new GridPanel(5,4,true);
        dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        height = (int)dimension.getHeight();
        width  = (int)dimension.getWidth();
        gridPan.setPreferredSize(new Dimension(width*7/12, height));
        return gridPan;
    }

    public static void main(String[] args) {
        new IHM();
    }
}
