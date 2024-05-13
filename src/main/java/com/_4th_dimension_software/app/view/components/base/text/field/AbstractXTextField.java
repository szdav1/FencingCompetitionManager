package com._4th_dimension_software.app.view.components.base.text.field;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.app.view.interfaces.CustomGraphicsUser;
import com._4th_dimension_software.app.view.interfaces.XComponent;
import com._4th_dimension_software.support.theme.Appearance;
import com._4th_dimension_software.support.theme.Appearances;
import com._4th_dimension_software.support.util.BorderPainter;
import com._4th_dimension_software.support.util.Util;

import javax.swing.JTextField;
import java.awt.*;

/**
 * The <code>AbstractXTextField</code> abstract class defines the abstract
 * behaviour of text fields inside the application. It is a subclass of
 * swing's default <code>JTextField</code> class. It implements the basic
 * and necessary interfaces that are required in order for a text fields to work
 * properly.
 *
 * @author szd
 */
public abstract class AbstractXTextField extends JTextField implements XComponent, CustomGraphicsUser {
    protected final Appearance appearance;
    protected final XFrame frame;

    /**
     * Defines the constructor of the text fields that
     * initializes every field of the class with the
     * given parameters.
     *
     * @param dimension      The Dimension of the text field
     * @param text           The default text of the text field
     * @param frame          The main frame of the application
     * @param appearanceName The name of the Appearance that's values
     *                       should be implemented on this text field
     */
    protected AbstractXTextField(Dimension dimension, String text, final XFrame frame, String appearanceName) {
        this.appearance = Appearances.get(appearanceName);
        this.frame = frame;

        this.setText(text);
        this.setFont(appearance.getFont());
        this.setForeground(appearance.getForegrounds().get(0));
        this.setCaretColor(this.getForeground());
        this.setOpaque(false);
        this.setBorder(null);
        this.setBounds(new Rectangle(0, 0, dimension.width, dimension.height));
        this.setPreferredSize(dimension);
    }

    /**
     * Defines the constructor of the text fields that
     * initializes every field of the class with the
     * given parameters except for the default text.
     *
     * @param dimension      The Dimension of the text field
     * @param frame          The main frame of the application
     * @param appearanceName The name of the Appearance that's values
     *                       should be implemented on this text field
     */
    protected AbstractXTextField(Dimension dimension, final XFrame frame, String appearanceName) {
        this(dimension, "", frame, appearanceName);
    }

    /**
     * Defines the constructor of the text fields that
     * initializes every field of the class with the
     * given parameters.
     *
     * @param x              The X coordinate of the text field in no-layout manager space
     * @param y              The Y coordinate of the text field in no-layout manager space
     * @param width          The width of the text field
     * @param height         The height of the text field
     * @param text           The default text of the text field
     * @param frame          The main frame of the application
     * @param appearanceName The name of the Appearance that's values
     *                       should be implemented on this text field
     */
    protected AbstractXTextField(int x, int y, int width, int height, String text, final XFrame frame, String appearanceName) {
        this.appearance = Appearances.get(appearanceName);
        this.frame = frame;

        this.setText(text);
        this.setFont(appearance.getFont());
        this.setForeground(appearance.getForegrounds().get(0));
        this.setCaretColor(this.getForeground());
        this.setOpaque(false);
        this.setBorder(null);
        this.setPreferredSize(new Dimension(width, height));
        this.setBounds(new Rectangle(x, y, width, height));
    }

    /**
     * Defines the constructor of the text fields that
     * initializes every field of the class with the
     * given parameters except for the default text.
     *
     * @param x              The X coordinate of the text field in no-layout manager space
     * @param y              The Y coordinate of the text field in no-layout manager space
     * @param width          The width of the text field
     * @param height         The height of the text field
     * @param frame          The main frame of the application
     * @param appearanceName The name of the Appearance that's values
     *                       should be implemented on this text field
     */
    protected AbstractXTextField(int x, int y, int width, int height, final XFrame frame, String appearanceName) {
        this(x, y, width, height, "", frame, appearanceName);
    }

    @Override
    public void paintBackground(int x, int y, int w, int h, int r, final Graphics2D g2D) {
        if (this.appearance.getBackgrounds().size() >= 2) {
            LinearGradientPaint lgp = new LinearGradientPaint(x, y, w, h, Util.calcEqualFracts(this.appearance.getBackgrounds().size()),
                this.appearance.getBackgroundsAsArray());

            g2D.setPaint(lgp);
        }
        else
            g2D.setColor(this.appearance.getBackgrounds().get(0));

        // Fill background
        g2D.fillRoundRect(x, y, this.getWidth(), this.getHeight(), r, r);
    }

    @Override
    public void paintForeground() {
    }

    @Override
    public void paintIcon() {
    }

    @Override
    public void paintBorder(int x, int y, int w, int h, int r, final Graphics2D g2D) {
        if (this.appearance.getBorderModel().getThickness() <= 0)
            return;

        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setStroke(new BasicStroke(this.appearance.getBorderModel().getThickness(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));

        BorderPainter bp = new BorderPainter(x, y, this.getWidth(), this.getHeight(), r, this.appearance, g2D);

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

        // Background
        this.paintBackground(X, Y, W, H, R, g2D);
        // Paint the border
        this.paintBorder(X, Y, W, H, R, g2D);
        // Paint the component
        super.paint(g);

        // Destroy the Graphics2D object as it is no longer needed
        g2D.dispose();
    }
}
