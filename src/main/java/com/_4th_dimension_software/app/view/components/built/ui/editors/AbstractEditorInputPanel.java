package com._4th_dimension_software.app.view.components.built.ui.editors;

import java.awt.Dimension;
import java.awt.Insets;
import java.util.HashMap;

import javax.swing.JLabel;

import com._4th_dimension_software.app.view.components.base.label.XLabel;
import com._4th_dimension_software.app.view.components.built.panels.expandable.ExpandablePanel;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.consts.PositionConstants;

/**
 * The <code>AbstractEditorInputPanel</code> is an abstract class
 * that defines the abstract behaviour of input panels used inside the
 * editors.
 */
public abstract class AbstractEditorInputPanel extends ExpandablePanel {
	protected final XLabel titleLabel;

	/**
	 * Defines the abstract constructor for input panels used in
	 * the editors.
	 *
	 * @param title          The title of the input panel
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that's
	 *                       values should be implemented on this component
	 */
	protected AbstractEditorInputPanel(String title, final XFrame frame, String appearanceName) {
		super(new Dimension(SizeData.EDITOR_INNER_PANEL_WIDTH, SizeData.EDITOR_INNER_PANEL_HEIGHT), frame, appearanceName);

		this.titleLabel = new XLabel(0, 0, SizeData.W_BUTTON_WIDTH, SizeData.BUTTON_HEIGHT, title, frame, appearanceName+".title");
		this.titleLabel.setHorizontalAlignment(JLabel.LEFT);
		this.titleLabel.setMargin(new Insets(0, SizeData.TEXT_MARGIN, 0, 0));

		this.headerPanel.addComponent(this.titleLabel, PositionConstants.TOP_POSITION);
	}

	/**
	 * Defines the abstract constructor for input panels used in
	 * the editors in no-layout manager space.
	 *
	 * @param x              The X coordinate of the panel in no-layout manager space
	 * @param y              The Y coordinate of the panel in no-layout manager space
	 * @param title          The title of the input panel
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that's
	 *                       values should be implemented on this component
	 */
	protected AbstractEditorInputPanel(int x, int y, String title, final XFrame frame, String appearanceName) {
		super(x, y, SizeData.EDITOR_INNER_PANEL_WIDTH, SizeData.EDITOR_INNER_PANEL_HEIGHT, frame, appearanceName);

		this.titleLabel = new XLabel(0, 0, SizeData.W_BUTTON_WIDTH, SizeData.BUTTON_HEIGHT, title, frame, appearanceName+".title");
		this.titleLabel.setHorizontalAlignment(JLabel.LEFT);
		this.titleLabel.setMargin(new Insets(0, SizeData.TEXT_MARGIN, 0, 0));

		this.headerPanel.addComponent(this.titleLabel, PositionConstants.TOP_POSITION);
	}

	/**
	 * Retrieves every data that from the inputs
	 * inside this input panel. Data returned by this method
	 * have been already validated.
	 *
	 * @return The validated data pack
	 */
	public abstract HashMap<String, String> getData();
}
