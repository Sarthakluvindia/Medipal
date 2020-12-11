package com.example.ugdmedipal;

public class RegisteredUser {
    String name;
    String bg;
    String height;
    String weight;

    public RegisteredUser() {
    }

    public RegisteredUser(String name, String bg, String height, String weight) {
        this.name = name;
        this.bg = bg;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getBg() {
        return bg;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }
}
