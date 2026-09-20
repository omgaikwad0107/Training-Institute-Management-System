package org.techhub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.techhub.Model.LoginModel;
import org.techhub.Model.ResultModel;
import org.techhub.Model.StudentModel;
import org.techhub.Service.ResultService;
import org.techhub.Service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class ResultController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private ResultService resultService;

	// STUDENT - MY RESULTS
	@GetMapping("/results")
	public String myResults(HttpSession session, Model model) {

		LoginModel loggedUser = (LoginModel) session.getAttribute("loggedUser");

		if (loggedUser == null) {
			return "redirect:/loginPage";
		}

		StudentModel student = studentService.getStudentByUsername(loggedUser.getUsername());

		if (student == null) {
			return "redirect:/loginPage";
		}

		int studentId = student.getId();

		List<ResultModel> resultList = resultService.getResultsByStudentId(studentId);

		model.addAttribute("student", student);

		model.addAttribute("resultList", resultList);

		return "Student/MyResults";
	}
}