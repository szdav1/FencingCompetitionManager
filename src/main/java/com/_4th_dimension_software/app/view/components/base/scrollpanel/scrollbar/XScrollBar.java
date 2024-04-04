package com._4th_dimension_software.app.view.components.base.scrollpanel.scrollbar;

import java.awt.Dimension;

/**
 * The <code>XScrollBar</code> class is an extended representation
 * of Swing's <code>JScrollBar</code> class. It works similarly to
 * <code>JScrollBar</code>.
 * <p></p>
 * The extended means that just by passing in an Appearance
 * object to the constructor, this panel will be stylized
 * according to that Appearance. This saves the work with
 * Graphics and Graphics2D and makes creating beautiful
 * container panels easy and fast.
 *
 * @author szd
 */
public class XScrollBar extends AbstractXScrollBar {
	/**
	 * Constructs an <code>XScrollBar</code> object. This object is
	 * similar to a <code>JScrollBar</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param dimension      The dimension of the scroll bar
	 * @param orientation    the orientation of the scroll bar (<code>JScrollBar.HORIZONTAL</code>, <code>JScrollBar.VERTICAL</code>)
	 * @param appearanceName The name of the Appearance that's values should be
	 *                       implemented on this scrollbar
	 */
	public XScrollBar(Dimension dimension, int orientation, String appearanceName) {
		super(dimension, orientation, appearanceName);
	}

	/**
	 * Constructs an <code>XScrollBar</code> object. This object is
	 * similar to a <code>JScrollBar</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param orientation    the orientation of the scroll bar (<code>JScrollBar.HORIZONTAL</code>, <code>JScrollBar.VERTICAL</code>)
	 * @param appearanceName The name of the Appearance that's values should be
	 *                       implemented on this scrollbar
	 */
	public XScrollBar(int orientation, String appearanceName) {
		super(orientation, appearanceName);
	}
}
