package com._4th_dimension_software.support.settings.reader;

import com._4th_dimension_software.support.util.ResourceHandler;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;

/**
 * The <code>SettingsReader</code> class reads the specified
 * XML file's content and structures it into a <code>HashMap</code>.
 *
 * @author szd
 */
public final class SettingsReader {
    /**
     * Reads and structures the contents of the specified
     * file into a <code>HashMap</code>.
     *
     * @param filePath The path of the desired XML file
     * @return A <code>HashMap</code> that contains the read
     * and processed data of the specified file
     */
    public static HashMap<String, String> readFromXML(final String filePath) {
        HashMap<String, String> settings = new HashMap<>();

        try {
            Document settingsDocument = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(new File(ResourceHandler.get(filePath)));

            settingsDocument.normalize();

            NodeList rootNodes = settingsDocument.getChildNodes();

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
                        settings.put(childElement.getNodeName(), text.getData());
                    }
                }
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

        return settings;
    }
}
