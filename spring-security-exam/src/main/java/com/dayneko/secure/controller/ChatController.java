package com.dayneko.secure.controller;

import com.dayneko.secure.dao.MessageDAOImpl;
import com.dayneko.secure.dao.UserDAOImpl;
import com.dayneko.secure.entity.Message;
import com.dayneko.secure.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ChatController {

    private User myUser;

    @Autowired
    private UserDAOImpl userDAO;

    @Autowired
    private MessageDAOImpl messageDAO;


    @RequestMapping(value = "/chat")
    public String getAttrs(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        model.addAttribute("username", name);
        myUser = userDAO.getUserInfo(name);
        model.addAttribute("user_id", myUser.getUser_id());
        model.addAttribute("username", myUser.getUsername());
        model.addAttribute("email", myUser.getEmail());
        model.addAttribute("telephone", myUser.getPhone());

        return "chatRoom";
    }

    @GetMapping("chatMessages")
    public ResponseEntity<List<Message>> createArticle() {
        List<Message> messages = messageDAO.loadMessages();

        return new ResponseEntity<List<Message>>(messages, HttpStatus.OK);
    }
}
