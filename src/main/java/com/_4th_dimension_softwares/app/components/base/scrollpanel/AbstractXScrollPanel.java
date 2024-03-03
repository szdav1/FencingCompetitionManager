package com._4th_dimension_softwares.app.components.base.scrollpanel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com._4th_dimension_softwares.app.components.base.panel.XPanel;
import com._4th_dimension_softwares.app.components.base.scrollpanel.scrollbar.XScrollBar;
import com._4th_dimension_softwares.app.components.interfaces.XComponent;
import com._4th_dimension_softwares.app.components.interfaces.XContainer;
import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.framework.Appearance;

public abstract class AbstractXScrollPanel extends JScrollPane implements XComponent, XContainer {
	protected Appearance appearance;
	protected final XFrame frame;
	protected XPanel viewPanel;

	protected AbstractXScrollPanel(Dimension dimension, LayoutManager layoutManager, XFrame frame, Appearance panelAppearance, Appearance scrollBarAppearance) {
		this.appearance = panelAppearance;
		this.frame = frame;
		this.viewPanel = new XPanel(new Dimension(0, 0), layoutManager, frame, panelAppearance);

		this.setVerticalScrollBar(new XScrollBar(JScrollBar.VERTICAL, scrollBarAppearance));
		this.setHorizontalScrollBar(new XScrollBar(JScrollBar.HORIZONTAL, scrollBarAppearance));
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.setViewportView(this.viewPanel);
		this.setBorder(null);
		this.setBackground(panelAppearance.getBackgrounds().get(panelAppearance.getBackgrounds().size()-1));
		this.setBounds(new Rectangle(0, 0, dimension.width, dimension.height));
		this.setPreferredSize(dimension);
	}

	protected AbstractXScrollPanel(Dimension dimension, XFrame frame, Appearance panelAppearance, Appearance scrollBarAppearance) {
		this(dimension, new FlowLayout(FlowLayout.CENTER, 0, 0), frame, panelAppearance, scrollBarAppearance);
	}

	protected AbstractXScrollPanel(int x, int y, int width, int height, LayoutManager layoutManager, XFrame frame, Appearance panelAppearance, Appearance scrollBarAppearance) {
		this.appearance = panelAppearance;
		this.frame = frame;
		this.viewPanel = new XPanel(new Dimension(0, 0), layoutManager, frame, panelAppearance);

		this.setVerticalScrollBar(new XScrollBar(JScrollBar.VERTICAL, scrollBarAppearance));
		this.setHorizontalScrollBar(new XScrollBar(JScrollBar.HORIZONTAL, scrollBarAppearance));
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.setViewportView(this.viewPanel);
		this.setBorder(null);
		this.setBackground(panelAppearance.getBackgrounds().get(panelAppearance.getBackgrounds().size()-1));
		this.setPreferredSize(new Dimension(width, height));
		this.setBounds(new Rectangle(x, y, width, height));
	}

	protected AbstractXScrollPanel(int x, int y, int width, int height, XFrame frame, Appearance panelAppearance, Appearance scrollBarAppearance) {
		this(x, y, width, height, new FlowLayout(FlowLayout.CENTER, 0, 0), frame, panelAppearance, scrollBarAppearance);
	}

	public XPanel getViewPanel() {
		return this.viewPanel;
	}
}
