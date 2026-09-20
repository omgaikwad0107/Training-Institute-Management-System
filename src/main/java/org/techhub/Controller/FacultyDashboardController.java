package org.techhub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.techhub.Model.AssessmentModel;
import org.techhub.Model.BatchModel;
import org.techhub.Model.FacultyModel;
import org.techhub.Model.LoginModel;
import org.techhub.Model.StudentModel;

import org.techhub.Service.FacultyAssessmentService;
import org.techhub.Service.FacultyAttendanceService;
import org.techhub.Service.FacultyBatchService;
import org.techhub.Service.FacultyProfileService;
import org.techhub.Service.FacultyStudentService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/faculty")
public class FacultyDashboardController {

    @Autowired
    private FacultyStudentService facultyStudentService;

    @Autowired
    private FacultyBatchService facultyBatchService;

    @Autowired
    private FacultyAssessmentService facultyAssessmentService;

    @Autowired
    private FacultyAttendanceService facultyAttendanceService;

    @Autowired
    private FacultyProfileService facultyProfileService;


    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {

        // ==========================================
        // CHECK LOGIN
        // ==========================================

        LoginModel loggedUser =
                (LoginModel) session.getAttribute("loggedUser");

        if (loggedUser == null) {
            return "redirect:/loginPage";
        }


        String username = loggedUser.getUsername();


        // ==========================================
        // FACULTY PROFILE
        // ==========================================

        FacultyModel faculty =
                facultyProfileService
                        .getFacultyByUsername(username);

        String facultyName = username;

        if (faculty != null &&
            faculty.getFacultyName() != null &&
            !faculty.getFacultyName().trim().isEmpty()) {

            facultyName = faculty.getFacultyName();
        }


        // ==========================================
        // MY STUDENTS
        // ==========================================

        List<StudentModel> studentList =
                facultyStudentService
                        .getStudentsByFacultyUsername(username);

        int totalStudents =
                studentList.size();


        // ==========================================
        // MY BATCHES
        // ==========================================

        List<BatchModel> batchList =
                facultyBatchService
                        .getBatchesByFacultyUsername(username);

        int totalBatches =
                batchList.size();


        // ==========================================
        // MY ASSESSMENTS
        // ==========================================

        List<AssessmentModel> assessmentList =
                facultyAssessmentService
                        .getAssessmentsByFacultyUsername(username);

        int totalAssessments =
                assessmentList.size();


        // ==========================================
        // PENDING ASSESSMENTS
        // ==========================================

        int pendingAssessments = 0;

        for (AssessmentModel assessment : assessmentList) {

            if (assessment.getStatus() != null &&
                assessment.getStatus()
                          .equalsIgnoreCase("UPCOMING")) {

                pendingAssessments++;
            }
        }


        // ==========================================
        // TODAY'S ATTENDANCE
        // ==========================================

        int todayPresent =
                facultyAttendanceService
                        .getTodayPresentCountByFacultyUsername(username);


        // ==========================================
        // FACULTY INFORMATION
        // ==========================================

        model.addAttribute(
                "facultyName",
                facultyName
        );

        model.addAttribute(
                "facultyUsername",
                username
        );


        // ==========================================
        // DASHBOARD STATISTICS
        // ==========================================

        model.addAttribute(
                "totalStudents",
                totalStudents
        );

        model.addAttribute(
                "totalBatches",
                totalBatches
        );

        model.addAttribute(
                "totalAssessments",
                totalAssessments
        );

        model.addAttribute(
                "pendingAssessments",
                pendingAssessments
        );

        model.addAttribute(
                "todayPresent",
                todayPresent
        );


        // ==========================================
        // DASHBOARD LISTS
        // ==========================================

        model.addAttribute(
                "batchList",
                batchList
        );

        model.addAttribute(
                "assessmentList",
                assessmentList
        );


        // ==========================================
        // DASHBOARD PAGE
        // ==========================================

        return "Faculty/FacultyDashboard";
    }
}