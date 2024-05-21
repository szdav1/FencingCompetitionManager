package com._4th_dimension_software.app.view.components.built.ui.editors;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JLabel;

import com._4th_dimension_software.app.view.components.base.label.XLabel;
import com._4th_dimension_software.app.view.components.built.panels.expandable.ExpandablePanel;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.consts.PositionConstants;

public abstract class AbstractEditorInputPanel extends ExpandablePanel {
	protected final XLabel titleLabel;

	public AbstractEditorInputPanel(String title, final XFrame frame, String appearanceName) {
		super(new Dimension(SizeData.EDITOR_INNER_PANEL_WIDTH, SizeData.EDITOR_INNER_PANEL_HEIGHT), frame, appearanceName);

		this.titleLabel = new XLabel(0, 0, SizeData.W_BUTTON_WIDTH, SizeData.BUTTON_HEIGHT, title, frame, appearanceName+".title");
		this.titleLabel.setHorizontalAlignment(JLabel.LEFT);
		this.titleLabel.setMargin(new Insets(0, SizeData.TEXT_MARGIN, 0, 0));

		this.headerPanel.addComponent(this.titleLabel, PositionConstants.TOP_POSITION);
	}

	public AbstractEditorInputPanel(int x, int y, String title, final XFrame frame, String appearanceName) {
		super(x, y, SizeData.EDITOR_INNER_PANEL_WIDTH, SizeData.EDITOR_INNER_PANEL_HEIGHT, frame, appearanceName);

		this.titleLabel = new XLabel(0, 0, SizeData.W_BUTTON_WIDTH, SizeData.BUTTON_HEIGHT, title, frame, appearanceName+".title");
		this.titleLabel.setHorizontalAlignment(JLabel.LEFT);
		this.titleLabel.setMargin(new Insets(0, SizeData.TEXT_MARGIN, 0, 0));

		this.headerPanel.addComponent(this.titleLabel, PositionConstants.TOP_POSITION);
	}
}
