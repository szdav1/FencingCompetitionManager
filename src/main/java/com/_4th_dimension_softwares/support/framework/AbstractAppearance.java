package com._4th_dimension_softwares.support.framework;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import com._4th_dimension_softwares.support.appdata.SizeData;
import com._4th_dimension_softwares.support.framework.models.BorderModel;
import com._4th_dimension_softwares.support.framework.models.ColorThemeModel;
import com._4th_dimension_softwares.support.framework.models.FontModel;
import com._4th_dimension_softwares.support.util.Resources;

public abstract class AbstractAppearance {
	protected List<Color> backgrounds;
	protected List<Color> foregrounds;
	protected BorderModel borderModel;
	protected Font font;
	protected ImageIcon icon1;
	protected ImageIcon icon2;

	protected AbstractAppearance() {
		this.backgrounds = new ArrayList<>(List.of(Color.black));
		this.foregrounds = new ArrayList<>(List.of(Color.white));
		this.borderModel = new BorderModel();
		this.font = new Font(Font.MONOSPACED, Font.PLAIN, SizeData.FONT_SIZE);
		this.icon1 = null;
		this.icon2 = null;
	}

	public AbstractAppearance(final ColorThemeModel colorThemeModel) {
		this.backgrounds = colorThemeModel.getBackgroundModel().getColors();
		this.foregrounds = colorThemeModel.getForegroundModel().getColors();
		this.borderModel = colorThemeModel.getBorderModel();
		this.icon1 = colorThemeModel.getIconModel1().getIcon();
		this.icon2 = colorThemeModel.getIconModel2().getIcon();
		this.createFont(colorThemeModel.getFontModel());
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
				try {
					this.font = Font.createFont(Font.TRUETYPE_FONT, new File(Resources.get(fontModel.getSource())))
						.deriveFont(fontModel.getLigature(), (float) fontModel.getSize());
				}
				catch (Exception exc) {
					this.font = new Font(Font.MONOSPACED, Font.PLAIN, SizeData.FONT_SIZE);
				}
			}

			// Backup font
			else
				this.font = new Font(Font.MONOSPACED, Font.PLAIN, SizeData.FONT_SIZE);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public List<Color> getBackgrounds() {
		return this.backgrounds;
	}

	public List<Color> getForegrounds() {
		return this.foregrounds;
	}

	public BorderModel getBorderModel() {
		return this.borderModel;
	}

	public Font getFont() {
		return this.font;
	}

	public ImageIcon getIcon1() {
		return this.icon1;
	}

	public ImageIcon getIcon2() {
		return this.icon2;
	}
}
