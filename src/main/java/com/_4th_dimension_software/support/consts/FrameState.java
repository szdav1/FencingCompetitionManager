package com._4th_dimension_software.support.consts;

/**
 * The <code>FrameState</code> enum contains
 * values that define certain conditions of the main
 * frame of the application. These values can be used
 * to perform state specific tasks.
 *
 * @author szd
 */
public enum FrameState {
    /**
     * Defines the normal state of the frame.
     * This is set when nothing is opened.
     */
    NORMAL("normal"),
    /**
     * Defines the state of the main frame
     * when the poule editor is opened.
     */
    POULE_EDITOR_OPENED("poule editor opened"),
    /**
     * Defines the state of the main frame
     * when the poule stats inspector is opened.
     */
    POULE_STATS_INSPECTOR_OPENED("poule stats inspector opened"),
    /**
     * Defines the state of the main frame
     * when the table editor is opened.
     */
    TABLE_EDITOR_OPENED("table editor opened"),
    /**
     * Defines the state of the main frame
     * when the table stats inspector is opened.
     */
    TABLE_STATS_INSPECTOR_OPENED("table stats inspector opened"),
    /**
     * Defines the state of the main frame
     * when the competition editor is opened.
     */
    COMPETITION_EDITOR_OPENED("competition editor opened"),
    /**
     * Defines the state of the main frame
     * when the competition stats inspector is opened.
     */
    COMPETITION_STATS_INSPECTOR_OPENED("competition stats inspector opened"),
    /**
     * Defines the state of the main frame
     * when the rule set editor is opened.
     */
    RULE_SET_EDITOR_OPENED("rule set editor opened"),
    /**
     * Defines the state of the main frame
     * when the rule set inspector is opened.
     */
    RULE_SET_INSPECTOR_OPENED("rule set inspector opened"),
    /**
     * Defines the state of the main frame
     * when the settings editor is opened.
     */
    SETTINGS_EDITOR_OPENED("settings editor opened"),
    /**
     * Defines the state of the main frame
     * when the database editor is opened.
     */
    DATABASE_EDITOR_OPENED("database editor opened"),

    /**
     * Defines the state when a panel is
     * opened inside the frame.
     */
    PANEL_OPENED("panel opened");

    private final String state;

    FrameState(final String state) {
        this.state = state;
    }

    /**
     * Returns the string representation of the
     * desired <code>FrameState</code> constant.
     *
     * @return The <code>String</code> assigned to the desired enum value
     */
    public String state() {
        return this.state;
    }
}
