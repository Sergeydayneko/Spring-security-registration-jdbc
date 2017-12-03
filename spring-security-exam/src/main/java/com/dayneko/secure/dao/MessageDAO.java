package com.dayneko.secure.dao;

import com.dayneko.secure.entity.Message;

import java.util.Date;
import java.util.List;

public interface MessageDAO {
    void saveMessage(Message message);

    List<Message> loadMessages();
}
