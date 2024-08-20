package com.example.RestApi.model;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;

    // Getters and setters


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
