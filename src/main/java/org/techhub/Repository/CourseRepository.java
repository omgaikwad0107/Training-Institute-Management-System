package org.techhub.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.techhub.Model.CourseModel;

@Repository
public class CourseRepository {

	@Autowired
	private JdbcTemplate template;

	// Add Course
	public boolean saveCourse(CourseModel course) {

		String sql = "INSERT INTO courses " + "(course_name, duration, fees, status) " + "VALUES (?, ?, ?, ?)";

		int result = template.update(sql, course.getCourseName(), course.getDuration(), course.getFees(),
				course.getStatus());

		return result > 0;
	}

	// Get All Courses
	public List<CourseModel> getAllCourses() {

		String sql = "SELECT id, course_name, duration, fees, status " + "FROM courses ORDER BY id DESC";

		return template.query(sql, (rs, rowNum) -> {

			CourseModel course = new CourseModel();

			course.setId(rs.getInt("id"));
			course.setCourseName(rs.getString("course_name"));
			course.setDuration(rs.getString("duration"));
			course.setFees(rs.getDouble("fees"));
			course.setStatus(rs.getString("status"));

			return course;
		});
	}

	// Get Course By ID
	public CourseModel getCourseById(int id) {

		String sql = "SELECT id, course_name, duration, fees, status " + "FROM courses WHERE id = ?";

		List<CourseModel> list = template.query(sql, (rs, rowNum) -> {

			CourseModel course = new CourseModel();

			course.setId(rs.getInt("id"));
			course.setCourseName(rs.getString("course_name"));
			course.setDuration(rs.getString("duration"));
			course.setFees(rs.getDouble("fees"));
			course.setStatus(rs.getString("status"));

			return course;

		}, id);

		if (list.isEmpty()) {
			return null;
		}

		return list.get(0);
	}

	// Update Course
	public boolean updateCourse(CourseModel course) {

		String sql = "UPDATE courses SET " + "course_name = ?, duration = ?, fees = ?, status = ? " + "WHERE id = ?";

		int result = template.update(sql, course.getCourseName(), course.getDuration(), course.getFees(),
				course.getStatus(), course.getId());

		return result > 0;
	}

	// Delete Course
	public boolean deleteCourse(int id) {

		String sql = "DELETE FROM courses WHERE id = ?";

		int result = template.update(sql, id);

		return result > 0;
	}
	
	// Get Active Courses For Student
	public List<CourseModel> getActiveCourses() {

	    String sql = "SELECT id, course_name, duration, fees, status " +
	                 "FROM courses " +
	                 "WHERE status = 'ACTIVE' " +
	                 "ORDER BY course_name";

	    return template.query(sql, (rs, rowNum) -> {

	        CourseModel course = new CourseModel();

	        course.setId(rs.getInt("id"));
	        course.setCourseName(rs.getString("course_name"));
	        course.setDuration(rs.getString("duration"));
	        course.setFees(rs.getDouble("fees"));
	        course.setStatus(rs.getString("status"));

	        return course;
	    });
	}
	
	// Get Total Courses
	public int getTotalCourses() {

	    String sql = "SELECT COUNT(*) FROM courses";

	    return template.queryForObject(
	            sql,
	            Integer.class
	    );
	}
	
}