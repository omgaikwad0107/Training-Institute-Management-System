package org.techhub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.techhub.Model.StudentModel;
import org.techhub.Service.BatchService;
import org.techhub.Service.CourseService;
import org.techhub.Service.StudentService;

@Controller
@RequestMapping("/admin/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private BatchService batchService;


    // =========================================================
    // STUDENT LIST
    // URL: /admin/students
    // =========================================================
    @GetMapping
    public String studentList(Model model) {

        List<StudentModel> students =
                studentService.getAllStudents();

        model.addAttribute("students", students);

        return "Admin/studentList";
    }


    // =========================================================
    // ADD STUDENT PAGE
    // URL: /admin/students/add
    // =========================================================
    @GetMapping("/add")
    public String addStudentPage(Model model) {

        model.addAttribute(
                "student",
                new StudentModel()
        );

        // Load active courses
        model.addAttribute(
                "courses",
                courseService.getActiveCourses()
        );

        // Load ALL active batches
        model.addAttribute(
                "batches",
                batchService.getActiveBatches()
        );

        return "Admin/addStudent";
    }


    // =========================================================
    // SAVE STUDENT
    // URL: /admin/students/save
    // =========================================================
    @PostMapping("/save")
    public String saveStudent(
            @ModelAttribute("student") StudentModel student,
            Model model) {

        boolean saved =
                studentService.saveStudent(student);

        if (saved) {
            return "redirect:/admin/students?success=true";
        }

        model.addAttribute(
                "error",
                "Unable to save student. Username or email may already exist."
        );

        model.addAttribute(
                "student",
                student
        );

        // Reload dropdown data if save fails
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


    // =========================================================
    // EDIT STUDENT
    // URL: /admin/students/edit/1
    // =========================================================
    @GetMapping("/edit/{id}")
    public String editStudent(
            @PathVariable("id") int id,
            Model model) {

        StudentModel student =
                studentService.getStudentById(id);

        if (student == null) {
            return "redirect:/admin/students?error=notfound";
        }

        model.addAttribute(
                "student",
                student
        );

        return "Admin/editStudent";
    }


    // =========================================================
    // UPDATE STUDENT
    // URL: /admin/students/update
    // =========================================================
    @PostMapping("/update")
    public String updateStudent(
            @ModelAttribute("student") StudentModel student,
            Model model) {

        boolean updated =
                studentService.updateStudent(student);

        if (updated) {
            return "redirect:/admin/students?updated=true";
        }

        model.addAttribute(
                "error",
                "Unable to update student."
        );

        model.addAttribute(
                "student",
                student
        );

        return "Admin/editStudent";
    }


    // =========================================================
    // DELETE STUDENT
    // URL: /admin/students/delete/1
    // =========================================================
    @GetMapping("/delete/{id}")
    public String deleteStudent(
            @PathVariable("id") int id) {

        boolean deleted =
                studentService.deleteStudent(id);

        if (deleted) {
            return "redirect:/admin/students?deleted=true";
        }

        return "redirect:/admin/students?error=deletefailed";
    }
}