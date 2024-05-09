package com._4th_dimension_software.app.view.components.built.ui.editors;

import com._4th_dimension_software.app.control.editors.AbstractEditorController;
import com._4th_dimension_software.app.view.components.base.button.XButton;
import com._4th_dimension_software.app.view.components.base.label.XLabel;
import com._4th_dimension_software.app.view.components.base.panel.XPanel;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.consts.PositionConstants;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

/**
 * The <code>AbstractEditor</code> abstract class defines the abstract
 * behaviour of editors inside the application. It holds an anonymous
 * instance of the <code>AbstractEditorController</code> that takes
 * care of closing the editors.
 *
 * @author szd
 */
public abstract class AbstractEditor extends XPanel {
    // Parts of the editor
    protected final XPanel headerPanel;
    protected final XPanel centerPanel;
    protected final XPanel footerPanel;
    // Title label
    protected final XLabel titleLabel;
    // Close button
    protected final XButton closeButton;
    protected final XButton confirmButton;

    /**
     * Defines the base constructor of editors.
     *
     * @param frame          The main frame of the application
     * @param appearanceName The name of the <code>Appearance</code> that's
     *                       values should be implemented on this component
     */
    protected AbstractEditor(final XFrame frame, String appearanceName) {
        super((SizeData.SCREEN_WIDTH/2)-(SizeData.EDITOR_WIDTH/2)-SizeData.SIDEBAR_WIDTH, (SizeData.SCREEN_HEIGHT/2)-(SizeData.EDITOR_HEIGHT/2),
            SizeData.EDITOR_WIDTH, SizeData.EDITOR_HEIGHT, new BorderLayout(), frame, appearanceName);

        // Parts of the editor
        this.headerPanel = new XPanel(new Dimension(this.getWidth(), SizeData.BUTTON_HEIGHT), new FlowLayout(FlowLayout.RIGHT, 0, 0), frame, appearanceName+".header");
        this.centerPanel = new XPanel(new Dimension(this.getWidth(), this.getHeight()-SizeData.BUTTON_HEIGHT), frame, appearanceName+".center");
        this.footerPanel = new XPanel(this.headerPanel.getPreferredSize(), new FlowLayout(FlowLayout.CENTER, 0, 0), frame, appearanceName+".footer");

        // Title label
        this.titleLabel = new XLabel(new Dimension(this.headerPanel.getWidth()-SizeData.N_BUTTON_WIDTH, SizeData.BUTTON_HEIGHT), "", frame, appearanceName+".title");
        this.titleLabel.setHorizontalAlignment(JLabel.LEFT);
        this.titleLabel.setMargin(new Insets(0, SizeData.TEXT_MARGIN, 0, 0));

        // Close button
        this.closeButton = new XButton(SizeData.N_BUTTON_DIMENSION, "x", frame, appearanceName+".buttons.close");
        this.confirmButton = new XButton(SizeData.W_BUTTON_DIMENSION, "Confirm", frame, appearanceName+".buttons.confirm");

        // Instantiate an anonymous controller for the editors
        new AbstractEditorController(this);

        // Add components to the header panel
        this.headerPanel.addComponent(this.titleLabel);
        this.headerPanel.addComponent(this.closeButton);

        // Add components to the footer panel
        this.footerPanel.addComponent(this.confirmButton);

        // Add the parts of the editor top the display
        this.addComponent(this.headerPanel, PositionConstants.TOP_POSITION);
        this.addComponent(this.centerPanel, PositionConstants.CENTER_POSITION);
        this.addComponent(this.footerPanel, PositionConstants.BOTTOM_POSITION);
    }

    /**
     * Sets the title of this editor object.
     *
     * @param title The title of this editor object
     */
    protected void setTitle(String title) {
        this.titleLabel.setText(title);
    }

    public XButton getCloseButton() {
        return this.closeButton;
    }
}
