package com._4th_dimension_softwares.app.components.base.label;

import java.awt.Dimension;

import javax.swing.SwingConstants;

import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.framework.Appearance;

/**
 * The XLabel class is an extended representation
 * of Swing's <code>JLabel</code> class. It works similarly to
 * <code>JLabel</code>. It can contain text and an icon.
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
public class XLabel extends AbstractXLabel {
	/**
	 * Constructs an XLabel object. This object is
	 * similar to a <code>JLabel</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param dimension  The Dimension of the label
	 * @param text       The text of the label
	 * @param frame      The main frame of the Application
	 * @param appearance The <code>Appearance</code> that's values
	 *                   should be implemented on this label
	 */
	public XLabel(Dimension dimension, String text, XFrame frame, Appearance appearance) {
		super(dimension, text, frame, appearance);
	}

	/**
	 * Constructs an XLabel object. This object is
	 * similar to a <code>JLabel</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param x          The X coordinate of the label in no-layout manager space
	 * @param y          The Y coordinate of the label in no-layout manager space
	 * @param width      The width of the label
	 * @param height     The height of the label
	 * @param text       The text of the label
	 * @param frame      The main frame of the Application
	 * @param appearance The <code>Appearance</code> that's values
	 *                   should be implemented on this label
	 */
	public XLabel(int x, int y, int width, int height, String text, XFrame frame, Appearance appearance) {
		super(x, y, width, height, text, frame, appearance);
	}

	public void centerContent() {
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setVerticalAlignment(SwingConstants.CENTER);
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
}
