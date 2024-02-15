package com._4th_dimension_softwares.support.util;

import java.net.URL;
import java.util.Objects;

/**
 * The <code>Resources</code> class holds a method
 * that is a shortcut for getting resources.
 *
 * @author szd
 */
public final class Resources {
	// Not instantiatable
	private Resources() {
	}

	/**
	 * Tries to get the specified file in the module's
	 * resource folder if there's one. If the resources folder
	 * is missing or the specified file path is incorrect,
	 * the method will fail due to a <code>NullPointerException</code>.
	 * If the path of the desired file was typed in incorrectly, like
	 * the "/" is missing from the beginning, the method will try to
	 * query the resources with appending a backslash at the beginning.
	 * However, if this fails too, the method will fail with a
	 * <code>NullPointerException</code>.
	 *
	 * @param filePath The path of the desired file starting from resources
	 * @return The full path of the desired file
	 */
	public static String get(String filePath) {
		URL fileURL = Resources.class.getResource(filePath);

		return fileURL == null ?
			Objects.requireNonNull(Resources.class.getResource("/".concat(filePath)).getFile()) :
			fileURL.getFile();
	}
}
