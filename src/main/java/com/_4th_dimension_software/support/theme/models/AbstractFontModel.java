package com._4th_dimension_software.support.theme.models;

import java.awt.Font;

import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.util.Util;

/**
 * The <code>AbstractFontModel</code> stores and validates
 * font related data. It defines the abstract
 * behaviour of font models inside the application.
 * These data are fed into this class's constructor by the <code>ColorThemeReader</code>.
 */
public abstract class AbstractFontModel {
	protected String source;
	protected String family;
	protected int ligature;
	protected int size;

	/**
	 * Defines the base constructor of font models
	 * that initializes every field to a default value.
	 */
	protected AbstractFontModel() {
		this.source = "";
		this.family = "Arial";
		this.ligature = Font.PLAIN;
		this.size = SizeData.FONT_SIZE;
	}

	/**
	 * Defines the base constructor of font models
	 * that initializes every field with the specified parameter.
	 *
	 * @param source   The source of the custom font
	 * @param type     The string representation of the type of the font
	 * @param ligature The string representation of the ligature of the font
	 * @param size     The string representation of the size of the font
	 */
	protected AbstractFontModel(final String source, String type, String ligature, String size) {
		this.source = source;
		this.family = type;
		this.size = Util.toInt(size, SizeData.FONT_SIZE, (i) -> i > 0);

		if (this.size != SizeData.FONT_SIZE)
			this.size *= SizeData.PROPORTIONALITY_FACTOR;

		this.ligature = switch (ligature.toLowerCase()) {
			case "bold" -> Font.BOLD;
			case "italic" -> Font.ITALIC;
			default -> Font.PLAIN;
		};
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public int getLigature() {
		return this.ligature;
	}

	public void setLigature(int ligature) {
		this.ligature = ligature;
	}

	public int getSize() {
		return this.size != 0 ? this.size : SizeData.FONT_SIZE;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
