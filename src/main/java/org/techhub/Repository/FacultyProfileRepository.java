package org.techhub.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.techhub.Model.FacultyModel;

@Repository
public class FacultyProfileRepository {

    @Autowired
    private JdbcTemplate template;

   
    // Get Faculty Profile by Username
 

    public FacultyModel getFacultyByUsername(String username) {

        String sql =
                "SELECT " +
                "f.id, " +
                "f.user_id, " +
                "f.faculty_name, " +
                "f.email, " +
                "f.mobile, " +
                "f.gender, " +
                "f.dob, " +
                "f.address, " +
                "f.joining_date, " +
                "f.specialization, " +
                "f.status, " +
                "u.username " +
                "FROM faculty f " +
                "INNER JOIN users u " +
                "ON f.user_id = u.id " +
                "WHERE u.username = ?";

        List<FacultyModel> list =
                template.query(
                        sql,
                        (rs, rowNum) -> {

                            FacultyModel faculty =
                                    new FacultyModel();

                            faculty.setId(
                                    rs.getInt("id"));

                            faculty.setUserId(
                                    rs.getInt("user_id"));

                            faculty.setFacultyName(
                                    rs.getString("faculty_name"));

                            faculty.setEmail(
                                    rs.getString("email"));

                            faculty.setMobile(
                                    rs.getString("mobile"));

                            faculty.setGender(
                                    rs.getString("gender"));

                            if (rs.getDate("dob") != null) {
                                faculty.setDob(
                                        rs.getDate("dob")
                                                .toLocalDate());
                            }

                            faculty.setAddress(
                                    rs.getString("address"));

                            if (rs.getDate("joining_date") != null) {
                                faculty.setJoiningDate(
                                        rs.getDate("joining_date")
                                                .toLocalDate());
                            }

                            faculty.setSpecialization(
                                    rs.getString("specialization"));

                            faculty.setStatus(
                                    rs.getString("status"));

                            faculty.setUsername(
                                    rs.getString("username"));

                            return faculty;
                        },
                        username
                );

        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }
}