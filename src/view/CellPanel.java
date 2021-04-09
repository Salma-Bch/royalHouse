package view;

import model.Cell;
import model.Furniture;
import process.GridHandler;
import process.RotatedIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.dnd.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

/**
 * \file CellPanel.java
 * \brief Classe qui permet d afficher une cellule
 * \author CERINI Enzo, OBEYESEKARA Avishka, MANOUBI Farah, DENDOUNE Rayane, LEKMITI Mouncif, BENCHELKHA Salma
 * \version 1.0
 * \date 09/04/2021
 *
 * Classe contenant toutes les fonctions associées à l'affichage d'une cellule
 *
 */

public class CellPanel extends JPanel implements MouseListener, Serializable {
    private final Cell cell;
    private final int cellSize;
    private Color backgroundColor = Color.GRAY;
    private final boolean dropable;
    private final boolean dragable;
    private JLabel couleur;
    private JLabel style;
    private JLabel type;
    public boolean canThrow;

    private DragGestureRecognizer dragGestureRecognizer;
    private DragGestureHandler dragGestureHandler;
    DropTarget dropTarget;
    DropHandler dropHandler;

    /**
     * \fn CellPanel(Cell cell, int cellSize, boolean dropable, boolean dragable,boolean canThrow)
     * \brief Constructeur de CellulePanel
     * \param [in] cell correspond à une cellule (Type Cellule)
     * \param [in] cellSize correspond  à la taille d'une cellule (Type Integer)
     * \param [in] dropable permet d'indiquer si un meuble est dropable (Type Boolean)
     * \param [in] canThrow permet d'indiquer si un meuble est dragable (Type Boolean)
     */
    public CellPanel(Cell cell, int cellSize, boolean dropable, boolean dragable,boolean canThrow){
        super();
        this.cell = cell;
        this.canThrow = canThrow;
        this.cellSize = cellSize;
        this.dropable = dropable;
        this.dragable = dragable;
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.addMouseListener(this);
    }

    /**
     * \fn Cell getCell()
     * \brief Fonction qui retourne une cellule
     * \return Retourne une cellule
     */
    public Cell getCell(){
        return this.cell;
    }

    /**
     * \fn Color getBackgroundColor()
     * \brief Fonction qui permet de retourner une couleur de fond
     * \return Retourne une couleur
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * \fn void addNotify()
     * \brief Fonction qui permet de notifier
     */
    @Override
    public void addNotify(){
        if(dragable) {
            super.addNotify();
            if (dragGestureRecognizer == null) {
                dragGestureHandler = new DragGestureHandler(this);
                dragGestureRecognizer = DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(this
                        , DnDConstants.ACTION_COPY, dragGestureHandler);
            }
            dropHandler = new DropHandler();
            if (this.dropable)
                dropTarget = new DropTarget(this, DnDConstants.ACTION_COPY, dropHandler, true);
        }
    }

    /**
     * \fn void remoteNotify()
     * \brief Fonction qui permet de supprimer une notification
     */
    @Override
    public void removeNotify(){
        if(dragable) {
            if (dragGestureRecognizer != null) {
                dragGestureRecognizer.removeDragGestureListener(dragGestureHandler);
                dragGestureHandler = null;
            }
            dragGestureRecognizer = null;
            super.removeNotify();
            if (this.dropable)
                dropTarget.removeDropTargetListener(dropHandler);
        }
    }
    /**
     * \fn void paint(Graphics g)
     * \brief Fonction qui permet de dessiner
     * \param [in] g correspond au Graphique (Type Graphics)
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        this.setBackground(backgroundColor);
        paintFurniture(g);
    }

    /**
     * \fn void paintFurniture(Graphics g)
     * \brief Fonction qui permet de dessiner un meuble dans une cellule
     * \param [in] g correspond au Graphique (Type Graphics)
     */
    public void paintFurniture(Graphics g){
        if(cell.getFurniture() != null) {
            Image image = cell.getFurniture().getImage().getImage().getScaledInstance(cellSize, cellSize, Image.SCALE_DEFAULT);
            ImageIcon imageIcon = new ImageIcon(image);
            RotatedIcon rotatedIcon = new RotatedIcon(imageIcon,cell.getFurniture().getOrientation());
            rotatedIcon.paintIcon(this, g,  (getWidth()-cellSize)/2,(getHeight()-cellSize)/2);
        }
    }

    public void setBackgroundColor(Color backgroundColor){
        this.backgroundColor = backgroundColor;
    }

    /**
     * \fn void mouseClicked(MouseEvent e)
     * \brief Fonction qui permet de gérer les mouvements de la souris dans une cellule
     * \param [in] e correspond aux évènements de la souris (Type MouseEvent)
     */
    @Override
    public void mouseClicked(MouseEvent e) {

        ToolboxPanel.gridPanel.reinitCellPanels();
        ToolboxPanel.gridPanel.revalidate();
        ToolboxPanel.gridPanel.repaint();
        IHM.gridPan.reinitCellPanels();
        IHM.gridPan.revalidate();
        IHM.gridPan.repaint();

        this.getParent().repaint();
        Furniture f = cell.getFurniture();
        GridHandler.selectedCellPanel = this;

        if(f != null) {
            JPanel informationsMeubles = informationsMeubles();
            try {
                Furniture clonedF = (Furniture)f.clone();
                GarbagePanel.cellInfoPan.getCell().setFurniture(clonedF);
                GarbagePanel.infoPanel.remove(1);
                GarbagePanel.infoPanel.add(informationsMeubles);
                this.setVisible(true);
                GarbagePanel.infoPanel.revalidate();
                GarbagePanel.infoPanel.repaint();
            } catch (CloneNotSupportedException ex) {
                ex.printStackTrace();
            }

            backgroundColor = new Color(228, 172, 61);
            this.repaint();

        }

    }
    /**
     * \fn JPanel informationsMeubles()
     * \brief Fonction qui permet d'afficher les informations d'un meuble sélectionné dans un JPanel
     * \return un JPanel contenant les informations du meuble sélectionné
     */
    public JPanel informationsMeubles() {
        JPanel informations = new JPanel();
        informations.setLayout(new GridLayout(3,1));

        couleur = new JLabel();
        style = new JLabel();
        type = new JLabel();
        couleur.setText("        Couleur : " + cell.getFurniture().getColor());
        style.setText("        Style : " + cell.getFurniture().getStyle());
        type.setText("        Type : " + cell.getFurniture().getType());
        couleur.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 22));
        style.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 22));
        type.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 22));

        informations.add(couleur);
        informations.add(type);
        informations.add(style);

        return informations;
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
