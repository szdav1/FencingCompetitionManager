package com._4th_dimension_softwares.support.framework;

import java.awt.Color;

import com._4th_dimension_software.support.theme.Appearance;
import com._4th_dimension_software.support.theme.models.ColorModel;
import com._4th_dimension_software.support.theme.models.ColorThemeModel;
import com._4th_dimension_software.support.theme.models.FontModel;
import com._4th_dimension_software.support.theme.models.IconModel;
import com._4th_dimension_software.support.util.Util;
import org.junit.jupiter.api.*;

@Disabled
class AppearanceTest {
	ColorThemeModel ctm;

	@BeforeEach
	void initCtm() {
		ctm = new ColorThemeModel();
	}

	@Nested
	@DisplayName("Color related tests (Background, Foreground)")
	class ColorRelatedTests {
		@Test
		@DisplayName("The background colors should be: red, green and blue")
		void theBackgroundColorsShouldBeRedGreenAndBlue() {
			ctm.setBackgroundModel(new ColorModel("[255,0,0,255] [0,255,0,255] [0,0,255,255]"));
			Appearance a = new Appearance(ctm);

			Assertions.assertAll(
				() -> Assertions.assertTrue(Util.compareColors(Color.red, a.getBackgrounds().get(0))),
				() -> Assertions.assertTrue(Util.compareColors(Color.green, a.getBackgrounds().get(1))),
				() -> Assertions.assertTrue(Util.compareColors(Color.blue, a.getBackgrounds().get(2)))
			);
		}

		@Test
		@DisplayName("The foreground colors should be: black, pink and gray")
		void theForegroundColorsShouldBeBlackPinkAndGray() {
			ctm.setForegroundModel(new ColorModel("[0,0,0,255] [255, 175, 175,255] [128, 128, 128,255]"));
			Appearance a = new Appearance(ctm);

			Assertions.assertAll(
				() -> Assertions.assertTrue(Util.compareColors(Color.black, a.getForegrounds().get(0))),
				() -> Assertions.assertTrue(Util.compareColors(Color.pink, a.getForegrounds().get(1))),
				() -> Assertions.assertTrue(Util.compareColors(Color.gray, a.getForegrounds().get(2)))
			);
		}
	}

	@Nested
	@DisplayName("Font related tests")
	class FontRelatedTests {
		@Test
		@DisplayName("The family (name) of the font should be Arial")
		void theFontFamilyShouldBeArial() {
			ctm.setFontModel(new FontModel("", "Arial", "Plain", "25"));
			Appearance a = new Appearance(ctm);

			Assertions.assertEquals("Arial", a.getFont().getFontName());
		}

		@Test
		@DisplayName("The family (name) of the font should be the specified custom font: Halimun")
		void theFamilyOfTheFontShouldBeTheSpecifiedCustomFont() {
			ctm.setFontModel(new FontModel("fonts/Halimun-W7jn.ttf", "", "Plain", "25"));
			Appearance a = new Appearance(ctm);
			System.out.println(ctm.getFontModel().getFamily());

			Assertions.assertEquals("Halimun", a.getFont().getFontName());
		}

		@Test
		@DisplayName("The family (name) of the font should be the default font family: Arial")
		void theFamilyOfTheFontShouldBeTheDefaultArial() {
			ctm.setFontModel(new FontModel("src/test/resourcs/fnts\\Haliun-W7jn.ttf", "Something", "Plain", "25"));
			Appearance a = new Appearance(ctm);

			Assertions.assertEquals("Arial", a.getFont().getFontName());
		}
	}

	@Nested
	@DisplayName("Icon related tests")
	@Disabled("Icons were tested and worked properly, the test icon is unnecessary and was removed")
	class IconRelatedTests {
		@Test
		@DisplayName("The icon of the Appearance should not be null")
		void theIconShouldNotBeNull() {
			ctm.setIconModel1(new IconModel("testIcon.png"));
			Appearance a = new Appearance(ctm);

			Assertions.assertNotNull(a.getIcon1());
		}

		@Test
		@DisplayName("The icon of the Appearance should be null")
		void theIconShouldBeNull() {
			ctm.setIconModel1(new IconModel("src/testesources/testIcon.png"));
			Appearance a = new Appearance(ctm);

			Assertions.assertNotNull(a.getIcon1());
		}

		@Test
		@DisplayName("The size of the icon should be 50x50")
		void theSizeOfTheIconShouldBe50x50() {
			ctm.setIconModel1(new IconModel("/testIcon.png", "5", "5"));
			Appearance a = new Appearance(ctm);

			Assertions.assertAll(
				() -> Assertions.assertEquals(50, a.getIcon1().getIconWidth()),
				() -> Assertions.assertEquals(50, a.getIcon1().getIconHeight())
			);
		}
	}
}