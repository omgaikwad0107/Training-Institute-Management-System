package org.techhub.Model;

import java.time.LocalDate;

public class AssessmentModel {

    private int id;

    private String batchName;
    private String courseName;
    private String assessmentName;
    private LocalDate assessmentDate;
    private int totalMarks;
    private String status;
    private LocalDate createdAt;


    public AssessmentModel() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
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


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }


    @Override
    public String toString() {

        return "AssessmentModel{" +
                "id=" + id +
                ", batchName='" + batchName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", assessmentName='" + assessmentName + '\'' +
                ", assessmentDate=" + assessmentDate +
                ", totalMarks=" + totalMarks +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}