package org.techhub.Model;

import java.time.LocalDate;

public class ResultModel {

	private int id;

	private int studentId;
	private int assessmentId;

	private int marksObtained;
	private String resultStatus;
	private String remarks;
	private LocalDate createdAt;

	// Details from JOIN
	private String studentName;
	private String assessmentName;
	private String courseName;
	private String batchName;
	private int totalMarks;
	private LocalDate assessmentDate;

	public ResultModel() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}

	public int getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}

	public String getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAssessmentName() {
		return assessmentName;
	}

	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public LocalDate getAssessmentDate() {
		return assessmentDate;
	}

	public void setAssessmentDate(LocalDate assessmentDate) {
		this.assessmentDate = assessmentDate;
	}

	@Override
	public String toString() {

		return "ResultModel{" + "id=" + id + ", studentId=" + studentId + ", assessmentId=" + assessmentId
				+ ", marksObtained=" + marksObtained + ", resultStatus='" + resultStatus + '\'' + ", remarks='"
				+ remarks + '\'' + ", createdAt=" + createdAt + ", studentName='" + studentName + '\''
				+ ", assessmentName='" + assessmentName + '\'' + ", courseName='" + courseName + '\'' + ", batchName='"
				+ batchName + '\'' + ", totalMarks=" + totalMarks + ", assessmentDate=" + assessmentDate + '}';
	}
}