package com.alchemymix.ui.buttons;

import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {
    private final JCheckBox toggleFullscreen;
    private final JButton backButton;
    private final JComboBox<String> resolutionDropdown;
    private final Dimension[] resolutions = {
            new Dimension(1280, 720),
            new Dimension(1600, 900),
            new Dimension(1920, 1080)
    };

    private Rectangle windowedBounds;
    private int previousState = JFrame.NORMAL;

    public OptionsPanel(JFrame frame, Runnable onBack) {
        setLayout(new BorderLayout(20, 20));

        // Title
        add(createTitle(), BorderLayout.NORTH);

        // Toggle Fullscreen Logic
        toggleFullscreen = new JCheckBox("Fullscreen");
        toggleFullscreen.setFont(new Font("Serif", Font.PLAIN, 20));
        toggleFullscreen.addActionListener(e -> toggleFullscreen(frame));

        // Resolution Dropdown Logic
        resolutionDropdown = new JComboBox<>(new String[]{"1280x720", "1600x900", "1920x1080"});
        resolutionDropdown.setFont(new Font("Serif", Font.PLAIN, 20));
        resolutionDropdown.addActionListener(e -> {
            int index = resolutionDropdown.getSelectedIndex();
            if (index >= 0 && index < resolutions.length) {
                Dimension logicalDim = resolutions[index];
                if (toggleFullscreen.isSelected()) {
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                } else {
                    frame.setSize(logicalDim.width, logicalDim.height);
                    frame.setLocationRelativeTo(null);
                }

            }
        });

        // Center panel Creation with
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(createFullscreenContainer());
        centerPanel.add(createResolutionContainer());
        add(centerPanel, BorderLayout.CENTER);


        // Back button at bottom
        backButton = new JButton("Go Back");
        backButton.setFont(new Font("Serif", Font.PLAIN, 20));
        add(createBackButtonContainer(onBack), BorderLayout.SOUTH);
    }

    // Title
    private JLabel createTitle() {
        JLabel title = new JLabel("Options", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 28));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        return title;
    }

    // Fullscreen checkbox container
    private JPanel createFullscreenContainer() {
        JPanel fullscreenContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fullscreenContainer.add(toggleFullscreen);
        return fullscreenContainer;
    }

    // Resolution dropdown container
    private JPanel createResolutionContainer() {
        JPanel resolutionContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel resolutionLabel = new JLabel("Resolution: ");
        resolutionLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        resolutionContainer.add(resolutionLabel);
        resolutionContainer.add(resolutionDropdown);
        return resolutionContainer;
    }

    // Back button container
    private JPanel createBackButtonContainer(Runnable onBack) {
        JPanel backButtonContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButtonContainer.add(backButton);
        backButton.addActionListener(e -> onBack.run());
        return backButtonContainer;
    }

    // Fullscreen toggle
    private void toggleFullscreen(JFrame frame) {
        frame.dispose();

        if (toggleFullscreen.isSelected()) {
            windowedBounds = frame.getBounds();
            previousState = frame.getExtendedState();
            frame.setUndecorated(true);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        } else {
            frame.setUndecorated(false);
            frame.setExtendedState(previousState);
            if (windowedBounds != null) frame.setBounds(windowedBounds);
        }

        frame.setVisible(true);
    }
}
