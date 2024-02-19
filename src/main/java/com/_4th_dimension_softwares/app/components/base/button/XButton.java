package com._4th_dimension_softwares.app.components.base.button;

import java.awt.Dimension;
import java.awt.event.MouseEvent;

import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.framework.Appearance;

public class XButton extends AbstractXButton {
	public XButton(Dimension dimension, String text, XFrame frame, ButtonType type, Appearance appearance) {
		super(dimension, text, frame, type, appearance);
	}

	public XButton(Dimension dimension, XFrame frame, ButtonType type, Appearance appearance) {
		super(dimension, frame, type, appearance);
	}

	public XButton(int x, int y, int width, int height, String text, XFrame frame, ButtonType type, Appearance appearance) {
		super(x, y, width, height, text, frame, type, appearance);
	}

	public XButton(int x, int y, int width, int height, XFrame frame, ButtonType type, Appearance appearance) {
		super(x, y, width, height, frame, type, appearance);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.pressed = true;
		this.paintComponent(this.getGraphics());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.pressed = false;
		this.paintComponent(this.getGraphics());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.entered = true;
		this.paintComponent(this.getGraphics());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.entered = false;
		this.paintComponent(this.getGraphics());
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
