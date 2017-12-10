package com.dayneko.secure.controller;

import com.dayneko.secure.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class LoginController {

    @RequestMapping(value = "/")
    public String start(){
        return "index";
    }

    @RequestMapping(value = "/index")
    public ModelAndView indexPage(@ModelAttribute("userJSP") User user)
    {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("MyUser", user);

        return mav;
    }

    @RequestMapping(value = "/login")
    public String loginPage(){ return "login"; }

    @RequestMapping(value = "/userPage")
    public String usersPages() { return "userPage"; }

    @RequestMapping(value = "/adminPage")
    public String adminsPages() { return "adminPage"; }

    @RequestMapping(value = "/403")
    public ModelAndView accessDenied(Principal user)
    {
        ModelAndView model = new ModelAndView();

        //Login having test
        if (user != null) {
            model.addObject("msg", "Hi " + user.getName()
                    + "<span style=\"color: red; \">, you do not have permission to access this page!</span>");
        } else {
            model.addObject("msg",
                    "<span style=\"color: red; \">You do not have permission to access this page!</span>");
        }

        model.setViewName("403");
        return model;
    }
}