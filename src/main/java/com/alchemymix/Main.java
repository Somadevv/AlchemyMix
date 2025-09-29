package com.alchemymix;

import com.alchemymix.client.ClientLoader;
import com.alchemymix.ui.manager.PanelManager;
import com.alchemymix.ui.utils.UIInitializer;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Client...");

        SwingUtilities.invokeLater(() -> {
            try {
                // Set Nimbus LAF explicitly before creating any Swing components
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {
                System.err.println("Failed to set Nimbus Look and Feel, falling back to default.");
            }

            ClientLoader client = new ClientLoader();
            client.launch();
            System.out.println("Client successfully loaded.");

            PanelManager panelManager = new PanelManager("AlchemyMix", "MAIN_MENU", 800, 600);
            UIInitializer.registerPanels(panelManager);
        });
    }

}