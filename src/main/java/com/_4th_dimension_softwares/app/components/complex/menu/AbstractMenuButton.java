package com._4th_dimension_softwares.app.components.complex.menu;

import java.awt.Dimension;

import com._4th_dimension_softwares.app.components.base.button.ButtonType;
import com._4th_dimension_softwares.app.components.base.button.XButton;
import com._4th_dimension_softwares.app.components.base.panel.XPanel;
import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.consts.PositionConstants;

public abstract class AbstractMenuButton extends XButton {
	protected XPanel dropdownPanel;

	public AbstractMenuButton(Dimension dimension, String text, final XFrame frame, ButtonType type, String appearanceName) {
		super(dimension, text, frame, type, appearanceName);
	}

	public AbstractMenuButton(Dimension dimension, final XFrame frame, ButtonType type, String appearanceName) {
		super(dimension, frame, type, appearanceName);
	}

	public AbstractMenuButton(int x, int y, int width, int height, String text, final XFrame frame, ButtonType type, String appearanceName) {
		super(x, y, width, height, text, frame, type, appearanceName);
	}

	public AbstractMenuButton(int x, int y, int width, int height, final XFrame frame, ButtonType type, String appearanceName) {
		super(x, y, width, height, frame, type, appearanceName);
	}

	public void displayDropdownPanel() {
		this.frame.addComponent(this.dropdownPanel, PositionConstants.HIGH_POSITION);
	}

	public void removeDropdownPanel() {
		this.frame.removeComponent(this.dropdownPanel);
	}
}
