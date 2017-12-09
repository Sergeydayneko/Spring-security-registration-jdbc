package com.dayneko.secure.sockets;

import com.dayneko.secure.entity.Message;
import com.dayneko.secure.entity.User;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * TODO add to functionality
 */

public class MessageEncoder implements Encoder.Text<Message> {

    @Override
    public String encode(Message message) throws EncodeException {
        User message_owner = message.getMessageOwner();

        JsonObject jsonObject = Json.createObjectBuilder()
                .add("user_id", message_owner.getUserId())
                .add("sendDate", String.valueOf(message.getSendDate()))
                .add("username", message_owner.getUsername())
                .add("messageContent", message.getMessageContent())
                .build();

        return jsonObject.toString();
    }

    @Override
    public void init(EndpointConfig ec) {
        System.out.println("MessageEncoder - init method called");
    }

    @Override
    public void destroy() {
        System.out.println("MessageEncoder - destroy method called");
    }
}