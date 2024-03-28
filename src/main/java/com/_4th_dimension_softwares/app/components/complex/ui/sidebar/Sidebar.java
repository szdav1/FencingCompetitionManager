package com._4th_dimension_softwares.app.components.complex.ui.sidebar;

import java.util.List;

import com._4th_dimension_softwares.app.components.base.button.ButtonType;
import com._4th_dimension_softwares.app.components.complex.ui.menu.MenuButton;
import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.app.listeners.SidebarMouseListener;
import com._4th_dimension_softwares.support.appdata.SizeData;

/**
 * The <code>Sidebar</code> class contains the declaration of
 * everything that is in the sidebar of the application. Actions
 * happening in the sidebar are handled in this class,
 * buttons displayed in the sidebar are controlled by this class
 * etc.
 */
public final class Sidebar extends AbstractSidebar {
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

		// The listener that takes care of the mouse actions happened in the sidebar
		final SidebarMouseListener sml = new SidebarMouseListener(this);

		// Menu buttons
		this.competitionButton = new MenuButton(SizeData.N_BUTTON_DIMENSION, "MENU", frame, ButtonType.FOREGROUND_CHANGER, appearanceName+".buttons");
		this.settingsButton = new MenuButton(SizeData.N_BUTTON_DIMENSION, "SETTINGS", frame, ButtonType.FOREGROUND_CHANGER, appearanceName+".buttons");

		// Add the menu buttons to the menu button list
		this.menuButtons.add(competitionButton);
		this.menuButtons.add(settingsButton);

		// Implement the listener on the buttons
		this.menuButtons.forEach(btn -> btn.addMouseListener(sml));

		// Add the menu buttons to the sidebar
		this.menuButtons.forEach(this::addComponent);
	}

	@Override
	public List<MenuButton> getButtons() {
		return this.menuButtons;
	}
}
