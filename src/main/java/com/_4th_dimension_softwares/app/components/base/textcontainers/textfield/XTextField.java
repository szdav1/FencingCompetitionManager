package com._4th_dimension_softwares.app.components.base.textcontainers.textfield;

import java.awt.Dimension;

import javax.swing.JTextField;

import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.framework.Appearance;

public class XTextField extends AbstractXTextField {
	public XTextField(Dimension dimension, String text, XFrame frame, Appearance appearance) {
		super(dimension, text, frame, appearance);
	}

	public XTextField(Dimension dimension, XFrame frame, Appearance appearance) {
		super(dimension, frame, appearance);
	}

	public XTextField(int x, int y, int width, int height, String text, XFrame frame, Appearance appearance) {
		super(x, y, width, height, text, frame, appearance);
	}

	public XTextField(int x, int y, int width, int height, XFrame frame, Appearance appearance) {
		super(x, y, width, height, frame, appearance);
	}

	public void centerContent() {
		this.setHorizontalAlignment(JTextField.CENTER);
	}

	@Override
	public XFrame getFrame() {
		return this.frame;
	}

	@Override
	public void repaintFrame() {
		if (this.frame != null)
			this.frame.repaint();
	}

	@Override
	public Appearance getAppearance() {
		return this.appearance;
	}
}
