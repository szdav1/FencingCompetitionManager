package com._4th_dimension_softwares.support.framework;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;

import com._4th_dimension_softwares.support.appdata.SizeData;
import com._4th_dimension_softwares.support.framework.models.BorderModel;
import com._4th_dimension_softwares.support.framework.models.ColorThemeModel;
import com._4th_dimension_softwares.support.util.Resources;

public abstract class AbstractAppearance {
	protected List<Color> backgrounds;
	protected List<Color> foregrounds;
	protected BorderModel borderModel;
	protected Font font;
	protected ImageIcon icon1;
	protected ImageIcon icon2;

	public AbstractAppearance(ColorThemeModel colorThemeModel) {
		this.backgrounds = colorThemeModel.getBackgroundModel().getColors();
		this.foregrounds = colorThemeModel.getForegroundModel().getColors();
		this.borderModel = colorThemeModel.getBorderModel();

		try {
			// Font family
			if (colorThemeModel.getFontModel().getSource().isBlank() && !colorThemeModel.getFontModel().getFamily().isBlank())
				this.font = new Font(colorThemeModel.getFontModel().getFamily(), colorThemeModel.getFontModel().getLigature(),
					colorThemeModel.getFontModel().getSize());

			// Custom font
			else if (!colorThemeModel.getFontModel().getSource().isBlank()) {
				try {
					this.font = Font.createFont(Font.TRUETYPE_FONT, new File(Resources.get(colorThemeModel.getFontModel().getSource())))
						.deriveFont(colorThemeModel.getFontModel().getLigature(), (float) colorThemeModel.getFontModel().getSize());
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

		this.icon1 = colorThemeModel.getIconModel1().getIcon();
		this.icon2 = colorThemeModel.getIconModel2().getIcon();
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
