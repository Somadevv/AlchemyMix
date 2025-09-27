package com.alchemymix.ui;

import com.alchemymix.Main;
import com.alchemymix.ui.buttons.MainMenuButton;

import javax.swing.*;
import java.awt.*;

/**
 * Main menu screen with title and navigation buttons.
 */
public class MainMenuPanel extends JPanel {

        public MainMenuPanel(JFrame parentFrame, Runnable onCreateAccount, Runnable showOptions, Runnable onExit) {

        setLayout(new GridBagLayout());
        setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.CENTER;

        // Title
        JLabel title = new JLabel("AlchemyMix");
        title.setFont(new Font("Serif", Font.BOLD, 42));
        title.setForeground(Color.WHITE);
        add(title, gbc);

        // Spacer
        gbc.insets = new Insets(40, 10, 10, 10);

        MainMenuButton createBtn = new MainMenuButton("Create Account", parentFrame);
        createBtn.addActionListener(e -> onCreateAccount.run());
        add(createBtn, gbc);

        MainMenuButton optionsButton = new MainMenuButton("Options", parentFrame);
        optionsButton.addActionListener(e -> showOptions.run());
        add(optionsButton, gbc);

        MainMenuButton exitBtn = new MainMenuButton("Exit", parentFrame);
        exitBtn.addActionListener(e -> onExit.run());
        add(exitBtn, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int w = getWidth();
        int h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, new Color(20, 20, 20),
                0, h, new Color(60, 60, 60));
        g2.setPaint(gp);
        g2.fillRect(0, 0, w, h);
    }
}
