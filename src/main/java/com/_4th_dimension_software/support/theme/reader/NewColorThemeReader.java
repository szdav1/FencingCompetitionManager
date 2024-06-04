package com._4th_dimension_software.support.theme.reader;

import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;

import com._4th_dimension_software.support.theme.models.ColorThemeModel;
import com._4th_dimension_software.support.util.ResourceHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class NewColorThemeReader {
	// Not instantiatable
	private NewColorThemeReader(){
	}

	public static HashMap<String, ColorThemeModel> readFromXML(final String filePath) {
		HashMap<String, ColorThemeModel> ctms = new HashMap<>();

		try {
			Document colorThemeDocument = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder()
				.parse(new File(ResourceHandler.get(filePath)));

			colorThemeDocument.normalize();

			NodeList rootNodes = colorThemeDocument.getElementsByTagName("appearance");

			for (int i = 0; i < rootNodes.getLength(); i++) {
				Node rootNode = rootNodes.item(i);

				if (rootNode.getNodeType() != Node.ELEMENT_NODE)
					continue;

				Element rootElement = (Element) rootNode;
				NodeList childNodes = rootElement.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++) {
					Node childNode = childNodes.item(j);

					if (childNode.getNodeType() != Node.ELEMENT_NODE)
						continue;

					Element childElement = (Element) childNode;
					System.out.println(childElement.getTagName() + " => " + childElement.getAttribute("applyto"));
				}
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

		return null;
	}
}
