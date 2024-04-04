package com._4th_dimension_software.app.view.components.base.scrollpanel.scrollbar;

import java.awt.Dimension;

import javax.swing.JScrollBar;

import com._4th_dimension_software.app.view.components.base.scrollpanel.scrollbar.ui.XScrollBarUI;
import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.framework.Appearance;
import com._4th_dimension_software.support.framework.Appearances;

public abstract class AbstractXScrollBar extends JScrollBar {
	protected Appearance appearance;

	protected AbstractXScrollBar(Dimension dimension, int orientation, String appearanceName) {
		this.appearance = Appearances.get(appearanceName);

		this.setBorder(null);
		this.setFocusable(false);
		this.setOrientation(orientation);
		this.setUI(new XScrollBarUI(appearanceName));
		this.setPreferredSize(dimension);
	}

	protected AbstractXScrollBar(int orientation, String appearanceName) {
		this(orientation == JScrollBar.VERTICAL ?
			SizeData.V_SCROLL_BAR_DIMENSION :
			SizeData.H_SCROLL_BAR_DIMENSION, orientation, appearanceName);
	}

	public Appearance getAppearance() {
		return this.appearance;
	}
}
