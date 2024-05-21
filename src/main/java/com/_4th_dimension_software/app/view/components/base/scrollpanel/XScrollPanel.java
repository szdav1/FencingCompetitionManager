package com._4th_dimension_software.app.view.components.base.scrollpanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JComponent;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.consts.PositionConstants;
import com._4th_dimension_software.support.theme.Appearance;

/**
 * The <code>XScrollPanel</code> class is an extended representation
 * of Swing's <code>JScrollPane</code> class. It works similarly to
 * a <code>JScrollPane</code>. It acts as a scrollable container, it can have different
 * <code>LayoutManager</code>s.
 *
 * @author szd
 */
public class XScrollPanel extends AbstractXScrollPanel {
	/**
	 * Constructs an <code>XScrollPanel</code> object. This object is
	 * similar to a <code>JScrollPane</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param dimension           The Dimension of the scroll panel
	 * @param layoutManager       The LayoutManager used inside the scroll panel
	 * @param frame               The main frame of the application
	 * @param panelAppearanceName The Appearance object that's values should be implemented
	 *                            on the view of the scroll panel
	 */
	public XScrollPanel(Dimension dimension, LayoutManager layoutManager, final XFrame frame, String panelAppearanceName) {
		super(dimension, layoutManager, frame, panelAppearanceName);
	}

	/**
	 * Constructs an <code>XScrollPanel</code> object. This object is
	 * similar to a <code>JScrollPane</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param dimension           The Dimension of the scroll panel
	 * @param frame               The main frame of the application
	 * @param panelAppearanceName The name of the Appearance object that's values should be implemented
	 *                            on the view of the scroll panel
	 */
	public XScrollPanel(Dimension dimension, final XFrame frame, String panelAppearanceName) {
		super(dimension, frame, panelAppearanceName);
	}

	/**
	 * Constructs an <code>XScrollPanel</code> object. This object is
	 * similar to a <code>JScrollPane</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param x                   The X coordinate of the scroll panel in no-layout manager space
	 * @param y                   The Y coordinate of the scroll panel in no-layout manager space
	 * @param width               The width of the scroll panel
	 * @param height              The height of the scroll panel
	 * @param layoutManager       The LayoutManager used inside the scroll panel
	 * @param frame               The main frame of the application
	 * @param panelAppearanceName The name of the Appearance object that's values should be implemented
	 *                            on the view of the scroll panel
	 */
	public XScrollPanel(int x, int y, int width, int height, LayoutManager layoutManager, final XFrame frame, String panelAppearanceName) {
		super(x, y, width, height, layoutManager, frame, panelAppearanceName);
	}

	/**
	 * Constructs an <code>XScrollPanel</code> object. This object is
	 * similar to a <code>JScrollPane</code> object, only this is much
	 * easier to customize using an <code>Appearance</code> object.
	 *
	 * @param x                   The X coordinate of the scroll panel in no-layout manager space
	 * @param y                   The Y coordinate of the scroll panel in no-layout manager space
	 * @param width               The width of the scroll panel
	 * @param height              The height of the scroll panel
	 * @param frame               The main frame of the application
	 * @param panelAppearanceName The name of the Appearance object that's values should be implemented
	 *                            on the view of the scroll panel
	 */
	public XScrollPanel(int x, int y, int width, int height, final XFrame frame, String panelAppearanceName) {
		super(x, y, width, height, frame, panelAppearanceName);
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
		if (this.autoResize && !(this.viewPanel.getLayout() instanceof BorderLayout)) {
			this.viewPanel.addComponent(component, positionConstants);
			this.viewPanel.setPreferredSize(new Dimension(this.viewPanel.getWidth(),
				this.viewPanel.getPreferredSize().height+component.getHeight()+((FlowLayout) this.viewPanel.getLayout()).getVgap())
			);
			this.setViewportView(this.viewPanel);
		}

		else if (this.viewPanel.getLayout() instanceof BorderLayout)
			this.viewPanel.addComponent(component, positionConstants);

		else {
			// Calculate overhangs
			int xOverhang = component.getX()+component.getWidth();
			int yOverhang = component.getY()+component.getHeight();

			// Resize the view panel
			this.viewPanel.setPreferredSize(new Dimension(Math.max(xOverhang, this.viewPanel.getPreferredSize().width),
				Math.max(yOverhang, this.viewPanel.getPreferredSize().height))
			);

			// Add the component and refresh the viewport
			this.viewPanel.addComponent(component, positionConstants);
			this.setViewportView(this.viewPanel);
		}
	}

	@Override
	public void addComponent(final JComponent component) {
		this.addComponent(component, PositionConstants.MID_POSITION);
	}

	@Override
	public JComponent removeComponent(final JComponent component) {
		return this.viewPanel.removeComponent(component);
	}
}
