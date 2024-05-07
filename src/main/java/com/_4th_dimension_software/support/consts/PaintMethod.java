package com._4th_dimension_software.support.consts;

/**
 * The <code>PaintMethod</code> enum defines
 * the two possible painting methods that can be used
 * during the graphical composing of a component.
 * <p>The two methods are:</p>
 * <p><code>GRADIENT</code></p>
 * <p><code>SINGLE_COLOR</code></p>
 *
 * @author szd
 */
public enum PaintMethod {
	/**
	 * Defines the gradient painting method.
	 */
	GRADIENT("gradient"),
	/**
	 * Defines the single color painting method.
	 */
	SINGLE_COLOR("single_color");

	private final String methodName;

	PaintMethod(String methodName) {
		this.methodName = methodName;
	}

	/**
	 * Returns the name of the painting method.
	 *
	 * @return The name of the painting method represented as a <code>String</code>
	 */
	public String methodName() {
		return this.methodName;
	}
}
