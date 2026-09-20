package org.techhub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

import org.techhub.Model.LoginModel;
import org.techhub.Service.BatchService;
import org.techhub.Service.CourseService;
import org.techhub.Service.FacultyService;
import org.techhub.Service.StudentService;
import org.techhub.Service.loginService;

@Controller
public class HomeController {

    @Autowired
    private loginService service;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private BatchService batchService;

    @Autowired
    private FacultyService facultyService;

    // Home Page
    @RequestMapping("/")
    public String homePage() {
        return "homePage";
    }

    // Login Page
    @RequestMapping("/loginPage")
    public String loginPage() {
        return "loginPage";
    }

    // Verify User
    @RequestMapping("/VerifyUser")
    public String VerifyUser(LoginModel model, HttpSession session) {

        LoginModel user = service.isVerifyUser(model);

        if (user == null) {
            return "loginPage";
        }

        // Login user session save
        session.setAttribute("loggedUser", user);

        // Role based redirect
        if (user.getRole().equalsIgnoreCase("ADMIN")) {
            return "redirect:/Dashboard";
        }

        if (user.getRole().equalsIgnoreCase("STUDENT")) {
            return "redirect:/student/dashboard";
        }

        if (user.getRole().equalsIgnoreCase("FACULTY")) {
            return "redirect:/faculty/dashboard";
        }

        return "loginPage";
    }

    // Student Management
    @RequestMapping("/StudentManagement")
    public String StudentManagement(Model model) {

        model.addAttribute(
                "totalStudents",
                studentService.getTotalStudents()
        );

        model.addAttribute(
                "activeStudents",
                studentService.getActiveStudents()
        );

        model.addAttribute(
                "inactiveStudents",
                studentService.getInactiveStudents()
        );

        model.addAttribute(
                "completedStudents",
                studentService.getCompletedStudents()
        );

        return "Admin/StudentManagement";
    }

    // Admin Dashboard
    @GetMapping("/Dashboard")
    public String dashboard(Model model) {

        int totalStudents =
                studentService.getTotalStudents();

        int totalCourses =
                courseService.getTotalCourses();

        int totalFaculty =
                facultyService.getTotalFaculty();

        int totalBatches =
                batchService.getTotalBatches();

        model.addAttribute(
                "totalStudents",
                totalStudents
        );

        model.addAttribute(
                "totalCourses",
                totalCourses
        );

        model.addAttribute(
                "totalFaculty",
                totalFaculty
        );

        model.addAttribute(
                "totalBatches",
                totalBatches
        );

        return "Admin/AdminDashboard";
    }

    // Add Student Page
    @RequestMapping("/addStudent")
    public String addStudent(Model model) {

        model.addAttribute(
                "courses",
                courseService.getActiveCourses()
        );

        model.addAttribute(
                "batches",
                batchService.getActiveBatches()
        );

        return "Admin/addStudent";
    }

    // Logout
    @RequestMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/loginPage";
    }
}