package com._4th_dimension_software.app.view.components.specific.ui.sidebar;

import com._4th_dimension_software.app.control.sidebar.SidebarController;
import com._4th_dimension_software.app.view.components.base.button.XButton;
import com._4th_dimension_software.app.view.components.base.label.XLabel;
import com._4th_dimension_software.app.view.components.base.panel.XPanel;
import com._4th_dimension_software.app.view.components.specific.separator.Separator;
import com._4th_dimension_software.app.view.components.specific.ui.sidebar.menu.MenuButton;
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

		// Header
		this.header = new XLabel(SizeData.W_BUTTON_DIMENSION, LanguagePack.get("sidebar.header"), frame, appearanceName+".header");
		this.header.centerContent();

		// Separators
		this.separator1 = new Separator(SizeData.SEPARATOR_DIMENSION, appearanceName+".separator");
		this.separator2 = new Separator(SizeData.SEPARATOR_DIMENSION, appearanceName+".separator");
		this.separator3 = new Separator(SizeData.SEPARATOR_DIMENSION, appearanceName+".separator");

		// Menu buttons
		this.pouleButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, LanguagePack.get("sidebar.poule"), frame, appearanceName+".buttons.poule");
		this.pouleButton.addButtonToDropdown(LanguagePack.get("sidebar.poule.empty"), "[F1]", appearanceName+".buttons.poule.dropdown.empty");
		this.pouleButton.addButtonToDropdown(LanguagePack.get("sidebar.poule.database"), "[F2]", appearanceName+".buttons.poule.dropdown.database");
		this.pouleButton.addButtonToDropdown(LanguagePack.get("sidebar.poule.stats"), "[F3]", appearanceName+".buttons.poule.dropdown.stats");
		this.pouleButton.adjustContentOfButtonsInDropdownPanel(SwingConstants.LEFT);

		this.tableButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, LanguagePack.get("sidebar.table"), frame, appearanceName+".buttons.table");
		this.tableButton.addButtonToDropdown(LanguagePack.get("sidebar.table.empty"), "[F4]", appearanceName+".buttons.table.dropdown.empty");
		this.tableButton.addButtonToDropdown(LanguagePack.get("sidebar.table.database"), "[F5]", appearanceName+".buttons.table.dropdown.database");
		this.tableButton.addButtonToDropdown(LanguagePack.get("sidebar.table.stats"), "[F6]", appearanceName+".buttons.table.dropdown.stats");
		this.tableButton.adjustContentOfButtonsInDropdownPanel(SwingConstants.LEFT);

		this.competitionButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, LanguagePack.get("sidebar.competition"), frame, appearanceName+".buttons.competition");
		this.competitionButton.addButtonToDropdown(LanguagePack.get("sidebar.competition.empty"), "[F7]", appearanceName+".buttons.competition.dropdown.empty");
		this.competitionButton.addButtonToDropdown(LanguagePack.get("sidebar.competition.database"), "[F8]", appearanceName+".buttons.competition.dropdown.database");
		this.competitionButton.addButtonToDropdown(LanguagePack.get("sidebar.competition.stats"), "[F9]", appearanceName+".buttons.competition.dropdown.stats");
		this.competitionButton.adjustContentOfButtonsInDropdownPanel(SwingConstants.LEFT);

		this.ruleSetsButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, LanguagePack.get("sidebar.ruleSet"), frame, appearanceName+".buttons.ruleSet");
		this.ruleSetsButton.addButtonToDropdown(LanguagePack.get("sidebar.ruleSet.view"), "[F10]", appearanceName+".buttons.ruleSet.dropdown.view");
		this.ruleSetsButton.addButtonToDropdown(LanguagePack.get("sidebar.ruleSet.new"), "[F11]", appearanceName+".buttons.ruleSet.dropdown.add");
		this.ruleSetsButton.addButtonToDropdown(LanguagePack.get("sidebar.ruleSet.delete"), "[F12]", appearanceName+".buttons.ruleSet.dropdown.delete");
		this.ruleSetsButton.addButtonToDropdown(LanguagePack.get("sidebar.ruleSet.modify"), "[M]", appearanceName+".buttons.ruleSet.dropdown.modify");
		this.ruleSetsButton.adjustContentOfButtonsInDropdownPanel(SwingConstants.LEFT);

		this.settingsButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, LanguagePack.get("sidebar.settings"), frame, appearanceName+".buttons.settings");
		this.settingsButton.addButtonToDropdown(LanguagePack.get("sidebar.settings.interface"), "[I]", appearanceName+".buttons.settings.dropdown.appearance");
		this.settingsButton.addButtonToDropdown(LanguagePack.get("sidebar.settings.language"), "[L]", appearanceName+".buttons.settings.dropdown.language");
		this.settingsButton.adjustContentOfButtonsInDropdownPanel(SwingConstants.LEFT);

		this.databaseButton = new MenuButton(SizeData.W_BUTTON_DIMENSION, LanguagePack.get("sidebar.database"), frame, appearanceName+".buttons.database");
		this.databaseButton.addButtonToDropdown(LanguagePack.get("sidebar.database.connect"), "[C]", appearanceName+".buttons.database.dropdown.connect");
		this.databaseButton.addButtonToDropdown(LanguagePack.get("sidebar.database.arrange"), "[A]", appearanceName+".buttons.database.dropdown.manage");
		this.databaseButton.adjustContentOfButtonsInDropdownPanel(SwingConstants.LEFT);

		// Exit button
		this.exitButton = new XButton(SizeData.W_BUTTON_DIMENSION, LanguagePack.get("sidebar.exit"), "[Esc]", frame, appearanceName+".buttons.exit");
		this.exitButton.setMargin(new Insets(0, SizeData.BUTTON_TEXT_MARGIN, 0, 0));
		this.exitButton.adjustContent(SwingConstants.LEFT);

		// Add the menu buttons to the menu button list
		this.menuButtons.add(this.pouleButton);
		this.menuButtons.add(this.tableButton);
		this.menuButtons.add(this.competitionButton);
		this.menuButtons.add(this.ruleSetsButton);
		this.menuButtons.add(this.settingsButton);
		this.menuButtons.add(this.databaseButton);

		// The listener that takes care of the mouse actions happened in the sidebar
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
