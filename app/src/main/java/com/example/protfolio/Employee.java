package com.example.protfolio;

public class Employee {
    String title;
    String description;
    String info;

    public Employee(String title, String description, String info) {
        this.title = title;
        this.description = description;
        this.info = info;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getInfo() {
        return info;
    }
}
