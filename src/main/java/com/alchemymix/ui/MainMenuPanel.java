package com.alchemymix.ui;

import com.alchemymix.ui.buttons.MainMenuButton;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {

    public MainMenuPanel(JFrame parentFrame, Runnable onStart, Runnable onOptions, Runnable onExit) {
        setLayout(new GridBagLayout());
        setBackground(Color.BLACK);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;

        // Title
        JLabel title = new JLabel("AlchemyMix");
        title.setFont(new Font("Serif", Font.BOLD, 32));
        title.setForeground(Color.WHITE);
        add(title, gbc);


        // Create Account
        MainMenuButton startButton = new MainMenuButton("Create Account", parentFrame);
        startButton.addActionListener(e -> onStart.run());
        add(startButton, gbc);

        MainMenuButton optionsButton = new MainMenuButton("Options", parentFrame);
        optionsButton.addActionListener(e -> onOptions.run());
        add(optionsButton, gbc);

        MainMenuButton exitButton = new MainMenuButton("Exit", parentFrame);
        exitButton.addActionListener(e -> onExit.run());
        add(exitButton, gbc);

    }
}
