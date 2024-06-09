package com._4th_dimension_software.app.control.sidebar.key;

import com._4th_dimension_software.app.view.components.built.ui.sidebar.Sidebar;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;

/**
 * The <code>RuleSetMenuKeyActions</code> class contains
 * inner classes that are child classes of <code>swing</code>'s
 * <code>AbstractEvent</code> class. This class contains inner classes
 * responsible for handling the rule set menu button's key actions.
 */
public final class RuleSetMenuKeyActions {
    private final Sidebar sidebar;

    /**
     * Constructs a <code>RuleSetMenuKeyActions</code> class.
     * This class is responsible for handling shortcut keys
     * related to the rule set menu button's key actions.
     *
     * @param sidebar The sidebar of the main frame of the application
     */
    public RuleSetMenuKeyActions(final Sidebar sidebar) {
        this.sidebar = sidebar;

        // Implement the necessary key bindings
        this.sidebar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("V"), "ViewRuleSetsKeyAction");
        this.sidebar.getActionMap().put("ViewRuleSetsKeyAction", new ViewRuleSetsKeyAction());

        this.sidebar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("N"), "NewRuleSetKeyAction");
        this.sidebar.getActionMap().put("NewRuleSetKeyAction", new NewRuleSetKeyAction());

        this.sidebar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "DeleteRuleSetKeyAction");
        this.sidebar.getActionMap().put("DeleteRuleSetKeyAction", new DeleteRuleSetKeyAction());

        this.sidebar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("M"), "ModifyRuleSetKeyAction");
        this.sidebar.getActionMap().put("ModifyRuleSetKeyAction", new ModifyRuleSetKeyAction());
    }

    /**
     * The <code>ViewRuleSetsKeyAction</code> handles the task of the
     * view rule sets button inside the rule sets menu button's dropdown panel.
     */
    private class ViewRuleSetsKeyAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            sidebar.getFrame().openRuleSetInspector();
        }
    }

    /**
     * The <code>NewRuleSetKeyAction</code> handles the task of the
     * new rule set button inside the rule sets menu button's dropdown panel.
     */
    private class NewRuleSetKeyAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            sidebar.getFrame().openNewRuleSetEditor();
        }
    }

    /**
     * The <code>DeleteRuleSetKeyAction</code> handles the task of the
     * delete set button inside the rule sets menu button's dropdown panel.
     */
    private class DeleteRuleSetKeyAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            sidebar.getFrame().openRuleSetDeleter();
        }
    }

    /**
     * The <code>ModifyRuleSetKeyAction</code> handles the task of the
     * modify rule set button inside the rule sets menu button's dropdown panel.
     */
    private class ModifyRuleSetKeyAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            sidebar.getFrame().openRuleSetModifier();
        }
    }
}
