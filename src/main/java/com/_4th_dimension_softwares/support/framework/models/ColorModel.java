package com._4th_dimension_softwares.support.framework.models;

/**
 * Stores raw color values read from
 * the specified color theme file by
 * the <code>ColorThemeReader</code>. These values
 * are stored using an <code>ArrayList</code>, and validated
 * inside the constructor so that the interpreter
 * won't have to check every individual field of this class.
 *
 * @author szd
 */
public final class ColorModel extends AbstractColorModel {
	/**
	 * Constructs a model of colors without
	 * any specified parameters. The model uses
	 * default values in this case.
	 * (Color.black: [0, 0, 0, 255])
	 */
	public ColorModel() {
	}

	/**
	 * Constructs a model of colors based on the
	 * specified parameters. Every value is a validated
	 * Color value, which are stored in an ArrayList
	 * for easier access.
	 *
	 * @param line The currently read line from the color theme file
	 */
	public ColorModel(String line) {
		super(line);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ColorModel cm) {
			return this.colors.equals(cm.getColors());
		}

		return false;
	}

	@Override
	public String toString() {
		return "ColorModel{"+
			"colors="+colors+
			'}';
	}
}
