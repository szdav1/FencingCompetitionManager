package com._4th_dimension_software.app.view.components.base.button;

/**
 * Defines the type of buttons that can be used in
 * the application. These types define the action
 * type that should be done when an action occurs.
 * These actions happen in the <code>UI</code>, when:
 * <p>The button is hovered: <code>MouseListener.mouseEntered()</code></p>
 * <p>The button's area is exited: <code>MouseListener.mouseExited()</code></p>
 * <p>The button is clicked: <code>MouseListener.mouseClicked()</code></p>
 * <p>The button is pressed: <code>MouseListener.mousePressed()</code></p>
 * <p>The button is released: <code>MouseListener.mouseReleased()</code>.</p>
 * When any of these actions happen, depending on the type of the button
 * the: <code>background</code>, <code>foreground</code> or the <code>icon</code>
 * of the button changes.
 * <p><code>BACKGROUND_CHANGER</code> - Changes the background</p>
 * <p><code>FOREGROUND_CHANGER</code> - Changes the foreground</p>
 * <p><code>ICON_CHANGER</code> - Changes the icon</p>
 *
 * @author szd
 */
public enum ButtonType {
	/**
	 * Defines a background changer button.
	 * If a mouse action occurs on the button,
	 * the background of the button changes
	 * to the color specified in its <code>Appearance</code>.
	 */
	BACKGROUND_CHANGER,
	/**
	 * Defines a foreground changer button.
	 * If a mouse action occurs on the button,
	 * the foreground of the button changes
	 * to the color specified in its <code>Appearance</code>.
	 */
	FOREGROUND_CHANGER,
	/**
	 * Defines an icon changer button.
	 * If a mouse action occurs on the button,
	 * the icon of the button changes
	 * to the icon specified in its <code>Appearance</code>.
	 */
	ICON_CHANGER;
}
