package com._4th_dimension_software.app.view.components.built.ui.sidebar.menu;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import com._4th_dimension_software.app.view.components.base.button.XButton;
import com._4th_dimension_software.app.view.components.base.panel.XPanel;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.appdata.SizeData;

/**
 * The <code>DropdownPanel</code> class is a child class
 * of the <code>XPanel</code> class. As the name implies,
 * it is a dropdown panel. When the corresponding menu button
 * is pressed and activated, the dropdown panel appears.
 * This class holds its subcomponents (buttons) in an <code>ArrayList</code> for
 * easy access.
 *
 * @author szd
 */
public class DropdownPanel extends XPanel {
	private final List<XButton> buttons;
	private boolean displaying;
	private String recentAppearanceName;

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

		this.buttons = new ArrayList<>();
		this.displaying = false;
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

		this.buttons = new ArrayList<>();
		this.displaying = false;
	}

	public List<XButton> getButtons() {
		return this.buttons;
	}

	public boolean isDisplaying() {
		return this.displaying;
	}

	public void setDisplaying(boolean displaying) {
		this.displaying = displaying;
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

	/**
	 * Creates and adds a button to the dropdown panel
	 * with the specified text and shortcut key text.
	 * The dropdown panel is resized vertically if needed.
	 *
	 * @param buttonText The text of the button
	 */
	public void createAndAddButton(String buttonText, String shortcutKeyText, String appearanceName) {
		this.recentAppearanceName = appearanceName;
		XButton btn = new XButton(new Dimension(this.getWidth(), SizeData.BUTTON_HEIGHT), buttonText, shortcutKeyText, this.frame, appearanceName);
		btn.setMargin(new Insets(0, SizeData.TEXT_MARGIN, 0, 0));

		this.buttons.add(btn);
		int newHeight = SizeData.calcDropdownHeight(this.buttons.size());

		this.setSize(this.getWidth(), newHeight);
		this.addComponent(btn);
	}

	/**
	 * Creates and adds a button to the dropdown panel
	 * with the specified text. The dropdown panel is resized vertically if needed.
	 *
	 * @param buttonText The text of the button
	 */
	public void createAndAddButton(String buttonText, String appearanceName) {
		this.createAndAddButton(buttonText, "", appearanceName);
	}

	/**
	 * Creates and adds a button to the dropdown panel
	 * with the specified text using the recently passed in
	 * appearance name. The dropdown panel is resized vertically if needed.
	 *
	 * @param buttonText The text of the button
	 */
	public void createAndAddButton(String buttonText) {
		this.createAndAddButton(buttonText, this.recentAppearanceName);
	}
}
