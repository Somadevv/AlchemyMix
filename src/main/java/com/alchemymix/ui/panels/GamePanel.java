package com.alchemymix.ui.panels;

import com.alchemymix.models.Account;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final Account account;

    // ✅ Constructor should take an Account, not PanelManager
    public GamePanel(Account account) {
        this.account = account;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Welcome, " + account.getUsername() + "!");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);

        // Stats panel
        JPanel statsPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        statsPanel.add(new JLabel("Level: " + account.getLevel()));
        statsPanel.add(new JLabel("Health: " + account.getHealth()));
        statsPanel.add(new JLabel("Gold: " + account.getGold()));

        add(statsPanel, BorderLayout.CENTER);
    }
}
