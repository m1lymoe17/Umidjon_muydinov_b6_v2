package com.app.repository;

import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getUserList() {
        String query = "select * from users";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt(1));
            user.setFirstName(rs.getString(2));
            user.setLastName(rs.getString(3));
            user.setUsername(rs.getString(4));
            user.setPassword(rs.getString(5));
            user.setCustomer(rs.getBoolean(6));
            user.setBio(rs.getString(7));
            return user;
        });
    }

    public User getUserById(Integer id) {
        String query = "select * from users where id = " + id;
        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt(1));
            user.setFirstName(rs.getString(2));
            user.setLastName(rs.getString(3));
            user.setUsername(rs.getString(4));
            user.setPassword(rs.getString(5));
            user.setCustomer(rs.getBoolean(6));
            user.setBio(rs.getString(7));
            return user;
        });
    }

    public boolean saveUser(User user) {
        String query =
                "insert into users(first_name, last_name, username, password) " +
                "values ('" + user.getFirstName() + "','" + user.getLastName() +
                "','" + user.getUsername() +
                "','" + user.getPassword() + "')";
        return jdbcTemplate.update(query) > 0;
    }

    public boolean deleteUser(Integer id) {
        String query = "delete from users where id = " + id;
        return jdbcTemplate.update(query) > 0;
    }

    public User getLoggedUser(User loggedUser) {
        String sqlQuery =
                "select * " +
                "from users where username like '" + loggedUser.getUsername() + "' and password like '" + loggedUser.getPassword() + "';";
        List<User> query = jdbcTemplate.query(sqlQuery, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt(1));
            user.setFirstName(rs.getString(2));
            user.setLastName(rs.getString(3));
            user.setUsername(rs.getString(4));
            user.setPassword(rs.getString(5));
            user.setCustomer(rs.getBoolean(6));
            user.setBio(rs.getString(7));
            return user;
        });
        if (query.size() > 0) {
            return query.get(0);
        }
        return null;
    }
}
