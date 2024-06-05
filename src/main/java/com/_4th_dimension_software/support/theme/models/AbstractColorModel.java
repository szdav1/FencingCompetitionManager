package com._4th_dimension_software.support.theme.models;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com._4th_dimension_software.support.theme.definitions.ColorDefinitions;
import com._4th_dimension_software.support.util.Util;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The <code>AbstractColorModel</code> stores and validates
 * color related data. It handles the parsing of color arrays
 * defined inside the color theme file. It defines the abstract
 * behaviour of color models inside the application.
 * These data are fed into this class's constructor by the <code>ColorThemeReader</code>.
 */
@ToString
@EqualsAndHashCode
public abstract class AbstractColorModel {
	protected List<Color> colors;

	/**
	 * Defines the base constructor of color models
	 * that initializes every field to a default value.
	 */
	protected AbstractColorModel() {
		this.colors = new ArrayList<>();
		this.colors.add(Color.black);
	}

	/**
	 * Defines the base constructor of border models
	 * that initializes every field with the specified parameter.
	 *
	 * @param line The line in the color theme document that has the color array
	 */
	protected AbstractColorModel(String line) {
		this.colors = turnStringToColorList(line);
	}

	/**
	 * Tries to transform the specified string into a color array
	 * that's items are put into the color list.
	 *
	 * @param str The string that should be turned into a color array
	 */
	public static List<Color> turnStringToColorList(final String str) {
		int c = 1;
		boolean isDefinition = false;
		List<Integer> tempList = new ArrayList<>();
		List<Color> colors = new ArrayList<>();

		// If the value given is blank, a black color is used
		if (str.isBlank())
			colors.add(Color.black);

		// Interpretation
		else {
			String[] values = str
				.replaceAll(" ", "")
				.replaceAll("\t", "")
				.replaceAll("\n", "")
				.split("]\\[");

			for (String value : values) {
				tempList.clear();
				// Remove unnecessary characters and split to get the color values
				String[] nums = value.replaceAll("\\[", "")
					.replaceAll("]", "")
					.split(",");

				for (String num : nums) {
					if (num.startsWith("@")) {
						colors.addAll(ColorDefinitions.get(num));
						isDefinition = true;
					}

					else {
						tempList.add(Util.toInt(num, c%4 == 0 ? 255 : 0, i -> i >= 0));
						isDefinition = false;
						c++;
					}
				}

				if (!isDefinition)
					colors.add(Util.listToColor(tempList));
			}
		}

		return colors;
	}

	public List<Color> getColors() {
		return this.colors;
	}

	public void setColors(String str) {
		this.colors = turnStringToColorList(str);
	}
}
