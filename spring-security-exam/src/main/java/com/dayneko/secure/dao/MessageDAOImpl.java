package com.dayneko.secure.dao;

import com.dayneko.secure.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class MessageDAOImpl implements MessageDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveMessage(Message message) {
        String sql = "INSERT INTO messages(shpt_date, sender_id, content)\n" +
                "VALUES(?, ?, ?)";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");

        jdbcTemplate.update(
                sql,
                new Object[] {
                        dateFormat.format(message.getSend_date()),
                        message.getMessage_owner().getUser_id(),
                        message.getMessage_content()
                });
    }

    public List<Message> loadMessages() {
        String sql = "SELECT username, shpt_date, content\n" +
                "FROM messages\n" +
                "JOIN users ON\n" +
                "messages.sender_id = users.id";

        List<Message> messages = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Message>() {
            @Override
            public Message mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Message message = new Message();
                message.setOwnerName(resultSet.getString("username"));
                message.setSend_date(resultSet.getDate("shpt_date"));
                message.setMessage_content(resultSet.getString("content"));
                return message;
            }
        });
        return messages;
    }
}
