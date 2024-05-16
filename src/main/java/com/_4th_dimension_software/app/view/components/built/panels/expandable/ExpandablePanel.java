package com._4th_dimension_software.app.view.components.built.panels.expandable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com._4th_dimension_software.app.view.components.base.button.XButton;
import com._4th_dimension_software.app.view.components.base.panel.XPanel;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.consts.PositionConstants;

public class ExpandablePanel extends XPanel implements ActionListener {
	private boolean expanded;
	private final Dimension dimension;
	private final XPanel headerPanel;
	private final XPanel centerPanel;
	private final ExpandButton expandButton;

	public ExpandablePanel(Dimension dimension, final XFrame frame, String appearanceName) {
		super(dimension, new BorderLayout(), frame, appearanceName);

		this.expanded = false;
		this.dimension = dimension;

		this.headerPanel = new XPanel(new Dimension(this.getWidth(), SizeData.BUTTON_HEIGHT), null, frame, appearanceName+".panel");
		this.centerPanel = new XPanel(new Dimension(this.getWidth(), this.getHeight()-SizeData.BUTTON_HEIGHT), frame, appearanceName+".panel");

		this.expandButton = new ExpandButton(this.getWidth()-SizeData.N_BUTTON_WIDTH, 0, SizeData.N_BUTTON_WIDTH, SizeData.BUTTON_HEIGHT, "", frame, appearanceName+".button");
		this.expandButton.addActionListener(this);

	}

	public ExpandablePanel(int x, int y, int width, int height, final XFrame frame, String appearanceName) {
		super(x, y, width, height, new BorderLayout(), frame, appearanceName);

		this.expanded = false;
		this.dimension = new Dimension(width, height);

		this.headerPanel = new XPanel(new Dimension(this.getWidth(), SizeData.BUTTON_HEIGHT), null, frame, appearanceName+".panel");
		this.centerPanel = new XPanel(new Dimension(this.getWidth(), this.getHeight()-SizeData.BUTTON_HEIGHT), frame, appearanceName+".panel");

		this.expandButton = new ExpandButton(this.getWidth()-SizeData.N_BUTTON_WIDTH, 0, SizeData.N_BUTTON_WIDTH, SizeData.BUTTON_HEIGHT, "", frame, appearanceName+".button");
		this.expandButton.addActionListener(this);

		this.headerPanel.addComponent(this.expandButton);

		this.addComponent(this.headerPanel, PositionConstants.TOP_POSITION);
		this.addComponent(this.centerPanel, PositionConstants.CENTER_POSITION);

	}

	public void expand() {
		this.setSize(this.dimension.width, this.dimension.height);
		this.setPreferredSize(this.dimension);
		this.repaintFrame();
	}

	public void fold() {
		this.setSize(this.dimension.width, SizeData.BUTTON_HEIGHT);
		this.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		this.repaintFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.expandButton.equals(e.getSource())) {
			this.expanded = !this.expanded;

			if (this.expanded)
				this.fold();

			else
				this.expand();
		}
	}
}