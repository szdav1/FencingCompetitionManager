package com._4th_dimension_softwares.app.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com._4th_dimension_softwares.app.components.complex.ui.menu.MenuButton;
import com._4th_dimension_softwares.app.components.complex.ui.sidebar.Sidebar;

/**
 * The <code>SidebarMouseListener</code> is the class that handles mouse
 * actions that happened inside the sidebar using a <code>MouseListener</code>.
 * This "listener" class takes care of handling the menu buttons' dropdown panels,
 * actions happening inside the dropdown panels etc. Basically, every mouse action
 * that happens inside the sidebar and must be handled will end up being processed
 * by this class.
 */
public final class SidebarMouseListener implements MouseListener {
	private final Sidebar sidebar;
	private MenuButton previousButton;

	/**
	 * Constructs a <code>SidebarMouseListener</code>. It is
	 * important to note that the sidebar object that is passed
	 * into the constructor must be the same object where the
	 * mouse actions happen.
	 *
	 * @param sidebar The sidebar that will receive this listener
	 */
	public SidebarMouseListener(final Sidebar sidebar) {
		this.sidebar = sidebar;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		/*
		 * Activate a menu button so that its dropdown
		 * panel stays open even after exiting it with the
		 * cursor.
		 * */
		this.sidebar.getButtons().forEach(btn -> {
			if (btn.equals(e.getSource())) {
				this.previousButton = btn;
				btn.setActive(!btn.isActive());
			}
		});
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		/*
		 * Show the dropdown panel of the hovered menu button.
		 * If there's a previous button (a button that has been pressed
		 * before the current one making its dropdown panel stay open) it
		 * is deactivated.
		 * */
		this.sidebar.getButtons().forEach(btn -> {
			if (btn.equals(e.getSource()) && !btn.isActive()) {
				if (this.previousButton != null) {
					this.previousButton.setActive(false);
					this.previousButton.hideDropdownPanel();
				}

				btn.showDropdownPanel();
			}
		});
	}

	@Override
	public void mouseExited(MouseEvent e) {
		/*
		 * Hide the dropdown panel of the exited menu button.
		 * If the menu button that has been exited by the cursor
		 * was clicked, it has been activated so its dropdown panel
		 * must stay open after exiting.
		 * */
		this.sidebar.getButtons().forEach(btn -> {
			if (btn.equals(e.getSource()) && !btn.isActive())
				btn.hideDropdownPanel();
		});
	}
}
