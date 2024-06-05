package com._4th_dimension_software.app.view.components.built.ui.editors;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.lang.Language;

/**
 * The <code>EmptyTableEditor</code> class is a subclass
 * of the <code>AbstractEditor</code>. It contains UI
 * elements and handles actions related to creating tables
 * with empty resources.
 *
 * @author szd
 */
public final class EmptyTableEditor extends AbstractEditor {
	/**
	 * Constructs a <code>EmptyTableEditor</code> object.
	 * This editor object is responsible for handling
	 * table creation with empty resources.
	 *
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that should
	 *                       be implemented on this component
	 */
	public EmptyTableEditor(final XFrame frame, String appearanceName) {
		super(frame, appearanceName);
		this.setTitle(Language.get("emptyTableEditor.title"));
	}
}
