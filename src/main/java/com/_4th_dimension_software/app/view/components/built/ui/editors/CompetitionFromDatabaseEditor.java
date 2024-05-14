package com._4th_dimension_software.app.view.components.built.ui.editors;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.lang.LanguagePack;

/**
 * The <code>CompetitionFromDatabaseEditor</code> class is a subclass
 * of the <code>AbstractEditor</code>. It contains UI
 * elements and handles actions related to competition creation
 * from database.
 *
 * @author szd
 */
public final class CompetitionFromDatabaseEditor extends AbstractEditor {
	/**
	 * Constructs a <code>CompetitionFromDatabaseEditor</code> object.
	 * This editor object is responsible for handling
	 * competition creation from database.
	 *
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that should
	 *                       be implemented on this component
	 */
	public CompetitionFromDatabaseEditor(final XFrame frame, String appearanceName) {
		super(frame, appearanceName);
		this.setTitle(LanguagePack.get("competitionFromDatabaseEditor.title"));
	}
}