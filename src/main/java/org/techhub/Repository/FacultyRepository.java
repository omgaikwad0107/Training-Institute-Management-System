package org.techhub.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.techhub.Model.FacultyModel;

@Repository
public class FacultyRepository {

    @Autowired
    private JdbcTemplate template;

    // Add Faculty
    public boolean saveFaculty(FacultyModel faculty) {

        try {

            String userSql =
                    "INSERT INTO users "
                  + "(username, password, role, status) "
                  + "VALUES (?, ?, ?, ?)";

            int userResult = template.update(
                    userSql,
                    faculty.getUsername(),
                    faculty.getPassword(),
                    "FACULTY",
                    faculty.getStatus()
            );

            if (userResult <= 0) {
                return false;
            }

            Integer userId = template.queryForObject(
                    "SELECT id FROM users WHERE username = ?",
                    Integer.class,
                    faculty.getUsername()
            );

            if (userId == null) {
                return false;
            }

            String facultySql =
                    "INSERT INTO faculty "
                  + "(user_id, faculty_name, email, mobile, gender, "
                  + "dob, address, joining_date, specialization, status) "
                  + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            int facultyResult = template.update(
                    facultySql,
                    userId,
                    faculty.getFacultyName(),
                    faculty.getEmail(),
                    faculty.getMobile(),
                    faculty.getGender(),
                    faculty.getDob(),
                    faculty.getAddress(),
                    faculty.getJoiningDate(),
                    faculty.getSpecialization(),
                    faculty.getStatus()
            );

            return facultyResult > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    // Get All Faculty
    public List<FacultyModel> getAllFaculty() {

        String sql =
                "SELECT "
              + "f.id, f.user_id, f.faculty_name, f.email, f.mobile, "
              + "f.gender, f.dob, f.address, f.joining_date, "
              + "f.specialization, f.status, "
              + "u.username, u.password, u.role "
              + "FROM faculty f "
              + "INNER JOIN users u ON f.user_id = u.id "
              + "ORDER BY f.id DESC";

        return template.query(
                sql,
                (rs, rowNum) -> mapFaculty(rs)
        );
    }

    // Get Faculty By ID
    public FacultyModel getFacultyById(int id) {

        String sql =
                "SELECT "
              + "f.id, f.user_id, f.faculty_name, f.email, f.mobile, "
              + "f.gender, f.dob, f.address, f.joining_date, "
              + "f.specialization, f.status, "
              + "u.username, u.password, u.role "
              + "FROM faculty f "
              + "INNER JOIN users u ON f.user_id = u.id "
              + "WHERE f.id = ?";

        List<FacultyModel> list = template.query(
                sql,
                (rs, rowNum) -> mapFaculty(rs),
                id
        );

        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

    // Update Faculty
    public boolean updateFaculty(FacultyModel faculty) {

        try {

            String userSql =
                    "UPDATE users SET "
                  + "username = ?, "
                  + "password = ?, "
                  + "status = ? "
                  + "WHERE id = ?";

            int userResult = template.update(
                    userSql,
                    faculty.getUsername(),
                    faculty.getPassword(),
                    faculty.getStatus(),
                    faculty.getUserId()
            );

            if (userResult <= 0) {
                return false;
            }

            String facultySql =
                    "UPDATE faculty SET "
                  + "faculty_name = ?, "
                  + "email = ?, "
                  + "mobile = ?, "
                  + "gender = ?, "
                  + "dob = ?, "
                  + "address = ?, "
                  + "joining_date = ?, "
                  + "specialization = ?, "
                  + "status = ? "
                  + "WHERE id = ?";

            int facultyResult = template.update(
                    facultySql,
                    faculty.getFacultyName(),
                    faculty.getEmail(),
                    faculty.getMobile(),
                    faculty.getGender(),
                    faculty.getDob(),
                    faculty.getAddress(),
                    faculty.getJoiningDate(),
                    faculty.getSpecialization(),
                    faculty.getStatus(),
                    faculty.getId()
            );

            return facultyResult > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    // Delete Faculty
    public boolean deleteFaculty(int facultyId) {

        try {

            Integer userId = template.queryForObject(
                    "SELECT user_id FROM faculty WHERE id = ?",
                    Integer.class,
                    facultyId
            );

            if (userId == null) {
                return false;
            }

            int facultyDeleted = template.update(
                    "DELETE FROM faculty WHERE id = ?",
                    facultyId
            );

            if (facultyDeleted <= 0) {
                return false;
            }

            int userDeleted = template.update(
                    "DELETE FROM users WHERE id = ?",
                    userId
            );

            return userDeleted > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    // Get Active Faculty
    public List<FacultyModel> getActiveFaculty() {

        String sql =
                "SELECT "
              + "f.id, f.user_id, f.faculty_name, f.email, f.mobile, "
              + "f.gender, f.dob, f.address, f.joining_date, "
              + "f.specialization, f.status, "
              + "u.username, u.password, u.role "
              + "FROM faculty f "
              + "INNER JOIN users u ON f.user_id = u.id "
              + "WHERE f.status = 'ACTIVE' "
              + "ORDER BY f.faculty_name";

        return template.query(
                sql,
                (rs, rowNum) -> mapFaculty(rs)
        );
    }

    // Get Total Faculty
    public int getTotalFaculty() {

        String sql = "SELECT COUNT(*) FROM faculty";

        return template.queryForObject(
                sql,
                Integer.class
        );
    }

    // Map ResultSet To FacultyModel
    private FacultyModel mapFaculty(ResultSet rs)
            throws SQLException {

        FacultyModel faculty = new FacultyModel();

        faculty.setId(rs.getInt("id"));
        faculty.setUserId(rs.getInt("user_id"));

        faculty.setFacultyName(
                rs.getString("faculty_name")
        );

        faculty.setEmail(
                rs.getString("email")
        );

        faculty.setMobile(
                rs.getString("mobile")
        );

        faculty.setGender(
                rs.getString("gender")
        );

        if (rs.getDate("dob") != null) {

            faculty.setDob(
                    rs.getDate("dob").toLocalDate()
            );
        }

        faculty.setAddress(
                rs.getString("address")
        );

        if (rs.getDate("joining_date") != null) {

            faculty.setJoiningDate(
                    rs.getDate("joining_date").toLocalDate()
            );
        }

        faculty.setSpecialization(
                rs.getString("specialization")
        );

        faculty.setStatus(
                rs.getString("status")
        );

        faculty.setUsername(
                rs.getString("username")
        );

        faculty.setPassword(
                rs.getString("password")
        );

        faculty.setRole(
                rs.getString("role")
        );

        return faculty;
    }
}