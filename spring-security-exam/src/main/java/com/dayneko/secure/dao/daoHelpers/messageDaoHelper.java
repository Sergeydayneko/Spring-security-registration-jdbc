package com.dayneko.secure.dao.daoHelpers;

import com.dayneko.secure.entity.Message;
import org.springframework.jdbc.core.RowMapper;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class messageDaoHelper {

    /**
     * SQL QUERIES
     *
     * FOR Messages
     */

    static public String saveMessageQuery = "INSERT INTO messages(shpt_date, sender_id, content)\n" +
            "VALUES(:date, :messageOwner, :messageContent)";

    static public String loadMessagesQuery = "SELECT username, shpt_date, content\n" +
            "FROM messages\n" +
            "JOIN users ON\n" +
            "messages.sender_id = users.id";

    /**
     * NAMED PARAMS
     *
     * FOR MESSAGES
     */

    public static Map<String, Object> getMessageParams(Message message)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        Map<String, Object> namedMessageParams = new HashMap<>();

        namedMessageParams.put("date", dateFormat.format(message.getSendDate()));
        namedMessageParams.put("messageOwner", message.getMessageOwner().getUserId());
        namedMessageParams.put("messageContent", message.getMessageContent());

        return  namedMessageParams;
    }

    /**
     * LAMBDAS RowMapper
     *
     * FOR MESSAGES
     */

     public static RowMapper<Message> messageRowMapper = (resultSet, rowNum) ->
    {
        Message message = new Message();
        message.setOwnerName(resultSet.getString("username"));
        message.setSendDate(resultSet.getDate("shpt_date"));
        message.setMessageContent(resultSet.getString("content"));
        return message;
    };
}
