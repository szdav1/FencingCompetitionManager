package com._4th_dimension_software.support.util;

import java.io.FileReader;
import java.net.URL;

/**
 * The <code>Resources</code> class holds a method
 * that is a shortcut for getting resources.
 *
 * @author szd
 */
public final class ResourceHandler {
	// Not instantiatable
	private ResourceHandler() {
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
	 * <code>NullPointerException</code>. However, this exception does not
	 * interrupt the running of the application. An empty <code>String</code>
	 * is returned if the resource can not be found.
	 *
	 * @param filePath The path of the desired file starting from resources
	 * @return The full path of the desired file
	 */
	public static String get(final String filePath) {
		URL fileURL = ResourceHandler.class.getResource(filePath);

		if (fileURL == null)
			return "";

		try (FileReader fr = new FileReader(fileURL.getFile())) {
			return fileURL.getFile();
		}
		catch (Exception exc) {
			return "resources"+filePath;
		}
	}
}
