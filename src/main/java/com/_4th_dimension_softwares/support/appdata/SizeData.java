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
	public static final int FONT_SIZE = SCREEN_WIDTH/100;
	public static final int BORDER_SIZE = 2;

	// Not instantiatable
	private SizeData() {
	}
}
