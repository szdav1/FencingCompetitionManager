package com._4th_dimension_softwares.support.framework.models;

import java.awt.MediaTracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * There's a testIcon.png file in the
 * resources package. The tests are going
 * to use that icon. It has a width of 512
 * and height of 512.
 */
class IconModelTest {
	IconModel im;

	@Test
	@DisplayName("Should load the icon normally")
	void shouldLoadTheIconNormally() {
		im = new IconModel("src/test/resources/testIcon.png");

		Assertions.assertEquals(MediaTracker.COMPLETE, im.getIcon().getImageLoadStatus());
	}

	@Test
	@DisplayName("The icon should be loaded with its default dimensions: w=512px, h=512px")
	void theIconShouldHaveItsDefaultDimensions() {
		im = new IconModel("src/test/resources/testIcon.png");

		Assertions.assertAll(
			() -> Assertions.assertEquals(512, im.getIcon().getIconWidth()),
			() -> Assertions.assertEquals(512, im.getIcon().getIconHeight())
		);
	}

	@Test
	@DisplayName("The icon should be loaded with 50% smaller dimensions")
	void shouldLoadIconWith50percentSmallerDimensions() {
		im = new IconModel("src/test/resources/testIcon.png", "50", "50");
		int actual = 512*50/100;

		Assertions.assertAll(
			() -> Assertions.assertEquals(actual, im.getIcon().getIconWidth()),
			() -> Assertions.assertEquals(actual, im.getIcon().getIconHeight())
		);
	}

	@ParameterizedTest
	@ValueSource(strings = {"-43", "-78", "0", "jklfgl", "fö9845ö9[]{[}", "\\///=%()+!*"})
	@DisplayName("Should load the icon with its default dimensions because every passed in data is invalid")
	void shouldLoadTheIconWithItsDefaultDimensions(String str) {
		im = new IconModel("src/test/resources/testIcon.png", str, str);

		Assertions.assertAll(
			() -> Assertions.assertEquals(512, im.getIcon().getIconWidth()),
			() -> Assertions.assertEquals(512, im.getIcon().getIconHeight())
		);
	}
}