package com._4th_dimension_software.support.framework.models;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com._4th_dimension_software.support.util.Util;

public abstract class AbstractColorModel {
	protected List<Color> colors;

	protected AbstractColorModel() {
		this.colors = new ArrayList<>();
		this.colors.add(Color.black);
	}

	protected AbstractColorModel(String line) {
		this.colors = new ArrayList<>();
		this.turnStringToColorList(line);
	}

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
