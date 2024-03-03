package com._4th_dimension_softwares.app.components.base.scrollpanel.scrollbar.ui;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

import com._4th_dimension_softwares.support.framework.Appearance;
import com._4th_dimension_softwares.support.util.Util;

public abstract class AbstractXScrollBarUI extends BasicScrollBarUI {
	protected Appearance appearance;

	protected AbstractXScrollBarUI(Appearance appearance) {
		this.appearance = appearance;
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
		final int x = 0;
		final int y = 0;
		final int w = c.getWidth();
		final int h = c.getHeight();
		// Roundness
		final int rns = this.appearance.getBorderModel().getRoundness();
		// Linear Gradient Paint
		LinearGradientPaint lgp;

		if (this.appearance.getBackgrounds().size() == 1)
			g2D.setColor(this.appearance.getBackgrounds().get(0));
		// Paint the track with a linear gradient paint
		else {
			lgp = new LinearGradientPaint(x, y, w, h, Util.calcEqualFracts(this.appearance.getBackgrounds().size()),
				this.appearance.getBackgroundsAsArray());
			g2D.setPaint(lgp);
		}
		// Use single color

		// Paint the track
		g2D.fillRect(x, y, w, h);
	}

	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
		// Cast Graphics to Graphics2D
		Graphics2D g2D = (Graphics2D) g;
		g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		// Start and end coordinates for painting
		final int x = r.x;
		final int y = r.y;
		final int w = r.width;
		final int h = r.height;
		// Roundness
		final int rns = this.appearance.getBorderModel().getRoundness();
		// Linear Gradient Paint
		GradientPaint gp;

		// Use single color
		if (this.appearance.getForegrounds().size() == 1)
			g2D.setColor(this.appearance.getForegrounds().get(0));
		// Paint the track with a linear gradient paint
		else {
			gp = new GradientPaint(x, y, this.appearance.getForegrounds().get(0), w, h, this.appearance.getForegrounds().get(1));
			g2D.setPaint(gp);
		}

		// Paint the thumb
		g2D.fillRoundRect(x, y, w, h, rns, rns);
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
