package com._4th_dimension_softwares.support.appdata;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * The SizeData class stores data related
 * to sizes and dimensions of components
 * and other UI elements.
 *
 * @author szd
 */
public final class SizeData {
	// Screen Dimension, width and height
	public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int SCREEN_WIDTH = SCREEN_SIZE.width;
	public static final int SCREEN_HEIGHT = SCREEN_SIZE.height;

	// Font size
	public static final int FONT_SIZE = SCREEN_WIDTH/130;
	public static final int BORDER_SIZE = 2;

	// Scroll bar size and Dimension
	public static final int V_SCROLL_BAR_WIDTH = 30;
	public static final int V_SCROLL_BAR_HEIGHT = 30;
	public static final Dimension V_SCROLL_BAR_DIMENSION = new Dimension(V_SCROLL_BAR_WIDTH, V_SCROLL_BAR_HEIGHT);

	public static final int H_SCROLL_BAR_WIDTH = 30;
	public static final int H_SCROLL_BAR_HEIGHT = 30;
	public static final Dimension H_SCROLL_BAR_DIMENSION = new Dimension(H_SCROLL_BAR_WIDTH, H_SCROLL_BAR_HEIGHT);

	// Sidebar size and Dimension
	public static final int SIDEBAR_WIDTH = SCREEN_WIDTH*5/100;
	public static final int SIDEBAR_HEIGHT = SCREEN_HEIGHT;
	public static final Dimension SIDEBAR_DIMENSION = new Dimension(SIDEBAR_WIDTH, SIDEBAR_HEIGHT);

	// Not instantiatable
	private SizeData() {
	}
}
