package com.example.jushuapeterte;

import java.net.MalformedURLException;
import java.net.URL;

public class User {
    String username;
    String password;
    String css;

    public User(String username, String password) throws MalformedURLException {
        this.username = username;
        this.password = password;
        css = username + ".css";
    }
}