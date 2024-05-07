package com._4th_dimension_software.support.settings;

import java.util.HashMap;

/**
 * The <code>Settings</code> class stores
 * information about the application's preferred settings
 * like color theme or language. These settings are string
 * representation of the path of the XMLs.
 *
 * @author szd
 */
public final class Settings {
    private static boolean initialized = false;
    private static HashMap<String, String> settings;

    // Not instantiatable
    private Settings() {
    }

    /**
     * Initializes the <code>Settings</code> class.
     * If it has been already initialized, a <code>RuntimeException</code>
     * is thrown.
     *
     * @param settings A <code>HashMap</code> that stores the settings
     */
    public static void init(HashMap<String, String> settings) {
        if (initialized)
            throw new RuntimeException("Settings has been already initialized");

        Settings.settings = settings;
        initialized = true;
    }

    /**
     * Retrieves the appropriate String
     * representation of the specified file that
     * stores application information.
     *
     * @param settingsKey The key that's in pair with the desired setting
     * @return The path of the desired settings file
     */
    public static String get(String settingsKey) {
        return settings.get(settingsKey);
    }
}
