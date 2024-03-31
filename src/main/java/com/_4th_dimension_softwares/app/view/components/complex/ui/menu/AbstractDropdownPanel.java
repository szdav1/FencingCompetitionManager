package com._4th_dimension_softwares.app.view.components.complex.ui.menu;

import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import com._4th_dimension_softwares.app.view.components.base.button.XButton;
import com._4th_dimension_softwares.app.view.components.base.panel.XPanel;
import com._4th_dimension_softwares.app.view.frame.XFrame;

public abstract class AbstractDropdownPanel extends XPanel {
	protected List<XButton> buttonList;

	public AbstractDropdownPanel(int x, int y, int width, int height, LayoutManager layoutManager, final XFrame frame, String appearanceName) {
		super(x, y, width, height, layoutManager, frame, appearanceName);

		this.buttonList = new ArrayList<>();
	}

	public AbstractDropdownPanel(int x, int y, int width, int height, final XFrame frame, String appearanceName) {
		super(x, y, width, height, frame, appearanceName);

		this.buttonList = new ArrayList<>();
	}

	public List<XButton> getButtonList() {
		return this.buttonList;
	}


	/**
	 * Creates and adds a button to the dropdown panel
	 * with the specified text.
	 *
	 * @param buttonText The text of the button
	 */
	public abstract void createAndAddButton(String buttonText);
}
