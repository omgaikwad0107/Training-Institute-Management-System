package org.techhub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.techhub.Model.AssessmentModel;
import org.techhub.Model.LoginModel;
import org.techhub.Model.ResultModel;
import org.techhub.Model.StudentModel;

import org.techhub.Service.AssessmentService;
import org.techhub.Service.AttendanceService;
import org.techhub.Service.ResultService;
import org.techhub.Service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class StudentPortalController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private AttendanceService attendanceService;

	@Autowired
	private AssessmentService assessmentService;

	@Autowired
	private ResultService resultService;

	@GetMapping("/dashboard")
	public String studentDashboard(HttpSession session, Model model) {

		LoginModel loggedUser = (LoginModel) session.getAttribute("loggedUser");

		if (loggedUser == null) {
			return "redirect:/loginPage";
		}

		StudentModel student = studentService.getStudentByUsername(loggedUser.getUsername());

		if (student == null) {
			return "redirect:/loginPage";
		}

		int studentId = student.getId();

		// Attendance
		int totalClasses = attendanceService.getTotalClasses(studentId);

		int presentClasses = attendanceService.getPresentClasses(studentId);

		int absentClasses = attendanceService.getAbsentClasses(studentId);

		double attendancePercentage = attendanceService.getAttendancePercentage(studentId);

		// Assessments
		List<AssessmentModel> assessmentList = assessmentService.getAssessmentsByBatch(student.getBatch());

		// Results
		List<ResultModel> resultList = resultService.getResultsByStudentId(studentId);

		// Course count
		int courseCount = 0;

		if (student.getCourse() != null && !student.getCourse().trim().isEmpty()) {

			courseCount = 1;
		}

		// Completed assessments
		int completedAssessmentCount = resultList.size();

		// Send data to JSP
		model.addAttribute("student", student);

		model.addAttribute("courseCount", courseCount);

		model.addAttribute("totalClasses", totalClasses);
		model.addAttribute("presentClasses", presentClasses);
		model.addAttribute("absentClasses", absentClasses);
		model.addAttribute("attendancePercentage", attendancePercentage);

		model.addAttribute("assessmentList", assessmentList);

		model.addAttribute("completedAssessmentCount", completedAssessmentCount);

		model.addAttribute("resultList", resultList);

		return "Student/StudentDashboard";
	}

	@GetMapping("/courses")
	public String myCourses(HttpSession session, Model model) {

		LoginModel loggedUser = (LoginModel) session.getAttribute("loggedUser");

		if (loggedUser == null) {
			return "redirect:/loginPage";
		}

		StudentModel student = studentService.getStudentByUsername(loggedUser.getUsername());

		if (student == null) {
			return "redirect:/loginPage";
		}

		model.addAttribute("student", student);

		return "Student/MyCourses";
	}

	@GetMapping("/batches")
	public String myBatches(HttpSession session, Model model) {

		LoginModel loggedUser = (LoginModel) session.getAttribute("loggedUser");

		if (loggedUser == null) {
			return "redirect:/loginPage";
		}

		StudentModel student = studentService.getStudentByUsername(loggedUser.getUsername());

		if (student == null) {
			return "redirect:/loginPage";
		}

		model.addAttribute("student", student);

		return "Student/MyBatches";
	}
}