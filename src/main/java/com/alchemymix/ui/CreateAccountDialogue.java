package com.alchemymix.ui;

import com.alchemymix.account.AccountCreationResult;
import com.alchemymix.model.Account;
import com.alchemymix.service.AccountManager;

import javax.swing.*;
import java.awt.*;

public class CreateAccountDialogue extends JDialog {
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JLabel errorLabel;
    private final JButton createButton;
    private final JButton cancelButton;

    private Account createdAccount;

    public CreateAccountDialogue(JFrame parent) {
        super(parent, "Create Account", true); // modal
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(parent);

        // ---- Layout ----
        setLayout(new BorderLayout(10, 10));
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Username
        formPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        formPanel.add(usernameField);

        // Password
        formPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        formPanel.add(passwordField);

        add(formPanel, BorderLayout.CENTER);

        // Error label (inline feedback)
        errorLabel = new JLabel(" ");
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        errorLabel.setForeground(Color.RED);
        add(errorLabel, BorderLayout.NORTH);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        createButton = new JButton("Create");
        cancelButton = new JButton("Cancel");
        buttonPanel.add(cancelButton);
        buttonPanel.add(createButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // --- Actions ---
        createButton.addActionListener(e -> handleCreate());
        cancelButton.addActionListener(e -> {
            createdAccount = null;
            dispose();
        });

        // ENTER = Create, ESC = Cancel
        getRootPane().setDefaultButton(createButton);
        getRootPane().registerKeyboardAction(
                e -> dispose(),
                KeyStroke.getKeyStroke("ESCAPE"),
                JComponent.WHEN_IN_FOCUSED_WINDOW
        );
    }

    private void handleCreate() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        errorLabel.setForeground(Color.RED); // reset to red by default

        AccountCreationResult result = AccountManager.createAccount(username, password);

        switch (result.getStatus()) {
            case SUCCESS -> {
                // Success: inline green message
                errorLabel.setForeground(new Color(0, 128, 0));
                errorLabel.setText("✅ " + result.getMessage());
                createdAccount = result.getAccount();

                createButton.setEnabled(false);
                cancelButton.setEnabled(false);

                // Auto-close after short delay
                new javax.swing.Timer(1000, ev -> dispose()).start();
            }
            case ALREADY_EXISTS, INVALID_INPUT, IO_ERROR -> {
                errorLabel.setText("⚠ " + result.getMessage());
                clearInputs();
            }
        }
    }

    private void clearInputs() {
        usernameField.setText("");
        passwordField.setText("");
        usernameField.requestFocusInWindow();
    }

    public Account showDialogAndGetAccount() {
        setVisible(true); // blocks until dialog closes
        return createdAccount;
    }
}
