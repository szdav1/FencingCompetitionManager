package com._4th_dimension_software.support.theme.models;

import java.awt.Color;

import javax.swing.ImageIcon;

import com._4th_dimension_software.support.util.Util;

public abstract class AbstractIconModel {
	protected ImageIcon icon;

	protected AbstractIconModel() {
		this.icon = null;
	}

	protected AbstractIconModel(final String source, String widthPercentage, String heightPercentage) {
		if (!source.isBlank())
			this.icon = Util.loadImageIcon(source, Util.toInt(widthPercentage, 3, (i) -> i > 0), Util.toInt(heightPercentage, 3, (i) -> i > 0));
		else
			this.icon = null;
	}

	protected AbstractIconModel(final String source, String widthPercentage, String heightPercentage, String color) {
		int w = Util.toInt(widthPercentage, 3, (i) -> i > 0);
		int h = Util.toInt(heightPercentage, 3, (i) -> i > 0);

		if (!source.isBlank() && !color.isBlank()) {
			Color c = new ColorModel(color).getColors().get(0);

			this.icon = Util.loadImageIcon(source, w, h, c);
		}
		else
			this.icon = Util.loadImageIcon(source, w, h);
	}

	protected AbstractIconModel(String source) {
		this.icon = Util.loadImageIcon(source);
	}

	public ImageIcon getIcon() {
		return this.icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
}
