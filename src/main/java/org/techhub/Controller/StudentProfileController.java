package org.techhub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.techhub.Model.LoginModel;
import org.techhub.Model.StudentModel;
import org.techhub.Service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class StudentProfileController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/profile")
	public String myProfile(HttpSession session, Model model) {

		LoginModel loggedUser = (LoginModel) session.getAttribute("loggedUser");

		// Login check
		if (loggedUser == null) {
			return "redirect:/loginPage";
		}

		// Get student details
		StudentModel student = studentService.getStudentByUsername(loggedUser.getUsername());

		// Student not found
		if (student == null) {
			return "redirect:/loginPage";
		}

		// Send student data to JSP
		model.addAttribute("student", student);

		return "Student/MyProfile";
	}
}