package com.dayneko.secure.RegistrationUtil;

import com.dayneko.secure.entity.ServerResponse;

import java.util.ArrayList;
import java.util.Map;

public interface RegistrationUtil
{
    ServerResponse checkUser(String username);
    ArrayList<ServerResponse> checkFields(Map<?, ?> parameters);
}
