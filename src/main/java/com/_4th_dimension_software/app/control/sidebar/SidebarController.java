package com._4th_dimension_software.app.control.sidebar;

import com._4th_dimension_software.app.control.AbstractXController;
import com._4th_dimension_software.app.view.components.base.button.XButton;
import com._4th_dimension_software.app.view.components.built.ui.sidebar.Sidebar;
import com._4th_dimension_software.app.view.components.built.ui.sidebar.menu.MenuButton;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Optional;

/**
 * The <code>SidebarController</code> is the class that handles actions that happened inside the
 * sidebar using the <code>MouseListener</code>, the <code>MouseMotionListener</code>, the
 * <code>ActionListener</code> and the <code>KeyListener</code> interfaces.
 * This controller class takes care of handling the menu buttons' dropdown panels,
 * actions happening inside the dropdown panels etc. Basically, every action
 * that happens inside the sidebar and must be handled will end up being processed
 * by this class.
 *
 * @author szd
 */
public final class SidebarController extends AbstractXController {
    private final Sidebar sidebar;
    private MenuButton prevButton;
    private MenuButton prevEnteredButton;

    /**
     * Constructs a <code>SidebarController</code>. It is
     * important to note that the sidebar object that is passed
     * into the constructor must be the same object where the
     * actions happen.
     *
     * @param sidebar The sidebar that will receive this listener
     */
    public SidebarController(final Sidebar sidebar) {
        this.sidebar = sidebar;

        // Instantiate the key action classes
        new SidebarKeyActions(sidebar);
        new PouleMenuKeyActions(sidebar);
        new TableMenuKeyActions(sidebar);
        new CompetitionMenuKeyActions(sidebar);
        new RuleSetMenuKeyActions(sidebar);
        new SettingsMenuKeyActions(sidebar);
        new DatabaseMenuKeyActions(sidebar);
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
        if (ae.getSource().equals(this.sidebar.getExitButton()))
            this.sidebar.getFrame().exit();
    }

    /**
     * Handles actions related to the buttons contained inside the
     * poule menu button's dropdown panel. The actions of these buttons
     * are defined another time for the key bindings.
     *
     * @param ae The <code>ActionEvent</code> that happened
     */
    private void handlePouleButtons(final ActionEvent ae) {
        int srcBtnInd = -1;
        int ind = 0;

        List<XButton> pouleMenuButtons = this.sidebar.getButtons()
            .get(0)
            .getDropdownPanel()
            .getButtons();

        while (srcBtnInd == -1 && ind < pouleMenuButtons.size()) {
            if (pouleMenuButtons.get(ind).equals(ae.getSource()))
                srcBtnInd = ind;

            ind++;
        }

        switch (srcBtnInd) {
            case 0 -> this.sidebar.getFrame().openEmptyPouleEditor();
            case 1 -> this.sidebar.getFrame().openPouleFromDatabaseEditor();
            case 2 -> this.sidebar.getFrame().openPouleStatsInspector();
            default -> {
            }
        }
    }

    /**
     * Handles actions related to the buttons contained inside the
     * table menu button's dropdown panel. The actions of these buttons
     * are defined another time for the key bindings.
     *
     * @param ae The <code>ActionEvent</code> that happened
     */
    private void handleTableButtons(final ActionEvent ae) {
        int srcBtnInd = -1;
        int ind = 0;

        List<XButton> tableMenuButtons = this.sidebar.getButtons()
            .get(1)
            .getDropdownPanel()
            .getButtons();

        while (srcBtnInd == -1 && ind < tableMenuButtons.size()) {
            if (tableMenuButtons.get(ind).equals(ae.getSource()))
                srcBtnInd = ind;

            ind++;
        }

        switch (srcBtnInd) {
            case 0 -> this.sidebar.getFrame().openEmptyTableEditor();
            case 1 -> this.sidebar.getFrame().openTableFromDatabaseEditor();
            case 2 -> this.sidebar.getFrame().openTableStatsInspector();
            default -> {
            }
        }
    }

    /**
     * Handles actions related to the buttons contained inside the
     * competition menu button's dropdown panel. The actions of these buttons
     * are defined another time for the key bindings.
     *
     * @param ae The <code>ActionEvent</code> that happened
     */
    private void handleCompetitionButtons(final ActionEvent ae) {
        int srcBtnInd = -1;
        int ind = 0;

        List<XButton> competitionMenuButtons = this.sidebar.getButtons()
            .get(2)
            .getDropdownPanel()
            .getButtons();

        while (srcBtnInd == -1 && ind < competitionMenuButtons.size()) {
            if (competitionMenuButtons.get(ind).equals(ae.getSource()))
                srcBtnInd = ind;

            ind++;
        }

        switch (srcBtnInd) {
            case 0 -> this.sidebar.getFrame().openEmptyCompetitionEditor();
            case 1 -> this.sidebar.getFrame().openCompetitionFromDatabaseEditor();
            case 2 -> this.sidebar.getFrame().openCompetitionStatsInspector();
            default -> {
            }
        }
    }

    /**
     * Handles actions related to the buttons contained inside the
     * rule set menu button's dropdown panel. The actions of these buttons
     * are defined another time for the key bindings.
     *
     * @param ae The <code>ActionEvent</code> that happened
     */
    private void handleRuleSetButtons(final ActionEvent ae) {
        int srcBtnInd = -1;
        int ind = 0;

        List<XButton> ruleSetMenuButtons = this.sidebar.getButtons()
            .get(3)
            .getDropdownPanel()
            .getButtons();

        while (srcBtnInd == -1 && ind < ruleSetMenuButtons.size()) {
            if (ruleSetMenuButtons.get(ind).equals(ae.getSource()))
                srcBtnInd = ind;

            ind++;
        }

        switch (srcBtnInd) {
            case 0 -> this.sidebar.getFrame().openRuleSetInspector();
            case 1 -> this.sidebar.getFrame().openNewRuleSetEditor();
            case 2 -> this.sidebar.getFrame().openRuleSetDeleter();
            case 3 -> this.sidebar.getFrame().openRuleSetModifier();
            default -> {
            }
        }
    }

    /**
     * Handles actions related to the buttons contained inside the
     * settings menu button's dropdown panel. The actions of these buttons
     * are defined another time for the key bindings.
     *
     * @param ae The <code>ActionEvent</code> that happened
     */
    public void handleSettingsButtons(final ActionEvent ae) {
        int srcBtnInd = -1;
        int ind = 0;

        List<XButton> settingsMenuButtons = this.sidebar.getButtons()
            .get(4)
            .getDropdownPanel()
            .getButtons();

        while (srcBtnInd == -1 && ind < settingsMenuButtons.size()) {
            if (settingsMenuButtons.get(ind).equals(ae.getSource()))
                srcBtnInd = ind;

            ind++;
        }

        switch (srcBtnInd) {
            case 0 -> this.sidebar.getFrame().openInterfaceEditor();
            case 1 -> this.sidebar.getFrame().openLanguageEditor();
            default -> {
            }
        }
    }

    /**
     * Handles actions related to the buttons contained inside the
     * database menu button's dropdown panel. The actions of these buttons
     * are defined another time for the key bindings.
     *
     * @param ae The <code>ActionEvent</code> that happened
     */
    public void handleDatabaseButtons(final ActionEvent ae) {
        int srcBtnInd = -1;
        int ind = 0;

        List<XButton> settingsMenuButtons = this.sidebar.getButtons()
            .get(5)
            .getDropdownPanel()
            .getButtons();

        while (srcBtnInd == -1 && ind < settingsMenuButtons.size()) {
            if (settingsMenuButtons.get(ind).equals(ae.getSource()))
                srcBtnInd = ind;

            ind++;
        }

        switch (srcBtnInd) {
            case 0 -> this.sidebar.getFrame().openDatabaseConnectionEditor();
            case 1 -> {}
            default -> {
            }
        }
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
        // Make the calls for the action handling methods
        this.handleExit(e);
        this.handlePouleButtons(e);
        this.handleTableButtons(e);
        this.handleCompetitionButtons(e);
        this.handleRuleSetButtons(e);
        this.handleSettingsButtons(e);
        this.handleDatabaseButtons(e);
    }
}
