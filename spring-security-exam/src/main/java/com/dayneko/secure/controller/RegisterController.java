package com.dayneko.secure.controller;

import com.dayneko.secure.dao.UserDAO;
import com.dayneko.secure.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * CONTROLLER FOR REGISTRATION
 */

@Controller
public class RegisterController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView showRegister() {
        ModelAndView mav = new ModelAndView("registration");
        mav.addObject("User", new User());
        return mav;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("User") User user) {
        userDAO.register(user);

        ModelAndView mav = new ModelAndView("welcome");
        return mav;
    }
}
