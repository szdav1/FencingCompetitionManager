package com._4th_dimension_softwares.app.components.interfaces;

import java.util.List;

import com._4th_dimension_softwares.app.components.complex.menu.MenuButton;

/**
 * The <code>XSidebar</code> interface is a
 * functional interface that defines the
 * <code>getMenuButtons()</code> method.
 *
 * @author szd
 */
@FunctionalInterface
public interface XSidebar {
	/**
	 * Returns every button inside the sidebar
	 * collected into an <code>ArrayList</code>.
	 *
	 * @return A list of the buttons contained in the sidebar
	 */
	List<MenuButton> getButtons();
}
