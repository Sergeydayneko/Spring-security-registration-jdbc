//package com.dayneko.secure.dao.rowMapperImplements;
//
//import com.dayneko.secure.entity.User;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;

/**
 * EXAMPLE OF USING RowMapper REDEFINITION
 */

//public class UserInfoMapper implements RowMapper<User>
//{
//    public User mapRow(ResultSet rs, int rowNum) throws SQLException
//    {
//        User user = new User();
//        user.setUsername(rs.getString("username"));
//        user.setPassword(rs.getString("password"));
//        user.setRole(rs.getString("rolename"));
//        System.out.println(user.toString());
//        return user;
//    }
//}
