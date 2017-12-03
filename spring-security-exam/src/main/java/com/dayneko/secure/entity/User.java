package com.dayneko.secure.entity;

public class User {

    private int user_id;
    private String username;
    private String password;
    private String role;
    private String email;
    private int phone;

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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        String userId = String.valueOf(getUser_id());
        String userName = getUsername();

        return "This is " + userName + " with ID = " + userId;
    }
}