package com.alchemymix.client;

import com.alchemymix.ui.utils.UIInitializer;

import javax.swing.*;

public class ClientLoader {


    public void launch() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {}


        SwingUtilities.invokeLater(UIInitializer::initializeUI);
    }





}
