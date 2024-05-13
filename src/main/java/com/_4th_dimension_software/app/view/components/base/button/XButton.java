package com._4th_dimension_software.app.view.components.base.button;

import java.awt.Dimension;
import java.awt.event.MouseEvent;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.theme.Appearance;
import com._4th_dimension_software.support.util.Util;

/**
 * The <code>XButton</code> class is an extended representation
 * of swing's <code>JButton</code> class. It works similarly to
 * a <code>JButton</code>. It acts as a button, and it can change
 * its background, foreground or icon based on the type of action
 * occurring on the area of the button.
 *
 * @author szd
 */
public class XButton extends AbstractXButton {
	/**
	 * Constructs an <code>XButton</code> object. This object is
	 * similar to a <code>JButton</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param dimension       The Dimension of the button
	 * @param text            The text of the button
	 * @param shortcutKeyText The string representation of the shortcut key assigned to this button
	 * @param frame           The main frame of the application
	 * @param appearanceName  The name of the Appearance that's values
	 *                        should be implemented on this button
	 */
	public XButton(Dimension dimension, String text, String shortcutKeyText, final XFrame frame, String appearanceName) {
		super(dimension, text, shortcutKeyText, frame, appearanceName);
	}

	/**
	 * Constructs an <code>XButton</code> object. This object is
	 * similar to a <code>JButton</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param dimension      The Dimension of the button
	 * @param text           The text of the button
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that's values
	 *                       should be implemented on this button
	 */
	public XButton(Dimension dimension, String text, final XFrame frame, String appearanceName) {
		super(dimension, text, frame, appearanceName);
	}

	/**
	 * Constructs an <code>XButton</code> object. This object is
	 * similar to a <code>JButton</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param x               The X coordinate of the button in no-layout manager space
	 * @param y               The Y coordinate of the button in no-layout manager space
	 * @param width           The width of the button
	 * @param height          The height of the button
	 * @param text            The text of the button
	 * @param shortcutKeyText The string representation of the shortcut key assigned to this button
	 * @param frame           The main frame of the application
	 * @param appearanceName  The name of the Appearance that's values
	 *                        should be implemented on this button
	 */
	public XButton(int x, int y, int width, int height, String text, String shortcutKeyText, final XFrame frame, String appearanceName) {
		super(x, y, width, height, text, shortcutKeyText, frame, appearanceName);
	}

	/**
	 * Constructs an <code>XButton</code> object. This object is
	 * similar to a <code>JButton</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param x              The X coordinate of the button in no-layout manager space
	 * @param y              The Y coordinate of the button in no-layout manager space
	 * @param width          The width of the button
	 * @param height         The height of the button
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that's values
	 *                       should be implemented on this button
	 */
	public XButton(int x, int y, int width, int height, String text, final XFrame frame, String appearanceName) {
		super(x, y, width, height, text, frame, appearanceName);
	}

	/**
	 * Sets the text of the shortcut key label
	 * of this button to the specified text.
	 * This text does not equal to the actual shortcut key
	 * assigned to this button.
	 *
	 * @param shortcutKeyText The text representation of the shortcut key text
	 */
	public void setShortcutKeyText(String shortcutKeyText) {
		this.shortcutKeyLabel.setText(Util.surroundString(shortcutKeyText, "[", "]"));
	}

	/**
	 * Resets all states of the button.
	 */
	public void reset() {
		this.entered = false;
		this.pressed = false;
	}

	/**
	 * Adjusts the content of the button using
	 * the specified <code>position</code> value.
	 * <p>The valid values for position are:</p>
	 * <p><code>SwingConstants.LEFT</code></p>
	 * <p><code>SwingConstants.RIGHT</code></p>
	 * <p><code>SwingConstants.CENTER</code></p>
	 * <p><code>SwingConstants.LEADING</code></p>
	 * <p><code>SwingConstants.TRAILING</code></p>
	 *
	 * @param position The position of the content of the button
	 */
	public void adjustContent(int position) {
		this.setHorizontalAlignment(position);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.pressed = true;
		this.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.pressed = false;
		this.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.entered = true;
		this.repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.entered = false;
		this.repaint();
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
