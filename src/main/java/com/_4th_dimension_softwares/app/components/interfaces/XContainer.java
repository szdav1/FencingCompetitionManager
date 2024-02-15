package com._4th_dimension_softwares.app.components.interfaces;

import javax.swing.JComponent;

import com._4th_dimension_softwares.support.consts.PositionConstants;

/**
 * The <code>XContainer</code> interface is used to make a
 * component a functional container. This interface
 * provides methods for the class that implements it
 * which handle adding and removing components from.
 *
 * @author szd
 */
public interface XContainer {
	/**
	 * Puts the specified component on the scene.
	 * The position constant is used to determine the
	 * Z coordinate of the component.
	 *
	 * @param component         The component that should be added to the scene
	 * @param positionConstants The Z position on which the component should be placed
	 */
	void addComponent(JComponent component, PositionConstants positionConstants);

	/**
	 * Puts the specified component on the scene.
	 * The Z coordinate of the component is going
	 * to be MID (5) be default.
	 *
	 * @param component The component that should be added to the scene
	 */
	void addComponent(JComponent component);

	/**
	 * Removes the specified component from the scene
	 * and returns it.
	 *
	 * @param component The component that should be removed from the scene
	 * @return The component that was removed from the scene
	 */
	JComponent removeComponent(JComponent component);
}
