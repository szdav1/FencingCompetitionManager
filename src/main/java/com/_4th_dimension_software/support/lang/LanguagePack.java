package com._4th_dimension_software.support.lang;

import java.util.HashMap;

/**
 * The <code>LanguagePack</code> class
 * stores language info for the application.
 * It can be initialized only once during the runtime
 * of the application.
 *
 * @author szd
 */
public final class LanguagePack {
	private static boolean initialized = false;
	private static HashMap<String, String> words;

	// Not instantiatable
	private LanguagePack() {
	}

	/**
	 * Initializes the <code>LanguagePack</code> for the runtime of the
	 * application. If it has been already initialized, a <code>RuntimeException</code>
	 * is thrown.
	 *
	 * @param words The <code>HashMap</code> that will be assigned to this class's <code>HashMap</code>
	 */
	public static void init(HashMap<String, String> words) {
		if (initialized)
			throw new RuntimeException("Language pack has benn already initialized.");

		LanguagePack.words = words;
		initialized = true;
	}

	/**
	 * Returns the appropriate word specified
	 * with the given key.
	 *
	 * @param key The key of the desired word
	 * @return The desired word
	 */
	public static String get(String key) {
		return words.get(key);
	}
}
