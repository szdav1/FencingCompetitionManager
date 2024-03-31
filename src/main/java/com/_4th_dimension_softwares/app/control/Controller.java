package com._4th_dimension_softwares.app.control;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * The <code>Controller</code> class is a child class
 * of the <code>AbstractController</code> class that
 * implements the
 * <p><code>ActionListener</code></p>
 * <p><code>KeyListener</code></p>
 * <p><code>MouseListener</code></p>
 * <code>MouseMotionListener</code> interfaces. This
 * class overrides the necessary methods from these interfaces
 * and leaves them empty. This way controller classes that extend
 * this class only has to override methods that are necessary for
 * them to function. This helps to make the controller classes'
 * code more transparent and makes later works or maintenance
 * easier. Although key bindings are used to create keyboard shortcuts,
 * every controller class has access to the <code>KeyListener</code>.
 * This is because if something is required to be done only when the
 * component is focused, the <code>KeyListener</code> interface is the
 * perfect solution.
 */
public class Controller extends AbstractController {
	// ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
	}

	// KeyListener
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	// MouseListener
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	// MouseMotionListener
	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}
