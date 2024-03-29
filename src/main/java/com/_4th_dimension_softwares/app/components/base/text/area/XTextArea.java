package com._4th_dimension_softwares.app.components.base.text.area;

import java.awt.*;

import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.framework.Appearance;
import com._4th_dimension_softwares.support.util.Util;

/**
 * The XTextArea class is an extended representation
 * of Swing's <code>JTextArea</code> class. It works similarly to
 * <code>JTextField</code>. It acts as an input field.
 * <p></p>
 * The extended means that just by passing in an Appearance
 * object to the constructor, this panel will be stylized
 * according to that Appearance. This saves the work with
 * Graphics and Graphics2D and makes creating beautiful
 * container panels easy and fast.
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
 * The next that is painted is the border. If the thickness of the border
 * is greater than 0, than the border is painted. The coloring of the
 * border happens the same way as coloring the background. The number of colors
 * determines the process. If less than 2, the simple color will be used, if more or
 * 2, then <code>LinearGradientPaint</code> will be used.
 * <p></p>
 * The text is rendered by the default rendering method defined by swing.
 * Basically the <code>super</code> class's <code>paintComponent()</code>
 * method is invoked at the end of the overridden <code>paintComponent()</code>
 * method to draw the desired text on the component.
 * <p></p>
 * The icon similarly to the text is rendered using the default
 * rendering method defined by swing.
 * <p></p>
 * Important
 * <p>For painting the background: <code>VALUE_RENDER_QUALITY</code></p>
 * <p>For painting the border: <code>VALUE_ANTIALIAS_ON</code></p>
 *
 * @author szd
 */
public class XTextArea extends AbstractXTextArea {
	/**
	 * Constructs an <code>XTextArea</code> object. This object is
	 * similar to a <code>JTextArea</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param dimension      The Dimension of the text field
	 * @param text           The default text of the text field
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the <code>Appearance</code> that's values
	 *                       should be implemented on this text area
	 */
	public XTextArea(Dimension dimension, String text, final XFrame frame, String appearanceName) {
		super(dimension, text, frame, appearanceName);
	}

	/**
	 * Constructs an <code>XTextArea</code> object. This object is
	 * similar to a <code>JTextArea</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param dimension      The Dimension of the text field
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the <code>Appearance</code> that's values
	 *                       should be implemented on this text area
	 */
	public XTextArea(Dimension dimension, final XFrame frame, String appearanceName) {
		super(dimension, frame, appearanceName);
	}

	/**
	 * Constructs an <code>XTextArea</code> object. This object is
	 * similar to a <code>JTextArea</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param x              The X coordinate of the text field in no-layout manager space
	 * @param y              The Y coordinate of the text field in no-layout manager space
	 * @param width          The width of the text field
	 * @param height         The height of the text field
	 * @param text           The default text of the text field
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the <code>Appearance</code> that's values
	 *                       should be implemented on this text area
	 */
	public XTextArea(int x, int y, int width, int height, String text, final XFrame frame, String appearanceName) {
		super(x, y, width, height, text, frame, appearanceName);
	}

	/**
	 * Constructs an <code>XTextArea</code> object. This object is
	 * similar to a <code>JTextArea</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param x              The X coordinate of the text field in no-layout manager space
	 * @param y              The Y coordinate of the text field in no-layout manager space
	 * @param width          The width of the text field
	 * @param height         The height of the text field
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the <code>Appearance</code> that's values
	 *                       should be implemented on this text area
	 */
	public XTextArea(int x, int y, int width, int height, final XFrame frame, String appearanceName) {
		super(x, y, width, height, frame, appearanceName);
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

		if (this.appearance.getBackgrounds().size() >= 2) {
			lgp = new LinearGradientPaint(x, y, w, h, Util.calcEqualFracts(this.appearance.getBackgrounds().size()),
				this.appearance.getBackgroundsAsArray());

			g2D.setPaint(lgp);
		}
		else
			g2D.setColor(this.appearance.getBackgrounds().get(0));

		// Fill background
		g2D.fillRoundRect(x, y, w, h, r, r);
	}

	@Override
	public void paintForeground() {
	}

	@Override
	public void paintIcon() {
	}

	@Override
	public void paintBorder(int x, int y, int w, int h, int r, final Graphics2D g2D) {
		LinearGradientPaint lgp;

		if (this.appearance.getBorderModel().getThickness() != 0) {
			g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

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
