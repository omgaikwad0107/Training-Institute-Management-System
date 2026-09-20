package org.techhub.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.techhub.Model.AssessmentModel;

@Repository
public class AdminAssessmentRepository {

    @Autowired
    private JdbcTemplate template;

    // =====================================================
    // GET ALL ASSESSMENTS
    // =====================================================

    public List<AssessmentModel> getAllAssessments() {

        String sql = "SELECT id, batch_name, course_name, assessment_name, "
                + "assessment_date, total_marks, status, created_at "
                + "FROM assessments "
                + "ORDER BY assessment_date DESC";

        return template.query(sql, (rs, rowNum) -> mapAssessment(rs));
    }

    // =====================================================
    // GET UPCOMING ASSESSMENTS
    // =====================================================

    public List<AssessmentModel> getUpcomingAssessments() {

        String sql = "SELECT id, batch_name, course_name, assessment_name, "
                + "assessment_date, total_marks, status, created_at "
                + "FROM assessments "
                + "WHERE status = 'UPCOMING' "
                + "ORDER BY assessment_date ASC";

        return template.query(sql, (rs, rowNum) -> mapAssessment(rs));
    }

    // =====================================================
    // GET COMPLETED ASSESSMENTS
    // =====================================================

    public List<AssessmentModel> getCompletedAssessments() {

        String sql = "SELECT id, batch_name, course_name, assessment_name, "
                + "assessment_date, total_marks, status, created_at "
                + "FROM assessments "
                + "WHERE status = 'COMPLETED' "
                + "ORDER BY assessment_date DESC";

        return template.query(sql, (rs, rowNum) -> mapAssessment(rs));
    }

    // =====================================================
    // GET BY STATUS
    // =====================================================

    public List<AssessmentModel> getAssessmentsByStatus(String status) {

        String sql = "SELECT id, batch_name, course_name, assessment_name, "
                + "assessment_date, total_marks, status, created_at "
                + "FROM assessments "
                + "WHERE status = ? "
                + "ORDER BY assessment_date DESC";

        return template.query(sql, (rs, rowNum) -> mapAssessment(rs), status);
    }

    // =====================================================
    // GET BY COURSE
    // =====================================================

    public List<AssessmentModel> getAssessmentsByCourse(String courseName) {

        String sql = "SELECT id, batch_name, course_name, assessment_name, "
                + "assessment_date, total_marks, status, created_at "
                + "FROM assessments "
                + "WHERE course_name = ? "
                + "ORDER BY assessment_date DESC";

        return template.query(sql, (rs, rowNum) -> mapAssessment(rs), courseName);
    }

    // =====================================================
    // GET BY BATCH
    // =====================================================

    public List<AssessmentModel> getAssessmentsByBatch(String batchName) {

        String sql = "SELECT id, batch_name, course_name, assessment_name, "
                + "assessment_date, total_marks, status, created_at "
                + "FROM assessments "
                + "WHERE batch_name = ? "
                + "ORDER BY assessment_date DESC";

        return template.query(sql, (rs, rowNum) -> mapAssessment(rs), batchName);
    }

    // =====================================================
    // TOTAL ASSESSMENTS
    // =====================================================

    public int getTotalAssessments() {

        String sql = "SELECT COUNT(*) FROM assessments";

        return template.queryForObject(sql, Integer.class);
    }

    // =====================================================
    // TOTAL UPCOMING
    // =====================================================

    public int getTotalUpcoming() {

        String sql = "SELECT COUNT(*) FROM assessments "
                + "WHERE status = 'UPCOMING'";

        return template.queryForObject(sql, Integer.class);
    }

    // =====================================================
    // TOTAL COMPLETED
    // =====================================================

    public int getTotalCompleted() {

        String sql = "SELECT COUNT(*) FROM assessments "
                + "WHERE status = 'COMPLETED'";

        return template.queryForObject(sql, Integer.class);
    }

    // =====================================================
    // MAP DATABASE RESULT
    // =====================================================

    private AssessmentModel mapAssessment(ResultSet rs) throws SQLException {

        AssessmentModel assessment = new AssessmentModel();

        assessment.setId(rs.getInt("id"));
        assessment.setBatchName(rs.getString("batch_name"));
        assessment.setCourseName(rs.getString("course_name"));
        assessment.setAssessmentName(rs.getString("assessment_name"));

        if (rs.getDate("assessment_date") != null) {
            assessment.setAssessmentDate(
                    rs.getDate("assessment_date").toLocalDate()
            );
        }

        assessment.setTotalMarks(rs.getInt("total_marks"));
        assessment.setStatus(rs.getString("status"));

        if (rs.getTimestamp("created_at") != null) {
            assessment.setCreatedAt(
                    rs.getTimestamp("created_at")
                            .toLocalDateTime()
                            .toLocalDate()
            );
        }

        return assessment;
    }
}