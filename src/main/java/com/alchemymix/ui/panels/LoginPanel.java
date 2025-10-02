package com.alchemymix.ui.panels;

import com.alchemymix.ui.core.PanelManager;
import com.alchemymix.ui.util.UIHelpers;
import com.alchemymix.ui.widgets.MainMenuButton;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    public  LoginPanel(PanelManager manager) {
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
        UIHelpers.addMenuButton(this, "Exit", "EXIT", gbc, manager);
    }
}
