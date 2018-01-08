package com.dayneko.secure.entity;

import java.io.Serializable;

public class User implements Serializable
{
    //TODO Сделать рефакторинг на создание конструктора, чтобы было вместо setter'ов

    private int userId;
    private String username;
    private String password;
    private String passwordConfirm;
    private String role;
    private String email;
    private String phone;

    public User(String username, String password, String email, String phone)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public User(){
        String mock = "Заглушка, позже удалить";
    }

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

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPasswordConfirm() { return passwordConfirm; }
    public void setPasswordConfirm(String passwordConfirm) { this.passwordConfirm = passwordConfirm; }

    @Override
    public String toString() {
        String userId = String.valueOf(getUserId());
        String userName = getUsername();

        return "This is " + userName + " with ID = " + userId;
    }
}