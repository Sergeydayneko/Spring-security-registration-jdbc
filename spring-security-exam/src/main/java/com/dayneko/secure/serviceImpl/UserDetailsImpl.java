//package com.dayneko.secure.serviceImpl;
//
//import com.dayneko.secure.dao.UserDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//
//@Service
//public class UserDetailsImpl implements UserDetailsInterface {
//
//    @Autowired
//    private UserDAO userDAO;
//
//    @Override
//    public UserDetails getUser(String username)
//            throws UsernameNotFoundException {
//        com.dayneko.secure.entity.User userInfo = userDAO.userInfo(username);
//        GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
//        org.springframework.security.core.userdetails.UserDetails userDetails = (org.springframework.security.core.userdetails.UserDetails)new org.springframework.security.core.userdetails.User(userInfo.getUsername(),
//                userInfo.getPassword(), Arrays.asList(authority));
//        return userDetails;
//    }
//}
