package com._4th_dimension_software.support.theme.models;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com._4th_dimension_software.support.util.Util;

/**
 * The <code>AbstractColorModel</code> stores and validates
 * color related data. It handles the parsing of color arrays
 * defined inside the color theme file. It defines the abstract
 * behaviour of color models inside the application.
 * These data are fed into this class's constructor by the <code>ColorThemeReader</code>.
 */
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
		this.colors = new ArrayList<>();
		this.turnStringToColorList(line);
	}

	/**
	 * Tries to transform the specified string into a color array
	 * that's items are put into the color list.
	 *
	 * @param str The string that should be turned into a color array
	 */
	private void turnStringToColorList(final String str) {
		this.colors.clear();

		// If the value given is blank, a black color is used
		if (str.isBlank())
			this.colors.add(Color.black);
			// Interpretation
		else {
			String[] values = str
				.replaceAll(" ", "")
				.replaceAll("\t", "")
				.replaceAll("\n", "")
				.split("]\\[");

			for (String value : values) {
				// Remove unnecessary characters and split to get the color values
				String[] splitValues = value.replaceAll("\\[", "")
					.replaceAll("]", "")
					.split(",");

				List<Integer> tempList = new ArrayList<>();

				if (splitValues.length == 4) {
					tempList.add(Util.toInt(splitValues[0], 0, (i) -> i >= 0));
					tempList.add(Util.toInt(splitValues[1], 0, (i) -> i >= 0));
					tempList.add(Util.toInt(splitValues[2], 0, (i) -> i >= 0));
					tempList.add(Util.toInt(splitValues[3], 255, (i) -> i >= 0));
				}

				this.colors.add(Util.listToColor(tempList));
			}
		}
	}

	public List<Color> getColors() {
		return this.colors;
	}

	public void setColors(String str) {
		this.turnStringToColorList(str);
	}
}
