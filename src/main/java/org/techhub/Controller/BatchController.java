package org.techhub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.techhub.Model.BatchModel;
import org.techhub.Service.BatchService;

@Controller
@RequestMapping("/admin/batches")
public class BatchController {

    @Autowired
    private BatchService batchService;


    @GetMapping
    public String batchList(Model model) {

        List<BatchModel> batches =
                batchService.getAllBatches();

        model.addAttribute("batches", batches);

        return "Admin/BatchManagement";
    }


    @GetMapping("/add")
    public String addBatchPage(Model model) {

        model.addAttribute("batch", new BatchModel());

        return "Admin/addBatch";
    }

 
    @PostMapping("/save")
    public String saveBatch(
            @ModelAttribute("batch") BatchModel batch) {

        boolean saved =
                batchService.saveBatch(batch);

        if (saved) {
            return "redirect:/admin/batches?success=true";
        }

        return "redirect:/admin/batches?error=savefailed";
    }


    @GetMapping("/edit/{id}")
    public String editBatch(
            @PathVariable("id") int id,
            Model model) {

        BatchModel batch =
                batchService.getBatchById(id);

        if (batch == null) {
            return "redirect:/admin/batches?error=notfound";
        }

        model.addAttribute("batch", batch);

        return "Admin/editBatch";
    }


    @PostMapping("/update")
    public String updateBatch(
            @ModelAttribute("batch") BatchModel batch) {

        boolean updated =
                batchService.updateBatch(batch);

        if (updated) {
            return "redirect:/admin/batches?updated=true";
        }

        return "redirect:/admin/batches?error=updatefailed";
    }


    @GetMapping("/delete/{id}")
    public String deleteBatch(
            @PathVariable("id") int id) {

        boolean deleted =
                batchService.deleteBatch(id);

        if (deleted) {
            return "redirect:/admin/batches?deleted=true";
        }

        return "redirect:/admin/batches?error=deletefailed";
    }


  
}