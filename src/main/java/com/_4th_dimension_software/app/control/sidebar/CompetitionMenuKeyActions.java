package com._4th_dimension_software.app.control.sidebar;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import com._4th_dimension_software.app.view.components.built.ui.sidebar.Sidebar;

/**
 * The <code>CompetitionMenuKeyActions</code> class contains
 * inner classes that are child classes of <code>swing</code>'s
 * <code>AbstractEvent</code> class. This class contains inner classes
 * responsible for handling the competition menu button's actions.
 */
public final class CompetitionMenuKeyActions {
	private final Sidebar sidebar;

	/**
	 * Constructs a <code>CompetitionMenuKeyActions</code> class.
	 * This class is responsible for handling shortcut keys
	 * related to the competition menu button's actions.
	 *
	 * @param sidebar The sidebar of the main frame of the application
	 */
	public CompetitionMenuKeyActions(final Sidebar sidebar) {
		this.sidebar = sidebar;

		// Assign the actions with the shortcut keys
		this.sidebar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F7"), "EmptyCompetitionKeyAction");
		this.sidebar.getActionMap().put("EmptyCompetitionKeyAction", new EmptyCompetitionKeyAction());

		this.sidebar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F8"), "CompetitionFromDatabaseKeyAction");
		this.sidebar.getActionMap().put("CompetitionFromDatabaseKeyAction", new CompetitionFromDatabaseKeyAction());

		this.sidebar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F9"), "CompetitionStatsKeyAction");
		this.sidebar.getActionMap().put("CompetitionStatsKeyAction", new CompetitionStatsKeyAction());
	}

	/**
	 * The <code>EmptyCompetitionKeyAction</code> handles the task of the
	 * empty competition button inside the competition menu buttons dropdown panel.
	 */
	private class EmptyCompetitionKeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			sidebar.getFrame().openEmptyCompetitionEditor();
		}
	}

	/**
	 * The <code>CompetitionFromDatabaseKeyAction</code> handles the task of the
	 * competition from database button inside the competition menu buttons dropdown panel.
	 */
	private class CompetitionFromDatabaseKeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			sidebar.getFrame().openCompetitionFromDatabaseEditor();
		}
	}

	/**
	 * The <code>CompetitionStatsKeyAction</code> handles the task of the
	 * competition stats button inside the competition menu buttons dropdown panel.
	 */
	private class CompetitionStatsKeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			sidebar.getFrame().openCompetitionStatsInspector();
		}
	}
}
