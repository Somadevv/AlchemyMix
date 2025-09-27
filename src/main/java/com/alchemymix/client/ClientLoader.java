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
        // TODO: implement login flow
    }

    // Create Account (loop until success or cancel)
    private void createAccount() {
        while (true) {
            // Step 1: Ask for username
            String username = JOptionPane.showInputDialog(frame, "Enter Username:");
            if (username == null || username.isBlank()) return; // user canceled

            username = username.trim();

            // Step 2: Check if username exists
            if (AccountManager.accountExists(username)) {
                JOptionPane.showMessageDialog(
                        frame,
                        "That username is already taken. Please choose another.",
                        "Username Taken",
                        JOptionPane.ERROR_MESSAGE
                );
                continue; // back to Step 1
            }

            // Step 3: Username is free → ask for password
            String password = JOptionPane.showInputDialog(frame, "Enter Password:");
            if (password == null || password.isBlank()) return; // user canceled

            // Step 4: Save account
            Account newAccount = new Account(username, password);

            try {
                AccountManager.createAccount(newAccount);
                JOptionPane.showMessageDialog(frame, "Account created for " + username + "!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, "Error saving account: " + e.getMessage());
            }

            break; // success → exit loop
        }
    }

    private void exitGame() {
        frame.dispose();
    }
}
