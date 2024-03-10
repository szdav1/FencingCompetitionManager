package com._4th_dimension_softwares.app.components.base.scrollpanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JComponent;

import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.consts.PositionConstants;
import com._4th_dimension_softwares.support.framework.Appearance;

/**
 * The <code>XScrollPanel</code> class is an extended representation
 * of Swing's <code>JScrollPane</code> class. It works similarly to
 * <code>JScrollPane</code>. It acts as a scrollable container, it can have different
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
 * The scrollbar is painted separately. It requires a separate <code>Appearance</code>
 * object to gather information from.
 * <p></p>
 * Important
 * <p>For painting the background: <code>VALUE_RENDER_QUALITY</code></p>
 * <p>For painting the border: <code>VALUE_ANTIALIAS_ON</code></p>
 *
 * @author szd
 */
public class XScrollPanel extends AbstractXScrollPanel {
	/**
	 * Constructs an <code>XScrollPanel</code> object. This object is
	 * similar to a <code>JScrollPane</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param dimension               The Dimension of the scroll panel
	 * @param layoutManager           The LayoutManager used inside the scroll panel
	 * @param frame                   The main frame of the application
	 * @param panelAppearanceName     The Appearance object that's values should be implemented
	 *                                on the view of the scroll panel
	 * @param scrollBarAppearanceName The name of the Appearance that's values should be
	 *                                implemented on this scrollbar UI
	 */
	public XScrollPanel(Dimension dimension, LayoutManager layoutManager, XFrame frame, String panelAppearanceName, String scrollBarAppearanceName) {
		super(dimension, layoutManager, frame, panelAppearanceName, scrollBarAppearanceName);
	}

	/**
	 * Constructs an <code>XScrollPanel</code> object. This object is
	 * similar to a <code>JScrollPane</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param dimension               The Dimension of the scroll panel
	 * @param frame                   The main frame of the application
	 * @param panelAppearanceName     The name of the Appearance object that's values should be implemented
	 *                                on the view of the scroll panel
	 * @param scrollBarAppearanceName The name of the Appearance that's values should be
	 *                                implemented on the scrollbar
	 */
	public XScrollPanel(Dimension dimension, XFrame frame, String panelAppearanceName, String scrollBarAppearanceName) {
		super(dimension, frame, panelAppearanceName, scrollBarAppearanceName);
	}

	/**
	 * Constructs an <code>XScrollPanel</code> object. This object is
	 * similar to a <code>JScrollPane</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param x                       The X coordinate of the scroll panel in no-layout manager space
	 * @param y                       The Y coordinate of the scroll panel in no-layout manager space
	 * @param width                   The width of the scroll panel
	 * @param height                  The height of the scroll panel
	 * @param layoutManager           The LayoutManager used inside the scroll panel
	 * @param frame                   The main frame of the application
	 * @param panelAppearanceName     The name of the Appearance object that's values should be implemented
	 *                                on the view of the scroll panel
	 * @param scrollBarAppearanceName The name of the Appearance that's values should be
	 *                                implemented on the scrollbar
	 */
	public XScrollPanel(int x, int y, int width, int height, LayoutManager layoutManager, XFrame frame, String panelAppearanceName, String scrollBarAppearanceName) {
		super(x, y, width, height, layoutManager, frame, panelAppearanceName, scrollBarAppearanceName);
	}

	/**
	 * Constructs an <code>XScrollPanel</code> object. This object is
	 * similar to a <code>JScrollPane</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param x                       The X coordinate of the scroll panel in no-layout manager space
	 * @param y                       The Y coordinate of the scroll panel in no-layout manager space
	 * @param width                   The width of the scroll panel
	 * @param height                  The height of the scroll panel
	 * @param frame                   The main frame of the application
	 * @param panelAppearanceName     The name of the Appearance object that's values should be implemented
	 *                                on the view of the scroll panel
	 * @param scrollBarAppearanceName The name of the Appearance that's values should be
	 *                                implemented on the scrollbar
	 */
	public XScrollPanel(int x, int y, int width, int height, XFrame frame, String panelAppearanceName, String scrollBarAppearanceName) {
		super(x, y, width, height, frame, panelAppearanceName, scrollBarAppearanceName);
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
	public void addComponent(JComponent component, PositionConstants positionConstants) {
		if (this.viewPanel.getLayout() instanceof BorderLayout)
			this.viewPanel.addComponent(component, positionConstants);
		else {
			// Calculate overhangs
			int xOverhang = component.getX()+component.getWidth();
			int yOverhang = component.getY()+component.getHeight();

			// Resize the view
			this.viewPanel.setPreferredSize(new Dimension(Math.max(xOverhang, this.viewPanel.getPreferredSize().width),
				Math.max(yOverhang, this.viewPanel.getPreferredSize().height)));

			// Add the component and refresh the viewport
			this.viewPanel.addComponent(component, positionConstants);
			this.setViewportView(this.viewPanel);
		}
	}

	@Override
	public void addComponent(JComponent component) {
		if (this.viewPanel.getLayout() instanceof BorderLayout)
			this.viewPanel.addComponent(component, PositionConstants.CENTER_POSITION);
		else {
			// Calculate overhangs
			int xOverhang = this.viewPanel.getPreferredSize().width-(component.getX()+component.getWidth());
			int yOverhang = this.viewPanel.getPreferredSize().width-(component.getY()+component.getHeight());

			// Resize the view
			this.viewPanel.setPreferredSize(new Dimension(this.viewPanel.getPreferredSize().width+xOverhang,
				this.viewPanel.getPreferredSize().height+yOverhang));

			// Add the component and refresh the viewport
			this.viewPanel.addComponent(component, PositionConstants.MID_POSITION);
			this.setViewportView(this.viewPanel);
		}
	}

	@Override
	public JComponent removeComponent(JComponent component) {
		return this.viewPanel.removeComponent(component);
	}
}
