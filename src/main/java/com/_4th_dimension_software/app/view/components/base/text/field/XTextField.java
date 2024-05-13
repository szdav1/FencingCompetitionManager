package com._4th_dimension_software.app.view.components.base.text.field;

import java.awt.Dimension;

import javax.swing.JTextField;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.theme.Appearance;

/**
 * The XTextField class is an extended representation
 * of Swing's <code>JTextField</code> class. It works similarly to
 * a <code>JTextField</code>. It acts as an input field.
 *
 * @author szd
 */
public class XTextField extends AbstractXTextField {
	/**
	 * Constructs an <code>XTextField</code> object. This object is
	 * similar to a <code>JTextField</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param dimension      The Dimension of the text field
	 * @param text           The default text of the text field
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that's values
	 *                       should be implemented on this text field
	 */
	public XTextField(Dimension dimension, String text, final XFrame frame, String appearanceName) {
		super(dimension, text, frame, appearanceName);
	}

	/**
	 * Constructs an <code>XTextField</code> object. This object is
	 * similar to a <code>JTextField</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param dimension      The Dimension of the text field
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that's values
	 *                       should be implemented on this text field
	 */
	public XTextField(Dimension dimension, final XFrame frame, String appearanceName) {
		super(dimension, frame, appearanceName);
	}

	/**
	 * Constructs an <code>XTextField</code> object. This object is
	 * similar to a <code>JTextField</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param x              The X coordinate of the text field in no-layout manager space
	 * @param y              The Y coordinate of the text field in no-layout manager space
	 * @param width          The width of the text field
	 * @param height         The height of the text field
	 * @param text           The default text of the text field
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that's values
	 *                       should be implemented on this text field
	 */
	public XTextField(int x, int y, int width, int height, String text, final XFrame frame, String appearanceName) {
		super(x, y, width, height, text, frame, appearanceName);
	}

	/**
	 * Constructs an <code>XTextField</code> object. This object is
	 * similar to a <code>JTextField</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param x              The X coordinate of the text field in no-layout manager space
	 * @param y              The Y coordinate of the text field in no-layout manager space
	 * @param width          The width of the text field
	 * @param height         The height of the text field
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that's values
	 *                       should be implemented on this text field
	 */
	public XTextField(int x, int y, int width, int height, final XFrame frame, String appearanceName) {
		super(x, y, width, height, frame, appearanceName);
	}

	/**
	 * Centers the content of the text field horizontally.
	 * This method is a shortcut to the default <code>setHorizontalAlignment()</code>
	 * called with <code>JTextField.CENTER</code> passed into it.
	 */
	public void centerContent() {
		this.setHorizontalAlignment(JTextField.CENTER);
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
