package com._4th_dimension_softwares.app.run;

import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.framework.interpreter.ColorThemeInterpreter;

/*
*  TODOS
* -=====-
*
* TODO: Make the appropriate constructor for the App class
* TODO: Check for errors
* TODO: Check for missing docstrings
* TODO: Create the run configurations for the test classes
*
* */

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
		ColorThemeInterpreter.interpretColorTheme(this.getClass().getResource("/themes/darkTheme.xml").getFile());

		new XFrame(null, "CompetitionManager 0.5-WORK-IN-PROGRESS");
	}
}
