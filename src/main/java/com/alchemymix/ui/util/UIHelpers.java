
package com.alchemymix.ui.util;

import com.alchemymix.ui.core.PanelManager;
import com.alchemymix.ui.widgets.MainMenuButton;

import javax.swing.*;
import java.awt.*;

public class UIHelpers {
    public static JButton addMenuButton(
            JPanel parent,
            String label,
            String panelName,
            GridBagConstraints gbc,
            PanelManager panelManager
    ) {
        MainMenuButton button = new MainMenuButton(label, panelManager.getWindow());

        button.addActionListener(e -> {
            if ("EXIT".equals(panelName)) {
                panelManager.getWindow().dispose();
                System.exit(0);
            } else {
                panelManager.displayPanel(panelName);
            }
        });
        parent.add(button, gbc);
        return button;
    }
}
