package com._4th_dimension_softwares.app.components.complex.menu;

import java.awt.Dimension;

import com._4th_dimension_softwares.app.components.base.button.ButtonType;
import com._4th_dimension_softwares.app.frame.XFrame;

public class MenuButton extends AbstractMenuButton {
	public MenuButton(Dimension dimension, String text, XFrame frame, ButtonType type, String appearanceName) {
		super(dimension, text, frame, type, appearanceName);
	}

	public MenuButton(Dimension dimension, XFrame frame, ButtonType type, String appearanceName) {
		super(dimension, frame, type, appearanceName);
	}

	public MenuButton(int x, int y, int width, int height, String text, XFrame frame, ButtonType type, String appearanceName) {
		super(x, y, width, height, text, frame, type, appearanceName);
	}

	public MenuButton(int x, int y, int width, int height, XFrame frame, ButtonType type, String appearanceName) {
		super(x, y, width, height, frame, type, appearanceName);
	}
}
