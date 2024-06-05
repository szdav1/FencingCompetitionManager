package com._4th_dimension_software.app.view.components.built.ui.sidebar;

import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;

import com._4th_dimension_software.app.control.sidebar.SidebarController;
import com._4th_dimension_software.app.view.components.base.button.XButton;
import com._4th_dimension_software.app.view.components.base.label.XLabel;
import com._4th_dimension_software.app.view.components.base.panel.XPanel;
import com._4th_dimension_software.app.view.components.built.ui.separator.Separator;
import com._4th_dimension_software.app.view.components.built.ui.sidebar.menu.MenuButton;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.consts.RelativePositions;
import com._4th_dimension_software.support.lang.Language;

/**
 * The <code>Sidebar</code> class contains the declaration of
 * everything that is in the sidebar of the application. Actions
 * happening in the sidebar are handled in this class,
 * buttons displayed in the sidebar are controlled by this class
 * etc.
 *
 * @author szd
 */
public final class Sidebar extends XPanel {
	// List of the buttons
	private final List<MenuButton> menuButtons;
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

		// Header
		// Header
		XLabel header = new XLabel(SizeData.W_BUTTON_DIMENSION, Language.get("sidebar.header"), frame, appearanceName+".header");
		header.centerContent();

		// Separators
		// Separators
		Separator separator1 = new Separator(SizeData.SEPARATOR_DIMENSION, appearanceName+".separator");
		Separator separator2 = new Separator(SizeData.SEPARATOR_DIMENSION, appearanceName+".separator");
		Separator separator3 = new Separator(SizeData.SEPARATOR_DIMENSION, appearanceName+".separator");

		// Menu buttons
		// Menu buttons
		MenuButton pouleButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, Language.get("sidebar.poule"), frame, appearanceName+".buttons.poule");
		pouleButton.addButtonToDropdown(Language.get("sidebar.poule.empty"), "F1", appearanceName+".buttons.poule.dropdown.empty");
		pouleButton.addButtonToDropdown(Language.get("sidebar.poule.database"), "F2", appearanceName+".buttons.poule.dropdown.database");
		pouleButton.addButtonToDropdown(Language.get("sidebar.poule.stats"), "F3", appearanceName+".buttons.poule.dropdown.stats");
		pouleButton.adjustContentOfButtonsInDropdownPanel(SwingConstants.LEFT);

		MenuButton tableButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, Language.get("sidebar.table"), frame, appearanceName+".buttons.table");
		tableButton.addButtonToDropdown(Language.get("sidebar.table.empty"), "F4", appearanceName+".buttons.table.dropdown.empty");
		tableButton.addButtonToDropdown(Language.get("sidebar.table.database"), "F5", appearanceName+".buttons.table.dropdown.database");
		tableButton.addButtonToDropdown(Language.get("sidebar.table.stats"), "F6", appearanceName+".buttons.table.dropdown.stats");
		tableButton.adjustContentOfButtonsInDropdownPanel(SwingConstants.LEFT);

		MenuButton competitionButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, Language.get("sidebar.competition"), frame, appearanceName+".buttons.competition");
		competitionButton.addButtonToDropdown(Language.get("sidebar.competition.empty"), "F7", appearanceName+".buttons.competition.dropdown.empty");
		competitionButton.addButtonToDropdown(Language.get("sidebar.competition.database"), "F8", appearanceName+".buttons.competition.dropdown.database");
		competitionButton.addButtonToDropdown(Language.get("sidebar.competition.stats"), "F9", appearanceName+".buttons.competition.dropdown.stats");
		competitionButton.adjustContentOfButtonsInDropdownPanel(SwingConstants.LEFT);

		MenuButton ruleSetsButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, Language.get("sidebar.ruleSet"), frame, appearanceName+".buttons.ruleSet");
		ruleSetsButton.addButtonToDropdown(Language.get("sidebar.ruleSet.view"), "V", appearanceName+".buttons.ruleSet.dropdown.view");
		ruleSetsButton.addButtonToDropdown(Language.get("sidebar.ruleSet.new"), "N", appearanceName+".buttons.ruleSet.dropdown.add");
		ruleSetsButton.addButtonToDropdown(Language.get("sidebar.ruleSet.delete"), "D", appearanceName+".buttons.ruleSet.dropdown.delete");
		ruleSetsButton.addButtonToDropdown(Language.get("sidebar.ruleSet.modify"), "M", appearanceName+".buttons.ruleSet.dropdown.modify");
		ruleSetsButton.adjustContentOfButtonsInDropdownPanel(SwingConstants.LEFT);

		MenuButton settingsButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, Language.get("sidebar.settings"), frame, appearanceName+".buttons.settings");
		settingsButton.addButtonToDropdown(Language.get("sidebar.settings.interface"), "I", appearanceName+".buttons.settings.dropdown.appearance");
		settingsButton.addButtonToDropdown(Language.get("sidebar.settings.language"), "L", appearanceName+".buttons.settings.dropdown.language");
		settingsButton.adjustContentOfButtonsInDropdownPanel(SwingConstants.LEFT);

		MenuButton databaseButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, Language.get("sidebar.database"), frame, appearanceName+".buttons.database");
		databaseButton.addButtonToDropdown(Language.get("sidebar.database.connect"), "C", appearanceName+".buttons.database.dropdown.connect");
		databaseButton.adjustContentOfButtonsInDropdownPanel(SwingConstants.LEFT);

		// Exit button
		this.exitButton = new XButton(SizeData.W_BUTTON_DIMENSION, Language.get("sidebar.exit"), "Esc", frame, appearanceName+".buttons.exit");
		this.exitButton.setMargin(new Insets(0, SizeData.TEXT_MARGIN, 0, 0));
		this.exitButton.adjustContent(SwingConstants.LEFT);

		// Add the menu buttons to the menu button list
		this.menuButtons.add(pouleButton);
		this.menuButtons.add(tableButton);
		this.menuButtons.add(competitionButton);
		this.menuButtons.add(ruleSetsButton);
		this.menuButtons.add(settingsButton);
		this.menuButtons.add(databaseButton);

		// The controller that takes care of the actions happened in the sidebar
		final SidebarController sc = new SidebarController(this);

		// Implement the controller
		this.menuButtons.forEach(btn -> {
			btn.addMouseListenerToAll(sc);
			btn.addActionListenerToAll(sc);
		});
		this.exitButton.addActionListener(sc);
		this.exitButton.addMouseListener(sc);
		this.frame.getCenterPanel().addMouseListener(sc);

		// Add the header to the sidebar
		this.addComponent(header);
		// Add the separator to the sidebar
		this.addComponent(separator1);

		// Add the menu buttons to the sidebar
		for (int i = 0; i < this.menuButtons.size(); i++) {
			this.addComponent(this.menuButtons.get(i));

			if (i == 2)
				this.addComponent(separator2);
		}
		this.addComponent(separator3);
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
