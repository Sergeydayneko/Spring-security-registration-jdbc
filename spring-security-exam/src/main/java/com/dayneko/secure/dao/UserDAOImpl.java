package com.dayneko.secure.dao;

import com.dayneko.secure.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDAOImpl implements UserDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //    Регистрация пользователя и внесения роли
    public void register(User user) {
        String sqlUserQuery = "insert into users(username, password, email, phone) values(?,?,?,?)";
        String sqlRoleQuery = "INSERT INTO user_roles values(\n" +
                "(SELECT users.id \n" +
                "FROM users\n" +
                "WHERE username = ?)\n" +
                "\n" +
                ", 1)";

        jdbcTemplate.update(
                sqlUserQuery,
                new Object[] {
                        user.getUsername(), user.getPassword(), user.getEmail(), user.getPhone()
                });

        jdbcTemplate.update(
                sqlRoleQuery,
                new Object[] {
                        user.getUsername()
                });
    }

    //   Авторизация пользователя
    public User getLoginInfo(String username) {

        String sql = "SELECT USERS.name username, USERS.password password, ROLES.name rolename\n" +
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


        User userLoginInfo = (User) jdbcTemplate.queryForObject(sql, new Object[]{username},
                new RowMapper<User>() {
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        User user = new User();
                        user.setUsername(rs.getString("username"));
                        user.setPassword(rs.getString("password"));
                        user.setRole(rs.getString("rolename"));
                        return user;
                    }
                });
        return userLoginInfo;
    }

    public User getUserInfo(String usernameOrEmail){
        String sql = "SELECT id, username, password, email, phone\n" +
                "FROM users\n" +
                "WHERE username = ?";

        User userInfo = (User) jdbcTemplate.queryForObject(sql, new Object[]{usernameOrEmail},
                new RowMapper<User>() {

                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        User user = new User();
                        user.setUser_id(rs.getInt("id"));
                        user.setUsername(rs.getString("username"));
                        user.setEmail(rs.getString("email"));

                        return user;
                    }
                });
        return userInfo;
    }
}
