package com._4th_dimension_softwares.support.framework.models;

import java.awt.Font;

import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.theme.models.FontModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FontModelTest {
	FontModel fm;


	@Test
	@DisplayName("Should have default fields created by the empty constructor")
	void shouldHaveDefaultFields() {
		fm = new FontModel();

		Assertions.assertAll(
			() -> Assertions.assertTrue(fm.getSource().isBlank()),
			() -> Assertions.assertEquals("Arial", fm.getFamily()),
			() -> Assertions.assertEquals(fm.getLigature(), Font.PLAIN),
			() -> Assertions.assertEquals(SizeData.FONT_SIZE, fm.getSize())
		);
	}

	@ParameterizedTest
	@ValueSource(strings = {"-20", "Hello", "-gjklfg", "[][[/\\*", "-99", "0"})
	@DisplayName("The size should always be proportional, because every passed in data is invalid")
	void shouldAlwaysHaveProportionalFontSize(String str) {
		fm = new FontModel("", "", "", str);

		Assertions.assertEquals(SizeData.FONT_SIZE, fm.getSize());
	}

	@ParameterizedTest
	@ValueSource(strings = {"23", "89", "10", "1", "9909"})
	@DisplayName("The size should always be proportional, because every passed in data is valid")
	void shouldNeverHaveProportionalFontSize(String str) {
		fm = new FontModel("", "", "", str);

		Assertions.assertNotEquals(SizeData.FONT_SIZE, fm.getSize());
	}

	@Test
	@DisplayName("The ligature should be bold")
	void shouldHaveBoldLigature() {
		fm = new FontModel("", "", "BoLd", "");

		Assertions.assertEquals(Font.BOLD, fm.getLigature());
	}

	@Test
	@DisplayName("The ligature should be italic")
	void shouldHaveItalicLigature() {
		fm = new FontModel("", "", "ItALic", "");

		Assertions.assertEquals(Font.ITALIC, fm.getLigature());
	}

	@ParameterizedTest
	@ValueSource(strings = {"pLaIn", "PLAIN", "74897459", "jhgfdkj", "\\//[][{}:*,?"})
	@DisplayName("The ligature should be plain")
	void shouldHavePLainLigature(String str) {
		fm = new FontModel("", "", str, "");

		Assertions.assertEquals(Font.PLAIN, fm.getLigature());
	}
}