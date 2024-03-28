package com._4th_dimension_softwares.app.components.complex.ui.sidebar;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import com._4th_dimension_softwares.app.components.base.panel.XPanel;
import com._4th_dimension_softwares.app.components.complex.ui.menu.MenuButton;
import com._4th_dimension_softwares.app.components.interfaces.XSidebar;
import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.appdata.SizeData;
import com._4th_dimension_softwares.support.consts.PositionConstants;

public abstract class AbstractSidebar extends XPanel implements XSidebar {
	protected List<MenuButton> menuButtons;

	protected AbstractSidebar(final XFrame frame, String appearanceName) {
		super(SizeData.SIDEBAR_DIMENSION, new FlowLayout(FlowLayout.CENTER, 0, SizeData.BORDER_SIZE), frame, appearanceName);

		this.menuButtons = new ArrayList<>();

		// Automatically add the sidebar to the main frame of the application
		this.frame.addComponent(this, PositionConstants.LEFT_POSITION);
	}
}
