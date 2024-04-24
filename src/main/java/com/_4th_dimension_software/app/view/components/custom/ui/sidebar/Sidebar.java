package com._4th_dimension_software.app.view.components.custom.ui.sidebar;

import com._4th_dimension_software.app.control.sidebar.SidebarController;
import com._4th_dimension_software.app.view.components.base.label.XLabel;
import com._4th_dimension_software.app.view.components.base.panel.XPanel;
import com._4th_dimension_software.app.view.components.custom.ui.sidebar.menu.MenuButton;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.consts.RelativePositions;

import java.util.ArrayList;
import java.util.List;

/**
 * The <code>Sidebar</code> class contains the declaration of
 * everything that is in the sidebar of the application. Actions
 * happening in the sidebar are handled in this class,
 * buttons displayed in the sidebar are controlled by this class
 * etc.
 */
public final class Sidebar extends XPanel {
	// List of the buttons
	private List<MenuButton> menuButtons;
	// Header
	private final XLabel header;
	// Separator
	private final XLabel separator;
	// Menu buttons
	private final MenuButton newButton;
	private final MenuButton settingsButton;

	/**
	 * Constructs a <code>Sidebar</code> object.
	 * This object's UI representation is
	 * automatically added to the main frame of the
	 * application.
	 *
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the <code>Appearance</code> that's
	 *                       values should be implemented on this sidebar
	 */
	public Sidebar(final XFrame frame, String appearanceName) {
		super(SizeData.SIDEBAR_DIMENSION, frame, appearanceName);

		this.menuButtons = new ArrayList<>();

		// The listener that takes care of the mouse actions happened in the sidebar
		final SidebarController sml = new SidebarController(this);

		// Header
		this.header = new XLabel(SizeData.W_BUTTON_DIMENSION, "Dashboard", frame, appearanceName+".header");
		this.header.centerContent();

		// Separator
		this.separator = new XLabel(SizeData.SEPARATOR_DIMENSION, "", frame, appearanceName+".separator");

		// Menu buttons
		this.newButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, "New", frame, appearanceName+".buttons.new");
		this.newButton.addButtonToDropdown("Competition");
		this.newButton.addButtonToDropdown("Empty Poule");
		this.newButton.addButtonToDropdown("Empty Table");

		this.settingsButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, "Settings", frame, appearanceName+".buttons.settings");
		this.settingsButton.addButtonToDropdown("Appearance");

		// Add the menu buttons to the menu button list
		this.menuButtons.add(newButton);
		this.menuButtons.add(settingsButton);

		// Implement the controller
		this.menuButtons.forEach(btn -> btn.addMouseListener(sml));
		this.frame.getCenterPanel().addMouseListener(sml);

		// Add the header to the sidebar
		this.addComponent(this.header);
		// Add the separator to the sidebar
		this.addComponent(this.separator);

		// Add the menu buttons to the sidebar
		this.menuButtons.forEach(this::addComponent);
	}

	/**
	 * Adjusts the location of dropdown panels of
	 * menu buttons to display correctly. This
	 * method requires the main frame of the application
	 * to be visible.
	 */
	public void performAdjustments() {
		this.menuButtons.forEach(btn ->
			btn.adjustDropdownPosition(RelativePositions.TO_RIGHT, 0, 0));
	}

	public List<MenuButton> getButtons() {
		return this.menuButtons;
	}
}
