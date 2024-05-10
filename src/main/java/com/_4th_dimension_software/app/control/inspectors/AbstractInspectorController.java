package com._4th_dimension_software.app.control.inspectors;

import com._4th_dimension_software.app.control.AbstractXController;
import com._4th_dimension_software.app.view.components.built.ui.inspectors.AbstractInspector;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;

/**
 * The <code>AbstractInspectorController</code> is the class that handles actions that happened inside inspectors using
 * the <code>MouseListener</code>, the <code>MouseMotionListener</code>, the <code>ActionListener</code>
 * and the <code>KeyListener</code> interfaces. This controller class only handles closing of the inspectors by
 * both key and mouse actions.
 * <p></p>
 * The <code>AbstractInspectorController</code> handles the close action of inspectors only. This controller
 * is instantiated inside the <code>AbstractInspector</code> class hence its name.
 *
 * @author szd
 */
public final class AbstractInspectorController extends AbstractXController {
    private final AbstractInspector abstractInspector;

    /**
     * Constructs an <code>AbstractInspectorController</code> object.
     * This object is responsible for handling actions inside inspectors.
     * Mainly, this controller object handles the closing of inspectors.
     *
     * @param abstractInspector The <code>AbstractInspector</code> object that should
     *                          implement this controller
     */
    public AbstractInspectorController(final AbstractInspector abstractInspector) {
        this.abstractInspector = abstractInspector;
        // Implement the necessary  keybindings
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
     * currently opened, it will close the most recently added
     * panel.
     */
    private class CloseKeyAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            abstractInspector.getFrame().removeDisplayingPanel();
        }
    }
}
