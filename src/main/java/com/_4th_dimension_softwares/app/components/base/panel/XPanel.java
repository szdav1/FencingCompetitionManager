package com._4th_dimension_softwares.app.components.base.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JComponent;

import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.consts.PositionConstants;
import com._4th_dimension_softwares.support.framework.Appearance;

/**
 * The <code>XPanel</code> class is an extended representation
 * of Swing's <code>JPanel</code> class. It works similarly to
 * <code>JPanel</code>. It acts as a container, it can have different
 * <code>LayoutManager</code>s.
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
 * Important
 * <p>For painting the background: <code>VALUE_RENDER_QUALITY</code></p>
 * <p>For painting the border: <code>VALUE_ANTIALIAS_ON</code></p>
 *
 * @author szd
 */
public class XPanel extends AbstractXPanel {
	/**
	 * Constructs an <code>XPanel</code> object. This object is
	 * similar to a <code>JPanel</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param dimension     The Dimension of the panel
	 * @param layoutManager The LayoutManager of the panel
	 * @param frame         The main frame of the Application
	 * @param appearance    The Appearance that's values should be
	 *                      implemented on this panel
	 */
	public XPanel(Dimension dimension, LayoutManager layoutManager, XFrame frame, Appearance appearance) {
		super(dimension, layoutManager, frame, appearance);
	}

	/**
	 * Constructs an <code>XPanel</code> object. This object is
	 * similar to a <code>JPanel</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param dimension  The Dimension of the panel
	 * @param frame      The main frame of the Application
	 * @param appearance The Appearance that's values should be
	 *                   implemented on this panel
	 */
	public XPanel(Dimension dimension, XFrame frame, Appearance appearance) {
		super(dimension, frame, appearance);
	}

	/**
	 * Constructs an <code>XPanel</code> object. This object is
	 * similar to a <code>JPanel</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param x             The X coordinate of the panel in no-layout manager space
	 * @param y             The Y coordinate of the panel in no-layout manager space
	 * @param width         The width of the panel
	 * @param height        The height of the panel
	 * @param layoutManager The LayoutManager of the panel
	 * @param frame         The main frame of the application
	 * @param appearance    The Appearance that's values should be
	 *                      implemented on this panel
	 */
	public XPanel(int x, int y, int width, int height, LayoutManager layoutManager, XFrame frame, Appearance appearance) {
		super(x, y, width, height, layoutManager, frame, appearance);
	}

	/**
	 * Constructs an <code>XPanel</code> object. This object is
	 * similar to a <code>JPanel</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param x          The X coordinate of the panel in no-layout manager space
	 * @param y          The Y coordinate of the panel in no-layout manager space
	 * @param width      The width of the panel
	 * @param height     The height of the panel
	 * @param frame      The main frame of the application
	 * @param appearance The Appearance that's values should be
	 *                   implemented on this panel
	 */
	public XPanel(int x, int y, int width, int height, XFrame frame, Appearance appearance) {
		super(x, y, width, height, frame, appearance);
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
	public void addComponent(JComponent component, PositionConstants positionConstants) {
		this.add(component, this.getLayout() instanceof BorderLayout ?
			positionConstants.getBorderLayoutPosition() :
			positionConstants.getLayoutLevel()
		);
	}

	@Override
	public void addComponent(JComponent component) {
		this.addComponent(component, this.getLayout() instanceof BorderLayout ?
			PositionConstants.CENTER_POSITION :
			PositionConstants.MID_POSITION
		);
	}

	@Override
	public JComponent removeComponent(JComponent component) {
		this.remove(component);

		return component;
	}
}
