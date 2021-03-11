package view;

import javax.swing.*;
import java.awt.*;

public class GarbagePanel extends JPanel {
    private Image image;


    public GarbagePanel(int width, int height) {

        super();
        this.setPreferredSize(new Dimension(width/6, height));
        this.setBorder(BorderFactory.createEmptyBorder(30,0,30,0));
        image = Toolkit.getDefaultToolkit().getImage("./ressources/images/royal_texture.jpg");

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(5,500, 200, 155);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
