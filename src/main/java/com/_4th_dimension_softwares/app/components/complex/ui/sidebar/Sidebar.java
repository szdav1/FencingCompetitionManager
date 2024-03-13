package com._4th_dimension_softwares.app.components.complex.ui.sidebar;

import java.util.List;

import com._4th_dimension_softwares.app.components.complex.menu.MenuButton;
import com._4th_dimension_softwares.app.frame.XFrame;

/**
 * The <code>Sidebar</code> class contains the declaration of
 * everything that is in the sidebar of the application. Actions
 * happening in the sidebar are handled in this class,
 * buttons displayed in the sidebar are controlled by this class
 * etc.
 */
public final class Sidebar extends AbstractSidebar {
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
	public Sidebar(XFrame frame, String appearanceName) {
		super(frame, appearanceName);
	}

	@Override
	public List<MenuButton> getButtons() {
		return this.menuButtons;
	}
}
