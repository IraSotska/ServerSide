package com.app.entities;

public class Customer {

    private String name;
    private String surName;
    private String password;
    private String email;
    private String phone;

    private String userRole = "user";

    public Customer() {
    }

    public Customer(String name, String surName, String password, String email, String phone) {
        this.name = name;
        this.surName = surName;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
