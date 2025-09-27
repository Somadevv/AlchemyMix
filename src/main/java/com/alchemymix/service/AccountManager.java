package com.alchemymix.service;

import com.alchemymix.model.Account;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class AccountManager {
    private static final String ACCOUNTS_DIR = "accounts";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Save account to JSON
    public static void saveAccount(Account account) throws IOException {
        File dir = new File(ACCOUNTS_DIR);
        if (!dir.exists()) dir.mkdirs();

        File file = new File(dir, account.getUsername() + ".json");

        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(account, writer);
        }
    }

    // Load account from JSON
    public static Account loadAccount(String username) throws IOException {
        File file = new File(ACCOUNTS_DIR, username + ".json");
        if (!file.exists()) {
            throw new FileNotFoundException("Account for " + username + " not found.");
        }

        try (FileReader reader = new FileReader(file)) {
            return gson.fromJson(reader, Account.class);
        }
    }
}
