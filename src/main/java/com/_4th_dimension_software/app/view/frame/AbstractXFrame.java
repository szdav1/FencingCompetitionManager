package com._4th_dimension_software.app.view.frame;

import com._4th_dimension_software.app.view.interfaces.XContainer;
import com._4th_dimension_software.support.appdata.SizeData;
import com._4th_dimension_software.support.consts.FrameState;
import com._4th_dimension_software.support.theme.Appearance;
import com._4th_dimension_software.support.theme.Appearances;

import javax.swing.JFrame;

/**
 * The <code>AbstractXFrame</code> abstract class defines the abstract
 * behaviour of a frame inside the application. It defines the constructor
 * of the frame, which holds the basic setup of a <code>JFrame</code>.
 *
 * @author szd
 */
public abstract class AbstractXFrame extends JFrame implements XContainer {
    protected Appearance appearance;
    protected FrameState frameState;

    /**
     * Defines the constructor of the frame of the application that
     * does the basic <code>JFrame</code> setup in order to make the
     * frame appear and work properly.
     *
     * @param title          The title of the frame
     * @param appearanceName The name of the Appearance that's
     *                       values should be implemented on the frame
     */
    protected AbstractXFrame(String title, String appearanceName) {
        this.appearance = Appearances.get(appearanceName);
        this.frameState = FrameState.NORMAL;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(this.appearance.getIcon1() == null ? null : this.appearance.getIcon1().getImage());
        this.setTitle(title);
        this.setUndecorated(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(SizeData.SCREEN_WIDTH, SizeData.SCREEN_HEIGHT);
        this.setLocationRelativeTo(null);
    }

    public FrameState getFrameState() {
        return this.frameState;
    }

    public void setFrameState(FrameState frameState) {
        this.frameState = frameState;
    }
}
