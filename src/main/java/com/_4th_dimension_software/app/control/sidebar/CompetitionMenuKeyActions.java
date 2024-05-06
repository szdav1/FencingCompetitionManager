package com._4th_dimension_software.app.control.sidebar;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import com._4th_dimension_software.app.view.components.built.ui.sidebar.Sidebar;
import com._4th_dimension_software.support.consts.FrameState;

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
	public CompetitionMenuKeyActions(Sidebar sidebar) {
		this.sidebar = sidebar;

		// Assign the actions with the shortcut keys
		this.sidebar.getInputMap().put(KeyStroke.getKeyStroke("F7"), "EmptyCompetitionKeyAction");
		this.sidebar.getActionMap().put("EmptyCompetitionKeyAction", new EmptyCompetitionKeyAction());

		this.sidebar.getInputMap().put(KeyStroke.getKeyStroke("F8"), "CompetitionFromDatabaseKeyAction");
		this.sidebar.getActionMap().put("CompetitionFromDatabaseKeyAction", new CompetitionFromDatabaseKeyAction());

		this.sidebar.getInputMap().put(KeyStroke.getKeyStroke("F9"), "CompetitionStatsKeyAction");
		this.sidebar.getActionMap().put("CompetitionStatsKeyAction", new CompetitionStatsKeyAction());
	}

	/**
	 * The <code>EmptyCompetitionKeyAction</code> handles the task of the
	 * empty competition button inside the competition menu buttons dropdown panel.
	 */
	public class EmptyCompetitionKeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (sidebar.getFrame().getFrameState() != FrameState.NORMAL)
				return;

			System.out.println("Empty Competition");
		}
	}

	/**
	 * The <code>CompetitionFromDatabaseKeyAction</code> handles the task of the
	 * competition from database button inside the competition menu buttons dropdown panel.
	 */
	public class CompetitionFromDatabaseKeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (sidebar.getFrame().getFrameState() != FrameState.NORMAL)
				return;

			System.out.println("Competition From Database");
		}
	}

	/**
	 * The <code>CompetitionStatsKeyAction</code> handles the task of the
	 * competition stats button inside the competition menu buttons dropdown panel.
	 */
	public class CompetitionStatsKeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (sidebar.getFrame().getFrameState() != FrameState.NORMAL)
				return;

			System.out.println("View Competition Stats");
		}
	}
}
