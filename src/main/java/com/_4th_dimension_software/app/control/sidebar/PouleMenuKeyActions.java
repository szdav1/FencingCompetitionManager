package com._4th_dimension_software.app.control.sidebar;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import com._4th_dimension_software.app.view.components.built.ui.sidebar.Sidebar;
import com._4th_dimension_software.support.consts.FrameState;

/**
 * The <code>PouleMenuKeyActions</code> class contains
 * inner classes that are child classes of <code>swing</code>'s
 * <code>AbstractEvent</code> class. This class contains inner classes
 * responsible for handling the poule menu button's actions.
 */
public final class PouleMenuKeyActions {
	private final Sidebar sidebar;

	/**
	 * Constructs a <code>PouleMenuKeyActions</code> class.
	 * This class is responsible for handling shortcut keys
	 * related to the poule menu button's actions.
	 *
	 * @param sidebar The sidebar of the main frame of the application
	 */
	public PouleMenuKeyActions(Sidebar sidebar) {
		this.sidebar = sidebar;

		// Assign the actions with the shortcut keys
		this.sidebar.getInputMap().put(KeyStroke.getKeyStroke("F1"), "EmptyPouleKeyAction");
		this.sidebar.getActionMap().put("EmptyPouleKeyAction", new EmptyPouleKeyAction());

		this.sidebar.getInputMap().put(KeyStroke.getKeyStroke("F2"), "PouleFromDatabaseKeyAction");
		this.sidebar.getActionMap().put("PouleFromDatabaseKeyAction", new PouleFromDatabaseKeyAction());

		this.sidebar.getInputMap().put(KeyStroke.getKeyStroke("F3"), "PouleStatsKeyAction");
		this.sidebar.getActionMap().put("PouleStatsKeyAction", new PouleStatsKeyAction());
	}

	/**
	 * The <code>EmptyPouleKeyAction</code> handles the task of the
	 * empty poule button inside the poule menu buttons dropdown panel.
	 */
	public class EmptyPouleKeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (sidebar.getFrame().getFrameState() != FrameState.NORMAL)
				return;

			System.out.println("Empty Poule");
		}
	}

	/**
	 * The <code>PouleFromDatabaseKeyAction</code> handles the task of the
	 * poule from database button inside the poule menu buttons dropdown panel.
	 */
	public class PouleFromDatabaseKeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (sidebar.getFrame().getFrameState() != FrameState.NORMAL)
				return;

			System.out.println("Poule From Database");
		}
	}

	/**
	 * The <code>PouleStatsKeyAction</code> handles the task of the
	 * poule stats button inside the poule menu buttons dropdown panel.
	 */
	public class PouleStatsKeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (sidebar.getFrame().getFrameState() != FrameState.NORMAL)
				return;

			System.out.println("View Poule Stats");
		}
	}
}
