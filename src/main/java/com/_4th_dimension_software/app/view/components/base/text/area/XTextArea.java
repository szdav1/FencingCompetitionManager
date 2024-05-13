package com._4th_dimension_software.app.view.components.base.text.area;

import java.awt.Dimension;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.theme.Appearance;

/**
 * The <code>XTextArea</code> class is an extended representation
 * of swing's <code>JTextArea</code> class. It works similarly to
 * a <code>JTextArea</code>. It acts as an input area.
 *
 * @author szd
 */
public class XTextArea extends AbstractXTextArea {
	/**
	 * Constructs an <code>XTextArea</code> object. This object is
	 * similar to a <code>JTextArea</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param dimension      The Dimension of the text field
	 * @param text           The default text of the text field
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that's values
	 *                       should be implemented on this text area
	 */
	public XTextArea(Dimension dimension, String text, final XFrame frame, String appearanceName) {
		super(dimension, text, frame, appearanceName);
	}

	/**
	 * Constructs an <code>XTextArea</code> object. This object is
	 * similar to a <code>JTextArea</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param dimension      The Dimension of the text field
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that's values
	 *                       should be implemented on this text area
	 */
	public XTextArea(Dimension dimension, final XFrame frame, String appearanceName) {
		super(dimension, frame, appearanceName);
	}

	/**
	 * Constructs an <code>XTextArea</code> object. This object is
	 * similar to a <code>JTextArea</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param x              The X coordinate of the text field in no-layout manager space
	 * @param y              The Y coordinate of the text field in no-layout manager space
	 * @param width          The width of the text field
	 * @param height         The height of the text field
	 * @param text           The default text of the text field
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that's values
	 *                       should be implemented on this text area
	 */
	public XTextArea(int x, int y, int width, int height, String text, final XFrame frame, String appearanceName) {
		super(x, y, width, height, text, frame, appearanceName);
	}

	/**
	 * Constructs an <code>XTextArea</code> object. This object is
	 * similar to a <code>JTextArea</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param x              The X coordinate of the text field in no-layout manager space
	 * @param y              The Y coordinate of the text field in no-layout manager space
	 * @param width          The width of the text field
	 * @param height         The height of the text field
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that's values
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
}
