package com._4th_dimension_software.app.view.components.built.ui.sidebar.menu;

import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.consts.PositionConstants;
import com._4th_dimension_software.support.consts.RelativePositions;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 * The <code>MenuButton</code> class is a child of the
 * <code>XButton</code> class. This class is used to create
 * structured menus for easy navigation. It has a dropdown panel,
 * which is activated when the button is pressed.
 */
public class MenuButton extends AbstractMenuButton {
    /**
     * Constructs a <code>MenuButton</code> object
     * with the desired dimension and text.
     *
     * @param dimension      The Dimension of the menu button
     * @param text           The text of the menu button
     * @param frame          The main frame of the application
     * @param appearanceName The name of the <code>Appearance</code> that's values
     *                       should be implemented on this panel
     */
    public MenuButton(Dimension dimension, String text, final XFrame frame, String appearanceName) {
        super(dimension, text, frame, appearanceName);
    }

    /**
     * Sets the relative position of the dropdown panel.
     * The position of the dropdown panel is always relative
     * to the menu button's position.
     * <p>Valid values are:</p>
     * <code>ON_TOP</code> the dropdown panel will be displaying
     * on top of the menu button.
     * <p></p>
     * <code>TO_RIGHT</code> the dropdown panel will be displaying
     * on the right side of the menu button.
     * <p></p>
     * <code>AT_BOTTOM</code> the dropdown panel will be displaying
     * at the bottom of the menu button.
     * <p></p>
     * <code>TO_LEFT</code> the dropdown panel will be displaying
     * on the left side of the menu button.
     *
     * @param relativePositions A <code>RelativePositions</code> enum value that defines the
     *                          relative position of the dropdown panel
     */
    public void adjustDropdownPosition(RelativePositions relativePositions, int xAdjustment, int yAdjustment) {
        if (this.getParent() == null || !this.frame.isVisible())
            return;

        final Point p = this.getLocationOnScreen();

        switch (relativePositions) {
            case TO_RIGHT -> this.dropdownPanel.setLocation(p.x+xAdjustment, p.y+yAdjustment);
            case TO_LEFT -> this.dropdownPanel.setLocation(p.x-this.getWidth()+xAdjustment, p.y+yAdjustment);
            case AT_BOTTOM -> this.dropdownPanel.setLocation(p.x+xAdjustment, p.y-this.getHeight()+yAdjustment);
            case ON_TOP ->
                this.dropdownPanel.setLocation(p.x+xAdjustment, p.y-this.dropdownPanel.getHeight()+yAdjustment);
        }
    }

    /**
     * Shortcut to the <code>DropdownPanel</code> class's
     * <code>createAndAddButton()</code> method. It calls the
     * dropdown panel's method with the specified text, shortcut key text and appearanceName.
     *
     * @param buttonText      The text of the button
     * @param shortcutKeyText The string representation of the shortcut key assigned to this button
     * @param appearanceName  The name of the <code>Appearance</code>
     */
    public void addButtonToDropdown(String buttonText, String shortcutKeyText, String appearanceName) {
        this.dropdownPanel.createAndAddButton(buttonText, shortcutKeyText, appearanceName);
        this.dropdownPanel.getLastButton().addActionListener(this);
    }

    /**
     * Shortcut to the <code>DropdownPanel</code> class's
     * <code>createAndAddButton()</code> method. It calls the
     * dropdown panel's method with the specified text and appearanceName.
     *
     * @param buttonText     The text of the button
     * @param appearanceName The name of the <code>Appearance</code>
     */
    public void addButtonToDropdown(String buttonText, String appearanceName) {
        this.dropdownPanel.createAndAddButton(buttonText, appearanceName);
        this.dropdownPanel.getLastButton().addActionListener(this);
    }

    /**
     * Shortcut to the <code>DropdownPanel</code> class's
     * <code>createAndAddButton()</code> method. It calls the
     * dropdown panel's method with the specified text.
     *
     * @param buttonText The text of the button
     */
    public void addButtonToDropdown(String buttonText) {
        this.dropdownPanel.createAndAddButton(buttonText);
        this.dropdownPanel.getLastButton().addActionListener(this);
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public DropdownPanel getDropdownPanel() {
        return this.dropdownPanel;
    }

    /**
     * Adds the dropdown panel of this menu button
     * to the main frame of the application at the set position.
     */
    public void showDropdownPanel() {
        this.frame.addToCenterPanel(this.dropdownPanel, PositionConstants.HIGH_POSITION);
        this.dropdownPanel.setDisplaying(true);
    }

    /**
     * Removes the dropdown panel of the menu button
     * from the main frame of the application.
     */
    public void hideDropdownPanel() {
        this.frame.removeFromCenterPanel(this.dropdownPanel);
        this.dropdownPanel.setDisplaying(false);
    }

    /**
     * Sets the alignment of the content of the buttons inside the
     * dropdown panel of this <code>MenuButton</code> object.
     * <p>Valid values for position are:</p>
     * <p><code>SwingConstants.LEFT</code></p>
     * <p><code>SwingConstants.RIGHT</code></p>
     * <p><code>SwingConstants.CENTER</code></p>
     * <p><code>SwingConstants.LEADING</code></p>
     * <p><code>SwingConstants.TRAILING</code></p>
     *
     * @param position The position of the content of the button
     */
    public void adjustContentOfButtonsInDropdownPanel(int position) {
        this.dropdownPanel.getButtons().forEach(btn -> btn.setHorizontalAlignment(position));
    }

    /**
     * Adds the specified <code>MouseListener</code> interface
     * to this object and every other button object stored
     * inside the dropdown panel of this button.
     *
     * @param ml The <code>MouseListener</code> interface that should be added
     */
    public void addMouseListenerToAll(final MouseListener ml) {
        this.addMouseListener(ml);
        this.dropdownPanel.getButtons()
            .forEach(btn -> btn.addMouseListener(ml));
    }

    /**
     * Adds the specified <code>ActionListener</code> interface
     * to this object and every other button object stored
     * inside the dropdown panel of this button.
     *
     * @param al The <code>MouseListener</code> interface that should be added
     */
    public void addActionListenerToAll(final ActionListener al) {
        this.addActionListener(al);
        this.dropdownPanel.getButtons()
            .forEach(btn -> btn.addActionListener(al));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
         * Control the closing of the dropdown panel
         * when a button is pressed inside it.
         * */
        this.dropdownPanel.getButtons().forEach(btn -> {
            if (btn.equals(e.getSource())) {
                this.setActive(false);
                btn.reset();
                btn.repaint();
                this.hideDropdownPanel();
            }
        });
    }
}
