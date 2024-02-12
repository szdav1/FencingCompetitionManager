package com._4th_dimension_softwares.app.components.interfaces;

import com._4th_dimension_softwares.app.frame.XFrame;
import com._4th_dimension_softwares.support.framework.Appearance;

/**
 * The <code>XComponent</code> interface specifies default methods
 * that every component used in the application must implement.
 * Basically, every component inside the application is an
 * <code>XComponent</code>.
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
	 * Returns tha Appearance of the component.
	 *
	 * @return The Appearance of the component
	 */
	Appearance getAppearance();
}
