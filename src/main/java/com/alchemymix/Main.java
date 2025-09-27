package com.alchemymix;

import com.alchemymix.client.ClientLoader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ClientLoader client = new ClientLoader();
        client.launch();
    }
}