package com._4th_dimension_software.support.framework;

import java.awt.Color;

import com._4th_dimension_software.support.framework.models.ColorThemeModel;

/**
 * The <code>Appearance</code> class is a class that stores
 * every appearance related data in a specified format.
 * This is the last stage of the color theme interpretation.
 * Every data is received from a <code>ColorThemeModel</code>, and stored
 * in the corresponding way.
 * <p></p>
 * Custom components are stylized based on the
 * data stored by this class's fields. This class also
 * has methods that help working with <code>Graphics</code>, as some
 * fields do not have the corresponding type, but can be easily
 * converted to it.
 *
 * @author szd
 */
public final class Appearance extends AbstractAppearance {
	/**
	 * Constructs an <code>Appearance</code> object. This object
	 * stores information for component styling,
	 * and every field of the class represents a style
	 * element that can be implemented on the desired
	 * component. The fields are already validated when
	 * they get into this class.
	 */
	public Appearance() {
	}

	/**
	 * Constructs an <code>Appearance</code> object. This object
	 * stores information for component styling,
	 * and every field of the class represents a style
	 * element that can be implemented on the desired
	 * component. The fields are already validated when
	 * they get into this class.
	 *
	 * @param colorThemeModel The ColorThemeModel that should be converted to Appearance
	 */
	public Appearance(final ColorThemeModel colorThemeModel) {
		super(colorThemeModel);
	}

	/**
	 * Returns the summary value of the booleans
	 * in the borderPaintRules <code>HashMap</code>. If
	 * only one of the values is false, the return value is
	 * going to be false as well.
	 *
	 * @return The sum value of the contents of the borderPaintRules <code>HashMap</code>
	 */
	public boolean isBorderPainted() {
		return this.borderPaintRules.get("top") &&
			this.borderPaintRules.get("right") &&
			this.borderPaintRules.get("bottom") &&
			this.borderPaintRules.get("left");
	}

	/**
	 * Returns the summary value of the booleans
	 * in the borderPaintRules <code>HashMap</code>. If
	 * only one of the values is true, the return value is
	 * going to be true as well.
	 *
	 * @return The sum value of the contents of the borderPaintRules <code>HashMap</code>
	 */
	public boolean isBorderNotPainted() {
		return !this.borderPaintRules.get("top") &&
			!this.borderPaintRules.get("right") &&
			!this.borderPaintRules.get("bottom") &&
			!this.borderPaintRules.get("left");
	}

	/**
	 * Returns whether the specified section of the border
	 * should be painted or not.
	 *
	 * @param sectionName The name of the section of the border
	 * @return Whether the specified section should be painted or not
	 */
	public boolean isBorderSectionPainted(String sectionName) {
		if (!this.borderPaintRules.containsKey(sectionName))
			return true;

		return this.borderPaintRules.get(sectionName);
	}

	/**
	 * Converts the backgrounds <code>ArrayList</code> to an
	 * array that contains the same data as the ArrayList.
	 *
	 * @return The array representation of the backgrounds ArrayList
	 */
	public Color[] getBackgroundsAsArray() {
		Color[] colors = new Color[this.backgrounds.size()];

		for (int i = 0; i < this.backgrounds.size(); i++) {
			colors[i] = this.backgrounds.get(i);
		}

		return colors;
	}

	/**
	 * Converts the foregrounds <code>ArrayList</code> into an
	 * array that contains the same data as the ArrayList.
	 *
	 * @return The array representation of the foregrounds ArrayList
	 */
	public Color[] getForegroundsAsArray() {
		Color[] colors = new Color[this.foregrounds.size()];

		for (int i = 0; i < this.backgrounds.size(); i++) {
			colors[i] = this.backgrounds.get(i);
		}

		return colors;
	}

	/**
	 * Retrieves the colors of the <code>BorderModel</code>
	 * in a <code>Color</code> array.
	 *
	 * @return The array representation of the <code>BorderModel</code>'s
	 * color configuration
	 */
	public Color[] getBorderColorsAsArray() {
		Color[] colors = new Color[this.borderModel.getColorModel().getColors().size()];

		for (int i = 0; i < this.borderModel.getColorModel().getColors().size(); i++) {
			colors[i] = this.borderModel.getColorModel().getColors().get(i);
		}

		return colors;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Appearance a) {
			return this.borderPaintRules.equals(a.getBorderPaintRules()) &&
				this.linearPaint == a.isLinearPaint() &&
				this.backgrounds.equals(a.getBackgrounds()) &&
				this.foregrounds.equals(a.getForegrounds()) &&
				this.borderModel.equals(a.getBorderModel()) &&
				this.font.equals(a.getFont()) &&
				this.icon1.equals(a.getIcon1()) &&
				this.icon2.equals(a.getIcon2());
		}

		return false;
	}

	@Override
	public String toString() {
		return "Appearance{"+
			"linearPaint="+linearPaint+
			", borderPaintRules="+borderPaintRules+
			", backgrounds="+backgrounds+
			", foregrounds="+foregrounds+
			", borderModel="+borderModel+
			", font="+font+
			", icon1="+icon1+
			", icon2="+icon2+
			'}';
	}
}
