package com._4th_dimension_softwares.support.consts;

import java.awt.BorderLayout;

/**
 * Defines position constants for component
 * placement. These constants are used when
 * a component is being placed on a container.
 * For the BorderLayout layout manager class the
 * valid parameters for placing a component are
 * redefined in this enum.
 *
 * @author szd
 */
public enum PositionConstants {
    /**
     * Defines the highest position a component
     * can be placed on by using this enum's constants. (10)
     */
    HIGH_POSITION(10),
    /**
     * Defines the middle position a component
     * can be placed on by using this enum's constants. (5)
     */
    MID_POSITION(5),
    /**
     * Defines the lowest position a component
     * can be placed on using this enum's constants. (1)
     */
    LOW_POSITION(1),
    /**
     * Defines the position of backgrounds (images).
     * This position is the lowest possible position
     * this enum can provide. (0)
     */
    BACKGROUND_POSITION(0),

    /**
     * Redefines the NORTH value of the
     * BorderLayout layout manager.
     */
    TOP_POSITION("North"),
    /**
     * Redefines the CENTER value of the
     * BorderLayout layout manager.
     */
    CENTER_POSITION("Center"),
    /**
     * Redefines the SOUTH value of the
     * BorderLayout layout manager.
     */
    BOTTOM_POSITION("South"),
    /**
     * Redefines the EAST value of the
     * BorderLayout layout manager.
     */
    RIGHT_POSITION("East"),
    /**
     * Redefines the WEST value of the
     * BorderLayout layout manager.
     */
    LEFT_POSITION("West");

    private final Integer layoutLevel;

    private final String borderLayoutPosition;

    PositionConstants(Integer layoutLevel) {
        this.layoutLevel = layoutLevel;
        this.borderLayoutPosition = "";
    }

    PositionConstants(String borderLayoutPosition) {
        this.layoutLevel = 0;
        this.borderLayoutPosition = borderLayoutPosition;
    }

    /**
     * Gets the specified layout level (Z coordinate)
     * associated with the desired constant.
     *
     * @return The layout level (Z coordinate) of the desired constant
     */
    public Integer getLayoutLevel() {
        return this.layoutLevel;
    }

	/**
	 * Gets the specified border layout position
	 * associated with the desired constant.
	 *
	 * @return The border layout position of the desired constant
	 */
    public String getBorderLayoutPosition() {
        return this.borderLayoutPosition;
    }
}