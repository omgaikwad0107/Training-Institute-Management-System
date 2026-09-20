package org.techhub.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.techhub.Model.AttendanceModel;

@Repository
public class AttendanceRepository {

    @Autowired
    private JdbcTemplate template;


    // Get attendance history
    public List<AttendanceModel> getAttendanceByStudentId(int studentId) {

        String sql =
                "SELECT id, student_id, attendance_date, status, remarks " +
                "FROM attendance " +
                "WHERE student_id = ? " +
                "ORDER BY attendance_date DESC";

        return template.query(
                sql,
                (rs, rowNum) -> mapAttendance(rs),
                studentId
        );
    }


    // Total classes
    public int getTotalClasses(int studentId) {

        String sql =
                "SELECT COUNT(*) " +
                "FROM attendance " +
                "WHERE student_id = ?";

        return template.queryForObject(
                sql,
                Integer.class,
                studentId
        );
    }


    // Present classes
    public int getPresentClasses(int studentId) {

        String sql =
                "SELECT COUNT(*) " +
                "FROM attendance " +
                "WHERE student_id = ? " +
                "AND status = 'PRESENT'";

        return template.queryForObject(
                sql,
                Integer.class,
                studentId
        );
    }


    // Absent classes
    public int getAbsentClasses(int studentId) {

        String sql =
                "SELECT COUNT(*) " +
                "FROM attendance " +
                "WHERE student_id = ? " +
                "AND status = 'ABSENT'";

        return template.queryForObject(
                sql,
                Integer.class,
                studentId
        );
    }


    // Map ResultSet
    private AttendanceModel mapAttendance(ResultSet rs)
            throws SQLException {

        AttendanceModel attendance = new AttendanceModel();

        attendance.setId(
                rs.getInt("id")
        );

        attendance.setStudentId(
                rs.getInt("student_id")
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