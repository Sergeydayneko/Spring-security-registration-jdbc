package com.dayneko.secure.serviceImpl;


import com.dayneko.secure.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        com.dayneko.secure.entity.User userInfo = userDAO.getLoginInfo(username);
        GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
        UserDetails userDetails = (UserDetails)new org.springframework.security.core.userdetails.User(userInfo.getUsername(),
                userInfo.getPassword(), Arrays.asList(authority));
        return userDetails;
    }
}