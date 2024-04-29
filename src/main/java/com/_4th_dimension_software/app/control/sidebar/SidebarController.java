package com._4th_dimension_software.app.control.sidebar;

import com._4th_dimension_software.app.control.XController;
import com._4th_dimension_software.app.view.components.base.button.XButton;
import com._4th_dimension_software.app.view.components.custom.ui.sidebar.Sidebar;
import com._4th_dimension_software.app.view.components.custom.ui.sidebar.menu.MenuButton;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Optional;

/**
 * The <code>SidebarMouseListener</code> is the class that handles mouse
 * actions that happened inside the sidebar using a <code>MouseListener</code>.
 * This "listener" class takes care of handling the menu buttons' dropdown panels,
 * actions happening inside the dropdown panels etc. Basically, every action
 * that happens inside the sidebar and must be handled will end up being processed
 * by this class.
 */
public final class SidebarController extends XController {
    private final Sidebar sidebar;
    private MenuButton prevButton;
    private MenuButton prevEnteredButton;

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
     * Tries to find the origin of the specified <code>InputEvent</code>.
     * If the <code>XButton</code> that caused the event is contained in
     * the sidebar, it is returned in an <code>Optional</code>.
     *
     * @param ie The event that happened
     * @return An <code>Optional</code> containing the source of the event
     */
    private Optional<XButton> findButtonSourceOfInputEvent(final InputEvent ie) {
        for (MenuButton btn : this.sidebar.getButtons()) {
            // If one of the buttons is the source
            if (btn.equals(ie.getSource()))
                return Optional.of(btn);
        }

        return Optional.empty();
    }

    /**
     * Determines whether the dropdown panels should be closed
     * or not.
     *
     * @param ie The event that triggered the action
     * @return True if certain components were the source of the event, false otherwise
     */
    private boolean shouldCloseDropdownPanels(final InputEvent ie) {
        return this.sidebar.getFrame()
            .getCenterPanel()
            .equals(ie.getSource()) ||

            this.sidebar.getExitButton()
                .equals(ie.getSource()) ||

            this.sidebar.equals(ie.getSource());
    }

    /**
     * Performs the appropriate dropdown panel method
     * according to the ID of the given <code>MouseEvent</code>.
     *
     * @param me The <code>MouseEvent</code> that triggered a dropdown panel
     */
    private void handleDropdownPanels(final MouseEvent me) {
        Optional<XButton> btnOptional = this.findButtonSourceOfInputEvent(me);
        boolean scdps = this.shouldCloseDropdownPanels(me);

        /*
         * If the center panel is entered and there was a button previously
         * hovered by the mouse which is currently not active, its dropdown
         * panel should be removed from the scene.
         * */
        if (scdps && this.prevEnteredButton != null && !this.prevEnteredButton.isActive()) {
            this.prevEnteredButton.hideDropdownPanel();
            return;
        }

        if (btnOptional.isEmpty())
            return;

        int meID = me.getID();
        MenuButton btn = (MenuButton) btnOptional.get();

        /*
         * Show the dropdown panel of the hovered menu button.
         * If there's a previous button (a button that has been pressed
         * before the current one making its dropdown panel stay open) it
         * is deactivated.
         * */
        if (meID == MouseEvent.MOUSE_ENTERED) {
            if (this.prevEnteredButton != null) {
                /*
                 * If the previously entered button is the same as the currently
                 * entered button and that button is not displaying its dropdown panel,
                 * it should start displaying it.
                 * */
                if (this.prevEnteredButton.equals(btn) && !btn.getDropdownPanel().isDisplaying())
                    btn.showDropdownPanel();
                    /*
                     * If the previously entered button is not the same as the currently
                     * entered button, that button should start displaying its dropdown panel
                     * while the previous should hide it.
                     * */
                else {
                    this.prevEnteredButton.hideDropdownPanel();
                    btn.showDropdownPanel();
                }
            }
            else
                btn.showDropdownPanel();


            if (this.prevButton != null && !btn.equals(this.prevButton)) {
                this.prevButton.setActive(false);
                this.prevButton.hideDropdownPanel();
            }

            this.prevEnteredButton = btn;
        }
        /*
         * Activate a menu button so that its dropdown
         * panel stays open even after exiting it with the
         * cursor.
         * */
        else if (meID == MouseEvent.MOUSE_CLICKED) {
            this.prevButton = btn;
            btn.setActive(!btn.isActive());
        }
        /*
         * Hide the dropdown panel of the exited menu button.
         * If the menu button that has been exited by the cursor
         * was clicked, it has been activated so its dropdown panel
         * must stay open after exiting.
         * */
        else if (meID == MouseEvent.MOUSE_EXITED) {
            if (!btn.isActive() && scdps)
                btn.hideDropdownPanel();
        }
    }

    /**
     * Exits the application if the source of the
     * specified <code>MouseEvent</code> is the exit button
     * of the sidebar.
     *
     * @param ae The <code>MouseEvent</code> that occurred
     */
    private void handleExit(final ActionEvent ae) {
        if (ae.getSource().equals(this.sidebar.getExitButton())) {
            this.sidebar.getFrame().dispose();
            System.exit(0);
        }
    }

    /**
     * Handles action happened inside the dropdown panel
     * of the poule button inside the sidebar.
     *
     * @param ae The <code>ActionEvent</code> that occurred
     */
    private void handlePouleButtonActions(final ActionEvent ae) {
        List<XButton> pouleButtonButtons = this.sidebar.getButtons()
            .get(0)
            .getDropdownPanel()
            .getButtons();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.handleDropdownPanels(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.handleDropdownPanels(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.handleDropdownPanels(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.handleExit(e);
        this.handlePouleButtonActions(e);
    }
}
