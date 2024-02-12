package com._4th_dimension_softwares.app.components.base.panel;

import java.awt.*;

import javax.swing.JLayeredPane;

import com._4th_dimension_softwares.app.components.interfaces.XComponent;
import com._4th_dimension_softwares.app.components.interfaces.XContainer;
import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.framework.Appearance;

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
		this.appearance = appearance;
		this.frame = frame;

		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		this.setPreferredSize(dimension);
		this.setBounds(new Rectangle(0, 0, dimension.width, dimension.height));
	}

	protected AbstractXPanel(int x, int y, int width, int height, LayoutManager layoutManager, XFrame frame, Appearance appearance) {
		this.appearance = appearance;
		this.frame = frame;

		this.setLayout(layoutManager);
		this.setBounds(new Rectangle(x, y, width, height));
		this.setPreferredSize(new Dimension(width, height));
	}

	protected AbstractXPanel(int x, int y, int width, int height, XFrame frame, Appearance appearance) {
		this.appearance = appearance;
		this.frame = frame;

		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		this.setBounds(new Rectangle(x, y, width, height));
		this.setPreferredSize(new Dimension(width, height));
	}

	/**
	 * The <code>paintComponent()</code> method is fully overridden
	 * from the super class. Only the displaying of added components
	 * is what kept, but background painting and border painting
	 * is fully customized to work based on the Appearance object passed
	 * into the constructor of the class.
	 * <p/>
	 * The first is the background that gets painted. The painting procedure
	 * depends on the number of colors in the Appearance object. If the number
	 * is less than 2, the color that was specified in the backgrounds field of
	 * the color theme will be painted all over the component. If multiple colors
	 * were defined, then a <code>LinearGradientPant</code> will be used to paint
	 * every specified color on the component dividing the available space for painting
	 * equally.
	 * <p/>
	 * The next that is painted is the border. If the thickness of the border
	 * is greater than 0, than the border is painted. The coloring of the
	 * border happens the same way as coloring the background. The number of colors
	 * determines the process. If less than 2, the simple color will be used, if more or
	 * 2, then <code>LinearGradientPaint</code> will be used.
	 * <p/>
	 * Important
	 * </p>
	 * For painting the background: <code>VALUE_RENDER_QUALITY</code>
	 * <p/>
	 * For painting the border: <code>VALUE_ANTIALIAS_ON</code>
	 *
	 * @param g the <code>Graphics</code> object to protect
	 * @author szd
	 */
	@Override
	protected void paintComponent(Graphics g) {
		// Paint added components
		super.paintComponent(g);

		// Cast Graphics to Graphics2D
		Graphics2D g2D = (Graphics2D) g;
		g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		// Start and end coordinates for painting
		int x = 0;
		int y = 0;
		int w = this.getWidth();
		int h = this.getHeight();
		// Roundness
		int r = this.appearance.getBorderModel().getRoundness();
		// Linear Gradient Paint
		LinearGradientPaint lgp;

		// Background
		if (this.appearance.getBackgrounds().size() >= 2) {
			// Calculate the fractions for the colors
			float[] fs = new float[this.appearance.getBackgrounds().size()];
			fs[0] = 1.0f/fs.length;

			for (int i = 1; i < fs.length; i++) {
				fs[i] = fs[i-1]+fs[0];
			}

			lgp = new LinearGradientPaint(x, y, w, h, fs, this.appearance.getBackgroundsAsArray());
			g2D.setPaint(lgp);
		}
		else
			g2D.setColor(this.appearance.getBackgrounds().get(0));

		g2D.fillRoundRect(x, y, w, h, r, r);

		// Border
		if (this.appearance.getBorderModel().getThickness() != 0) {
			g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			if (this.appearance.getBorderModel().getColorModel().getColors().size() >= 2) {
				// Calculate the fractions for the colors
				float[] fs = new float[this.appearance.getBorderModel().getColorModel().getColors().size()];
				fs[0] = 1.0f/fs.length;

				for (int i = 1; i < fs.length; i++) {
					fs[i] = fs[i-1]+fs[0];
				}

				lgp = new LinearGradientPaint(x, y, w, h, fs, this.appearance.getBorderColorsAsArray());
				g2D.setPaint(lgp);
				g2D.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
			}
			else
				g2D.setColor(this.appearance.getBorderModel().getColorModel().getColors().get(0));

			g2D.drawRoundRect(x, y, w, h, r, r);
		}
	}
}
