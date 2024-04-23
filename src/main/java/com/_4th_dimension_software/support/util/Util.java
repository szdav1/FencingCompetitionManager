package com._4th_dimension_software.support.util;

import java.awt.Color;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.util.macros.IntValidator;

/**
 * Contains utility methods and fields.
 * Many of the defined methods in this class
 * are very specific for this application or even
 * for a part of the application.
 * For example, many of the methods below are specially
 * designed and developed to help make color them processing
 * faster, and the related code more readable.
 *
 * @author szd
 */
public final class Util {
	// Not instantiatable
	private Util() {
	}

	/**
	 * Determines whether the specified number
	 * is valid to represent a value in an RGB color
	 * or not. If the number given is less than 0 or
	 * higher than 255 the method returns false,
	 * otherwise true. (0 <= n <= 255)
	 *
	 * @param num The number that needs to be checked
	 * @return whether the number is valid or not
	 */
	public static boolean isValidForRGB(int num) {
		return num >= 0 && num <= 255;
	}

	/**
	 * Determines the integer representation
	 * of the specified string. This method is
	 * a copy of the <code>Integer.parseInt()</code> method,
	 * only this method will not throw any exceptions
	 * if the specified string is invalid, instead, it
	 * will return the maximum integer value in negative.
	 * In this case, this can be done because for sure, the
	 * software will never encounter such big number.
	 *
	 * @param str The string that needs to be converted to integer
	 * @return The integer representation of the string, or -1 if the
	 * string is invalid
	 */
	public static int toInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch (Exception exception) {
			return -Integer.MAX_VALUE;
		}
	}

	/**
	 * Determines the integer representation
	 * of the specified string. This method is
	 * a copy of the <code>Integer.parseInt()</code> method,
	 * only this method will not throw any exceptions
	 * if the specified string is invalid, instead, it
	 * will return the defValue second parameter. This is
	 * useful when dealing with color theme interpretation
	 * because if an invalid string is found instead of a
	 * number, the method will simply return the defined number,
	 * and the specified value will be set to the desired default
	 * number.
	 *
	 * @param str      The string that needs to be converted to integer
	 * @param defValue The default value which gets returned if a problem
	 *                 occurs during transformation
	 * @return The integer representation of the string, or default value if the
	 * string is invalid
	 */
	public static int toInt(String str, int defValue) {
		try {
			return Integer.parseInt(str);
		}
		catch (Exception exception) {
			return defValue;
		}
	}

	/**
	 * Converts the specified string to an integer.
	 * The converted string only gets returned in
	 * integer format if it fulfills the <code>IntValidator</code>'s
	 * condition. This means that if the received number
	 * is for example not high enough, or less than 0,
	 * the specified default value will be returned.
	 *
	 * @param str      The string that should be converted to an integer
	 * @param defValue The default value that should be returned if the integer is incorrect
	 * @param macro    IntValidator interface, this defines the certain condition when the integer is correct
	 * @return The received number from the string if it fulfills the specified condition,
	 * default value otherwise
	 */
	public static int toInt(String str, int defValue, IntValidator macro) {
		int i = toInt(str);

		if (macro.checkIntCorrectness(i) && i != -Integer.MAX_VALUE)
			return i;
		else
			return defValue;
	}

	/**
	 * Converts the given integer <code>List</code> into a
	 * valid color. If the list misses one item,
	 * black is returned as a default color.
	 *
	 * @param ints The list that should be converted into a color
	 * @return The Color representation of the array
	 */
	public static Color listToColor(List<Integer> ints) {
		if (ints.size() < 4)
			return Color.black;

		for (int i = 0; i < ints.size(); i++) {
			if (!isValidForRGB(ints.get(i)))
				ints.set(i, 0);
		}

		return new Color(ints.get(0), ints.get(1), ints.get(2), ints.get(3));
	}

	/**
	 * Loads an <code>ImageIcon</code> and scales it based on the
	 * specified percentages. The newly constructed icon
	 * will be returned after scaling it.
	 *
	 * @param source           The path of the icon
	 * @param widthPercentage  The amount of percentage the icon should be resized on the X axis
	 * @param heightPercentage The amount of percentage the icon should be resized on the Y axis
	 * @return A scaled <code>ImageIcon</code> that was created from the specified source
	 */
	public static ImageIcon loadImageIcon(final String source, int widthPercentage, int heightPercentage) {
		ImageIcon i = new ImageIcon(ResourceHandler.get(source));

		return new ImageIcon(i.getImage().getScaledInstance(SizeData.PROPORTIONALITY_FACTOR*(widthPercentage*10),
			SizeData.PROPORTIONALITY_FACTOR*(heightPercentage*10), Image.SCALE_SMOOTH));
	}

	/**
	 * Loads and <code>ImageIcon</code> from the specified
	 * source, with maintaining the default size
	 * of the icon.
	 *
	 * @param source The path of the icon
	 * @return The <code>ImageIcon</code> that was created from the specified source
	 */
	public static ImageIcon loadImageIcon(final String source) {
		return new ImageIcon(ResourceHandler.get(source));
	}

	/**
	 * Compares two colors by their RGB values.
	 * Returns true, if the two colors' Red, Green, Blue
	 * and Opacity values are identical, returns false otherwise.
	 * The difference between this method and the standard equals()
	 * method of the Color class is that this one only cares
	 * for the color values. If every value is the same, the
	 * two colors are the same.
	 *
	 * @param c1 A color that should be compared with another color
	 * @param c2 The other color that should be compared to the other
	 * @return True if every RGB value is identical, false if not
	 */
	public static boolean compareColors(Color c1, Color c2) {
		return c1.getRed() == c2.getRed() &&
			c1.getGreen() == c2.getGreen() &&
			c1.getBlue() == c2.getBlue() &&
			c1.getAlpha() == c2.getAlpha();
	}

	/**
	 * Calculates equal size fractions for <code>Color</code>s
	 * in a <code>LinearGradientPaint</code>. Every fraction size
	 * must be between 1 and zero and must be a <code>float</code>.
	 * The fraction values must follow each other in ascending order too.
	 * The fraction values are returned in a <code>float array</code>.
	 *
	 * @param numberOfFracts The desired number of fractions
	 * @return A <code>float array</code> filled with ascending fraction values
	 */
	public static float[] calcEqualFracts(int numberOfFracts) {
		float[] fracts = new float[numberOfFracts];
		fracts[0] = 1.0f/fracts.length;

		for (int i = 1; i < fracts.length; i++) {
			fracts[i] = fracts[0]+fracts[i-1];
		}

		return fracts;
	}

	/**
	 * Separates the <code>Color</code>s in the specified <code>List</code>
	 * into two halves. The results of the process are returned in a <code>List</code>
	 * object, which contains the two <code>array</code>s that are filled with the
	 * colors from the specified <code>List</code>.
	 *
	 * @param colors The <code>List</code> that's content should be separated
	 * @return A <code>List</code> containing the two halves of the specified <code>List</code>
	 */
	public static List<Color[]> halveColors(List<Color> colors) {
		Color[] cs1 = new Color[colors.size()/2];
		Color[] cs2 = new Color[colors.size()%2 != 0 ? colors.size()/2+1 : colors.size()/2];
		int j = 0;

		for (int i = 0; i < colors.size()/2; i++) {
			cs1[i] = colors.get(i);
		}

		for (int i = colors.size()/2; i < colors.size(); i++) {
			cs2[j] = colors.get(i);
			j++;
		}

		return List.of(cs1, cs2);
	}

	/**
	 * Returns the boolean value of a string. If the specified
	 * string is not appropriate to be translated to a boolean,
	 * the specified default value is returned. Else, the boolean
	 * value of the defined string gets returned.
	 *
	 * @param str          The string that should be turned into a boolean
	 * @param defaultValue The default value that should get returned in case of an invalid string
	 * @return The boolean representation of the specified string or the default value
	 */
	public static boolean toBoolean(String str, boolean defaultValue) {
		if (str.isBlank())
			return defaultValue;

		return Boolean.parseBoolean(str);
	}
}
