package org.techhub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

import org.techhub.Model.LoginModel;
import org.techhub.Model.StudentModel;
import org.techhub.Service.AttendanceService;
import org.techhub.Service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentAttendanceController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private AttendanceService attendanceService;


    @GetMapping("/attendance")
    public String attendance(
            HttpSession session,
            Model model) {

        // Check login
        LoginModel loggedUser =
                (LoginModel) session.getAttribute("loggedUser");

        if (loggedUser == null) {
            return "redirect:/loginPage";
        }


        // Get student
        StudentModel student =
                studentService.getStudentByUsername(
                        loggedUser.getUsername()
                );

        if (student == null) {
            return "redirect:/loginPage";
        }


        int studentId = student.getId();


        // Attendance data
        int totalClasses =
                attendanceService.getTotalClasses(studentId);

        int presentClasses =
                attendanceService.getPresentClasses(studentId);

        int absentClasses =
                attendanceService.getAbsentClasses(studentId);

        double attendancePercentage =
                attendanceService.getAttendancePercentage(studentId);


        // Add data to JSP
        model.addAttribute("student", student);

        model.addAttribute(
                "totalClasses",
                totalClasses
        );

        model.addAttribute(
                "presentClasses",
                presentClasses
        );

        model.addAttribute(
                "absentClasses",
                absentClasses
        );

        model.addAttribute(
                "attendancePercentage",
                attendancePercentage
        );

        model.addAttribute(
                "attendanceList",
                attendanceService
                    .getAttendanceByStudentId(studentId)
        );


        return "Student/MyAttendance";
    }
}