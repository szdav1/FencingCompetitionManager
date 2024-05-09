package com._4th_dimension_software.app.view.components.built.ui.editor;

import com._4th_dimension_software.app.view.frame.XFrame;

/**
 * The <code>RuleSetEditor</code> class is a subclass
 * of the <code>AbstractEditor</code>. It contains UI
 * elements and handles actions related to rule set
 * creation.
 *
 * @author szd
 */
public final class RuleSetEditor extends AbstractEditor {
	/**
	 * Constructs a <code>RuleSetEditor</code> object.
	 * This editor object is responsible for handling
	 * rule set creation.
	 *
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the appearance that should
	 *                       be implemented on this component
	 */
	public RuleSetEditor(XFrame frame, String appearanceName) {
		super(frame, appearanceName);
		this.setTitle("Rule Set Creator");
	}
}
