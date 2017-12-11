package com.dayneko.secure.RegistrationUtil;

import com.dayneko.secure.dao.UserDAO;
import com.dayneko.secure.entity.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.dayneko.secure.RegistrationUtil.RegExpHelpers.PASSWORD_REGEXP;

@Component
public class RegistrationUtilImpl implements RegistrationUtil
{
    private final UserDAO userDAO;

    @Autowired
    public RegistrationUtilImpl(UserDAO userDAO)
    {
        this.userDAO = userDAO;
    }


    @Override
    public boolean checkUser(String username)
    {
        return userDAO.checkUserExist(username);
    }

    @Override
    public ArrayList<ServerResponse> checkFields(Map<?, ?> parameters)
    {
        ArrayList<ServerResponse> responses = new ArrayList<>();

        for (Map.Entry<?, ?> param : parameters.entrySet())
        {
            if (param.getKey() instanceof String) {

                switch (param.getKey().toString()) {
                    case "password":
                        System.out.println("PASSWORD " + param.getValue().toString());
                        char[] symbols = param.getValue().toString().toCharArray();
                        if (symbols.length < 3  || symbols.length > 15 ||
                            !PASSWORD_REGEXP.matcher(param.getValue().toString()).matches())
                        {
                            responses.add(new ServerResponse(6000, "Invalid password!"));
                        } else
                            responses.add(new ServerResponse(5000, "Password OK"));
                    case "passwordConfirm":
//                        if ()

                    case "email":
                        System.out.println("Email! " + param.getValue().toString());
                    case "phone":
                        System.out.println("Phone number " + param.getValue().toString());
                }
            }

        }

        return null;
    }
}
