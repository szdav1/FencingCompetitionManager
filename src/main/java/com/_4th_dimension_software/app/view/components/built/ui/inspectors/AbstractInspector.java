package com._4th_dimension_software.app.view.components.built.ui.inspectors;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JLabel;

import com._4th_dimension_software.app.control.inspectors.AbstractInspectorController;
import com._4th_dimension_software.app.view.components.base.button.XButton;
import com._4th_dimension_software.app.view.components.base.label.XLabel;
import com._4th_dimension_software.app.view.components.base.panel.XPanel;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.consts.PositionConstants;

/**
 * The <code>AbstractInspector</code> abstract class defines the abstract
 * behaviour of inspectors inside the application. It holds an anonymous
 * instance of the <code>AbstractInspectorController</code> that takes
 * care of closing the editors.
 *
 * @author szd
 */
public abstract class AbstractInspector extends XPanel {
	// Parts of the inspector
	protected final XPanel headerPanel;
	protected final XPanel centerPanel;
	// Title label
	protected final XLabel titleLabel;
	// Close button
	protected final XButton closeButton;

	/**
	 * Defines the base constructor of inspectors. The base
	 * constructor initializes all UI elements of an inspector,
	 * and creates an anonymous instance of the <code>AbstractInspectorController</code>
	 * controller class. This controller handles the closing of inspectors.
	 *
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that's
	 *                       values should be implemented on this component
	 */
	protected AbstractInspector(final XFrame frame, String appearanceName) {
		super((SizeData.SCREEN_WIDTH/2)-(SizeData.EDITOR_WIDTH/2)-SizeData.SIDEBAR_WIDTH, (SizeData.SCREEN_HEIGHT/2)-(SizeData.EDITOR_HEIGHT/2),
			SizeData.EDITOR_WIDTH, SizeData.EDITOR_HEIGHT, new BorderLayout(), frame, appearanceName);

		// Parts of the editor
		this.headerPanel = new XPanel(new Dimension(this.getWidth(), SizeData.BUTTON_HEIGHT), new FlowLayout(FlowLayout.RIGHT, 0, 0), frame, appearanceName+".header");
		this.centerPanel = new XPanel(new Dimension(this.getWidth(), this.getHeight()-SizeData.BUTTON_HEIGHT), frame, appearanceName+".center");

		// Title label
		this.titleLabel = new XLabel(new Dimension(this.headerPanel.getWidth()-SizeData.N_BUTTON_WIDTH, SizeData.BUTTON_HEIGHT), "", frame, appearanceName+".title");
		this.titleLabel.setHorizontalAlignment(JLabel.LEFT);
		this.titleLabel.setMargin(new Insets(0, SizeData.TEXT_MARGIN, 0, 0));

		// Close button
		this.closeButton = new XButton(SizeData.N_BUTTON_DIMENSION, "x", frame, appearanceName+".buttons.close");

		// Instantiate an anonymous controller for the inspectors
		new AbstractInspectorController(this);

		// Add components to the header panel
		this.headerPanel.addComponent(this.titleLabel);
		this.headerPanel.addComponent(this.closeButton);

		// Add the parts of the editor top the display
		this.addComponent(this.headerPanel, PositionConstants.TOP_POSITION);
		this.addComponent(this.centerPanel, PositionConstants.CENTER_POSITION);
	}

	/**
	 * Sets the title of this editor object.
	 *
	 * @param title The title of this editor object
	 */
	protected void setTitle(String title) {
		this.titleLabel.setText(title);
	}

	public XButton getCloseButton() {
		return this.closeButton;
	}
}
