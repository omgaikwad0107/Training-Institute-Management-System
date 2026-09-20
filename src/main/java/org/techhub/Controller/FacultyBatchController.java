package org.techhub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.techhub.Model.BatchModel;
import org.techhub.Model.LoginModel;
import org.techhub.Service.FacultyBatchService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/faculty")
public class FacultyBatchController {

    @Autowired
    private FacultyBatchService facultyBatchService;


    // =====================================================
    // MY BATCHES
    // =====================================================

    @GetMapping("/batches")
    public String myBatches(
            HttpSession session,
            Model model) {

        LoginModel loggedUser =
                (LoginModel) session.getAttribute("loggedUser");

        if (loggedUser == null) {
            return "redirect:/loginPage";
        }

        String username = loggedUser.getUsername();

        List<BatchModel> batchList =
                facultyBatchService
                .getBatchesByFacultyUsername(username);

        int totalBatches =
                facultyBatchService
                .getTotalBatchesByFacultyUsername(username);

        model.addAttribute("batchList", batchList);
        model.addAttribute("totalBatches", totalBatches);

        return "Faculty/MyBatches";
    }

}