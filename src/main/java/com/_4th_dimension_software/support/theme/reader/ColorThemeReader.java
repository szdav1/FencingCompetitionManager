package com._4th_dimension_software.support.theme.reader;

import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;

import com._4th_dimension_software.support.theme.definitions.ColorDefinitions;
import com._4th_dimension_software.support.theme.models.*;
import com._4th_dimension_software.support.util.ResourceHandler;
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

	private static void handleDefinitions(final Document ctd) {
		NodeList defNodes = ctd.getElementsByTagName("ColorDefinitions");

		for (int i = 0; i < defNodes.getLength(); i++) {
			Node rootNode = defNodes.item(i);

			if (rootNode.getNodeType() != Node.ELEMENT_NODE)
				continue;

			Element rootElement = (Element) rootNode;
			NodeList childNodes = rootElement.getChildNodes();

			for (int j = 0; j < childNodes.getLength(); j++) {
				Node childNode = childNodes.item(j);

				if (childNode.getNodeType() != Node.ELEMENT_NODE)
					continue;

				Element childElement = (Element) childNode;
//				System.out.println(childElement.getTagName() + " => " + childElement.getAttribute("colors"));
				ColorDefinitions.addDefinition(childElement.getTagName(), childElement.getAttribute("colors"));
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
		ColorDefinitions.init();

		try {
			Document ctd = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder()
				.parse(new File(ResourceHandler.get(filePath)));

			ctd.normalize();

			// Parse the definitions
			handleDefinitions(ctd);

			// Get the appearances
			NodeList rootNodes = ctd.getElementsByTagName("Appearance");

			for (int i = 0; i < rootNodes.getLength(); i++) {
				Node rootNode = rootNodes.item(i);

				if (rootNode.getNodeType() != Node.ELEMENT_NODE)
					continue;

				Element rootElement = (Element) rootNode;
				NodeList childNodes = rootElement.getChildNodes();
				// Instantiate a ColorThemeModel for the current iteration
				ColorThemeModel ctm = new ColorThemeModel();

				for (int j = 0; j < childNodes.getLength(); j++) {
					Node childNode = childNodes.item(j);

					if (childNode.getNodeType() != Node.ELEMENT_NODE)
						continue;

					Element childElement = (Element) childNode;
					String tagName = childElement.getTagName().toLowerCase();
					ColorThemeModelConstructor.constructColorThemeModel(tagName, childElement, ctm);
				}
				// Place the currently generated ColorThemeModel into the HashMap
				colorThemeModels.put(rootElement.getAttribute("applyTo"), ctm);
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

		return colorThemeModels;
	}
}