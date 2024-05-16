package com._4th_dimension_software.support.theme.models;

import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.util.Util;

/**
 * The <code>AbstractBorderModel</code> stores and validates
 * border related data like color, thickness, and edge roundness. It
 * defines the abstract behaviour of border models inside the application.
 * These data are fed into this class's constructor by the <code>ColorThemeReader</code>.
 */
public abstract class AbstractBorderModel {
	protected ColorModel colorModel;
	protected int thickness;
	protected int roundness;

	/**
	 * Defines the base constructor of border models
	 * that initializes every field to a default value.
	 */
	protected AbstractBorderModel() {
		this.colorModel = new ColorModel();
		this.thickness = 0;
		this.roundness = 0;
	}

	/**
	 * Defines the base constructor of border models
	 * that initializes every field with the specified
	 * parameters.
	 *
	 * @param colorModelString The string representation of a color array
	 * @param thickness        The string representation of the border thickness
	 * @param roundness        The string representation of the border edge roundness
	 */
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
