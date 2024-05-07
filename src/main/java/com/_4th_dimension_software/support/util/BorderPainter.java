package com._4th_dimension_software.support.util;

import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;

import com._4th_dimension_software.support.consts.PaintMethod;
import com._4th_dimension_software.support.theme.Appearance;

/**
 * The <code>BorderPainter</code> class defines methods
 * that either paint the full border of a component using,
 * or paints parts of the border that were defined in the
 * color theme file. The painting happens using the component's
 * original Graphics object that was cast to a Graphics2D object.
 * Based on the number of colors defined for the border, the BorderPainter
 * will automatically configure itself to use gradient or single color
 * painting method.
 *
 * @author szd
 */
public final class BorderPainter {
	private final int x;
	private final int y;
	private final int width;
	private final int height;
	private final int roundness;
	private final Appearance appearance;
	private final Graphics2D graphics2D;
	private final PaintMethod paintMethod;

	/**
	 * Constructs a <code>BorderPainter</code> object. This
	 * object can be used to paint the border of certain components
	 * displayed on the screen.
	 *
	 * @param x          The X coordinate of the component
	 * @param y          The Y coordinate of the component
	 * @param width      The width of the component
	 * @param height     The height of the component
	 * @param roundness  The roundness of the border defined in the color them file for the component
	 * @param appearance The <code>Appearance</code> of the component
	 * @param graphics2D The <code>Graphics2D</code> object of the component
	 */
	public BorderPainter(int x, int y, int width, int height, int roundness, Appearance appearance, final Graphics2D graphics2D) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.roundness = roundness;
		this.appearance = appearance;
		this.graphics2D = graphics2D;
		this.paintMethod = this.appearance.getBorderModel()
			.getColorModel()
			.getColors()
			.size() >= 2 ? PaintMethod.GRADIENT : PaintMethod.SINGLE_COLOR;

		if (paintMethod == PaintMethod.SINGLE_COLOR)
			this.graphics2D.setColor(this.appearance.getBorderModel().getColorModel().getColors().get(0));
	}

	/**
	 * Paints the full border of a component.
	 */
	public void paintFullBorder() {
		if (this.paintMethod == PaintMethod.GRADIENT) {
			LinearGradientPaint lgp = new LinearGradientPaint(this.x, this.y, this.width, this.height, Util.calcEqualFracts(appearance.getBorderModel()
				.getColorModel()
				.getColors()
				.size()), appearance.getBorderColorsAsArray());

			this.graphics2D.setPaint(lgp);
			this.graphics2D.drawRoundRect(this.x, this.y, this.width, this.height, this.roundness, this.roundness);
		}
		else
			this.graphics2D.drawRoundRect(x, y, this.width, this.height, this.roundness, this.roundness);
	}

	/**
	 * Paints the top section of the border
	 * of the component.
	 */
	public void paintTopBorder() {
		if (this.paintMethod == PaintMethod.GRADIENT) {
			LinearGradientPaint lgp = new LinearGradientPaint(0, 0, this.width, 0, Util.calcEqualFracts(this.appearance.getBorderModel()
				.getColorModel()
				.getColors()
				.size()), this.appearance.getBorderColorsAsArray());

			this.graphics2D.setPaint(lgp);
			this.graphics2D.drawLine(0, 0, this.width, 0);
		}
		else
			this.graphics2D.drawLine(0, 0, this.width, 0);
	}

	/**
	 * Paints the right section of the border
	 * of the component.
	 */
	public void paintRightBorder() {
		if (this.paintMethod == PaintMethod.GRADIENT) {
			LinearGradientPaint lgp = new LinearGradientPaint(this.width, 0, this.width, this.height, Util.calcEqualFracts(this.appearance.getBorderModel()
				.getColorModel()
				.getColors()
				.size()), this.appearance.getBorderColorsAsReversedArray());

			this.graphics2D.setPaint(lgp);
			this.graphics2D.drawLine(this.width, 0, this.width, this.height);
		}
		else
			this.graphics2D.drawLine(this.width, 0, this.width, this.height);
	}

	/**
	 * Paints the bottom section of the border
	 * of the component.
	 */
	public void paintBottomBorder() {
		if (this.paintMethod == PaintMethod.GRADIENT) {
			LinearGradientPaint lgp = new LinearGradientPaint(0, this.height, this.width, this.height, Util.calcEqualFracts(this.appearance.getBorderModel()
				.getColorModel()
				.getColors()
				.size()), this.appearance.getBorderColorsAsArray());

			this.graphics2D.setPaint(lgp);
			this.graphics2D.drawLine(0, this.height, this.width, this.height);
		}
		else
			this.graphics2D.drawLine(0, this.height, this.width, this.height);
	}

	/**
	 * Paints the left section of the border
	 * of the component.
	 */
	public void paintLeftBorder() {
		if (this.paintMethod == PaintMethod.GRADIENT) {
			LinearGradientPaint lgp = new LinearGradientPaint(0, 0, 0, this.height, Util.calcEqualFracts(this.appearance.getBorderModel()
				.getColorModel()
				.getColors()
				.size()), this.appearance.getBorderColorsAsArray());

			this.graphics2D.setPaint(lgp);
			this.graphics2D.drawLine(0, 0, 0, this.height);
		}
		else
			this.graphics2D.drawLine(0, 0, 0, this.height);
	}
}
