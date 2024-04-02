package com._4th_dimension_softwares.app.view.components.custom.ui.menu;

import java.awt.Dimension;
import java.awt.Point;

import com._4th_dimension_softwares.app.view.components.base.button.ButtonType;
import com._4th_dimension_softwares.app.view.frame.XFrame;
import com._4th_dimension_softwares.support.appdata.SizeData;
import com._4th_dimension_softwares.support.consts.PositionConstants;
import com._4th_dimension_softwares.support.consts.RelativePositions;

/**
 * The <code>MenuButton</code> class is a child of the
 * <code>XButton</code> class. This class is used to create
 * structured menus for easy navigation. It has a dropdown panel,
 * which is activated when the button is pressed.
 */
public class MenuButton extends AbstractMenuButton {
	/**
	 * Constructs a <code>MenuButton</code> object
	 * with the desired dimension and text.
	 *
	 * @param dimension      The Dimension of the menu button
	 * @param text           The text of the menu button
	 * @param frame          The main frame of the application
	 * @param type           The type of the button
	 * @param appearanceName The name of the <code>Appearance</code> that's values
	 *                       should be implemented on this panel
	 */
	public MenuButton(Dimension dimension, String text, final XFrame frame, ButtonType type, String appearanceName) {
		super(dimension, text, frame, type, appearanceName);
	}

	/**
	 * Adds the dropdown panel of this menu button
	 * to the main frame of the application at the set position.
	 */
	public void showDropdownPanel() {
		this.setDropdownPosition(this.dropdownPosition);
		this.frame.addToCenterPanel(this.dropdownPanel, PositionConstants.HIGH_POSITION);
	}

	/**
	 * Removes the dropdown panel of the menu button
	 * from the main frame of the application.
	 */
	public void hideDropdownPanel() {
		this.frame.removeFromCenterPanel(this.dropdownPanel);
	}

	@Override
	public void setDropdownPosition(RelativePositions relativePositions) {
		this.dropdownPosition = relativePositions;

		if (this.getParent() == null)
			return;

		final Point p = this.getLocationOnScreen();

		if (relativePositions == RelativePositions.TO_RIGHT)
			this.dropdownPanel.setLocation(p.x-SizeData.BORDER_SIZE, p.y);

	}
}
