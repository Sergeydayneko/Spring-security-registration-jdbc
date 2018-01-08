package com.dayneko.secure.dao.daoHelpers;

import com.dayneko.secure.entity.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.HashMap;
import java.util.Map;

public class UserDaoHelper
{
    /**
     * SQL QUERIES
     *
     * FOR USER
     *
     */

    static public String userInfoSql = "SELECT USERS.name username, USERS.password password, ROLES.name rolename\n" +
            "FROM\n" +
            "\t(\n" +
            "\t\tSELECT u.username name, u.password, r.role_id\n" +
            "\t\tFROM users u\n" +
            "\t\tINNER JOIN user_roles r ON u.id = r.user_id\n" +
            "\t) AS USERS\n" +
            "INNER JOIN\n" +
            "\t(\n" +
            "\t\tSELECT r.role_id, roles.name \n" +
            "\t\tFROM user_roles r\n" +
            "\t\tINNER JOIN roles ON r.role_id = roles.id\n" +
            "\t) AS ROLES\n" +
            "ON ROLES.role_id = USERS.role_id\n" +
            "WHERE USERS.name = ? ";

    static public final String checkUserExistSql = "SELECT COUNT(*)\n" +
            " FROM users\n" +
            " WHERE username = ?";

    static public final String chatUserSql = "SELECT id, username, password, email, phone\n" +
            "FROM users\n" +
            "WHERE username = ?";

    static public final String registerUserSql = "insert into users(username, password, email, phone) values(:username, :password, :email, :phone)";


    static public String sqlRoleQuery = "INSERT INTO user_roles values(\n" +
            "(SELECT users.id \n" +
            "FROM users\n" +
            "WHERE username = :username)\n" +
            "\n" +
            ", 1)";

    /**
     * LAMBDA ROWMAPPERS
     *
     * FOR USER
     *
     */

    static public RowMapper<User> userMapper = (rs, rowNum ) ->
    {
        User user = new User();
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getString("rolename"));
        return user;
    };

    static public RowMapper<User> chatUserMapper = (rs, rowmap) ->
    {
        User user = new User();
        user.setUserId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        return user;
    };


    /**
     *
     * @param user
     * @return namedParams for JDBC
     */

    static public Map<String, Object> getRegisterParams(User user)
    {
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("username", user.getUsername());
        namedParameters.put("password", user.getPassword());
        namedParameters.put("email", user.getEmail());
        namedParameters.put("phone", user.getPhone());

        return namedParameters;
    }
}
