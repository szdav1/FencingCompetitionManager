package com._4th_dimension_softwares.support.framework.models;

/**
 * Stores data about a border read
 * from the specified color theme file by
 * the <code>ColorThemeReader</code>. Every passed in value
 * is validated inside the constructor so that the
 * interpreter won't have to bother checking every
 * individual field of this class.
 *
 * @author szd
 */
public final class BorderModel extends AbstractBorderModel {
	/**
	 * Instantiates a model of a border
	 * without any specified parameters.
	 */
	public BorderModel() {
	}

	/**
	 * Constructs a model of a border
	 * based on the specified data. Every
	 * individual data is validated inside the
	 * constructor, so that the interpreter won't
	 * have to bother checking every field of this
	 * class for errors or mistypes.
	 *
	 * @param colorModelString The color model of the border model
	 * @param thickness        The thickness of the border model
	 * @param roundness        The roundness of the border model
	 */
	public BorderModel(String colorModelString, String thickness, String roundness) {
		super(colorModelString, thickness, roundness);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BorderModel bm) {
			return this.colorModel.equals(bm.getColorModel()) &&
				this.thickness == bm.getThickness() &&
				this.roundness == bm.getRoundness();
		}

		return false;
	}

	@Override
	public String toString() {
		return "BorderModel{"+
			"colorModel="+colorModel+
			", thickness="+thickness+
			", roundness="+roundness+
			'}';
	}
}
