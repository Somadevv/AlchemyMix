package com.alchemymix.client;

import com.alchemymix.models.Account;
import com.alchemymix.ui.panels.CreateAccountPanel;
import com.alchemymix.ui.core.PanelManager;
import com.alchemymix.ui.panels.MainMenuPanel;
import com.alchemymix.ui.panels.OptionsPanel;
import com.alchemymix.ui.util.UIInitializer;

import javax.swing.*;

public class ClientLoader {
    private static final String CLIENT_NAME = "AlchemyMix";
    private static final int CLIENT_WIDTH = 700;
    private static final int CLIENT_HEIGHT = 500;

    private PanelManager panelManager;

    public void launch() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {}


        SwingUtilities.invokeLater(this::initUI);
    }

    private void initUI() {
        panelManager = new PanelManager(CLIENT_NAME, "MAIN_MENU", CLIENT_WIDTH, CLIENT_HEIGHT);

        // Register panels
        UIInitializer.registerPanels(panelManager);

        // Show main menu
        panelManager.displayPanel("MAIN_MENU");
        panelManager.showWindow();
    }


    // --- Handlers for menu actions ---

public void createAccount() {
    panelManager.displayPanel("CREATE_ACCOUNT");
}

    public void showOptions() {
        panelManager.displayPanel("OPTIONS");
    }

    public void exitGame() {
        System.out.println("Exiting game...");
        System.exit(0);
    }
}
