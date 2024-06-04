package com._4th_dimension_software.app.run;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.lang.loader.LanguagePackLoader;
import com._4th_dimension_software.support.settings.Settings;
import com._4th_dimension_software.support.settings.loader.SettingsLoader;
import com._4th_dimension_software.support.theme.loader.ColorThemeLoader;
import com._4th_dimension_software.support.theme.reader.NewColorThemeReader;

/**
 * The <code>App</code> class is the entry point of
 * the application. This class is responsible for instantiating
 * the main frame of the application.
 *
 * @author szd
 */
public final class App {
//	private final XFrame frame;

	/**
	 * Initializes the application and runs it.
	 * This is the entry point of the application.
	 */
	public App() {
//		// Read the settings file
//		SettingsLoader.loadFromXML("/settings/Settings.xml");
//		// Interpret the specified color theme and open the application window
//		ColorThemeLoader.loadFromXML(Settings.get("colorTheme"));
//		// Load the specified language XML file
//		LanguagePackLoader.loadFromXML(Settings.get("language"));
//
//		// Open application window
//		this.frame = new XFrame("CompetitionManager 0.5-WORK-IN-PROGRESS", "window");

		NewColorThemeReader.readFromXML("/themes/DarkRedTheme.xml");
	}
}
