package com.dayneko.secure.sockets;

import com.dayneko.secure.entity.Message;
import com.dayneko.secure.entity.User;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.StringReader;
import java.util.Date;


public class MessageDecoder implements Decoder.Text<Message> {


    @Override
    public Message decode(String jsonMessage) throws DecodeException {

        JsonObject jsonObject = Json.createReader(new StringReader(jsonMessage)).readObject();
        Message message = new Message();
        message.setMessage_content(jsonObject.getString("messageText")); //посмотреть как у меня прописан контент во фронте
        message.setSend_date(new Date());
        message.setMessage_owner(new User());
        message.getMessage_owner().setUser_id(Integer.parseInt(jsonObject.getString("userId")));
        message.getMessage_owner().setUsername(jsonObject.getString("userName"));

        System.out.println(message.toString());

        return message;

    }



    @Override
    public boolean willDecode(String jsonMessage) {
        if (jsonMessage != null && !jsonMessage.isEmpty()) {
            try {
                System.out.println("MessageDecoder - читается");
                Json.createReader(new StringReader(jsonMessage)).readObject();

                return true;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("MessageDecoder - нечитается");
            }
        }
        return false;
    }

    @Override
    public void init(EndpointConfig ec) {
        System.out.println("MessageDecoder -init method called");
    }

    @Override
    public void destroy() {
        System.out.println("MessageDecoder - destroy method called");
    }

}
