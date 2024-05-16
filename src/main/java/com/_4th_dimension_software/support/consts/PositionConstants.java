package com._4th_dimension_software.support.consts;

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
	 * Redefines the <code>NORTH</code> value of the
	 * BorderLayout layout manager.
	 */
	TOP_POSITION("North"),
	/**
	 * Redefines the <code>CENTER</code> value of the
	 * BorderLayout layout manager.
	 */
	CENTER_POSITION("Center"),
	/**
	 * Redefines the <code>SOUTH</code> value of the
	 * BorderLayout layout manager.
	 */
	BOTTOM_POSITION("South"),
	/**
	 * Redefines the <code>EAST</code> value of the
	 * BorderLayout layout manager.
	 */
	RIGHT_POSITION("East"),
	/**
	 * Redefines the <code>WEST</code> value of the
	 * BorderLayout layout manager.
	 */
	LEFT_POSITION("West");

	private final Integer layoutLevel;
	private final String borderLayoutPosition;

	PositionConstants(Integer layoutLevel) {
		this.layoutLevel = layoutLevel;
		this.borderLayoutPosition = "Center";
	}

	PositionConstants(String borderLayoutPosition) {
		this.layoutLevel = 5;
		this.borderLayoutPosition = borderLayoutPosition;
	}

	/**
	 * Returns the specified layout level (Z coordinate)
	 * associated with the desired constant.
	 *
	 * @return The layout level (Z coordinate) of the desired constant
	 */
	public Integer layoutLevel() {
		return this.layoutLevel;
	}

	/**
	 * Returns the specified border layout position
	 * associated with the desired constant.
	 *
	 * @return The border layout position of the desired constant
	 */
	public String borderLayoutPosition() {
		return this.borderLayoutPosition;
	}
}