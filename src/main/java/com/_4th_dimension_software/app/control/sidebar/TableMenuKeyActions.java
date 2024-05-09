package com._4th_dimension_software.app.control.sidebar;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import com._4th_dimension_software.app.view.components.built.ui.sidebar.Sidebar;
import com._4th_dimension_software.support.consts.FrameState;

/**
 * The <code>TableMenuKeyActions</code> class contains
 * inner classes that are child classes of <code>swing</code>'s
 * <code>AbstractEvent</code> class. This class contains inner classes
 * responsible for handling the table menu button's actions.
 */
public final class TableMenuKeyActions {
	private final Sidebar sidebar;

	/**
	 * Constructs a <code>TableMenuKeyActions</code> class.
	 * This class is responsible for handling shortcut keys
	 * related to the table menu button's actions.
	 *
	 * @param sidebar The sidebar of the main frame of the application
	 */
	public TableMenuKeyActions(Sidebar sidebar) {
		this.sidebar = sidebar;

		// Assign the actions with the shortcut keys
		this.sidebar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F4"), "EmptyTableKeyAction");
		this.sidebar.getActionMap().put("EmptyTableKeyAction", new EmptyTableKeyAction());

		this.sidebar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F5"), "TableFromDatabaseKeyAction");
		this.sidebar.getActionMap().put("TableFromDatabaseKeyAction", new TableFromDatabaseKeyAction());

		this.sidebar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F6"), "TableStatsKeyAction");
		this.sidebar.getActionMap().put("TableStatsKeyAction", new TableStatsKeyAction());
	}

	/**
	 * The <code>EmptyTableKeyAction</code> handles the task of the
	 * empty table button inside the table menu buttons dropdown panel.
	 */
	private class EmptyTableKeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			sidebar.getFrame().openEmptyTableEditor();
		}
	}

	/**
	 * The <code>TableFromDatabaseKeyAction</code> handles the task of the
	 * table from database button inside the table menu buttons dropdown panel.
	 */
	private class TableFromDatabaseKeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			sidebar.getFrame().openTableFromDatabaseEditor();
		}
	}

	/**
	 * The <code>TableStatsKeyAction</code> handles the task of the
	 * table stats button inside the table menu buttons dropdown panel.
	 */
	private class TableStatsKeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			sidebar.getFrame().openTableStatsInspector();
		}
	}
}
