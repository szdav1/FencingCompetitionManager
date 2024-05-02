package com._4th_dimension_software.support.theme.models;

import java.util.HashMap;

public abstract class AbstractColorThemeModel {
	protected boolean linearPaint;
	protected HashMap<String, Boolean> borderPaintRules;
	protected ColorModel backgroundModel;
	protected ColorModel foregroundModel;
	protected BorderModel borderModel;
	protected FontModel fontModel;
	protected IconModel iconModel1;
	protected IconModel iconModel2;

	protected AbstractColorThemeModel() {
		this.linearPaint = true;
		this.backgroundModel = new ColorModel();
		this.foregroundModel = new ColorModel("[255,255,255,255]");
		this.borderModel = new BorderModel();
		this.fontModel = new FontModel();
		this.iconModel1 = new IconModel();
		this.iconModel2 = new IconModel();

		this.initBorderPaintRules();
	}

	public AbstractColorThemeModel(final boolean linearPaint, final boolean paintTopBorder, final boolean paintRightBorder, final boolean paintBottomBorder,
		final boolean paintLeftBorder, final ColorModel backgroundModel, final ColorModel foregroundModel, final BorderModel borderModel, final FontModel fontModel,
		final IconModel iconModel1, final IconModel iconModel2) {

		this.linearPaint = linearPaint;
		this.backgroundModel = backgroundModel;
		this.foregroundModel = foregroundModel;
		this.borderModel = borderModel;
		this.fontModel = fontModel;
		this.iconModel1 = iconModel1;
		this.iconModel2 = iconModel2;

		this.initBorderPaintRules();
		this.setBorderPaintRule("top", paintTopBorder);
		this.setBorderPaintRule("right", paintRightBorder);
		this.setBorderPaintRule("bottom", paintBottomBorder);
		this.setBorderPaintRule("left", paintLeftBorder);
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
}