package org.techhub.Controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.techhub.Model.AssessmentModel;
import org.techhub.Model.LoginModel;
import org.techhub.Service.AdminAssessmentService;
import org.techhub.Service.CourseService;
import org.techhub.Service.BatchService;

@Controller
@RequestMapping("/admin")
public class AdminAssessmentController {

    @Autowired
    private AdminAssessmentService assessmentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private BatchService batchService;


    @GetMapping("/assessments")
    public String assessments(

            @RequestParam(value = "course", required = false)
            String course,

            @RequestParam(value = "batch", required = false)
            String batch,

            @RequestParam(value = "status", required = false)
            String status,

            HttpSession session,
            Model model) {

        LoginModel loggedUser =
                (LoginModel) session.getAttribute("loggedUser");

        // Session check
        if (loggedUser == null) {
            return "redirect:/loginPage";
        }

        // Admin role check
        if (!"ADMIN".equalsIgnoreCase(loggedUser.getRole())) {
            return "redirect:/loginPage";
        }


        // =====================================================
        // DYNAMIC COURSE & BATCH DATA
        // =====================================================

        model.addAttribute(
                "courses",
                courseService.getActiveCourses()
        );

        model.addAttribute(
                "batches",
                batchService.getActiveBatches()
        );


        // =====================================================
        // ASSESSMENT FILTER
        // =====================================================

        List<AssessmentModel> assessmentList;


        if (course != null && !course.trim().isEmpty()) {

            assessmentList =
                    assessmentService.getAssessmentsByCourse(course);

            model.addAttribute("selectedCourse", course);

        }

        else if (batch != null && !batch.trim().isEmpty()) {

            assessmentList =
                    assessmentService.getAssessmentsByBatch(batch);

            model.addAttribute("selectedBatch", batch);

        }

        else if (status != null && !status.trim().isEmpty()) {

            assessmentList =
                    assessmentService.getAssessmentsByStatus(status);

            model.addAttribute("selectedStatus", status);

        }

        else {

            assessmentList =
                    assessmentService.getAllAssessments();
        }


        // =====================================================
        // TABLE DATA
        // =====================================================

        model.addAttribute(
                "assessmentList",
                assessmentList
        );


        // =====================================================
        // SUMMARY COUNTS
        // =====================================================

        model.addAttribute(
                "totalAssessments",
                assessmentService.getTotalAssessments()
        );

        model.addAttribute(
                "totalUpcoming",
                assessmentService.getTotalUpcoming()
        );

        model.addAttribute(
                "totalCompleted",
                assessmentService.getTotalCompleted()
        );


        return "Admin/AdminAssessments";
    }
}