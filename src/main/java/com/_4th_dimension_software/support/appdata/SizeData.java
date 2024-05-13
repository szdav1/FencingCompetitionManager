package com._4th_dimension_software.support.appdata;

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

    // Proportional factor
    public static final int PROPORTIONALITY_FACTOR = Math.round((float) SCREEN_WIDTH/SCREEN_HEIGHT);

    // Font size
    public static final int FONT_SIZE = PROPORTIONALITY_FACTOR*7;
    public static final int BORDER_SIZE = PROPORTIONALITY_FACTOR;

    // Scroll bar size and Dimension
    // Vertical
    public static final int V_SCROLL_BAR_WIDTH = (int) (SCREEN_WIDTH*1.5f/100);
    public static final int V_SCROLL_BAR_HEIGHT = (int) (SCREEN_WIDTH*1.5f/100);
    public static final Dimension V_SCROLL_BAR_DIMENSION = new Dimension(V_SCROLL_BAR_WIDTH, V_SCROLL_BAR_HEIGHT);

    // Horizontal
    public static final int H_SCROLL_BAR_WIDTH = (int) (SCREEN_WIDTH*1.5f/100);
    public static final int H_SCROLL_BAR_HEIGHT = (int) (SCREEN_WIDTH*1.5f/100);
    public static final Dimension H_SCROLL_BAR_DIMENSION = new Dimension(H_SCROLL_BAR_WIDTH, H_SCROLL_BAR_HEIGHT);

    // Button size and dimension
    public static final int N_BUTTON_WIDTH = SCREEN_WIDTH*3/100;
    public static final int BUTTON_WIDTH = SCREEN_WIDTH*7/100;
    public static final int W_BUTTON_WIDTH = SCREEN_WIDTH*10/100;
    public static final int BUTTON_HEIGHT = SCREEN_HEIGHT*5/100;

    // Narrow button dimension
    public static final Dimension N_BUTTON_DIMENSION = new Dimension(N_BUTTON_WIDTH, BUTTON_HEIGHT);
    // Button button dimension
    public static final Dimension BUTTON_DIMENSION = new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT);
    // Wide button dimension
    public static final Dimension W_BUTTON_DIMENSION = new Dimension(W_BUTTON_WIDTH, BUTTON_HEIGHT);

    // Sidebar size and Dimension
    public static final int SIDEBAR_WIDTH = W_BUTTON_WIDTH;
    public static final int SIDEBAR_HEIGHT = SCREEN_HEIGHT;
    public static final Dimension SIDEBAR_DIMENSION = new Dimension(SIDEBAR_WIDTH, SIDEBAR_HEIGHT);

    // Dropdown panel size and dimension
    public static final int DROPDOWN_WIDTH = BUTTON_WIDTH;
    public static final int DROPDOWN_HEIGHT = BUTTON_HEIGHT*3;
    public static final Dimension DROPDOWN_DIMENSION = new Dimension(DROPDOWN_WIDTH, DROPDOWN_HEIGHT);

    // Separator line size and dimension
    public static final int SEPARATOR_WIDTH = W_BUTTON_WIDTH;
    public static final Dimension SEPARATOR_DIMENSION = new Dimension(SEPARATOR_WIDTH, BORDER_SIZE);

    // Text margin in buttons
    public static final int TEXT_MARGIN = PROPORTIONALITY_FACTOR*5;

    // Shortcut key label size and dimension
    public static final int SHORTCUT_KEY_LABEL_WIDTH = SCREEN_WIDTH*3/100;
    public static final Dimension SHORTCUT_KEY_LABEL_DIMENSION = new Dimension(SHORTCUT_KEY_LABEL_WIDTH, BUTTON_HEIGHT);

    // Editor size and dimension
    public static final int EDITOR_WIDTH = (SizeData.SCREEN_WIDTH-SizeData.SIDEBAR_WIDTH)*65/100;
    public static final int EDITOR_HEIGHT = SizeData.SCREEN_HEIGHT*65/100;
    public static final Dimension EDITOR_DIMENSION = new Dimension(EDITOR_WIDTH, EDITOR_HEIGHT);

    // Not instantiatable
    private SizeData() {
    }

    /**
     * Calculates the height of a dropdown panel
     * that contains the given amount of buttons.
     *
     * @param buttonQuantity The amount of buttons held by the dropdown panel
     * @return The new height of the dropdown panel
     */
    public static int calcDropdownHeight(int buttonQuantity) {
        return BUTTON_HEIGHT*buttonQuantity;
    }

    /**
     * Calculates the given percentage using the
     * <code>proportionality factor</code>.
     *
     * @param percentage The amount of percentage that should be calculated
     * @return The percentage of the width of the window
     */
    public static int calc(int percentage) {
        return PROPORTIONALITY_FACTOR*percentage;
    }
}
