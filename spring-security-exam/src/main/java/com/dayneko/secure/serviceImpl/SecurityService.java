package com.dayneko.secure.serviceImpl;

public interface SecurityService
{
    String findLoggedInUsername();
    void autologin(String username, String password);
}
