package com.alchemymix.ui.panels;

import com.alchemymix.models.Account;
import com.alchemymix.service.AccountManager;
import com.alchemymix.account.AccountCreationResult;
import com.alchemymix.ui.core.PanelManager;

import javax.swing.*;
import java.awt.*;

public class CreateAccountPanel extends JPanel {
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JLabel errorLabel;
    private final JButton createButton;
    private final JButton cancelButton;

    private final PanelManager manager; // keep a reference

    public CreateAccountPanel(PanelManager manager) {
        this.manager = manager; // save reference to use in handleCreate

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        // Form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(15);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);

        // Username row
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(usernameField, gbc);

        // Password row
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        formPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(passwordField, gbc);

        add(formPanel, BorderLayout.CENTER);

        // Error label
        errorLabel = new JLabel(" ");
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        errorLabel.setForeground(Color.RED);
        add(errorLabel, BorderLayout.NORTH);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        createButton = new JButton("Create");
        cancelButton = new JButton("Cancel");

        buttonPanel.add(cancelButton);
        buttonPanel.add(createButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Actions
        createButton.addActionListener(e -> handleCreate());
        cancelButton.addActionListener(e -> manager.displayPanel("MAIN_MENU"));
    }

    private void handleCreate() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        AccountCreationResult result = AccountManager.createAccount(username, password);

        switch (result.getStatus()) {
            case SUCCESS -> {
                errorLabel.setText("✔" + result.getMessage());
                // Add loading effect
                errorLabel.setForeground(new Color(0, 128, 0)); // green

                Account createdAccount = result.getAccount();
                // Register a GamePanel for this account
                manager.registerPanel("GAME", new GamePanel(createdAccount));
                // Switch to the game screen
                manager.displayPanel("GAME");
            }
            case ALREADY_EXISTS, INVALID_INPUT, IO_ERROR -> {
                errorLabel.setText("⚠ " + result.getMessage());
                errorLabel.setForeground(Color.RED);
            }
        }
    }
}
