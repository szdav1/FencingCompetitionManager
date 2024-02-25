package com._4th_dimension_softwares.app.frame;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.JComponent;

import com._4th_dimension_softwares.app.components.base.panel.XPanel;
import com._4th_dimension_softwares.support.consts.PositionConstants;
import com._4th_dimension_softwares.support.framework.Appearance;
import com._4th_dimension_softwares.support.framework.Appearances;

/**
 * The <code>XFrame</code> is the main frame of the application. Everything
 * that takes place on the screen is handled by this class
 * in order to avoid conflicts with positions and components.
 * Every component takes care of its own task, but it is this
 * <code>XFrame</code> class that will conduct the displaying and removing of
 * those components. Main components like editors can not be
 * displayed when another editor is opened or the user is doing
 * something else that might interrupt the displaying process.
 *
 * @author szd
 */
public class XFrame extends AbstractXFrame {
	private final XPanel contentPanel;

	/**
	 * Constructs an <code>XFrame</code> object. This object is
	 * the conductor of the actions in the application.
	 *
	 * @param title      The title of the application window
	 * @param appearance The <code>Appearance</code> that is going to
	 *                   be used to stylize the window
	 */
	public XFrame(String title, Appearance appearance) {
		// Basic setup for the window
		super(title, appearance);

		this.contentPanel = new XPanel(0, 0, this.getWidth(), this.getHeight(), new BorderLayout(), this, appearance);
		this.setContentPane(this.contentPanel);
	}

	@Override
	public void addComponent(JComponent component, PositionConstants positionConstants) {
		this.contentPanel.addComponent(component, positionConstants);
		this.repaint();
	}

	@Override
	public void addComponent(JComponent component) {
		this.contentPanel.addComponent(component);
		this.repaint();
	}

	@Override
	public JComponent removeComponent(JComponent component) {
		this.contentPanel.removeComponent(component);
		this.repaint();

		return component;
	}
}
