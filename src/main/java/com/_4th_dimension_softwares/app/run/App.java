package com._4th_dimension_softwares.app.run;

import com._4th_dimension_softwares.app.view.frame.XFrame;
import com._4th_dimension_softwares.support.framework.loader.ColorThemeLoader;

/**
 * Entry point of the application
 *
 * @author szd
 */
public final class App {
	private final XFrame frame;

	/**
	 * Initializes the application and runs it.
	 * This is the entry point of the application.
	 */
	public App() {
		// Interpret the specified color theme and open the application window
		ColorThemeLoader.loadFromXML("/themes/DarkTheme.xml");
		this.frame = new XFrame("CompetitionManager 0.5-WORK-IN-PROGRESS", "window");
	}
}
