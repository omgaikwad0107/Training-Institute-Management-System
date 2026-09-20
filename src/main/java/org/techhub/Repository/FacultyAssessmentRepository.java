package org.techhub.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.techhub.Model.AssessmentModel;

@Repository
public class FacultyAssessmentRepository {

    @Autowired
    private JdbcTemplate template;


    // Faculty ला assigned batches मिळवण्यासाठी
    public List<String> getBatchesByFacultyUsername(String username) {

        String sql =
                "SELECT DISTINCT b.batch_name " +
                "FROM batches b " +
                "INNER JOIN faculty f ON b.faculty_id = f.id " +
                "INNER JOIN users u ON f.user_id = u.id " +
                "WHERE u.username = ? " +
                "AND b.status = 'ACTIVE' " +
                "ORDER BY b.batch_name";

        return template.query(
                sql,
                (rs, rowNum) -> rs.getString("batch_name"),
                username
        );
    }


    // Faculty च्या batches मधील assessments
    public List<AssessmentModel> getAssessmentsByFacultyUsername(
            String username) {

        String sql =
                "SELECT DISTINCT " +
                "a.id, " +
                "a.batch_name, " +
                "a.course_name, " +
                "a.assessment_name, " +
                "a.assessment_date, " +
                "a.total_marks, " +
                "a.status, " +
                "a.created_at " +
                "FROM assessments a " +
                "INNER JOIN batches b " +
                "ON a.batch_name = b.batch_name " +
                "INNER JOIN faculty f " +
                "ON b.faculty_id = f.id " +
                "INNER JOIN users u " +
                "ON f.user_id = u.id " +
                "WHERE u.username = ? " +
                "ORDER BY a.assessment_date DESC, a.id DESC";

        return template.query(
                sql,
                (rs, rowNum) -> {

                    AssessmentModel assessment =
                            new AssessmentModel();

                    assessment.setId(
                            rs.getInt("id"));

                    assessment.setBatchName(
                            rs.getString("batch_name"));

                    assessment.setCourseName(
                            rs.getString("course_name"));

                    assessment.setAssessmentName(
                            rs.getString("assessment_name"));

                    if (rs.getDate("assessment_date") != null) {
                        assessment.setAssessmentDate(
                                rs.getDate("assessment_date")
                                        .toLocalDate());
                    }

                    assessment.setTotalMarks(
                            rs.getInt("total_marks"));

                    assessment.setStatus(
                            rs.getString("status"));

                    return assessment;
                },
                username
        );
    }


    // Assessment save करण्यापूर्वी batch faculty चा आहे का ते check
    public boolean isBatchAssignedToFaculty(
            String batchName,
            String username) {

        String sql =
                "SELECT COUNT(*) " +
                "FROM batches b " +
                "INNER JOIN faculty f ON b.faculty_id = f.id " +
                "INNER JOIN users u ON f.user_id = u.id " +
                "WHERE b.batch_name = ? " +
                "AND u.username = ? " +
                "AND b.status = 'ACTIVE'";

        Integer count = template.queryForObject(
                sql,
                Integer.class,
                batchName,
                username
        );

        return count != null && count > 0;
    }


    // Assessment save
    public boolean saveAssessment(
            AssessmentModel assessment) {

        String sql =
                "INSERT INTO assessments " +
                "(batch_name, course_name, assessment_name, " +
                "assessment_date, total_marks, status) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        int result = template.update(
                sql,
                assessment.getBatchName(),
                assessment.getCourseName(),
                assessment.getAssessmentName(),
                assessment.getAssessmentDate(),
                assessment.getTotalMarks(),
                assessment.getStatus()
        );

        return result > 0;
    }


    // Assessment delete
    public boolean deleteAssessment(int id) {

        String sql =
                "DELETE FROM assessments " +
                "WHERE id = ?";

        int result = template.update(sql, id);

        return result > 0;
    }
}