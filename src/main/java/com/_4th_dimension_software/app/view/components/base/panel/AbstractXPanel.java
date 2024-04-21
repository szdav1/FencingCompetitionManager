package com._4th_dimension_software.app.view.components.base.panel;

import java.awt.*;

import javax.swing.JLayeredPane;

import com._4th_dimension_software.app.view.components.interfaces.CustomGraphicsUser;
import com._4th_dimension_software.app.view.components.interfaces.XComponent;
import com._4th_dimension_software.app.view.components.interfaces.XContainer;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.framework.Appearance;
import com._4th_dimension_software.support.framework.Appearances;
import com._4th_dimension_software.support.util.Util;

public abstract class AbstractXPanel extends JLayeredPane implements XComponent, XContainer, CustomGraphicsUser {
	protected Appearance appearance;
	protected final XFrame frame;

	protected AbstractXPanel(Dimension dimension, LayoutManager layoutManager, final XFrame frame, String appearanceName) {
		this.appearance = Appearances.get(appearanceName);
		this.frame = frame;

		this.setLayout(layoutManager);
		this.setPreferredSize(dimension);
		this.setBounds(new Rectangle(0, 0, dimension.width, dimension.height));
	}

	protected AbstractXPanel(Dimension dimension, final XFrame frame, String appearanceName) {
		this(dimension, null, frame, appearanceName);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
	}

	protected AbstractXPanel(int x, int y, int width, int height, LayoutManager layoutManager, final XFrame frame, String appearanceName) {
		this.appearance = Appearances.get(appearanceName);
		this.frame = frame;

		this.setLayout(layoutManager);
		this.setBounds(new Rectangle(x, y, width, height));
		this.setPreferredSize(new Dimension(width, height));
	}

	protected AbstractXPanel(int x, int y, int width, int height, final XFrame frame, String appearanceName) {
		this(x, y, width, height, null, frame, appearanceName);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
	}

	@Override
	public void paintBackground(int x, int y, int w, int h, int r, final Graphics2D g2D) {
		if (this.appearance.getBackgrounds().size() >= 2) {
			LinearGradientPaint lgp = new LinearGradientPaint(x, y, w, h, Util.calcEqualFracts(this.appearance.getBackgrounds().size()),
				this.appearance.getBackgroundsAsArray());

			g2D.setPaint(lgp);
		}
		else
			g2D.setColor(this.appearance.getBackgrounds().get(0));

		// Fill background
		g2D.fillRoundRect(x, y, this.getWidth(), this.getHeight(), r, r);
	}

	@Override
	public void paintForeground() {
	}

	@Override
	public void paintIcon() {
	}

	@Override
	public void paintBorder(int x, int y, int w, int h, int r, final Graphics2D g2D) {
		LinearGradientPaint lgp;

		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (this.appearance.getBorderModel().getThickness() <= 0)
			return;

		// Set the specified stroke
		g2D.setStroke(new BasicStroke(this.appearance.getBorderModel().getThickness(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));

		// Set the coloring of the border based on the number of colors specified in the color theme
		if (this.appearance.getBorderModel().getColorModel().getColors().size() >= 2) {
			// Draw full border
			if (this.appearance.getBorderModel().getThickness() != 0 && this.appearance.isBorderNotPainted() || this.appearance.isBorderPainted()) {
				lgp = new LinearGradientPaint(x, y, w, h, Util.calcEqualFracts(this.appearance.getBorderModel()
					.getColorModel()
					.getColors()
					.size()), this.appearance.getBorderColorsAsArray());

				g2D.setPaint(lgp);
				g2D.drawRoundRect(x, y, this.getWidth(), this.getHeight(), r, r);
			}
			else {
				// Draw top section of the border only
				if (this.appearance.isBorderSectionPainted("top")) {
					lgp = new LinearGradientPaint(0, 0, this.getWidth(), 0, Util.calcEqualFracts(this.appearance.getBorderModel()
						.getColorModel()
						.getColors()
						.size()), this.appearance.getBorderColorsAsArray());

					g2D.setPaint(lgp);
					g2D.drawLine(0, 0, this.getWidth(), 0);
				}
				// Draw right section of the border only
				if (this.appearance.isBorderSectionPainted("right")) {
					lgp = new LinearGradientPaint(this.getWidth(), 0, this.getWidth(), this.getHeight(), Util.calcEqualFracts(this.appearance.getBorderModel()
						.getColorModel()
						.getColors()
						.size()), this.appearance.getBorderColorsAsArray());

					g2D.setPaint(lgp);
					g2D.drawLine(this.getWidth(), 0, this.getWidth(), this.getHeight());
				}
				// Draw bottom section of the border only
				if (this.appearance.isBorderSectionPainted("bottom")) {
					lgp = new LinearGradientPaint(0, this.getHeight(), this.getWidth(), this.getHeight(), Util.calcEqualFracts(this.appearance.getBorderModel()
						.getColorModel()
						.getColors()
						.size()), this.appearance.getBorderColorsAsArray());

					g2D.setPaint(lgp);
					g2D.drawLine(0, this.getHeight(), this.getWidth(), this.getHeight());
				}
				// Draw left side of the border only
				if (this.appearance.isBorderSectionPainted("left")) {
					lgp = new LinearGradientPaint(0, 0, 0, this.getHeight(), Util.calcEqualFracts(this.appearance.getBorderModel()
						.getColorModel()
						.getColors()
						.size()), this.appearance.getBorderColorsAsArray());

					g2D.setPaint(lgp);
					g2D.drawLine(0, 0, 0, this.getHeight());
				}
			}
		}
		else {
			g2D.setColor(this.appearance.getBorderModel().getColorModel().getColors().get(0));

			// Draw full border
			if (this.appearance.getBorderModel().getThickness() != 0 && this.appearance.isBorderNotPainted() || this.appearance.isBorderPainted())
				g2D.drawRoundRect(x, y, this.getWidth(), this.getHeight(), r, r);
			else {
				// Draw top section of the border only
				if (this.appearance.isBorderSectionPainted("top"))
					g2D.drawLine(0, 0, this.getWidth(), 0);

				// Draw right section of the border only
				if (this.appearance.isBorderSectionPainted("right"))
					g2D.drawLine(this.getWidth(), 0, this.getWidth(), this.getHeight());

				// Draw bottom section of the border only
				if (this.appearance.isBorderSectionPainted("bottom"))
					g2D.drawLine(0, this.getHeight(), this.getWidth(), this.getHeight());

				// Draw left side of the border only
				if (this.appearance.isBorderSectionPainted("left"))
					g2D.drawLine(0, 0, 0, this.getHeight());
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		// Cast Graphics to Graphics2D
		Graphics2D g2D = (Graphics2D) g;
		g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		// Start and end coordinates for painting
		final int X = 0;
		final int Y = 0;
		final int W = this.getWidth();
		final int H = this.appearance.isLinearPaint() ? 0 : this.getHeight();
		// Roundness
		final int R = this.appearance.getBorderModel().getRoundness();

		// Background
		this.paintBackground(X, Y, W, H, R, g2D);
		// Paint the border
		this.paintBorder(X, Y, W, H, R, g2D);
		// Paint the component
		super.paint(g);

		// Destroy the Graphics2D object as it is no longer needed
		g2D.dispose();
	}
}
