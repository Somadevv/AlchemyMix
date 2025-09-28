package com.alchemymix.ui.core;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * PanelManager controls which JPanel is currently displayed inside a JFrame.
 * It acts as a central controller that can register and switch between
 * multiple panels (e.g. main menu, options, game screen).
 */
public class PanelManager {
    private String state;

    // The main application window
    private final JFrame window;

    // Stores panels by name
    private final Map<String, JPanel> panels = new HashMap<>();

    // Currently displayed panel
    private JPanel currentPanel;

    /**
     * Creates a PanelManager with an initial state and window setup.
     *
     * @param title        Title of the window
     * @param initialState Initial state/panel name
     * @param width        Window width
     * @param height       Window height
     */
    public PanelManager(String title, String initialState, int width, int height) {
        this.state = initialState;
        this.window = new JFrame(title);
        this.window.setSize(width, height);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setLocationRelativeTo(null);
    }

    /** Makes the window visible. */
    public void showWindow() {
        window.setVisible(true);
    }

    /**
     * Registers a panel with a given name.
     *
     * @param name  Unique identifier for the panel
     * @param panel The JPanel to register
     */
    public void registerPanel(String name, JPanel panel) {
        panels.put(name, panel);
    }

    /**
     * Displays a registered panel by name.
     *
     * @param name The name of the panel to display
     */
    public void displayPanel(String name) {
        JPanel panel = panels.get(name);
        if (panel == null) {
            throw new IllegalArgumentException("No panel registered with name: " + name);
        }

        window.setContentPane(panel);
        window.revalidate();
        window.repaint();

        currentPanel = panel;
        state = name;
    }

    public JPanel getCurrentPanel() {
        return currentPanel;
    }

    public JFrame getWindow() {
        return window;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
