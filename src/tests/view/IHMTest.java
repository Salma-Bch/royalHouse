package tests.view;

import org.junit.Test;
import view.GridPanel;
import view.ToolboxPanel;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class IHMTest {

    @Test
    public void initToolboxPan() {
        Dimension dimension;
        int height;
        int width;
        ToolboxPanel toolboxPan = new ToolboxPanel();
        dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        height = (int)dimension.getHeight();
        width  = (int)dimension.getWidth();
        toolboxPan.setPreferredSize(new Dimension(width/4, height));
        toolboxPan.setBorder(BorderFactory.createEmptyBorder(30,0,30,0));
        assertNotNull(toolboxPan);

    }

    @Test
    public void initGridPan() {
        Dimension dimension;
        int height;
        int width;
        GridPanel gridPan = new GridPanel(5,4,true,false, 20);
        dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        height = (int)dimension.getHeight();
        width  = (int)dimension.getWidth();
        gridPan.setPreferredSize(new Dimension(width*7/12, height));
        assertNotNull(gridPan);
    }
}