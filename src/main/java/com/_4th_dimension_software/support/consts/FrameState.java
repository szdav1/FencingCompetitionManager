package com._4th_dimension_software.support.consts;

/**
 * The <code>FrameState</code> enum contains
 * values that define certain conditions of the main
 * frame of the application. These values can be used
 * to perform state specific tasks.
 *
 * @author szd
 */
public enum FrameState {
	/**
	 * Defines the normal state of the frame.
	 * This is set when nothing is opened.
	 */
	NORMAL("normal"),
	/**
	 * Defines the state when a panel is
	 * opened inside the frame.
	 */
	PANEL_OPENED("panel opened");

	private final String state;

	FrameState(final String state) {
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
