package com._4th_dimension_software.app.view.components.built.panels.expandable;

import java.awt.BorderLayout;
import java.awt.Dimension;

import com._4th_dimension_software.app.view.components.base.panel.XPanel;
import com._4th_dimension_software.app.view.components.base.scrollpanel.XScrollPanel;
import com._4th_dimension_software.app.view.frame.XFrame;
import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.consts.PositionConstants;

/**
 * The <code>ExpandablePanel</code> class is a subclass
 * of the <code>XPanel</code> custom panel class. As the
 * name implies, it provides a folding functionality.
 */
public class ExpandablePanel extends XPanel {
	private boolean expanded;
	private final Dimension dimension;
	protected final XPanel headerPanel;
	protected final XPanel centerPanel;
	private final ExpandButton expandButton;
	private XScrollPanel scrollPanel;

	/**
	 * Constructs an <code>ExpandablePanel</code> object using
	 * the specified dimension and the appearance that's name
	 * was given.
	 *
	 * @param dimension      The Dimension of the panel
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that's values
	 *                       should be implemented on this component
	 */
	public ExpandablePanel(Dimension dimension, final XFrame frame, String appearanceName) {
		super(dimension, new BorderLayout(), frame, appearanceName);

		this.expanded = true;
		this.dimension = dimension;

		this.headerPanel = new XPanel(new Dimension(this.getWidth(), SizeData.BUTTON_HEIGHT), null, frame, appearanceName+".panel");
		this.centerPanel = new XPanel(new Dimension(this.getWidth(), this.getHeight()-SizeData.BUTTON_HEIGHT), frame, appearanceName+".panel");

		this.expandButton = new ExpandButton(this.getWidth()-SizeData.N_BUTTON_WIDTH, 0, SizeData.N_BUTTON_WIDTH, SizeData.BUTTON_HEIGHT, "", frame, appearanceName+".button");
		this.expandButton.addActionListener(e -> {
			if (this.expandButton.equals(e.getSource())) {
				if (this.expanded)
					this.fold();

				else
					this.expand();

				this.expanded = !this.expanded;

				if (this.scrollPanel != null)
					this.scrollPanel.revalidate();
			}
		});

		this.headerPanel.addComponent(this.expandButton);

		this.addComponent(this.headerPanel, PositionConstants.TOP_POSITION);
		this.addComponent(this.centerPanel, PositionConstants.CENTER_POSITION);
	}

	/**
	 * Constructs an <code>ExpandablePanel</code> object using
	 * the specified x, y, width and height values and the
	 * appearance that's name was given.
	 *
	 * @param x              The X coordinate of the panel in no-layout manager space
	 * @param y              The Y coordinate of the panel in no-layout manager space
	 * @param width          The width of the panel in no-layout manager space
	 * @param height         The height of the panel in no-layout manager space
	 * @param frame          The main frame of the application
	 * @param appearanceName The name of the Appearance that's values
	 *                       should be implemented on this component
	 */
	public ExpandablePanel(int x, int y, int width, int height, final XFrame frame, String appearanceName) {
		super(x, y, width, height, new BorderLayout(), frame, appearanceName);

		this.expanded = true;
		this.dimension = new Dimension(width, height);

		this.headerPanel = new XPanel(new Dimension(this.getWidth(), SizeData.BUTTON_HEIGHT), null, frame, appearanceName+".panel");
		this.centerPanel = new XPanel(new Dimension(this.getWidth(), this.getHeight()-SizeData.BUTTON_HEIGHT), frame, appearanceName+".panel");

		this.expandButton = new ExpandButton(this.getWidth()-SizeData.N_BUTTON_WIDTH, 0, SizeData.N_BUTTON_WIDTH, SizeData.BUTTON_HEIGHT, "", frame, appearanceName+".button");
		this.expandButton.addActionListener(e -> {
			if (this.expandButton.equals(e.getSource())) {
				if (this.expanded)
					this.fold();

				else
					this.expand();

				this.expanded = !this.expanded;

				if (this.scrollPanel != null)
					this.scrollPanel.revalidate();
			}
		});

		this.headerPanel.addComponent(this.expandButton);

		this.addComponent(this.headerPanel, PositionConstants.TOP_POSITION);
		this.addComponent(this.centerPanel, PositionConstants.CENTER_POSITION);
	}

	/**
	 * Makes the panel folded by default.
	 */
	public void setFoldedByDefault() {
		this.expanded = false;
		this.expandButton.setExpanded(true);
		this.fold();
	}

	/**
	 * Expands the panel.
	 */
	private void expand() {
		this.setSize(this.dimension.width, this.dimension.height);
		this.setPreferredSize(this.dimension);
		this.repaintFrame();
	}

	/**
	 * Folds the panel.
	 */
	private void fold() {
		this.setSize(this.dimension.width, SizeData.BUTTON_HEIGHT);
		this.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		this.repaintFrame();
	}

	public void setScrollPanel(XScrollPanel scrollPanel) {
		this.scrollPanel = scrollPanel;
	}
}