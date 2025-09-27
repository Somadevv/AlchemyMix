package com.alchemymix.client;

import com.alchemymix.model.Account;
import com.alchemymix.ui.CreateAccountDialogue;
import com.alchemymix.ui.MainMenuPanel;
import com.alchemymix.ui.buttons.OptionsPanel;

import javax.swing.*;
import java.io.IOException ;

public class ClientLoader {
    private static final String CLIENT_NAME = "AlchemyMix";
    private static final int CLIENT_WIDTH = 700;
    private static final int CLIENT_HEIGHT = 500;

    private JFrame frame;

    public void launch() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(this::drawMainMenu);
    }

    private void drawMainMenu() {
        frame = new JFrame(CLIENT_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(CLIENT_WIDTH, CLIENT_HEIGHT);
        frame.setLocationRelativeTo(null);

        // Main menu
        displayMainMenu();

        frame.setVisible(true);
    }

    private void displayMainMenu() {
        MainMenuPanel menu = new MainMenuPanel(
                frame,
                this::createAccount,
                this::showOptions,
                this::exitGame
        );
        frame.setContentPane(menu);
        frame.revalidate();
    }

    private void createAccount() {
        CreateAccountDialogue dialog = new CreateAccountDialogue(frame);
        Account created = dialog.showDialogAndGetAccount();

        if (created != null) {
            JOptionPane.showMessageDialog(frame,
                    "Welcome, " + created.getUsername() + "!",
                    "Account Created",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void showOptions() {
        OptionsPanel optionsPanel = new OptionsPanel(this::displayMainMenu);
        frame.setContentPane(optionsPanel);
        frame.revalidate();
    }


    private void exitGame() {
        System.out.println("Exiting game...");
        System.exit(0);
    }
}
