package com._4th_dimension_software.app.view.components.base.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JComponent;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.consts.PositionConstants;
import com._4th_dimension_software.support.theme.Appearance;

/**
 * The <code>XPanel</code> class is an extended representation
 * of Swing's <code>JPanel</code> class. It works similarly to
 * a <code>JPanel</code>. It acts as a container, it can have different
 * <code>LayoutManager</code>s and contain multiple other components.
 *
 * @author szd
 */
public class XPanel extends AbstractXPanel {
	/**
	 * Constructs an <code>XPanel</code> object. This object is
	 * similar to a <code>JPanel</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param dimension      The Dimension of the panel
	 * @param layoutManager  The LayoutManager of the panel
	 * @param frame          The main frame of the Application
	 * @param appearanceName The name of the Appearance that's values
	 *                       should be implemented on this panel
	 */
	public XPanel(Dimension dimension, LayoutManager layoutManager, final XFrame frame, String appearanceName) {
		super(dimension, layoutManager, frame, appearanceName);
	}

	/**
	 * Constructs an <code>XPanel</code> object. This object is
	 * similar to a <code>JPanel</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param dimension      The Dimension of the panel
	 * @param frame          The main frame of the Application
	 * @param appearanceName The name of the Appearance that's values
	 *                       should be implemented on this panel
	 */
	public XPanel(Dimension dimension, final XFrame frame, String appearanceName) {
		super(dimension, frame, appearanceName);
	}

	/**
	 * Constructs an <code>XPanel</code> object. This object is
	 * similar to a <code>JPanel</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param x              The X coordinate of the panel in no-layout manager space
	 * @param y              The Y coordinate of the panel in no-layout manager space
	 * @param width          The width of the panel
	 * @param height         The height of the panel
	 * @param layoutManager  The LayoutManager of the panel
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that's values
	 *                       should be implemented on this panel
	 */
	public XPanel(int x, int y, int width, int height, LayoutManager layoutManager, final XFrame frame, String appearanceName) {
		super(x, y, width, height, layoutManager, frame, appearanceName);
	}

	/**
	 * Constructs an <code>XPanel</code> object. This object is
	 * similar to a <code>JPanel</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param x              The X coordinate of the panel in no-layout manager space
	 * @param y              The Y coordinate of the panel in no-layout manager space
	 * @param width          The width of the panel
	 * @param height         The height of the panel
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that's values
	 *                       should be implemented on this panel
	 */
	public XPanel(int x, int y, int width, int height, final XFrame frame, String appearanceName) {
		super(x, y, width, height, frame, appearanceName);
	}

	/**
	 * Sets the alignment of the currently used <code>FlowLayout</code>.
	 * This method will only work if the layout manager of the container
	 * is an instance of the <code>FlowLayout</code> class. The valid
	 * options are:
	 * <p><code>FlowLayout.LEADING</code></p>
	 * <p><code>FlowLayout.CENTER</code></p>
	 * <p><code>FlowLayout.TRAILING</code></p>
	 * <p><code>FlowLayout.LEFT</code></p>
	 * <p><code>FlowLayout.RIGHT</code></p>
	 *
	 * @param alignment One of the valid constants defined int the <code>FlowLayout</code> class
	 */
	public void setFlowAlignment(int alignment) {
		if (this.getLayout() instanceof FlowLayout fl)
			fl.setAlignment(alignment);
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
	public void addComponent(final JComponent component, PositionConstants positionConstants) {
		this.add(component, this.getLayout() instanceof BorderLayout ?
			positionConstants.borderLayoutPosition() :
			positionConstants.layoutLevel()
		);
		this.repaintFrame();
		this.revalidate();
	}

	@Override
	public void addComponent(final JComponent component) {
		this.addComponent(component, this.getLayout() instanceof BorderLayout ?
			PositionConstants.CENTER_POSITION :
			PositionConstants.MID_POSITION
		);
		this.repaintFrame();
		this.revalidate();
	}

	@Override
	public JComponent removeComponent(final JComponent component) {
		this.remove(component);
		this.repaintFrame();
		this.revalidate();

		return component;
	}
}
