package com._4th_dimension_software.app.control.editors;

import com._4th_dimension_software.app.control.AbstractXController;
import com._4th_dimension_software.app.view.components.built.ui.editors.AbstractEditor;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;

/**
 * The <code>AbstractEditorController</code> is the class that handles actions that happened inside editors using
 * a <code>MouseListener</code>, <code>MouseMotionListener</code>, an <code>ActionListener</code>
 * and the <code>KeyListener</code> interfaces. This controller class only handles closing of the editors by
 * both key and mouse actions.
 * <p></p>
 * The <code>AbstractEditorController</code> handles the close action of editors only. This controller
 * is instantiated inside the <code>AbstractEditor</code> class hence its name.
 *
 * @author szd
 */
public final class AbstractEditorController extends AbstractXController {
    private final AbstractEditor abstractEditor;

    /**
     * Constructs an <code>AbstractEditorController</code> object.
     * This object is responsible for handling actions inside editors.
     * Mainly, this controller object handles the closing of editors.
     *
     * @param abstractEditor The <code>AbstractEditor</code> object that should
     *                       implement this controller
     */
    public AbstractEditorController(final AbstractEditor abstractEditor) {
        this.abstractEditor = abstractEditor;
        // Implement the necessary key bindings
        this.abstractEditor.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "CloseKeyAction");
        this.abstractEditor.getActionMap().put("CloseKeyAction", new CloseKeyAction());
        this.abstractEditor.getCloseButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.abstractEditor.getCloseButton().equals(e.getSource()))
            this.abstractEditor.getFrame().removeDisplayingPanel();
    }

    /**
     * The <code>CloseKeyAction</code> handles the closing of
     * the currently opened panel by calling the main frame's
     * <code>removeDisplayingPanel()</code>. This way it
     * is not a requirement to keep track of which editor is
     * currently opened, it will close the most recently added
     * panel.
     */
    private class CloseKeyAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            abstractEditor.getFrame().removeDisplayingPanel();
        }
    }
}
