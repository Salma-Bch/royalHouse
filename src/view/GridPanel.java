package view;

import model.Grid;
import process.GridHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GridPanel extends JPanel implements MouseListener {

    public GridHandler gridHandler;
    private Grid grid;
    int position = 0;
    int x = 0;
    int y = 0;
    int px =  50 + x * 50;
    int py = 100 + y * 50 - 50;
    Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    int height, width;

    public GridPanel() {
        super();
        this.setSize(600, 600);
        gridHandler = new GridHandler(6,8);
        grid = gridHandler.getGrid();
        height = GridHandler.sizeCell * grid.getRowNumber();
        width = GridHandler.sizeCell * grid.getColumnNumber();

        this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        drawGrid(g, width,height, GridHandler.sizeCell);
        int selectedCell = gridHandler.getSelectedCell();
        //grid.getCells().get(selectedCell);
        /*for(int i = 0; i< ToolboxPanel.furnitures.size(); i++){
            Image image = ToolboxPanel.furnitures.get(i).getImage().getImage().getScaledInstance(sizeCell,sizeCell,Image.SCALE_DEFAULT);
            ImageIcon imageIcon = new ImageIcon(image);
            imageIcon.paintIcon(this, g2, i*sizeCell,100);
        }*/
        displayCells(g);
    }

    private void drawGrid(Graphics g, int width ,int height, int sizeCell) {
        g.setColor(Color.BLACK);
        g.drawLine(0, 0, width, 0);
        g.drawLine(0, height, width, height);
        g.drawLine(0, 0, 0, height);
        g.drawLine(width, 0, width, height);

        for(int i = 0; i<=width; i+=sizeCell) {
            g.drawLine(i, 0, i, height);
        }

        for(int i = 0; i<=height; i+=sizeCell) {
            g.drawLine(0, i, width, i);
        }
    }

   public void displayCells(Graphics g){
       g.setColor(new Color(59, 109, 146));
       for (int i=0; i<grid.getCells().size(); i++){
           x = i /GridHandler.sizeCell;
           y = i/GridHandler.sizeCell;
           px =  (x+1) * GridHandler.sizeCell;
           py =  (y+1) * GridHandler.sizeCell;
           g.fillRect(px -(GridHandler.sizeCell-1),py -(GridHandler.sizeCell-1),(GridHandler.sizeCell-1), (GridHandler.sizeCell-1) );
       }
       x = gridHandler.getSelectedCell() /GridHandler.sizeCell;
       y = gridHandler.getSelectedCell()/GridHandler.sizeCell;
       px =  (3+1) * GridHandler.sizeCell;
       py =  (3+1) * GridHandler.sizeCell;
       g.setColor(new Color(189, 189, 189));
       g.fillRect(px, py, 0, 0);
   }
    public void mouseClicked(MouseEvent e) {
        if(e.getX()<width && e.getY()<height) {
            x = e.getX() / GridHandler.sizeCell;
            y = e.getY() / GridHandler.sizeCell;

            position = 8 * y + x;
            System.out.println("x = " + x + " y = " + y);
            System.out.println(position);
            gridHandler.setSelectedCell(position);
            System.out.println("Selected cell : " +gridHandler.getSelectedCell());
            this.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
