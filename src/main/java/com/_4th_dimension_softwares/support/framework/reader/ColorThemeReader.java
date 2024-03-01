package com._4th_dimension_softwares.support.framework.reader;

import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;

import com._4th_dimension_softwares.support.framework.models.*;
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
    public static HashMap<String, ColorThemeModel> readColorThemeFromXML(final String filePath) {
        HashMap<String, ColorThemeModel> colorThemeModels = new HashMap<>();

        try {
            Document colorThemeDocument = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(new File(filePath));

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

                            /*
                             * Based on the tag name of the current element, its attributes
                             * get fetched and stored in corresponding models. Each model
                             * takes care of validating the data passed in to its constructor.
                             * After creating the corresponding model, it is put into a
                             * ColorThemeModel which wil be put into the HashMap that will be
                             * returned as the result of this process. The key for each
                             * ColorThemeModel is the "applyTo" attribute of the root element node.
                             */

                            // Border
                            if (tagName.equalsIgnoreCase("border")) {
                                BorderModel bm = new BorderModel(
                                    childElement.getAttribute("colors"),
                                    childElement.getAttribute("thickness"),
                                    childElement.getAttribute("roundness")
                                );
                                ctm.setBorderModel(bm);
                            }
                            // Font
                            else if (tagName.equalsIgnoreCase("font")) {
                                FontModel fm = new FontModel(
                                    childElement.getAttribute("source"),
                                    childElement.getAttribute("family"),
                                    childElement.getAttribute("ligature"),
                                    childElement.getAttribute("size")
                                );
                                ctm.setFontModel(fm);
                            }
                            // Icon1
                            else if (tagName.equalsIgnoreCase("icon1")) {
                                IconModel im = new IconModel(
                                    childElement.getAttribute("source"),
                                    childElement.getAttribute("width"),
                                    childElement.getAttribute("height")
                                );
                                ctm.setIconModel1(im);
                            }
                            // Icon2
                            else if (tagName.equalsIgnoreCase("icon2")) {
                                IconModel im = new IconModel(
                                    childElement.getAttribute("source"),
                                    childElement.getAttribute("width"),
                                    childElement.getAttribute("height")
                                );
                                ctm.setIconModel2(im);
                            }
                            // Background
                            else if (tagName.equalsIgnoreCase("background")) {
                                ColorModel cm = new ColorModel(childElement.getAttribute("colors"));
                                ctm.setBackgroundModel(cm);
                            }
                            // Foreground
                            else if (tagName.equalsIgnoreCase("foreground")) {
                                ColorModel cm = new ColorModel(childElement.getAttribute("colors"));
                                ctm.setForegroundModel(cm);
                            }
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