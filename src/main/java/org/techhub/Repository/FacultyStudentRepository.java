package org.techhub.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.techhub.Model.StudentModel;

@Repository
public class FacultyStudentRepository {

	@Autowired
	private JdbcTemplate template;

	public List<StudentModel> getStudentsByFacultyUsername(String username) {

		String sql = "SELECT DISTINCT " + "s.id, s.user_id, s.student_name, s.email, s.mobile, "
				+ "s.gender, s.dob, s.address, s.admission_date, s.status, " + "u.username, "
				+ "e.id AS enrollment_id, e.course, e.batch, " + "e.enrollment_date, e.status AS enrollment_status, "
				+ "c.duration AS course_duration, c.fees AS course_fees " + "FROM faculty f "
				+ "INNER JOIN users fu ON f.user_id = fu.id " + "INNER JOIN batches b ON f.id = b.faculty_id "
				+ "INNER JOIN enrollments e ON b.batch_name = e.batch "
				+ "INNER JOIN students s ON e.student_id = s.id " + "INNER JOIN users u ON s.user_id = u.id "
				+ "LEFT JOIN courses c ON e.course = c.course_name " + "WHERE fu.username = ? "
				+ "AND e.status = 'ACTIVE' " + "AND s.status = 'ACTIVE' " + "ORDER BY s.student_name";

		return template.query(sql, (rs, rowNum) -> {

			StudentModel student = new StudentModel();

			student.setId(rs.getInt("id"));
			student.setUserId(rs.getInt("user_id"));
			student.setStudentName(rs.getString("student_name"));
			student.setEmail(rs.getString("email"));
			student.setMobile(rs.getString("mobile"));
			student.setGender(rs.getString("gender"));

			if (rs.getDate("dob") != null) {
				student.setDob(rs.getDate("dob").toLocalDate());
			}

			student.setAddress(rs.getString("address"));

			if (rs.getDate("admission_date") != null) {
				student.setAdmissionDate(rs.getDate("admission_date").toLocalDate());
			}

			student.setStatus(rs.getString("status"));
			student.setUsername(rs.getString("username"));

			student.setEnrollmentId(rs.getInt("enrollment_id"));

			student.setCourse(rs.getString("course"));
			student.setBatch(rs.getString("batch"));

			if (rs.getDate("enrollment_date") != null) {
				student.setEnrollmentDate(rs.getDate("enrollment_date").toLocalDate());
			}

			student.setEnrollmentStatus(rs.getString("enrollment_status"));

			student.setCourseDuration(rs.getString("course_duration"));

			student.setCourseFees(rs.getDouble("course_fees"));

			return student;

		}, username);
	}
}