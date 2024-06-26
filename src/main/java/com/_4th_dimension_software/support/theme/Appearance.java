package com._4th_dimension_software.support.theme;

import java.awt.Color;
import java.util.Collections;

import com._4th_dimension_software.support.theme.models.ColorThemeModel;

/**
 * The <code>Appearance</code> class is a class that stores
 * every appearance related data in a specified format.
 * This is the last stage of the color theme interpretation.
 * Every data is received from a <code>ColorThemeModel</code>, and stored
 * in the corresponding way.
 * <p></p>
 * Custom components are stylized based on the
 * data stored by this class's fields. This class also
 * has methods that help working with <code>Graphics</code>, as some
 * fields do not have the corresponding type, but can be easily
 * converted to it.
 *
 * @author szd
 */
public final class Appearance extends AbstractAppearance {
    /**
     * Constructs an <code>Appearance</code> object. This object
     * stores information for component styling,
     * and every field of the class represents a style
     * element that can be implemented on the desired
     * component. The fields are already validated when
     * they get into this class.
     */
    public Appearance() {
    }

    /**
     * Constructs an <code>Appearance</code> object. This object
     * stores information for component styling,
     * and every field of the class represents a style
     * element that can be implemented on the desired
     * component. The fields are already validated when
     * they get into this class.
     *
     * @param colorThemeModel The ColorThemeModel that should be converted to Appearance
     */
    public Appearance(final ColorThemeModel colorThemeModel) {
        super(colorThemeModel);
    }

    /**
     * Reverses the colors of the background.
     */
    public void reverseBackgrounds() {
        Collections.reverse(this.backgrounds);
    }

    /**
     * Reverses the colors of the foreground.
     */
    public void reverseForegrounds() {
        Collections.reverse(this.foregrounds);
    }

    /**
     * Reverses the colors of the border.
     */
    public void reverseBorderColors() {
		Collections.reverse(this.borderModel.getColorModel().getColors());
    }

    /**
     * Returns the summary value of the booleans
     * in the borderPaintRules <code>HashMap</code>. If
     * only one of the values is false, the return value is
     * going to be false as well.
     *
     * @return The sum value of the contents of the borderPaintRules <code>HashMap</code>
     */
    public boolean isBorderPainted() {
        return this.borderPaintRules.get("top") &&
            this.borderPaintRules.get("right") &&
            this.borderPaintRules.get("bottom") &&
            this.borderPaintRules.get("left");
    }

    /**
     * Returns the summary value of the booleans
     * in the borderPaintRules <code>HashMap</code>. If
     * only one of the values is true, the return value is
     * going to be true as well.
     *
     * @return The sum value of the contents of the borderPaintRules <code>HashMap</code>
     */
    public boolean isBorderNotPainted() {
        return !this.borderPaintRules.get("top") &&
            !this.borderPaintRules.get("right") &&
            !this.borderPaintRules.get("bottom") &&
            !this.borderPaintRules.get("left");
    }

    /**
     * Returns whether the specified section of the border
     * should be painted or not.
     *
     * @param sectionName The name of the section of the border
     * @return Whether the specified section should be painted or not
     */
    public boolean isBorderSectionPainted(String sectionName) {
        if (!this.borderPaintRules.containsKey(sectionName))
            return true;

        return this.borderPaintRules.get(sectionName);
    }

    /**
     * Converts the backgrounds <code>ArrayList</code> to an
     * array that contains the same data as the ArrayList.
     *
     * @return The array representation of the backgrounds ArrayList
     */
    public Color[] getBackgroundsAsArray() {
        Color[] colors = new Color[this.backgrounds.size()];

        for (int i = 0; i < this.backgrounds.size(); i++) {
            colors[i] = this.backgrounds.get(i);
        }

        return colors;
    }

    /**
     * Converts the foregrounds <code>ArrayList</code> into an
     * array that contains the same data as the ArrayList.
     *
     * @return The array representation of the foregrounds ArrayList
     */
    public Color[] getForegroundsAsArray() {
        Color[] colors = new Color[this.foregrounds.size()];

        for (int i = 0; i < this.foregrounds.size(); i++) {
            colors[i] = this.foregrounds.get(i);
        }

        return colors;
    }

    /**
     * Retrieves the colors of the <code>BorderModel</code>
     * in a <code>Color</code> array.
     *
     * @return The array representation of the <code>BorderModel</code>'s
     * color configuration
     */
    public Color[] getBorderColorsAsArray() {
        Color[] colors = new Color[this.borderModel.getColorModel().getColors().size()];

        for (int i = 0; i < this.borderModel.getColorModel().getColors().size(); i++) {
            colors[i] = this.borderModel.getColorModel().getColors().get(i);
        }

        return colors;
    }

    /**
     * Converts the backgrounds <code>ArrayList</code> to a
     * reversed array that contains the same data as the ArrayList.
     *
     * @return The array representation of the backgrounds ArrayList
     */
    public Color[] getBackgroundsAsReversedArray() {
        Color[] colors = new Color[this.foregrounds.size()];
        int j = 0;

        for (int i = this.foregrounds.size()-1; i >= 0; i--) {
            colors[j] = this.foregrounds.get(i);
            j++;
        }

        return colors;
    }

    /**
     * Converts the foregrounds <code>ArrayList</code> into a
     * reversed array that contains the same data as the ArrayList.
     *
     * @return The array representation of the foregrounds ArrayList
     */
    public Color[] getForegroundsAsReversedArray() {
        Color[] colors = new Color[this.foregrounds.size()];
        int j = 0;

        for (int i = 0; i < this.backgrounds.size(); i--) {
            colors[j] = this.backgrounds.get(i);
            j++;
        }

        return colors;
    }

    /**
     * Retrieves the colors of the <code>BorderModel</code>
     * in a reversed <code>Color</code> array.
     *
     * @return The array representation of the <code>BorderModel</code>'s
     * color configuration
     */
    public Color[] getBorderColorsAsReversedArray() {
        Color[] colors = new Color[this.borderModel.getColorModel().getColors().size()];
        int j = 0;

        for (int i = this.borderModel.getColorModel().getColors().size()-1; i >= 0; i--) {
            colors[j] = this.borderModel.getColorModel().getColors().get(i);
            j++;
        }

        return colors;
    }
}
