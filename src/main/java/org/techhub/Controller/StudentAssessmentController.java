package org.techhub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.techhub.Model.AssessmentModel;
import org.techhub.Model.LoginModel;
import org.techhub.Model.StudentModel;
import org.techhub.Service.AssessmentService;
import org.techhub.Service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class StudentAssessmentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private AssessmentService assessmentService;

	// =====================================================
	// MY ASSESSMENTS
	// =====================================================

	@GetMapping("/assessments")
	public String myAssessments(HttpSession session, Model model) {

		// Logged-in user check
		LoginModel loggedUser = (LoginModel) session.getAttribute("loggedUser");

		if (loggedUser == null) {
			return "redirect:/loginPage";
		}

		// Get student using logged-in username
		StudentModel student = studentService.getStudentByUsername(loggedUser.getUsername());

		if (student == null) {
			return "redirect:/loginPage";
		}

		// Get student's batch
		String batchName = student.getBatch();

		// Get assessments for student's batch
		List<AssessmentModel> assessmentList = assessmentService.getAssessmentsByBatch(batchName);

		// Send data to JSP
		model.addAttribute("student", student);

		model.addAttribute("assessmentList", assessmentList);

		return "Student/MyAssessments";
	}
}