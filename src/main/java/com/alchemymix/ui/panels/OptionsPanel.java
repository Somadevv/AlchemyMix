package com.alchemymix.ui.panels;

import com.alchemymix.ui.core.PanelManager;

import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {
    private final JCheckBox toggleFullscreen;
    private final JButton backButton;

    public OptionsPanel(PanelManager manager) {
        setLayout(new BorderLayout(20, 20));

        // Add title
        add(createTitle(), BorderLayout.NORTH);

        // Add Fullscreen Toggle
        toggleFullscreen = new JCheckBox("Fullscreen");
        add(createFullscreenContainer(), BorderLayout.CENTER);

        // Add Back Button
        backButton = new JButton("Go Back");
        add(createBackButtonContainer(manager), BorderLayout.SOUTH);
    }

    private JLabel createTitle() {
        JLabel title = new JLabel("Options", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 20f)); // make it look nicer
        return title;
    }

    private JPanel createFullscreenContainer() {
        JPanel fullscreenToggleContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fullscreenToggleContainer.add(toggleFullscreen);
        return fullscreenToggleContainer;
    }

    private JPanel createBackButtonContainer(PanelManager manager) {
        JPanel backButtonContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButtonContainer.add(backButton);

        // Action -> return to MAIN_MENU
        backButton.addActionListener(e -> manager.displayPanel("MAIN_MENU"));

        return backButtonContainer;
    }
}
