package com.dayneko.secure.dao;

import com.dayneko.secure.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static com.dayneko.secure.dao.daoHelpers.UserDaoHelper.*;

@Repository
public class UserDAOImpl implements UserDAO
{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //    Регистрация пользователя и внесения роли
    public void register(User user) {
        Map<String, String> namedParameters = new HashMap<>();
        namedParameters.put("username", user.getUsername());
        namedParameters.put("password", user.getPassword());
        namedParameters.put("email", user.getEmail());
        namedParameters.put("phone", user.getPhone());

        System.out.println(namedParameters.toString());


        String registerUserSql = "insert into users(username, password, email, phone) values(:username, :password, :email, :phone)";

        jdbcTemplate.update(registerUserSql, namedParameters);

        String sqlRoleQuery = "INSERT INTO user_roles values(\n" +
                "(SELECT users.id \n" +
                "FROM users\n" +
                "WHERE username = ?)\n" +
                "\n" +
                ", 1)";

        jdbcTemplate.update(
                sqlRoleQuery,
                new Object[] {
                        user.getUsername()
                });
    }

    public User getLoginInfo(String username)
    {
        return jdbcTemplate.queryForObject(userInfoSql, userMapper, username);
    }

    public User getUserInfo(String usernameOrEmail)
    {
        return jdbcTemplate.queryForObject(chatUserSql, chatUserMapper, usernameOrEmail);
    }

    public boolean checkUserExist(String username)
    {
        return jdbcTemplate.queryForObject(checkUserExistSql, Boolean.class, username);
    }
}