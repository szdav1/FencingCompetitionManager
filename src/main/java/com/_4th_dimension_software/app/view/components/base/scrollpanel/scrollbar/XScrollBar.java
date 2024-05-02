package com._4th_dimension_software.app.view.components.base.scrollpanel.scrollbar;

import java.awt.Dimension;

import javax.swing.JScrollBar;

import com._4th_dimension_software.app.view.components.base.scrollpanel.scrollbar.ui.XScrollBarUI;
import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.theme.Appearance;
import com._4th_dimension_software.support.theme.Appearances;

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
public class XScrollBar extends JScrollBar {
	private Appearance appearance;

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
		this.appearance = Appearances.get(appearanceName);

		this.setBorder(null);
		this.setFocusable(false);
		this.setOrientation(orientation);
		this.setUI(new XScrollBarUI(appearanceName));
		this.setPreferredSize(dimension);
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
		this(orientation == JScrollBar.VERTICAL ?
			SizeData.V_SCROLL_BAR_DIMENSION :
			SizeData.H_SCROLL_BAR_DIMENSION, orientation, appearanceName);
	}

	public Appearance getAppearance() {
		return this.appearance;
	}
}
