package com._4th_dimension_software.app.view.frame;

import javax.swing.JFrame;

import com._4th_dimension_software.app.view.components.interfaces.XContainer;
import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.framework.Appearance;
import com._4th_dimension_software.support.framework.Appearances;

public abstract class AbstractXFrame extends JFrame implements XContainer {
	protected Appearance appearance;

	protected AbstractXFrame(String title, String appearanceName) {
		this.appearance = Appearances.get(appearanceName);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(this.appearance.getIcon1() == null ? null : this.appearance.getIcon1().getImage());
		this.setTitle(title);
		this.setUndecorated(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(SizeData.SCREEN_WIDTH, SizeData.SCREEN_HEIGHT);
		this.setLocationRelativeTo(null);
	}
}
