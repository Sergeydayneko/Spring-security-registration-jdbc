package com.dayneko.secure.dao;

import com.dayneko.secure.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import static com.dayneko.secure.dao.daoHelpers.UserDaoHelper.*;

@Repository
public class UserDAOImpl implements UserDAO
{
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void register(User user)
    {
        namedParameterJdbcTemplate.update(registerUserQuery, getRegisterParams(user));
        namedParameterJdbcTemplate.update(sqlRoleQuery, getRegisterParams(user));
    }

    public User getLoginInfo(String username)
    {
        return jdbcTemplate.queryForObject(userInfoQuery, userMapper, username);
    }

    public User getUserInfo(String usernameOrEmail)
    {
        return jdbcTemplate.queryForObject(chatUserQuery, chatUserMapper, usernameOrEmail);
    }

    public boolean checkUserExist(String username)
    {
        return jdbcTemplate.queryForObject(checkUserExistQuery, Boolean.class, username);
    }
}