package com._4th_dimension_software.app.view.components.base.scrollpanel.scrollbar.ui;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

import com._4th_dimension_software.support.framework.Appearance;
import com._4th_dimension_software.support.framework.Appearances;
import com._4th_dimension_software.support.util.Util;

public abstract class AbstractXScrollBarUI extends BasicScrollBarUI {
	protected Appearance appearance;

	protected AbstractXScrollBarUI(String appearanceName) {
		this.appearance = Appearances.get(appearanceName);
	}

	/**
	 * Remove the up and down arrow buttons from the top
	 * and bottom of the scroll bar.
	 *
	 * @return A JButton that has a preferred size, minimum and maximum
	 * size of 0
	 */
	private JButton removeButtons() {
		JButton btn = new JButton();
		btn.setPreferredSize(new Dimension(0, 0));
		btn.setMinimumSize(btn.getPreferredSize());
		btn.setMaximumSize(btn.getPreferredSize());

		return btn;
	}

	public Appearance getAppearance() {
		return this.appearance;
	}

	@Override
	protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
		// Cast Graphics to Graphics2D
		Graphics2D g2D = (Graphics2D) g;
		g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		// Start and end coordinates for painting
		final int X = 0;
		final int Y = 0;
		final int W = c.getWidth();
		final int H = c.getHeight();
		// Roundness
		final int RNS = this.appearance.getBorderModel().getRoundness();
		// Linear Gradient Paint
		LinearGradientPaint lgp;

		// Use single color
		if (this.appearance.getBackgrounds().size() == 1)
			g2D.setColor(this.appearance.getBackgrounds().get(0));
		// Paint the track with a linear gradient paint
		else {
			lgp = new LinearGradientPaint(X, Y, W, H, Util.calcEqualFracts(this.appearance.getBackgrounds().size()),
				this.appearance.getBackgroundsAsArray());
			g2D.setPaint(lgp);
		}

		// Paint the track
		g2D.fillRect(X, Y, W, H);

		// Destroy the Graphics2D object as it is no longer needed
		g2D.dispose();
	}

	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
		// Cast Graphics to Graphics2D
		Graphics2D g2D = (Graphics2D) g;
		g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		// Start and end coordinates for painting
		final int X = r.x;
		final int Y = r.y;
		final int W = r.width;
		final int H = r.height;
		// Roundness
		final int RNS = this.appearance.getBorderModel().getRoundness();
		// Linear Gradient Paint
		GradientPaint gp;

		// Use single color
		if (this.appearance.getForegrounds().size() == 1)
			g2D.setColor(this.appearance.getForegrounds().get(0));
		// Paint the track with a linear gradient paint
		else {
			gp = new GradientPaint(X, Y, this.appearance.getForegrounds().get(0), W, H, this.appearance.getForegrounds().get(1));
			g2D.setPaint(gp);
		}

		// Paint the thumb
		g2D.fillRoundRect(X, Y, W, H, RNS, RNS);

		// Destroy the Graphics2D object as it is no longer needed
		g2D.dispose();
	}

	@Override
	protected JButton createIncreaseButton(int orientation) {
		return this.removeButtons();
	}

	@Override
	protected JButton createDecreaseButton(int orientation) {
		return this.removeButtons();
	}
}
