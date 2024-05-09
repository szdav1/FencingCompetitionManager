package com._4th_dimension_software.app.view.components.built.ui.sidebar.menu;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import com._4th_dimension_software.app.view.components.base.button.XButton;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.appdata.SizeData;

public abstract class AbstractMenuButton extends XButton implements ActionListener {
	protected boolean active;
	protected DropdownPanel dropdownPanel;

	protected AbstractMenuButton(Dimension dimension, String text, final XFrame frame, String appearanceName) {
		super(dimension, text, frame, appearanceName);

		this.setHorizontalAlignment(SwingConstants.LEFT);
		this.setVerticalAlignment(SwingConstants.CENTER);
		this.setMargin(new Insets(0, SizeData.TEXT_MARGIN, 0, 0));

		this.active = false;
		this.dropdownPanel = new DropdownPanel(0, 0, this.getWidth(), SizeData.DROPDOWN_HEIGHT, frame, appearanceName+".dropdown");
	}

	protected AbstractMenuButton(Dimension dimension, final XFrame frame, String appearanceName) {
		this(dimension, "", frame, appearanceName);
	}

	protected AbstractMenuButton(int x, int y, int width, int height, String text, final XFrame frame, String appearanceName) {
		super(x, y, width, height, text, frame, appearanceName);

		this.setHorizontalAlignment(SwingConstants.LEFT);
		this.setVerticalAlignment(SwingConstants.CENTER);
		this.setMargin(new Insets(0, SizeData.TEXT_MARGIN, 0, 0));

		this.active = false;
		this.dropdownPanel = new DropdownPanel(0, 0, this.getWidth(), SizeData.DROPDOWN_HEIGHT, frame, appearanceName+".dropdown");
	}

	protected AbstractMenuButton(int x, int y, int width, int height, final XFrame frame, String appearanceName) {
		this(x, y, width, height, "", frame, appearanceName);
	}
}
