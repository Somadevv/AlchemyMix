package com.alchemymix.service;

import com.alchemymix.model.Account;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class AccountManager {
    private static final String ACCOUNTS_DIR = "accounts";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Check if an account JSON file already exists for the given username.
     */
    public static boolean accountExists(String username) {
        String normalized = capitalizeFirst(username);
        File file = new File(ACCOUNTS_DIR, normalized + ".json");
        return file.exists();
    }

    /**
     * Save an account to JSON.
     * Caller is responsible for checking accountExists() first.
     */
    public static void createAccount(Account account) throws IOException {
        File dir = new File(ACCOUNTS_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String normalized = capitalizeFirst(account.getUsername());
        File file = new File(dir, normalized + ".json");

        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(account, writer);
        }
    }

    /**
     * Load an account from JSON by username.
     */
    public static Account loadAccount(String username) throws IOException {
        String normalized = capitalizeFirst(username);
        File file = new File(ACCOUNTS_DIR, normalized + ".json");

        if (!file.exists()) {
            throw new FileNotFoundException("Account for " + normalized + " not found.");
        }

        try (FileReader reader = new FileReader(file)) {
            return gson.fromJson(reader, Account.class);
        }
    }

    /**
     * Utility: Capitalize the first character of a string.
     */
    private static String capitalizeFirst(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
