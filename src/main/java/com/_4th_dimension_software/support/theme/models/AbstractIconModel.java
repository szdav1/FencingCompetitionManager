package com._4th_dimension_software.support.theme.models;

import java.awt.Color;

import javax.swing.ImageIcon;

import com._4th_dimension_software.support.util.Util;

/**
 * The <code>AbstractIconModel</code> stores and validates
 * icon related data. It handles the loading of images into the application
 * defined inside the color theme file. It defines the abstract
 * behaviour of icon models inside the application.
 * These data are fed into this class's constructor by the <code>ColorThemeReader</code>.
 */
public abstract class AbstractIconModel {
	protected ImageIcon icon;

	/**
	 * Defines the base constructor of icon models
	 * that initializes every field to a default value.
	 */
	protected AbstractIconModel() {
		this.icon = null;
	}

	/**
	 * Defines the base constructor of icon models
	 * that initializes every field with the specified parameter.
	 *
	 * @param source The source of the image
	 * @param width  The width that should be used for the image when resizing
	 * @param height The height that should be used for the image when resizing
	 */
	protected AbstractIconModel(final String source, String width, String height) {
		if (!source.isBlank())
			this.icon = Util.loadImageIcon(source, Util.toInt(width, 3, (i) -> i > 0), Util.toInt(height, 3, (i) -> i > 0));
		else
			this.icon = null;
	}

	/**
	 * Defines the base constructor of icon models
	 * that initializes every field with the specified parameter.
	 *
	 * @param source The source of the image
	 * @param width  The width that should be used for the image when resizing
	 * @param height The height that should be used for the image when resizing
	 * @param color  The color that should be used to recolor the image
	 */
	protected AbstractIconModel(final String source, String width, String height, String color) {
		int w = Util.toInt(width, 3, (i) -> i > 0);
		int h = Util.toInt(height, 3, (i) -> i > 0);

		if (!source.isBlank() && !color.isBlank()) {
			Color c = new ColorModel(color).getColors().get(0);

			this.icon = Util.loadImageIcon(source, w, h, c);
		}
		else
			this.icon = Util.loadImageIcon(source, w, h);
	}

	/**
	 * Defines the constructor of icon models
	 * that initializes the icon using only the source
	 * attribute and leaving everything else as default.
	 *
	 * @param source The source of the image
	 */
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
