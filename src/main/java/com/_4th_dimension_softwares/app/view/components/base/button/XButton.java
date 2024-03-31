package com._4th_dimension_softwares.app.view.components.base.button;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.List;

import com._4th_dimension_softwares.app.view.frame.XFrame;
import com._4th_dimension_softwares.support.framework.Appearance;
import com._4th_dimension_softwares.support.util.Util;

/**
 * The XButton class is an extended representation
 * of Swing's <code>JButton</code> class. It works similarly to
 * <code>JButton</code>. It acts as a button, and it can change
 * its background, foreground or icon based on the type of action
 * occurring on the area of the button.
 * <p></p>
 * The extended means that just by passing in an Appearance
 * object to the constructor, this panel will be stylized
 * according to that Appearance. This saves the work with
 * Graphics and Graphics2D and makes creating beautiful
 * container buttons easy and fast.
 * <p></p>
 * The <code>paintComponent()</code> method is fully overridden
 * from the super class. Only the displaying of added components
 * is what kept, but background painting and border painting
 * is fully customized to work based on the Appearance object passed
 * into the constructor of the class.
 * <p></p>
 * The first is the background that gets painted. The painting procedure
 * depends on the number of colors in the Appearance object. If the number
 * is less than 2, the color that was specified in the backgrounds field of
 * the color theme will be painted all over the component. If multiple colors
 * were defined, then a <code>LinearGradientPant</code> will be used to paint
 * every specified color on the component dividing the available space for painting
 * equally.
 * <p></p>
 * The second thing that's painted is the foreground. The text is rendered by the
 * default rendering procedure, the only thing that is modified is the color of
 * the text. This varies based on mouse actions performed on the button.
 * <p></p>
 * Next is the icon that is painted. Similarly to the text on the button, the
 * icon is painted using the default paint method, the only thing that's modified is
 * that the icon that is painted on the component changes based on mouse action.
 * <p></p>
 * The next that is painted is the border. If the thickness of the border
 * is greater than 0, than the border is painted. The coloring of the
 * border happens the same way as coloring the background. The number of colors
 * determines the process. If less than 2, the simple color will be used, if more or
 * 2, then <code>LinearGradientPaint</code> will be used.
 * <p></p>
 * Important
 * <p>For painting the background: <code>VALUE_RENDER_QUALITY</code></p>
 * <p>For painting the border: <code>VALUE_ANTIALIAS_ON</code></p>
 *
 * @author szd
 */
public class XButton extends AbstractXButton {
	/**
	 * Constructs an <code>XButton</code> object. This object is
	 * similar to a <code>JButton</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param dimension      The Dimension of the button
	 * @param text           The text of the button
	 * @param frame          The main frame of the application
	 * @param type           The type of the button (<code>ButtonType.BACKGROUND_CHANGER, FOREGROUND_CHANGER, ICON_CHANGER</code>)
	 * @param appearanceName The name of the <code>Appearance</code> that's values
	 *                       should be implemented on this button
	 */
	public XButton(Dimension dimension, String text, final XFrame frame, ButtonType type, String appearanceName) {
		super(dimension, text, frame, type, appearanceName);
	}

	/**
	 * Constructs an <code>XButton</code> object. This object is
	 * similar to a <code>JButton</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param dimension      The Dimension of the button
	 * @param frame          The main frame of the application
	 * @param type           The type of the button (<code>ButtonType.BACKGROUND_CHANGER, FOREGROUND_CHANGER, ICON_CHANGER</code>)
	 * @param appearanceName The name of the <code>Appearance</code> that's values
	 *                       should be implemented on this button
	 */
	public XButton(Dimension dimension, final XFrame frame, ButtonType type, String appearanceName) {
		super(dimension, frame, type, appearanceName);
	}

	/**
	 * Constructs an <code>XButton</code> object. This object is
	 * similar to a <code>JButton</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param x              The X coordinate of the button in no-layout manager space
	 * @param y              The Y coordinate of the button in no-layout manager space
	 * @param width          The width of the button
	 * @param height         The height of the button
	 * @param text           The text of the button
	 * @param frame          The main frame of the application
	 * @param type           The type of the button (<code>ButtonType.BACKGROUND_CHANGER, FOREGROUND_CHANGER, ICON_CHANGER</code>)
	 * @param appearanceName The name of the <code>Appearance</code> that's values
	 *                       should be implemented on this button
	 */
	public XButton(int x, int y, int width, int height, String text, final XFrame frame, ButtonType type, String appearanceName) {
		super(x, y, width, height, text, frame, type, appearanceName);
	}

	/**
	 * Constructs an <code>XButton</code> object. This object is
	 * similar to a <code>JButton</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param x              The X coordinate of the button in no-layout manager space
	 * @param y              The Y coordinate of the button in no-layout manager space
	 * @param width          The width of the button
	 * @param height         The height of the button
	 * @param frame          The main frame of the application
	 * @param type           The type of the button (<code>ButtonType.BACKGROUND_CHANGER, FOREGROUND_CHANGER, ICON_CHANGER</code>)
	 * @param appearanceName The name of the <code>Appearance</code> that's values
	 *                       should be implemented on this button
	 */
	public XButton(int x, int y, int width, int height, final XFrame frame, ButtonType type, String appearanceName) {
		super(x, y, width, height, frame, type, appearanceName);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.pressed = true;
		this.paintComponent(this.getGraphics());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.pressed = false;
		this.paintComponent(this.getGraphics());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.entered = true;
		this.paintComponent(this.getGraphics());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.entered = false;
		this.paintComponent(this.getGraphics());
	}

	@Override
	public XFrame getFrame() {
		return this.frame;
	}

	@Override
	public void repaintFrame() {
		if (this.frame != null)
			this.frame.repaint();
	}

	@Override
	public Appearance getAppearance() {
		return this.appearance;
	}

	@Override
	public void paintBackground(int x, int y, int w, int h, int r, final Graphics2D g2D) {
		LinearGradientPaint lgp;

		// If there's only one color defined in the color theme
		if (this.appearance.getBackgrounds().size() == 1) {
			g2D.setColor(this.appearance.getBackgrounds().get(0));
		}
		// If there are two colors defined in the color theme
		else if (this.appearance.getBackgrounds().size() == 2) {
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
		else if (this.appearance.getBackgrounds().size() == 3) {
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
		g2D.fillRoundRect(x, y, w, h, r, r);
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
		LinearGradientPaint lgp;

		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (this.appearance.getBorderModel().getThickness() > 0) {
			if (this.appearance.getBorderModel().getColorModel().getColors().size() >= 2) {
				lgp = new LinearGradientPaint(x, y, w, h, Util.calcEqualFracts(this.appearance.getBorderModel()
					.getColorModel()
					.getColors()
					.size()), this.appearance.getBorderColorsAsArray());

				g2D.setPaint(lgp);
			}
			else
				g2D.setColor(this.appearance.getBorderModel().getColorModel().getColors().get(0));

			g2D.setStroke(new BasicStroke(this.appearance.getBorderModel().getThickness(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
			// Draw border
			g2D.drawRoundRect(x, y, w, h, r, r);
		}
	}
}
