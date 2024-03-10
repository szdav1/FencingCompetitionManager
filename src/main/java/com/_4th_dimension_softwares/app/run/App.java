package com._4th_dimension_softwares.app.run;

import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.framework.Appearances;
import com._4th_dimension_softwares.support.framework.interpreter.ColorThemeInterpreter;
import com._4th_dimension_softwares.support.util.Resources;

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
		ColorThemeInterpreter.interpretColorTheme(Resources.get("/themes/DarkTheme.xml"));
		this.frame = new XFrame("CompetitionManager 0.5-WORK-IN-PROGRESS", "window");
	}
}
