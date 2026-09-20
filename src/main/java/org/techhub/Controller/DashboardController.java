package org.techhub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.techhub.Service.StudentService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
public class DashboardController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/dashboard")
	public String dashboard(Model model) {

	    model.addAttribute("totalStudents",
	            studentService.getTotalStudents());

	    model.addAttribute("activeStudents",
	            studentService.getActiveStudents());

	    model.addAttribute("inactiveStudents",
	            studentService.getInactiveStudents());

	    model.addAttribute("completedStudents",
	            studentService.getCompletedStudents());

	    return "Admin/Dashboard";
	}
}
