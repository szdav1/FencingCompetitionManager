package com._4th_dimension_softwares.app.view.components.base.panel;

import java.awt.*;

import javax.swing.JComponent;

import com._4th_dimension_softwares.app.view.frame.XFrame;
import com._4th_dimension_softwares.support.consts.PositionConstants;
import com._4th_dimension_softwares.support.framework.Appearance;
import com._4th_dimension_softwares.support.util.Util;

/**
 * The <code>XPanel</code> class is an extended representation
 * of Swing's <code>JPanel</code> class. It works similarly to
 * <code>JPanel</code>. It acts as a container, it can have different
 * <code>LayoutManager</code>s.
 * <p></p>
 * The extended means that just by passing in an Appearance
 * object to the constructor, this panel will be stylized
 * according to that Appearance. This saves the work with
 * Graphics and Graphics2D and makes creating beautiful
 * container panels easy and fast.
 * <p></p>
 * The <code>paintComponent()</code> method is fully overridden
 * from the super class. Only the displaying of added components
 * is what kept, but background painting and border painting
 * is fully customized to work based on the Appearance object passed
 * into the constructor of the class.
 * <p></p>
 * The first is the background that gets painted. The painting procedure
 * depends on the number of colors in the Appearance object. If the number
 * is less than 2, the color that was specified in the backgrounds field of
 * the color theme will be painted all over the component. If multiple colors
 * were defined, then a <code>LinearGradientPant</code> will be used to paint
 * every specified color on the component dividing the available space for painting
 * equally.
 * <p></p>
 * The next that is painted is the border. If the thickness of the border
 * is greater than 0, than the border is painted. The coloring of the
 * border happens the same way as coloring the background. The number of colors
 * determines the process. If less than 2, the simple color will be used, if more or
 * 2, then <code>LinearGradientPaint</code> will be used.
 * <p></p>
 * Important
 * <p>For painting the background: <code>VALUE_RENDER_QUALITY</code></p>
 * <p>For painting the border: <code>VALUE_ANTIALIAS_ON</code></p>
 *
 * @author szd
 */
public class XPanel extends AbstractXPanel {
	/**
	 * Constructs an <code>XPanel</code> object. This object is
	 * similar to a <code>JPanel</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param dimension      The Dimension of the panel
	 * @param layoutManager  The LayoutManager of the panel
	 * @param frame          The main frame of the Application
	 * @param appearanceName The name of the <code>Appearance</code> that's values
	 *                       should be implemented on this panel
	 */
	public XPanel(Dimension dimension, LayoutManager layoutManager, final XFrame frame, String appearanceName) {
		super(dimension, layoutManager, frame, appearanceName);
	}

	/**
	 * Constructs an <code>XPanel</code> object. This object is
	 * similar to a <code>JPanel</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param dimension      The Dimension of the panel
	 * @param frame          The main frame of the Application
	 * @param appearanceName The name of the <code>Appearance</code> that's values
	 *                       should be implemented on this panel
	 */
	public XPanel(Dimension dimension, final XFrame frame, String appearanceName) {
		super(dimension, frame, appearanceName);
	}

	/**
	 * Constructs an <code>XPanel</code> object. This object is
	 * similar to a <code>JPanel</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param x              The X coordinate of the panel in no-layout manager space
	 * @param y              The Y coordinate of the panel in no-layout manager space
	 * @param width          The width of the panel
	 * @param height         The height of the panel
	 * @param layoutManager  The LayoutManager of the panel
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the <code>Appearance</code> that's values
	 *                       should be implemented on this panel
	 */
	public XPanel(int x, int y, int width, int height, LayoutManager layoutManager, final XFrame frame, String appearanceName) {
		super(x, y, width, height, layoutManager, frame, appearanceName);
	}

	/**
	 * Constructs an <code>XPanel</code> object. This object is
	 * similar to a <code>JPanel</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param x              The X coordinate of the panel in no-layout manager space
	 * @param y              The Y coordinate of the panel in no-layout manager space
	 * @param width          The width of the panel
	 * @param height         The height of the panel
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the <code>Appearance</code> that's values
	 *                       should be implemented on this panel
	 */
	public XPanel(int x, int y, int width, int height, final XFrame frame, String appearanceName) {
		super(x, y, width, height, frame, appearanceName);
	}

	/**
	 * Sets the alignment of the currently used <code>FlowLayout</code>.
	 * This method will only work if the layout manager of the container
	 * is an instance of the <code>FlowLayout</code> class. The valid
	 * options are:
	 * <p><code>FlowLayout.LEADING</code></p>
	 * <p><code>FlowLayout.CENTER</code></p>
	 * <p><code>FlowLayout.TRAILING</code></p>
	 * <p><code>FlowLayout.LEFT</code></p>
	 * <p><code>FlowLayout.RIGHT</code></p>
	 *
	 * @param alignment One of the valid constants defined int the <code>FlowLayout</code> class
	 */
	public void setFlowAlignment(int alignment) {
		if (this.getLayout() instanceof FlowLayout fl)
			fl.setAlignment(alignment);
	}

	/**
	 * Sets the padding (inner margin) of the container to the
	 * padding defined in the color theme file. If the constructor
	 * that doesn't take a layout manager is called to instantiate
	 * this class, by default the values defined in the color theme
	 * file are going to be used (if there is no padding defined the
	 * default value is 0). However, if a constructor that does take a
	 * layout manager is called, accessing the proportional values defined
	 * in the color theme file is not possible. This method gives an easy
	 * solution to this problem.
	 */
	public void usePadding() {
		if (this.getLayout() instanceof FlowLayout fl) {
			fl.setVgap(this.appearance.getVerticalPadding());
			fl.setHgap(this.appearance.getHorizontalPadding());
		}
	}

	@Override
	public XFrame getFrame() {
		return this.frame;
	}

	@Override
	public void repaintFrame() {
		if (this.frame != null)
			this.frame.repaint();
	}

	@Override
	public Appearance getAppearance() {
		return this.appearance;
	}

	@Override
	public void addComponent(final JComponent component, PositionConstants positionConstants) {
		this.add(component, this.getLayout() instanceof BorderLayout ?
			positionConstants.borderLayoutPosition() :
			positionConstants.layoutLevel()
		);
		this.repaintFrame();
		this.validate();
	}

	@Override
	public void addComponent(final JComponent component) {
		this.addComponent(component, this.getLayout() instanceof BorderLayout ?
			PositionConstants.CENTER_POSITION :
			PositionConstants.MID_POSITION
		);
		this.repaintFrame();
		this.validate();
	}

	@Override
	public JComponent removeComponent(final JComponent component) {
		this.remove(component);
		this.repaintFrame();
		this.validate();

		return component;
	}

	@Override
	public void paintBackground(int x, int y, int w, int h, int r, final Graphics2D g2D) {
		LinearGradientPaint lgp;

		if (this.appearance.getBackgrounds().size() >= 2) {
			lgp = new LinearGradientPaint(x, y, w, h, Util.calcEqualFracts(this.appearance.getBackgrounds().size()),
				this.appearance.getBackgroundsAsArray());

			g2D.setPaint(lgp);
		}
		else
			g2D.setColor(this.appearance.getBackgrounds().get(0));

		// Fill background
		g2D.fillRoundRect(x, y, w, h, r, r);
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
	}
}
