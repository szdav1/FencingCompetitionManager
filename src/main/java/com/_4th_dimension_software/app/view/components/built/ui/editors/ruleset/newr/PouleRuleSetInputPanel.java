package com._4th_dimension_software.app.view.components.built.ui.editors.ruleset.newr;

import java.util.HashMap;

import com._4th_dimension_software.app.view.components.built.ui.editors.AbstractEditorInputPanel;
import com._4th_dimension_software.app.view.frame.XFrame;

/**
 * The <code>PouleRuleSetInputPanel</code> class is a subclass
 * of the <code>AbstractEditorInputPanel</code> and an inner
 * panel for the <code>NewRuleSetEditor</code> class, that holds the
 * necessary UI elements for poule rules.
 */
public final class PouleRuleSetInputPanel extends AbstractEditorInputPanel {
	/**
	 * Constructs a <code>PouleRuleSetInputPanel</code> object. This
	 * object is used as an inner container for the <code>NewRuleSetEditor</code>.
	 *
	 * @param title          The title of the input panel
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that's values
	 *                       should be implemented on this component
	 */
	public PouleRuleSetInputPanel(String title, final XFrame frame, String appearanceName) {
		super(title, frame, appearanceName);
	}

	@Override
	public HashMap<String, String> getData() {
		return null;
	}
}
