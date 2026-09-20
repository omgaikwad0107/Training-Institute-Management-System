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

import org.techhub.Model.FacultyResultModel;
import org.techhub.Model.LoginModel;
import org.techhub.Service.FacultyResultService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/faculty")
public class FacultyResultController {


    @Autowired
    private FacultyResultService facultyResultService;


    // --------------------------------------------------
    // Student Results page
    // --------------------------------------------------

    @GetMapping("/results")
    public String results(
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


        List<FacultyResultModel> assessmentList =
                facultyResultService
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


        return "Faculty/FacultyResults";
    }


    // --------------------------------------------------
    // Enter results page
    // --------------------------------------------------

    @GetMapping("/results/enter")
    public String enterResults(
            @RequestParam("assessmentId") int assessmentId,
            HttpSession session,
            Model model,
            RedirectAttributes redirectAttributes) {


        LoginModel loggedUser =
                (LoginModel) session
                .getAttribute("loggedUser");


        if (loggedUser == null) {
            return "redirect:/loginPage";
        }


        String username =
                loggedUser.getUsername();


        boolean assigned =
                facultyResultService
                .isAssessmentAssignedToFaculty(
                        assessmentId,
                        username
                );


        if (!assigned) {

            redirectAttributes
                    .addFlashAttribute(
                            "errorMessage",
                            "Invalid assessment."
                    );

            return "redirect:/faculty/results";
        }


        List<FacultyResultModel> studentList =
                facultyResultService
                .getStudentsByAssessment(
                        assessmentId
                );


        model.addAttribute(
                "studentList",
                studentList
        );


        model.addAttribute(
                "assessmentId",
                assessmentId
        );


        if (!studentList.isEmpty()) {

            model.addAttribute(
                    "assessment",
                    studentList.get(0)
            );
        }


        return "Faculty/EnterResults";
    }


    // --------------------------------------------------
    // Save result
    // --------------------------------------------------

    @PostMapping("/results/save")
    public String saveResult(
            @RequestParam("studentId") int studentId,
            @RequestParam("assessmentId") int assessmentId,
            @RequestParam("marksObtained") int marksObtained,
            @RequestParam("resultStatus") String resultStatus,
            @RequestParam(value = "remarks",
                    required = false) String remarks,
            HttpSession session,
            RedirectAttributes redirectAttributes) {


        LoginModel loggedUser =
                (LoginModel) session
                .getAttribute("loggedUser");


        if (loggedUser == null) {
            return "redirect:/loginPage";
        }


        boolean saved =
                facultyResultService
                .saveResult(
                        studentId,
                        assessmentId,
                        marksObtained,
                        resultStatus,
                        remarks,
                        loggedUser.getUsername()
                );


        if (saved) {

            redirectAttributes
                    .addFlashAttribute(
                            "successMessage",
                            "Result saved successfully."
                    );

        } else {

            redirectAttributes
                    .addFlashAttribute(
                            "errorMessage",
                            "Unable to save result."
                    );
        }


        return "redirect:/faculty/results/enter?assessmentId="
                + assessmentId;
    }
}