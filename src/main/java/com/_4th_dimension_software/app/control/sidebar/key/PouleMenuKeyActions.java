package com._4th_dimension_software.app.control.sidebar.key;

import com._4th_dimension_software.app.view.components.built.ui.sidebar.Sidebar;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;

/**
 * The <code>PouleMenuKeyActions</code> class contains
 * inner classes that are child classes of <code>swing</code>'s
 * <code>AbstractEvent</code> class. This class contains inner classes
 * responsible for handling the poule menu button's key actions.
 */
public final class PouleMenuKeyActions {
    private final Sidebar sidebar;

    /**
     * Constructs a <code>PouleMenuKeyActions</code> class.
     * This class is responsible for handling shortcut keys
     * related to the poule menu button's key actions.
     *
     * @param sidebar The sidebar of the main frame of the application
     */
    public PouleMenuKeyActions(final Sidebar sidebar) {
        this.sidebar = sidebar;

        // Implement the necessary key bindings
        this.sidebar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "EmptyPouleKeyAction");
        this.sidebar.getActionMap().put("EmptyPouleKeyAction", new EmptyPouleKeyAction());

        this.sidebar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F2"), "PouleFromDatabaseKeyAction");
        this.sidebar.getActionMap().put("PouleFromDatabaseKeyAction", new PouleFromDatabaseKeyAction());

        this.sidebar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F3"), "PouleStatsKeyAction");
        this.sidebar.getActionMap().put("PouleStatsKeyAction", new PouleStatsKeyAction());
    }

    /**
     * The <code>EmptyPouleKeyAction</code> handles the task of the
     * empty poule button inside the poule menu button's dropdown panel.
     */
    private class EmptyPouleKeyAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            sidebar.getFrame().openEmptyPouleEditor();
        }
    }

    /**
     * The <code>PouleFromDatabaseKeyAction</code> handles the task of the
     * poule from database button inside the poule menu button's dropdown panel.
     */
    private class PouleFromDatabaseKeyAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            sidebar.getFrame().openPouleFromDatabaseEditor();
        }
    }

    /**
     * The <code>PouleStatsKeyAction</code> handles the task of the
     * poule stats button inside the poule menu button's dropdown panel.
     */
    private class PouleStatsKeyAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            sidebar.getFrame().openPouleStatsInspector();
        }
    }
}
