package com._4th_dimension_softwares.app.components.interfaces;

import java.awt.Graphics2D;

/**
 * The <code>CustomGraphicsUser</code> declares methods for
 * components that use custom graphics. These methods are the
 * basic and necessary painting steps: background, foreground, icon,
 * border. The methods might not be identical in different components,
 * some components might not even need all of these methods (e.g.: a panel
 * will never paint foreground).
 *
 * @author szd
 */
public interface CustomGraphicsUser {
	/**
	 * Paints the background based on the specified values.
	 * The paint starts at the x and y, and goes to w (width) and h (height).
	 * r is the value of roundness that should be implemented, and the g2D object
	 * is the <code>Graphics2D</code> object that is currently in use.
	 *
	 * @param x   The starting coordinate of the paint on the X axis
	 * @param y   The starting coordinate of the paint on the Y axis
	 * @param w   The end coordinate of the paint on the X axis
	 * @param h   The end coordinate of the paint on the Y axis
	 * @param r   The roundness of the edges
	 * @param g2D The currently used <code>Graphics2D</code> object
	 */
	void paintBackground(int x, int y, int w, int h, int r, final Graphics2D g2D);

	/**
	 * Paints the foreground based on the values
	 * in the specified <code>Appearance</code>.
	 */
	void paintForeground();

	/**
	 * Paints the icon based on the values
	 * in the specified <code>Appearance</code>.
	 */
	void paintIcon();

	/**
	 * Paints the border based on the specified values.
	 * The paint starts at the x and y, and goes to w (width) and h (height).
	 * r is the value of roundness that should be implemented, and the g2D object
	 * is the <code>Graphics2D</code> object that is currently in use.
	 *
	 * @param x   The starting coordinate of the paint on the X axis
	 * @param y   The starting coordinate of the paint on the Y axis
	 * @param w   The end coordinate of the paint on the X axis
	 * @param h   The end coordinate of the paint on the Y axis
	 * @param r   The roundness of the edges
	 * @param g2D The currently used <code>Graphics2D</code> object
	 */
	void paintBorder(int x, int y, int w, int h, int r, final Graphics2D g2D);
}
