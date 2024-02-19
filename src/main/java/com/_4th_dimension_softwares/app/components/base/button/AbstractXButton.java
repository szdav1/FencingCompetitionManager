package com._4th_dimension_softwares.app.components.base.button;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com._4th_dimension_softwares.app.components.interfaces.XComponent;
import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.framework.Appearance;
import com._4th_dimension_softwares.support.util.Util;

public abstract class AbstractXButton extends JButton implements MouseListener, XComponent {
	protected boolean entered = false;
	protected boolean pressed = false;

	protected Appearance appearance;
	protected final XFrame frame;
	protected final ButtonType type;

	protected AbstractXButton(Dimension dimension, String text, XFrame frame, ButtonType type, Appearance appearance) {
		this.appearance = appearance;
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

	protected AbstractXButton(Dimension dimension, XFrame frame, ButtonType type, Appearance appearance) {
		this(dimension, "", frame, type, appearance);
	}

	protected AbstractXButton(int x, int y, int width, int height, String text, XFrame frame, ButtonType type, Appearance appearance) {
		this.appearance = appearance;
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

	protected AbstractXButton(int x, int y, int width, int height, XFrame frame, ButtonType type, Appearance appearance) {
		this(x, y, width, height, "", frame, type, appearance);
	}

	/**
	 * Retrieves the main icon from the <code>Appearance</code>
	 * of the button object.
	 *
	 * @return The main icon of the button stored in the <code>Appearance</code>
	 * of the button
	 */
	public Optional<ImageIcon> getIcon1() {
		return Optional.of(this.appearance.getIcon1());
	}

	/**
	 * Retrieves the secondary icon from the <code>Appearance</code>
	 * of the button object.
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
		final int x = 0;
		final int y = 0;
		final int w = this.getWidth();
		final int h = this.getHeight();
		// Roundness
		final int r = this.appearance.getBorderModel().getRoundness();
		// Linear Gradient Paint
		LinearGradientPaint lgp;

		// Background
		if (this.type == ButtonType.BACKGROUND_CHANGER) {
			// If there's only one color defined in the color theme
			if (this.appearance.getBackgrounds().size() == 1) {
				g2D.setColor(this.appearance.getBackgrounds().get(0));
			}
			// If there are two colors defined in the color theme
			else if (this.appearance.getBackgrounds().size() == 2) {
				// If the button is entered by the mouse, the second color is painted
				if (this.entered)
					g2D.setColor(this.appearance.getBackgrounds().get(1));
					// If not, the (default) first color is painted
				else
					g2D.setColor(this.appearance.getBackgrounds().get(0));

				// If the button is pressed, the (default) first color is painted
				if (this.pressed)
					g2D.setColor(this.appearance.getBackgrounds().get(0));
					// If not, the second color is painted
				else
					g2D.setColor(this.appearance.getBackgrounds().get(1));

				// If the state of the button is normal, the (default) first color is painted
				if (!this.entered && !this.pressed)
					g2D.setColor(this.appearance.getBackgrounds().get(0));
			}
			// If there are three colors defined in the color theme
			else if (this.appearance.getBackgrounds().size() == 3) {
				// Separate the colors
				Color mainColor = this.appearance.getBackgrounds().get(0);
				Color[] secondaryColors = {this.appearance.getBackgrounds().get(1), this.appearance.getBackgrounds().get(2)};
				// Create the LinearGradientPaint
				lgp = new LinearGradientPaint(x, y, w, h, Util.calcEqualFracts(secondaryColors.length), secondaryColors);

				// If the button is entered by the mouse, the background is painted gradient
				if (this.entered)
					g2D.setPaint(lgp);
					// If not, the (default) first color is painted
				else
					g2D.setColor(mainColor);

				// If the button is pressed, the (default) first color is painted
				if (this.pressed)
					g2D.setColor(mainColor);
					// If not, the background is painted gradient
				else
					g2D.setPaint(lgp);

				// If the state of the button is normal, the (default) first color is painted
				if (!this.entered && !this.pressed)
					g2D.setColor(this.appearance.getBackgrounds().get(0));
			}
			// If there are more than three colors defined in the color theme
			else {
				List<Color[]> halfColors = Util.halveColors(this.appearance.getBackgrounds());
				lgp = new LinearGradientPaint(x, y, w, h, Util.calcEqualFracts(halfColors.get(0).length), halfColors.get(0));
				LinearGradientPaint lgp2 = new LinearGradientPaint(x, y, w, h, Util.calcEqualFracts(halfColors.get(1).length), halfColors.get(1));

				// If the button is entered by the mouse, the first half of the specified colors
				// Are painted in a linear gradient configuration
				if (this.entered)
					g2D.setPaint(lgp2);
					// If not, the second half of the specified colors are painted in the same configuration
				else
					g2D.setPaint(lgp);

				// If the button is entered by the mouse, the first half of the specified colors
				// Are painted in a linear gradient configuration
				if (this.pressed)
					g2D.setPaint(lgp);
					// If not, the second half of the specified colors are painted in the same configuration
				else
					g2D.setPaint(lgp2);

				// If the state of the button is normal, the (default) first color is painted
				if (!this.entered && !this.pressed)
					g2D.setPaint(lgp);
			}

			// Fill the background
			g2D.fillRoundRect(x, y, w, h, r, r);
		}
		// Foreground
		if (this.type == ButtonType.FOREGROUND_CHANGER) {
			if (this.appearance.getForegrounds().size() >= 2) {
				// TODO: Implement the foreground and icon changing effect and write docstrings for the XButton
			}
		}

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

		// Destroy the Graphics2D object as it is no longer needed
		g2D.dispose();
	}
}
