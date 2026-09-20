package org.techhub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.techhub.Model.LoginModel;
import org.techhub.Model.StudentModel;
import org.techhub.Service.FacultyStudentService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/faculty")
public class FacultyStudentController {

	@Autowired
	private FacultyStudentService facultyStudentService;

	@GetMapping("/students")
	public String myStudents(HttpSession session, Model model) {

		LoginModel loggedUser = (LoginModel) session.getAttribute("loggedUser");

		if (loggedUser == null) {
			return "redirect:/loginPage";
		}

		List<StudentModel> studentList = facultyStudentService.getStudentsByFacultyUsername(loggedUser.getUsername());

		model.addAttribute("studentList", studentList);
		model.addAttribute("totalStudents", studentList.size());

		return "Faculty/MyStudents";
	}
}