package process;

import javax.swing.*;
import java.awt.*;

/**
 * \file RotatedIcon.c
 * \brief Classe qui permet de faire la rotation des images
 * \author LEKMITI Mouncif, MANOUBI Farah, BENCHELKHA Salma, OBEYESEKARA Avishka, CERINI Enzo, DENDOUNE Rayane
 * \version 1.0
 * \date 09/04/2021
 *
 * La classe RotatedIcon vous permet de modifier l'orientation d'une icône en la faisant pivoter avant de la peindre. Cette classe prend en charge les orientations suivantes :
 *
 * DOWN - rotation de 90 degrés
 * UP (par défaut) - rotation de -90 degrés
 * UPSIDE_DOWN - tourné de 180 degrés
 * ABOUT_CENTER - l'icône est tournée grâce aux degrés spécifiés autour de son centre.
 */
public class RotatedIcon implements Icon
{
    public enum Rotate
    {
        DOWN,
        UP,
        UPSIDE_DOWN,
        ABOUT_CENTER;
    }

    private Icon icon;

    private Rotate rotate;

    private double degrees;
    private boolean circularIcon;

    /**
     * RotatedIcon(Icon icon) constructeur
     * Constructeur pour créer une RotatedIcon qui est tournée vers le bas.
     *  @param icon  L'icône à tourner
     */
    public RotatedIcon(Icon icon)
    {
        this(icon, Rotate.UP);
    }

    /**
     * RotatedIcon(Icon icon, Rotate rotate) constructeur
     * @brief Créer une RotatedIcon
     *
     *  @param icon	L'icône à tourner
     *  @param rotate  La direction de la rotation
     */
    public RotatedIcon(Icon icon, Rotate rotate)
    {
        this.icon = icon;
        this.rotate = rotate;
    }

    /**
     * RotatedIcon(Icon icon, double degrees) constructeur
     * @brief Créer une RotatedIcon. L'icône va tourner autour de son centre. Ce constructeur va automatiquement définir l'enum Rotate sur ABOUT_CENTER.
     *
     *  @param icon	L'icône à tourner
     *  @param degrees  Le degré de rotation
     */
    public RotatedIcon(Icon icon, double degrees)
    {
        this(icon, degrees, false);
    }

    /**
     *  RotatedIcon(Icon icon, double degrees, boolean circularIcon) constructeur
     *  Créer une RotatedIcon. L'icône va tourner autour de son centre. Ce constructeur va automatiquement définir l'enum Rotate sur ABOUT_CENTER.
     *
     *  @param icon	L'icône à tourner
     *  @param degrees  Le degré de rotation
     *  @param circularIcon traiter l'icône comme circulaire pour que sa taille ne change pas
     */
    public RotatedIcon(Icon icon, double degrees, boolean circularIcon)
    {
        this(icon, Rotate.ABOUT_CENTER);
        setDegrees( degrees );
        setCircularIcon( circularIcon );
    }

    /**
     * Icon getIcon()
     *  @brief Obtient l'icône à faire pivoter
     *  @return L'icône à faire pivoter
     */
    public Icon getIcon()
    {
        return icon;
    }

    /**
     * Rotate getRotate()
     *  @brief Obtient l'enum Rotate qui indique la direction de la rotation.
     *
     *  @return Retourne l'enum de Rotate
     */
    public Rotate getRotate()
    {
        return rotate;
    }

    /**
     * double getDegrees()
     * @brief Obtient les degrés de rotation. Utilisé uniquement pour Rotate.ABOUT_CENTER.
     *
     *  @return les degrés de rotation
     */
    public double getDegrees()
    {
        return degrees;
    }

    /**
     * void setDegrees(double degrees)
     * @brief Permet de modifier le degré de rotation
     *
     *  @param degrees Le degré de rotation par lequel on veut le modifier
     */
    public void setDegrees(double degrees)
    {
        this.degrees = degrees;
    }

    /**
     * boolean isCircularIcon()
     * @brief Fonction qui retourne un booleen si l'icone a changé de largeur ou de longueur après rotation
     *
     *  @return true pour une icône circulaire, false sinon
     */
    public boolean isCircularIcon()
    {
        return circularIcon;
    }

    /**
     * void setCircularIcon(boolean circularIcon)
     * @brief Définit l'icone comme circulaire ou rectangulaire.
     *  Set the Icon as circular or rectangular. Utilisé uniquement pour Rotate.ABOUT_CENTER. Fonction qui retourne un booleen si l'icone a changé de largeur ou de longueur après rotation
     *
     *  @param circularIcon pour une icône circulaire, false sinon
     */
    public void setCircularIcon(boolean circularIcon)
    {
        this.circularIcon = circularIcon;
    }

//
//  Implement the Icon Interface
//

    /**
     * int getIconWidth()
     * @brief Obtient la largeur de cette icône.
     *
     *  @return Retourne la largeur de cette icône en pixels.
     */
    @Override
    public int getIconWidth()
    {
        if (rotate == Rotate.ABOUT_CENTER)
        {
            if (circularIcon)
                return icon.getIconWidth();
            else
            {
                double radians = Math.toRadians( degrees );
                double sin = Math.abs( Math.sin( radians ) );
                double cos = Math.abs( Math.cos( radians ) );
                int width = (int)Math.floor(icon.getIconWidth() * cos + icon.getIconHeight() * sin);
                return width;
            }
        }
        else if (rotate == Rotate.UPSIDE_DOWN)
            return icon.getIconWidth();
        else
            return icon.getIconHeight();
    }

    /**
     *  Obtient la hauteur de cette icône.
     *
     *  @return Retourne la hauteur de cette icône en pixel.
     */
    @Override
    public int getIconHeight()
    {
        if (rotate == Rotate.ABOUT_CENTER)
        {
            if (circularIcon)
                return icon.getIconHeight();
            else
            {
                double radians = Math.toRadians( degrees );
                double sin = Math.abs( Math.sin( radians ) );
                double cos = Math.abs( Math.cos( radians ) );
                int height = (int)Math.floor(icon.getIconHeight() * cos + icon.getIconWidth() * sin);
                return height;
            }
        }
        else if (rotate == Rotate.UPSIDE_DOWN)
            return icon.getIconHeight();
        else
            return icon.getIconWidth();
    }

    /**
     * void paintIcon(Component c, Graphics g, int x, int y)
     * @brief Fonction qui peint les icônes de cette icône composée à l'emplacement spécifié
     *  @param c Le composant sur lequel l'icône est peinte
     *  @param g le contexte graphique
     *  @param x la coordonnée X du coin supérieur gauche de l'icône
     *  @param y la coordonnée Y du coin supérieur gauche de l'icône
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        Graphics2D g2 = (Graphics2D)g.create();

        int cWidth = icon.getIconWidth() / 2;
        int cHeight = icon.getIconHeight() / 2;
        int xAdjustment = (icon.getIconWidth() % 2) == 0 ? 0 : -1;
        int yAdjustment = (icon.getIconHeight() % 2) == 0 ? 0 : -1;

        if (rotate == Rotate.DOWN)
        {
            g2.translate(x + cHeight, y + cWidth);
            g2.rotate( Math.toRadians( 90 ) );
            icon.paintIcon(c, g2,  -cWidth, yAdjustment - cHeight);
        }
        else if (rotate == Rotate.UP)
        {
            g2.translate(x + cHeight, y + cWidth);
            g2.rotate( Math.toRadians( -90 ) );
            icon.paintIcon(c, g2,  xAdjustment - cWidth, -cHeight);
        }
        else if (rotate == Rotate.UPSIDE_DOWN)
        {
            g2.translate(x + cWidth, y + cHeight);
            g2.rotate( Math.toRadians( 180 ) );
            icon.paintIcon(c, g2, xAdjustment - cWidth, yAdjustment - cHeight);
        }
        else if (rotate == Rotate.ABOUT_CENTER)
        {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setClip(x, y, getIconWidth(), getIconHeight());
            g2.translate((getIconWidth() - icon.getIconWidth()) / 2, (getIconHeight() - icon.getIconHeight()) / 2);
            g2.rotate(Math.toRadians(degrees), x + cWidth, y + cHeight);
            icon.paintIcon(c, g2, x, y);
        }

        g2.dispose();
    }

}

