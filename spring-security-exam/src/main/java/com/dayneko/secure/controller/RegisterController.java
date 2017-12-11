package com.dayneko.secure.controller;

import com.dayneko.secure.RegistrationUtil.RegistrationUtil;
import com.dayneko.secure.comparators.ValidateComparator;
import com.dayneko.secure.dao.UserDAO;
import com.dayneko.secure.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * CONTROLLER FOR REGISTRATION
 */

@Controller
public class RegisterController
{
    private final UserDAO userDAO;
    private final RegistrationUtil registrationUtil;

    @Autowired
    public RegisterController(UserDAO userDAO, RegistrationUtil registrationUtil)
    {
        this.userDAO = userDAO;
        this.registrationUtil = registrationUtil;
    }

    @RequestMapping(value = "/registration")
    public ModelAndView showRegister()
    {
        ModelAndView mav = new ModelAndView("registrationTEST");
        mav.addObject("User", new User());
        return mav;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public String addUser(HttpServletRequest servletRequest)
    {
        String username = servletRequest.getParameter("login");
        String password = servletRequest.getParameter("password");
        String passwordConfirm = servletRequest.getParameter("passwordConfirm");
        String email = servletRequest.getParameter("email");
        String phone = servletRequest.getParameter("phone");

        Map<String, String> parameterValue = new TreeMap<>(new ValidateComparator());
        parameterValue.put("password", password);
        parameterValue.put("passwordConfirm", passwordConfirm);
        parameterValue.put("email", email);
        parameterValue.put("phone", phone);

        registrationUtil.checkFields(parameterValue);

        System.out.println(registrationUtil.checkUser(username));

//        userDAO.register(user);
        return "redirect:/index";
    }
}