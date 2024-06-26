package com._4th_dimension_software.support.theme.models;

/**
 * Stores raw versions of <code>Appearance</code> values.
 * These values are: background, foreground,
 * border and font. These values are stored as
 * models. Each model stores relevant data in
 * such form that the <code>ColorThemeInterpreter</code> can
 * understand and create all the <code>Appearance</code>s from
 * those data. Models are created during the reading
 * stage of the color theme processing. <code>ColorThemeModel</code>s
 * collect these models into one class, so that the values
 * stored by models can be accessed easily.
 *
 * @author szd
 */
public final class ColorThemeModel extends AbstractColorThemeModel {
	/**
	 * Constructs a <code>ColorThemeModel</code> without any
	 * specified parameters. Every model that would
	 * be stored by this class gets a default value.
	 */
	public ColorThemeModel() {
	}

	/**
	 * Constructs a <code>ColorThemeModel</code> that stores
	 * the models that were created during the reading
	 * stage of the color theme interpretation. Every model
	 * is created individually, and every model's fields are
	 * validated inside the models' constructors. This means
	 * that this class contains mostly safe, valid models that
	 * can be accessed from this class that collects them.
	 *
	 * @param linearPaint       Defines whether the background should be painted linearly or not
	 * @param paintTopBorder    Defines whether the top of the border should be painted
	 * @param paintRightBorder  Defines whether the right side of the border should be painted
	 * @param paintBottomBorder Defines whether the bottom of the border should be painted
	 * @param paintLeftBorder   Defines whether the left side of the border should be painted
	 * @param backgroundModel   The model for the background colors
	 * @param foregroundModel   The model for the foreground colors
	 * @param borderModel       The model for the border
	 * @param fontModel         The model for the font
	 * @param iconModel1        The model of the main icon
	 * @param iconModel2        The model of the secondary icon
	 * @param iconModel3        The model of the third icon
	 * @param iconModel4        The model of the fourth icon
	 */
	public ColorThemeModel(final boolean linearPaint, final boolean paintTopBorder, final boolean paintRightBorder, final boolean paintBottomBorder,
		final boolean paintLeftBorder, final ColorModel backgroundModel, final ColorModel foregroundModel, final BorderModel borderModel, final FontModel fontModel,
		final IconModel iconModel1, final IconModel iconModel2, final IconModel iconModel3, final IconModel iconModel4) {

		super(linearPaint, paintTopBorder, paintRightBorder, paintBottomBorder, paintLeftBorder, backgroundModel, foregroundModel, borderModel, fontModel, iconModel1, iconModel2, iconModel3, iconModel4);
	}

	/**
	 * Constructs a <code>ColorThemeModel</code> that stores
	 * the models that were created during the reading
	 * stage of the color theme interpretation. Every model
	 * is created individually, and every model's fields are
	 * validated inside the models' constructors. This means
	 * that this class contains mostly safe, valid models that
	 * can be accessed from this class that collects them.
	 *
	 * @param linearPaint       Defines whether the background should be painted linearly or not
	 * @param paintTopBorder    Defines whether the top of the border should be painted
	 * @param paintRightBorder  Defines whether the right side of the border should be painted
	 * @param paintBottomBorder Defines whether the bottom of the border should be painted
	 * @param paintLeftBorder   Defines whether the left side of the border should be painted
	 * @param backgroundModel   The model for the background colors
	 * @param foregroundModel   The model for the foreground colors
	 * @param borderModel       The model for the border
	 * @param fontModel         The model for the font
	 * @param iconModel1        The model of the main icon
	 * @param iconModel2        The model of the secondary icon
	 */
	public ColorThemeModel(final boolean linearPaint, final boolean paintTopBorder, final boolean paintRightBorder, final boolean paintBottomBorder,
		final boolean paintLeftBorder, final ColorModel backgroundModel, final ColorModel foregroundModel, final BorderModel borderModel, final FontModel fontModel,
		final IconModel iconModel1, final IconModel iconModel2) {

		super(linearPaint, paintTopBorder, paintRightBorder, paintBottomBorder, paintLeftBorder, backgroundModel, foregroundModel, borderModel, fontModel, iconModel1, iconModel2);
	}
}
