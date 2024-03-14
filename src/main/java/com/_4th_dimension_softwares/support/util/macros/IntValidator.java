package com._4th_dimension_softwares.support.util.macros;

/**
 * The <code>IntValidator</code> is a functional interface
 * that is used to check if an integer fulfills
 * a certain condition. It is used to define return
 * values in the <code>Util</code> class's <code>toInt()</code> method based
 * on the return value of this interface's lambda
 * expression.
 */
@FunctionalInterface
public interface IntValidator {
	/**
	 * Checks if the specified integer fulfills
	 * a certain condition. This condition can
	 * be anything, as long as the return value
	 * of the expression is a boolean.
	 * e.g.: (i) -> i > 0 This expression will
	 * return true, if the specified integer is
	 * higher than 0, false if not.
	 *
	 * @param i The integer that should be checked
	 * @return True if the specified integer fulfills
	 * a certain condition, false otherwise
	 */
	boolean checkIntCorrectness(final int i);
}
