package com._4th_dimension_software.support.framework.models;

import com._4th_dimension_software.support.appdata.SizeData;

public abstract class AbstractColorThemeModel {
	protected int verticalPadding;
	protected int horizontalPadding;
	protected ColorModel backgroundModel;
	protected ColorModel foregroundModel;
	protected BorderModel borderModel;
	protected FontModel fontModel;
	protected IconModel iconModel1;
	protected IconModel iconModel2;

	protected AbstractColorThemeModel() {
		this.verticalPadding = 0;
		this.horizontalPadding = 0;
		this.backgroundModel = new ColorModel();
		this.foregroundModel = new ColorModel("[255,255,255,255]");
		this.borderModel = new BorderModel();
		this.fontModel = new FontModel();
		this.iconModel1 = new IconModel();
		this.iconModel2 = new IconModel();
	}

	protected AbstractColorThemeModel(final int verticalPadding, final int horizontalPadding, final ColorModel backgroundModel,
		final ColorModel foregroundModel, final BorderModel borderModel, final FontModel fontModel, final IconModel iconModel1, final IconModel iconModel2) {

		this.verticalPadding = SizeData.SCREEN_WIDTH*verticalPadding/100;
		this.horizontalPadding = SizeData.SCREEN_HEIGHT*horizontalPadding/100;
		this.backgroundModel = backgroundModel;
		this.foregroundModel = foregroundModel;
		this.borderModel = borderModel;
		this.fontModel = fontModel;
		this.iconModel1 = iconModel1;
		this.iconModel2 = iconModel2;
	}

	public int getVerticalPadding() {
		return this.verticalPadding;
	}

	public void setVerticalPadding(int verticalPadding) {
		this.verticalPadding = verticalPadding;
	}

	public int getHorizontalPadding() {
		return this.horizontalPadding;
	}

	public void setHorizontalPadding(int horizontalPadding) {
		this.horizontalPadding = horizontalPadding;
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
