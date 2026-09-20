package org.techhub.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.techhub.Model.AdminAttendanceModel;

@Repository
public class AdminAttendanceRepository {

    @Autowired
    private JdbcTemplate template;


    // Get all attendance
    public List<AdminAttendanceModel> getAllAttendance() {

        String sql =
                "SELECT a.id, a.student_id, s.student_name, " +
                "e.course AS course_name, e.batch AS batch_name, " +
                "a.attendance_date, a.status, a.remarks " +
                "FROM attendance a " +
                "INNER JOIN students s ON a.student_id = s.id " +
                "LEFT JOIN enrollments e ON s.id = e.student_id " +
                "AND e.status = 'ACTIVE' " +
                "ORDER BY a.attendance_date DESC, s.student_name";

        return template.query(
                sql,
                (rs, rowNum) -> mapAttendance(rs)
        );
    }


    // Filter by date
    public List<AdminAttendanceModel> getAttendanceByDate(
            LocalDate date) {

        String sql =
                "SELECT a.id, a.student_id, s.student_name, " +
                "e.course AS course_name, e.batch AS batch_name, " +
                "a.attendance_date, a.status, a.remarks " +
                "FROM attendance a " +
                "INNER JOIN students s ON a.student_id = s.id " +
                "LEFT JOIN enrollments e ON s.id = e.student_id " +
                "AND e.status = 'ACTIVE' " +
                "WHERE a.attendance_date = ? " +
                "ORDER BY s.student_name";

        return template.query(
                sql,
                (rs, rowNum) -> mapAttendance(rs),
                date
        );
    }


    // Filter by status
    public List<AdminAttendanceModel> getAttendanceByStatus(
            String status) {

        String sql =
                "SELECT a.id, a.student_id, s.student_name, " +
                "e.course AS course_name, e.batch AS batch_name, " +
                "a.attendance_date, a.status, a.remarks " +
                "FROM attendance a " +
                "INNER JOIN students s ON a.student_id = s.id " +
                "LEFT JOIN enrollments e ON s.id = e.student_id " +
                "AND e.status = 'ACTIVE' " +
                "WHERE a.status = ? " +
                "ORDER BY a.attendance_date DESC, s.student_name";

        return template.query(
                sql,
                (rs, rowNum) -> mapAttendance(rs),
                status
        );
    }


    // Total attendance records
    public int getTotalRecords() {

        String sql =
                "SELECT COUNT(*) FROM attendance";

        return template.queryForObject(
                sql,
                Integer.class
        );
    }


    // Total present
    public int getTotalPresent() {

        String sql =
                "SELECT COUNT(*) " +
                "FROM attendance " +
                "WHERE status = 'PRESENT'";

        return template.queryForObject(
                sql,
                Integer.class
        );
    }


    // Total absent
    public int getTotalAbsent() {

        String sql =
                "SELECT COUNT(*) " +
                "FROM attendance " +
                "WHERE status = 'ABSENT'";

        return template.queryForObject(
                sql,
                Integer.class
        );
    }


    private AdminAttendanceModel mapAttendance(
            ResultSet rs) throws SQLException {

        AdminAttendanceModel attendance =
                new AdminAttendanceModel();

        attendance.setId(
                rs.getInt("id")
        );

        attendance.setStudentId(
                rs.getInt("student_id")
        );

        attendance.setStudentName(
                rs.getString("student_name")
        );

        attendance.setCourseName(
                rs.getString("course_name")
        );

        attendance.setBatchName(
                rs.getString("batch_name")
        );

        attendance.setAttendanceDate(
                rs.getDate("attendance_date").toLocalDate()
        );

        attendance.setStatus(
                rs.getString("status")
        );

        attendance.setRemarks(
                rs.getString("remarks")
        );

        return attendance;
    }
}