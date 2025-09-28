package com.alchemymix.ui.panels;

import com.alchemymix.ui.core.PanelManager;

import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {
    private final JCheckBox toggleFullscreen;
    private final JButton backButton;
    private final JComboBox<String> resolutionDropdown;

    public OptionsPanel(PanelManager manager) {
        setLayout(new BorderLayout(20, 20));

        // Add title
        add(createTitle(), BorderLayout.NORTH);

        // Add Fullscreen Toggle
        toggleFullscreen = new JCheckBox("Fullscreen");

        // Add Resolution Dropdown
        String[] resolutions = {"1280x720", "1600x900", "1920x1080"};
        resolutionDropdown = new JComboBox<>(resolutions);

        add(createOptionsContainer(manager), BorderLayout.CENTER);

        // Add Back Button
        backButton = new JButton("Go Back");
        add(createBackButtonContainer(manager), BorderLayout.SOUTH);
    }

    private JLabel createTitle() {
        JLabel title = new JLabel("Options", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 20f));
        return title;
    }

    private JPanel createOptionsContainer(PanelManager manager) {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Fullscreen toggle container
        JPanel fullscreenToggleContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fullscreenToggleContainer.add(toggleFullscreen);
        container.add(fullscreenToggleContainer);

        // Resolution dropdown container
        JPanel resolutionContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resolutionContainer.add(new JLabel("Resolution:"));
        resolutionContainer.add(resolutionDropdown);
        container.add(resolutionContainer);

        // Add functionality
        toggleFullscreen.addActionListener(e -> {
            JFrame window = manager.getWindow();
            if (toggleFullscreen.isSelected()) {
                // Enable fullscreen
                window.dispose();
                window.setUndecorated(true);
                window.setExtendedState(JFrame.MAXIMIZED_BOTH);
                window.setVisible(true);
            } else {
                // Exit fullscreen
                window.dispose();
                window.setUndecorated(false);
                window.setExtendedState(JFrame.NORMAL);
                window.setSize(800, 600);
                window.setLocationRelativeTo(null);
                window.setVisible(true);
            }
        });

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

        return container;
    }

    private JPanel createBackButtonContainer(PanelManager manager) {
        JPanel backButtonContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButtonContainer.add(backButton);

        backButton.addActionListener(e -> manager.displayPanel("MAIN_MENU"));

        return backButtonContainer;
    }
}
