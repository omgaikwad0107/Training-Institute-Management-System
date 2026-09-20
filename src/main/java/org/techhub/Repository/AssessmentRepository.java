package org.techhub.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.techhub.Model.AssessmentModel;

@Repository
public class AssessmentRepository {

	@Autowired
	private JdbcTemplate template;

	// =====================================================
	// GET ALL ASSESSMENTS
	// =====================================================

	public List<AssessmentModel> getAllAssessments() {

		String sql = "SELECT id, batch_name, course_name, assessment_name, "
				+ "assessment_date, total_marks, status, created_at " + "FROM assessments "
				+ "ORDER BY assessment_date DESC";

		return template.query(sql, (rs, rowNum) -> mapAssessment(rs));
	}

	// =====================================================
	// GET ASSESSMENTS FOR A PARTICULAR BATCH
	// =====================================================

	public List<AssessmentModel> getAssessmentsByBatch(String batchName) {

		String sql = "SELECT id, batch_name, course_name, assessment_name, "
				+ "assessment_date, total_marks, status, created_at " + "FROM assessments " + "WHERE batch_name = ? "
				+ "ORDER BY assessment_date DESC";

		return template.query(sql, (rs, rowNum) -> mapAssessment(rs), batchName);
	}

	// =====================================================
	// SAVE ASSESSMENT
	// =====================================================

	public boolean saveAssessment(AssessmentModel assessment) {

		String sql = "INSERT INTO assessments " + "(batch_name, course_name, assessment_name, "
				+ "assessment_date, total_marks, status) " + "VALUES (?, ?, ?, ?, ?, ?)";

		int rows = template.update(sql, assessment.getBatchName(), assessment.getCourseName(),
				assessment.getAssessmentName(), assessment.getAssessmentDate(), assessment.getTotalMarks(),
				assessment.getStatus());

		return rows > 0;
	}

	// =====================================================
	// GET ASSESSMENT BY ID
	// =====================================================

	public AssessmentModel getAssessmentById(int id) {

		String sql = "SELECT id, batch_name, course_name, assessment_name, "
				+ "assessment_date, total_marks, status, created_at " + "FROM assessments " + "WHERE id = ?";

		List<AssessmentModel> list = template.query(sql, (rs, rowNum) -> mapAssessment(rs), id);

		if (list.isEmpty()) {
			return null;
		}

		return list.get(0);
	}

	// =====================================================
	// UPDATE ASSESSMENT
	// =====================================================

	public boolean updateAssessment(AssessmentModel assessment) {

		String sql = "UPDATE assessments SET " + "batch_name = ?, " + "course_name = ?, " + "assessment_name = ?, "
				+ "assessment_date = ?, " + "total_marks = ?, " + "status = ? " + "WHERE id = ?";

		int rows = template.update(sql, assessment.getBatchName(), assessment.getCourseName(),
				assessment.getAssessmentName(), assessment.getAssessmentDate(), assessment.getTotalMarks(),
				assessment.getStatus(), assessment.getId());

		return rows > 0;
	}

	// =====================================================
	// DELETE ASSESSMENT
	// =====================================================

	public boolean deleteAssessment(int id) {

		String sql = "DELETE FROM assessments WHERE id = ?";

		int rows = template.update(sql, id);

		return rows > 0;
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

		assessment.setAssessmentDate(rs.getDate("assessment_date").toLocalDate());

		assessment.setTotalMarks(rs.getInt("total_marks"));

		assessment.setStatus(rs.getString("status"));

		if (rs.getTimestamp("created_at") != null) {

			assessment.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime().toLocalDate());
		}

		return assessment;
	}
}