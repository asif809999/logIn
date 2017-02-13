package com.example.alasif.tourmate.Model;

public class RegisterModel {
    private int id;
    private String email, password;

    public RegisterModel(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public RegisterModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public RegisterModel() {
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

