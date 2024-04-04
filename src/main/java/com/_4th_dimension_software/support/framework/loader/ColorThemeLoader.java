package com._4th_dimension_software.support.framework.loader;

import java.util.HashMap;

import com._4th_dimension_software.support.framework.reader.ColorThemeReader;
import com._4th_dimension_software.support.framework.Appearance;
import com._4th_dimension_software.support.framework.Appearances;

/**
 * The <code>ColorThemeLoader</code> converts every
 * <code>ColorThemeModel</code> into <code>Appearances</code>. Every <code>Appearance</code>
 * is put into a <code>HashMap</code> with the corresponding key,
 * and returned at the end of the process.
 *
 * @author szd
 */
public final class ColorThemeLoader {
	// Not instantiatable
	private ColorThemeLoader() {
	}

	/**
	 * Converts every <code>ColorThemeModel</code> that was constructed during
	 * the reading procedure to <code>Appearance</code>s. <code>Appearance</code>s are simplified
	 * and validated representations of the data read from the specified
	 * color theme file by the <code>ColorThemeReader</code>.
	 * After the conversion step is completed, the <code>Appearances</code> class's init()
	 * method is called, and the <code>Appearance</code>s are put into its <code>HashMap</code>.
	 * Every <code>Appearance</code> is accessible from that class only, but they can
	 * only be read, not updated.
	 *
	 * @param filePath The path or name of the desired XML file that contains
	 *                 the color theme data
	 */
	public static void loadFromXML(final String filePath) {
		HashMap<String, Appearance> appearances = new HashMap<>();

		ColorThemeReader.readFromXML(filePath)
			.forEach((compName, ctm) -> appearances.put(compName, new Appearance(ctm)));

		Appearances.init(appearances);
	}
}
