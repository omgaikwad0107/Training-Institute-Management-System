package org.techhub.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.techhub.Model.FacultyAttendanceModel;

@Repository
public class FacultyAttendanceRepository {

    @Autowired
    private JdbcTemplate template;


    // =====================================================
    // GET FACULTY ASSIGNED STUDENTS
    // =====================================================

    public List<FacultyAttendanceModel> getStudentsByFacultyUsername(
            String username) {

        String sql =
                "SELECT DISTINCT " +
                "s.id AS student_id, " +
                "s.student_name, " +
                "e.course AS course_name, " +
                "e.batch AS batch_name " +

                "FROM faculty f " +

                "INNER JOIN users fu " +
                "ON f.user_id = fu.id " +

                "INNER JOIN batches b " +
                "ON f.id = b.faculty_id " +

                "INNER JOIN enrollments e " +
                "ON TRIM(b.batch_name) = TRIM(e.batch) " +

                "INNER JOIN students s " +
                "ON e.student_id = s.id " +

                "WHERE fu.username = ? " +
                "AND e.status = 'ACTIVE' " +
                "AND s.status = 'ACTIVE' " +

                "ORDER BY e.batch, s.student_name";


        return template.query(
                sql,
                (rs, rowNum) -> {

                    FacultyAttendanceModel attendance =
                            new FacultyAttendanceModel();

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

                    return attendance;

                },
                username
        );
    }


    // =====================================================
    // CHECK ATTENDANCE EXISTS
    // =====================================================

    public boolean attendanceExists(
            int studentId,
            LocalDate attendanceDate) {

        String sql =
                "SELECT COUNT(*) " +
                "FROM attendance " +
                "WHERE student_id = ? " +
                "AND attendance_date = ?";


        Integer count =
                template.queryForObject(
                        sql,
                        Integer.class,
                        studentId,
                        attendanceDate
                );


        return count != null && count > 0;
    }


    // =====================================================
    // SAVE ATTENDANCE
    // =====================================================

    public boolean saveAttendance(
            int studentId,
            LocalDate attendanceDate,
            String status,
            String remarks) {

        String sql =
                "INSERT INTO attendance " +
                "(student_id, attendance_date, status, remarks) " +
                "VALUES (?, ?, ?, ?)";


        int result =
                template.update(
                        sql,
                        studentId,
                        attendanceDate,
                        status,
                        remarks
                );


        return result > 0;
    }


    // =====================================================
    // UPDATE ATTENDANCE
    // =====================================================

    public boolean updateAttendance(
            int studentId,
            LocalDate attendanceDate,
            String status,
            String remarks) {

        String sql =
                "UPDATE attendance " +
                "SET status = ?, remarks = ? " +
                "WHERE student_id = ? " +
                "AND attendance_date = ?";


        int result =
                template.update(
                        sql,
                        status,
                        remarks,
                        studentId,
                        attendanceDate
                );


        return result > 0;
    }


    // =====================================================
    // CHECK STUDENT ASSIGNED TO FACULTY
    // =====================================================

    public boolean isStudentAssignedToFaculty(
            int studentId,
            String username) {

        String sql =
                "SELECT COUNT(*) " +
                "FROM faculty f " +

                "INNER JOIN users u " +
                "ON f.user_id = u.id " +

                "INNER JOIN batches b " +
                "ON f.id = b.faculty_id " +

                "INNER JOIN enrollments e " +
                "ON TRIM(b.batch_name) = TRIM(e.batch) " +

                "WHERE u.username = ? " +
                "AND e.student_id = ? " +
                "AND e.status = 'ACTIVE'";


        Integer count =
                template.queryForObject(
                        sql,
                        Integer.class,
                        username,
                        studentId
                );


        return count != null && count > 0;
    }


    // =====================================================
    // TODAY PRESENT COUNT
    // =====================================================

    public int getTodayPresentCountByFacultyUsername(
            String username) {

        String sql =
                "SELECT COUNT(DISTINCT a.student_id) " +

                "FROM attendance a " +

                "INNER JOIN students s " +
                "ON a.student_id = s.id " +

                "INNER JOIN enrollments e " +
                "ON e.student_id = s.id " +

                "INNER JOIN batches b " +
                "ON TRIM(e.batch) = TRIM(b.batch_name) " +

                "INNER JOIN faculty f " +
                "ON b.faculty_id = f.id " +

                "INNER JOIN users u " +
                "ON f.user_id = u.id " +

                "WHERE u.username = ? " +
                "AND e.status = 'ACTIVE' " +
                "AND s.status = 'ACTIVE' " +
                "AND a.attendance_date = CURDATE() " +
                "AND a.status = 'PRESENT'";


        Integer count =
                template.queryForObject(
                        sql,
                        Integer.class,
                        username
                );


        return count != null ? count : 0;
    }
}