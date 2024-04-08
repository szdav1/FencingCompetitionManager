package com._4th_dimension_software.app.view.components.custom.ui.menu;

import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import com._4th_dimension_software.app.view.components.base.button.XButton;
import com._4th_dimension_software.app.view.components.base.panel.XPanel;
import com._4th_dimension_software.app.view.frame.XFrame;

public abstract class AbstractDropdownPanel extends XPanel {
	protected List<XButton> buttons;

	protected AbstractDropdownPanel(int x, int y, int width, int height, LayoutManager layoutManager, final XFrame frame, String appearanceName) {
		super(x, y, width, height, layoutManager, frame, appearanceName);

		this.buttons = new ArrayList<>();
		this.setSize(this.getWidth(), this.getHeight());
	}

	protected AbstractDropdownPanel(int x, int y, int width, int height, final XFrame frame, String appearanceName) {
		super(x, y, width, height, frame, appearanceName);

		this.buttons = new ArrayList<>();
		this.setSize(this.getWidth(), this.getHeight());
	}

	public List<XButton> getButtons() {
		return this.buttons;
	}

	/**
	 * Returns the first button in the dropdown panel.
	 *
	 * @return The first button in the dropdown panel
	 */
	public XButton getFirstButton() {
		return this.buttons.get(0);
	}

	/**
	 * Returns the last button in the dropdown panel.
	 *
	 * @return The last button in the dropdown panel
	 */
	public XButton getLastButton() {
		return this.buttons.get(this.buttons.size()-1);
	}
}
