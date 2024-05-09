package com._4th_dimension_software.app.view.components.built.ui.editor;

import com._4th_dimension_software.app.control.editor.AbstractEditorController;
import com._4th_dimension_software.app.view.components.base.button.XButton;
import com._4th_dimension_software.app.view.components.base.label.XLabel;
import com._4th_dimension_software.app.view.components.base.panel.XPanel;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.consts.PositionConstants;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

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

    protected AbstractEditor(XFrame frame, String appearanceName) {
        super(SizeData.SCREEN_WIDTH/4-SizeData.W_BUTTON_WIDTH, SizeData.SCREEN_HEIGHT/4, SizeData.SCREEN_WIDTH/2, SizeData.SCREEN_HEIGHT/2, new BorderLayout(), frame, appearanceName);

        // Parts of the editor
        this.headerPanel = new XPanel(new Dimension(this.getWidth(), SizeData.BUTTON_HEIGHT), new FlowLayout(FlowLayout.RIGHT, 0, 0), frame, appearanceName+".header");
        this.centerPanel = new XPanel(new Dimension(this.getWidth(), this.getHeight()-SizeData.BUTTON_HEIGHT), frame, appearanceName+".center");
        this.footerPanel = new XPanel(this.headerPanel.getPreferredSize(), new FlowLayout(FlowLayout.CENTER, 0, 0), frame, appearanceName+".footer");

        // Title label
        this.titleLabel = new XLabel(new Dimension(this.headerPanel.getWidth()-SizeData.N_BUTTON_WIDTH, SizeData.BUTTON_HEIGHT), "", frame, appearanceName+".title");
        this.titleLabel.setHorizontalAlignment(JLabel.LEFT);
        this.titleLabel.setBorder(new EmptyBorder(new Insets(0, SizeData.TEXT_MARGIN, 0, 0)));

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
