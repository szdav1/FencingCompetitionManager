package com._4th_dimension_software.app.view.components.base.label;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.theme.Appearance;

/**
 * The <code>XLabel</code> class is an extended representation
 * of swing's <code>JLabel</code> class. It works similarly to
 * a <code>JLabel</code>. It acts as a label, and it can display
 * text, icon or both at the same time.
 *
 * @author szd
 */
public class XLabel extends AbstractXLabel {
	/**
	 * Constructs an <code>XLabel</code> object. This object is
	 * similar to a <code>JLabel</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param dimension      The Dimension of the label
	 * @param text           The text of the label
	 * @param frame          The main frame of the Application
	 * @param appearanceName The name of the Appearance that's values
	 *                       should be implemented on this label
	 */
	public XLabel(Dimension dimension, String text, final XFrame frame, String appearanceName) {
		super(dimension, text, frame, appearanceName);
	}

	/**
	 * Constructs an <code>XLabel</code> object. This object is
	 * similar to a <code>JLabel</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param x              The X coordinate of the label in no-layout manager space
	 * @param y              The Y coordinate of the label in no-layout manager space
	 * @param width          The width of the label
	 * @param height         The height of the label
	 * @param text           The text of the label
	 * @param frame          The main frame of the Application
	 * @param appearanceName The name of the Appearance that's values
	 *                       should be implemented on this label
	 */
	public XLabel(int x, int y, int width, int height, String text, final XFrame frame, String appearanceName) {
		super(x, y, width, height, text, frame, appearanceName);
	}

	/**
	 * Centers the content of the label horizontally and vertically.
	 * This method is a shortcut to the default <code>setHorizontalAlignment()</code>
	 * called with <code>SwingConstants.CENTER</code> passed into it and
	 * the <code>setVerticalAlignment()</code> called with <code>SwingConstants.CENTER</code>
	 * passed into it.
	 */
	public void centerContent() {
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setVerticalAlignment(SwingConstants.CENTER);
	}

	/**
	 * Sets the specified margin of the label.
	 * The margin is set by using an <code>EmptyBorder</code>
	 * object with the specified <code>Insets</code>.
	 *
	 * @param insets The dimensions of the margin
	 */
	public void setMargin(Insets insets) {
		this.setBorder(new EmptyBorder(insets));
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
