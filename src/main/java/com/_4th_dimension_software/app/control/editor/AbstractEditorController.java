package com._4th_dimension_software.app.control.editor;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import com._4th_dimension_software.app.control.XController;
import com._4th_dimension_software.app.view.components.built.ui.editor.AbstractEditor;

/**
 * The <code>AbstractEditorController</code> is the class that handles actions that happened inside editors using
 * a <code>MouseListener</code>, <code>MouseMotionListener</code>. <code>ActionListener</code>
 * and <code>KeyListener</code> interfaces. This controller class only handles closing of the editors by
 * both key and mouse actions.
 *
 * @author szd
 */
public final class AbstractEditorController extends XController {
	private final AbstractEditor abstractEditor;

	/**
	 * Constructs a <code>AbstractEditorController</code> object.
	 * This object is responsible for handling actions inside editors.
	 *
	 * @param abstractEditor The <code>AbstractEditor</code> object that should
	 *                       implement this controller
	 */
	public AbstractEditorController(final AbstractEditor abstractEditor) {
		this.abstractEditor = abstractEditor;
		this.abstractEditor.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "CloseKeyAction");
		this.abstractEditor.getActionMap().put("CloseKeyAction", new CloseKeyAction());
		this.abstractEditor.getCloseButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.abstractEditor.getCloseButton()))
			this.abstractEditor.getFrame().closeCurrentlyOpenedEditor();
	}

	/**
	 * The <code>CloseKeyAction</code> handles the closing of
	 * the currently opened editor by calling the main frame's
	 * <code>closeCurrentlyOpenedEditor()</code>. This way it
	 * is not a requirement to keep track of which editor is
	 * currently opened, it will close it anyways.
	 */
	private class CloseKeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			abstractEditor.getFrame().closeCurrentlyOpenedEditor();
		}
	}
}
