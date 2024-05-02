package com._4th_dimension_software.app.view.components.interfaces;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.theme.Appearance;

/**
 * The <code>XComponent</code> interface specifies default methods
 * that every component used in the application must implement.
 * Basically, every component inside the application is an
 * <code>XComponent</code>.
 *
 * @author szd
 */
public interface XComponent {
	/**
	 * Returns the main frame of the application.
	 *
	 * @return The main frame of the Application
	 */
	XFrame getFrame();

	/**
	 * Repaints the main frame if it's not null.
	 */
	void repaintFrame();

	/**
	 * Returns the Appearance of the component.
	 *
	 * @return The Appearance of the component
	 */
	Appearance getAppearance();
}
