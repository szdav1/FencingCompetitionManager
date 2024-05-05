package com._4th_dimension_software.support.consts;

/**
 * The <code>FrameState</code> enum contains
 * values that define certain
 */
public enum FrameState {
	NORMAL("normal"),
	PANEL_OPENED("panel opened");

	private final String state;

	FrameState(String state) {
		this.state = state;
	}

	/**
	 * Returns the string representation of the
	 * desired <code>FrameState</code> constant.
	 *
	 * @return The <code>String</code> assigned to the desired enum value
	 */
	public String state() {
		return this.state;
	}
}
