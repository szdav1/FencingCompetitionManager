package com._4th_dimension_softwares.app.frame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JFrame;

import com._4th_dimension_softwares.app.components.interfaces.XContainer;
import com._4th_dimension_softwares.support.appdata.SizeData;

public abstract class AbstractXFrame extends JFrame implements XContainer {
	protected AbstractXFrame(Image iconImage, String title) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(iconImage);
		this.setTitle(title);
		this.setUndecorated(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setBounds(new Rectangle(0, 0, SizeData.SCREEN_WIDTH, SizeData.SCREEN_HEIGHT));
		this.setVisible(true);
	}
}
