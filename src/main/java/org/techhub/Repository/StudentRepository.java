package org.techhub.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.techhub.Model.StudentModel;

@Repository
public class StudentRepository {

	@Autowired
	private JdbcTemplate template;

	// =========================================================
	// SAVE STUDENT
	// =========================================================

	public boolean saveStudent(StudentModel student) {

		try {

			// -------------------------------------------------
			// 1. INSERT INTO USERS
			// -------------------------------------------------

			String userSql = "INSERT INTO users " + "(username, password, role, status) " + "VALUES (?, ?, ?, ?)";

			int userResult = template.update(userSql, student.getUsername(), student.getPassword(), "STUDENT",
					student.getStatus());

			if (userResult <= 0) {
				return false;
			}

			// -------------------------------------------------
			// 2. GET GENERATED USER ID
			// -------------------------------------------------

			Integer userId = template.queryForObject("SELECT id FROM users WHERE username = ?", Integer.class,
					student.getUsername());

			if (userId == null) {
				return false;
			}

			// -------------------------------------------------
			// 3. INSERT INTO STUDENTS
			// -------------------------------------------------

			String studentSql = "INSERT INTO students " + "(user_id, student_name, email, mobile, gender, "
					+ "dob, address, status) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			int studentResult = template.update(studentSql, userId, student.getStudentName(), student.getEmail(),
					student.getMobile(), student.getGender(), student.getDob(), student.getAddress(),
					student.getStatus());

			if (studentResult <= 0) {
				return false;
			}

			// -------------------------------------------------
			// 4. GET GENERATED STUDENT ID
			// -------------------------------------------------

			Integer studentId = template.queryForObject("SELECT id FROM students WHERE user_id = ?", Integer.class,
					userId);

			if (studentId == null) {
				return false;
			}

			// -------------------------------------------------
			// 5. INSERT INTO ENROLLMENTS
			// -------------------------------------------------

			String enrollmentSql = "INSERT INTO enrollments " + "(student_id, course, batch, status) "
					+ "VALUES (?, ?, ?, ?)";

			int enrollmentResult = template.update(enrollmentSql, studentId, student.getCourse(), student.getBatch(),
					"ACTIVE");

			return enrollmentResult > 0;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	// =========================================================
	// GET ALL STUDENTS
	// =========================================================

	public List<StudentModel> getAllStudents() {

		String sql = "SELECT " + "s.id, " + "s.user_id, " + "s.student_name, " + "s.email, " + "s.mobile, "
				+ "s.gender, " + "s.dob, " + "s.address, " + "s.admission_date, " + "s.status, " + "u.username, "
				+ "e.id AS enrollment_id, " + "e.course, " + "e.batch, " + "e.enrollment_date, "
				+ "e.status AS enrollment_status " + "FROM students s " + "INNER JOIN users u ON s.user_id = u.id "
				+ "LEFT JOIN enrollments e ON s.id = e.student_id " + "ORDER BY s.id DESC";

		return template.query(sql, (rs, rowNum) -> mapStudent(rs));
	}

	// =========================================================
	// GET STUDENT BY ID
	// =========================================================

	public StudentModel getStudentById(int id) {

		String sql = "SELECT " + "s.id, " + "s.user_id, " + "s.student_name, " + "s.email, " + "s.mobile, "
				+ "s.gender, " + "s.dob, " + "s.address, " + "s.admission_date, " + "s.status, " + "u.username, "
				+ "u.password, " + "e.id AS enrollment_id, " + "e.course, " + "e.batch, " + "e.enrollment_date, "
				+ "e.status AS enrollment_status " + "FROM students s " + "INNER JOIN users u ON s.user_id = u.id "
				+ "LEFT JOIN enrollments e ON s.id = e.student_id " + "WHERE s.id = ?";

		List<StudentModel> list = template.query(sql, (rs, rowNum) -> mapStudent(rs), id);

		if (list.isEmpty()) {
			return null;
		}

		return list.get(0);
	}

	// =========================================================
	// UPDATE STUDENT
	// =========================================================

	public boolean updateStudent(StudentModel student) {

		try {

			// -------------------------------------------------
			// 1. UPDATE USERS
			// -------------------------------------------------

			String userSql = "UPDATE users SET " + "username = ?, " + "password = ?, " + "status = ? " + "WHERE id = ?";

			int userResult = template.update(userSql, student.getUsername(), student.getPassword(), student.getStatus(),
					student.getUserId());

			if (userResult <= 0) {
				return false;
			}

			// -------------------------------------------------
			// 2. UPDATE STUDENTS
			// -------------------------------------------------

			String studentSql = "UPDATE students SET " + "student_name = ?, " + "email = ?, " + "mobile = ?, "
					+ "gender = ?, " + "dob = ?, " + "address = ?, " + "status = ? " + "WHERE id = ?";

			int studentResult = template.update(studentSql, student.getStudentName(), student.getEmail(),
					student.getMobile(), student.getGender(), student.getDob(), student.getAddress(),
					student.getStatus(), student.getId());

			if (studentResult <= 0) {
				return false;
			}

			// -------------------------------------------------
			// 3. UPDATE ENROLLMENT
			// -------------------------------------------------

			String enrollmentSql = "UPDATE enrollments SET " + "course = ?, " + "batch = ? " + "WHERE student_id = ?";

			int enrollmentResult = template.update(enrollmentSql, student.getCourse(), student.getBatch(),
					student.getId());

			if (enrollmentResult <= 0) {
				return false;
			}

			// -------------------------------------------------
			// ALL UPDATES SUCCESSFUL
			// -------------------------------------------------

			return true;

		} catch (Exception e) {

			e.printStackTrace();

			return false;
		}
	}
	// =========================================================
	// DELETE STUDENT
	// =========================================================

	public boolean deleteStudent(int studentId) {

	    try {

	        // 1. Get user_id of student
	        Integer userId = template.queryForObject(
	                "SELECT user_id FROM students WHERE id = ?",
	                Integer.class,
	                studentId
	        );

	        if (userId == null) {
	            return false;
	        }


	        // 2. Delete enrollment
	        template.update(
	                "DELETE FROM enrollments WHERE student_id = ?",
	                studentId
	        );


	        // 3. Delete student
	        template.update(
	                "DELETE FROM students WHERE id = ?",
	                studentId
	        );


	        // 4. Delete user
	        int userDeleted = template.update(
	                "DELETE FROM users WHERE id = ?",
	                userId
	        );


	        System.out.println("Student ID deleted : " + studentId);
	        System.out.println("User ID deleted    : " + userId);
	        System.out.println("Users rows deleted : " + userDeleted);


	        return userDeleted > 0;

	    } catch (Exception e) {

	        e.printStackTrace();
	        return false;
	    }
	}
	// =========================================================
	// RESULTSET → STUDENT MODEL
	// =========================================================

	private StudentModel mapStudent(ResultSet rs) throws SQLException {

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

		// Password exists only in getStudentById query
		try {
			student.setPassword(rs.getString("password"));
		} catch (SQLException e) {
			// Ignore because getAllStudents doesn't select password
		}

		student.setEnrollmentId(rs.getInt("enrollment_id"));

		student.setCourse(rs.getString("course"));

		student.setBatch(rs.getString("batch"));

		if (rs.getDate("enrollment_date") != null) {
			student.setEnrollmentDate(rs.getDate("enrollment_date").toLocalDate());
		}

		student.setEnrollmentStatus(rs.getString("enrollment_status"));

		return student;
	}
	
	public int getTotalStudents() {
	    String sql = "SELECT COUNT(*) FROM students";
	    return template.queryForObject(sql, Integer.class);
	}

	public int getActiveStudents() {
	    String sql = "SELECT COUNT(*) FROM students WHERE status = 'ACTIVE'";
	    return template.queryForObject(sql, Integer.class);
	}

	public int getInactiveStudents() {
	    String sql = "SELECT COUNT(*) FROM students WHERE status = 'INACTIVE'";
	    return template.queryForObject(sql, Integer.class);
	}

	public int getCompletedStudents() {
	    String sql = "SELECT COUNT(*) FROM students WHERE status = 'COMPLETED'";
	    return template.queryForObject(sql, Integer.class);
	}
	
	public int getTotalCourses() {
	    String sql = "SELECT COUNT(DISTINCT course) FROM enrollments";
	    return template.queryForObject(sql, Integer.class);
	}


	public int getTotalFaculty() {
	    String sql = "SELECT COUNT(*) FROM users WHERE role = 'FACULTY'";
	    return template.queryForObject(sql, Integer.class);
	}


	public int getTotalBatches() {
	    String sql = "SELECT COUNT(DISTINCT batch) FROM enrollments";
	    return template.queryForObject(sql, Integer.class);
	}
	///////////////////////////////
	public StudentModel getStudentByUsername(String username) {

	    String sql =
	        "SELECT s.id, s.user_id, s.student_name, s.email, s.mobile, " +
	        "s.gender, s.dob, s.address, s.admission_date, s.status, " +
	        "u.username, " +
	        "e.id AS enrollment_id, e.course, e.batch, " +
	        "e.enrollment_date, e.status AS enrollment_status, " +
	        "c.duration AS course_duration, c.fees AS course_fees " +
	        "FROM students s " +
	        "INNER JOIN users u ON s.user_id = u.id " +
	        "LEFT JOIN enrollments e ON s.id = e.student_id " +
	        "LEFT JOIN courses c ON e.course = c.course_name " +
	        "WHERE u.username = ? " +
	        "ORDER BY e.id DESC LIMIT 1";

	    List<StudentModel> list = template.query(
	        sql,
	        (rs, rowNum) -> {

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
	                student.setAdmissionDate(
	                    rs.getDate("admission_date").toLocalDate()
	                );
	            }

	            student.setStatus(rs.getString("status"));
	            student.setUsername(rs.getString("username"));

	            student.setEnrollmentId(
	                rs.getInt("enrollment_id")
	            );

	            student.setCourse(rs.getString("course"));
	            student.setBatch(rs.getString("batch"));

	            if (rs.getDate("enrollment_date") != null) {
	                student.setEnrollmentDate(
	                    rs.getDate("enrollment_date").toLocalDate()
	                );
	            }

	            student.setEnrollmentStatus(
	                rs.getString("enrollment_status")
	            );

	            student.setCourseDuration(
	                rs.getString("course_duration")
	            );

	            student.setCourseFees(
	                rs.getDouble("course_fees")
	            );

	            return student;
	        },
	        username
	    );

	    if (list.isEmpty()) {
	        return null;
	    }

	    return list.get(0);
	}
}