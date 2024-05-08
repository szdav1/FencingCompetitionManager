package com._4th_dimension_software.app.view.components.built.ui.editor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import com._4th_dimension_software.app.control.editor.AbstractEditorController;
import com._4th_dimension_software.app.view.components.base.button.XButton;
import com._4th_dimension_software.app.view.components.base.panel.XPanel;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.consts.PositionConstants;

public abstract class AbstractEditor extends XPanel {
	// Parts of the editor
	protected final XPanel headerPanel;
	protected final XPanel centerPanel;
	// Close button
	protected final XButton closeButton;

	protected AbstractEditor(XFrame frame, String appearanceName) {
		super(SizeData.SCREEN_WIDTH/4-SizeData.W_BUTTON_WIDTH, SizeData.SCREEN_HEIGHT/4, SizeData.SCREEN_WIDTH/2, SizeData.SCREEN_HEIGHT/2, new BorderLayout(), frame, appearanceName);

		// Parts of the editor
		this.headerPanel = new XPanel(new Dimension(this.getWidth(), SizeData.BUTTON_HEIGHT), new FlowLayout(FlowLayout.RIGHT, 0, 0), frame, appearanceName+".header");
		this.centerPanel = new XPanel(new Dimension(this.getWidth(), this.getHeight()-SizeData.BUTTON_HEIGHT), frame, appearanceName+".center");
		// Close button
		this.closeButton = new XButton(SizeData.N_BUTTON_DIMENSION, "x", frame, appearanceName+".buttons.close");

		// Instantiate an anonymous controller for the editors
		new AbstractEditorController(this);

		// Add components to the header panel
		this.headerPanel.addComponent(this.closeButton);

		// Add the parts of the editor top the display
		this.addComponent(this.headerPanel, PositionConstants.TOP_POSITION);
		this.addComponent(this.centerPanel, PositionConstants.CENTER_POSITION);
	}

	public XButton getCloseButton() {
		return this.closeButton;
	}
}
