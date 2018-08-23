package ua.rozhkov.springdepdb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.rozhkov.springdepdb.DAO.entity.core.Specialty;
import ua.rozhkov.springdepdb.service.SpecialtyService;

@Controller
@RequestMapping("/specialty")
public class SpecialtyController {

    private SpecialtyService specialtyService;

    public SpecialtyController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @RequestMapping("/list")
    public String showListSpecialitiesPage(Model model) {
        model.addAttribute("specialities", specialtyService.findAll());
        return "specialty/listSpecialty";
    }

    @RequestMapping("/add")
    public String showAddSpecialtyPage(Model model) {
        Specialty newSpecialty = new Specialty();
        model.addAttribute("newSpecialty", newSpecialty);
        return "addSpecialty";
    }

    @RequestMapping("/addNewSpecialty")
    public String addNewSpecialty(@ModelAttribute Specialty newSpecialty) {
        specialtyService.save(newSpecialty);
        return "redirect:/specialty/list";
    }

    @RequestMapping("/edit/{id}")
    public String showEditPage(@PathVariable long id, Model model) {
        Specialty specialtyToUpdate = specialtyService.findById(id);
        model.addAttribute("specialtyToUpdate", specialtyToUpdate);
        return "editSpecialty";
    }

    @RequestMapping("/updateSpecialty")
    public String updateSpecialty(@ModelAttribute Specialty specialtyToUpdate) {
        specialtyService.save(specialtyToUpdate);
        return "redirect:/specialty/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteSpeciality(@PathVariable long id) {
        specialtyService.deleteById(id);
        return "redirect:/specialty/list";
    }

}
