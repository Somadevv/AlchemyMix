package com.alchemymix.ui.panels;

import com.alchemymix.ui.manager.PanelManager;
import com.alchemymix.ui.widgets.MainMenuButton;
import com.alchemymix.ui.utils.UIHelpers;

import javax.swing.*;
import java.awt.*;

/**
 * Main menu screen with title and navigation buttons.
 */
public class MainMenuPanel extends JPanel {

        public MainMenuPanel(PanelManager manager) {
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

        UIHelpers.addMenuButton(this, "Create Account", "CREATE_ACCOUNT", gbc, manager);
        UIHelpers.addMenuButton(this, "Options", "SHOW_OPTIONS", gbc, manager);
        UIHelpers.addMenuButton(this, "Exit", "EXIT", gbc, manager);
    }

    private void addMenuButton(String label, String panelName, GridBagConstraints gbc, PanelManager manager) {
        MainMenuButton button = new MainMenuButton(label, manager.getWindow());
        button.addActionListener(e -> manager.displayPanel(panelName));
        add(button, gbc);
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
