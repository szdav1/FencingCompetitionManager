package com._4th_dimension_software.app.view.components.base.button;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com._4th_dimension_software.app.view.components.interfaces.CustomGraphicsUser;
import com._4th_dimension_software.app.view.components.interfaces.XComponent;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.framework.Appearance;
import com._4th_dimension_software.support.framework.Appearances;

public abstract class AbstractXButton extends JButton implements MouseListener, XComponent, CustomGraphicsUser {
	protected boolean entered = false;
	protected boolean pressed = false;

	protected Appearance appearance;
	protected final XFrame frame;

	protected AbstractXButton(Dimension dimension, String text, final XFrame frame, String appearanceName) {
		this.appearance = Appearances.get(appearanceName);
		this.frame = frame;

		this.setIcon(appearance.getIcon1() == null ? appearance.getIcon2() : appearance.getIcon1());
		this.setText(text);
		this.setFont(appearance.getFont());
		this.setForeground(appearance.getForegrounds().get(0));
		this.setFocusable(false);
		this.setContentAreaFilled(false);
		this.setBounds(new Rectangle(0, 0, dimension.width, dimension.height));
		this.setPreferredSize(dimension);
		this.addMouseListener(this);
	}

	protected AbstractXButton(Dimension dimension, final XFrame frame, String appearanceName) {
		this(dimension, "", frame, appearanceName);
	}

	protected AbstractXButton(int x, int y, int width, int height, String text, final XFrame frame, String appearanceName) {
		this.appearance = Appearances.get(appearanceName);
		this.frame = frame;

		this.setIcon(appearance.getIcon1() == null ? appearance.getIcon2() : appearance.getIcon1());
		this.setText(text);
		this.setFont(appearance.getFont());
		this.setForeground(appearance.getForegrounds().get(0));
		this.setFocusable(false);
		this.setContentAreaFilled(false);
		this.setPreferredSize(new Dimension(width, height));
		this.setBounds(new Rectangle(x, y, width, height));
		this.addMouseListener(this);
	}

	protected AbstractXButton(int x, int y, int width, int height, final XFrame frame, String appearanceName) {
		this(x, y, width, height, "", frame, appearanceName);
	}

	/**
	 * Retrieves the main icon from the <code>Appearance</code>
	 * of the button object wrapped into an Optional.
	 *
	 * @return The main icon of the button stored in the <code>Appearance</code>
	 * of the button
	 */
	public Optional<ImageIcon> getIcon1() {
		return Optional.of(this.appearance.getIcon1());
	}

	/**
	 * Retrieves the secondary icon from the <code>Appearance</code>
	 * of the button object wrapped into an Optional.
	 *
	 * @return The secondary icon of the button stored in the <code>Appearance</code>
	 * of the button
	 */
	public Optional<ImageIcon> getIcon2() {
		return Optional.of(this.appearance.getIcon2());
	}

	@Override
	protected void paintComponent(Graphics g) {
		// Cast Graphics to Graphics2D
		Graphics2D g2D = (Graphics2D) g;

		if (g2D != null) {
			g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

			// Start and end coordinates for painting
			final int X = 0;
			final int Y = 0;
			final int W = this.getWidth();
			final int H = this.appearance.isLinearPaint() ? 0 : this.getHeight();
			// Roundness
			final int R = this.appearance.getBorderModel().getRoundness();

			// Paint the background
			this.paintBackground(X, Y, W, H, R, g2D);
			// Paint the foreground
			this.paintForeground();
			// Paint the icon (Actually set the corresponding icon)
			this.paintIcon();

			// Paint Icon and Text
			super.paintComponent(g);

			// Destroy the Graphics2D object as it is no longer needed
			g2D.dispose();
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