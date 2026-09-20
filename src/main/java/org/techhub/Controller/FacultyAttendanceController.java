package org.techhub.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.techhub.Model.FacultyAttendanceModel;
import org.techhub.Model.LoginModel;
import org.techhub.Service.FacultyAttendanceService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/faculty")
public class FacultyAttendanceController {

    @Autowired
    private FacultyAttendanceService
            facultyAttendanceService;


    @GetMapping("/attendance")
    public String attendance(
            HttpSession session,
            Model model) {

        LoginModel loggedUser =
                (LoginModel) session
                .getAttribute("loggedUser");

        if (loggedUser == null) {
            return "redirect:/loginPage";
        }

        String username =
                loggedUser.getUsername();

        List<FacultyAttendanceModel> studentList =
                facultyAttendanceService
                .getStudentsByFacultyUsername(username);

        model.addAttribute(
                "studentList",
                studentList
        );

        model.addAttribute(
                "today",
                LocalDate.now()
        );

        model.addAttribute(
                "totalStudents",
                studentList.size()
        );

        return "Faculty/FacultyAttendance";
    }


    @PostMapping("/attendance/save")
    public String saveAttendance(
            @RequestParam("studentId")
            int studentId,

            @RequestParam("attendanceDate")
            String attendanceDate,

            @RequestParam("status")
            String status,

            @RequestParam(value = "remarks",
                          required = false)
            String remarks,

            HttpSession session,
            RedirectAttributes redirectAttributes) {

        LoginModel loggedUser =
                (LoginModel) session
                .getAttribute("loggedUser");

        if (loggedUser == null) {
            return "redirect:/loginPage";
        }

        LocalDate date =
                LocalDate.parse(attendanceDate);

        boolean saved =
                facultyAttendanceService
                .saveAttendance(
                        studentId,
                        date,
                        status,
                        remarks,
                        loggedUser.getUsername()
                );

        if (saved) {

            redirectAttributes
                    .addFlashAttribute(
                            "successMessage",
                            "Attendance saved successfully."
                    );

        } else {

            redirectAttributes
                    .addFlashAttribute(
                            "errorMessage",
                            "Unable to save attendance."
                    );
        }

        return "redirect:/faculty/attendance";
    }
}