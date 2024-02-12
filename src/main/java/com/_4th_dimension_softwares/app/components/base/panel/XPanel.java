package com._4th_dimension_softwares.app.components.base.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JComponent;

import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.consts.PositionConstants;
import com._4th_dimension_softwares.support.framework.Appearance;

/**
 * The XPanel class is an extended representation
 * of Swing's <code>JPanel</code> class. It works similarly to
 * JPanel. It acts as a container, it can have different
 * <code>LayoutManager</code>s.
 * <p/>
 * The extended means that just by passing in an Appearance
 * object to the constructor, this panel will be stylized
 * according to that Appearance. This saves the work with
 * Graphics and Graphics2D and makes creating beautiful
 * container panels easy and fast.
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
	 * @param layoutManager The LayoutManager of the panel
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
