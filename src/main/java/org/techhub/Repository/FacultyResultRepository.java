package org.techhub.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.techhub.Model.FacultyResultModel;

@Repository
public class FacultyResultRepository {

    @Autowired
    private JdbcTemplate template;


    // Get Assessments Assigned to Logged-in Faculty
   
    public List<FacultyResultModel> getAssessmentsByFacultyUsername(
            String username) {

        String sql =
                "SELECT DISTINCT " +
                "a.id AS assessment_id, " +
                "a.assessment_name, " +
                "a.course_name, " +
                "a.batch_name, " +
                "a.assessment_date, " +
                "a.total_marks " +
                "FROM assessments a " +
                "INNER JOIN batches b " +
                "ON TRIM(a.batch_name) = TRIM(b.batch_name) " +
                "INNER JOIN faculty f " +
                "ON b.faculty_id = f.id " +
                "INNER JOIN users u " +
                "ON f.user_id = u.id " +
                "WHERE u.username = ? " +
                "ORDER BY a.assessment_date DESC, a.id DESC";

        return template.query(
                sql,
                (rs, rowNum) -> {

                    FacultyResultModel result =
                            new FacultyResultModel();

                    result.setAssessmentId(
                            rs.getInt("assessment_id"));

                    result.setAssessmentName(
                            rs.getString("assessment_name"));

                    result.setCourseName(
                            rs.getString("course_name"));

                    result.setBatchName(
                            rs.getString("batch_name"));

                    if (rs.getDate("assessment_date") != null) {
                        result.setAssessmentDate(
                                rs.getDate("assessment_date")
                                        .toLocalDate());
                    }

                    result.setTotalMarks(
                            rs.getInt("total_marks"));

                    return result;
                },
                username
        );
    }

    // ==================================================
    // Check Assessment Belongs to Faculty
    // ==================================================

    public boolean isAssessmentAssignedToFaculty(
            int assessmentId,
            String username) {

        String sql =
                "SELECT COUNT(*) " +
                "FROM assessments a " +
                "INNER JOIN batches b " +
                "ON TRIM(a.batch_name) = TRIM(b.batch_name) " +
                "INNER JOIN faculty f " +
                "ON b.faculty_id = f.id " +
                "INNER JOIN users u " +
                "ON f.user_id = u.id " +
                "WHERE a.id = ? " +
                "AND u.username = ?";

        Integer count =
                template.queryForObject(
                        sql,
                        Integer.class,
                        assessmentId,
                        username
                );

        return count != null && count > 0;
    }

    // ==================================================
    // Get Students for Selected Assessment
    // ==================================================

    public List<FacultyResultModel> getStudentsByAssessment(
            int assessmentId) {

        String sql =
                "SELECT " +
                "s.id AS student_id, " +
                "s.student_name, " +
                "a.id AS assessment_id, " +
                "a.assessment_name, " +
                "a.course_name, " +
                "a.batch_name, " +
                "a.assessment_date, " +
                "a.total_marks, " +
                "r.id AS result_id, " +
                "r.marks_obtained, " +
                "r.result_status, " +
                "r.remarks " +
                "FROM assessments a " +
                "INNER JOIN enrollments e " +
                "ON TRIM(a.batch_name) = TRIM(e.batch) " +
                "INNER JOIN students s " +
                "ON e.student_id = s.id " +
                "LEFT JOIN results r " +
                "ON r.student_id = s.id " +
                "AND r.assessment_id = a.id " +
                "WHERE a.id = ? " +
                "AND e.status = 'ACTIVE' " +
                "AND s.status = 'ACTIVE' " +
                "ORDER BY s.student_name";

        return template.query(
                sql,
                (rs, rowNum) -> {

                    FacultyResultModel result =
                            new FacultyResultModel();

                    result.setStudentId(
                            rs.getInt("student_id"));

                    result.setStudentName(
                            rs.getString("student_name"));

                    result.setAssessmentId(
                            rs.getInt("assessment_id"));

                    result.setAssessmentName(
                            rs.getString("assessment_name"));

                    result.setCourseName(
                            rs.getString("course_name"));

                    result.setBatchName(
                            rs.getString("batch_name"));

                    if (rs.getDate("assessment_date") != null) {
                        result.setAssessmentDate(
                                rs.getDate("assessment_date")
                                        .toLocalDate());
                    }

                    result.setTotalMarks(
                            rs.getInt("total_marks"));

                    result.setId(
                            rs.getInt("result_id"));

                    result.setMarksObtained(
                            rs.getInt("marks_obtained"));

                    result.setResultStatus(
                            rs.getString("result_status"));

                    result.setRemarks(
                            rs.getString("remarks"));

                    return result;
                },
                assessmentId
        );
    }

    // ==================================================
    // Check Student Belongs to Assessment Batch
    // ==================================================

    public boolean isStudentValidForAssessment(
            int studentId,
            int assessmentId,
            String username) {

        String sql =
                "SELECT COUNT(*) " +
                "FROM assessments a " +
                "INNER JOIN batches b " +
                "ON TRIM(a.batch_name) = TRIM(b.batch_name) " +
                "INNER JOIN faculty f " +
                "ON b.faculty_id = f.id " +
                "INNER JOIN users u " +
                "ON f.user_id = u.id " +
                "INNER JOIN enrollments e " +
                "ON TRIM(a.batch_name) = TRIM(e.batch) " +
                "INNER JOIN students s " +
                "ON e.student_id = s.id " +
                "WHERE a.id = ? " +
                "AND s.id = ? " +
                "AND u.username = ? " +
                "AND e.status = 'ACTIVE' " +
                "AND s.status = 'ACTIVE'";

        Integer count =
                template.queryForObject(
                        sql,
                        Integer.class,
                        assessmentId,
                        studentId,
                        username
                );

        return count != null && count > 0;
    }

    // ==================================================
    // Check Result Already Exists
    // ==================================================

    public boolean resultExists(
            int studentId,
            int assessmentId) {

        String sql =
                "SELECT COUNT(*) " +
                "FROM results " +
                "WHERE student_id = ? " +
                "AND assessment_id = ?";

        Integer count =
                template.queryForObject(
                        sql,
                        Integer.class,
                        studentId,
                        assessmentId
                );

        return count != null && count > 0;
    }

    // ==================================================
    // Insert Result
    // ==================================================

    public boolean saveResult(
            int studentId,
            int assessmentId,
            int marksObtained,
            String resultStatus,
            String remarks) {

        String sql =
                "INSERT INTO results " +
                "(student_id, assessment_id, marks_obtained, " +
                "result_status, remarks) " +
                "VALUES (?, ?, ?, ?, ?)";

        int result =
                template.update(
                        sql,
                        studentId,
                        assessmentId,
                        marksObtained,
                        resultStatus,
                        remarks
                );

        return result > 0;
    }

    // ==================================================
    // Update Result
    // ==================================================

    public boolean updateResult(
            int studentId,
            int assessmentId,
            int marksObtained,
            String resultStatus,
            String remarks) {

        String sql =
                "UPDATE results " +
                "SET marks_obtained = ?, " +
                "result_status = ?, " +
                "remarks = ? " +
                "WHERE student_id = ? " +
                "AND assessment_id = ?";

        int result =
                template.update(
                        sql,
                        marksObtained,
                        resultStatus,
                        remarks,
                        studentId,
                        assessmentId
                );

        return result > 0;
    }
}