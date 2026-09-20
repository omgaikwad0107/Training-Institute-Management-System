package org.techhub.Model;

public class CourseModel {

	private int id;
	private String courseName;
	private String duration;
	private double fees;
	private String status;

	public CourseModel() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CourseModel [id=" + id + ", courseName=" + courseName + ", duration=" + duration + ", fees=" + fees
				+ ", status=" + status + "]";
	}
}