package com._4th_dimension_software.app.view.components.built.ui.separator;

import com._4th_dimension_software.app.view.components.base.label.XLabel;

import java.awt.Dimension;

/**
 * The <code>Separator</code> class is a subclass
 * of the <code>XLabel</code> class. It only fulfills
 * visual tasks thus has no functionality at all.
 *
 * @author szd
 */
public final class Separator extends XLabel {
    /**
     * Constructs a <code>Separator</code> object.
     *
     * @param dimension      The Dimension of the separator
     * @param appearanceName The name of the <code>Appearance</code> that's
     *                       values should be implemented on this separator
     */
    public Separator(Dimension dimension, String appearanceName) {
        super(dimension, "", null, appearanceName);
    }
}
