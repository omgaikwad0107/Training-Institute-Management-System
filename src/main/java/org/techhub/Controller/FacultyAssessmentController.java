package org.techhub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.techhub.Model.AssessmentModel;
import org.techhub.Model.LoginModel;
import org.techhub.Service.FacultyAssessmentService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/faculty")
public class FacultyAssessmentController {

    @Autowired
    private FacultyAssessmentService
            facultyAssessmentService;


    // Assessment list
    @GetMapping("/assessments")
    public String assessments(
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

        List<AssessmentModel> assessmentList =
                facultyAssessmentService
                .getAssessmentsByFacultyUsername(
                        username
                );

        model.addAttribute(
                "assessmentList",
                assessmentList
        );

        model.addAttribute(
                "totalAssessments",
                assessmentList.size()
        );

        return "Faculty/FacultyAssessments";
    }


    // Add assessment page
    @GetMapping("/assessments/add")
    public String addAssessment(
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

        List<String> batchList =
                facultyAssessmentService
                .getBatchesByFacultyUsername(
                        username
                );

        model.addAttribute(
                "batchList",
                batchList
        );

        return "Faculty/AddAssessment";
    }


    // Save assessment
    @PostMapping("/assessments/save")
    public String saveAssessment(
            AssessmentModel assessment,
            HttpSession session,
            RedirectAttributes redirectAttributes) {

        LoginModel loggedUser =
                (LoginModel) session
                .getAttribute("loggedUser");

        if (loggedUser == null) {
            return "redirect:/loginPage";
        }

        boolean saved =
                facultyAssessmentService
                .saveAssessment(
                        assessment,
                        loggedUser.getUsername()
                );

        if (saved) {

            redirectAttributes
                    .addFlashAttribute(
                            "successMessage",
                            "Assessment created successfully."
                    );

        } else {

            redirectAttributes
                    .addFlashAttribute(
                            "errorMessage",
                            "Unable to create assessment."
                    );
        }

        return "redirect:/faculty/assessments";
    }


    // Delete assessment
    @GetMapping("/assessments/delete")
    public String deleteAssessment(
            @RequestParam("id") int id,
            HttpSession session,
            RedirectAttributes redirectAttributes) {

        LoginModel loggedUser =
                (LoginModel) session
                .getAttribute("loggedUser");

        if (loggedUser == null) {
            return "redirect:/loginPage";
        }

        boolean deleted =
                facultyAssessmentService
                .deleteAssessment(
                        id,
                        loggedUser.getUsername()
                );

        if (deleted) {

            redirectAttributes
                    .addFlashAttribute(
                            "successMessage",
                            "Assessment deleted successfully."
                    );

        } else {

            redirectAttributes
                    .addFlashAttribute(
                            "errorMessage",
                            "Unable to delete assessment."
                    );
        }

        return "redirect:/faculty/assessments";
    }
}