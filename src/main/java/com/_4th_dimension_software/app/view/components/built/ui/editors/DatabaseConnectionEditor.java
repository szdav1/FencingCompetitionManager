package com._4th_dimension_software.app.view.components.built.ui.editors;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.lang.Language;

/**
 * The <code>DatabaseConnectionEditor</code> class is a subclass
 * of the <code>AbstractEditor</code>. It contains UI
 * elements and handles actions related to database connection
 * management.
 *
 * @author szd
 */
public final class DatabaseConnectionEditor extends AbstractEditor {
	/**
	 * Constructs a <code>DatabaseConnectionEditor</code> object.
	 * This editor object is responsible for handling database connectivity.
	 *
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that should
	 *                       be implemented on this component
	 */
	public DatabaseConnectionEditor(final XFrame frame, String appearanceName) {
		super(frame, appearanceName);
		this.setTitle(Language.get("databaseConnectionEditor.title"));
	}
}
