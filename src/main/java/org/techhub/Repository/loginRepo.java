package org.techhub.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import org.techhub.Model.LoginModel;

@Repository
public class loginRepo {

    @Autowired
    JdbcTemplate template;

    public LoginModel isVerifyUser(LoginModel model) {

        String sql = "SELECT username, password, role " +
                     "FROM users " +
                     "WHERE username = ? " +
                     "AND password = ? " +
                     "AND role = ?";

        List<LoginModel> value = template.query(
                sql,
                new Object[] {
                    model.getUsername(),
                    model.getPassword(),
                    model.getRole()
                },
                new RowMapper<LoginModel>() {

                    @Override
                    public LoginModel mapRow(ResultSet rs, int rowNum)
                            throws SQLException {

                        LoginModel user = new LoginModel();

                        user.setUsername(rs.getString("username"));
                        user.setPassword(rs.getString("password"));
                        user.setRole(rs.getString("role"));

                        return user;
                    }
                }
        );

        if (value.isEmpty()) {
            return null;
        }

        return value.get(0);
    }
}