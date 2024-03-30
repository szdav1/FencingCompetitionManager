package com._4th_dimension_softwares.app.control;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Optional;

import javax.swing.JComponent;

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
public final class SidebarController implements MouseListener {
	private final Sidebar sidebar;
	private MenuButton previousButton;

	/**
	 * Constructs a <code>SidebarMouseListener</code>. It is
	 * important to note that the sidebar object that is passed
	 * into the constructor must be the same object where the
	 * actions happen.
	 *
	 * @param sidebar The sidebar that will receive this listener
	 */
	public SidebarController(final Sidebar sidebar) {
		this.sidebar = sidebar;
	}

	/**
	 * Tries to find the origin of an <code>InputEvent</code>.
	 * If the component that caused the event is in contained in
	 * the sidebar, it is returned wrapped around an <code>Optional</code>.
	 *
	 * @param ie The event that happened
	 * @return An <code>Optional</code> containing the source of the event
	 */
	private Optional<JComponent> findSourceOfInputEvent(final InputEvent ie) {
		for (MenuButton btn : this.sidebar.getButtons()) {
			if (btn.equals(ie.getSource()))
				return Optional.of(btn);
		}

		return Optional.empty();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		/*
		 * Activate a menu button so that its dropdown
		 * panel stays open even after exiting it with the
		 * cursor.
		 * */
		if (this.findSourceOfInputEvent(e).isPresent()) {
			MenuButton btn = (MenuButton) this.findSourceOfInputEvent(e).get();
			this.previousButton = btn;
			btn.setActive(!btn.isActive());
		}
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
		if (this.findSourceOfInputEvent(e).isPresent()) {
			MenuButton btn = (MenuButton) this.findSourceOfInputEvent(e).get();

			if (!btn.isActive())
				btn.showDropdownPanel();

			if (this.previousButton != null && !btn.equals(this.previousButton)) {
				this.previousButton.setActive(false);
				this.previousButton.hideDropdownPanel();
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		/*
		 * Hide the dropdown panel of the exited menu button.
		 * If the menu button that has been exited by the cursor
		 * was clicked, it has been activated so its dropdown panel
		 * must stay open after exiting.
		 * */
		if (this.findSourceOfInputEvent(e).isPresent()) {
			MenuButton btn = (MenuButton) this.findSourceOfInputEvent(e).get();

			if (!btn.isActive())
				btn.hideDropdownPanel();
		}
	}
}
