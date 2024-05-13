package com._4th_dimension_software.app.view.components.built.ui.inspectors;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.lang.LanguagePack;

/**
 * The <code>TableStatsInspector</code> class is a subclass
 * of the <code>AbstractInspector</code>. It contains UI
 * elements and handles actions related to table statistics display.
 *
 * @author szd
 */
public final class TableStatsInspector extends AbstractInspector {
	/**
	 * Constructs a <code>TableStatsInspector</code> object.
	 * This inspector object is responsible for handling
	 * table statistics display.
	 *
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that should
	 *                       be implemented on this component
	 */
	public TableStatsInspector(final XFrame frame, String appearanceName) {
		super(frame, appearanceName);
		this.setTitle(LanguagePack.get("tableStatsInspector.title"));
	}
}
