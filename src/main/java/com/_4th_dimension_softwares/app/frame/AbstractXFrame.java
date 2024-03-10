package com._4th_dimension_softwares.app.frame;

import java.awt.Rectangle;

import javax.swing.JFrame;

import com._4th_dimension_softwares.app.components.interfaces.XContainer;
import com._4th_dimension_softwares.support.appdata.SizeData;
import com._4th_dimension_softwares.support.framework.Appearance;
import com._4th_dimension_softwares.support.framework.Appearances;

public abstract class AbstractXFrame extends JFrame implements XContainer {
	protected Appearance appearance;

	protected AbstractXFrame(String title, String appearanceName) {
		this.appearance = Appearances.get(appearanceName);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(this.appearance.getIcon1() == null ? null : this.appearance.getIcon1().getImage());
		this.setTitle(title);
		this.setUndecorated(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setBounds(new Rectangle(0, 0, SizeData.SCREEN_WIDTH, SizeData.SCREEN_HEIGHT));
		this.setVisible(true);
	}
}
