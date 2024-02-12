package com._4th_dimension_softwares.app.run;

import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.framework.interpreter.ColorThemeInterpreter;

/**
 * Entry point of the application
 *
 * @author szd
 */
public final class App {
	/**
	 * Initializes the application and runs it.
	 * This is the entry point of the application.
	 */
	public App() {
		final String colorThemeFilePath = this.getClass()
			.getResource("/themes/darkTheme.xml")
			.getFile();

		ColorThemeInterpreter.interpretColorTheme(colorThemeFilePath);
		new XFrame(null, "CompetitionManager 0.5-WORK-IN-PROGRESS");
	}
}
