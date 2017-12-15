package com.dayneko.secure.comparators;

import java.util.Comparator;

public class ValidateComparator implements Comparator<String>
{

    //TODO ПЕРЕПИСАТЬ КОМПАРАТОР
    @Override
    public int compare(String paramOne, String paramTwo)
    {
        return paramOne.toCharArray().length < paramTwo.toCharArray().length ? -1 : 1;
    }
}