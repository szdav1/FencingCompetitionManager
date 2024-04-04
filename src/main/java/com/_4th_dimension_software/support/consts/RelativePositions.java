package com._4th_dimension_software.support.consts;

/**
 * The <code>RelativePositions</code> enum declares
 * constants that tell a <code>MenuButton</code> object
 * the relative position of their dropdown panel. The positions
 * are relative to the <code>MenuButton</code> itself.
 */
public enum RelativePositions {
	/**
	 * The top position relative to the
	 * <code>MenuButton</code>.
	 */
	ON_TOP("top"),
	/**
	 * The right position relative to the
	 * <code>MenuButton</code>.
	 */
	TO_RIGHT("right"),
	/**
	 * The bottom position relative to the
	 * <code>MenuButton</code>.
	 */
	AT_BOTTOM("bottom"),
	/**
	 * The left position relative to the
	 * <code>MenuButton</code>.
	 */
	TO_LEFT("left");

	private final String relativePosition;

	RelativePositions(String relativePosition) {
		this.relativePosition = relativePosition;
	}

	/**
	 * Returns the <code>String</code> value of the
	 * desired constant.
	 *
	 * @return The <code>String</code> representation of the constant
	 */
	public String relativePosition() {
		return this.relativePosition;
	}
}
