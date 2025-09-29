package com.alchemymix.ui.panels;

import com.alchemymix.ui.manager.PanelManager;

import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {
    private final JCheckBox toggleFullscreen;
    private final JComboBox<String> resolutionDropdown;

    public OptionsPanel(PanelManager manager) {
        setLayout(new BorderLayout(20, 20));

        // Title at top-center
        JLabel title = new JLabel("Options", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 20f));
        add(title, BorderLayout.NORTH);

        // Fullscreen toggle
        toggleFullscreen = new JCheckBox("Fullscreen");
        toggleFullscreen.addActionListener(e -> {
            JFrame window = manager.getWindow();
            if (toggleFullscreen.isSelected()) {
                window.dispose();
                window.setUndecorated(true);
                window.setExtendedState(JFrame.MAXIMIZED_BOTH);
                window.setVisible(true);
            } else {
                window.dispose();
                window.setUndecorated(false);
                window.setExtendedState(JFrame.NORMAL);
                window.setSize(800, 600);
                window.setLocationRelativeTo(null);
                window.setVisible(true);
            }
        });

        // Resolution dropdown
        String[] resolutions = {"1280x720", "1600x900", "1920x1080"};
        resolutionDropdown = new JComboBox<>(resolutions);
        resolutionDropdown.addActionListener(e -> {
            JFrame window = manager.getWindow();
            String selected = (String) resolutionDropdown.getSelectedItem();
            if (selected != null && !toggleFullscreen.isSelected()) {
                String[] dims = selected.split("x");
                int width = Integer.parseInt(dims[0]);
                int height = Integer.parseInt(dims[1]);
                window.setSize(width, height);
                window.setLocationRelativeTo(null);
            }
        });

        // Create quadrants container
        JPanel quadrantsContainer = new JPanel(new GridLayout(2, 2, 10, 10));

        // Quadrant 1: Display settings
        JPanel displaySettings = new JPanel();
        displaySettings.setLayout(new BoxLayout(displaySettings, BoxLayout.Y_AXIS));
        displaySettings.setBorder(BorderFactory.createTitledBorder("Display Settings"));
        displaySettings.add(toggleFullscreen);
        displaySettings.add(Box.createVerticalStrut(10));
        displaySettings.add(new JLabel("Resolution:"));
        displaySettings.add(resolutionDropdown);

        // Quadrant 2: Audio settings (placeholder)
        JPanel audioSettings = new JPanel();
        audioSettings.setLayout(new BoxLayout(audioSettings, BoxLayout.Y_AXIS));
        audioSettings.setBorder(BorderFactory.createTitledBorder("Audio Settings"));

        // Quadrant 3: Controls settings (placeholder)
        JPanel controlsSettings = new JPanel();
        controlsSettings.setLayout(new BoxLayout(controlsSettings, BoxLayout.Y_AXIS));
        controlsSettings.setBorder(BorderFactory.createTitledBorder("Controls Settings"));

        // Quadrant 4: Misc settings (placeholder)
        JPanel miscSettings = new JPanel();
        miscSettings.setLayout(new BoxLayout(miscSettings, BoxLayout.Y_AXIS));
        miscSettings.setBorder(BorderFactory.createTitledBorder("Misc Settings"));

        // Add quadrants to container
        quadrantsContainer.add(displaySettings);
        quadrantsContainer.add(audioSettings);
        quadrantsContainer.add(controlsSettings);
        quadrantsContainer.add(miscSettings);

        add(quadrantsContainer, BorderLayout.CENTER);

        // Back button at bottom
        JButton backButton = new JButton("Go Back");
        backButton.addActionListener(e -> manager.displayPanel("MAIN_MENU"));

        JPanel backButtonContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButtonContainer.add(backButton);
        add(backButtonContainer, BorderLayout.SOUTH);
    }
}
