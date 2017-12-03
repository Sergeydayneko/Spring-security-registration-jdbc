package com.dayneko.secure.sockets;

import com.dayneko.secure.dao.MessageDAOImpl;
import com.dayneko.secure.dao.UserDAOImpl;
import com.dayneko.secure.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(
                value        = "/chat",
                configurator = SpringConfigurator.class,
                encoders     = { MessageEncoder.class },
                decoders     = { MessageDecoder.class }
                )
public class ServerWebSocket {

    private final MessageDAOImpl messageDAO;
    private final UserDAOImpl userDAO;

//    Сердюковское внедрение зависимостей
    @Autowired
    public ServerWebSocket (UserDAOImpl userDAO, MessageDAOImpl messageDAO)
    {
        this.userDAO = userDAO;
        this.messageDAO = messageDAO;
    }

    @OnOpen
    public void onOpen(Session session)
    {
        System.out.println("Соединение открыто");

    }

    @OnMessage
    public void onMessage(Message message, Session session ) throws IOException, EncodeException
    {
        messageDAO.saveMessage(message);

    }

    @OnClose
    public void onClose(Session session ) {

        System.out.println(session.getId());
        System.out.println("Closing session");

    }
}
