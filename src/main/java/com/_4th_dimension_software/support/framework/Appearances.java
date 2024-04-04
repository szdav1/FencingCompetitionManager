package com._4th_dimension_software.support.framework;

import java.util.HashMap;

/**
 * The <code>Appearances</code> class
 * stores every <code>Appearance</code> of the application
 * in a <code>Map</code> structure. The <code>Appearance</code>s can be
 * only retrieved, but not updated.
 *
 * @author szd
 */
public final class Appearances {
	private static boolean initialized = false;
	private static HashMap<String, Appearance> values;

	/**
	 * Initializes the <code>Appearances</code> <code>HashMap</code>.
	 * This process can be done only once during the lifetime
	 * of the application.
	 *
	 * @param appearances The <code>HashMap</code> provided by the <code>ColorThemeProcessor</code>
	 */
	public static void init(final HashMap<String, Appearance> appearances) {
		if (!initialized && !appearances.isEmpty()) {
			values = appearances;
			initialized = true;
		}
	}

	/**
	 * Retrieves the desired <code>Appearance</code> based on the
	 * specified key (componentName).
	 *
	 * @param componentName The name of the component the <code>Appearance</code> is related for
	 * @return The <code>Appearance</code> that is related to the specified component
	 * @throws RuntimeException If the <code>Appearance</code>s haven't been initialized before
	 *                          calling this method
	 */
	public static Appearance get(final String componentName) {
		if (!initialized)
			throw new RuntimeException("Appearances haven't been initialized");

		Appearance a = values.get(componentName);

		return a == null ? new Appearance() : a;
	}
}
