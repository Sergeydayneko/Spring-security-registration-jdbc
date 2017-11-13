package com.dayneko.secure.dao;

import com.dayneko.secure.entity.User;

/**
 * Created by Sergey on 13.11.2017.
 */
public interface userDaoInterface {

    void register(User user);
    User getUserInfo(String username);

//    void setSimpleRole();
}
