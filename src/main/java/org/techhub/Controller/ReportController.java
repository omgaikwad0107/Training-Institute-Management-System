package org.techhub.Controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.techhub.Model.LoginModel;
import org.techhub.Model.ReportModel;
import org.techhub.Service.ReportService;


@Controller
@RequestMapping("/admin")
public class ReportController {


    @Autowired
    private ReportService reportService;


    @GetMapping("/reports")
    public String reports(HttpSession session, Model model) {


        // =========================
        // SESSION CHECK
        // =========================

        LoginModel loggedUser =
                (LoginModel) session.getAttribute("loggedUser");


        if (loggedUser == null) {

            return "redirect:/loginPage";
        }


        // =========================
        // ADMIN CHECK
        // =========================

        if (!"ADMIN".equalsIgnoreCase(loggedUser.getRole())) {

            return "redirect:/loginPage";
        }


        // =========================
        // REPORT DATA
        // =========================

        ReportModel report =
                reportService.getReport();


        model.addAttribute("report", report);


        return "Admin/AdminReports";
    }
}