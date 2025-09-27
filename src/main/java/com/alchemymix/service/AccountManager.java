package com.alchemymix.service;

import com.alchemymix.account.AccountCreationResult;
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
    public static boolean checkAccountExists(String username) {
        String normalized = capitalizeFirst(username);
        File file = new File(ACCOUNTS_DIR, normalized + ".json");
        return file.exists();
    }

    public static AccountCreationResult createAccount(String username, String password) {
        String normalized = capitalizeFirst(username == null ? "" : username.trim());

        if (normalized.isBlank() || password == null || password.trim().isBlank()) {
            return new AccountCreationResult(AccountCreationResult.Status.INVALID_INPUT,
                    "Username and password cannot be empty.");
        }

        File dir = new File(ACCOUNTS_DIR);
        if (!dir.exists() && !dir.mkdirs()) {
            return new AccountCreationResult(AccountCreationResult.Status.IO_ERROR,
                    "Could not create accounts directory.");
        }

        File file = new File(dir, normalized + ".json");
        if (file.exists()) {
            return new AccountCreationResult(AccountCreationResult.Status.ALREADY_EXISTS,
                    "That username is already taken.");
        }

        Account account = new Account(normalized, password);
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(account, writer);
            return new AccountCreationResult(AccountCreationResult.Status.SUCCESS,
                    "Account created.", account);
        } catch (IOException e) {
            return new AccountCreationResult(AccountCreationResult.Status.IO_ERROR,
                    "Error saving account: " + e.getMessage());
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
