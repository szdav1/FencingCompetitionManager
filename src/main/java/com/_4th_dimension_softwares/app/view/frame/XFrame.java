package com._4th_dimension_softwares.app.view.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import com._4th_dimension_softwares.app.view.components.base.panel.XPanel;
import com._4th_dimension_softwares.app.view.components.custom.ui.sidebar.Sidebar;
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
	// Sidebar
	private final Sidebar sidebar;
	// Center panel
	private final XPanel centerPanel;

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

		// Instantiate and add the frame part components
		// Sidebar
		this.sidebar = new Sidebar(this, "sidebar");
		// Center panel
		this.centerPanel = new XPanel(this.contentPanel.getPreferredSize(), null, this, appearanceName);

		// Background image
		this.setBackgroundImage();

		// Add frame part components
		this.addComponent(this.centerPanel, PositionConstants.CENTER_POSITION);

		// Set visibility
		this.setVisible(true);
	}

	/**
	 * Sets the background image of the frame.
	 * This image will only cover the center area of the
	 * frame. The image is the secondary mage contained in the frame's
	 * <code>Appearance</code>.
	 */
	private void setBackgroundImage() {
		if (this.appearance.getIcon2() != null) {
			JLabel l = new JLabel(new ImageIcon(this.appearance.getIcon2()
				.getImage()
				.getScaledInstance(this.centerPanel.getWidth(), this.centerPanel.getHeight(), Image.SCALE_SMOOTH)));

			l.setBounds(0, 0, this.centerPanel.getWidth(), this.centerPanel.getHeight());
			this.centerPanel.addComponent(l, PositionConstants.BACKGROUND_POSITION);
		}
	}

	/**
	 * Adds the specified component to the center panel of the frame
	 * placed on the desired Z coordinate specified by the position
	 * constant.
	 *
	 * @param component         The component that should be added to the center panel
	 * @param positionConstants The Z position on which the component should be placed
	 */
	public void addToCenterPanel(JComponent component, PositionConstants positionConstants) {
		this.centerPanel.addComponent(component, positionConstants);
	}

	/**
	 * Adds the specified component to the center panel of the frame
	 * placed on the desired Z coordinate specified by the position
	 * constant.
	 *
	 * @param component The component that should be added to the center panel
	 */
	public void addToCenterPanel(JComponent component) {
		this.addToCenterPanel(component, PositionConstants.MID_POSITION);
	}

	/**
	 * Removes and returns the desired component from the
	 * center panel of the frame.
	 *
	 * @param component The component that should be removed
	 * @return The removed component
	 */
	public JComponent removeFromCenterPanel(JComponent component) {
		return this.centerPanel.removeComponent(component);
	}

	@Override
	public void addComponent(final JComponent component, PositionConstants positionConstants) {
		this.contentPanel.addComponent(component, positionConstants);
	}

	@Override
	public void addComponent(final JComponent component) {
		this.contentPanel.addComponent(component);
	}

	@Override
	public JComponent removeComponent(final JComponent component) {
		return this.contentPanel.removeComponent(component);
	}
}
