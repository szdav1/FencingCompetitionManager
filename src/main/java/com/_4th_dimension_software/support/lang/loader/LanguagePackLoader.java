package com._4th_dimension_software.support.lang.loader;

import com._4th_dimension_software.support.lang.Language;
import com._4th_dimension_software.support.lang.reader.LanguagePackReader;

/**
 * The <code>LanguagePackLoader</code> class
 * loads the already read data into the <code>LanguagePack</code>
 * of the current runtime.
 *
 * @author szd
 */
public final class LanguagePackLoader {
	// Not instantiatable
	private LanguagePackLoader() {
	}

	/**
	 * Initializes the <code>LanguagePack</code> class
	 * for the runtime of the application and loads data
	 * from the specified language file.
	 *
	 * @param filePath The path of the language pack XML file
	 */
	public static void loadFromXML(final String filePath) {
		Language.init(LanguagePackReader.readFromXML(filePath));
	}
}
