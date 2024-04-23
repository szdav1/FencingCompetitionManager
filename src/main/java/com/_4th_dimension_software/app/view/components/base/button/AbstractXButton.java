package com._4th_dimension_software.app.view.components.base.button;

import com._4th_dimension_software.app.view.components.interfaces.CustomGraphicsUser;
import com._4th_dimension_software.app.view.components.interfaces.XComponent;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.framework.Appearance;
import com._4th_dimension_software.support.framework.Appearances;
import com._4th_dimension_software.support.util.BorderPainter;
import com._4th_dimension_software.support.util.Util;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Optional;

public abstract class AbstractXButton extends JButton implements MouseListener, XComponent, CustomGraphicsUser {
    protected boolean entered = false;
    protected boolean pressed = false;

    protected Appearance appearance;
    protected final XFrame frame;

    protected AbstractXButton(Dimension dimension, String text, final XFrame frame, String appearanceName) {
        this.appearance = Appearances.get(appearanceName);
        this.frame = frame;

        this.setIcon(appearance.getIcon1() == null ? appearance.getIcon2() : appearance.getIcon1());
        this.setText(text);
        this.setFont(appearance.getFont());
        this.setForeground(appearance.getForegrounds().get(0));
        this.setFocusable(false);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setBounds(new Rectangle(0, 0, dimension.width, dimension.height));
        this.setPreferredSize(dimension);
        this.addMouseListener(this);
    }

    protected AbstractXButton(Dimension dimension, final XFrame frame, String appearanceName) {
        this(dimension, "", frame, appearanceName);
    }

    protected AbstractXButton(int x, int y, int width, int height, String text, final XFrame frame, String appearanceName) {
        this.appearance = Appearances.get(appearanceName);
        this.frame = frame;

        this.setIcon(appearance.getIcon1() == null ? appearance.getIcon2() : appearance.getIcon1());
        this.setText(text);
        this.setFont(appearance.getFont());
        this.setForeground(appearance.getForegrounds().get(0));
        this.setFocusable(false);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setPreferredSize(new Dimension(width, height));
        this.setBounds(new Rectangle(x, y, width, height));
        this.addMouseListener(this);
    }

    protected AbstractXButton(int x, int y, int width, int height, final XFrame frame, String appearanceName) {
        this(x, y, width, height, "", frame, appearanceName);
    }

    /**
     * Retrieves the main icon from the <code>Appearance</code>
     * of the button object wrapped into an Optional.
     *
     * @return The main icon of the button stored in the <code>Appearance</code>
     * of the button
     */
    public Optional<ImageIcon> getIcon1() {
        return Optional.of(this.appearance.getIcon1());
    }

    /**
     * Retrieves the secondary icon from the <code>Appearance</code>
     * of the button object wrapped into an Optional.
     *
     * @return The secondary icon of the button stored in the <code>Appearance</code>
     * of the button
     */
    public Optional<ImageIcon> getIcon2() {
        return Optional.of(this.appearance.getIcon2());
    }

    @Override
    public void paintBackground(int x, int y, int w, int h, int r, final Graphics2D g2D) {
        LinearGradientPaint lgp;
        int backgroundSize = this.appearance.getBackgrounds().size();

        // If there's only one color defined in the color theme
        if (backgroundSize == 1) {
            g2D.setColor(this.appearance.getBackgrounds().get(0));
        }
        // If there are two colors defined in the color theme
        else if (backgroundSize == 2) {
            // If the button is entered by the mouse, the second color is painted
            // If not, the (default) first color is painted
            g2D.setPaint(this.entered ? this.appearance.getBackgrounds().get(1) : this.appearance.getBackgrounds().get(0));

            // If the button is pressed, the (default) first color is painted
            // If not, the second color is painted
            g2D.setPaint(this.pressed ? this.appearance.getBackgrounds().get(0) : this.appearance.getBackgrounds().get(1));

            // If the state of the button is normal, the (default) first color is painted
            if (!this.entered && !this.pressed)
                g2D.setColor(this.appearance.getBackgrounds().get(0));
        }
        // If there are three colors defined in the color theme
        else if (backgroundSize == 3) {
            // Separate the colors
            Color mainColor = this.appearance.getBackgrounds().get(0);
            Color[] secondaryColors = {this.appearance.getBackgrounds().get(1), this.appearance.getBackgrounds().get(2)};
            // Create the LinearGradientPaint
            lgp = new LinearGradientPaint(x, y, w, h, Util.calcEqualFracts(secondaryColors.length), secondaryColors);

            // If the button is entered by the mouse, the background is painted gradient
            g2D.setPaint(this.entered ? lgp : mainColor);
            // If not, the (default) first color is painted

            // If the button is pressed, the (default) first color is painted
            // If not, the background is painted gradient
            g2D.setPaint(this.pressed ? mainColor : lgp);

            // If the state of the button is normal, the (default) first color is painted
            if (!this.entered && !this.pressed)
                g2D.setColor(this.appearance.getBackgrounds().get(0));
        }
        // If there are more than three colors defined in the color theme
        else {
            List<Color[]> halfColors = Util.halveColors(this.appearance.getBackgrounds());
            lgp = new LinearGradientPaint(x, y, w, h, Util.calcEqualFracts(halfColors.get(0).length), halfColors.get(0));
            LinearGradientPaint lgp2 = new LinearGradientPaint(x, y, w, h, Util.calcEqualFracts(halfColors.get(1).length), halfColors.get(1));

            // If the button is entered by the mouse, the first half of the specified colors
            // Are painted in a linear gradient configuration
            // If not, the second half of the specified colors are painted in the same configuration
            g2D.setPaint(this.entered ? lgp2 : lgp);

            // If the button is entered by the mouse, the first half of the specified colors
            // Are painted in a linear gradient configuration
            g2D.setPaint(this.pressed ? lgp : lgp2);
            // If not, the second half of the specified colors are painted in the same configuration

            // If the state of the button is normal, the (default) first color is painted
            if (!this.entered && !this.pressed)
                g2D.setPaint(lgp);
        }

        // Fill the background
        g2D.fillRoundRect(x, y, this.getWidth(), this.getHeight(), r, r);
    }

    @Override
    public void paintForeground() {
        if (this.appearance.getForegrounds().size() >= 2) {
            // If the button is entered by the mouse, the second color specified in the
            // Appearance will be set as the foreground
            // If not, the first color specified in the Appearance will be set as the foreground
            this.setForeground(this.entered ? this.appearance.getForegrounds().get(1) : this.appearance.getForegrounds().get(0));

            // If the button is pressed, the first color specified in the
            // Appearance will be set as the foreground
            // If not, the second color specified in the Appearance will be set as the foreground
            this.setForeground(this.pressed ? this.appearance.getForegrounds().get(0) : this.appearance.getForegrounds().get(1));

            // If the state of the button is normal, the (default) first color is used
            if (!this.entered && !this.pressed)
                this.setForeground(this.appearance.getForegrounds().get(0));
        }
    }

    @Override
    public void paintIcon() {
        if (this.appearance.getIcon1() != null && this.appearance.getIcon2() != null) {
            // If the button is entered by the mouse, the secondary icon
            // Defined in the Appearance will be set as the icon of the button
            // If not, than the main icon specified in the Appearance will be set
            this.setIcon(this.entered ? this.appearance.getIcon2() : this.appearance.getIcon1());

            // If the button is pressed, the main icon
            // Defined in the Appearance will be set as the icon of the button
            // If not, than the secondary icon specified in the Appearance will be set
            this.setIcon(this.pressed ? this.appearance.getIcon1() : this.appearance.getIcon2());

            // If the state of the button is normal, the (default) first icon is used
            if (!this.entered && !this.pressed)
                this.setIcon(this.appearance.getIcon1());
        }
    }

    @Override
    public void paintBorder(int x, int y, int w, int h, int r, final Graphics2D g2D) {
        if (this.appearance.getBorderModel().getThickness() <= 0)
            return;

        BorderPainter bp = new BorderPainter(x, y, w, h, r, this.appearance, g2D);

        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setStroke(new BasicStroke(this.appearance.getBorderModel().getThickness(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));

        // Set the coloring of the border based on the number of colors specified in the color theme
        if (this.appearance.getBorderModel().getColorModel().getColors().size() >= 2) {
            // Draw full border
            if (this.appearance.getBorderModel().getThickness() != 0 && this.appearance.isBorderNotPainted() || this.appearance.isBorderPainted())
                bp.paintFullBorder();
            else {
                // Draw top section of the border only
                if (this.appearance.isBorderSectionPainted("top"))
                    bp.paintTopBorder();

                // Draw right section of the border only
                if (this.appearance.isBorderSectionPainted("right"))
                    bp.paintRightBorder();

                // Draw bottom section of the border only
                if (this.appearance.isBorderSectionPainted("bottom"))
                    bp.paintBottomBorder();

                // Draw left side of the border only
                if (this.appearance.isBorderSectionPainted("left"))
                    bp.paintLeftBorder();
            }
        }
        else {
            g2D.setColor(this.appearance.getBorderModel().getColorModel().getColors().get(0));

            // Draw full border
            if (this.appearance.getBorderModel().getThickness() != 0 && this.appearance.isBorderNotPainted() || this.appearance.isBorderPainted())
                g2D.drawRoundRect(x, y, this.getWidth(), this.getHeight(), r, r);
            else {
                // Draw top section of the border only
                if (this.appearance.isBorderSectionPainted("top"))
                    g2D.drawLine(0, 0, this.getWidth(), 0);

                // Draw right section of the border only
                if (this.appearance.isBorderSectionPainted("right"))
                    g2D.drawLine(this.getWidth(), 0, this.getWidth(), this.getHeight());

                // Draw bottom section of the border only
                if (this.appearance.isBorderSectionPainted("bottom"))
                    g2D.drawLine(0, this.getHeight(), this.getWidth(), this.getHeight());

                // Draw left side of the border only
                if (this.appearance.isBorderSectionPainted("left"))
                    g2D.drawLine(0, 0, 0, this.getHeight());
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        // Cast Graphics to Graphics2D
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        Rectangle clipRect = g.getClipBounds();

        // Start and end coordinates for painting
        final int X = clipRect.x;
        final int Y = clipRect.y;
        final int W = clipRect.width;
        final int H = clipRect.height;
        // Roundness
        final int R = this.appearance.getBorderModel().getRoundness();

        // Paint the background
        this.paintBackground(X, Y, W, H, R, g2D);
        // Paint the foreground
        this.paintForeground();
        // Paint the icon (Actually set the corresponding icon)
        this.paintIcon();
        // Paint the border
        this.paintBorder(X, Y, W, H, R, g2D);
        // Paint the component
        super.paint(g);

        // Destroy the Graphics2D object as it is no longer needed
        g2D.dispose();
    }
}
