package com.alchemymix.models;

public class Account {
    private final String username;
    private final String password;
    private final int level;
    private final int health;
    private final int gold;

    public Account(String username, String password, int level, int health, int gold) {
        this.username = username;
        this.password = password;
        this.level = level;
        this.health = health;
        this.gold = gold;
    }

    public Account(String username, String password) {
        this(username, password, 1, 0, 0); // default level 1, gold 0, exp 0
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public int getLevel() { return level; }
    public int getHealth() { return health; }
    public int getGold() { return gold; }
}
