package com.dayneko.secure.RegistrationUtil;

import com.dayneko.secure.dao.UserDAO;
import com.dayneko.secure.entity.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.dayneko.secure.helpers.RegExpHelpers.EMAIL_REGEXP;
import static com.dayneko.secure.helpers.RegExpHelpers.MOBILE_PHONEREGEXP;
import static com.dayneko.secure.helpers.RegExpHelpers.PASSWORD_REGEXP;

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
    public ServerResponse checkUser(String username)
    {
        if (userDAO.checkUserExist(username))
        {
            new ServerResponse(6000, "User is already exists", false);
        }

        return new ServerResponse(5000, "User  OK", true);
    }

    @Override
    public ArrayList<ServerResponse> checkFields(Map<?, ?> parameters)
    {
        ArrayList<ServerResponse> responses = new ArrayList<>();
        String[] cachePass = { String.valueOf(parameters.get("password")) };

        for (Map.Entry<?, ?> param : parameters.entrySet())
        {
            if (param.getKey() instanceof String)
            {
//                TODO предпологается сделать универсальный валидатор
                switch (param.getKey().toString())
                {
                    case "password":
                        char[] PasswordSymbols = param.getValue().toString().toCharArray();
                        if (PasswordSymbols.length < 3  || PasswordSymbols.length > 15 ||
                            !PASSWORD_REGEXP.matcher(param.getValue().toString()).matches())
                        {
                            responses.add(new ServerResponse(6000, "Invalid PASSWORD!", false));
                        } else
                            responses.add(new ServerResponse(5000, "Password OK", true));
                        break;
                    case "passwordConfirm":
                        try {
                            if (!(param.getValue().toString()).equals(cachePass[0]))
                            {
                                responses.add(new ServerResponse(6000, "Passwords don't match", false));
                            } else {
                                responses.add(new ServerResponse(5000, "PASSWORDS are OK", true));
                            }
                        } catch (NullPointerException npe) {
                            npe.printStackTrace();
                        }
                        break;
                    case "email":
                        char[] emailSymbols = param.getValue().toString().toCharArray();
                        if (emailSymbols.length < 3  || emailSymbols.length > 25 ||
                                !EMAIL_REGEXP.matcher(param.getValue().toString()).matches())
                        {
                            responses.add(new ServerResponse(6000, "Invalid EMAIL!", false));
                        } else
                            responses.add(new ServerResponse(5000, "EMAIL OK", true));
                        break;
                    case "phone":
                        System.out.println(param.getValue() instanceof String);
                        char[] phoneSymbols = param.getValue().toString().toCharArray();
                        if (phoneSymbols.length < 3  || phoneSymbols.length > 15 ||
                                !MOBILE_PHONEREGEXP.matcher(param.getValue().toString()).matches())
                        {
                            responses.add(new ServerResponse(6000, "Invalid PHONE!", false));
                        } else
                            responses.add(new ServerResponse(5000, "PHONE OK", true));
                        break;
                }
            }
        }

        return responses;
    }
}
