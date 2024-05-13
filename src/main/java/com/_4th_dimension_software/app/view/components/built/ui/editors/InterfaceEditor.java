package com._4th_dimension_software.app.view.components.built.ui.editors;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.lang.LanguagePack;

/**
 * The <code>InterfaceEditor</code> class is a subclass
 * of the <code>AbstractEditor</code>. It contains UI
 * elements and handles actions related to interface settings.
 *
 * @author szd
 */
public final class InterfaceEditor extends AbstractEditor {
	/**
	 * Constructs an <code>InterfaceEditor</code> object.
	 * This editor object is responsible for handling
	 * interface settings.
	 *
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that should
	 *                       be implemented on this component
	 */
	public InterfaceEditor(final XFrame frame, String appearanceName) {
		super(frame, appearanceName);
		this.setTitle(LanguagePack.get("settingsEditor.interfaceEditorTitle"));
	}
}
