package com._4th_dimension_software.support.theme;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;

import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.theme.models.BorderModel;
import com._4th_dimension_software.support.theme.models.ColorThemeModel;
import com._4th_dimension_software.support.theme.models.FontModel;
import com._4th_dimension_software.support.util.ResourceHandler;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The <code>AbstractAppearance</code> abstract class defines the
 * abstract behaviour of <code>Appearance</code>s inside the application.
 */
@Getter
@ToString
@EqualsAndHashCode()
public abstract class AbstractAppearance {
	protected boolean linearPaint;
	protected HashMap<String, Boolean> borderPaintRules;
	protected List<Color> backgrounds;
	protected List<Color> foregrounds;
	protected BorderModel borderModel;
	protected Font font;
	protected ImageIcon icon1;
	protected ImageIcon icon2;
	protected ImageIcon icon3;
	protected ImageIcon icon4;

	/**
	 * Defines the base constructor of <code>Appearance</code>s
	 * that initializes every field to a default value.
	 */
	protected AbstractAppearance() {
		this.linearPaint = true;
		this.backgrounds = new ArrayList<>(List.of(Color.black));
		this.foregrounds = new ArrayList<>(List.of(Color.white));
		this.borderModel = new BorderModel();
		this.font = new Font(Font.MONOSPACED, Font.PLAIN, SizeData.FONT_SIZE);
		this.icon1 = null;
		this.icon2 = null;
		this.icon3 = null;
		this.icon4 = null;

		this.initBorderPaintRules();
	}

	/**
	 * Defines the base constructor of <code>Appearance</code>s that
	 * initializes every field with the corresponding field of the
	 * specified <code>ColorThemeModel</code>.
	 *
	 * @param colorThemeModel The <code>ColorThemeModel</code> that's values should be
	 *                        passed into and processed by the Appearance.
	 */
	public AbstractAppearance(final ColorThemeModel colorThemeModel) {
		this.linearPaint = colorThemeModel.isLinearPaint();
		this.borderPaintRules = colorThemeModel.getBorderPaintRules();
		this.backgrounds = colorThemeModel.getBackgroundModel().getColors();
		this.foregrounds = colorThemeModel.getForegroundModel().getColors();
		this.borderModel = colorThemeModel.getBorderModel();
		this.icon1 = colorThemeModel.getIconModel1().getIcon();
		this.icon2 = colorThemeModel.getIconModel2().getIcon();
		this.icon3 = colorThemeModel.getIconModel3().getIcon();
		this.icon4 = colorThemeModel.getIconModel4().getIcon();

		this.createFont(colorThemeModel.getFontModel());
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
	 * Creates a <code>Font</code> object based on the values
	 * of the specified font model.
	 *
	 * @param fontModel A <code>Font</code> object that has been initialized
	 *                  based on the given <code>FontModel</code>
	 */
	private void createFont(final FontModel fontModel) {
		try {
			// Font family
			if (fontModel.getSource().isBlank() && !fontModel.getFamily().isBlank())
				this.font = new Font(fontModel.getFamily(), fontModel.getLigature(),
					fontModel.getSize());

				// Custom font
			else if (!fontModel.getSource().isBlank()) {
				this.font = Font.createFont(Font.TRUETYPE_FONT, new File(ResourceHandler.get(fontModel.getSource())))
					.deriveFont(fontModel.getLigature(), (float) fontModel.getSize());
			}
			// Backup font
			else
				this.font = new Font("Arial", Font.PLAIN, fontModel.getSize());
		}
		catch (Exception exc) {
			this.font = new Font("Arial", Font.PLAIN, SizeData.FONT_SIZE);
		}
	}
}
