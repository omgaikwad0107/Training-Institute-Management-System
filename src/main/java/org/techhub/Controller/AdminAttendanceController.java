package org.techhub.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import org.techhub.Model.AdminAttendanceModel;
import org.techhub.Model.LoginModel;
import org.techhub.Service.AdminAttendanceService;

@Controller
@RequestMapping("/admin")
public class AdminAttendanceController {

    @Autowired
    private AdminAttendanceService attendanceService;


    @GetMapping("/attendance")
    public String attendance(
            @RequestParam(
                value = "date",
                required = false
            )
            String date,

            @RequestParam(
                value = "status",
                required = false
            )
            String status,

            HttpSession session,
            Model model) {


        LoginModel loggedUser =
                (LoginModel) session
                .getAttribute("loggedUser");


        // Login check
        if (loggedUser == null) {
            return "redirect:/loginPage";
        }


        // Admin role check
        if (!"ADMIN".equalsIgnoreCase(
                loggedUser.getRole())) {

            return "redirect:/loginPage";
        }


        List<AdminAttendanceModel> attendanceList;


        // Date filter
        if (date != null &&
            !date.trim().isEmpty()) {

            LocalDate selectedDate =
                    LocalDate.parse(date);

            attendanceList =
                    attendanceService
                    .getAttendanceByDate(
                            selectedDate
                    );

            model.addAttribute(
                    "selectedDate",
                    date
            );

        }

        // Status filter
        else if (status != null &&
                 !status.trim().isEmpty()) {

            attendanceList =
                    attendanceService
                    .getAttendanceByStatus(
                            status
                    );

            model.addAttribute(
                    "selectedStatus",
                    status
            );

        }

        // No filter
        else {

            attendanceList =
                    attendanceService
                    .getAllAttendance();
        }


        // Attendance data
        model.addAttribute(
                "attendanceList",
                attendanceList
        );

        model.addAttribute(
                "totalRecords",
                attendanceService
                .getTotalRecords()
        );

        model.addAttribute(
                "totalPresent",
                attendanceService
                .getTotalPresent()
        );

        model.addAttribute(
                "totalAbsent",
                attendanceService
                .getTotalAbsent()
        );

        model.addAttribute(
                "attendancePercentage",
                attendanceService
                .getAttendancePercentage()
        );


        return "Admin/AdminAttendance";
    }
}