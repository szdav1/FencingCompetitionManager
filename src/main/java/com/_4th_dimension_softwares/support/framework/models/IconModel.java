package com._4th_dimension_softwares.support.framework.models;

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
	public IconModel(String source, String widthPercentage, String heightPercentage) {
		super(source, widthPercentage, heightPercentage);
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

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof IconModel im) {
			if (this.icon == null && im.getIcon() == null)
				return true;

			return this.icon.equals(im.getIcon());
		}

		return false;
	}

	@Override
	public String toString() {
		return "IconModel{"+
			"icon="+icon+
			'}';
	}
}
