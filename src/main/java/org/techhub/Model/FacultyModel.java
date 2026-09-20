package org.techhub.Model;

import java.time.LocalDate;

public class FacultyModel {

    private int id;
    private int userId;

    private String facultyName;
    private String email;
    private String mobile;
    private String gender;
    private LocalDate dob;
    private String address;
    private LocalDate joiningDate;
    private String specialization;
    private String status;

    private String username;
    private String password;
    private String role;


    public FacultyModel() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }


    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "FacultyModel [id=" + id
                + ", userId=" + userId
                + ", facultyName=" + facultyName
                + ", email=" + email
                + ", mobile=" + mobile
                + ", gender=" + gender
                + ", dob=" + dob
                + ", address=" + address
                + ", joiningDate=" + joiningDate
                + ", specialization=" + specialization
                + ", status=" + status
                + ", username=" + username
                + ", role=" + role
                + "]";
    }
}