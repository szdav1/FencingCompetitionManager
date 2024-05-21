package com._4th_dimension_software.app.view.components.built.panels.expandable;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com._4th_dimension_software.app.view.components.base.button.XButton;
import com._4th_dimension_software.app.view.frame.XFrame;

final class ExpandButton extends XButton implements ActionListener {
	private boolean expanded;

	public ExpandButton(Dimension dimension, String text, String shortcutKeyText, final XFrame frame, String appearanceName) {
		super(dimension, text, shortcutKeyText, frame, appearanceName);
		this.addActionListener(this);

		this.expanded = false;
	}

	public ExpandButton(Dimension dimension, String text, final XFrame frame, String appearanceName) {
		super(dimension, text, frame, appearanceName);
		this.addActionListener(this);

		this.expanded = false;
	}

	public ExpandButton(int x, int y, int width, int height, String text, String shortcutKeyText, final XFrame frame, String appearanceName) {
		super(x, y, width, height, text, shortcutKeyText, frame, appearanceName);
		this.addActionListener(this);

		this.expanded = false;
	}

	public ExpandButton(int x, int y, int width, int height, String text, final XFrame frame, String appearanceName) {
		super(x, y, width, height, text, frame, appearanceName);
		this.addActionListener(this);

		this.expanded = false;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
		this.repaint();
	}

	@Override
	public void paintIcon() {
		if (this.appearance.getIcon1() != null && this.appearance.getIcon2() != null && this.appearance.getIcon3() != null && this.appearance.getIcon4() != null) {
			if (!this.expanded) {
				this.setIcon(this.entered ? this.appearance.getIcon4() : this.appearance.getIcon3());
				this.setIcon(this.pressed ? this.appearance.getIcon3() : this.appearance.getIcon4());
			}
			else {
				this.setIcon(this.entered ? this.appearance.getIcon2() : this.appearance.getIcon1());
				this.setIcon(this.pressed ? this.appearance.getIcon1() : this.appearance.getIcon2());
			}

			if (!this.entered && !this.pressed && this.expanded)
				this.setIcon(this.appearance.getIcon1());

			else if (!this.entered && !this.pressed)
				this.setIcon(this.appearance.getIcon3());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.equals(e.getSource())) {
			this.expanded = !this.expanded;
			this.repaint();
		}
	}
}
