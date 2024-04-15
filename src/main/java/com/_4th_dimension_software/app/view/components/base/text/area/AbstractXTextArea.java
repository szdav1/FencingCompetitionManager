package com._4th_dimension_software.app.view.components.base.text.area;

import java.awt.*;

import javax.swing.JTextArea;

import com._4th_dimension_software.app.view.components.interfaces.CustomGraphicsUser;
import com._4th_dimension_software.app.view.components.interfaces.XComponent;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.framework.Appearance;
import com._4th_dimension_software.support.framework.Appearances;
import com._4th_dimension_software.support.util.Util;

public abstract class AbstractXTextArea extends JTextArea implements XComponent, CustomGraphicsUser {
	protected Appearance appearance;
	protected final XFrame frame;

	protected AbstractXTextArea(Dimension dimension, String text, final XFrame frame, String appearanceName) {
		this.appearance = Appearances.get(appearanceName);
		this.frame = frame;

		this.setText(text);
		this.setFont(appearance.getFont());
		this.setForeground(appearance.getForegrounds().get(0));
		this.setCaretColor(this.getForeground());
		this.setOpaque(false);
		this.setBorder(null);
		this.setBounds(new Rectangle(0, 0, dimension.width, dimension.height));
		this.setPreferredSize(dimension);
	}

	protected AbstractXTextArea(Dimension dimension, final XFrame frame, String appearanceName) {
		this(dimension, "", frame, appearanceName);
	}

	protected AbstractXTextArea(int x, int y, int width, int height, String text, final XFrame frame, String appearanceName) {
		this.appearance = Appearances.get(appearanceName);
		this.frame = frame;

		this.setText(text);
		this.setFont(appearance.getFont());
		this.setForeground(appearance.getForegrounds().get(0));
		this.setCaretColor(this.getForeground());
		this.setOpaque(false);
		this.setBorder(null);
		this.setPreferredSize(new Dimension(width, height));
		this.setBounds(new Rectangle(x, y, width, height));
	}

	protected AbstractXTextArea(int x, int y, int width, int height, final XFrame frame, String appearanceName) {
		this(x, y, width, height, "", frame, appearanceName);
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
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (this.appearance.getBorderModel().getThickness() != 0) {
			if (this.appearance.getBorderModel().getColorModel().getColors().size() >= 2) {
				LinearGradientPaint lgp = new LinearGradientPaint(x, y, w, h, Util.calcEqualFracts(this.appearance.getBorderModel()
					.getColorModel()
					.getColors()
					.size()), this.appearance.getBorderColorsAsArray());

				g2D.setPaint(lgp);
			}
			else
				g2D.setColor(this.appearance.getBorderModel().getColorModel().getColors().get(0));

			g2D.setStroke(new BasicStroke(this.appearance.getBorderModel().getThickness(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
			// Draw border
			g2D.drawRoundRect(x, y, this.getWidth(), this.getHeight(), r, r);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
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

		// Paint text
		super.paintComponent(g);
		// Needed in order for the displaying to work properly
		this.setBorder(null);

		// Destroy the Graphics2D object as it is no longer needed
		g2D.dispose();
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
		final int H = this.getHeight();
		// Roundness
		final int R = this.appearance.getBorderModel().getRoundness();

		// Paint the component
		super.paint(g);
		// Paint the border
		this.paintBorder(X, Y, W, H, R, g2D);

		// Destroy the Graphics2D object as it is no longer needed
		g2D.dispose();
	}
}
