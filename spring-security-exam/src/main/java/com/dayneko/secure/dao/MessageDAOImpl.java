package com.dayneko.secure.dao;

import com.dayneko.secure.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

import static com.dayneko.secure.dao.daoHelpers.messageDaoHelper.*;

@Repository
public class MessageDAOImpl implements MessageDAO {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void saveMessage(Message message)
    {
        namedParameterJdbcTemplate.update(saveMessageQuery, getMessageParams(message));
    }

    public List<Message> loadMessages()
    {
        return jdbcTemplate.query(loadMessagesQuery, messageRowMapper);
    }
}