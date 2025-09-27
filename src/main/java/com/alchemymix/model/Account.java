package com.alchemymix.model;

public class Account {
    private final String username;
    private final String password;
    private int currency;
    private int level;
    private int xp;

    // Constructor
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.currency = 100; // default starting value
        this.level = 1;
        this.xp = 0;
    }

    // Getters & setters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public int getCurrency() { return currency; }
    public int getLevel() { return level; }
    public int getXp() { return xp; }

    public void setCurrency(int currency) { this.currency = currency; }
    public void setLevel(int level) { this.level = level; }
    public void setXp(int xp) { this.xp = xp; }
}
