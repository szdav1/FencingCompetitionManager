package com._4th_dimension_softwares.app.components.complex.ui.sidebar;

import com._4th_dimension_softwares.app.components.base.panel.XPanel;
import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.appdata.SizeData;
import com._4th_dimension_softwares.support.framework.Appearance;

public abstract class AbstractSidebar extends XPanel {
	protected AbstractSidebar(XFrame frame, String appearanceName) {
		super(SizeData.SIDEBAR_DIMENSION, frame, appearanceName);
	}
}
