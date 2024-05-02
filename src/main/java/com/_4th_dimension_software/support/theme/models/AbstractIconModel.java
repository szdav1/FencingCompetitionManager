package com._4th_dimension_software.support.theme.models;

import javax.swing.ImageIcon;

import com._4th_dimension_software.support.util.Util;

public abstract class AbstractIconModel {
	protected ImageIcon icon;

	protected AbstractIconModel() {
		this.icon = null;
	}

	protected AbstractIconModel(final String source, String widthPercentage, String heightPercentage) {
		if (!source.isBlank())
			this.icon = Util.loadImageIcon(source, Util.toInt(widthPercentage, 3, (i) -> i > 0),
				Util.toInt(heightPercentage, 3, (i) -> i > 0));
		else
			this.icon = null;
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
