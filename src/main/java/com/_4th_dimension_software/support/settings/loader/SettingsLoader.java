package com._4th_dimension_software.support.settings.loader;

import com._4th_dimension_software.support.settings.Settings;
import com._4th_dimension_software.support.settings.reader.SettingsReader;

/**
 * The <code>SettingsLoader</code> class loads
 * the contents of the Settings.xml file and
 * initializes the <code>Settings</code> class.
 */
public final class SettingsLoader {
    // Not instantiatable
    private SettingsLoader() {
    }

    /**
     * Loads the specified XML file into the <code>Settings</code>
     * class.
     *
     * @param filePath The path of the desired XML file
     */
    public static void loadFromXML(final String filePath) {
        Settings.init(SettingsReader.readFromXML(filePath));
    }
}
