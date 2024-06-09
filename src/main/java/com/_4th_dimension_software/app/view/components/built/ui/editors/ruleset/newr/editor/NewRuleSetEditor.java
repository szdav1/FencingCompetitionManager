package com._4th_dimension_software.app.view.components.built.ui.editors.ruleset.newr.editor;

import java.awt.Dimension;
import java.awt.FlowLayout;

import com._4th_dimension_software.app.view.components.base.scrollpanel.XScrollPanel;
import com._4th_dimension_software.app.view.components.built.ui.editors.AbstractEditor;
import com._4th_dimension_software.app.view.components.built.ui.editors.ruleset.newr.CompetitionRuleSetInputPanel;
import com._4th_dimension_software.app.view.components.built.ui.editors.ruleset.newr.PouleRuleSetInputPanel;
import com._4th_dimension_software.app.view.components.built.ui.editors.ruleset.newr.RuleSetAttributesInputPanel;
import com._4th_dimension_software.app.view.components.built.ui.editors.ruleset.newr.TableRuleSetInputPanel;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.lang.Language;

/**
 * The <code>NewRuleSetEditor</code> class is a subclass
 * of the <code>AbstractEditor</code>. It contains UI
 * elements and handles actions related to rule set
 * creation.
 *
 * @author szd
 */
public final class NewRuleSetEditor extends AbstractEditor {
	private final RuleSetAttributesInputPanel ruleSetAttributesInputPanel;
	private final PouleRuleSetInputPanel pouleRuleSetInputPanel;
	private final TableRuleSetInputPanel tableRuleSetInputPanel;
	private final CompetitionRuleSetInputPanel competitionRuleSetInputPanel;

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
		this.setTitle(Language.get("newRuleSetEditor.title"));
		this.centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		final int IPX = (this.getWidth()/2)-(SizeData.EDITOR_INNER_PANEL_WIDTH/2);
		final int IPY = 0;
		final int VGAP = SizeData.PROPORTIONALITY_FACTOR*7;

		// Scroll panel
		XScrollPanel sp = new XScrollPanel(new Dimension(this.getWidth()-SizeData.BORDER_SIZE, this.getHeight()-(SizeData.BUTTON_HEIGHT*2)),
			new FlowLayout(FlowLayout.CENTER, 0, VGAP), frame, appearanceName+".scrollPanel");
		sp.setAutoResize(true);

		// Editor parts
		// Rule set attributes
		this.ruleSetAttributesInputPanel = new RuleSetAttributesInputPanel(Language.get("newRuleSetEditor.attributesTitle"), frame, appearanceName+".innerPanel");
		this.ruleSetAttributesInputPanel.setScrollPanel(sp);

		// Poule rule set
		this.pouleRuleSetInputPanel = new PouleRuleSetInputPanel(Language.get("newRuleSetEditor.pouleRulesTitle"), frame, appearanceName+".innerPanel");
		this.pouleRuleSetInputPanel.setScrollPanel(sp);

		// Table rule set
		this.tableRuleSetInputPanel = new TableRuleSetInputPanel(Language.get("newRuleSetEditor.tableRulesTitle"), frame, appearanceName+".innerPanel");
		this.tableRuleSetInputPanel.setScrollPanel(sp);

		// Competition rule set
		this.competitionRuleSetInputPanel = new CompetitionRuleSetInputPanel(Language.get("newRuleSetEditor.competitionRulesTitle"), frame, appearanceName+".innerPanel");
		this.competitionRuleSetInputPanel.setScrollPanel(sp);

		sp.addComponent(this.ruleSetAttributesInputPanel);
		sp.addComponent(this.pouleRuleSetInputPanel);
		sp.addComponent(this.tableRuleSetInputPanel);
		sp.addComponent(this.competitionRuleSetInputPanel);

		this.ruleSetAttributesInputPanel.setFoldedByDefault();
		this.pouleRuleSetInputPanel.setFoldedByDefault();
		this.tableRuleSetInputPanel.setFoldedByDefault();
		this.competitionRuleSetInputPanel.setFoldedByDefault();

		// Add the scroll panel to the display
		this.centerPanel.addComponent(sp);
	}
}
