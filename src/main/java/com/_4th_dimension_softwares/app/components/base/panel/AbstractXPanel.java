package com._4th_dimension_softwares.app.components.base.panel;

import java.awt.*;

import javax.swing.JLayeredPane;

import com._4th_dimension_softwares.app.components.interfaces.CustomGraphicsUser;
import com._4th_dimension_softwares.app.components.interfaces.XComponent;
import com._4th_dimension_softwares.app.components.interfaces.XContainer;
import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.framework.Appearance;
import com._4th_dimension_softwares.support.framework.Appearances;

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
		this(dimension, new FlowLayout(FlowLayout.CENTER, 0, 0), frame, appearanceName);
	}

	protected AbstractXPanel(int x, int y, int width, int height, LayoutManager layoutManager, final XFrame frame, String appearanceName) {
		this.appearance = Appearances.get(appearanceName);
		this.frame = frame;

		this.setLayout(layoutManager);
		this.setBounds(new Rectangle(x, y, width, height));
		this.setPreferredSize(new Dimension(width, height));
	}

	protected AbstractXPanel(int x, int y, int width, int height, final XFrame frame, String appearanceName) {
		this(x, y, width, height, new FlowLayout(FlowLayout.CENTER, 0, 0), frame, appearanceName);
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

		// Background
		this.paintBackground(X, Y, W, H, R, g2D);

		// Border
		this.paintBorder(X, Y, W, H, R, g2D);

		// Paint added components
		super.paintComponent(g);
		// Needed in order for the displaying to work properly
		this.setBorder(null);
	}
}
