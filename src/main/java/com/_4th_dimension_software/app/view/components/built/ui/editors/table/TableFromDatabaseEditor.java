package com._4th_dimension_software.app.view.components.built.ui.editors.table;

import com._4th_dimension_software.app.view.components.built.ui.editors.AbstractEditor;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.lang.Language;

/**
 * The <code>TableFromDatabaseEditor</code> class is a subclass
 * of the <code>AbstractEditor</code>. It contains UI
 * elements and handles actions related to table creation
 * from database.
 *
 * @author szd
 */
public final class TableFromDatabaseEditor extends AbstractEditor {
	/**
	 * Constructs a <code>TableFromDatabaseEditor</code> object.
	 * This editor object is responsible for handling
	 * table creation from database.
	 *
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that should
	 *                       be implemented on this component
	 */
	public TableFromDatabaseEditor(final XFrame frame, String appearanceName) {
		super(frame, appearanceName);
		this.setTitle(Language.get("tableFromDatabaseEditor.title"));
	}
}
