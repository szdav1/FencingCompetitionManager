package com._4th_dimension_software.support.theme.models;

import java.awt.Font;

import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.util.Util;

public abstract class AbstractFontModel {
	protected String source;
	protected String family;
	protected int ligature;
	protected int size;

	protected AbstractFontModel() {
		this.source = "";
		this.family = "Arial";
		this.ligature = Font.PLAIN;
		this.size = SizeData.FONT_SIZE;
	}

	protected AbstractFontModel(final String source, String type, String ligature, String size) {
		this.source = source;
		this.family = type;
		this.size = Util.toInt(size, SizeData.FONT_SIZE, (i) -> i > 0);

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
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
