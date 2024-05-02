package com._4th_dimension_software.app.view.components.base.scrollpanel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com._4th_dimension_software.app.view.components.base.scrollpanel.scrollbar.XScrollBar;
import com._4th_dimension_software.app.view.components.interfaces.XComponent;
import com._4th_dimension_software.app.view.components.interfaces.XContainer;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.theme.Appearance;
import com._4th_dimension_software.support.theme.Appearances;
import com._4th_dimension_software.app.view.components.base.panel.XPanel;

public abstract class AbstractXScrollPanel extends JScrollPane implements XComponent, XContainer {
	protected Appearance appearance;
	protected final XFrame frame;
	protected XPanel viewPanel;

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

	protected AbstractXScrollPanel(Dimension dimension, final XFrame frame, String panelAppearanceName, String scrollBarAppearanceName) {
		this(dimension, new FlowLayout(FlowLayout.CENTER, 0, 0), frame, panelAppearanceName, scrollBarAppearanceName);
	}

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

	protected AbstractXScrollPanel(int x, int y, int width, int height, final XFrame frame, String panelAppearanceName, String scrollBarAppearanceName) {
		this(x, y, width, height, new FlowLayout(FlowLayout.CENTER, 0, 0), frame, panelAppearanceName, scrollBarAppearanceName);
	}

	public XPanel getViewPanel() {
		return this.viewPanel;
	}
}
