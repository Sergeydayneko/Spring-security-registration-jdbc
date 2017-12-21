package com.dayneko.secure.helpers;

import java.util.regex.Pattern;

public class RegExpHelpers
{
    public static final Pattern EMAIL_REGEXP =
            Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$", Pattern.CASE_INSENSITIVE);

    public static final Pattern PASSWORD_REGEXP =
            Pattern.compile("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$");

    public static final Pattern MOBILE_PHONEREGEXP =
            Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
}
