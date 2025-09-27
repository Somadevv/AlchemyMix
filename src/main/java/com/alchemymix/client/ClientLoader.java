package com.alchemymix.client;

import com.alchemymix.ui.MainMenuPanel;

import javax.swing.*;

public class ClientLoader {

    private static final String CLIENT_NAME = "AlchemyMix";
    private static final int CLIENT_WIDTH = 600;
    private static final int CLIENT_HEIGHT = 500;

    private JFrame frame;

    // Entry point
    public void launch() {
        SwingUtilities.invokeLater(this::createAndShowGUI);
    }

    // Setup frame and show the main menu
    private void createAndShowGUI() {
        frame = new JFrame(CLIENT_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(CLIENT_WIDTH, CLIENT_HEIGHT);
        frame.setLocationRelativeTo(null);

        // Show main menu panel
        showMainMenu();

        frame.setVisible(true);
    }

    // Swap to main menu
    private void showMainMenu() {
        MainMenuPanel menu = new MainMenuPanel(
                frame,
                this::startGame,
                this::showOptions,
                this::exitGame
        );
        frame.setContentPane(menu);
        frame.revalidate();
    }

    // Placeholder: later will load your game screen
    private void startGame() {
        JPanel gamePanel = new JPanel();
        gamePanel.add(new JLabel("Game started!"));

        frame.setContentPane(gamePanel);
        frame.revalidate();
    }

    private void showOptions() {
        JPanel optionsPanel = new JPanel();
        optionsPanel.add(new JLabel("Options go here:"));

        frame.setContentPane(optionsPanel);
        frame.revalidate();
    }

    private void exitGame() {
        frame.dispose();
    }
}
