package com._4th_dimension_software.support.framework.reader;

import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;

import com._4th_dimension_software.support.framework.models.*;
import com._4th_dimension_software.support.util.ResourceHandler;
import com._4th_dimension_software.support.util.Util;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Reads the values from the specified color
 * theme file and structures it into a HashMap.
 *
 * @author szd
 */
public final class ColorThemeReader {
	// Not instantiatable
	private ColorThemeReader() {
	}

	/**
	 * Initializes the values of the specified <code>ColorThemeModel</code>
	 * based on the given tag name and the current element of the iteration.
	 *
	 * @param tagName The name of the current tag
	 * @param element The current child <code>Element</code>
	 * @param ctm     The <code>ColorThemeModel</code> object that's currently being constructed
	 */
	private static void constructColorThemeModel(final String tagName, final Element element, final ColorThemeModel ctm) {
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
					element.getAttribute("height")
				);
				ctm.setIconModel1(im);
			}
			// Icon2
			case "icon2" -> {
				IconModel im = new IconModel(
					element.getAttribute("source"),
					element.getAttribute("width"),
					element.getAttribute("height")
				);
				ctm.setIconModel2(im);
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
		}
	}

	/**
	 * Reads the values from the specified color theme
	 * file and structures them into a <code>HashMap</code>. Inside the
	 * <code>HashMap</code>, the <code>ColorThemeModels</code> which are constructed during
	 * the reading operation by separately creating the corresponding
	 * models based on the current line's tag name, are stored as values
	 * and the component's name as key for easier access. The created
	 * models are then put into the <code>ColorThemeModel</code>'s constructor, and the
	 * <code>ColorThemeModel</code>s are put into the <code>HashMap</code>.
	 *
	 * @param filePath The path of the file that contains the color theme values
	 * @return A <code>HashMap</code> that contains the component's name as key, and the
	 * constructed <code>ColorThemeModel</code>s as values
	 */
	public static HashMap<String, ColorThemeModel> readFromXML(final String filePath) {
		HashMap<String, ColorThemeModel> colorThemeModels = new HashMap<>();

		try {
			Document colorThemeDocument = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder()
				.parse(new File(ResourceHandler.get(filePath)));

			colorThemeDocument.normalize();

			NodeList rootNodes = colorThemeDocument.getElementsByTagName("appearance");

			for (int i = 0; i < rootNodes.getLength(); i++) {
				Node rootNode = rootNodes.item(i);

				if (rootNode.getNodeType() == Node.ELEMENT_NODE) {
					Element rootElement = (Element) rootNode;
					NodeList childNodes = rootElement.getChildNodes();
					// Instantiate a ColorThemeModel for the current iteration
					ColorThemeModel ctm = new ColorThemeModel();

					for (int j = 0; j < childNodes.getLength(); j++) {
						Node childNode = childNodes.item(j);

						if (childNode.getNodeType() == Node.ELEMENT_NODE) {
							Element childElement = (Element) childNode;
							String tagName = childElement.getTagName().toLowerCase();
							constructColorThemeModel(tagName, childElement, ctm);
						}
					}
					// Place the currently generated ColorThemeModel into the HashMap
					colorThemeModels.put(rootElement.getAttribute("applyTo"), ctm);
				}
			}
		}
		catch (Exception exc) {
			exc.printStackTrace(); //TODO: Implement backup theme (in-code theme)
		}

		return colorThemeModels;
	}
}