package com._4th_dimension_software.app.view.components.built.ui.inspectors;

import com._4th_dimension_software.app.view.components.built.ui.editors.AbstractEditor;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.lang.Language;

/**
 * The <code>TableStatsInspector</code> class is a subclass
 * of the <code>AbstractInspector</code>. It contains UI
 * elements and handles actions related to table statistics display.
 *
 * @author szd
 */
public final class TableStatsInspector extends AbstractEditor {
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
		this.removeComponent(this.footerPanel);
		this.setTitle(Language.get("tableStatsInspector.title"));
	}
}
