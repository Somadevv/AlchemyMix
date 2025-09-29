package com.alchemymix.ui.panels;

import com.alchemymix.service.AccountManager;
import com.alchemymix.account.AccountCreationResult;
import com.alchemymix.ui.manager.PanelManager;

import javax.swing.*;
import java.awt.*;

public class CreateAccountPanel extends JPanel {
    private final JTextField usernameField = new JTextField(15);
    private final JPasswordField passwordField = new JPasswordField(15);
    private final JLabel errorLabel = new JLabel(" ");
    private final PanelManager manager;

    public CreateAccountPanel(PanelManager manager) {
        this.manager = manager;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        add(buildFormPanel(), BorderLayout.CENTER);
        add(buildErrorLabel(), BorderLayout.NORTH);
        add(buildButtonPanel(), BorderLayout.SOUTH);
    }

    /** UI Builders **/
    private JPanel buildFormPanel() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Username
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(usernameField, gbc);

        // Password
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        formPanel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(passwordField, gbc);

        return formPanel;
    }

    private JLabel buildErrorLabel() {
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        errorLabel.setForeground(Color.RED);
        return errorLabel;
    }

    private JPanel buildButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        JButton createButton = new JButton("Create");
        JButton cancelButton = new JButton("Cancel");

        createButton.addActionListener(e -> handleCreate());
        cancelButton.addActionListener(e -> manager.displayPanel("MAIN_MENU"));

        buttonPanel.add(cancelButton);
        buttonPanel.add(createButton);
        return buttonPanel;
    }


    private void handleCreate() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        AccountCreationResult result = AccountManager.createAccount(username, password);

        switch (result.getStatus()) {
//          case SUCCESS -> handleSuccess(username, result);
            case ALREADY_EXISTS, INVALID_INPUT, IO_ERROR ->
                    showError("⚠ " + result.getMessage(), Color.RED);
        }
    }

    private void showError(String message, Color color) {
        errorLabel.setText(message);
        errorLabel.setForeground(color);
    }
}
