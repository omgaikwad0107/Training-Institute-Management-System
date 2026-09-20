package org.techhub.Model;

import java.time.LocalDate;

public class StudentModel {

	// students table

	private int id;
	private int userId;
	private String studentName;
	private String email;
	private String mobile;
	private String gender;
	private LocalDate dob;
	private String address;
	private LocalDate admissionDate;
	private String status;


	// users table

	private String username;
	private String password;
	private String role;


	// enrollments table

	private int enrollmentId;
	private String course;
	private String batch;
	private LocalDate enrollmentDate;
	private String enrollmentStatus;


	// course details - used for Student My Courses

	private String courseDuration;
	private double courseFees;


	public StudentModel() {

	}


	// Student ID

	public int getId() {

		return id;

	}

	public void setId(int id) {

		this.id = id;

	}


	// User ID

	public int getUserId() {

		return userId;

	}

	public void setUserId(int userId) {

		this.userId = userId;

	}


	// Student Name

	public String getStudentName() {

		return studentName;

	}

	public void setStudentName(String studentName) {

		this.studentName = studentName;

	}


	// Email

	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}


	// Mobile

	public String getMobile() {

		return mobile;

	}

	public void setMobile(String mobile) {

		this.mobile = mobile;

	}


	// Gender

	public String getGender() {

		return gender;

	}

	public void setGender(String gender) {

		this.gender = gender;

	}


	// DOB

	public LocalDate getDob() {

		return dob;

	}

	public void setDob(LocalDate dob) {

		this.dob = dob;

	}


	// Address

	public String getAddress() {

		return address;

	}

	public void setAddress(String address) {

		this.address = address;

	}


	// Admission Date

	public LocalDate getAdmissionDate() {

		return admissionDate;

	}

	public void setAdmissionDate(LocalDate admissionDate) {

		this.admissionDate = admissionDate;

	}


	// Student Status

	public String getStatus() {

		return status;

	}

	public void setStatus(String status) {

		this.status = status;

	}


	// Username

	public String getUsername() {

		return username;

	}

	public void setUsername(String username) {

		this.username = username;

	}


	// Password

	public String getPassword() {

		return password;

	}

	public void setPassword(String password) {

		this.password = password;

	}


	// Role

	public String getRole() {

		return role;

	}

	public void setRole(String role) {

		this.role = role;

	}


	// Enrollment ID

	public int getEnrollmentId() {

		return enrollmentId;

	}

	public void setEnrollmentId(int enrollmentId) {

		this.enrollmentId = enrollmentId;

	}


	// Course

	public String getCourse() {

		return course;

	}

	public void setCourse(String course) {

		this.course = course;

	}


	// Batch

	public String getBatch() {

		return batch;

	}

	public void setBatch(String batch) {

		this.batch = batch;

	}


	// Enrollment Date

	public LocalDate getEnrollmentDate() {

		return enrollmentDate;

	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {

		this.enrollmentDate = enrollmentDate;

	}


	// Enrollment Status

	public String getEnrollmentStatus() {

		return enrollmentStatus;

	}

	public void setEnrollmentStatus(String enrollmentStatus) {

		this.enrollmentStatus = enrollmentStatus;

	}


	// Course Duration

	public String getCourseDuration() {

		return courseDuration;

	}

	public void setCourseDuration(String courseDuration) {

		this.courseDuration = courseDuration;

	}


	// Course Fees

	public double getCourseFees() {

		return courseFees;

	}

	public void setCourseFees(double courseFees) {

		this.courseFees = courseFees;

	}


	@Override
	public String toString() {

		return "StudentModel{" +
				"id=" + id +
				", userId=" + userId +
				", studentName='" + studentName + '\'' +
				", email='" + email + '\'' +
				", mobile='" + mobile + '\'' +
				", gender='" + gender + '\'' +
				", dob=" + dob +
				", address='" + address + '\'' +
				", username='" + username + '\'' +
				", course='" + course + '\'' +
				", batch='" + batch + '\'' +
				", status='" + status + '\'' +
				'}';
	}

}