package com._4th_dimension_software.app.view.components.built.ui.editors.newruleset;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JLabel;

import com._4th_dimension_software.app.view.components.base.label.XLabel;
import com._4th_dimension_software.app.view.components.base.panel.XPanel;
import com._4th_dimension_software.app.view.components.base.scrollpanel.XScrollPanel;
import com._4th_dimension_software.app.view.components.built.ui.editors.AbstractEditor;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.lang.LanguagePack;

/**
 * The <code>NewRuleSetEditor</code> class is a subclass
 * of the <code>AbstractEditor</code>. It contains UI
 * elements and handles actions related to rule set
 * creation.
 *
 * @author szd
 */
public final class NewRuleSetEditor extends AbstractEditor {
	/**
	 * Constructs a <code>NewRuleSetEditor</code> object.
	 * This editor object is responsible for handling
	 * rule set creation.
	 *
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that should
	 *                       be implemented on this component
	 */
	public NewRuleSetEditor(final XFrame frame, String appearanceName) {
		super(frame, appearanceName);
		this.setTitle(LanguagePack.get("newRuleSetEditor.title"));
		this.centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		final int IPX = (this.getWidth()/2)-(SizeData.EDITOR_INNER_PANEL_WIDTH/2);
		final int IPY = 0;
		final int VGAP = SizeData.PROPORTIONALITY_FACTOR*5;

		// Scroll panel
		XScrollPanel scrollPanel = new XScrollPanel(new Dimension(this.getWidth()-SizeData.BORDER_SIZE, this.getHeight()-(SizeData.BUTTON_HEIGHT*2)), null, frame,
			appearanceName+".scrollPanel", appearanceName+".scrollPanel.scrollBar");

		// Editor parts
		// Rule set attributes
		XLabel ruleSetAttributesLabel = new XLabel(SizeData.W_BUTTON_DIMENSION, LanguagePack.get("newRuleSetEditor.attributesTitle"), frame, appearanceName+".titleLabels");
		ruleSetAttributesLabel.setMargin(new Insets(0, SizeData.TEXT_MARGIN, 0, 0));
		ruleSetAttributesLabel.setHorizontalAlignment(JLabel.LEFT);

		XPanel ruleSetApplicationPanel = new XPanel(IPX, IPY, SizeData.EDITOR_INNER_PANEL_WIDTH, SizeData.EDITOR_INNER_PANEL_HEIGHT,
			new FlowLayout(FlowLayout.LEFT, 0, 0), frame, appearanceName+".innerPanel");

		// Poule rules
		XLabel pouleRulesLabel = new XLabel(SizeData.W_BUTTON_DIMENSION, LanguagePack.get("newRuleSetEditor.pouleRulesTitle"), frame, appearanceName+".titleLabels");
		pouleRulesLabel.setMargin(new Insets(0, SizeData.TEXT_MARGIN, 0, 0));
		pouleRulesLabel.setHorizontalAlignment(JLabel.LEFT);

		XPanel pouleRulesPanel = new XPanel(IPX, IPY+VGAP+SizeData.EDITOR_INNER_PANEL_HEIGHT, SizeData.EDITOR_INNER_PANEL_WIDTH, SizeData.EDITOR_INNER_PANEL_HEIGHT,
			new FlowLayout(FlowLayout.LEFT, 0, 0), frame, appearanceName+".innerPanel");

		// Table rules
		XLabel tableRulesLabel = new XLabel(SizeData.W_BUTTON_DIMENSION, LanguagePack.get("newRuleSetEditor.tableRulesTitle"), frame, appearanceName+".titleLabels");
		tableRulesLabel.setMargin(new Insets(0, SizeData.TEXT_MARGIN, 0, 0));
		tableRulesLabel.setHorizontalAlignment(JLabel.LEFT);

		XPanel tableRulesPanel = new XPanel(IPX, IPY+((VGAP+SizeData.EDITOR_INNER_PANEL_HEIGHT)*2), SizeData.EDITOR_INNER_PANEL_WIDTH, SizeData.EDITOR_INNER_PANEL_HEIGHT,
			new FlowLayout(FlowLayout.LEFT, 0, 0), frame, appearanceName+".innerPanel");

		// Competition rules
		XLabel competitionRulesLabel = new XLabel(SizeData.W_BUTTON_DIMENSION, LanguagePack.get("newRuleSetEditor.competitionRulesTitle"), frame, appearanceName+".titleLabels");
		competitionRulesLabel.setMargin(new Insets(0, SizeData.TEXT_MARGIN, 0, 0));
		competitionRulesLabel.setHorizontalAlignment(JLabel.LEFT);

		XPanel competitionRulesPanel = new XPanel(IPX, IPY+((VGAP+SizeData.EDITOR_INNER_PANEL_HEIGHT)*3), SizeData.EDITOR_INNER_PANEL_WIDTH, SizeData.EDITOR_INNER_PANEL_HEIGHT,
			new FlowLayout(FlowLayout.LEFT, 0, 0), frame, appearanceName+".innerPanel");

		// Add components to the containers
		// Rule set application
		ruleSetApplicationPanel.addComponent(ruleSetAttributesLabel);

		// Poule rules
		pouleRulesPanel.addComponent(pouleRulesLabel);

		// Table rules
		tableRulesPanel.addComponent(tableRulesLabel);

		// Competition rules
		competitionRulesPanel.addComponent(competitionRulesLabel);

		// Add the containers to the scroll panel
		scrollPanel.addComponent(ruleSetApplicationPanel);
		scrollPanel.addComponent(pouleRulesPanel);
		scrollPanel.addComponent(tableRulesPanel);
		scrollPanel.addComponent(competitionRulesPanel);

		// Add the scroll panel to the display
		this.centerPanel.addComponent(scrollPanel);
	}
}
