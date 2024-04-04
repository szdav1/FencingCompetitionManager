package com._4th_dimension_software.app.view.components.custom.ui.menu;

import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.app.view.components.base.button.XButton;
import com._4th_dimension_software.app.view.components.base.panel.XPanel;

public abstract class AbstractDropdownPanel extends XPanel {
	protected List<XButton> buttonList;

	public AbstractDropdownPanel(int x, int y, int width, int height, LayoutManager layoutManager, final XFrame frame, String appearanceName) {
		super(x, y, width, height, layoutManager, frame, appearanceName);

		this.buttonList = new ArrayList<>();
		this.setSize(this.getWidth()+this.appearance.getHorizontalPadding(), this.getHeight()+this.appearance.getVerticalPadding());
	}

	public AbstractDropdownPanel(int x, int y, int width, int height, final XFrame frame, String appearanceName) {
		super(x, y, width, height, frame, appearanceName);

		this.buttonList = new ArrayList<>();
		this.setSize(this.getWidth()+this.appearance.getHorizontalPadding(), this.getHeight()+this.appearance.getVerticalPadding());
	}

	public List<XButton> getButtonList() {
		return this.buttonList;
	}
}
