package org.techhub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.techhub.Model.FacultyModel;
import org.techhub.Model.LoginModel;
import org.techhub.Service.FacultyProfileService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/faculty")
public class FacultyProfileController {

    @Autowired
    private FacultyProfileService facultyProfileService;

    // ==================================================
    // Faculty Profile
    // ==================================================

    @GetMapping("/profile")
    public String profile(
            HttpSession session,
            Model model) {

        LoginModel loggedUser =
                (LoginModel) session
                        .getAttribute("loggedUser");

        if (loggedUser == null) {
            return "redirect:/loginPage";
        }

        String username =
                loggedUser.getUsername();

        FacultyModel faculty =
                facultyProfileService
                        .getFacultyByUsername(username);

        if (faculty == null) {
            return "redirect:/loginPage";
        }

        model.addAttribute(
                "faculty",
                faculty
        );

        return "Faculty/MyProfile";
    }
}