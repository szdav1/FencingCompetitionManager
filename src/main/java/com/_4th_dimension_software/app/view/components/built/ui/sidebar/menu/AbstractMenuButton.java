package com._4th_dimension_software.app.view.components.built.ui.sidebar.menu;

import com._4th_dimension_software.app.view.components.base.button.XButton;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.appdata.SizeData;

import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionListener;

/**
 * The <code>AbstractMenuButton</code> abstract class defines the abstract
 * behaviour of menu buttons inside the application.
 *
 * @author szd
 */
public abstract class AbstractMenuButton extends XButton implements ActionListener {
    protected boolean active;
    protected DropdownPanel dropdownPanel;

    /**
     * Defines the constructor of menu buttons that
     * initializes every field of the class.
     *
     * @param dimension      The dimension of the menu button
     * @param text           The text of the menu button
     * @param frame          The main frame of the application
     * @param appearanceName The name of the <code>Appearance</code> that's
     *                       values should be implemented on this component
     */
    protected AbstractMenuButton(Dimension dimension, String text, final XFrame frame, String appearanceName) {
        super(dimension, text, frame, appearanceName);

        this.setHorizontalAlignment(SwingConstants.LEFT);
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.setMargin(new Insets(0, SizeData.TEXT_MARGIN, 0, 0));

        this.active = false;
        this.dropdownPanel = new DropdownPanel(0, 0, this.getWidth(), SizeData.DROPDOWN_HEIGHT, frame, appearanceName+".dropdown");
    }

    /**
     * Defines the constructor of menu buttons that
     * initializes every field of the class except for the
     * text.
     *
     * @param dimension      The dimension of the menu button
     * @param frame          The main frame of the application
     * @param appearanceName The name of the <code>Appearance</code> that's
     *                       values should be implemented on this component
     */
    protected AbstractMenuButton(Dimension dimension, final XFrame frame, String appearanceName) {
        this(dimension, "", frame, appearanceName);
    }

    /**
     * Defines the constructor of menu buttons that
     * initializes every field of the class.
     *
     * @param x              The X coordinate of the panel in no-layout manager space
     * @param y              The Y coordinate of the panel in no-layout manager space
     * @param width          The width of the panel
     * @param height         The height of the panel
     * @param text           The text of the menu button
     * @param frame          The main frame of the application
     * @param appearanceName The name of the <code>Appearance</code> that's
     *                       values should be implemented on this component
     */
    protected AbstractMenuButton(int x, int y, int width, int height, String text, final XFrame frame, String appearanceName) {
        super(x, y, width, height, text, frame, appearanceName);

        this.setHorizontalAlignment(SwingConstants.LEFT);
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.setMargin(new Insets(0, SizeData.TEXT_MARGIN, 0, 0));

        this.active = false;
        this.dropdownPanel = new DropdownPanel(0, 0, this.getWidth(), SizeData.DROPDOWN_HEIGHT, frame, appearanceName+".dropdown");
    }

    /**
     * Defines the constructor of menu buttons that
     * initializes every field of the class except for the
     * text.
     *
     * @param x              The X coordinate of the panel in no-layout manager space
     * @param y              The Y coordinate of the panel in no-layout manager space
     * @param width          The width of the panel
     * @param height         The height of the panel
     * @param frame          The main frame of the application
     * @param appearanceName The name of the <code>Appearance</code> that's
     *                       values should be implemented on this component
     */
    protected AbstractMenuButton(int x, int y, int width, int height, final XFrame frame, String appearanceName) {
        this(x, y, width, height, "", frame, appearanceName);
    }
}
