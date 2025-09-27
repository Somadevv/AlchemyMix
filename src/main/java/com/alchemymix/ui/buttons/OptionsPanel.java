package com.alchemymix.ui.buttons;

import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {
    private final JCheckBox toggleFullscreen;
    private final JButton backButton;

    public OptionsPanel(JFrame frame, Runnable onBack) {


        setLayout(new BorderLayout(20, 20));
        // Add title
        add(createTitle(), BorderLayout.NORTH);

        // Add Fullscreen Toggle
        toggleFullscreen = new JCheckBox("Fullscreen");
        add(createFullscreenContainer(), BorderLayout.CENTER);

        // Add Back Button

        backButton = new JButton("Go Back");
        add(createBackButtonContainer(onBack), BorderLayout.SOUTH);

        toggleFullscreen.addActionListener(e -> toggleFullscreen(frame));

    }


    private void toggleFullscreen(JFrame frame) {
        if (toggleFullscreen.isSelected()) {
            frame.dispose();
            frame.setUndecorated(true);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        } else {
            frame.dispose();
            frame.setUndecorated(false);
            frame.setExtendedState(JFrame.NORMAL);
            frame.setVisible(true);
            frame.setSize(600, 500);
        }
    }

    private JLabel createTitle() {
        return new JLabel("Options", SwingConstants.CENTER);
    }

    private JPanel createFullscreenContainer() {
        JPanel fullscreenToggleContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fullscreenToggleContainer.add(toggleFullscreen);
        return fullscreenToggleContainer;
    }

    //  Back Button
    private JPanel createBackButtonContainer(Runnable onBack) {
        JPanel backButtonContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButtonContainer.add(backButton);
        //  Action
        backButton.addActionListener(e -> onBack.run());
        return backButtonContainer;
    }
}




