package com.alchemymix.ui.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigManager {
    private final Map<String, Properties> defaultsMap; // define defaults map
    private final Map<String, Properties> configs; // define player config

    public ConfigManager() {
        //define defaults
        defaultsMap = new HashMap<>();
        configs = new HashMap<>();

        Properties optionsDefaults = new Properties();
        optionsDefaults.setProperty("fullscreen", "false");
        optionsDefaults.setProperty("resolution", "1280x720");
        defaultsMap.put("options", optionsDefaults);

        Properties playerDefaults = new Properties();
        playerDefaults.setProperty("Level", "1");
        defaultsMap.put("player", playerDefaults);
    }

    public Properties LoadConfig(String key, String filepath) {
        Properties defaults = defaultsMap.get(key);
        if (defaults == null) {
            defaults = new Properties();
        }
        Properties config = new Properties(defaults);
        File file = new File(filepath);

        //if the file already exists, apply settings to config
        if (file.exists()) {
            try (FileInputStream in = new FileInputStream(file)) {
                config.load(in);
                // if this fails catch the error
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // if the file doesn't exist, then create it
        else {
            try {
                file.getParentFile().mkdirs(); //take config and create the dir if !exist
                file.createNewFile();
                try (FileOutputStream out = new FileOutputStream(file)) {
                    config.store(out, "Options");
                }
            } catch (IOException e) {
                e.printStackTrace(); // throw error if permission denied or disk full
            }

        }

        configs.put(key, config);
        return config;
    }

    public void saveConfig(String key, String filePath) {
        Properties config = configs.get(key);
        if (config == null) return; // if no configs were changed, don't do anything

        File file = new File(filePath);
        try {
            file.getParentFile().mkdirs();
            try (FileOutputStream out = new FileOutputStream(file)) {
                config.store(out, "Saved " + key + " configuration");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getConfig(String key) {
        return configs.get(key);
    }

    public void setProperty(String key, String value) {
        Properties config = configs.get(key);
        if (config != null){
            config.setProperty(key, value);
        };
    }
}