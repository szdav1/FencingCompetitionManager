package com._4th_dimension_software.app.control.inspectors;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import com._4th_dimension_software.app.control.AbstractXController;
import com._4th_dimension_software.app.view.components.built.ui.inspectors.AbstractInspector;

/**
 * The <code>AbstractInspectorController</code> is the class that handles actions that happened inside inspectors using
 * a <code>MouseListener</code>, <code>MouseMotionListener</code>. <code>ActionListener</code>
 * and <code>KeyListener</code> interfaces. This controller class only handles closing of the inspectors by
 * both key and mouse actions.
 * <p></p>
 * The <code>AbstractInspectorController</code> handles the close action of editors. This controller
 * is instantiated inside the <code>AbstractInspector</code> class hence its name.
 *
 * @author szd
 */
public final class AbstractInspectorController extends AbstractXController {
	private final AbstractInspector abstractInspector;

	/**
	 * Constructs a <code>AbstractInspectorController</code> object.
	 * This object is responsible for handling actions inside inspectors.
	 *
	 * @param abstractInspector The <code>AbstractInspector</code> object that should
	 *                          implement this controller
	 */
	public AbstractInspectorController(final AbstractInspector abstractInspector) {
		this.abstractInspector = abstractInspector;
		this.abstractInspector.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "CloseKeyAction");
		this.abstractInspector.getActionMap().put("CloseKeyAction", new CloseKeyAction());
		this.abstractInspector.getCloseButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.abstractInspector.getCloseButton().equals(e.getSource()))
			this.abstractInspector.getFrame().removeDisplayingPanel();
	}

	/**
	 * The <code>CloseKeyAction</code> handles the closing of
	 * the currently opened inspector by calling the main frame's
	 * <code>removeDisplayingPanel()</code>. This way it
	 * is not a requirement to keep track of which inspector is
	 * currently opened, it will close it anyway.
	 */
	private class CloseKeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			abstractInspector.getFrame().removeDisplayingPanel();
		}
	}
}
