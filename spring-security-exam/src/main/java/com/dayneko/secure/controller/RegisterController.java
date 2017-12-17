package com.dayneko.secure.controller;

import com.dayneko.secure.RegistrationUtil.RegistrationUtil;
import com.dayneko.secure.dao.UserDAO;
import com.dayneko.secure.entity.ServerResponse;
import com.dayneko.secure.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
        ModelAndView mav = new ModelAndView("registration");
        mav.addObject("User", new User());
        return mav;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ResponseEntity<List<ServerResponse>> addUser(HttpServletRequest servletRequest)
    {
        ArrayList<ServerResponse> validationResponse;
        Map<String, String> parameterValue = new TreeMap<>();
        ArrayList<Boolean> validationPassing = new ArrayList<>();

        String username = servletRequest.getParameter("login");
        String password = servletRequest.getParameter("password");
        String passwordConfirm = servletRequest.getParameter("passwordConfirm");
        String email = servletRequest.getParameter("email");
        String phone = servletRequest.getParameter("phone");

        parameterValue.put("password", password);
        parameterValue.put("passwordConfirm", passwordConfirm);
        parameterValue.put("email", email);
        parameterValue.put("phone", phone);

        validationResponse = registrationUtil.checkFields(parameterValue);
        validationResponse.add(registrationUtil.checkUser(username.toLowerCase()));

        for( ServerResponse resp : validationResponse)
        {
            validationPassing.add(resp.getValid());
        }

        if (validationPassing.contains(false))
        {
            return new ResponseEntity<List<ServerResponse>>(validationResponse, HttpStatus.UNAUTHORIZED);
        }

        User user = new User(username, password, email, phone);
        userDAO.register(user);

        return new ResponseEntity<List<ServerResponse>>(validationResponse, HttpStatus.OK);
    }
}