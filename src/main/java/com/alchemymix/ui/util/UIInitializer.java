package com.alchemymix.ui.util;

import com.alchemymix.ui.core.PanelManager;
import com.alchemymix.ui.panels.*;

public class UIInitializer {
    private static final String CLIENT_NAME = "AlchemyMix";
    private static final int CLIENT_WIDTH = 800;
    private static final int CLIENT_HEIGHT = 600;

    public static PanelManager initializeUI() {
        PanelManager panelManager = new PanelManager(CLIENT_NAME, "MAIN_MENU", CLIENT_WIDTH, CLIENT_HEIGHT);

        registerPanels(panelManager);
        panelManager.displayPanel("MAIN_MENU");
        panelManager.showWindow();

        return panelManager;
    }
    public static void registerPanels(PanelManager panelManager) {
        // Add all panels your client needs here
        panelManager.registerPanel("MAIN_MENU", new MainMenuPanel(panelManager));
        panelManager.registerPanel("SHOW_OPTIONS", new OptionsPanel(panelManager));
        panelManager.registerPanel("CREATE_ACCOUNT", new CreateAccountPanel(panelManager));
    }

}
