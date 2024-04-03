package com._4th_dimension_softwares.app.view.components.base.button;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com._4th_dimension_softwares.app.view.components.interfaces.CustomGraphicsUser;
import com._4th_dimension_softwares.app.view.components.interfaces.XComponent;
import com._4th_dimension_softwares.app.view.frame.XFrame;
import com._4th_dimension_softwares.support.framework.Appearance;
import com._4th_dimension_softwares.support.framework.Appearances;
import com._4th_dimension_softwares.support.util.Util;

public abstract class AbstractXButton extends JButton implements MouseListener, XComponent, CustomGraphicsUser {
	protected boolean entered = false;
	protected boolean pressed = false;

	protected Appearance appearance;
	protected final XFrame frame;
	protected final ButtonType type;

	protected AbstractXButton(Dimension dimension, String text, final XFrame frame, ButtonType type, String appearanceName) {
		this.appearance = Appearances.get(appearanceName);
		this.frame = frame;
		this.type = type;

		this.setIcon(appearance.getIcon1() == null ? appearance.getIcon2() : appearance.getIcon1());
		this.setText(text);
		this.setFont(appearance.getFont());
		this.setForeground(appearance.getForegrounds().get(0));
		this.setFocusable(false);
		this.setBorder(null);
		this.setContentAreaFilled(false);
		this.setBounds(new Rectangle(0, 0, dimension.width, dimension.height));
		this.setPreferredSize(dimension);
		this.addMouseListener(this);
	}

	protected AbstractXButton(Dimension dimension, final XFrame frame, ButtonType type, String appearanceName) {
		this(dimension, "", frame, type, appearanceName);
	}

	protected AbstractXButton(int x, int y, int width, int height, String text, final XFrame frame, ButtonType type, String appearanceName) {
		this.appearance = Appearances.get(appearanceName);
		this.frame = frame;
		this.type = type;

		this.setIcon(appearance.getIcon1() == null ? appearance.getIcon2() : appearance.getIcon1());
		this.setText(text);
		this.setFont(appearance.getFont());
		this.setForeground(appearance.getForegrounds().get(0));
		this.setFocusable(false);
		this.setBorder(null);
		this.setContentAreaFilled(false);
		this.setPreferredSize(new Dimension(width, height));
		this.setBounds(new Rectangle(x, y, width, height));
		this.addMouseListener(this);
	}

	protected AbstractXButton(int x, int y, int width, int height, final XFrame frame, ButtonType type, String appearanceName) {
		this(x, y, width, height, "", frame, type, appearanceName);
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
		g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		// Start and end coordinates for painting
		final int X = 0;
		final int Y = 0;
		final int W = this.getWidth();
		final int H = this.getHeight();
		// Roundness
		final int R = this.appearance.getBorderModel().getRoundness();

		// Fill the background - Used for Foreground and Icon mainly
		if (this.appearance.getBackgrounds().size() >= 2 && this.type != ButtonType.BACKGROUND_CHANGER) {
			LinearGradientPaint lgp = new LinearGradientPaint(X, Y, W, H, Util.calcEqualFracts(this.appearance.getBackgrounds().size()),
				this.appearance.getBackgroundsAsArray());

			g2D.setPaint(lgp);
		}
		else
			g2D.setColor(this.appearance.getBackgrounds().get(0));

		g2D.fillRoundRect(X, Y, W, H, R, R);

		// Background
		if (this.type == ButtonType.BACKGROUND_CHANGER) {
			this.paintBackground(X, Y, W, H, R, g2D);
		}
		// Foreground
		else if (this.type == ButtonType.FOREGROUND_CHANGER) {
			this.paintForeground();
		}
		// Icon
		else if (this.type == ButtonType.ICON_CHANGER) {
			this.paintIcon();
		}

		// Paint Icon and Text
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
