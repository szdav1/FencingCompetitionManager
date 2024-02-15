package com._4th_dimension_softwares.support.framework.models;

import javax.swing.ImageIcon;

import com._4th_dimension_softwares.support.util.Resources;
import com._4th_dimension_softwares.support.util.Util;

public abstract class AbstractIconModel {
	protected ImageIcon icon;

	protected AbstractIconModel() {
		this.icon = null;
	}

	protected AbstractIconModel(String source, String widthPercentage, String heightPercentage) {
		if (!source.isBlank())
			this.icon = Util.loadImageIcon(Resources.get(source), Util.toInt(widthPercentage, 100, (i) -> i > 0), Util.toInt(heightPercentage, 100, (i) -> i > 0));
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
