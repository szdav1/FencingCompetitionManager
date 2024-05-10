package com._4th_dimension_software.app.control.sidebar;

import com._4th_dimension_software.app.view.components.built.ui.sidebar.Sidebar;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;

/**
 * The <code>SettingsMenuKeyActions</code> class contains
 * inner classes that are child classes of <code>swing</code>'s
 * <code>AbstractEvent</code> class. This class contains inner classes
 * responsible for handling the settings menu button's key actions.
 */
public final class SettingsMenuKeyActions {
    private final Sidebar sidebar;

    /**
     * Constructs a <code>SettingsMenuKeyActions</code> class.
     * This class is responsible for handling shortcut keys
     * related to the settings menu button's key actions.
     *
     * @param sidebar The sidebar of the main frame of the application
     */
    public SettingsMenuKeyActions(final Sidebar sidebar) {
        this.sidebar = sidebar;

        // Implement the necessary key bindings
        this.sidebar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("I"), "InterfaceKeyAction");
        this.sidebar.getActionMap().put("InterfaceKeyAction", new InterfaceKeyAction());

        this.sidebar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("L"), "LanguageKeyAction");
        this.sidebar.getActionMap().put("LanguageKeyAction", new LanguageKeyAction());
    }

    /**
     * The <code>InterfaceKeyAction</code> handles the task of the
     * interface button inside the settings menu button's dropdown panel.
     */
    private class InterfaceKeyAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            sidebar.getFrame().openInterfaceEditor();
        }
    }

    /**
     * The <code>LanguageKeyAction</code> handles the task of the
     * language button inside the settings menu button's dropdown panel.
     */
    private class LanguageKeyAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            sidebar.getFrame().openLanguageEditor();
        }
    }
}
