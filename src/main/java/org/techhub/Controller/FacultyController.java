package org.techhub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.techhub.Model.FacultyModel;
import org.techhub.Service.FacultyService;

@Controller
@RequestMapping("/admin/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;


    // =========================================================
    // FACULTY LIST
    // URL: /admin/faculty
    // =========================================================
    @GetMapping
    public String facultyList(Model model) {

        List<FacultyModel> facultyList =
                facultyService.getAllFaculty();

        model.addAttribute("facultyList", facultyList);

        return "Admin/FacultyManagement";
    }


    // =========================================================
    // ADD FACULTY PAGE
    // URL: /admin/faculty/add
    // =========================================================
    @GetMapping("/add")
    public String addFacultyPage(Model model) {

        model.addAttribute(
                "faculty",
                new FacultyModel()
        );

        return "Admin/addFaculty";
    }


    // =========================================================
    // SAVE FACULTY
    // URL: /admin/faculty/save
    // =========================================================
    @PostMapping("/save")
    public String saveFaculty(
            @ModelAttribute("faculty") FacultyModel faculty,
            Model model) {

        boolean saved =
                facultyService.saveFaculty(faculty);

        if (saved) {
            return "redirect:/admin/faculty?success=true";
        }

        model.addAttribute(
                "error",
                "Unable to save faculty. Username or email may already exist."
        );

        model.addAttribute(
                "faculty",
                faculty
        );

        return "Admin/addFaculty";
    }


    // =========================================================
    // EDIT FACULTY
    // URL: /admin/faculty/edit/1
    // =========================================================
    @GetMapping("/edit/{id}")
    public String editFaculty(
            @PathVariable("id") int id,
            Model model) {

        FacultyModel faculty =
                facultyService.getFacultyById(id);

        if (faculty == null) {
            return "redirect:/admin/faculty?error=notfound";
        }

        model.addAttribute(
                "faculty",
                faculty
        );

        return "Admin/editFaculty";
    }


    // =========================================================
    // UPDATE FACULTY
    // URL: /admin/faculty/update
    // =========================================================
    @PostMapping("/update")
    public String updateFaculty(
            @ModelAttribute("faculty") FacultyModel faculty,
            Model model) {

        boolean updated =
                facultyService.updateFaculty(faculty);

        if (updated) {
            return "redirect:/admin/faculty?updated=true";
        }

        model.addAttribute(
                "error",
                "Unable to update faculty."
        );

        model.addAttribute(
                "faculty",
                faculty
        );

        return "Admin/editFaculty";
    }


    // =========================================================
    // DELETE FACULTY
    // URL: /admin/faculty/delete/1
    // =========================================================
    @GetMapping("/delete/{id}")
    public String deleteFaculty(
            @PathVariable("id") int id) {

        boolean deleted =
                facultyService.deleteFaculty(id);

        if (deleted) {
            return "redirect:/admin/faculty?deleted=true";
        }

        return "redirect:/admin/faculty?error=deletefailed";
    }
    
}