package com._4th_dimension_softwares.support.framework.models;

import java.awt.Color;

import com._4th_dimension_software.support.theme.models.BorderModel;
import com._4th_dimension_software.support.theme.models.ColorModel;
import com._4th_dimension_software.support.util.Util;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BorderModelTest {
	static BorderModel bm;

	@BeforeAll
	static void initBorderModel() {
		bm = new BorderModel();
	}

	@Test
	@DisplayName("The ColorModel of the model should be red, green and blue")
	void theColorModelOfTheBorderShouldBeRedGreenBlueWithEachHaving255Alpha() {
		bm.setColorModel("[255, 0, 0, 255][0, 255, 0, 255][0, 0, 255, 255]");

		Assertions.assertAll(
			() -> Util.compareColors(Color.red, bm.getColorModel().getColors().get(0)),
			() -> Util.compareColors(Color.green, bm.getColorModel().getColors().get(1)),
			() -> Util.compareColors(Color.blue, bm.getColorModel().getColors().get(2))
		);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1", "54", "23", "32", "33"})
	@DisplayName("The thickness should never be 0, because every passed in data is correct")
	void theThicknessShouldNeverBeZeroAsEveryValueIsCorrect(String str) {
		bm = new BorderModel("", str, "");

		Assertions.assertNotEquals(0, bm.getThickness());
	}

	@ParameterizedTest
	@ValueSource(strings = {"Hello", "World", "!", "-623", "\n"})
	@DisplayName("The thickness should always be 0, because every passed in data is incorrect")
	void theThicknessShouldAlwaysBeZeroBecauseEveryDataIsIncorrect(String str) {
		bm = new BorderModel("", "", str);

		Assertions.assertEquals(0, bm.getThickness());
	}

	@ParameterizedTest
	@ValueSource(strings = {"12", "4", "499", "124", "3", "2", "1"})
	@DisplayName("The roundness should never be 0, because every passed in data is correct")
	void theRoundnessShouldNotBeZeroBecauseEveryPassedInDataIsCorrect(String str) {
		bm = new BorderModel("", "", str);

		Assertions.assertNotEquals(0, bm.getRoundness());
	}

	@ParameterizedTest
	@ValueSource(strings = {"-12", "sd4", "Invalid", "Values", "-4573", "-2-*S", "'!%/=(=lkjfdg"})
	@DisplayName("The roundness should always be 0, because every passed in data is correct")
	void theRoundnessShouldAlwaysBeZeroBecauseEveryPassedInDataIsCorrect(String str) {
		bm = new BorderModel("", "", str);

		Assertions.assertEquals(0, bm.getRoundness());
	}

	@ParameterizedTest
	@ValueSource(strings = {"[255, 0, 0, 255][0, 0, 255, 255];2;3", "[0, 23, 234, 255] [126, 0, 66, 122];10;73"})
	@DisplayName("Every field of the model should not be 0 or black, because every value is correct")
	void everyFieldOfTheModelShouldNotBeZeroOrBlackBecauseEveryValueIsCorrect(String str) {
		String[] strs = str.split(";");
		bm = new BorderModel(strs[0], strs[1], strs[2]);

		Assertions.assertAll(
			() -> Assertions.assertNotEquals(new ColorModel(), bm.getColorModel()),
			() -> Assertions.assertNotEquals(0, bm.getThickness()),
			() -> Assertions.assertNotEquals(0, bm.getRoundness())
		);
	}
}