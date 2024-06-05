package com._4th_dimension_software.support.theme.models;

import java.util.HashMap;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The <code>AbstractColorThemeModel</code> abstract class defines the abstract
 * behaviour of color theme models inside the application.
 */
@ToString
@EqualsAndHashCode
public abstract class AbstractColorThemeModel {
	protected boolean linearPaint;
	protected HashMap<String, Boolean> borderPaintRules;
	protected ColorModel backgroundModel;
	protected ColorModel foregroundModel;
	protected BorderModel borderModel;
	protected FontModel fontModel;
	protected IconModel iconModel1;
	protected IconModel iconModel2;
	protected IconModel iconModel3;
	protected IconModel iconModel4;

	/**
	 * Defines the base constructor of color theme models
	 * that initializes every field with a default value.
	 */
	protected AbstractColorThemeModel() {
		this.linearPaint = true;
		this.backgroundModel = new ColorModel();
		this.foregroundModel = new ColorModel("[255,255,255,255]");
		this.borderModel = new BorderModel();
		this.fontModel = new FontModel();
		this.iconModel1 = new IconModel();
		this.iconModel2 = new IconModel();
		this.iconModel3 = new IconModel();
		this.iconModel4 = new IconModel();

		this.initBorderPaintRules();
	}

	/**
	 * Defines the base constructor of color theme models
	 * that initializes every field with the specified parameter.
	 *
	 * @param linearPaint       Boolean value that defines the painting method of backgrounds
	 * @param paintTopBorder    Boolean value that defines whether the top section of the border should be painted
	 * @param paintRightBorder  Boolean value that defines whether the right section of the border should be painted
	 * @param paintBottomBorder Boolean value that defines whether the bottom section of the border should be painted
	 * @param paintLeftBorder   Boolean value that defines whether the left section of the border should be painted
	 * @param backgroundModel   The background model that has been initialized by the reader
	 * @param foregroundModel   The foreground model that has been initialized by the reader
	 * @param borderModel       The border model that has benn initialized by the reader
	 * @param fontModel         The font model that has benn initialized by the reader
	 * @param iconModel1        The first icon model that has benn initialized by the reader
	 * @param iconModel2        The second icon model that has benn initialized by the reader
	 */
	public AbstractColorThemeModel(final boolean linearPaint, final boolean paintTopBorder, final boolean paintRightBorder, final boolean paintBottomBorder,
		final boolean paintLeftBorder, final ColorModel backgroundModel, final ColorModel foregroundModel, final BorderModel borderModel, final FontModel fontModel,
		final IconModel iconModel1, final IconModel iconModel2, final IconModel iconModel3, final IconModel iconModel4) {

		this.linearPaint = linearPaint;
		this.backgroundModel = backgroundModel;
		this.foregroundModel = foregroundModel;
		this.borderModel = borderModel;
		this.fontModel = fontModel;
		this.iconModel1 = iconModel1;
		this.iconModel2 = iconModel2;
		this.iconModel3 = iconModel3;
		this.iconModel4 = iconModel4;

		this.initBorderPaintRules();
		this.setBorderPaintRule("top", paintTopBorder);
		this.setBorderPaintRule("right", paintRightBorder);
		this.setBorderPaintRule("bottom", paintBottomBorder);
		this.setBorderPaintRule("left", paintLeftBorder);
	}

	public AbstractColorThemeModel(final boolean linearPaint, final boolean paintTopBorder, final boolean paintRightBorder, final boolean paintBottomBorder,
		final boolean paintLeftBorder, final ColorModel backgroundModel, final ColorModel foregroundModel, final BorderModel borderModel, final FontModel fontModel,
		final IconModel iconModel1, final IconModel iconModel2) {

		this(linearPaint, paintTopBorder, paintRightBorder, paintBottomBorder, paintLeftBorder, backgroundModel, foregroundModel, borderModel, fontModel, iconModel1, iconModel2,
			new IconModel(), new IconModel());
	}

	/**
	 * Initializes the <code>borderPaintRules</code> <code>HashMap</code>
	 * with every value being <code>true</code>.
	 */
	private void initBorderPaintRules() {
		this.borderPaintRules = new HashMap<>();
		this.borderPaintRules.put("top", false);
		this.borderPaintRules.put("right", false);
		this.borderPaintRules.put("bottom", false);
		this.borderPaintRules.put("left", false);
	}

	/**
	 * Sets whether the specified section of the border should
	 * be painted.
	 * <p>Valid section names are:</p>
	 * <p><code>"top"</code></p>
	 * <p><code>"right"</code></p>
	 * <p><code>"bottom"</code></p>
	 * <p><code>"left"</code></p>
	 *
	 * @param sectionName The name of the section
	 * @param painted     Boolean, determines whether the specified section
	 *                    should be painted
	 */
	public void setBorderPaintRule(String sectionName, boolean painted) {
		if (!this.borderPaintRules.containsKey(sectionName))
			return;

		this.borderPaintRules.put(sectionName, painted);
	}

	/**
	 * Sets whether the specified section of the border should
	 * be painted.
	 * <p>Valid section names are:</p>
	 * <p><code>"top"</code></p>
	 * <p><code>"right"</code></p>
	 * <p><code>"bottom"</code></p>
	 * <p><code>"left"</code></p>
	 *
	 * @param sectionName The name of the section
	 * @param paintedStr  A boolean represented with string,
	 *                    determines whether the specified section should be painted
	 */
	public void setBorderPaintRule(String sectionName, String paintedStr) {
		if (!this.borderPaintRules.containsKey(sectionName))
			return;

		this.borderPaintRules.put(sectionName, Boolean.parseBoolean(paintedStr));
	}

	public boolean isLinearPaint() {
		return this.linearPaint;
	}

	public void setLinearPaint(boolean linearPaint) {
		this.linearPaint = linearPaint;
	}

	public void setLinearPaint(String linearPaint) {
		this.linearPaint = Boolean.parseBoolean(linearPaint);
	}

	public HashMap<String, Boolean> getBorderPaintRules() {
		return this.borderPaintRules;
	}

	public ColorModel getBackgroundModel() {
		return this.backgroundModel;
	}

	public void setBackgroundModel(ColorModel backgroundModel) {
		this.backgroundModel = backgroundModel;
	}

	public ColorModel getForegroundModel() {
		return this.foregroundModel;
	}

	public void setForegroundModel(ColorModel foregroundModel) {
		this.foregroundModel = foregroundModel;
	}

	public BorderModel getBorderModel() {
		return this.borderModel;
	}

	public void setBorderModel(BorderModel borderModel) {
		this.borderModel = borderModel;
	}

	public FontModel getFontModel() {
		return this.fontModel;
	}

	public void setFontModel(FontModel fontModel) {
		this.fontModel = fontModel;
	}

	public IconModel getIconModel1() {
		return this.iconModel1;
	}

	public void setIconModel1(IconModel iconModel1) {
		this.iconModel1 = iconModel1;
	}

	public IconModel getIconModel2() {
		return this.iconModel2;
	}

	public void setIconModel2(IconModel iconModel2) {
		this.iconModel2 = iconModel2;
	}

	public IconModel getIconModel3() {
		return this.iconModel3;
	}

	public void setIconModel3(IconModel iconModel3) {
		this.iconModel3 = iconModel3;
	}

	public IconModel getIconModel4() {
		return this.iconModel4;
	}

	public void setIconModel4(IconModel iconModel4) {
		this.iconModel4 = iconModel4;
	}
}
