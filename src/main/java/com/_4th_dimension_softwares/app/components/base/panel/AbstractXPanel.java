package com._4th_dimension_softwares.app.components.base.panel;

import java.awt.*;

import javax.swing.JLayeredPane;

import com._4th_dimension_softwares.app.components.interfaces.XComponent;
import com._4th_dimension_softwares.app.components.interfaces.XContainer;
import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.framework.Appearance;
import com._4th_dimension_softwares.support.util.Util;

public abstract class AbstractXPanel extends JLayeredPane implements XComponent, XContainer {
	protected Appearance appearance;
	protected final XFrame frame;

	protected AbstractXPanel(Dimension dimension, LayoutManager layoutManager, XFrame frame, Appearance appearance) {
		this.appearance = appearance;
		this.frame = frame;

		this.setLayout(layoutManager);
		this.setPreferredSize(dimension);
		this.setBounds(new Rectangle(0, 0, dimension.width, dimension.height));
	}

	protected AbstractXPanel(Dimension dimension, XFrame frame, Appearance appearance) {
		this(dimension, new FlowLayout(FlowLayout.CENTER, 0, 0), frame, appearance);
	}

	protected AbstractXPanel(int x, int y, int width, int height, LayoutManager layoutManager, XFrame frame, Appearance appearance) {
		this.appearance = appearance;
		this.frame = frame;

		this.setLayout(layoutManager);
		this.setBounds(new Rectangle(x, y, width, height));
		this.setPreferredSize(new Dimension(width, height));
	}

	protected AbstractXPanel(int x, int y, int width, int height, XFrame frame, Appearance appearance) {
		this(x, y, width, height, new FlowLayout(FlowLayout.CENTER, 0, 0), frame, appearance);
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
			}
			else
				g2D.setColor(this.appearance.getBorderModel().getColorModel().getColors().get(0));

			g2D.setStroke(new BasicStroke(this.appearance.getBorderModel().getThickness(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
			// Draw border
			g2D.drawRoundRect(x, y, w, h, r, r);
		}

		// Paint added components
		super.paintComponent(g);
	}
}
