package com._4th_dimension_software.app.control.sidebar;

import com._4th_dimension_software.app.view.components.built.ui.sidebar.Sidebar;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;

/**
 * The <code>SidebarKeyActions</code> class contains
 * inner classes that are child classes of <code>swing</code>'s
 * <code>AbstractEvent</code> class. These classes are kept for
 * handling shortcut key actions in the frame, when the state of
 * the frame is <code>NORMAL</code>.
 */
public final class SidebarKeyActions {
    private final Sidebar sidebar;

    /**
     * Constructs a <code>SidebarKeyActions</code> class.
     * This class takes care of handling the shortcut key
     * actions that happen inside the main frame of application
     * when its state is <code>NORMAL</code> and nothing is opened.
     *
     * @param sidebar The sidebar of the main frame of the application
     */
    public SidebarKeyActions(final Sidebar sidebar) {
        this.sidebar = sidebar;

        // Implement the necessary key bindings
        this.sidebar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "ExitKeyAction");
        this.sidebar.getActionMap().put("ExitKeyAction", new ExitKeyAction());
    }

    /**
     * The <code>ExitKeyAction</code> handles the task of the
     * exit button inside the sidebar.
     */
    private class ExitKeyAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            sidebar.getFrame().exit();
        }
    }
}
