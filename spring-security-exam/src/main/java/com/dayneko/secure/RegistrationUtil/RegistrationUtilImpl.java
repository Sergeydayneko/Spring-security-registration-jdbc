package com.dayneko.secure.RegistrationUtil;

import com.dayneko.secure.dao.UserDAO;
import com.dayneko.secure.entity.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.dayneko.secure.RegistrationUtil.RegExpHelpers.EMAIL_REGEXP;
import static com.dayneko.secure.RegistrationUtil.RegExpHelpers.MOBILE_PHONEREGEXP;
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
            //TODO неправильно работает порядок заполнения коллекции
            if (param.getKey() instanceof String) {
                String[] savePass = new String[1];
                if (param.getKey().toString() == "password")
                {
                    savePass[0] = param.getKey().toString();
                }

                switch (param.getKey().toString()) {
                    case "password":
                        savePass[0] = param.getKey().toString();

                        char[] PasswordSymbols = param.getValue().toString().toCharArray();
                        if (PasswordSymbols.length < 3  || PasswordSymbols.length > 15 ||
                            !PASSWORD_REGEXP.matcher(param.getValue().toString()).matches())
                        {
                            responses.add(new ServerResponse(6000, "Invalid PASSWORD!"));
                        } else
                            responses.add(new ServerResponse(5000, "Password OK"));
                        break;
                    case "passwordConfirm":
                        System.out.println(savePass[0]);
                        try {
                            if ((param.getValue().toString()).equals(savePass[0]))
                            {
                                responses.add(new ServerResponse(6000, "Passwords don't match"));
                            } else
                                responses.add(new ServerResponse(5000, "PASSWORDS are OK"));
                        } catch (NullPointerException npe) {
                            npe.printStackTrace();
                        }
                        break;
                    case "email":
                        char[] emailSymbols = param.getValue().toString().toCharArray();
                        if (emailSymbols.length < 3  || emailSymbols.length > 25 ||
                                !EMAIL_REGEXP.matcher(param.getValue().toString()).matches())
                        {
                            responses.add(new ServerResponse(6000, "Invalid EMAIL!"));
                        } else
                            responses.add(new ServerResponse(5000, "EMAIL OK"));
                        break;
                    case "phone":
                        char[] phoneSymbols = param.getValue().toString().toCharArray();
                        if (phoneSymbols.length < 3  || phoneSymbols.length > 10 ||
                                !MOBILE_PHONEREGEXP.matcher(param.getValue().toString()).matches())
                        {
                            responses.add(new ServerResponse(6000, "Invalid PHONE!"));
                        } else
                            responses.add(new ServerResponse(5000, "PHONE OK"));
                        break;
                }
            }


        }
//        for (ServerResponse response : responses)
//            System.out.println(response.getContent() + " " + response.getStatus());

        return null;
    }
}
