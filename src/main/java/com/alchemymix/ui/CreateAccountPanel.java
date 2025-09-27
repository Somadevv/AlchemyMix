package com.alchemymix.ui;


import javax.swing.*;
import java.awt.*;

public class CreateAccountPanel extends JPanel {

    public CreateAccountPanel(JFrame parentFrame) {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;

        // Title
        JLabel titleLabel = new JLabel("Create Account");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(titleLabel, gbc);
    }
}
