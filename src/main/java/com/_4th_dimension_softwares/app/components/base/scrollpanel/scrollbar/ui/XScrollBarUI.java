package com._4th_dimension_softwares.app.components.base.scrollpanel.scrollbar.ui;

import com._4th_dimension_softwares.support.framework.Appearance;

/**
 * The <code>XScrollBarUI</code> class is an extended representation
 * of Swing's <code>BasicScrollBarUI</code> class. It works similarly to
 * <code>BasicScrollBarUI</code>.
 * <p></p>
 * The extended means that just by passing in an Appearance
 * object to the constructor, this panel will be stylized
 * according to that Appearance. This saves the work with
 * Graphics and Graphics2D and makes creating beautiful
 * container panels easy and fast.
 * <p></p>
 * The <code>paintTrack()</code> method is fully overridden
 * from the super class to make it work with <code>Appearance</code>s.
 * <p></p>
 * The <code>paintThumb()</code> method is also fully overridden
 * from the superclass to make it work with <code>Appearance</code>s.
 * <p></p>
 * Important
 * <p>For painting the track: <code>VALUE_RENDER_QUALITY</code></p>
 * <p>For painting the thumb: <code>VALUE_RENDER_QUALITY</code></p>
 *
 * @author szd
 */
public class XScrollBarUI extends AbstractXScrollBarUI {
	/**
	 * Constructs an <code>XScrollBarUI</code> object. This object is
	 * similar to a <code>BasicScrollBarUI</code> object, only this is much
	 * easier to customize using an Appearance object.
	 *
	 * @param appearance The Appearance that's values should be
	 *                   implemented on this scroll bar UI
	 */
	public XScrollBarUI(Appearance appearance) {
		super(appearance);
	}
}
