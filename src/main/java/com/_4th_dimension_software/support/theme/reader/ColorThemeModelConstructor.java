package com._4th_dimension_software.support.theme.reader;

import com._4th_dimension_software.support.theme.models.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class ColorThemeModelConstructor {
	public static void handleDefinitions(final Element element) {
		System.out.println(element.getTagName());
	}

	/**
	 * Handles the <code>modifiers</code> tag in the color theme
	 * document. This method takes care of validating and processing
	 * every child element of the <code>specified element</code> and
	 * put the corresponding values into the specified <code>color theme model</code>.
	 *
	 * @param element The <code>Element</code> of the current iteration
	 * @param ctm     The <code>ColorThemeModel</code> of the current iteration
	 */
	private static void handleModifiers(final Element element, final ColorThemeModel ctm) {
		NodeList elementChildren = element.getChildNodes();

		for (int i = 0; i < elementChildren.getLength(); i++) {
			if (elementChildren.item(i).getNodeType() != Node.ELEMENT_NODE)
				continue;

			Element childElement = (Element) elementChildren.item(i);

			if (childElement.getTagName().equalsIgnoreCase("paint"))
				ctm.setLinearPaint(childElement.getAttribute("linear"));

			else if (childElement.getTagName().equalsIgnoreCase("border")) {
				ctm.setBorderPaintRule("top", childElement.getAttribute("top"));
				ctm.setBorderPaintRule("right", childElement.getAttribute("right"));
				ctm.setBorderPaintRule("bottom", childElement.getAttribute("bottom"));
				ctm.setBorderPaintRule("left", childElement.getAttribute("left"));
			}
		}
	}

	/**
	 * Initializes the values of the specified <code>ColorThemeModel</code>
	 * based on the given tag name and the current element of the iteration.
	 *
	 * @param tagName The name of the current tag
	 * @param element The current child <code>Element</code>
	 * @param ctm     The <code>ColorThemeModel</code> object that's currently being constructed
	 */
	public static void constructColorThemeModel(final String tagName, final Element element, final ColorThemeModel ctm) {
		switch (tagName.toLowerCase()) {
			// Border
			case "border" -> {
				BorderModel bm = new BorderModel(
					element.getAttribute("colors"),
					element.getAttribute("thickness"),
					element.getAttribute("roundness")
				);
				ctm.setBorderModel(bm);
			}
			// Font
			case "font" -> {
				FontModel fm = new FontModel(
					element.getAttribute("source"),
					element.getAttribute("family"),
					element.getAttribute("ligature"),
					element.getAttribute("size")
				);
				ctm.setFontModel(fm);
			}
			// Icon1
			case "icon1" -> {
				IconModel im = new IconModel(
					element.getAttribute("source"),
					element.getAttribute("width"),
					element.getAttribute("height"),
					element.getAttribute("color")
				);
				ctm.setIconModel1(im);
			}
			// Icon2
			case "icon2" -> {
				IconModel im = new IconModel(
					element.getAttribute("source"),
					element.getAttribute("width"),
					element.getAttribute("height"),
					element.getAttribute("color")
				);
				ctm.setIconModel2(im);
			}
			// Icon3
			case "icon3" -> {
				IconModel im = new IconModel(
					element.getAttribute("source"),
					element.getAttribute("width"),
					element.getAttribute("height"),
					element.getAttribute("color")
				);
				ctm.setIconModel3(im);
			}
			// Icon4
			case "icon4" -> {
				IconModel im = new IconModel(
					element.getAttribute("source"),
					element.getAttribute("width"),
					element.getAttribute("height"),
					element.getAttribute("color")
				);
				ctm.setIconModel4(im);
			}
			// Background
			case "background" -> {
				ColorModel cm = new ColorModel(element.getAttribute("colors"));
				ctm.setBackgroundModel(cm);
			}
			// Foreground
			case "foreground" -> {
				ColorModel cm = new ColorModel(element.getAttribute("colors"));
				ctm.setForegroundModel(cm);
			}
			case "modifiers" -> handleModifiers(element, ctm);
		}
	}
}
