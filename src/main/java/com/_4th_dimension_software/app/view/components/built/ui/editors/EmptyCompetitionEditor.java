package com._4th_dimension_software.app.view.components.built.ui.editors;

import com._4th_dimension_software.app.view.frame.XFrame;

/**
 * The <code>CompetitionEditor</code> class is a subclass
 * of the <code>AbstractEditor</code>. It contains UI
 * elements and handles actions related to competition
 * creation with empty resources.
 *
 * @author szd
 */
public final class EmptyCompetitionEditor extends AbstractEditor {
	/**
	 * Constructs a <code>CompetitionEditor</code> object.
	 * This editor object is responsible for handling
	 * competition creation with empty resources.
	 *
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the appearance that should
	 *                       be implemented on this component
	 */
	public EmptyCompetitionEditor(final XFrame frame, String appearanceName) {
		super(frame, appearanceName);
		this.setTitle("Competition Editor: Empty");
	}
}
