package view;

import process.ToolboxHandler;
import javax.swing.*;
import java.awt.*;

public class ToolboxPanel extends JPanel {
    private JComboBox comboBoxMeuble = new JComboBox();
    private JComboBox comboBoxStyles = new JComboBox();
    public ToolboxHandler toolboxHandler;

    public ToolboxPanel() {
       build();
    }
    public void build(){
        //this.setSize(600, 600);
        ToolboxHandler toolboxHandler = new ToolboxHandler(4,4);
        toolboxHandler.initComboBox(comboBoxMeuble,comboBoxStyles);
        this.add(this.getJpanelComboboxs());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public JPanel getJpanelComboboxs(){
        JPanel jPanel = new JPanel();
        //jPanel.setBackground(Color.BLUE);
        jPanel.add(comboBoxMeuble);
        jPanel.add(comboBoxStyles);
        return jPanel;
    }
}
