package com._4th_dimension_softwares.app.view.components.custom.ui.sidebar;

import java.util.List;

import com._4th_dimension_softwares.app.view.components.base.button.ButtonType;
import com._4th_dimension_softwares.app.view.components.base.label.XLabel;
import com._4th_dimension_softwares.app.view.components.base.panel.XPanel;
import com._4th_dimension_softwares.app.view.components.custom.ui.menu.MenuButton;
import com._4th_dimension_softwares.app.view.frame.XFrame;
import com._4th_dimension_softwares.app.control.sidebar.SidebarController;
import com._4th_dimension_softwares.support.appdata.SizeData;
import com._4th_dimension_softwares.support.consts.RelativePositions;

/**
 * The <code>Sidebar</code> class contains the declaration of
 * everything that is in the sidebar of the application. Actions
 * happening in the sidebar are handled in this class,
 * buttons displayed in the sidebar are controlled by this class
 * etc.
 */
public final class Sidebar extends AbstractSidebar {
	// Header
	private final XLabel header;
	// Separator panels
	private final XPanel separator;
	// Menu buttons
	private final MenuButton competitionButton;
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
		super(frame, appearanceName);

		this.usePadding();

		// The listener that takes care of the mouse actions happened in the sidebar
		final SidebarController sml = new SidebarController(this);

		// Header
		this.header = new XLabel(SizeData.BUTTON_DIMENSION, "Management", frame, appearanceName+".header");
		this.header.centerContent();

		// Separator panels
		this.separator = new XPanel(SizeData.SEPARATOR_DIMENSION, frame, appearanceName+".separator");

		// Menu buttons
		this.competitionButton = new MenuButton(SizeData.BUTTON_DIMENSION, "Competition", frame, ButtonType.BACKGROUND_CHANGER, appearanceName+".buttons");
		this.settingsButton = new MenuButton(SizeData.BUTTON_DIMENSION, "SETTINGS", frame, ButtonType.BACKGROUND_CHANGER, appearanceName+".buttons");

		// Add the menu buttons to the menu button list
		this.menuButtons.add(competitionButton);
		this.menuButtons.add(settingsButton);

		// Implement the listener on the buttons
		this.menuButtons.forEach(btn -> btn.addMouseListener(sml));

		// Add the header to the sidebar
		this.addComponent(this.header);
		// Add the separator
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
			btn.adjustDropdownPosition(RelativePositions.TO_RIGHT, -SizeData.BORDER_SIZE, 0));
	}

	@Override
	public List<MenuButton> getButtons() {
		return this.menuButtons;
	}
}
