package com._4th_dimension_software.app.view.components.built.ui.editors.poule;

import com._4th_dimension_software.app.view.components.built.ui.editors.AbstractEditor;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.lang.Language;

/**
 * The <code>EmptyPouleEditor</code> class is a subclass
 * of the <code>AbstractEditor</code>. It contains UI
 * elements and handles actions related to poule creation
 * without resources.
 *
 * @author szd
 */
public final class EmptyPouleEditor extends AbstractEditor {
	/**
	 * Constructs a <code>EmptyPouleEditor</code> object.
	 * This editor object is responsible for handling
	 * poule creation without resources.
	 *
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that should
	 *                       be implemented on this component
	 */
	public EmptyPouleEditor(final XFrame frame, String appearanceName) {
		super(frame, appearanceName);
		this.setTitle(Language.get("emptyPouleEditor.title"));
	}
}
