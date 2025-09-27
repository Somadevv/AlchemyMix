package com.alchemymix.ui.buttons;

import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {
    private final JCheckBox toggleFullscreen;
    private final JButton backButton;

    public OptionsPanel(Runnable onBack) {


        setLayout(new BorderLayout(20, 20));
        // Add title
        add(createTitle(), BorderLayout.NORTH);

        // Add Fullscreen Toggle
        toggleFullscreen = new JCheckBox("Fullscreen");
        add(createFullscreenContainer(), BorderLayout.CENTER);

        // Add Back Button

        backButton = new JButton("Go Back");
        add(createBackButtonContainer(onBack), BorderLayout.SOUTH);

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




