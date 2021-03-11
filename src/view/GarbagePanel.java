package view;

import javax.swing.*;
import java.awt.*;

public class GarbagePanel extends JPanel {

    public GarbagePanel(int width, int height) {
        super();
        this.setPreferredSize(new Dimension(width/6, height));
        this.setBorder(BorderFactory.createEmptyBorder(30,0,30,0));
        this.setBackground(new Color(227, 72, 181));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(5,500, 200, 155);
    }
}
