package com.dayneko.secure.dao.daoHelpers;

public class messageDaoHelper {

    static public String saveMessageSql = "INSERT INTO messages(shpt_date, sender_id, content)\n" +
            "VALUES(?, ?, ?)";
}
