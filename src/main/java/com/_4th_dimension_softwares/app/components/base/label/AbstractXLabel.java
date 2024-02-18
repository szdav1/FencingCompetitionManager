package com._4th_dimension_softwares.app.components.base.label;

import java.awt.*;

import javax.swing.JLabel;

import com._4th_dimension_softwares.app.components.interfaces.XComponent;
import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.framework.Appearance;
import com._4th_dimension_softwares.support.util.Util;

public abstract class AbstractXLabel extends JLabel implements XComponent {
	protected Appearance appearance;
	protected final XFrame frame;

	protected AbstractXLabel(Dimension dimension, String text, XFrame frame, Appearance appearance) {
		this.appearance = appearance;
		this.frame = frame;

		this.setIcon(appearance.getIcon1() == null ? appearance.getIcon2() : appearance.getIcon1());
		this.setText(text);
		this.setFont(appearance.getFont());
		this.setForeground(appearance.getForegrounds().get(0));
		this.setPreferredSize(dimension);
		this.setBounds(new Rectangle(0, 0, dimension.width, dimension.height));
	}

	protected AbstractXLabel(int x, int y, int width, int height, String text, XFrame frame, Appearance appearance) {
		this.appearance = appearance;
		this.frame = frame;

		this.setIcon(appearance.getIcon1() == null ? appearance.getIcon2() : appearance.getIcon1());
		this.setText(text);
		this.setFont(appearance.getFont());
		this.setForeground(appearance.getForegrounds().get(0));
		this.setBounds(new Rectangle(x, y, width, height));
	}

	@Override
	protected void paintComponent(Graphics g) {
		// Cast Graphics to Graphics2D
		Graphics2D g2D = (Graphics2D) g;
		g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		// Start and end coordinates for painting
		final int x = 0;
		final int y = 0;
		final int w = this.getWidth();
		final int h = this.getHeight();
		// Roundness
		final int r = this.appearance.getBorderModel().getRoundness();
		// Linear Gradient Paint
		LinearGradientPaint lgp;

		// Background
		if (this.appearance.getBackgrounds().size() >= 2) {
			lgp = new LinearGradientPaint(x, y, w, h, Util.calcEqualFracts(this.appearance.getBackgrounds().size()),
				this.appearance.getBackgroundsAsArray());

			g2D.setPaint(lgp);
		}
		else
			g2D.setColor(this.appearance.getBackgrounds().get(0));

		// Fill background
		g2D.fillRoundRect(x, y, w, h, r, r);

		// Border
		if (this.appearance.getBorderModel().getThickness() != 0) {
			g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			if (this.appearance.getBorderModel().getColorModel().getColors().size() >= 2) {
				lgp = new LinearGradientPaint(x, y, w, h, Util.calcEqualFracts(this.appearance.getBorderModel()
					.getColorModel()
					.getColors()
					.size()), this.appearance.getBorderColorsAsArray());

				g2D.setPaint(lgp);
				g2D.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
			}
			else
				g2D.setColor(this.appearance.getBorderModel().getColorModel().getColors().get(0));

			// Draw border
			g2D.drawRoundRect(x, y, w, h, r, r);
		}

		// Paint Icon and Text
		super.paintComponent(g);
	}
}
