package com.alchemymix.model;

public class Account {
    private final String username;
    private final String password;
    private int currency;
    private int level;
    private int xp;

    // Constructor
    public Account(String username, String password) {
        // Capitalize username here if needed
        this.username = capitalizeFirst(username);
        this.password = password;
        this.currency = 100; // default starting value
        this.level = 1;
        this.xp = 0;
    }

    // Getters only for username/password
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    // Getters & setters for mutable fields
    public int getCurrency() { return currency; }
    public int getLevel() { return level; }
    public int getXp() { return xp; }

    public void setCurrency(int currency) { this.currency = currency; }
    public void setLevel(int level) { this.level = level; }
    public void setXp(int xp) { this.xp = xp; }

    // Capitalization helper
    private static String capitalizeFirst(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
