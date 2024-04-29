package com._4th_dimension_software.app.view.components.custom.ui.sidebar;

import com._4th_dimension_software.app.control.sidebar.SidebarController;
import com._4th_dimension_software.app.view.components.base.button.XButton;
import com._4th_dimension_software.app.view.components.base.label.XLabel;
import com._4th_dimension_software.app.view.components.base.panel.XPanel;
import com._4th_dimension_software.app.view.components.custom.separator.Separator;
import com._4th_dimension_software.app.view.components.custom.ui.sidebar.menu.MenuButton;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.consts.RelativePositions;
import com._4th_dimension_software.support.lang.LanguagePack;

import javax.swing.SwingConstants;
import java.awt.Insets;
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
	private final Separator separator3;
	// Menu buttons
	private final MenuButton pouleButton;
	private final MenuButton tableButton;
	private final MenuButton competitionButton;
	private final MenuButton ruleSetsButton;
	private final MenuButton settingsButton;
	private final MenuButton databaseButton;
	// Exit button
	private final XButton exitButton;

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
		final SidebarController sc = new SidebarController(this);

		// Header
		this.header = new XLabel(SizeData.W_BUTTON_DIMENSION, LanguagePack.get("sidebar.header"), frame, appearanceName+".header");
		this.header.centerContent();

		// Separators
		this.separator1 = new Separator(SizeData.SEPARATOR_DIMENSION, appearanceName+".separator");
		this.separator2 = new Separator(SizeData.SEPARATOR_DIMENSION, appearanceName+".separator");
		this.separator3 = new Separator(SizeData.SEPARATOR_DIMENSION, appearanceName+".separator");

		// Menu buttons
		this.pouleButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, LanguagePack.get("sidebar.poule"), frame, appearanceName+".buttons.poule");
		this.pouleButton.addButtonToDropdown(LanguagePack.get("sidebar.poule.empty"), appearanceName+".buttons.poule.dropdown.empty");
		this.pouleButton.addButtonToDropdown(LanguagePack.get("sidebar.poule.database"), appearanceName+".buttons.poule.dropdown.database");
		this.pouleButton.addButtonToDropdown(LanguagePack.get("sidebar.poule.stats"), appearanceName+".buttons.poule.dropdown.stats");
		this.pouleButton.adjustContentOfButtonsInDropdownPanel(SwingConstants.LEADING);

		this.tableButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, LanguagePack.get("sidebar.table"), frame, appearanceName+".buttons.table");
		this.tableButton.addButtonToDropdown(LanguagePack.get("sidebar.table.empty"), appearanceName+".buttons.table.dropdown.empty");
		this.tableButton.addButtonToDropdown(LanguagePack.get("sidebar.table.database"), appearanceName+".buttons.table.dropdown.database");
		this.tableButton.addButtonToDropdown(LanguagePack.get("sidebar.table.stats"), appearanceName+".buttons.table.dropdown.stats");
		this.tableButton.adjustContentOfButtonsInDropdownPanel(SwingConstants.LEADING);

		this.competitionButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, LanguagePack.get("sidebar.competition"), frame, appearanceName+".buttons.competition");
		this.competitionButton.addButtonToDropdown(LanguagePack.get("sidebar.competition.empty"), appearanceName+".buttons.competition.dropdown.empty");
		this.competitionButton.addButtonToDropdown(LanguagePack.get("sidebar.competition.database"), appearanceName+".buttons.competition.dropdown.database");
		this.competitionButton.addButtonToDropdown(LanguagePack.get("sidebar.competition.stats"), appearanceName+".buttons.competition.dropdown.stats");
		this.competitionButton.adjustContentOfButtonsInDropdownPanel(SwingConstants.LEADING);

		this.ruleSetsButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, LanguagePack.get("sidebar.ruleSet"), frame, appearanceName+".buttons.ruleSet");
		this.ruleSetsButton.addButtonToDropdown(LanguagePack.get("sidebar.ruleSet.view"), appearanceName+".buttons.ruleSet.dropdown.view");
		this.ruleSetsButton.addButtonToDropdown(LanguagePack.get("sidebar.ruleSet.new"), appearanceName+".buttons.ruleSet.dropdown.add");
		this.ruleSetsButton.addButtonToDropdown(LanguagePack.get("sidebar.ruleSet.delete"), appearanceName+".buttons.ruleSet.dropdown.delete");
		this.ruleSetsButton.addButtonToDropdown(LanguagePack.get("sidebar.ruleSet.modify"), appearanceName+".buttons.ruleSet.dropdown.modify");
		this.ruleSetsButton.adjustContentOfButtonsInDropdownPanel(SwingConstants.LEADING);

		this.settingsButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, LanguagePack.get("sidebar.settings"), frame, appearanceName+".buttons.settings");
		this.settingsButton.addButtonToDropdown(LanguagePack.get("sidebar.settings.appearance"), appearanceName+".buttons.settings.dropdown.appearance");
		this.settingsButton.adjustContentOfButtonsInDropdownPanel(SwingConstants.LEADING);

		this.databaseButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, LanguagePack.get("sidebar.database"), frame, appearanceName+".buttons.database");
		this.databaseButton.addButtonToDropdown(LanguagePack.get("sidebar.database.connect"), appearanceName+".buttons.database.dropdown.connect");
		this.databaseButton.addButtonToDropdown(LanguagePack.get("sidebar.database.manage"), appearanceName+".buttons.database.dropdown.manage");
		this.databaseButton.adjustContentOfButtonsInDropdownPanel(SwingConstants.LEADING);

		// Exit button
		this.exitButton = new XButton(SizeData.W_BUTTON_DIMENSION, LanguagePack.get("sidebar.exit"), frame, appearanceName+".buttons.exit");
		this.exitButton.addActionListener(sc);
		this.exitButton.addMouseListener(sc);
		this.exitButton.setMargin(new Insets(0, SizeData.BUTTON_TEXT_MARGIN, 0, 0));
		this.exitButton.adjustContent(SwingConstants.LEFT);

		// Add the menu buttons to the menu button list
		this.menuButtons.add(this.pouleButton);
		this.menuButtons.add(this.tableButton);
		this.menuButtons.add(this.competitionButton);
		this.menuButtons.add(this.ruleSetsButton);
		this.menuButtons.add(this.settingsButton);
		this.menuButtons.add(this.databaseButton);

		// Implement the controller
		this.menuButtons.forEach(btn -> {
			btn.addMouseListenerToAll(sc);
			btn.addActionListenerToAll(sc);
		});
		this.frame.getCenterPanel().addMouseListener(sc);

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
		this.addComponent(this.separator3);
		// Add the exit button
		this.addComponent(exitButton);
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

	public XButton getExitButton() {
		return this.exitButton;
	}
}
