package com.alchemymix.client;

import com.alchemymix.model.Account;
import com.alchemymix.service.AccountManager;
import com.alchemymix.ui.MainMenuPanel;

import javax.swing.*;
import java.io.IOException;

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
                this::createAccount,
                this::exitGame
        );
        frame.setContentPane(menu);
        frame.revalidate();
    }
    private void login() {

    };
    // Create Account
    private void createAccount() {
        String username = JOptionPane.showInputDialog(frame, "Enter Username:");
        if (username == null || username.isBlank()) return;

        String password = JOptionPane.showInputDialog(frame, "Enter Password:");
        if (password == null || password.isBlank()) return;

        Account newAccount = new Account(username, password);

        try {
            AccountManager.saveAccount(newAccount);
            JOptionPane.showMessageDialog(frame, "Account created for " + username + "!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saving account: " + e.getMessage());
        }
    }

    private void exitGame() {
        frame.dispose();
    }
}
