package com.dayneko.secure.dao;

import com.dayneko.secure.entity.User;

public interface UserDAO {
    void register(User user);
    User getUserInfo(String username);
    User getLoginInfo(String username);
    boolean checkUserExist(String username);
}