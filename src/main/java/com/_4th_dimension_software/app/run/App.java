package com._4th_dimension_software.app.run;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.framework.loader.ColorThemeLoader;
import com._4th_dimension_software.support.lang.loader.LanguagePackLoader;

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
		// Load the specified language XML file
		LanguagePackLoader.loadFromXML("/langs/English.xml");
		this.frame = new XFrame("CompetitionManager 0.5-WORK-IN-PROGRESS", "window");
	}
}
