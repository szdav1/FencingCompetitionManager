package com._4th_dimension_software.app.control.sidebar;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import com._4th_dimension_software.app.view.components.built.ui.sidebar.Sidebar;
import com._4th_dimension_software.support.consts.FrameState;

/**
 * The <code>SettingsMenuKeyActions</code> class contains
 * inner classes that are child classes of <code>swing</code>'s
 * <code>AbstractEvent</code> class. This class contains inner classes
 * responsible for handling the settings menu button's actions.
 */
public final class SettingsMenuKeyActions {
	private final Sidebar sidebar;

	/**
	 * Constructs a <code>SettingsMenuKeyActions</code> class.
	 * This class is responsible for handling shortcut keys
	 * related to the settings menu button's actions.
	 *
	 * @param sidebar The sidebar of the main frame of the application
	 */
	public SettingsMenuKeyActions(Sidebar sidebar) {
		this.sidebar = sidebar;

		// Assign the actions with the shortcut keys
		this.sidebar.getInputMap().put(KeyStroke.getKeyStroke("I"), "InterfaceKeyAction");
		this.sidebar.getActionMap().put("InterfaceKeyAction", new InterfaceKeyAction());

		this.sidebar.getInputMap().put(KeyStroke.getKeyStroke("L"), "LanguageKeyAction");
		this.sidebar.getActionMap().put("LanguageKeyAction", new LanguageKeyAction());
	}

	/**
	 * The <code>InterfaceKeyAction</code> handles the task of the
	 * interface button inside the settings menu buttons dropdown panel.
	 */
	public class InterfaceKeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (sidebar.getFrame().getFrameState() != FrameState.NORMAL)
				return;

			System.out.println("Interface Settings");
		}
	}

	/**
	 * The <code>LanguageKeyAction</code> handles the task of the
	 * language button inside the settings menu buttons dropdown panel.
	 */
	public class LanguageKeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (sidebar.getFrame().getFrameState() != FrameState.NORMAL)
				return;

			System.out.println("Language Settings");
		}
	}
}
