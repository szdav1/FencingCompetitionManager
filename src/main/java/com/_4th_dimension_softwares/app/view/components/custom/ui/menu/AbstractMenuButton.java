package com._4th_dimension_softwares.app.view.components.custom.ui.menu;

import java.awt.Dimension;

import com._4th_dimension_softwares.app.view.components.base.button.ButtonType;
import com._4th_dimension_softwares.app.view.components.base.button.XButton;
import com._4th_dimension_softwares.app.view.frame.XFrame;
import com._4th_dimension_softwares.support.appdata.SizeData;
import com._4th_dimension_softwares.support.consts.RelativePositions;

public abstract class AbstractMenuButton extends XButton {
	protected boolean active;
	protected RelativePositions dropdownPosition;
	protected DropdownPanel dropdownPanel;

	public AbstractMenuButton(Dimension dimension, String text, final XFrame frame, ButtonType type, String appearanceName) {
		super(dimension, text, frame, type, appearanceName);

		this.active = false;
		this.dropdownPosition = RelativePositions.TO_RIGHT;
		this.dropdownPanel = new DropdownPanel(0, 0, SizeData.DROPDOWN_WIDTH, SizeData.DROPDOWN_HEIGHT, frame, appearanceName+".dropdown");
	}

	public AbstractMenuButton(Dimension dimension, final XFrame frame, ButtonType type, String appearanceName) {
		this(dimension, "", frame, type, appearanceName);
	}

	public AbstractMenuButton(int x, int y, int width, int height, String text, final XFrame frame, ButtonType type, String appearanceName) {
		super(x, y, width, height, text, frame, type, appearanceName);

		this.active = false;
		this.dropdownPosition = RelativePositions.TO_RIGHT;
		this.dropdownPanel = new DropdownPanel(0, 0, SizeData.DROPDOWN_WIDTH, SizeData.DROPDOWN_HEIGHT, frame, appearanceName+".dropdown");
	}

	public AbstractMenuButton(int x, int y, int width, int height, final XFrame frame, ButtonType type, String appearanceName) {
		this(x, y, width, height, "", frame, type, appearanceName);
	}

	/**
	 * Shortcut to the <code>DropdownPanel</code> class's
	 * <code>createAndAddButton()</code> method. It calls the
	 * dropdown panel's method with the specified text.
	 *
	 * @param buttonText The text of the button
	 */
	public void addButtonToDropdown(String buttonText) {
		this.dropdownPanel.createAndAddButton(buttonText);
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public DropdownPanel getDropdownPanel() {
		return this.dropdownPanel;
	}

	/**
	 * Sets the relative position of the dropdown panel.
	 * The position of the dropdown panel is always relative
	 * to the menu button's position.
	 * <p>Valid values are:</p>
	 * - <code>ON_TOP</code> the dropdown panel will be displaying
	 * on top of the menu button.
	 * <p></p>
	 * - <code>TO_RIGHT</code> the dropdown panel will be displaying
	 * on the right side of the menu button.
	 * <p></p>
	 * - <code>AT_BOTTOM</code> the dropdown panel will be displaying
	 * at the bottom of the menu button.
	 * <p></p>
	 * - <code>TO_LEFT</code> the dropdown panel will be displaying
	 * on the left side of the menu button.
	 *
	 * @param relativePositions A <code>RelativePositions</code> enum value that defines the
	 *                          relative position of the dropdown panel
	 */
	public abstract void setDropdownPosition(RelativePositions relativePositions);
}
