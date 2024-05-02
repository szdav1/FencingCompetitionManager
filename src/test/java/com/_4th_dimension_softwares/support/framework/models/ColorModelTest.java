package com._4th_dimension_softwares.support.framework.models;

import java.awt.Color;

import com._4th_dimension_software.support.theme.models.ColorModel;
import com._4th_dimension_software.support.util.Util;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ColorModelTest {
	static ColorModel cm;

	@BeforeAll
	static void initColorModel() {
		cm = new ColorModel();
	}

	@BeforeEach
	void resetColorModel() {
		cm.getColors().clear();
	}

	@Test
 	@DisplayName("The colors should be red green and blue")
	void theColorsShouldBeRedGreenAndBlue() {
		cm.setColors("[255,0,0,255][0,255,0,255][0,0,255,255]");

		Assertions.assertAll(
			() -> Assertions.assertTrue(Util.compareColors(Color.red, cm.getColors().get(0))),
			() -> Assertions.assertTrue(Util.compareColors(Color.green, cm.getColors().get(1))),
			() -> Assertions.assertTrue(Util.compareColors(Color.blue, cm.getColors().get(2)))
		);
	}

	@ParameterizedTest
	@ValueSource(strings = {"[255, 0, 255, 255][0, 255, 0, 255][0, 0, 255, 255]", "[125,7, 0, 2][0, 43,    65,23][	44, 65	, 355, 33]"})
	@DisplayName("The model should not contain any black color at all, because every data is correct")
	void theModelShouldNotContainAnyBlackColors(String str) {
		cm.setColors(str);

		Assertions.assertAll(
			() -> Assertions.assertFalse(Util.compareColors(cm.getColors().get(0), Color.black)),
			() -> Assertions.assertFalse(Util.compareColors(cm.getColors().get(1), Color.black)),
			() -> Assertions.assertFalse(Util.compareColors(cm.getColors().get(2), Color.black))
		);
	}

	@ParameterizedTest
	@ValueSource(strings = {"[400, 400; 400][356; 765; 4322; 77][red, green, blue, 0.5]", "[[]][[][[[]]][]]]"})
	@DisplayName("The model should contain only black colors, because every data is incorrect")
	void theModelShouldContainOnlyBlackColors(String str) {
		cm.setColors(str);

		Assertions.assertAll(
			() -> Assertions.assertTrue(Util.compareColors(cm.getColors().get(0), Color.black)),
			() -> Assertions.assertTrue(Util.compareColors(cm.getColors().get(1), Color.black)),
			() -> Assertions.assertTrue(Util.compareColors(cm.getColors().get(2), Color.black))
		);
	}

	@ParameterizedTest
	@ValueSource(strings = {"[0,255,0,0][255,0,0,255][]", "[I, Hope, -255, 6][This, Will, Work, Properly][]"})
	@DisplayName("The number of colors created in the model should be 3, no matter if the data is correct or not")
	void theNumberOfColorsShouldBeThree(String str) {
		cm.setColors(str);

		Assertions.assertEquals(3, cm.getColors().size());
	}
}