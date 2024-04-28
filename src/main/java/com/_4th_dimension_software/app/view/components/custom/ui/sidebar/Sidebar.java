package com._4th_dimension_software.app.view.components.custom.ui.sidebar;

import com._4th_dimension_software.app.control.sidebar.SidebarController;
import com._4th_dimension_software.app.view.components.base.label.XLabel;
import com._4th_dimension_software.app.view.components.base.panel.XPanel;
import com._4th_dimension_software.app.view.components.custom.separator.Separator;
import com._4th_dimension_software.app.view.components.custom.ui.sidebar.menu.MenuButton;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.consts.RelativePositions;

import javax.swing.SwingConstants;
import java.util.ArrayList;
import java.util.List;

/**
 * The <code>Sidebar</code> class contains the declaration of
 * everything that is in the sidebar of the application. Actions
 * happening in the sidebar are handled in this class,
 * buttons displayed in the sidebar are controlled by this class
 * etc.
 */
public final class Sidebar extends XPanel {
	// List of the buttons
	private List<MenuButton> menuButtons;
	// Header
	private final XLabel header;
	// Separators
	private final Separator separator1;
	private final Separator separator2;
	// Menu buttons
	private final MenuButton pouleButton;
	private final MenuButton tableButton;
	private final MenuButton competitionButton;
	private final MenuButton ruleSetsButton;
	private final MenuButton settingsButton;
	private final MenuButton databaseButton;

	/**
	 * Constructs a <code>Sidebar</code> object.
	 * This object's UI representation is
	 * automatically added to the main frame of the
	 * application.
	 *
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the <code>Appearance</code> that's
	 *                       values should be implemented on this sidebar
	 */
	public Sidebar(final XFrame frame, String appearanceName) {
		super(SizeData.SIDEBAR_DIMENSION, frame, appearanceName);

		this.menuButtons = new ArrayList<>();

		// The listener that takes care of the mouse actions happened in the sidebar
		final SidebarController sml = new SidebarController(this);

		// Header
		this.header = new XLabel(SizeData.W_BUTTON_DIMENSION, "Dashboard", frame, appearanceName+".header");
		this.header.centerContent();

		// Separators
		this.separator1 = new Separator(SizeData.SEPARATOR_DIMENSION, appearanceName+".separator");
		this.separator2 = new Separator(SizeData.SEPARATOR_DIMENSION, appearanceName+".separator");

		// Menu buttons
		this.pouleButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, "Poule", frame, appearanceName+".buttons.poule");
		this.pouleButton.addButtonToDropdown("Empty Poule", appearanceName+".buttons.poule.dropdown.empty");
		this.pouleButton.addButtonToDropdown("From Database", appearanceName+".buttons.poule.dropdown.database");
		this.pouleButton.addButtonToDropdown("View Poule Stats", appearanceName+".buttons.poule.dropdown.stats");
		this.pouleButton.adjustContentOfButtonsInDropdown(SwingConstants.LEADING);

		this.tableButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, "Table", frame, appearanceName+".buttons.table");
		this.tableButton.addButtonToDropdown("Empty Table", appearanceName+".buttons.table.dropdown.empty");
		this.tableButton.addButtonToDropdown("From Database", appearanceName+".buttons.table.dropdown.database");
		this.tableButton.addButtonToDropdown("View Table Stats", appearanceName+".buttons.table.dropdown.stats");
		this.tableButton.adjustContentOfButtonsInDropdown(SwingConstants.LEADING);

		this.competitionButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, "Competition", frame, appearanceName+".buttons.competition");
		this.competitionButton.addButtonToDropdown("Empty Competition", appearanceName+".buttons.competition.dropdown.empty");
		this.competitionButton.addButtonToDropdown("From Database", appearanceName+".buttons.competition.dropdown.database");
		this.competitionButton.addButtonToDropdown("View Comp. Stats", appearanceName+".buttons.competition.dropdown.stats");
		this.competitionButton.adjustContentOfButtonsInDropdown(SwingConstants.LEADING);

		this.ruleSetsButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, "Rule Sets", frame, appearanceName+".buttons.ruleSet");
		this.ruleSetsButton.addButtonToDropdown("View Rule Sets", appearanceName+".buttons.ruleSet.dropdown.view");
		this.ruleSetsButton.addButtonToDropdown("New Rule Set", appearanceName+".buttons.ruleSet.dropdown.add");
		this.ruleSetsButton.addButtonToDropdown("Delete Rule Set", appearanceName+".buttons.ruleSet.dropdown.delete");
		this.ruleSetsButton.addButtonToDropdown("Modify Rule Set", appearanceName+".buttons.ruleSet.dropdown.modify");
		this.ruleSetsButton.adjustContentOfButtonsInDropdown(SwingConstants.LEADING);

		this.settingsButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, "Settings", frame, appearanceName+".buttons.settings");
		this.settingsButton.addButtonToDropdown("Appearance", appearanceName+".buttons.settings.dropdown.appearance");
		this.settingsButton.adjustContentOfButtonsInDropdown(SwingConstants.LEADING);

		this.databaseButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, "Database", frame, appearanceName+".buttons.database");
		this.databaseButton.addButtonToDropdown("Connect", appearanceName+".buttons.database.dropdown.connect");
		this.databaseButton.addButtonToDropdown("Manage", appearanceName+".buttons.database.dropdown.manage");
		this.databaseButton.adjustContentOfButtonsInDropdown(SwingConstants.LEADING);

		// Add the menu buttons to the menu button list
		this.menuButtons.add(this.pouleButton);
		this.menuButtons.add(this.tableButton);
		this.menuButtons.add(this.competitionButton);
		this.menuButtons.add(this.ruleSetsButton);
		this.menuButtons.add(this.settingsButton);
		this.menuButtons.add(this.databaseButton);

		// Implement the controller
		this.menuButtons.forEach(btn -> btn.addMouseListener(sml));
		this.frame.getCenterPanel().addMouseListener(sml);

		// Add the header to the sidebar
		this.addComponent(this.header);
		// Add the separator to the sidebar
		this.addComponent(this.separator1);

		// Add the menu buttons to the sidebar
		for (int i = 0; i < this.menuButtons.size(); i++) {
			this.addComponent(this.menuButtons.get(i));

			if (i == 2)
				this.addComponent(this.separator2);
		}
	}

	/**
	 * Adjusts the location of dropdown panels of
	 * menu buttons to display correctly. This
	 * method requires the main frame of the application
	 * to be visible.
	 */
	public void performAdjustments() {
		this.menuButtons.forEach(btn ->
			btn.adjustDropdownPosition(RelativePositions.TO_RIGHT, 0, 0));
	}

	public List<MenuButton> getButtons() {
		return this.menuButtons;
	}
}
