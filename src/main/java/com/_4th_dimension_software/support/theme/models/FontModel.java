package com._4th_dimension_software.support.theme.models;

/**
 * Stores font data read from the specified
 * color theme file by the <code>ColorThemeReader</code>.
 * These data are validated inside the constructor
 * so that the interpreter won't have to bother
 * checking every individual field of this class.
 *
 * @author szd
 */
public final class FontModel extends AbstractFontModel {
	/**
	 * Constructs a model of a font without
	 * any specified parameters. The fields are
	 * set to default values.
	 */
	public FontModel() {
	}

	/**
	 * Constructs a model of a font with the specified parameters.
	 * Every parameter is validated inside the constructor to make
	 * later tasks easier.
	 *
	 * @param source   The source of the font model (if it is custom font)
	 * @param family   The family of the font model (font family)
	 * @param ligature The ligature of the font model
	 * @param size     The size of the font model
	 */
	public FontModel(final String source, String family, String ligature, String size) {
		super(source, family, ligature, size);
	}
}
