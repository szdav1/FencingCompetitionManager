package com._4th_dimension_software.app.view.components.base.scrollpanel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com._4th_dimension_software.app.view.components.base.panel.XPanel;
import com._4th_dimension_software.app.view.components.base.scrollpanel.scrollbar.XScrollBar;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.app.view.interfaces.XComponent;
import com._4th_dimension_software.app.view.interfaces.XContainer;
import com._4th_dimension_software.support.theme.Appearance;
import com._4th_dimension_software.support.theme.Appearances;

/**
 * The <code>AbstractXScrollPanel</code> abstract class defines the abstract
 * behaviour of scroll panels inside the application. It is a subclass of
 * swing's default <code>JScrollPane</code> class. It implements the basic
 * and necessary interfaces that are required in order for a scroll panel to work
 * properly.
 *
 * @author szd
 */
public abstract class AbstractXScrollPanel extends JScrollPane implements XComponent, XContainer {
	protected final Appearance appearance;
	protected final XFrame frame;
	protected XPanel viewPanel;

	/**
	 * Defines the constructor of the scroll panels that
	 * initializes every field of the class with the
	 * given parameters.
	 *
	 * @param dimension               The Dimension of the scroll panel
	 * @param layoutManager           The LayoutManager used inside the scroll panel
	 * @param frame                   The main frame of the application
	 * @param panelAppearanceName     The Appearance object that's values should be implemented
	 *                                on the view of the scroll panel
	 * @param scrollBarAppearanceName The name of the Appearance that's values should be
	 *                                implemented on this scrollbar UI
	 */
	protected AbstractXScrollPanel(Dimension dimension, LayoutManager layoutManager, final XFrame frame, String panelAppearanceName, String scrollBarAppearanceName) {
		this.appearance = Appearances.get(panelAppearanceName);
		this.frame = frame;
		this.viewPanel = new XPanel(new Dimension(0, 0), layoutManager, frame, panelAppearanceName);

		this.setVerticalScrollBar(new XScrollBar(JScrollBar.VERTICAL, scrollBarAppearanceName));
		this.setHorizontalScrollBar(new XScrollBar(JScrollBar.HORIZONTAL, scrollBarAppearanceName));
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.setViewportView(this.viewPanel);
		this.setBorder(null);
		this.setBackground(this.appearance.getBackgrounds().get(this.appearance.getBackgrounds().size()-1));
		this.setBounds(new Rectangle(0, 0, dimension.width, dimension.height));
		this.setPreferredSize(dimension);
	}

	/**
	 * Defines the constructor of the scroll panels that
	 * initializes every field of the class with the
	 * given parameters except for the layout manager.
	 *
	 * @param dimension               The Dimension of the scroll panel
	 * @param frame                   The main frame of the application
	 * @param panelAppearanceName     The Appearance object that's values should be implemented
	 *                                on the view of the scroll panel
	 * @param scrollBarAppearanceName The name of the Appearance that's values should be
	 *                                implemented on this scrollbar UI
	 */
	protected AbstractXScrollPanel(Dimension dimension, final XFrame frame, String panelAppearanceName, String scrollBarAppearanceName) {
		this(dimension, new FlowLayout(FlowLayout.CENTER, 0, 0), frame, panelAppearanceName, scrollBarAppearanceName);
	}

	/**
	 * Defines the constructor of the scroll panels that
	 * initializes every field of the class with the
	 * given parameters.
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
	protected AbstractXScrollPanel(int x, int y, int width, int height, LayoutManager layoutManager, final XFrame frame, String panelAppearanceName, String scrollBarAppearanceName) {
		this.appearance = Appearances.get(panelAppearanceName);
		this.frame = frame;
		this.viewPanel = new XPanel(new Dimension(0, 0), layoutManager, frame, panelAppearanceName);

		this.setVerticalScrollBar(new XScrollBar(JScrollBar.VERTICAL, scrollBarAppearanceName));
		this.setHorizontalScrollBar(new XScrollBar(JScrollBar.HORIZONTAL, scrollBarAppearanceName));
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.setViewportView(this.viewPanel);
		this.setBorder(null);
		this.setBackground(this.appearance.getBackgrounds().get(this.appearance.getBackgrounds().size()-1));
		this.setPreferredSize(new Dimension(width, height));
		this.setBounds(new Rectangle(x, y, width, height));
	}

	/**
	 * Defines the constructor of the scroll panels that
	 * initializes every field of the class with the
	 * given parameters except for the layout manager.
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
	protected AbstractXScrollPanel(int x, int y, int width, int height, final XFrame frame, String panelAppearanceName, String scrollBarAppearanceName) {
		this(x, y, width, height, new FlowLayout(FlowLayout.CENTER, 0, 0), frame, panelAppearanceName, scrollBarAppearanceName);
	}

	public XPanel getViewPanel() {
		return this.viewPanel;
	}

	public void setViewPanel(XPanel viewPanel) {
		this.viewPanel = viewPanel;
	}
}
