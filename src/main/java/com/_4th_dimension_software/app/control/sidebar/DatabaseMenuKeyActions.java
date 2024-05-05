package com._4th_dimension_software.app.control.sidebar;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import com._4th_dimension_software.app.view.components.specific.ui.sidebar.Sidebar;
import com._4th_dimension_software.support.consts.FrameState;

/**
 * The <code>DatabaseMenuKeyActions</code> class contains
 * inner classes that are child classes of <code>swing</code>'s
 * <code>AbstractEvent</code> class. This class contains inner classes
 * responsible for handling the database menu button's actions.
 */
public final class DatabaseMenuKeyActions {
	private final Sidebar sidebar;

	/**
	 * Constructs a <code>DatabaseMenuKeyActions</code> class.
	 * This class is responsible for handling shortcut keys
	 * related to the database menu button's actions.
	 *
	 * @param sidebar The sidebar of the main frame of the application
	 */
	public DatabaseMenuKeyActions(Sidebar sidebar) {
		this.sidebar = sidebar;

		// Assign the actions with the shortcut keys
		this.sidebar.getInputMap().put(KeyStroke.getKeyStroke("C"), "ConnectKeyAction");
		this.sidebar.getActionMap().put("ConnectKeyAction", new ConnectKeyAction());

		this.sidebar.getInputMap().put(KeyStroke.getKeyStroke("A"), "ArrangeKeyAction");
		this.sidebar.getActionMap().put("ArrangeKeyAction", new ArrangeKeyAction());
	}

	/**
	 * The <code>ConnectKeyAction</code> handles the task of the
	 * connect button inside the database menu buttons dropdown panel.
	 */
	public class ConnectKeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (sidebar.getFrame().getFrameState() != FrameState.NORMAL)
				return;

			System.out.println("Connect To Database");
		}
	}

	/**
	 * The <code>ArrangeKeyAction</code> handles the task of the
	 * arrange button inside the database menu buttons dropdown panel.
	 */
	public class ArrangeKeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (sidebar.getFrame().getFrameState() != FrameState.NORMAL)
				return;

			System.out.println("Arrange Database");
		}
	}
}
