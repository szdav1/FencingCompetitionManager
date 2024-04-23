package com._4th_dimension_software.support.util;

import com._4th_dimension_software.support.framework.Appearance;

import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;

public final class BorderPainter {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final int roundness;
    private final Appearance appearance;
    private final Graphics2D graphics2D;

    public BorderPainter(int x, int y, int width, int height, int roundness, Appearance appearance, final Graphics2D graphics2D) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.roundness = roundness;
        this.appearance = appearance;
        this.graphics2D = graphics2D;
    }

    public void paintFullBorder() {
        LinearGradientPaint lgp = new LinearGradientPaint(this.x, this.y, this.width, this.height, Util.calcEqualFracts(appearance.getBorderModel()
            .getColorModel()
            .getColors()
            .size()), appearance.getBorderColorsAsArray());

        this.graphics2D.setPaint(lgp);
        this.graphics2D.drawRoundRect(this.x, this.y, this.width, this.height, this.roundness, this.roundness);
    }

    public void paintTopBorder() {
        LinearGradientPaint lgp = new LinearGradientPaint(0, 0, this.width, 0, Util.calcEqualFracts(this.appearance.getBorderModel()
            .getColorModel()
            .getColors()
            .size()), this.appearance.getBorderColorsAsArray());

        this.graphics2D.setPaint(lgp);
        this.graphics2D.drawLine(0, 0, this.width, 0);
    }

    public void paintRightBorder() {
        LinearGradientPaint lgp = new LinearGradientPaint(this.width, 0, this.width, this.height, Util.calcEqualFracts(this.appearance.getBorderModel()
            .getColorModel()
            .getColors()
            .size()), this.appearance.getBorderColorsAsReversedArray());

        this.graphics2D.setPaint(lgp);
        this.graphics2D.drawLine(this.width, 0, this.width, this.height);
    }

    public void paintBottomBorder() {
        LinearGradientPaint lgp = new LinearGradientPaint(0, this.height, this.width, this.height, Util.calcEqualFracts(this.appearance.getBorderModel()
            .getColorModel()
            .getColors()
            .size()), this.appearance.getBorderColorsAsArray());

        this.graphics2D.setPaint(lgp);
        this.graphics2D.drawLine(0, this.height, this.width, this.height);
    }

    public void paintLeftBorder() {
        LinearGradientPaint lgp = new LinearGradientPaint(0, 0, 0, this.height, Util.calcEqualFracts(this.appearance.getBorderModel()
            .getColorModel()
            .getColors()
            .size()), this.appearance.getBorderColorsAsArray());

        this.graphics2D.setPaint(lgp);
        this.graphics2D.drawLine(0, 0, 0, this.height);
    }
}
