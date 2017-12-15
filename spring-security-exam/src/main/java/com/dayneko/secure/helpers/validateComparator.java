package com.dayneko.secure.helpers;

import java.util.Comparator;

public class validateComparator implements Comparator<String>
{

    //TODO ПЕРЕПИСАТЬ КОМПАРАТОР
    @Override
    public int compare(String paramOne, String paramTwo)
    {
        return paramOne.toCharArray().length < paramTwo.toCharArray().length ? -1 : 1;
    }
}