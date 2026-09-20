package org.techhub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.techhub.Model.CourseModel;
import org.techhub.Service.CourseService;

@Controller
@RequestMapping("/admin/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Course Management Page
    @GetMapping
    public String courseList(Model model) {

        List<CourseModel> courses =
                courseService.getAllCourses();

        model.addAttribute("courses", courses);

        return "Admin/CourseManagement";
    }

    // Add Course Page
    @GetMapping("/add")
    public String addCoursePage(Model model) {

        model.addAttribute("course", new CourseModel());

        return "Admin/addCourse";
    }

    // Save Course
    @PostMapping("/save")
    public String saveCourse(
            @ModelAttribute("course") CourseModel course) {

        boolean saved = courseService.saveCourse(course);

        if (saved) {
            return "redirect:/admin/courses?success=true";
        }

        return "redirect:/admin/courses?error=savefailed";
    }

    // Edit Course Page
    @GetMapping("/edit/{id}")
    public String editCourse(
            @PathVariable("id") int id,
            Model model) {

        CourseModel course =
                courseService.getCourseById(id);

        if (course == null) {
            return "redirect:/admin/courses?error=notfound";
        }

        model.addAttribute("course", course);

        return "Admin/editCourse";
    }

    // Update Course
    @PostMapping("/update")
    public String updateCourse(
            @ModelAttribute("course") CourseModel course) {

        boolean updated =
                courseService.updateCourse(course);

        if (updated) {
            return "redirect:/admin/courses?updated=true";
        }

        return "redirect:/admin/courses?error=updatefailed";
    }

    // Delete Course
    @GetMapping("/delete/{id}")
    public String deleteCourse(
            @PathVariable("id") int id) {

        boolean deleted =
                courseService.deleteCourse(id);

        if (deleted) {
            return "redirect:/admin/courses?deleted=true";
        }

        return "redirect:/admin/courses?error=deletefailed";
    }
}