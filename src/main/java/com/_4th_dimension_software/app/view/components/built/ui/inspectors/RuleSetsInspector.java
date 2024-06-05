package com._4th_dimension_software.app.view.components.built.ui.inspectors;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.lang.Language;

/**
 * The <code>RuleSetsInspector</code> class is a subclass
 * of the <code>AbstractInspector</code>. It contains UI
 * elements and handles actions related to rule set display.
 *
 * @author szd
 */
public final class RuleSetsInspector extends AbstractInspector {
    /**
     * Constructs a <code>RuleSetsInspector</code> object.
     * This inspector object is responsible for handling
     * rule set display.
     *
     * @param frame          The main frame of the application
     * @param appearanceName The name of the Appearance that should
     *                       be implemented on this component
     */
    public RuleSetsInspector(final XFrame frame, String appearanceName) {
        super(frame, appearanceName);
        this.setTitle(Language.get("ruleSetInspector.title"));
    }
}
