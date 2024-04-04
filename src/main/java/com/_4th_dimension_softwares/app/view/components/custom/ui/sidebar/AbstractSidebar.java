package com._4th_dimension_softwares.app.view.components.custom.ui.sidebar;

import java.util.ArrayList;
import java.util.List;

import com._4th_dimension_softwares.app.view.components.base.panel.XPanel;
import com._4th_dimension_softwares.app.view.components.custom.ui.menu.MenuButton;
import com._4th_dimension_softwares.app.view.components.interfaces.XSidebar;
import com._4th_dimension_softwares.app.view.frame.XFrame;
import com._4th_dimension_softwares.support.appdata.SizeData;

public abstract class AbstractSidebar extends XPanel implements XSidebar {
	protected List<MenuButton> menuButtons;

	protected AbstractSidebar(final XFrame frame, String appearanceName) {
		super(SizeData.SIDEBAR_DIMENSION, frame, appearanceName);

		this.menuButtons = new ArrayList<>();
	}
}