package com.alchemymix.client;

import javax.swing.*;
import java.awt.*;
import com.alchemymix.ui.MainMenuButton;

public class ClientLoader {

    // Constants (final values for config)
    private static final String CLIENT_NAME = "Client";
    private static final int CLIENT_WIDTH = 600;
    private static final int CLIENT_HEIGHT = 500;

    // Entry point
    public void launch() {
        SwingUtilities.invokeLater(this::createAndShowGUI);
    }

    // GUI creation method
    private void createAndShowGUI() {
        // Frame setup
        JFrame frame = new JFrame(CLIENT_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create scalable button (our custom UI class)
        MainMenuButton myButton = new MainMenuButton("Sign up", frame);

        // Panel with GridBagLayout to keep button centered
        JPanel panel = new JPanel(new GridBagLayout());
        panel.add(myButton);

        // Add the panel (not the button directly) to the frame
        frame.add(panel, BorderLayout.CENTER);

        // Button action
        myButton.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "Account created!")
        );

        // Window sizing
        frame.setPreferredSize(new Dimension(CLIENT_WIDTH, CLIENT_HEIGHT));
        frame.pack();
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setVisible(true);
    }
}
