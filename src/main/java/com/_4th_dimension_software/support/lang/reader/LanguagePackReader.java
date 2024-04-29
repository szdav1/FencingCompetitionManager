package com._4th_dimension_software.support.lang.reader;

import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;

import com._4th_dimension_software.support.util.ResourceHandler;
import org.w3c.dom.*;

/**
 * The <code>LanguagePackReader</code> class reads
 * and structures a specified XML file that contains
 * language data in the appropriate format.
 */
public class LanguagePackReader {
	// Not instantiatable
	private LanguagePackReader() {
	}

	/**
	 * Loads a <code>LanguagePack</code> based on the specified
	 * file that's location was provided. Every value inside the
	 * language pack is kept as defined in the file, making the querying
	 * process case-sensitive. The values are trimmed to avoid whitespace
	 * characters. The result is fed to the <code>LanguagePackLoader</code>
	 * which creates the <code>LanguagePack</code> for the runtime of the application.
	 *
	 * @param filePath The path of the language pack XML file
	 * @return A filled <code>HashMap</code> that contains the concatenated
	 * keys and simple values from the specified file
	 */
	public static HashMap<String, String> readFromXML(final String filePath) {
		HashMap<String, String> strs = new HashMap<>();

		try {
			Document languagePackDocument = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder()
				.parse(new File(ResourceHandler.get(filePath)));

			languagePackDocument.normalize();

			StringBuilder strb = new StringBuilder();

			NodeList rootNodes = languagePackDocument.getElementsByTagName("words");

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
					NodeList deepNodes = childElement.getChildNodes();

					for (int k = 0; k < deepNodes.getLength(); k++) {
						Node deepNode = deepNodes.item(k);

						if (deepNode.getNodeType() != Node.TEXT_NODE)
							continue;

						Text text = (Text) deepNode;

						strb.delete(0, strb.length());

						String key = strb.append(rootElement.getAttribute("for"))
							.append(".")
							.append(childElement.getTagName())
							.toString();

						String value = text.getData().trim();

						strs.put(key, value);
					}
				}
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

		return strs;
	}
}
