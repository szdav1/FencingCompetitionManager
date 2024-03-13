package com._4th_dimension_softwares.app.frame;

import java.awt.*;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import com._4th_dimension_softwares.app.components.base.panel.XPanel;
import com._4th_dimension_softwares.app.components.complex.ui.sidebar.Sidebar;
import com._4th_dimension_softwares.support.consts.PositionConstants;

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
	// Content panel
	private final XPanel contentPanel;
	// Frame parts
	private final Sidebar sidebar;

	/**
	 * Constructs an <code>XFrame</code> object. This object is
	 * the conductor of the actions in the application.
	 *
	 * @param title          The title of the application window
	 * @param appearanceName The name of the <code>Appearance</code> that is going to
	 *                       be used to stylize the window
	 */
	public XFrame(String title, String appearanceName) {
		// Basic setup for the window
		super(title, appearanceName);

		// Instantiate and set the content panel
		this.contentPanel = new XPanel(new Dimension(this.getWidth(), this.getHeight()), new BorderLayout(), this, appearanceName);
		this.setContentPane(this.contentPanel);

		XPanel x = new XPanel(new Dimension(50, 50), this, "test");

		// Instantiate and add the frame part components
		// Sidebar
		this.sidebar = new Sidebar(this, "sidebar");
	}

	@Override
	public void addComponent(JComponent component, PositionConstants positionConstants) {
		this.contentPanel.addComponent(component, positionConstants);
	}

	@Override
	public void addComponent(JComponent component) {
		this.contentPanel.addComponent(component);
	}

	@Override
	public JComponent removeComponent(JComponent component) {
		this.contentPanel.removeComponent(component);

		return component;
	}
}
