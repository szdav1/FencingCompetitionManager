package com._4th_dimension_softwares.app.components.base.scrollpanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JComponent;

import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.consts.PositionConstants;
import com._4th_dimension_softwares.support.framework.Appearance;

public class XScrollPanel extends AbstractXScrollPanel {
	/**
	 * Constructs an <code>XScrollPanel</code> object. This object is
	 * similar to a <code>JScrollPane</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param dimension           The Dimension of the scroll panel
	 * @param layoutManager       The LayoutManager used inside the scroll panel
	 * @param frame               The main frame of the application
	 * @param panelAppearance     The Appearance object that's values should be implemented
	 *                            on the view of the scroll panel
	 * @param scrollBarAppearance The Appearance object that's values should be implemented
	 *                            on the scroll bar of the scroll panel
	 */
	public XScrollPanel(Dimension dimension, LayoutManager layoutManager, XFrame frame, Appearance panelAppearance, Appearance scrollBarAppearance) {
		super(dimension, layoutManager, frame, panelAppearance, scrollBarAppearance);
	}

	/**
	 * Constructs an <code>XScrollPanel</code> object. This object is
	 * similar to a <code>JScrollPane</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param dimension           The Dimension of the scroll panel
	 * @param frame               The main frame of the application
	 * @param panelAppearance     The Appearance object that's values should be implemented
	 *                            on the view of the scroll panel
	 * @param scrollBarAppearance The Appearance object that's values should be implemented
	 *                            on the scroll bar of the scroll panel
	 */
	public XScrollPanel(Dimension dimension, XFrame frame, Appearance panelAppearance, Appearance scrollBarAppearance) {
		super(dimension, frame, panelAppearance, scrollBarAppearance);
	}

	/**
	 * Constructs an <code>XScrollPanel</code> object. This object is
	 * similar to a <code>JScrollPane</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param x                   The X coordinate of the scroll panel in no-layout manager space
	 * @param y                   The Y coordinate of the scroll panel in no-layout manager space
	 * @param width               The width of the scroll panel
	 * @param height              The height of the scroll panel
	 * @param layoutManager       The LayoutManager used inside the scroll panel
	 * @param frame               The main frame of the application
	 * @param panelAppearance     The Appearance object that's values should be implemented
	 *                            on the view of the scroll panel
	 * @param scrollBarAppearance The Appearance object that's values should be implemented
	 *                            on the scroll bar of the scroll panel
	 */
	public XScrollPanel(int x, int y, int width, int height, LayoutManager layoutManager, XFrame frame, Appearance panelAppearance, Appearance scrollBarAppearance) {
		super(x, y, width, height, layoutManager, frame, panelAppearance, scrollBarAppearance);
	}

	/**
	 * Constructs an <code>XScrollPanel</code> object. This object is
	 * similar to a <code>JScrollPane</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param x                   The X coordinate of the scroll panel in no-layout manager space
	 * @param y                   The Y coordinate of the scroll panel in no-layout manager space
	 * @param width               The width of the scroll panel
	 * @param height              The height of the scroll panel
	 * @param frame               The main frame of the application
	 * @param panelAppearance     The Appearance object that's values should be implemented
	 *                            on the view of the scroll panel
	 * @param scrollBarAppearance The Appearance object that's values should be implemented
	 *                            on the scroll bar of the scroll panel
	 */
	public XScrollPanel(int x, int y, int width, int height, XFrame frame, Appearance panelAppearance, Appearance scrollBarAppearance) {
		super(x, y, width, height, frame, panelAppearance, scrollBarAppearance);
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
	public void  addComponent(JComponent component, PositionConstants positionConstants) {
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
