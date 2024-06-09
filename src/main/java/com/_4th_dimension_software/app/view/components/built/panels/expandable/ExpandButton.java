package com._4th_dimension_software.app.view.components.built.panels.expandable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com._4th_dimension_software.app.view.components.base.button.XButton;
import com._4th_dimension_software.app.view.frame.XFrame;

/**
 * The <code>ExpandButton</code> class is a package private
 * subclass of the <code>XButton</code> custom class. It is used
 * to handle expand and fold functionality of <code>ExpandablePanel</code>s.
 */
final class ExpandButton extends XButton implements ActionListener {
	private boolean expanded;

	/**
	 * Constructs an <code>ExpandButton</code> object. This object is
	 * used to handle expand and fold functionality of the <code>ExpandablePanel</code>s.
	 *
	 * @param x              The X coordinate of the button in no-layout manager space
	 * @param y              The Y coordinate of the button in no-layout manager space
	 * @param width          The width of the button in no-layout manager space
	 * @param height         The height of the button in no-layout manager space
	 * @param text           The text of the button
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that's values
	 *                       should be implemented on this component
	 */
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
