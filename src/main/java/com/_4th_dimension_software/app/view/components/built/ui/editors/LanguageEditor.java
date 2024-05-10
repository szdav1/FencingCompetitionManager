package com._4th_dimension_software.app.view.components.built.ui.editors;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.lang.LanguagePack;

public final class LanguageEditor extends AbstractEditor {
    public LanguageEditor(XFrame frame, String appearanceName) {
        super(frame, appearanceName);
        this.setTitle(LanguagePack.get("settingsEditor.languageEditorTitle"));
    }
}
