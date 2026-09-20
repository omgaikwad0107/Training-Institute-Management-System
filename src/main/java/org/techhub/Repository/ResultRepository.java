package org.techhub.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.techhub.Model.ResultModel;

@Repository
public class ResultRepository {

	@Autowired
	private JdbcTemplate template;

	// =====================================================
	// GET ALL RESULTS
	// =====================================================

	public List<ResultModel> getAllResults() {

		String sql = "SELECT " + "r.id, " + "r.student_id, " + "r.assessment_id, " + "r.marks_obtained, "
				+ "r.result_status, " + "r.remarks, " + "r.created_at, " + "s.student_name, " + "a.assessment_name, "
				+ "a.course_name, " + "a.batch_name, " + "a.total_marks, " + "a.assessment_date " + "FROM results r "
				+ "INNER JOIN students s " + "ON r.student_id = s.id " + "INNER JOIN assessments a "
				+ "ON r.assessment_id = a.id " + "ORDER BY a.assessment_date DESC";

		return template.query(sql, (rs, rowNum) -> mapResult(rs));
	}

	// =====================================================
	// GET RESULTS BY STUDENT
	// =====================================================

	public List<ResultModel> getResultsByStudentId(int studentId) {

		String sql = "SELECT " + "r.id, " + "r.student_id, " + "r.assessment_id, " + "r.marks_obtained, "
				+ "r.result_status, " + "r.remarks, " + "r.created_at, " + "s.student_name, " + "a.assessment_name, "
				+ "a.course_name, " + "a.batch_name, " + "a.total_marks, " + "a.assessment_date " + "FROM results r "
				+ "INNER JOIN students s " + "ON r.student_id = s.id " + "INNER JOIN assessments a "
				+ "ON r.assessment_id = a.id " + "WHERE r.student_id = ? " + "ORDER BY a.assessment_date DESC";

		return template.query(sql, (rs, rowNum) -> mapResult(rs), studentId);
	}

	// =====================================================
	// SAVE RESULT
	// =====================================================

	public boolean saveResult(ResultModel result) {

		String sql = "INSERT INTO results " + "(student_id, assessment_id, "
				+ "marks_obtained, result_status, remarks) " + "VALUES (?, ?, ?, ?, ?)";

		int rows = template.update(sql, result.getStudentId(), result.getAssessmentId(), result.getMarksObtained(),
				result.getResultStatus(), result.getRemarks());

		return rows > 0;
	}

	// =====================================================
	// GET RESULT BY ID
	// =====================================================

	public ResultModel getResultById(int id) {

		String sql = "SELECT " + "r.id, " + "r.student_id, " + "r.assessment_id, " + "r.marks_obtained, "
				+ "r.result_status, " + "r.remarks, " + "r.created_at, " + "s.student_name, " + "a.assessment_name, "
				+ "a.course_name, " + "a.batch_name, " + "a.total_marks, " + "a.assessment_date " + "FROM results r "
				+ "INNER JOIN students s " + "ON r.student_id = s.id " + "INNER JOIN assessments a "
				+ "ON r.assessment_id = a.id " + "WHERE r.id = ?";

		List<ResultModel> list = template.query(sql, (rs, rowNum) -> mapResult(rs), id);

		if (list.isEmpty()) {
			return null;
		}

		return list.get(0);
	}

	// =====================================================
	// UPDATE RESULT
	// =====================================================

	public boolean updateResult(ResultModel result) {

		String sql = "UPDATE results SET " + "student_id = ?, " + "assessment_id = ?, " + "marks_obtained = ?, "
				+ "result_status = ?, " + "remarks = ? " + "WHERE id = ?";

		int rows = template.update(sql, result.getStudentId(), result.getAssessmentId(), result.getMarksObtained(),
				result.getResultStatus(), result.getRemarks(), result.getId());

		return rows > 0;
	}

	// =====================================================
	// DELETE RESULT
	// =====================================================

	public boolean deleteResult(int id) {

		String sql = "DELETE FROM results WHERE id = ?";

		int rows = template.update(sql, id);

		return rows > 0;
	}

	// =====================================================
	// MAP RESULT
	// =====================================================

	private ResultModel mapResult(ResultSet rs) throws SQLException {

		ResultModel result = new ResultModel();

		result.setId(rs.getInt("id"));

		result.setStudentId(rs.getInt("student_id"));

		result.setAssessmentId(rs.getInt("assessment_id"));

		result.setMarksObtained(rs.getInt("marks_obtained"));

		result.setResultStatus(rs.getString("result_status"));

		result.setRemarks(rs.getString("remarks"));

		if (rs.getTimestamp("created_at") != null) {

			result.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime().toLocalDate());
		}

		result.setStudentName(rs.getString("student_name"));

		result.setAssessmentName(rs.getString("assessment_name"));

		result.setCourseName(rs.getString("course_name"));

		result.setBatchName(rs.getString("batch_name"));

		result.setTotalMarks(rs.getInt("total_marks"));

		if (rs.getDate("assessment_date") != null) {

			result.setAssessmentDate(rs.getDate("assessment_date").toLocalDate());
		}

		return result;
	}
}