package org.techhub.Model;

public class ReportModel {

	private int totalStudents;
	private int activeStudents;
	private int inactiveStudents;
	private int completedStudents;

	private int totalCourses;
	private int activeCourses;

	private int totalFaculty;
	private int activeFaculty;

	private int totalBatches;
	private int activeBatches;

	private int totalAttendanceRecords;
	private int totalPresent;
	private int totalAbsent;
	private double attendancePercentage;

	private int totalAssessments;
	private int upcomingAssessments;
	private int completedAssessments;

	public ReportModel() {
	}

	public int getTotalStudents() {
		return totalStudents;
	}

	public void setTotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}

	public int getActiveStudents() {
		return activeStudents;
	}

	public void setActiveStudents(int activeStudents) {
		this.activeStudents = activeStudents;
	}

	public int getInactiveStudents() {
		return inactiveStudents;
	}

	public void setInactiveStudents(int inactiveStudents) {
		this.inactiveStudents = inactiveStudents;
	}

	public int getCompletedStudents() {
		return completedStudents;
	}

	public void setCompletedStudents(int completedStudents) {
		this.completedStudents = completedStudents;
	}

	public int getTotalCourses() {
		return totalCourses;
	}

	public void setTotalCourses(int totalCourses) {
		this.totalCourses = totalCourses;
	}

	public int getActiveCourses() {
		return activeCourses;
	}

	public void setActiveCourses(int activeCourses) {
		this.activeCourses = activeCourses;
	}

	public int getTotalFaculty() {
		return totalFaculty;
	}

	public void setTotalFaculty(int totalFaculty) {
		this.totalFaculty = totalFaculty;
	}

	public int getActiveFaculty() {
		return activeFaculty;
	}

	public void setActiveFaculty(int activeFaculty) {
		this.activeFaculty = activeFaculty;
	}

	public int getTotalBatches() {
		return totalBatches;
	}

	public void setTotalBatches(int totalBatches) {
		this.totalBatches = totalBatches;
	}

	public int getActiveBatches() {
		return activeBatches;
	}

	public void setActiveBatches(int activeBatches) {
		this.activeBatches = activeBatches;
	}

	public int getTotalAttendanceRecords() {
		return totalAttendanceRecords;
	}

	public void setTotalAttendanceRecords(int totalAttendanceRecords) {
		this.totalAttendanceRecords = totalAttendanceRecords;
	}

	public int getTotalPresent() {
		return totalPresent;
	}

	public void setTotalPresent(int totalPresent) {
		this.totalPresent = totalPresent;
	}

	public int getTotalAbsent() {
		return totalAbsent;
	}

	public void setTotalAbsent(int totalAbsent) {
		this.totalAbsent = totalAbsent;
	}

	public double getAttendancePercentage() {
		return attendancePercentage;
	}

	public void setAttendancePercentage(double attendancePercentage) {
		this.attendancePercentage = attendancePercentage;
	}

	public int getTotalAssessments() {
		return totalAssessments;
	}

	public void setTotalAssessments(int totalAssessments) {
		this.totalAssessments = totalAssessments;
	}

	public int getUpcomingAssessments() {
		return upcomingAssessments;
	}

	public void setUpcomingAssessments(int upcomingAssessments) {
		this.upcomingAssessments = upcomingAssessments;
	}

	public int getCompletedAssessments() {
		return completedAssessments;
	}

	public void setCompletedAssessments(int completedAssessments) {
		this.completedAssessments = completedAssessments;
	}
}