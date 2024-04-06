package com._4th_dimension_software.app.view.components.custom.ui.menu;

import java.awt.Dimension;
import java.awt.LayoutManager;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.app.view.components.base.button.ButtonType;
import com._4th_dimension_software.app.view.components.base.button.XButton;

/**
 * The <code>DropdownPanel</code> class is a child class
 * of the <code>XPanel</code> class. As the name implies,
 * it is a dropdown panel. When the corresponding menu button
 * is pressed and activated, the dropdown panel appears.
 * This class holds the buttons that it contains in an <code>ArrayList</code>
 * for easier access.
 */
public class DropdownPanel extends AbstractDropdownPanel {
	/**
	 * Constructs a <code>DropdownPanel</code> object.
	 * The created object will be placed on the specified X and Y
	 * coordinates with the specified width and height.
	 *
	 * @param x              The X coordinate of the dropdown panel in no-layout manager space
	 * @param y              The Y coordinate of the dropdown panel in no-layout manager space
	 * @param width          The width of the dropdown panel
	 * @param height         The height of the dropdown panel
	 * @param layoutManager  The LayoutManager of the panel
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the <code>Appearance</code> that's values
	 *                       should be implemented on this panel
	 */
	public DropdownPanel(int x, int y, int width, int height, LayoutManager layoutManager, final XFrame frame, String appearanceName) {
		super(x, y, width, height, layoutManager, frame, appearanceName);
	}

	/**
	 * Constructs a <code>DropdownPanel</code> object.
	 * The created object will be placed on the specified X and Y
	 * coordinates with the specified width and height.
	 *
	 * @param x              The X coordinate of the dropdown panel in no-layout manager space
	 * @param y              The Y coordinate of the dropdown panel in no-layout manager space
	 * @param width          The width of the dropdown panel
	 * @param height         The height of the dropdown panel
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the <code>Appearance</code> that's values
	 *                       should be implemented on this panel
	 */
	public DropdownPanel(int x, int y, int width, int height, final XFrame frame, String appearanceName) {
		super(x, y, width, height, frame, appearanceName);
	}

	/**
	 * Creates and adds a button to the dropdown panel
	 * with the specified text.
	 *
	 * @param buttonText The text of the button
	 */
	public void createAndAddButton(String buttonText) {
		XButton btn = new XButton(new Dimension(this.getWidth(), SizeData.BUTTON_HEIGHT),
			buttonText, this.frame, ButtonType.BACKGROUND_CHANGER, "sidebar.buttons.dropdown.buttons");

		this.buttonList.add(btn);
		int newHeight = SizeData.calcDropdownHeight(this.buttonList.size());

		this.setSize(this.getWidth(), newHeight);
		this.addComponent(btn);
	}
}
