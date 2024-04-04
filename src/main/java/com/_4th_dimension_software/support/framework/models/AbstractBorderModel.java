package com._4th_dimension_software.support.framework.models;

import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.util.Util;

public abstract class AbstractBorderModel {
	protected ColorModel colorModel;
	protected int thickness;
	protected int roundness;

	protected AbstractBorderModel() {
		this.colorModel = new ColorModel();
		this.thickness = 0;
		this.roundness = 0;
	}

	protected AbstractBorderModel(String colorModelString, String thickness, String roundness) {
		this.colorModel = new ColorModel(colorModelString);
		this.roundness = Util.toInt(roundness, 0, (i) -> i > 0);

		if (thickness.isBlank())
			this.thickness = 0;
		else
			this.thickness = Util.toInt(thickness, SizeData.BORDER_SIZE, (i) -> i >= 0);
	}

	public ColorModel getColorModel() {
		return this.colorModel;
	}

	public void setColorModel(String colorModelString) {
		this.colorModel = new ColorModel(colorModelString);
	}

	public int getThickness() {
		return this.thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	public int getRoundness() {
		return this.roundness;
	}

	public void setRoundness(int roundness) {
		this.roundness = roundness;
	}
}
