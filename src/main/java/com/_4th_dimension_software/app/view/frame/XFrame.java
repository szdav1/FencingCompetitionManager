package com._4th_dimension_software.app.view.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import com._4th_dimension_software.app.view.components.base.panel.XPanel;
import com._4th_dimension_software.app.view.components.built.ui.editors.*;
import com._4th_dimension_software.app.view.components.built.ui.editors.newruleset.NewRuleSetEditor;
import com._4th_dimension_software.app.view.components.built.ui.inspectors.CompetitionStatsInspector;
import com._4th_dimension_software.app.view.components.built.ui.inspectors.PouleStatsInspector;
import com._4th_dimension_software.app.view.components.built.ui.inspectors.RuleSetsInspector;
import com._4th_dimension_software.app.view.components.built.ui.inspectors.TableStatsInspector;
import com._4th_dimension_software.app.view.components.built.ui.sidebar.Sidebar;
import com._4th_dimension_software.support.consts.FrameState;
import com._4th_dimension_software.support.consts.PositionConstants;

/**
 * The <code>XFrame</code> is the main frame of the application. Everything
 * that takes place on the screen is handled by this class
 * in order to avoid conflicts with positions and components.
 * Every component takes care of its own task, but it is this
 * <code>XFrame</code> class that will conduct the displaying and removing of
 * those components. Main components like editors can not be
 * displayed when another editor is opened or the user is doing
 * something else that might interrupt the displaying process.
 *
 * @author szd
 */
public class XFrame extends AbstractXFrame {
	// Content panel
	private final XPanel contentPanel;
	// Frame parts
	// Center panel
	private final XPanel centerPanel;
	// Sidebar
	private final Sidebar sidebar;

	// Currently opened editor
	private XPanel displayingPanel;
	// Editors
	// Poule
	private final EmptyPouleEditor emptyPouleEditor;
	private final PouleFromDatabaseEditor pouleFromDatabaseEditor;
	private final PouleStatsInspector pouleStatsInspector;
	// Table
	private final EmptyTableEditor emptyTableEditor;
	private final TableFromDatabaseEditor tableFromDatabaseEditor;
	private final TableStatsInspector tableStatsInspector;
	// Competition
	private final EmptyCompetitionEditor emptyCompetitionEditor;
	private final CompetitionFromDatabaseEditor competitionFromDatabaseEditor;
	private final CompetitionStatsInspector competitionStatsInspector;
	// Rule set
	private final NewRuleSetEditor newRuleSetEditor;
	private final RuleSetsInspector ruleSetsInspector;
	private final RuleSetDeleter ruleSetDeleter;
	private final RuleSetModifier ruleSetModifier;
	// Settings
	private final InterfaceEditor interfaceEditor;
	private final LanguageEditor languageEditor;
	// Database
	private final DatabaseConnectionEditor databaseConnectionEditor;

	/**
	 * Constructs an <code>XFrame</code> object. This object is
	 * the conductor of the actions in the application.
	 *
	 * @param title          The title of the application window
	 * @param appearanceName The name of the Appearance that is going to
	 *                       be used to stylize the window
	 */
	public XFrame(String title, String appearanceName) {
		// Basic setup for the window
		super(title, appearanceName);

		// Instantiate and set the content panel
		this.contentPanel = new XPanel(new Dimension(this.getWidth(), this.getHeight()), new BorderLayout(), this, appearanceName);
		this.setContentPane(this.contentPanel);

		// Instantiate and add parts of the frame
		// Center panel
		this.centerPanel = new XPanel(this.contentPanel.getPreferredSize(), null, this, appearanceName);
		// Sidebar
		this.sidebar = new Sidebar(this, "sidebar");

		// Editors
		// Poule
		this.emptyPouleEditor = new EmptyPouleEditor(this, "pouleEditor");
		this.pouleFromDatabaseEditor = new PouleFromDatabaseEditor(this, "pouleEditor");
		this.pouleStatsInspector = new PouleStatsInspector(this, "pouleEditor");
		// Table
		this.emptyTableEditor = new EmptyTableEditor(this, "tableEditor");
		this.tableFromDatabaseEditor = new TableFromDatabaseEditor(this, "tableEditor");
		this.tableStatsInspector = new TableStatsInspector(this, "tableEditor");
		// Competition
		this.emptyCompetitionEditor = new EmptyCompetitionEditor(this, "competitionEditor");
		this.competitionFromDatabaseEditor = new CompetitionFromDatabaseEditor(this, "competitionEditor");
		this.competitionStatsInspector = new CompetitionStatsInspector(this, "competitionEditor");
		// Rule set
		this.newRuleSetEditor = new NewRuleSetEditor(this, "ruleSetEditor");
		this.ruleSetsInspector = new RuleSetsInspector(this, "ruleSetEditor");
		this.ruleSetDeleter = new RuleSetDeleter(this, "ruleSetEditor");
		this.ruleSetModifier = new RuleSetModifier(this, "ruleSetEditor");
		// Settings
		this.interfaceEditor = new InterfaceEditor(this, "settingsEditor");
		this.languageEditor = new LanguageEditor(this, "settingsEditor");
		// Database
		this.databaseConnectionEditor = new DatabaseConnectionEditor(this, "databaseEditor");

		// Background image
		this.setBackgroundImage();
		// Add frame part components
		// Sidebar
		this.addComponent(this.sidebar, PositionConstants.LEFT_POSITION);
		// Center panel
		this.addComponent(this.centerPanel, PositionConstants.CENTER_POSITION);
	}

	public void display() {
		// Set visibility
		this.setVisible(true);

		// Perform fine adjustments on locations and dimensions that require the frame to be visible
		this.sidebar.performAdjustments();
	}

	/**
	 * Adds the empty poule editor to the main frame.
	 * This method only runs if the state of the frame
	 * is <code>NORMAL</code>.
	 */
	public void openEmptyPouleEditor() {
		if (this.frameState == FrameState.NORMAL) {
			this.addToCenterPanel(this.emptyPouleEditor);
			this.displayingPanel = this.emptyPouleEditor;
			this.frameState = FrameState.POULE_EDITOR_OPENED;
		}
	}

	/**
	 * Adds the poule from database editor to the main frame.
	 * This method only runs if the state of the frame
	 * is <code>NORMAL</code>.
	 */
	public void openPouleFromDatabaseEditor() {
		if (this.frameState == FrameState.NORMAL) {
			this.addToCenterPanel(this.pouleFromDatabaseEditor);
			this.displayingPanel = this.pouleFromDatabaseEditor;
			this.frameState = FrameState.POULE_EDITOR_OPENED;
		}
	}

	/**
	 * Adds the poule stats inspector to the main frame.
	 * This method only runs if the state of the frame
	 * is <code>NORMAL</code>.
	 */
	public void openPouleStatsInspector() {
		if (this.frameState == FrameState.NORMAL) {
			this.addToCenterPanel(this.pouleStatsInspector);
			this.displayingPanel = this.pouleStatsInspector;
			this.frameState = FrameState.POULE_STATS_INSPECTOR_OPENED;
		}
	}

	/**
	 * Adds the empty table editor to the main frame.
	 * This method only runs if the state of the frame
	 * is <code>NORMAL</code>.
	 */
	public void openEmptyTableEditor() {
		if (this.frameState == FrameState.NORMAL) {
			this.addToCenterPanel(this.emptyTableEditor);
			this.displayingPanel = this.emptyTableEditor;
			this.frameState = FrameState.TABLE_EDITOR_OPENED;
		}
	}

	/**
	 * Adds the table from database editor to the main frame.
	 * This method only runs if the state of the frame
	 * is <code>NORMAL</code>.
	 */
	public void openTableFromDatabaseEditor() {
		if (this.frameState == FrameState.NORMAL) {
			this.addToCenterPanel(this.tableFromDatabaseEditor);
			this.displayingPanel = this.tableFromDatabaseEditor;
			this.frameState = FrameState.TABLE_EDITOR_OPENED;
		}
	}

	/**
	 * Adds the poule stats inspector to the main frame.
	 * This method only runs if the state of the frame
	 * is <code>NORMAL</code>.
	 */
	public void openTableStatsInspector() {
		if (this.frameState == FrameState.NORMAL) {
			this.addToCenterPanel(this.tableStatsInspector);
			this.displayingPanel = this.tableStatsInspector;
			this.frameState = FrameState.TABLE_STATS_INSPECTOR_OPENED;
		}
	}

	/**
	 * Adds the empty competition editor to the main frame.
	 * This method only runs if the state of the frame
	 * is <code>NORMAL</code>.
	 */
	public void openEmptyCompetitionEditor() {
		if (this.frameState == FrameState.NORMAL) {
			this.addToCenterPanel(this.emptyCompetitionEditor);
			this.displayingPanel = this.emptyCompetitionEditor;
			this.frameState = FrameState.COMPETITION_EDITOR_OPENED;
		}
	}

	/**
	 * Adds the empty competition editor to the main frame.
	 * This method only runs if the state of the frame
	 * is <code>NORMAL</code>.
	 */
	public void openCompetitionFromDatabaseEditor() {
		if (this.frameState == FrameState.NORMAL) {
			this.addToCenterPanel(this.competitionFromDatabaseEditor);
			this.displayingPanel = this.competitionFromDatabaseEditor;
			this.frameState = FrameState.COMPETITION_EDITOR_OPENED;
		}
	}

	/**
	 * Adds the poule stats inspector to the main frame.
	 * This method only runs if the state of the frame
	 * is <code>NORMAL</code>.
	 */
	public void openCompetitionStatsInspector() {
		if (this.frameState == FrameState.NORMAL) {
			this.addToCenterPanel(this.competitionStatsInspector);
			this.displayingPanel = this.competitionStatsInspector;
			this.frameState = FrameState.COMPETITION_STATS_INSPECTOR_OPENED;
		}
	}

	/**
	 * Adds the new rule set editor to the main frame.
	 * This method only runs if the state of the frame
	 * is <code>NORMAL</code>.
	 */
	public void openRuleSetInspector() {
		if (this.frameState == FrameState.NORMAL) {
			this.addToCenterPanel(this.ruleSetsInspector);
			this.displayingPanel = this.ruleSetsInspector;
			this.frameState = FrameState.RULE_SET_INSPECTOR_OPENED;
		}
	}

	/**
	 * Adds the new rule set editor to the main frame.
	 * This method only runs if the state of the frame
	 * is <code>NORMAL</code>.
	 */
	public void openNewRuleSetEditor() {
		if (this.frameState == FrameState.NORMAL) {
			this.addToCenterPanel(this.newRuleSetEditor);
			this.displayingPanel = this.newRuleSetEditor;
			this.frameState = FrameState.RULE_SET_EDITOR_OPENED;
		}
	}

	/**
	 * Adds the new rule set editor to the main frame.
	 * This method only runs if the state of the frame
	 * is <code>NORMAL</code>.
	 */
	public void openRuleSetDeleter() {
		if (this.frameState == FrameState.NORMAL) {
			this.addToCenterPanel(this.ruleSetDeleter);
			this.displayingPanel = this.ruleSetDeleter;
			this.frameState = FrameState.RULE_SET_EDITOR_OPENED;
		}
	}

	/**
	 * Adds the new rule set editor to the main frame.
	 * This method only runs if the state of the frame
	 * is <code>NORMAL</code>.
	 */
	public void openRuleSetModifier() {
		if (this.frameState == FrameState.NORMAL) {
			this.addToCenterPanel(this.ruleSetModifier);
			this.displayingPanel = this.ruleSetModifier;
			this.frameState = FrameState.RULE_SET_EDITOR_OPENED;
		}
	}

	/**
	 * Adds the interface editor to the main frame.
	 * This method only runs if the state of the frame
	 * is <code>NORMAL</code>.
	 */
	public void openInterfaceEditor() {
		if (this.frameState == FrameState.NORMAL) {
			this.addToCenterPanel(this.interfaceEditor);
			this.displayingPanel = this.interfaceEditor;
			this.frameState = FrameState.SETTINGS_EDITOR_OPENED;
		}
	}

	/**
	 * Adds the language editor to the main frame.
	 * This method only runs if the state of the frame
	 * is <code>NORMAL</code>.
	 */
	public void openLanguageEditor() {
		if (this.frameState == FrameState.NORMAL) {
			this.addToCenterPanel(this.languageEditor);
			this.displayingPanel = this.languageEditor;
			this.frameState = FrameState.SETTINGS_EDITOR_OPENED;
		}
	}

	/**
	 * Adds the database connection editor to the main frame.
	 * This method only runs if the state of the frame
	 * is <code>NORMAL</code>.
	 */
	public void openDatabaseConnectionEditor() {
		if (this.frameState == FrameState.NORMAL) {
			this.addToCenterPanel(this.databaseConnectionEditor);
			this.displayingPanel = this.databaseConnectionEditor;
			this.frameState = FrameState.DATABASE_EDITOR_OPENED;
		}
	}

	/**
	 * Removes the currently opened editor from the main frame.
	 * This method only runs if the state of the frame is not
	 * <code>NORMAL</code>.
	 */
	public void removeDisplayingPanel() {
		if (this.frameState != FrameState.NORMAL) {
			this.removeFromCenterPanel(this.displayingPanel);
			this.frameState = FrameState.NORMAL;
		}
	}

	/**
	 * Closes the application frame and shuts down
	 * the application.
	 */
	public void exit() {
		if (this.frameState == FrameState.NORMAL) {
			this.dispose();
			System.exit(0);
		}
	}

	/**
	 * Sets the background image of the frame.
	 * This image will only cover the center area of the
	 * frame. The image is the secondary mage contained in the frame's
	 * <code>Appearance</code>.
	 */
	private void setBackgroundImage() {
		if (this.appearance.getIcon2() == null)
			return;

		JLabel l = new JLabel(new ImageIcon(this.appearance.getIcon2()
			.getImage()
			.getScaledInstance(this.centerPanel.getWidth(), this.centerPanel.getHeight(), Image.SCALE_SMOOTH)));

		l.setBounds(0, 0, this.centerPanel.getWidth(), this.centerPanel.getHeight());
		this.centerPanel.addComponent(l, PositionConstants.BACKGROUND_POSITION);

	}

	/**
	 * Adds the specified component to the center panel of the frame
	 * placed on the desired Z coordinate specified by the position
	 * constant.
	 *
	 * @param component         The component that should be added to the center panel
	 * @param positionConstants The Z position on which the component should be placed
	 */
	public void addToCenterPanel(JComponent component, PositionConstants positionConstants) {
		this.centerPanel.addComponent(component, positionConstants);
	}

	/**
	 * Adds the specified component to the center panel of the frame
	 * placed on the desired Z coordinate specified by the position
	 * constant.
	 *
	 * @param component The component that should be added to the center panel
	 */
	public void addToCenterPanel(JComponent component) {
		this.addToCenterPanel(component, PositionConstants.MID_POSITION);
	}

	/**
	 * Removes and returns the desired component from the
	 * center panel of the frame.
	 *
	 * @param component The component that should be removed
	 * @return The removed component
	 */
	public JComponent removeFromCenterPanel(JComponent component) {
		return this.centerPanel.removeComponent(component);
	}

	public XPanel getCenterPanel() {
		return this.centerPanel;
	}

	@Override
	public void addComponent(final JComponent component, PositionConstants positionConstants) {
		this.contentPanel.addComponent(component, positionConstants);
	}

	@Override
	public void addComponent(final JComponent component) {
		this.contentPanel.addComponent(component);
	}

	@Override
	public JComponent removeComponent(final JComponent component) {
		return this.contentPanel.removeComponent(component);
	}
}
