package com._4th_dimension_softwares.support.framework.models;

import java.awt.Color;

import com._4th_dimension_software.support.framework.models.BorderModel;
import com._4th_dimension_software.support.framework.models.ColorThemeModel;
import com._4th_dimension_software.support.framework.models.FontModel;
import com._4th_dimension_software.support.framework.models.IconModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ColorThemeModelTest {
	@Test
	@DisplayName("Every model inside the ColorThemeModel should have default values because of no-argument constructor call")
	void theModelShouldHaveDefaultValueModelsInIt() {
		ColorThemeModel ctm = new ColorThemeModel();

		Assertions.assertAll(
			() -> Assertions.assertEquals(Color.black, ctm.getBackgroundModel().getColors().get(0)),
			() -> Assertions.assertEquals(Color.white, ctm.getForegroundModel().getColors().get(0)),
			() -> Assertions.assertEquals(new BorderModel(), ctm.getBorderModel()),
			() -> Assertions.assertEquals(new FontModel(), ctm.getFontModel()),
			() -> Assertions.assertEquals(new IconModel(), ctm.getIconModel1()),
			() -> Assertions.assertEquals(new IconModel(), ctm.getIconModel2())
		);
	}
}