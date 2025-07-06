package com.airtribe.aggregatorApi.DTO;

public class Loginrequest {
    private String email;
    private String password;

    // No-arg constructor
    public Loginrequest() {
    }

    // All-arg constructor
    public Loginrequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
