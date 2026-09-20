package org.techhub.Model;

import java.time.LocalDate;

public class BatchModel {

    private int id;

    private String batchName;

    private String courseName;

    private LocalDate startDate;

    private LocalDate endDate;

    private String status;

    private int facultyId;

    private int studentCount;


    // =====================================================
    // DEFAULT CONSTRUCTOR
    // =====================================================

    public BatchModel() {

    }


    // =====================================================
    // GETTERS AND SETTERS
    // =====================================================

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


    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }


    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }


    // =====================================================
    // STUDENT COUNT
    // =====================================================

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }


    // =====================================================
    // TO STRING
    // =====================================================

    @Override
    public String toString() {

        return "BatchModel [id=" + id
                + ", batchName=" + batchName
                + ", courseName=" + courseName
                + ", startDate=" + startDate
                + ", endDate=" + endDate
                + ", status=" + status
                + ", facultyId=" + facultyId
                + ", studentCount=" + studentCount
                + "]";
    }
}