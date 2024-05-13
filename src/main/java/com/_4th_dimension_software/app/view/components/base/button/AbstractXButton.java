package com._4th_dimension_software.app.view.components.base.button;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import com._4th_dimension_software.app.view.components.base.label.XLabel;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.app.view.interfaces.CustomGraphicsUser;
import com._4th_dimension_software.app.view.interfaces.XComponent;
import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.theme.Appearance;
import com._4th_dimension_software.support.theme.Appearances;
import com._4th_dimension_software.support.util.BorderPainter;
import com._4th_dimension_software.support.util.Util;

/**
 * The <code>AbstractXButton</code> abstract class defines the abstract
 * behaviour of buttons inside the application. It is a subclass of
 * swing's default <code>JButton</code> class. It implements the basic
 * and necessary interfaces that are required in order for a button to work
 * properly.
 *
 * @author szd
 */
public abstract class AbstractXButton extends JButton implements MouseListener, XComponent, CustomGraphicsUser {
	protected boolean entered;
	protected boolean pressed;

	protected final Appearance appearance;
	protected final XFrame frame;
	protected final XLabel shortcutKeyLabel;

	/**
	 * Defines the constructor of the buttons that
	 * initializes every field of the class with the
	 * given parameters.
	 *
	 * @param dimension       The Dimension of the button
	 * @param text            The text of the button
	 * @param shortcutKeyText The string representation of the shortcut key assigned to this button
	 * @param frame           The main frame of the application
	 * @param appearanceName  The name of the Appearance that's values
	 *                        should be implemented on this button
	 */
	protected AbstractXButton(Dimension dimension, String text, String shortcutKeyText, final XFrame frame, String appearanceName) {
		this.entered = false;
		this.pressed = false;

		this.appearance = Appearances.get(appearanceName);
		this.frame = frame;
		this.shortcutKeyLabel = new XLabel(dimension.width-SizeData.SHORTCUT_KEY_LABEL_WIDTH, 0, SizeData.SHORTCUT_KEY_LABEL_WIDTH,
			dimension.height, shortcutKeyText, frame, "shortcutKeyLabel");
		this.shortcutKeyLabel.setHorizontalAlignment(JLabel.CENTER);
		this.shortcutKeyLabel.setVerticalAlignment(JLabel.CENTER);

		this.setIcon(appearance.getIcon1() == null ? appearance.getIcon2() : appearance.getIcon1());
		this.setText(text);
		this.setFont(appearance.getFont());
		this.setForeground(appearance.getForegrounds().get(0));
		this.setLayout(null);
		this.setFocusable(false);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setBounds(new Rectangle(0, 0, dimension.width, dimension.height));
		this.setPreferredSize(dimension);
		this.addMouseListener(this);

		// Add shortcut key label
		this.add(this.shortcutKeyLabel);
	}

	/**
	 * Defines the constructor of the buttons that
	 * initializes every field of the class with the
	 * given parameters except for the shortcut key text.
	 *
	 * @param dimension      The Dimension of the button
	 * @param text           The text of the button
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that's values
	 *                       should be implemented on this button
	 */
	protected AbstractXButton(Dimension dimension, String text, final XFrame frame, String appearanceName) {
		this(dimension, text, "", frame, appearanceName);
	}

	/**
	 * Defines the constructor of the buttons that
	 * initializes every field of the class with the
	 * given parameters.
	 *
	 * @param x               The X coordinate of the button in no-layout manager space
	 * @param y               The Y coordinate of the button in no-layout manager space
	 * @param width           The width of the button
	 * @param height          The height of the button
	 * @param text            The text of the button
	 * @param shortcutKeyText The string representation of the shortcut key assigned to this button
	 * @param frame           The main frame of the application
	 * @param appearanceName  The name of the Appearance that's values
	 *                        should be implemented on this button
	 */
	protected AbstractXButton(int x, int y, int width, int height, String text, String shortcutKeyText, final XFrame frame, String appearanceName) {
		this.entered = false;
		this.pressed = false;

		this.appearance = Appearances.get(appearanceName);
		this.frame = frame;
		this.shortcutKeyLabel = new XLabel(width-SizeData.SHORTCUT_KEY_LABEL_WIDTH, 0, SizeData.SHORTCUT_KEY_LABEL_WIDTH,
			height, shortcutKeyText, frame, "shortcutKeyLabel");
		this.shortcutKeyLabel.setHorizontalAlignment(JLabel.CENTER);
		this.shortcutKeyLabel.setVerticalAlignment(JLabel.CENTER);

		this.setIcon(appearance.getIcon1() == null ? appearance.getIcon2() : appearance.getIcon1());
		this.setText(text);
		this.setFont(appearance.getFont());
		this.setForeground(appearance.getForegrounds().get(0));
		this.setLayout(null);
		this.setFocusable(false);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setPreferredSize(new Dimension(width, height));
		this.setBounds(new Rectangle(x, y, width, height));
		this.addMouseListener(this);

		// Add shortcut key label
		this.add(this.shortcutKeyLabel);
	}

	/**
	 * Defines the constructor of the buttons that
	 * initializes every field of the class with the
	 * given parameters except for the shortcut key text.
	 *
	 * @param x              The X coordinate of the button in no-layout manager space
	 * @param y              The Y coordinate of the button in no-layout manager space
	 * @param width          The width of the button
	 * @param height         The height of the button
	 * @param text           The text of the button
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that's values
	 *                       should be implemented on this button
	 */
	protected AbstractXButton(int x, int y, int width, int height, String text, final XFrame frame, String appearanceName) {
		this(x, y, width, height, text, "", frame, appearanceName);
	}

	/**
	 * Sets the text of the shortcut key label
	 * of this button to the specified text.
	 * This text does not equal to the actual shortcut key
	 * assigned to this button.
	 *
	 * @param shortcutKeyText The text representation of the shortcut key text
	 */
	public void setShortcutKeyText(String shortcutKeyText) {
		this.shortcutKeyLabel.setText(shortcutKeyText);
	}

	/**
	 * Resets all states of the button.
	 */
	public void reset() {
		this.entered = false;
		this.pressed = false;
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
		if (this.appearance.getForegrounds().size() >= 2 && this.shortcutKeyLabel.getAppearance().getForegrounds().size() >= 2) {
			// If the button is entered by the mouse, the second color specified in the
			// Appearance will be set as the foreground
			// If not, the first color specified in the Appearance will be set as the foreground
			this.setForeground(this.entered ? this.appearance.getForegrounds().get(1) : this.appearance.getForegrounds().get(0));
			this.shortcutKeyLabel.setForeground(this.entered ?
				this.shortcutKeyLabel.getAppearance().getForegrounds().get(1) :
				this.shortcutKeyLabel.getAppearance().getForegrounds().get(0));

			// If the button is pressed, the first color specified in the
			// Appearance will be set as the foreground
			// If not, the second color specified in the Appearance will be set as the foreground
			this.setForeground(this.pressed ? this.appearance.getForegrounds().get(0) : this.appearance.getForegrounds().get(1));
			this.shortcutKeyLabel.setForeground(this.pressed ?
				this.shortcutKeyLabel.getAppearance().getForegrounds().get(0) :
				this.shortcutKeyLabel.getAppearance().getForegrounds().get(1));

			// If the state of the button is normal, the (default) first color is used
			if (!this.entered && !this.pressed) {
				this.setForeground(this.appearance.getForegrounds().get(0));
				this.shortcutKeyLabel.setForeground(this.shortcutKeyLabel.getAppearance().getForegrounds().get(0));
			}
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
