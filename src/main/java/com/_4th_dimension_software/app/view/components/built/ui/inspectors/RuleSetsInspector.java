package com._4th_dimension_software.app.view.components.built.ui.inspectors;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.lang.LanguagePack;

public final class RuleSetsInspector extends AbstractInspector {
    public RuleSetsInspector(XFrame frame, String appearanceName) {
        super(frame, appearanceName);
        this.setTitle(LanguagePack.get("ruleSetEditor.viewRuleSetsInspectorTitle"));
    }
}
