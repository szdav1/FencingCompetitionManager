package com._4th_dimension_software.app.view.components.built.ui.editors;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.lang.LanguagePack;

public final class RuleSetDeleter extends AbstractEditor{
    public RuleSetDeleter(XFrame frame, String appearanceName) {
        super(frame, appearanceName);
        this.setTitle(LanguagePack.get("ruleSetEditor.deleteRuleSetEditorTitle"));
    }
}
