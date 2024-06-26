package com._4th_dimension_software.support.theme.models;

/**
 * Stores icon data read from the specified
 * color theme file by the <code>ColorThemeReader</code> class.
 * Every individual field is validated, so that the
 * interpreter won't have to bother checking every
 * field of this class for errors and mistypes.
 *
 * @author szd
 */
public final class IconModel extends AbstractIconModel {
	/**
	 * Constructs a model of an icon without
	 * any specified parameters. In this case, the
	 * icon is going to be null.
	 */
	public IconModel() {
	}

	/**
	 * Constructs a model of an icon based on the
	 * passed in parameters. Every parameter is validated
	 * individually inside the constructor to make later
	 * tasks easier. The model will try to load the desired
	 * image into an <code>ImageIcon</code> from the resources
	 * folder by default.
	 *
	 * @param source           The source of the icon
	 * @param widthPercentage  The amount of percentage the icon should be scaled on the X axis
	 * @param heightPercentage The amount of percentage the icon should be scaled on the Y axis
	 */
	public IconModel(final String source, String widthPercentage, String heightPercentage) {
		super(source, widthPercentage, heightPercentage);
	}

	/**
	 * Constructs a model of an icon based on the
	 * passed in parameters. Every parameter is validated
	 * individually inside the constructor to make later
	 * tasks easier. The model will try to load the desired
	 * image into an <code>ImageIcon</code> from the resources
	 * folder by default, and color it using the specified color,
	 * which is first transformed into a <code>ColorModel</code> for
	 * validation.
	 *
	 * @param source           The source of the icon
	 * @param widthPercentage  The amount of percentage the icon should be scaled on the X axis
	 * @param heightPercentage The amount of percentage the icon should be scaled on the Y axis
	 * @param color            The desired color of the icon
	 */
	public IconModel(String source, String widthPercentage, String heightPercentage, String color) {
		super(source, widthPercentage, heightPercentage, color);
	}

	/**
	 * Constructs a model of an icon based on the
	 * passed in parameters. Every parameter is validated
	 * individually inside the constructor to make later
	 * tasks easier. The model will try to load the desired
	 * image into an <code>ImageIcon</code> from the resources
	 * folder by default.
	 *
	 * @param source The source of the icon
	 */
	public IconModel(String source) {
		super(source);
	}
}
