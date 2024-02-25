package com._4th_dimension_softwares.app.run;

import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.framework.Appearances;
import com._4th_dimension_softwares.support.framework.interpreter.ColorThemeInterpreter;
import com._4th_dimension_softwares.support.util.Resources;

/*
* TODO: Make the Appearances class's get() method return a
*  default Appearance if the specified key is incorrect
*
* TODO: Create the XTextArea class and the XScrollPanel class
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
		// Interpret the specified color theme and open the application window
		ColorThemeInterpreter.interpretColorTheme(Resources.get("/themes/DarkTheme.xml"));
		XFrame frame = new XFrame("CompetitionManager 0.5-WORK-IN-PROGRESS", Appearances.get("window"));
	}
}
