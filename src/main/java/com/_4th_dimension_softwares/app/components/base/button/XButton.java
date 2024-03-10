package com._4th_dimension_softwares.app.components.base.button;

import java.awt.Dimension;
import java.awt.event.MouseEvent;

import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.framework.Appearance;

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
	 * similar to a <code>XButton</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param dimension      The Dimension of the button
	 * @param text           The text of the button
	 * @param frame          The main frame of the application
	 * @param type           The type of the button (<code>ButtonType.BACKGROUND_CHANGER, FOREGROUND_CHANGER, ICON_CHANGER</code>)
	 * @param appearanceName The name of the <code>Appearance</code> that's values
	 *                       should be implemented on this button
	 */
	public XButton(Dimension dimension, String text, XFrame frame, ButtonType type, String appearanceName) {
		super(dimension, text, frame, type, appearanceName);
	}

	/**
	 * Constructs an <code>XButton</code> object. This object is
	 * similar to a <code>XButton</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param dimension      The Dimension of the button
	 * @param frame          The main frame of the application
	 * @param type           The type of the button (<code>ButtonType.BACKGROUND_CHANGER, FOREGROUND_CHANGER, ICON_CHANGER</code>)
	 * @param appearanceName The name of the <code>Appearance</code> that's values
	 *                       should be implemented on this button
	 */
	public XButton(Dimension dimension, XFrame frame, ButtonType type, String appearanceName) {
		super(dimension, frame, type, appearanceName);
	}

	/**
	 * Constructs an <code>XButton</code> object. This object is
	 * similar to a <code>XButton</code> object, only this is much
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
	public XButton(int x, int y, int width, int height, String text, XFrame frame, ButtonType type, String appearanceName) {
		super(x, y, width, height, text, frame, type, appearanceName);
	}

	/**
	 * Constructs an <code>XButton</code> object. This object is
	 * similar to a <code>XButton</code> object, only this is much
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
	public XButton(int x, int y, int width, int height, XFrame frame, ButtonType type, String appearanceName) {
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
}
