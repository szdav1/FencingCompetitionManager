package com._4th_dimension_software.app.view.components.built.ui.inspectors;

import com._4th_dimension_software.app.view.frame.XFrame;

/**
 * The <code>PouleStatsInspector</code> class is a subclass
 * of the <code>AbstractInspector</code>. It contains UI
 * elements and handles actions related to poule statistics display.
 *
 * @author szd
 */
public final class PouleStatsInspector extends AbstractInspector {
	/**
	 * Constructs a <code>PouleStatsInspector</code> object.
	 * This editor object is responsible for handling
	 * poule statistics display.
	 *
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the appearance that should
	 *                       be implemented on this component
	 */
	public PouleStatsInspector(final XFrame frame, String appearanceName) {
		super(frame, appearanceName);
		this.setTitle("Poule Statistics");
	}
}
