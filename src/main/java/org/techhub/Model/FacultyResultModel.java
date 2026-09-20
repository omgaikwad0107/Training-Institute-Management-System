package org.techhub.Model;

import java.time.LocalDate;

public class FacultyResultModel {

    private int id;

    private int studentId;
    private String studentName;

    private int assessmentId;
    private String assessmentName;
    private String courseName;
    private String batchName;

    private LocalDate assessmentDate;

    private int totalMarks;
    private int marksObtained;

    private String resultStatus;
    private String remarks;


    public FacultyResultModel() {
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


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
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


    public LocalDate getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(LocalDate assessmentDate) {
        this.assessmentDate = assessmentDate;
    }


    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
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


    @Override
    public String toString() {

        return "FacultyResultModel{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", assessmentId=" + assessmentId +
                ", assessmentName='" + assessmentName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", batchName='" + batchName + '\'' +
                ", assessmentDate=" + assessmentDate +
                ", totalMarks=" + totalMarks +
                ", marksObtained=" + marksObtained +
                ", resultStatus='" + resultStatus + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';

    }
}