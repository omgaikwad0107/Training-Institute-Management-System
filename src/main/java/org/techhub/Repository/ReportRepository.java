package org.techhub.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.techhub.Model.ReportModel;

@Repository
public class ReportRepository {

    @Autowired
    private JdbcTemplate template;


    // =========================
    // STUDENTS
    // =========================

    public int getTotalStudents() {

        String sql = "SELECT COUNT(*) FROM students";

        return template.queryForObject(sql, Integer.class);
    }


    public int getActiveStudents() {

        String sql =
                "SELECT COUNT(*) FROM students WHERE status = 'ACTIVE'";

        return template.queryForObject(sql, Integer.class);
    }


    public int getInactiveStudents() {

        String sql =
                "SELECT COUNT(*) FROM students WHERE status = 'INACTIVE'";

        return template.queryForObject(sql, Integer.class);
    }


    public int getCompletedStudents() {

        String sql =
                "SELECT COUNT(*) FROM students WHERE status = 'COMPLETED'";

        return template.queryForObject(sql, Integer.class);
    }


    // =========================
    // COURSES
    // =========================

    public int getTotalCourses() {

        String sql = "SELECT COUNT(*) FROM courses";

        return template.queryForObject(sql, Integer.class);
    }


    public int getActiveCourses() {

        String sql =
                "SELECT COUNT(*) FROM courses WHERE status = 'ACTIVE'";

        return template.queryForObject(sql, Integer.class);
    }


    // =========================
    // FACULTY
    // =========================

    public int getTotalFaculty() {

        String sql = "SELECT COUNT(*) FROM faculty";

        return template.queryForObject(sql, Integer.class);
    }


    public int getActiveFaculty() {

        String sql =
                "SELECT COUNT(*) FROM faculty WHERE status = 'ACTIVE'";

        return template.queryForObject(sql, Integer.class);
    }


    // =========================
    // BATCHES
    // =========================

    public int getTotalBatches() {

        String sql = "SELECT COUNT(*) FROM batches";

        return template.queryForObject(sql, Integer.class);
    }


    public int getActiveBatches() {

        String sql =
                "SELECT COUNT(*) FROM batches WHERE status = 'ACTIVE'";

        return template.queryForObject(sql, Integer.class);
    }


    // =========================
    // ATTENDANCE
    // =========================

    public int getTotalAttendanceRecords() {

        String sql =
                "SELECT COUNT(*) FROM attendance";

        return template.queryForObject(sql, Integer.class);
    }


    public int getTotalPresent() {

        String sql =
                "SELECT COUNT(*) FROM attendance WHERE status = 'PRESENT'";

        return template.queryForObject(sql, Integer.class);
    }


    public int getTotalAbsent() {

        String sql =
                "SELECT COUNT(*) FROM attendance WHERE status = 'ABSENT'";

        return template.queryForObject(sql, Integer.class);
    }


    // =========================
    // ASSESSMENTS
    // =========================

    public int getTotalAssessments() {

        String sql =
                "SELECT COUNT(*) FROM assessments";

        return template.queryForObject(sql, Integer.class);
    }


    public int getUpcomingAssessments() {

        String sql =
                "SELECT COUNT(*) FROM assessments " +
                "WHERE status = 'UPCOMING'";

        return template.queryForObject(sql, Integer.class);
    }


    public int getCompletedAssessments() {

        String sql =
                "SELECT COUNT(*) FROM assessments " +
                "WHERE status = 'COMPLETED'";

        return template.queryForObject(sql, Integer.class);
    }


    // =========================
    // COMPLETE REPORT
    // =========================

    public ReportModel getReport() {

        ReportModel report = new ReportModel();


        // Students

        report.setTotalStudents(getTotalStudents());
        report.setActiveStudents(getActiveStudents());
        report.setInactiveStudents(getInactiveStudents());
        report.setCompletedStudents(getCompletedStudents());


        // Courses

        report.setTotalCourses(getTotalCourses());
        report.setActiveCourses(getActiveCourses());


        // Faculty

        report.setTotalFaculty(getTotalFaculty());
        report.setActiveFaculty(getActiveFaculty());


        // Batches

        report.setTotalBatches(getTotalBatches());
        report.setActiveBatches(getActiveBatches());


        // Attendance

        int totalAttendance = getTotalAttendanceRecords();
        int totalPresent = getTotalPresent();
        int totalAbsent = getTotalAbsent();

        report.setTotalAttendanceRecords(totalAttendance);
        report.setTotalPresent(totalPresent);
        report.setTotalAbsent(totalAbsent);


        double attendancePercentage = 0;

        if (totalAttendance > 0) {

            attendancePercentage =
                    ((double) totalPresent / totalAttendance) * 100;

        }

        report.setAttendancePercentage(attendancePercentage);


        // Assessments

        report.setTotalAssessments(getTotalAssessments());
        report.setUpcomingAssessments(getUpcomingAssessments());
        report.setCompletedAssessments(getCompletedAssessments());


        return report;
    }
}